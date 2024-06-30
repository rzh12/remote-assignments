function count(input) {
    let counts = {};

    for (let i = 0; i < input.length; i++) {
        let char = input[i];
        if ( counts[char] > 0 ) {
            counts[char]++;
        } else {
            counts[char] = 1;
        }
    }
    
    return counts;
}

let input1 = ["a", "b", "c", "a", "c", "a", "x"];
console.log(count(input1));
// should print {a:3, b:1, c:2, x:1}



function groupByKey(input) {
    let group_value = {};

    for ( let i = 0; i < input.length; i++ ) {
        let key = input[i].key;
        let value = input[i].value;
        if ( group_value[key] > 0 ) {
            group_value[key] += value;
        } else {
            group_value[key] = value;
        }
    }

    return group_value;
}

let input2 = [
{ key: "a", value: 3 },
{ key: "b", value: 1 },
{ key: "c", value: 2 },
{ key: "a", value: 3 },
{ key: "c", value: 5 },
];
console.log(groupByKey(input2));
// should print {a:6, b:1, c:7}