def MovingRobot(steps):
  x = 0
  y = 0
  direction = 0

  for step in steps:
    if direction == 0:
      y += step
    elif direction == 1:
      x -= step
    elif direction ==2:
      y -= step
    else:
      x += step

    direction = (direction + 1) % 4

  print "Posicion final: ({}, {})".format(x, y)


MovingRobot([10, 5, -2])
MovingRobot([2, 5, -3, -8, 2, 0, 2, 1, 4])