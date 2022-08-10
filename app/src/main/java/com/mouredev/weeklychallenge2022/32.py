#
# Dado un listado de números, encuentra el SEGUNDO más grande.
#

import random
import sys

# Create a list of random numbers
def create_list(lenght: int) -> list:
    return_list = []
    for number in range(lenght):
        return_list.append(random.randint(0, 100))
    return return_list


def second_highest(my_unique_list: list) -> int:
    return sorted(my_unique_list)[-2]


if __name__ == "__main__":
    if len(sys.argv) == 2 and sys.argv[1].isdigit():
        lenght = sys.argv[1]
    else:
        lenght = 10  # Default lenght, this can be changed
    my_list = create_list(int(lenght))
    print(my_list)
    # We don't need duplicates in the list, so we remove them
    my_unique_list = list(set(my_list))
    print(second_highest(my_unique_list))
