def ordered_linear_search(array,target):
  # ordered_linear_search acts as a helper function here
	for item in array: # <- iterates through array
		if item == target: # <- return True if found
			return True
		if item > target: # <- returns false when the item being inspected becomes larger than the target
		# the target hence cannot be contained in any slot to the right since the array is sorted in ascending order
			return False
	return False

def jumpsearch(array,target):
  """
  An enhanced version of ordered linear search where the array is divided into blocks
  obtained by taking the square root of n where n is the size of array. The last item
  in each block is compared with the target. If block[-1] is equal to the target, return True.
  If block[-1] is less than target, the adjacent blocks are searched, and finally, when block[-1]
  is greater than, the target must be somewhere within the current block. The block is searched 
  using ordered linear search.
	"""
  n = len(array)
	m = int(n**0.5) # <- determines block size
	i = 0 # <- determines the lower bound of each block
	while i < n: # <- terminates when i exceeds the size of array
		m_block = array[i:i+m] # <- slices the array into a block
		if m_block[-1] == target: # <- returns True if the last item of this block is the target
			return True
		elif m_block[-1] > target: # <- performs ordered_linear_search on this block
		# if the last item is greater than the target
			return ordered_linear_search(m_block,target) # returns True if target is in this block, False otherwise
    else:
			i += m # <- increment i by m, move to the next block since m_block[-1] is less than target
	return False # <- returns False if i becomes greater or equal to n

# sample use
array = [1,2,3,5,6,7,8,9,10]
t1 = 7
t2 = 2
t3 = 4
t4 = 11
print(jumpsearch(array,t1))
# t1 is the last item of block 2, m_block[-1] == target evaluates to True, returns True
print(jumpsearch(array,t2))
# t2 is contained in block 1, m_block[-1] > target evaluetes to True, ordered_linear_search is called and returns True
print(jumpsearch(array,t3))
# t3 should appear somewhere in block 2, ordered_linear_search is called and return False since t3 is not contained in block 2
print(jumpsearch(array,t4))
# since max(array) is less than t4, i keeps incrementing by 3 until i < n evaluates to False, returns False
