package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import Base.Reports;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Loginpage extends Reports {

	private static final By Mobileno = AppiumBy.xpath("//android.widget.EditText[@index='2']");

	private static final By Password = AppiumBy.xpath("//android.widget.EditText[@index='4']");

	private static final By Loginbtn = AppiumBy.xpath("//android.widget.Button[@content-desc=\"Next\"]");

	private static final By Homepageprofile = AppiumBy.xpath("//*[@bounds=\"[14,80][1066,250]\"]");

	public Loginpage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void login() throws InterruptedException {
		Readpropertyfile();
		if (prop.getProperty("Loginuser").equalsIgnoreCase("Chairman")) {

			Send_Keys(Mobileno, prop.getProperty("code"));
			Reports.Info("Entering Society code");

			Hide_Keyboard();
			Reports.Info("Clicking on Next button");

			Send_Keys(Mobileno, prop.getProperty("ChairmanMobileno"));
			Reports.Info("Entering Mibile No");

			Click(Password);
			Send_Keys(Password, prop.getProperty("Chairmanpassword"));
			Reports.Info("Entering Password");

			Hide_Keyboard();
			Click(Loginbtn);
			Reports.Info("Clicking on Loginbtn button");

			Thread.sleep(5000);

			if (driver.findElement(Homepageprofile).isDisplayed()) {
				Reports.Pass_Test("Application Login Success & Homepage is displayed");

			} else {
				Reports.Fail_Test("Application Login Failed");
			}

		}
	}

}
