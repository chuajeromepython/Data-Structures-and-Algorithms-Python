def round_to_nearest_nth(n,nth=0):
	return round(n,nth)
	
def get_mean(data):
	total = 0
	N = len(data)
	for dp in data:
		total += dp
	return total / N
	
def get_mode(data):
	freq_table = {}
	for dp in data:
		if dp in freq_table:
			freq_table[dp] += 1
		else:
			freq_table[dp] = 1
	if sum(freq_table.values()) == len(freq_table.keys()):
		return 'No mode'
	freq_table_paired = [[k,freq_table[k]] for k in freq_table]
	def sort_reverse():
		for i in range(len(freq_table_paired)):
			for j in range(len(freq_table_paired)-i-1):
				if freq_table_paired[j+1][-1] > freq_table_paired[j][-1]:
					freq_table_paired[j+1],freq_table_paired[j] = freq_table_paired[j],freq_table_paired[j+1]
	sort_reverse()
	mode = []
	curr_val, max_val = 0,0
	for p1,p2 in freq_table_paired:
		curr_val = p2
		if curr_val >= max_val:
			max_val = curr_val
			mode.append(p1)
	return mode

def get_median(data):
	mid = len(data)//2
	sorted_data = list(data)
	sorted_data.sort()
	if len(sorted_data) % 2 == 0:
		return (sorted_data[mid] + sorted_data[mid-1]) / 2
	return sorted_data[mid]

def get_weighted_mean(data,weights):
	assert len(data) == len(weights), 'Invalid data and weights'
	s_d_w, s_w = 0, 0
	for i in range(max(len(data),len(weights))):
		s_d_w += data[i] * weights[i]
		s_w += weights[i]
	return s_d_w / s_w

def get_variance(data,is_sample=False):
	mean = get_mean(data)
	var = sum((v - mean) ** 2 for v in data) / (len(data) - (1 if is_sample else 0))
	return var

def get_std(data,is_sample=False):
	return get_variance(data,is_sample=True)**0.5

print(get_mean([5,4,3,2,1]))
print(get_mode([5,4,3,2,1]))
print(get_median([5,4,3,2,1,0]))
print(get_weighted_mean([5,4,3,2,1],[0,6,28,10,6]))
print(get_variance([0,1,5,7,9,10,14],is_sample=True))
test = get_std([0,1,5,7,9,10,14],is_sample=True)
print(round_to_nearest_nth(test,2)) #hundredths
