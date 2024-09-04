package eKart.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

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
	private String userCreatedAt;
	private String imageName;

//    @blo // Large Object Binary
    @Column(columnDefinition = "LONGBLOB") // Explicitly specify the column type
    private byte[] imageData;
	
	
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


	public String getUserCreatedAt() {
		return userCreatedAt;
	}


	public void setUserCreatedAt(String userCreatedAt) {
		this.userCreatedAt = userCreatedAt;
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
	    
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int userid, String userName, String userEmail, String userPassword, long userPhone, String userAddress,
			String userType, String userCreatedAt, String imageName, byte[] imageData) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.userType = userType;
		this.userCreatedAt = userCreatedAt;
		this.imageName = imageName;
		this.imageData = imageData;
	}


	public User(String userName, String userEmail, String userPassword, long userPhone, String userAddress,
			String userType, String userCreatedAt, String imageName, byte[] imageData) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.userType = userType;
		this.userCreatedAt = userCreatedAt;
		this.imageName = imageName;
		this.imageData = imageData;
	}

	
}
