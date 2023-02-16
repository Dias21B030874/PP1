from time import sleep
import math
def delay(fn, ms, n):
  sleep(ms / 1000)
  return fn(n)
n = int(input())
ms = int(input())
print("Square root after specific miliseconds:") 
print(delay(lambda x: math.sqrt(x), ms, n))