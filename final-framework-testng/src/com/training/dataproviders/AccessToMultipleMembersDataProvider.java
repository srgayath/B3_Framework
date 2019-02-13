package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.NewMemberBean;
import com.training.dao.AddNewMemberDao;
import com.training.readexcel.ApachePOIExcelGiveMemberAccess;
import com.training.readexcel.ReadExcel;

public class AccessToMultipleMembersDataProvider {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<NewMemberBean> list = new AddNewMemberDao().getNewUserData(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(NewMemberBean temp : list){
			Object[]  obj = new Object[15]; 
			obj[0] = temp.getUserName(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "test-data")
	public Object[][] getExcelData(){
		String fileName ="C:/Users/SRIVALLIPAVANAGAYATH/Desktop/Selenium Project Files/CYCTD_003.xlsx"; 
		return new ApachePOIExcelGiveMemberAccess().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/SRIVALLIPAVANAGAYATH/Desktop/Selenium Project Files/CYCTD_003.xls", "Input"); 
	}
}
