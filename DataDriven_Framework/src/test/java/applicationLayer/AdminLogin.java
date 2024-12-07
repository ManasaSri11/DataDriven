package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogin {
	//define Repository for login
	@FindBy(name="txtUsername")
	WebElement ObjUser;
	@FindBy(id="txtPassword")
	WebElement ObjPass;
	@FindBy(id="btnLogin")
	WebElement ObjLogin;
	public void verifyLogin(String username,String password)
	{
	ObjUser.sendKeys(username);	
	ObjPass.sendKeys(password);
	ObjLogin.click();
	}

}
