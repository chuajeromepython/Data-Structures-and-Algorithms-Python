def convert_to_binary(decimal):
	if decimal == 0:
		return '0'
	binary = ''
	while decimal > 0:
		r = decimal % 2
		binary = str(r) + binary
		decimal //= 2
	return binary

def convert_to_decimal(binary):
	if binary == '0':
		return 0
	decimal = 0
	for i in range(len(binary)):
		if binary[-i-1] == '1':
			decimal += 2**i
	return decimal
