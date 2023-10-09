def binary_search_iterative(array,target):
    if len(array) == 0: 
        # return False if array is empty
        return False
    if len(array) == 1 and array[0] == target: 
        # if array contains only one item, check if that item is equal to the target
        return True
    low = 0 # set the lower bound
    high = len(array) - 1 # set the upper bound
    while low <= high: # return False if low exceeds high
        mid = (low + high) // 2 # determine the middle item
        if array[mid] == target:
            return True # return True if the middle item is equal to target 
        elif array[mid] < target:
            low = mid + 1 # if the middle item is less than target, cut discard the left part of array
        else:
            high = mid - 1 # otherwise, discard the right side
    return False

# sample use
array = [1,2,3,4,5,6,7]
print(binary_search_iterative(array,7)) # returns True
print(binary_search_iterative(array,0)) # returns False
print(binary_search_iterative(array,9)) # returns False
print(binary_search_iterative([9],9)) # returns True
print(binary_search_iterative([],100)) # returns False
