List<int> numberList = new List<int>(){
    5, 8, 10, 4, 2, 45, 35, 11, 100, 25
};

int largest = 0;
int secondLargest = 0;

foreach (var number in numberList){
    if(number > largest){
        secondLargest = largest;
        largest = number;
    }else if(number > secondLargest){
        secondLargest = number;
    }
    //Console.WriteLine(number);
}

Console.WriteLine("El segundo numero mayor es: {0}", secondLargest);