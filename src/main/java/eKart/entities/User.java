package eKart.entities;

import java.util.Arrays;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity 	//mendatory
public class User {
	
	@Id		//mendatory
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	private String userName;
	private String userEmail;
	private String userPassword;
	private long userPhone;
	private String userAddress;
	private String userType;
	@Temporal(TemporalType.DATE)
	private Date userCreatedAt;
	
//	@OneToOne
//	private Cart cart;
	
	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public long getUserPhone() {
		return userPhone;
	}


	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}


	public String getUserAddress() {
		return userAddress;
	}


	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	public Date getUserCreatedAt() {
		return userCreatedAt;
	}


	public void setUserCreatedAt(Date userCreatedAt) {
		this.userCreatedAt = userCreatedAt;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(String userName, String userEmail, String userPassword, long userPhone, String userAddress,
			String userType, Date userCreatedAt) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.userType = userType;
		this.userCreatedAt = userCreatedAt;
	}


//	public Cart getCart() {
//		return cart;
//	}
//
//
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}


//	public User(String userName, String userEmail, String userPassword, long userPhone, String userAddress,
//			String userType, Date userCreatedAt, Cart cart) {
//		super();
//		this.userName = userName;
//		this.userEmail = userEmail;
//		this.userPassword = userPassword;
//		this.userPhone = userPhone;
//		this.userAddress = userAddress;
//		this.userType = userType;
//		this.userCreatedAt = userCreatedAt;
//		this.cart = cart;
//	}




	

	
}
