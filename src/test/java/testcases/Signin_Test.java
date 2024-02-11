package testcases;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Baseclass;
import pageobjects.Countryselectionpage;
import pageobjects.Createaccountpage;
import pageobjects.Signinpage;

public class Signin_Test extends Baseclass {
	
	@DataProvider(name="signintestdata")
	public Object[][] createaccount() throws InterruptedException, EncryptedDocumentException, IOException{
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\ecommerce\\src\\main\\java\\resources\\Data.xlsx");
		
		//CreateWorkbook
		
		Workbook workbook=WorkbookFactory.create(file);
		Sheet sheet=workbook.getSheet("Signin_Tests");
	
		//get the total number of rows
		
		int rowcount=sheet.getLastRowNum();
		
		//get column count
		
		int columncount=sheet.getRow(0).getLastCellNum();
		
		//create 2D array to store data from excel
		
		Object[][] data=new Object[rowcount][columncount];
		Thread.sleep(5000);
		
		//iteration
		
		for(int i=0; i<rowcount; i++) {
			//get the current row
			Row row=sheet.getRow(i+1);
			//iteration though column
			for(int j=0; j<columncount; j++) {
				Cell cell=row.getCell(j);
				//store the cell value- check if cell is null or not
				data[i][j]=(cell!=null)?cell.toString():null;
			}
			
		}
		
		return data;
	}


@Test (dataProvider="signintestdata")
public void signin(String email, String password)throws Exception  {
	
	Countryselectionpage country=new Countryselectionpage(driver);
	country.select_US();
	
	Signinpage signin=new Signinpage(driver);
	signin.clickonaccount();
	signin.clicksignin();
	signin.getsignindetails(email, password);
	
	//createaccount.createanaccount("Pearl","c","krishnapriya@gmail.com","Pearl@123", "9857461235");
	//String actual=signin.getalertmsg();
	//String Expected=("Oops! The email or password did not match our records. Please try again.");
	
	//assert.assertEquals(signin.getalertmsg(), "Oops! The email or password did not match our records. Please try again.");
	
}



}
