import re

txt = input()
temp = txt.split('_')
res = temp[0] + ''.join(i.title() for i in temp[1:])
print(str(res)) 
