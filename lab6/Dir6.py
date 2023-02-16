import string
for letter in string.ascii_lowercase:
    with open('{}.txt'.format(letter), 'w') as f:
        f.write(letter)