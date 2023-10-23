def euclid_gcd(m,n):
  while n:
    m, n = n, m % n
  return m
