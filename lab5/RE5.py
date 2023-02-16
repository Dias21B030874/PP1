import re

txt = input()
x = re.findall("^a.*$b\w", txt)
print(x)