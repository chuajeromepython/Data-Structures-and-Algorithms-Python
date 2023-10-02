def get_nearest_mid(array,low,high,target):
    mid = low + ((high - low) / (array[high] - array[low])) * (target - array[low])
    return int(mid)
    
def interpolation_search(array,target):
    low = 0
    high = len(array) - 1
    while low <= high:
        mid = get_nearest_mid(array,low,high,target)
        if mid > high or mid < low:
            return None
        if array[mid] == target:
            return True    
        elif array[mid] < target:
            low = mid + 1
        else:
            high = mid - 1
    return False        
            
# sample use 
list1 = [4,60,75,100,120,230,250]
for i in list1:
    print(interpolation_search(list1,i)) # returns True for each i
