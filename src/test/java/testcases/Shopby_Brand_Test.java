package testcases;

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
import pageobjects.Shopbybrand;
import pageobjects.Signinpage;

public class Shopby_Brand_Test extends Baseclass {
		
		@DataProvider(name="brandwiseshopping")
		public Object[][] createaccount() throws InterruptedException, EncryptedDocumentException, IOException{
			FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\ecommerce\\src\\main\\java\\resources\\Data.xlsx");
			
			//CreateWorkbook
			
			Workbook workbook=WorkbookFactory.create(file);
			Sheet sheet=workbook.getSheet("Shopby_Brand");
		
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

@Test (dataProvider="brandwiseshopping")
	public void shop_by_brand(String shopby, String brandname, String appliance, String sortoption) throws Exception {

		Countryselectionpage country=new Countryselectionpage(driver);
		
		country.select_US();
		
		/*Signinpage signin=new Signinpage(driver);
		signin.clickonaccount();
		signin.clicksignin();
		signin.getsignindetails("meenakshi020423@gmail.com", "Meenakshi@02"); */
		
		Shopbybrand shop=new Shopbybrand(driver);
		
		shop.clickonmenu();
		shop.shopbybrand(shopby);
		shop.Select_Brand(brandname);
		shop.Select_Product(appliance);
		shop.excludeoutofstockitem();
		shop.sortbyoption(sortoption);
		shop.selectproduct_and_addtocart();
		shop.go_to_cart();
		shop.checkout();
		//shop.continue_to_payment();
		}

			
		
	}
		


