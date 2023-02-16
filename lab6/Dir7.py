with open('input.txt','r') as f1, open('input1.txt','a') as f2:
    for line in f1:
             f2.write(line)