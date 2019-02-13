package com.training.bean;

public class NewMemberBean {
	private String userName;
	private String fullName;
	private String eMail;
	private String dob;
	private String gender;
	private String address;
	private String postalCode;
	private String city;
	private String phoneNumber;
	private String mobileNumber;
	private String faxNumber;
	private String url;
	private String password;
	private String confirmPassword;

	public NewMemberBean() {
	}
	
	public NewMemberBean(String userName, String fullName, String eMail, String dob, String gender, String address, String postalCode, String city, String area, String phoneNumber, String mobileNumber, String faxNumber, String url, String password, String confirmPassword) {
		super();
		this.userName = userName;
		this.fullName = fullName;
		this.eMail = eMail;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.mobileNumber = mobileNumber;
		this.faxNumber = faxNumber;
		this.url = url;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	@Override
	public String toString() {
		return "NewMemberBean [userName=" + userName + ", fullName=" + fullName + ", eMail=" + eMail + ", dob=" + dob + ", gender=" + gender + ", address=" + address + ", postalCode=" + postalCode + ", city=" + city + ", phoneNumber=" + phoneNumber + ", mobileNumber=" + mobileNumber + ", faxNumber=" + faxNumber + ", url=" + url + ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
	}
	
}
