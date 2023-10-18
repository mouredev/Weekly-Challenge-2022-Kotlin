#include <iostream>

template<typename T, size_t n>
void print_array(T const(& arr)[n])
{
    if (n > 0)
    {
        std::cout << '[';
        for (size_t i = 0; i < n; i++) {
            std::cout << arr[i] << ((i != n - 1) ? ", " : "");
        }
        std::cout << ']' << std::endl;  
    }
}