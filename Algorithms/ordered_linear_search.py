def ordered_linear_search(array,target):
	for item in array: # <- iterates through array
		if item == target: # <- return True if found
			return True
		if item > target: # <- returns false when the item being inspected becomes larger than the target
		# the target hence cannot be contained in any slot to the right since the array is sorted in ascending order
			return False
	return False

# sample use
array = [1,2,3,5,6,7,8,9,10]
print(ordered_linear_search(array,5))
print(ordered_linear_search(array,4))
print(ordered_linear_search(array,11))
