for i in range(1, 101):
  if i%5 == 0 and i%3==0:
    print(i, "FIZZ BUZZ")
  elif i%3==0:
    print(i, "FIZZ")
  elif i%5 == 0:
    print(i, "BUZZ")
  else:
    print(i)