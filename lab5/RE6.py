import re  

txt = input() 
replace = ":"
pattern = "[ ,.]"
print(re.sub(pattern, replace, txt))