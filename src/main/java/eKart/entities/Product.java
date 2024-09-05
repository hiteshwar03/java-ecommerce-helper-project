package eKart.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity	//mandatory
public class Product {


	@Id		//mendatory
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String pName;
	private String pDesc;
	private int pPrice;
	private int pDiscount;
	private int pQuantity;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private Cart cart;
	
	//store image
	private String imageName;

//  @blo // Large Object Binary
	@Column(columnDefinition = "LONGBLOB") // Explicitly specify the column type
	private byte[] imageData;
	private String imageType; // MIME type for the image
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpDesc() {
		return pDesc;
	}
	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public int getpDiscount() {
		return pDiscount;
	}
	public void setpDiscount(int pDiscount) {
		this.pDiscount = pDiscount;
	}
	public int getpQuantity() {
		return pQuantity;
	}
	public void setpQuantity(int pQuantity) {
		this.pQuantity = pQuantity;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String pName, String pDesc, int pPrice, int pDiscount, int pQuantity, Category category, Cart cart,
			String imageName, byte[] imageData, String imageType) {
		super();
		this.pName = pName;
		this.pDesc = pDesc;
		this.pPrice = pPrice;
		this.pDiscount = pDiscount;
		this.pQuantity = pQuantity;
		this.category = category;
		this.cart = cart;
		this.imageName = imageName;
		this.imageData = imageData;
		this.imageType = imageType;
	}
	
	
	
	

	
	
}
