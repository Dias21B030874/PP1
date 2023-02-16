l = ['Almaty','Astana','Nur-Sultan']
with open('input1.txt', 'w') as f:
    for items in l:
        f.write('%s\n' %items)
    f.close()