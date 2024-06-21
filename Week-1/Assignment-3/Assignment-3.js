function countAandB(input) {

    let count = 0;
    
    for (let char of input) {
        // Check if the character is 'a' or 'b'
        if (char === 'a' || char === 'b') {
            count++;
        }
    }
    return count;
}

function toNumber(input) {

    let numbers = [];
    
    for (let char of input) {
        // Map the character to its corresponding number
        switch (char) {
            case 'a':
                numbers.push(1);
                break;
            case 'b':
                numbers.push(2);
                break;
            case 'c':
                numbers.push(3);
                break;
            case 'd':
                numbers.push(4);
                break;
            case 'e':
                numbers.push(5);
                break;
        }
    }
    return numbers;
}

let input1 = ['a', 'b', 'c', 'a', 'c', 'a', 'c'];
console.log(countAandB(input1)); // should print 4 (3 ‘a’ letters and 1 ‘b’ letter)
console.log(toNumber(input1)); // should print [1, 2, 3, 1, 3, 1, 3]

let input2 = ['e', 'd', 'c', 'd', 'e'];
console.log(countAandB(input2)); // should print 0
console.log(toNumber(input2)); // should print [5, 4, 3, 4, 5]