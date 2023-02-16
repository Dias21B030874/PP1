import re

txt = input()
res = [txt[0].lower()]
for c in txt[1:]:
        if c in ('ABCDEFGHIJKLMNOPQRSTUVWXYZ'):
            res.append('_')
            res.append(c.lower())
        else:
            res.append(c)     
print(''.join(res))