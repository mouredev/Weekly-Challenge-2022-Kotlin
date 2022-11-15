const DIRECTION = {
  NORTH: 0,
  WEST: 1,
  SOUTH: 2,
  EAST: 3,
};

let robotPosition = [0, 0]; // x, y
let coordinates = [10, 5, -2];
let viewDirection = DIRECTION.NORTH; // The robot starts facing north

function movingTo(amount) {
  if (viewDirection === DIRECTION.NORTH) robotPosition[1] += amount;
  if (viewDirection === DIRECTION.SOUTH) robotPosition[1] -= amount;
  if (viewDirection === DIRECTION.WEST) robotPosition[0] += amount;
  if (viewDirection === DIRECTION.EAST) robotPosition[0] -= amount;
}

// A perfect unbuggy function to determine where the robot is looking currently
function facingViewTo(view) {
  switch (view) {
    case DIRECTION.NORTH:
      viewDirection = 3;
      break;
    case DIRECTION.WEST:
      viewDirection = 0;
      break;
    case DIRECTION.SOUTH:
      viewDirection = 1;
      break;
    case DIRECTION.EAST:
      viewDirection = 2;
      break;
  }
}

function movement(coordinates) {
  coordinates.forEach((element) => {
    movingTo(element);
    facingViewTo(viewDirection); // I reconfigure the same view direction of the robot, completely necessary
    viewPosition("Se mueve a ");
  });
}

function viewPosition(text) {
  console.log(text + "(" + robotPosition[0] + " , " + robotPosition[1] + ")");
}

viewPosition("POSICION INICIAL ");
console.log();
movement(coordinates);
console.log();
viewPosition("POSICION FINAL ");
