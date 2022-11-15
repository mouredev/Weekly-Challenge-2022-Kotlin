import math

def moveRobot(steps=[]):
    # Initial position [x, y]
    pos = [0, 0]
    # Heading direction. Starting facing north.
    dir = (math.pi/2)
    
    for s in steps:
        pos[0] += int( math.cos(dir) * s )
        pos[1] += int( math.sin(dir) * s )
        dir += (math.pi/2)
    
    return pos

if __name__=='__main__':
    steps = [-8, 4, 3, -1]
    finalPos = moveRobot(steps)
    print(finalPos)
