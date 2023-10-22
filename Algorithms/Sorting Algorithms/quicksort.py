def quicksort(array):
    temp = list(array)
    if not temp:
        return temp
    pivot = temp.pop(len(temp)//2)
    left,right = [],[]
    for item in temp:
        if item <= pivot:
            left.append(item)
        else:
            right.append(item)
    return quicksort(left) + [pivot] + quicksort(right)
    
p = [5,1,4,2,3,10,6,9,7,8,9]
print(quicksort(p))
