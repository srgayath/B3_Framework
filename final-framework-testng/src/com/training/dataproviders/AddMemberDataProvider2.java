package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.NewMemberBean;
import com.training.dao.AddNewMemberDao;
import com.training.readexcel.ApachePOIExcelReadValidData;
import com.training.readexcel.ReadExcel;

public class AddMemberDataProvider2 {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<NewMemberBean> list = new AddNewMemberDao().getNewUserData(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(NewMemberBean temp : list){
			Object[]  obj = new Object[15]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getFullName();
			obj[2] = temp.geteMail();
			obj[3] = temp.getDob();
			obj[4] = temp.getGender();
			obj[5] = temp.getAddress();
			obj[6] = temp.getPostalCode();
			obj[7] = temp.getCity();
			obj[8] = temp.getPhoneNumber();
			obj[9] = temp.getMobileNumber();
			obj[10] = temp.getFaxNumber();
			obj[11] = temp.getUrl();
			obj[12] = temp.getPassword();
			obj[13] = temp.getConfirmPassword();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "test-data")
	public Object[][] getExcelData(){
		String fileName ="C:/Users/SRIVALLIPAVANAGAYATH/Desktop/Selenium Project Files/CYTD_001.xlsx"; 
		return new ApachePOIExcelReadValidData().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/SRIVALLIPAVANAGAYATH/Desktop/Selenium Project Files/CYTD_001.xls", "Input"); 
	}
}
