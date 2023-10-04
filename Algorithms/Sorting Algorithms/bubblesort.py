def bubblesort(array):
  n = len(array)
  for i in range(n):
    for j in range(n-i-1):
      if array[j + 1] < array[j]:
        array[j + 1],array[j] = array[j],array[j + 1]
  return None
