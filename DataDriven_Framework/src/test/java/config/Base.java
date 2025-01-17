package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import applicationLayer.AdminLogin;
import applicationLayer.AdminLogout;

public class Base {
public static WebDriver driver;
public static Properties conpro;
@BeforeTest
public static void setup() throws Throwable
{
	conpro = new Properties();
	conpro.load(new FileInputStream("PropertyFiles/Environment.properties"));
	if(conpro.getProperty("Browser").equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(conpro.getProperty("Url"));
		AdminLogin login = PageFactory .initElements(driver, AdminLogin.class);
		login.verifyLogin("Admin", "Qedge123!@#");
		
	}
	else if(conpro.getProperty("Browser").equalsIgnoreCase("firefox"))
	{
		driver = new FirefoxDriver();
		driver.get(conpro.getProperty("Url"));
		AdminLogin login = PageFactory .initElements(driver, AdminLogin.class);
		login.verifyLogin("Admin", "Qedge123!@#");
	}
	else
	{
		Reporter.log("Browser Value Not Matching",true);
		
	}
	
}
@AfterTest
public static void tearDown() throws Throwable
{
	AdminLogout logout = PageFactory.initElements(driver, AdminLogout.class);
	logout.verifyLogout();
	driver.quit();
}
}
