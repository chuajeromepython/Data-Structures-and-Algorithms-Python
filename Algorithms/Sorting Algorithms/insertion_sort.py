def insertion_sort(array):
    for i in range(1,len(array)):
        key = array[i]
        j = i - 1
        while j >= 0 and key < array[j]:
            array[j + 1] = array[j]
            j -= 1
        array[j + 1] = key
    return array
    
print(insertion_sort([5,1,4,2,3,10,6,9,7,8]))
