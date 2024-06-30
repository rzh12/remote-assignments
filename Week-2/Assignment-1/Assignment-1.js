
function max(numbers) {
  // Empty array case
  if (numbers.length === 0) {
    return undefined;
  }
  
  let maxValue = numbers[0];
  for ( let i = 1; i < numbers.length; i++ ) {
    if ( numbers[i] > maxValue ) {
      maxValue = numbers[i];
    }
  }
  return maxValue;
}


function findPosition(numbers, target) {
  for ( let i = 0; i < numbers.length; i++ ) {
    if ( numbers[i] === target ) {
      return i;
    }
  }
  return -1; // Return -1 if the target is not found
}


console.log(max([1, 2, 4, 5])); // should print 5
console.log(max([5, 2, 7, 1, 6])); // should print 7
console.log(findPosition([5, 2, 7, 1, 6], 5)); // should print 0
console.log(findPosition([5, 2, 7, 1, 6], 7)); // should print 2
console.log(findPosition([5, 2, 7, 7, 7, 1, 6], 7)); // should print 2 (the first position)
console.log(findPosition([5, 2, 7, 1, 6], 8)); // should print -1