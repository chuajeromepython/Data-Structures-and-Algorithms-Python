def unordered_linear_search(array,target):
  for item in array: # <- iterates through the array 
    if item == target:
      return True # <- returns true if item is equal to target
	return False # <- returns false if the loop terminates without reaching the return statement
      
# sample use
array = [5,1,4,2,3]
print(unordered_linear_search(array,4)) # target found at index 2, returns True
print(unordered_linear_search(array,6)) # target not found, returns False
print(unordered_linear_search(array,0)) # likewise
