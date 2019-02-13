package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.LoginBean;
import com.training.bean.NewMemberBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class AddNewMemberDao {
	
	Properties properties; 
	
	public AddNewMemberDao() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<NewMemberBean> getNewUserData(){
		String sql = properties.getProperty("get.logins"); 
		
		GetConnection gc  = new GetConnection(); 
		List<NewMemberBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<NewMemberBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				NewMemberBean temp = new NewMemberBean(); 
				temp.setUserName(gc.rs1.getString(1));
				temp.setFullName(gc.rs1.getString(2));
				temp.seteMail(gc.rs1.getString(3));
				temp.setDob(gc.rs1.getString(4));
				temp.setGender(gc.rs1.getString(5));
				temp.setAddress(gc.rs1.getString(6));
				temp.setPostalCode(gc.rs1.getString(7));
				temp.setCity(gc.rs1.getString(8));
				temp.setPhoneNumber(gc.rs1.getString(9));
				temp.setMobileNumber(gc.rs1.getString(10));
				temp.setFaxNumber(gc.rs1.getString(11));
				temp.setUrl(gc.rs1.getString(12));
				temp.setPassword(gc.rs1.getString(13));
				temp.setConfirmPassword(gc.rs1.getString(14));
				
				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new AddNewMemberDao().getNewUserData().forEach(System.out :: println);
	}
	
	
}
