package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utility {
	public static WebDriver driver;
	//public Properties prop;
	WebDriverWait wait;
	Actions action;
	
 /*
  	public static String readProperty() throws Exception {
		String projectPath = System.getProperty("user.dir");
		File file = new File(projectPath + "C:\\Users\\Admin\\eclipse-workspace\\ecommerce\\src\\main\\java\\resources\\data.properties");
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		
	}
	*/
	public void launchbrowser() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.bestbuy.com/");
		
		
		//window maximization		
				driver.manage().window().maximize();
				
				//delete cookies		
				driver.manage().deleteAllCookies();
				
				//implicit Wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
	}
	
	public static WebElement initializewait(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static WebElement initializevisibilitywait(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void InitializeActions(){
		Actions action=new Actions(driver);
	}
	
	public void Initializedropdown( List<WebElement> menudropdown, String optiontoselect) throws InterruptedException {
		List<WebElement> list=menudropdown;
		for(int i=0; i<menudropdown.size(); i++) {
			String textofchoosenoption=menudropdown.get(i).getText();
			Thread.sleep(5000);
			if(textofchoosenoption.contains(optiontoselect)) {
				wait.until(ExpectedConditions.elementToBeClickable(menudropdown.get(i)));
				action.moveToElement(menudropdown.get(i)).click().build().perform();
				break;
			}
				
		}
		
	}
	
	public  String getScreenshot(String testname, WebDriver driver) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//Screenshot//"+testname+".png");
		//String screenshotfilepath=System.getProperty("user.dir")+"\\Screenshot\\"+testname+".png";
		FileUtils.copyFile(src,file);
		return System.getProperty("user.dir")+"//Screenshot//"+testname+".png";
	}
	

	public void InitializeJavascriptExecutor() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,1000)");
	}
	
	public void selectbyvalue(WebElement element, String value) {
		Select select=new Select(element);
		select.selectByValue(value);	
	}
	public void selectbyindex(WebElement element, int index) {
		Select select=new Select(element);
		select.deselectByIndex(index);	
	}
	public void selectbyvisibletext(WebElement element, String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);	
	}
	
	
}
