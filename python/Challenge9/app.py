import json
import re

with open('Challenge9/morse.json') as f:
    MORSE = json.load(f)

def verification_morse(mors):
    x = re.search("[^\-\.\s]", mors)
    return True if x is None else False

def transalate_to_morse(sen):
    sen = sen.upper()
    for x, y in MORSE.items():
        sen = sen.replace(x, f' {y} ')
    sen = sen.replace('  ', ' ').replace('   ', '  ').strip()
    return sen

def translate_to_sentence(mor):
    mor = ' ' + mor.replace(' ', '  ') + ' '
    for x, y in MORSE.items():
        if x == '.':
            continue
        mor = mor.replace(f' {y} ', x)
    mor = mor.replace(' .-.-.- ', '.').replace('  ', ' ')
    return mor.lower()

if __name__ == '__main__':
    question = "1. To morse code\n2. To sentence\nWhat do you want? "
    ques = input(question)
    assert ques == '1' or ques == '2', 'Enter only "1" or "2"'
    sen = input('Enter sentence: ')
    if ques == '1':
        res = transalate_to_morse(sen)
    else:
        assert verification_morse(sen), 'Morse code in only "." and "-"'
        res = translate_to_sentence(sen)
    print(res)
