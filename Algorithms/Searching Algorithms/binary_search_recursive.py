def binary_search_recursive(array,low,high,target):
    if low > high:
        return False
    mid = (low + high) // 2
    if array[mid] == target:
        return True
    elif array[mid] < target:
        return binary_search_recursive(array,mid+1,high,target) 
    else:
        return binary_search_recursive(array,low,mid-1,target)       
    
# sample use
array = [1,2,3,4,5,6,7]
low = 0
high = len(array) - 1
print(binary_search_recursive(array,low,high,7)) # returns True
print(binary_search_recursive(array,low,high,0)) # returns False
print(binary_search_recursive(array,low,high,9)) # returns False
