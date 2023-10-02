def binary_search_iterative(array,target):
    low = 0
    high = len(array) - 1
    while low <= high:
        mid = (low + high) // 2
        if array[mid] == target:
            return True
        elif array[mid] < target:
            low = mid + 1
        else:
            high = mid - 1
    return False
# sample use
array = [1,2,3,4,5,6,7]
print(binary_search_iterative(array,7)) # returns True
print(binary_search_iterative(array,0)) # returns False
print(binary_search_iterative(array,9)) # returns False
