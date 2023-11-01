import matplotlib.pyplot as plt
import random

def t1(p):
    x,y = p[0],p[1]
    x_i = 0.85*x + 0.04*y
    y_i = -0.04*x + 0.85*y + 1.6
    return x_i,y_i
 
def t2(p):
    x,y = p[0],p[1]
    x_i = 0.2*x - 0.26*y
    y_i = 0.23*x + 0.22*y + 1.6
    return x_i,y_i
    
def t3(p):
    x,y = p[0],p[1]
    x_i = -0.15*x + 0.28*y
    y_i = 0.26*x + 0.24*y + 0.
    return x_i,y_i

def t4(p):
    x,y = p[0],p[1]
    x_i = 0
    y_i = 0.16 * y
    return x_i,y_i
    
 
def get_index(probability):
    r = random.random()
    c_probability = 0
    sum_of_prob = []
    for p in probability:
        c_probability += p
        sum_of_prob.append(c_probability)
    for item, sp in enumerate(sum_of_prob):
        if r <= sp:
            return item
    return len(probability) - 1

def transform(p):
        transformations = [t1,t2,t3,t4]
        probability = [0.85,0.07,0.07,0.01]
        tindex = get_index(probability)
        t = transformations[tindex]
        x,y = t(p)
        return x,y
        
def draw_fern(n):
    x = [0]
    y = [0]
    x1,y1 = 0,0
    for i in range(n):
        x1,y1 = transform((x1,y1))
        x.append(x1)
        y.append(y1)
    return x,y

n = 100000  
plt.style.use('classic')              
fig,ax = plt.subplots()
x,y = draw_fern(n)
ax.scatter(x,y,s=10,alpha=0.20,edgecolor='black',c='green')
ax.set_title(f'Barnsley Fern with {n} steps')
ax.set_xlabel(r'$x$ - axis',size=30)
ax.set_ylabel(r'$y$ - axis',size=30)
plt.show()
