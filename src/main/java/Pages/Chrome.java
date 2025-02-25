package Pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import Base.Reports;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Chrome extends Reports {

	private static final By Searchbar = AppiumBy
			.xpath("//android.widget.EditText[@resource-id=\"com.android.chrome:id/search_box_text\"]");

	private static final By Acceptbtn = AppiumBy
			.xpath("//android.widget.Button[@resource-id=\"com.android.chrome:id/terms_accept\"]");

	private static final By Nothanksbtn = AppiumBy
			.xpath("//android.widget.Button[@resource-id=\"com.android.chrome:id/negative_button\"]");

	private static final By Homepagesidebar = AppiumBy.xpath("//android.view.View[@text=\"Open/Close Menu\"]");

	private static final By Allmodules = AppiumBy
			.xpath("//android.view.View[@resource-id=\"post-480987\"]/android.view.View[2]/android.view.View[2]");

	private static final By Closead = AppiumBy.xpath(
			"//android.view.View[@resource-id=\"cta_155419\"]/android.view.View/android.view.View[3]/android.widget.Image");

	public Chrome() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void Searchbar() throws InterruptedException, IOException {
		Readpropertyfile();
		Click(Acceptbtn);
		Reports.Fail_Test("fail");
		Click(Nothanksbtn);
		System.out.println("btn press");
		Send_Keys(Searchbar, "");
		Press_Enter();
		Click(Homepagesidebar);
		Thread.sleep(1000);
		Click(Closead);

	}
}