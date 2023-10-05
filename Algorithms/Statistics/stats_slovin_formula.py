def sample_size(N,e):
	# slovin's formula: N / 1 + Ne^2
	sample_size = N / (1 + N * (e ** 2))
	return round(sample_size)

def percentage(population,N):
  """
	Using localcontext().prec will allow accurate readings of floating point numbers
	for this function only.
	Percentage is calculated by dividing each element in population by N
	"""
	from decimal import Decimal,localcontext
	with localcontext() as ctx: # setting precision using a context managaer
		ctx.prec = 2 # set precision to 2 or 0.00
		percentage = []
		for p in population:
			P = float(Decimal(p)/Decimal(N)) # P is forced to calculate p / N with only two decimal places
			percentage.append(P)
	return percentage # all items in this list should equal to 1.0 or 100 when summed

def get_sample_size(f1,f2,pop,N,e):
	"""
	f1 and f2 are functions sample_size and percentage. We call them with appropriate parameters
	in this function.
	""" 
	sample_size = f1(N,e)
	percentage = f2(pop,N)
	final_sample_size = []
	for p,p_cnt in zip(percentage,pop):
		 # calculate final sample size by multiplying each element in percentage by sample_size (obtained using slovin's formula)
		final_sample_size.append((p_cnt,round(p * sample_size)))
	return final_sample_size # when all the second item in each tupled are summed, it should equal to sample_size
  
# sample use
population = [800,400,500,600,700]
N = sum(population)
e = 0.05
"""
e or "margin of error" can be 0.01, 0.05, or 0.10 percent.
Choosing e depends on the researcher's circumstances. 0.05 seems to be the sweetspot.
"""
#print(get_sample_size(sample_size,percentage,population,N,e))
"""
returns [(800, 95), (400, 46), (500, 60), (600, 71), (700, 81)], where
the first item in each tuple represents the population and the second the right amount of sample to be
taken from that population.
"""
print(f'Population {"Sample size":>20}')
for i,j in get_sample_size(sample_size,percentage,population,N,e):
	print(f'{i} {j:>18}')
