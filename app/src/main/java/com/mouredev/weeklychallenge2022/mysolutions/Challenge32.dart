void main() {
  List<double> numberList1 = [-5, -2.1, 0, -10, -0.1];
  List<double> numberList2 = [0, 1.5, 8, 8, 12, 12, 4.5, -1.1];

  secondLargest(numberList1);
  secondLargest(numberList2);

  secondLargestWithoutSort(numberList1);
  secondLargestWithoutSort(numberList2);
}

// solution
void secondLargest(List<double> numberList) {
  // delete duplicates
  numberList = numberList.toSet().toList();

  numberList.sort((n1, n2) => n2.compareTo(n1));
  print(numberList[1]);
}

// other solution
void secondLargestWithoutSort(List<double> numberList) {
  double largestNumber = -double.infinity;
  double secondNumber = -double.infinity;

  numberList.forEach((nextNumber) {
    if (nextNumber > largestNumber) {
      secondNumber = largestNumber;
      largestNumber = nextNumber;
    } else if (nextNumber < largestNumber && nextNumber > secondNumber) {
      secondNumber = nextNumber;
    }
  });

  print(secondNumber);
}
