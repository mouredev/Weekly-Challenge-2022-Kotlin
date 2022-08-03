void main() {
  nextLeapYears(294);
}

void nextLeapYears(int nextLeapYear) {
  List<int> leapYearsList = [];
  while (leapYearsList.length < 30) {
    nextLeapYear = nextLeapYear + 4 - nextLeapYear % 4;
    if (nextLeapYear % 100 != 0 || nextLeapYear % 400 == 0) leapYearsList.add(nextLeapYear);
  }
  print(leapYearsList);
}
