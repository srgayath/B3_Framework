package com.training.bean;

public class AccessToMultipleMembersBean {
	private String userName;


	public AccessToMultipleMembersBean() {
	}
	
	public AccessToMultipleMembersBean(String userName) {
		super();
		this.userName = userName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	@Override
	public String toString() {
		return "NewMemberBean [userName=" + userName + "]";
	}
	
}
