package testmeapp.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import testmeapp.utility.Drivers;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class OnlineShoppingTest {
	 WebDriver driver=Drivers.getDriver("chrome");
  @Test(priority=1)
  public void testRegistration() {
	  
	  driver.findElement(By.linkText("SignUp")).click();
	  driver.findElement(By.id("userName")).sendKeys("abcd12345");
	  driver.findElement(By.id("firstName")).sendKeys("Deeksha");
	  driver.findElement(By.id("lastName")).sendKeys("Pai");
	  driver.findElement(By.id("password")).sendKeys("Dee261197");
	  driver.findElement(By.id("pass_confirmation")).sendKeys("Dee261197");
	  WebElement radio=driver.findElement(By.xpath("/html/body/main/div/div/form/fieldset/div/div[6]/div/div/label/span[2]"));
	  radio.click();
	  driver.findElement(By.id("emailAddress")).sendKeys("paideek97@gmail.com");
	  driver.findElement(By.id("mobileNumber")).sendKeys("8277609549");
	  driver.findElement(By.id("dob")).sendKeys("11/26/1997");
	  driver.findElement(By.id("address")).sendKeys("Manipal,Udupi");
	  Select from=new Select(driver.findElement(By.id("securityQuestion")));
	  from.selectByIndex(1);
	  driver.findElement(By.id("answer")).sendKeys("Black");
	  driver.findElement(By.name("Submit")).click();
}
  
  @Test(priority=2)
  public void testLogin() {
	  //driver.findElement(By.linkText("SignIn")).click();
	  driver.findElement(By.name("userName")).sendKeys("abcd12345");
	  driver.findElement(By.id("password")).sendKeys("Dee261197");
	  driver.findElement(By.name("Login")).click();
  }
  
  
  @Test(priority=3)
  public void testCart() throws InterruptedException {
	  
	  driver.findElement(By.linkText("All Categories")).click();
	  Thread.sleep(500);
	  driver.findElement(By.linkText("Electronics")).click();
	  Thread.sleep(500);
	  driver.findElement(By.linkText("Head Phone")).click();
	  Thread.sleep(500);
	  driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
	  Thread.sleep(500);
	  
	  
	  
  }
  
  @Test(priority=4)
  public void testPayment() throws InterruptedException {
	  
	  driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
	  Thread.sleep(500);
	  driver.findElement(By.xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[5]/a")).click();
	  Thread.sleep(500);
	  driver.findElement(By.xpath("//input[@type='submit' and @value='Proceed to Pay']")).click();
	  Thread.sleep(500);
	  driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div/div/div[2]/div[2]/div")).click();
	  Thread.sleep(500);
	  driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div/a")).click();
	  Thread.sleep(500);
	  driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div/div/div/form/input[1]")).sendKeys("123457");
	  Thread.sleep(500);
	  driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div/div/div/form/input[2]")).sendKeys("Pass@457");
	  Thread.sleep(500);
	  driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/div/div[3]/input")).click();
	  Thread.sleep(500);
	  driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input")).sendKeys("Trans@457");
	  Thread.sleep(500);
	  driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/div/div[2]/input")).click();
	  Thread.sleep(500);
	  //driver.findElement(By.xpath("/html/body/header/div/div/ul/b/a[2]")).click();
  }
  
  
  ExtentReports extent=new ExtentReports();
  
  @AfterMethod
  public void getResultafterMethod(ITestResult result) throws Exception {
	  
	  ExtentHtmlReporter reporter= new ExtentHtmlReporter("C:\\Users\\training_b6B.01.16\\Desktop\\NewExtentReport26_DP.html");
	  ExtentReports extent= new ExtentReports();
	  extent.attachReporter(reporter);
	  ExtentTest logger=extent.createTest("TestMeApp");
	  logger.log(Status.INFO, "TestMEAPP Successfull");
	  logger.log(Status.PASS, "TestMEAPP Successfull");
	  
	  if(result.getStatus()==ITestResult.SUCCESS) {
	  logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Test Case Passed",ExtentColor.GREEN));
	  TakesScreenshot capture1=(TakesScreenshot)driver;
	  File source1=capture1.getScreenshotAs(OutputType.FILE);
	  String imgpath=System.getProperty("user.dir")+"/extent-reports/snapshots/" +result.getName()+".png";
	  FileUtils.copyFile(source1, new File(imgpath));
	  logger.addScreenCaptureFromPath(imgpath,result.getName());
	  }
	  
	  else if(result.getStatus()==ITestResult.FAILURE) {
	  logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test Case Failed",ExtentColor.RED));
	  TakesScreenshot snapshot=(TakesScreenshot)driver;
	  File src=snapshot.getScreenshotAs(OutputType.FILE);
	  String path=System.getProperty("user.dir")+"/extent-reports/snapshots/" +result.getName()+".png";
	  System.out.println((result.getName()));
	  FileUtils.copyFile(src, new File(path));
	  logger.addScreenCaptureFromPath(path,result.getName());
	  }
	  extent.flush();
	  /*logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + "-Test Case Failed",ExtentColor.RED));
	  }
	  else if(result.getStatus() == ITestResult.SKIP) 
	  {
      logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "-Test Case Skipped",ExtentColor.ORANGE));*/
	  }
	  
  
	  
  @BeforeTest
  public void startReportbeforeTest() {
	 
	  String url="http://10.232.237.143:443/TestMeApp/fetchcat.htm";
	  driver.get(url);
	  driver.manage().window().maximize();
	  driver.navigate().refresh();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  System.out.println("The title of the web page is"+driver.getTitle());
  }

  @AfterTest
  public void endReportafterTest() {
	  extent.flush();
  }

}
