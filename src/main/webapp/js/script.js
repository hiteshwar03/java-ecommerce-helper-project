function addToProduct(pid, pname, price) {
    let cart = localStorage.getItem("cart");
    let cartObj = cart ? JSON.parse(cart) : []; // Initialize cartObj as an empty array if cart is null

    // Check if the product already exists in the cart
    let existingProduct = cartObj.find(item => item.productId === pid);
	console.log(typeof existingProduct)

	if (existingProduct) {
	     // Increase quantity if the product already exists
	     existingProduct.productQuantity += 1;
	     showToast(`${existingProduct.productName} quantity increased ${existingProduct.productQuantity}`);
	     console.log("Product quantity increased");
	 } else {
	     // Add new product to cart
	     let newProduct = { productId: pid, productName: pname, productQuantity: 1, productPrice: price };
	     cartObj.push(newProduct);
	     showToast("Product added");
	     console.log("Product added");
	 }

    // Update the cart in local storage
    localStorage.setItem("cart", JSON.stringify(cartObj));

    // Update the cart display
    updateCart();
}

function updateCart() {
	let cartString = localStorage.getItem("cart");
	let cartObj = cartString ? JSON.parse(cartString) : []; // Initialize cartObj as an empty array if cartString is null

	if (cartObj.length === 0) {
		console.log("Cart is empty");
		$(".cart-body").html("<h3>Empty cart... Please add items to your cart</h3>");
		$(".checkout-btn").addClass('disabled');
	} else {
		console.log(cartObj);
		let table = `
        <table border="1">
            <thead>
                <tr>
                    <th>Product</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Action</th> <!-- Added for Remove button -->
                </tr>
            </thead>
            <tbody>
        `;

		let totalPrice = 0;
		cartObj.forEach(item => {
			table += `
            <tr>
                <td>${item.productName}</td>
                <td>${item.productPrice}</td>
                <td>${item.productQuantity}</td>
                <td>${item.productQuantity * item.productPrice}</td>
                <td><button onclick="deleteItemFromCart(${item.productId})">Remove</button></td>
            </tr>
            `;
			totalPrice += item.productPrice * item.productQuantity;
		});

		table += `
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="3">Total</td>
                    <td>${totalPrice}</td>
                </tr>
            </tfoot>
        </table>
        `;

		$(".cart-body").html(table);
		$(".checkout-btn").removeClass('disabled');
	}

	// Update cart length display
	$(".cart-items").html(`(${cartObj.length})`);
}

function deleteItemFromCart(pid) {
	let cart = localStorage.getItem("cart");
	let cartObj = cart ? JSON.parse(cart) : [];

	// Filter out the product to remove
	cartObj = cartObj.filter(item => item.productId !== pid);
	localStorage.setItem("cart", JSON.stringify(cartObj));
	showToast("product removed")
	// Update the cart display after removal
	updateCart();
}


$(document).ready(function() {
	updateCart();
});



/*toast function */
function showToast(content) {
	$("#toast").html(`<i class='fa-regular fa-circle-check'></i>` + content)
	$("#toast").fadeIn(400).delay(2000).fadeOut(400);
}
