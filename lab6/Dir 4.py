import os
file = open('input.txt', 'r').read().split("\n")
Cnt = 0
for i in file:
    if i:
        Cnt += 1
print(Cnt)
