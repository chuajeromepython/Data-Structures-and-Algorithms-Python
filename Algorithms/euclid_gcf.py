def euclid_algorithm(m,n):
  while n:
    m,n = n,m%n
  return m
