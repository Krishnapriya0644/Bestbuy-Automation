package testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import base.Baseclass;
import pageobjects.Countryselectionpage;
import pageobjects.Createaccountpage;

public class Create_Account_Test extends Baseclass {
	

	@DataProvider(name="createaccountdata")
	public Object[][] createaccount() throws InterruptedException, EncryptedDocumentException, IOException{
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\ecommerce\\src\\main\\java\\resources\\Data.xlsx");
		
		//CreateWorkbook
		
		Workbook workbook=WorkbookFactory.create(file);
		Sheet sheet=workbook.getSheet("Sheet1");
	
		//get the total number of rows
		
		int rowcount=sheet.getLastRowNum();
		
		//get column count
		
		int columncount=sheet.getRow(0).getLastCellNum();
		
		//create 2D array to store data from excel
		
		Object[][] data=new Object[rowcount][columncount];
		Thread.sleep(5000);
		
		//iteration
		
		for(int i=1; i<=rowcount; i++) {
			//get the current row
			Row row=sheet.getRow(i);
			//iteration though column
			for(int j=0; j<columncount; j++) {
				Cell cell=row.getCell(j);
				//store the cell value- check if cell is null or not
				data[i-1][j]=(cell!=null)?cell.toString():null;
			}
			
		}
		
		return data;
	}

	@Test (dataProvider="createaccountdata")
	public void createaccounttest(String firstname, String lastname, String email, String password, String mobilenumber)throws Exception  {
	//public void createaccounttest() throws Exception {
		Countryselectionpage country=new Countryselectionpage(driver);
		country.select_US();
		
		Createaccountpage createaccount=new Createaccountpage(driver);
		createaccount.clickonaccount();
		
		//createaccount.createanaccount("Pearl","c","krishnapriya@gmail.com","Pearl@123", "9857461235");

		createaccount.createanaccount(firstname, lastname, email, password, mobilenumber);
		
	}


	
}
