package testmeapp.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Drivers {
  @Test
  public static WebDriver getDriver(String browser) {
	  
	  if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\training_b6B.01.16\\Desktop\\Browser Drivers_DP\\chromedriver.exe");
		return new ChromeDriver();}
	else if(browser.equals("firefox")) {
		 System.setProperty("webdriver.firefox.driver","C:\\Users\\training_b6B.01.16\\Desktop\\Browser Drivers_DP\\geckodriver.exe");
	return new FirefoxDriver();}
	else if(browser.equals("ie")){
		System.setProperty("webdriver.ie.driver","C:\\Users\\training_b6B.01.16\\Desktop\\Browser Drivers_DP\\IEDriverServer.exe");
		return new InternetExplorerDriver();}
	else {

		return null;
    }
  }
} 
