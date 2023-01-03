//Hola no supe a que archivo hacer commit, espero sirva de algo.


function moveRobot(steps){
  let position = [0, 0]
  let currentQuadrant = 1
  let currentPosition = 1
  steps.forEach(function(step) {
    position[currentPosition] += operate(step, currentQuadrant)
    currentPosition = currentPosition == 1 ? 0 : 1
    currentQuadrant = setQuadrant(currentQuadrant)
  });
  return position
}

function operate(step, quadrant){
        return (quadrant == 1 || quadrant == 4) ? step : (step * -1)
}

function setQuadrant(quadrant){
  return (quadrant >= 4) ? 1 : quadrant + 1
}

//let position = moveRobot([1, 1, 1, 1])
let position = moveRobot([10, 5, -2])
console.log(position)
