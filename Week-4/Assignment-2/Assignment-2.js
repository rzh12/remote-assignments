function ajax(src, callback) {

    const xhr = new XMLHttpRequest();
    
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            callback(xhr.responseText);
        }
    };
    
    xhr.open('GET', src);
    xhr.send();
}

function render(data) {
	const products = JSON.parse(data);

  	for (let i = 0; i < products.length; i++) {
	    const product = products[i];
	    const productDiv = document.createElement('div');
	    productDiv.innerHTML = `
	      <div>Name: ${product.name}</div>
	      <div>Price: ${product.price}</div>
	      <div>Description: ${product.description}</div><br/>
	    `;
		document.getElementById('container').appendChild(productDiv);
	}
}


ajax(
'https://remote-assignment.s3.ap-northeast-1.amazonaws.com/products',
function (response) {
render(response);
}
); // you should get product information in JSON format and render data in the page