// Part A
function delayedResult(n1, n2, delayTime, callback) {

	const sum = n1 + n2; 

    setTimeout(function() {
        callback(sum);
    }, delayTime);
}


delayedResult(4, 5, 3000, function (result) {
	console.log(result);
}); // 9 (4+5) will be shown in the console after 3 seconds
delayedResult(-5, 10, 2000, function (result) {
	console.log(result);
}); // 5 (-5+10) will be shown in the console after 2 seconds




// Part B
function delayedResultPromise(n1, n2, delayTime) {
	
	const sum = n1 + n2;

	return new Promise((resolve, reject) => {
		setTimeout(function() {
			resolve(sum);
		}, delayTime);
		
	});

}


delayedResultPromise(4, 5, 3000).then(console.log);
// 9 (4+5) will be shown in the console after 3 seconds




// Part C
async function main() {

	const result = await delayedResultPromise(4, 5, 3000);
	console.log(result)

}


main(); // result will be shown in the console after <delayTime> seconds