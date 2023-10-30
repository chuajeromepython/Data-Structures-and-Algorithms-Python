def get_nth_position(m,n):
	if n <= 0:
		return 'n can\'t be equal or less than 0'
	power = 0
	for i in str(n):
		if i == '0':
			power += 1
	if (power + 1) > len(str(m)):
		return 'n exceeded the largest place in m'
	return (m // (10 ** power)) % 10
