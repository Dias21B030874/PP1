import re

txt = input()
x = re.findall("[a-z]\S*_\S*[a-z]", txt)
print(x)