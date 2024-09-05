function addToProduct(pid,pname,price){
	let cart=localStorage.getItem("cart");
	
	if(cart==null){
		let products=[];
		let product={productId:pid, productName:pname, productQuantity:1,productPrice:price};
		products.push(product);
		localStorage.setItem("cart",JSON.stringify(products));
		console.log("product added first time")
	}
	else{
		let pcart=JSON.parse(cart);
		
		let oldProduct=pcart.find((item)=>item.productId==pid)
		
		if(oldProduct){
			oldProduct.productQuantity=oldProduct.productQuantity+1;
			pcart.map((item)=>{
				if(item.productId==oldProduct.productId){
					item.productQuantity=oldProduct.productQuantity
				}
			});
			
			localStorage.setItem("cart",JSON.stringify(pcart))
			console.log("product increased quantity")
		}
		else{
			let product={productId:pid, productName:pname, productQuantity:1,productPrice:price};
			pcart.push(product);
			localStorage.setItem("cart",JSON.stringify(pcart))
			console.log("product added")
		}
	}
}


function updateCart(){
	let cartString=localStorage.getItem("cart");
	let cartObj=JSON.parse(cartString);
	
	if(cartObj===null || cartObj.length===0){
		console.log("cart is empty")
		$(".cart-body").html("<h3>empty cart....Please add items in you cart</h3>")
		$("checkout-btn").addClass('disabled');
	}
	else{
		console.log(cartObj);
		$("cart-items").html('(${cartObj.length})');
		let table=`
		<table border="1">
		        <thead>
		            <tr>
		                <th>Product</th>
		                <th>Price</th>
		                <th>Quantity</th>
		                <th>Total</th> 
		            </tr>
		        </thead>
		`;
		
		let totalPrice=0;
		cartObj.map((item)=>{
			table+=`
				<tr>
					<td>${item.productName}</td>
					<td>${item.productPrice}</td>
					<td>${item.productQuantity}</td>
					<td>${item.productQuantity * item.productPrice}</td>
					<td><button>Remove</button></td>
				</tr>
			`;
			totalPrice+=item.productPrice*item.productQuantity;
		});
			
		table+=`
						<tr>
							<td>Total: ${totalPrice}</td>
						</tr>
		`;
		
		$(".cart-body").html(table)
		$("checkout-btn").addClass('enabled');
				
		
	}
}

$(document).ready(function(){
	updateCart();
})