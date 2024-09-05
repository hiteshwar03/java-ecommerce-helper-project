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