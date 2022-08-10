const numbers = [1,10,23,4,5,7]

const findLargest = (array, depth) => {
  const largest = Math.max(...array)
  
  const newArray = array.filter(number => number !== largest)
  if(depth <= 1) return largest
  return findLargest(newArray, depth - 1)
}

console.log(findLargest(numbers,2))
