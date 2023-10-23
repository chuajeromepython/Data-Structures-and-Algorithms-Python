def sieve(n):
    primes_bool = [True] * (n + 1)
    primes_bool[0] = primes_bool[1] = False
    for p in range(2,int(n**0.5)+1):
        if primes_bool[p]:
            """
            for i in range(p*p,n+1,p):
                primes_bool[i] = False
            """
            i = p*p
            while i < (n + 1):
                primes_bool[i] = False
                i += p              
    primes = [prime for prime in range(2,n+1) if primes_bool[prime]]
    return primes
    
print(sieve(100))
