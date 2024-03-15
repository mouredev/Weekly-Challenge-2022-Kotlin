# Dado un listado de números, encuentra el SEGUNDO más grande.

def segundo(array) -> int:
    flag = 0
    temp_flag = 1
    if len(array) == 1:
        return 0
    elif len(array) == 0:
        return 0
    for item in array:
        if item > temp_flag:
            flag = temp_flag
            temp_flag = item
        elif item < temp_flag and item > flag:
            flag = item
    return flag

if __name__ == '__main__':
    print(segundo([154, 0, 900, 9, 1, 160, 2 ,3]))
    print(segundo([]))
    print(segundo([3]))
    print(segundo([0, 192, 154, 170, 4, 180, 190, 2, 300]))
