#include <iostream>
#include <cmath>

using namespace std;

double convert(int num, int from, int to) {
    
    if ((from < 2) || from > 10) {
        return 0;
    }

    if ((to < 2) || to > 10) {
        return 0;
    }

    if (from == to) {
        return from;
    }

    double sum = 0;
    int i = 0;
    while (num > 0) {
        int temp = num % to;
        num /= to;
        if(temp >= from) {
            return 0;
        }

        sum += temp * pow(from, i);
        i++;
    }
    
    return sum;
}

int main() {
    int nums[] = {10, 111, 1011, 110110, 100100, 1110111};
    for (int i = 0; i < sizeof(nums) / sizeof(int); i++) {
        double result = convert(nums[i], 2, 10);
        cout<<"El número "<<nums[i]<<"[2] equivale a "<<result<<"[10]"<<endl;
    }
}