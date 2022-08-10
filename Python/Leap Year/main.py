def leap_year(year) -> int:
    times = 30
    missing_years = year % 4
    if missing_years != 0:
        missing_years = 4 - missing_years
        year += missing_years
        print(year)
        times -= 1
    for i in range(times):
        year += 4
        print(year)

if __name__ == '__main__':
    leap_year(2011)
    leap_year(2025)
    leap_year(2026)