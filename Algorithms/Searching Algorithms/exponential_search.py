def binary_search(array,low,high,target):
    if low > high:
        return False
    mid = (low + high) // 2
    if array[mid] == target:
        return True
    elif array[mid] < target:
        return binary_search(array,mid+1,high,target)
    else:
        return binary_search(array,low,high-1,target)
    
def exponential_search(array,target):
    if array[0] == target:
        return True
    idx = 1
    while idx < len(array) and array[idx] < target:
        idx *= 2
    return binary_search(array,idx//2,min(idx,len(array)-1),target) 
        

array = [1,2,3,4,5,6]
for i in array:
    print(exponential_search(array,i)) # returns True for all items
    
print(exponential_search(array,0)) # False
print(exponential_search(array,10)) # False
