def selection_sort(array):
    for i in range(len(array)):
        low = i
        for j in range(i+1,len(array)):
            if array[j] < array[low]:
                low = j
        array[low],array[i] = array[i],array[low]
    return array
    
print(selection_sort([5,1,4,2,3,10,6,9,7,8]))
