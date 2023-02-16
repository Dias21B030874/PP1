import os
path = os.path.join('C:/Users/home/OneDrive/Рабочий стол/Lab6/', 'input.txt')
if os.access("input.txt", os.R_OK):
    os.remove(path)

