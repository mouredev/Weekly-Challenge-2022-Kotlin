const integersArray = [1,2,3,5,7,11,13,17,19];

function findLostNumbers(sourceArray) {
    const resultArray = []
    const arrayLength = sourceArray.length
    const min = sourceArray[0]
    const max = sourceArray[arrayLength - 1]

    validateInputArray(sourceArray)
      
    for(let i = min; i<max; i++) {
        if (!sourceArray.includes(i)) {
            resultArray.push(i)
        }
    }

    return resultArray
}

function validateInputArray(sourceArray) {
    for(let i = 0; i < sourceArray.length - 1 ; i++) {
        if (sourceArray[i] >= sourceArray[i+1]) {
            throw new Error("Invalid input. Array must contain only ordered unrepeated integers.")
        }
    }
}

var lostNumbers = findLostNumbers(integersArray);
console.log(lostNumbers)
