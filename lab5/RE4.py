import re

txt = input()
x = re.findall("[A-Z]{1}\S+[a-z]", txt)
print(x)