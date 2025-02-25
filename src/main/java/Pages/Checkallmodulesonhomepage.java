package Pages;

import org.openqa.selenium.By;

import Base.Reports;
import io.appium.java_client.AppiumBy;

public class Checkallmodulesonhomepage extends Reports {
	private static final By Preapprovedentry = AppiumBy.accessibilityId("Pre Approve Entry");

	private static final By Mycommunity = AppiumBy.accessibilityId("My Community");

	private static final By Notifygate = AppiumBy.accessibilityId("Notify Gate");

	private static final By Adminaccess = AppiumBy.accessibilityId("Admin Access");

	private static final By Homepageprofile = AppiumBy.xpath("//*[@bounds=\"[14,80][1066,250]\"]");

	private static final By RaiseComplaintmodule = AppiumBy.xpath("//*[@bounds=\"[41,809][289,1029]\"]");

	private static final By Societymembersmodule = AppiumBy.xpath("//*[@bounds=\"[344,809][591,1029]\"]");

	private static final By Securityalertmodule = AppiumBy.xpath("//*[@bounds=\"[41,1185][289,1405]\"]");

	private static final By Messagetosecuritymodule = AppiumBy.xpath("//*[@bounds=\"[316,1185][564,1405]\"]");

	private static final By Dailyhelpersmodule = AppiumBy.xpath("//*[@bounds=\"[591,1185][839,1405]\"]");

	private static final By Newmembersmodule = AppiumBy.xpath("//*[@bounds=\"[41,1562][289,1782]\"]");

	private static final By Securitymodule = AppiumBy.xpath("//*[@bounds=\"[316,1562][564,1782]\"]");

	private static final By Activitiesmodule = AppiumBy.xpath("//*[@bounds=\"[360,2049][720,2208]\"]");

	private static final By Moremodule = AppiumBy.xpath("//*[@bounds=\"[720,2049][1080,2208]\"]");

	public void Homepagemainmenuverification() throws InterruptedException {

		String a = "Chairman", b = "Secretary", c = "Treasurer";

		if (prop.getProperty("Loginuser").equalsIgnoreCase(a) || prop.getProperty("Loginuser").equalsIgnoreCase(b)
				|| prop.getProperty("Loginuser").equalsIgnoreCase(c)) {

			if (driver.findElement(Preapprovedentry).isDisplayed()) {
				Reports.Pass_Test("Preapprovedentry is displayed");
			} else {
				Reports.Fail_Test("Preapprovedentry is not displayed");
			}
			if (driver.findElement(Mycommunity).isDisplayed()) {
				Reports.Pass_Test("Mycommunity is displayed");
			} else {
				Reports.Fail_Test("Mycommunity is notdisplayed");
			}
			if (driver.findElement(Notifygate).isDisplayed()) {
				Reports.Pass_Test("Notifygate is displayed");
			} else {
				Reports.Fail_Test("Notifygate is not displayed");
			}
			if (driver.findElement(Adminaccess).isDisplayed()) {
				Reports.Pass_Test("Adminaccess is displayed");
			} else {
				Reports.Fail_Test("Adminaccess is not displayed");
			}

			if (driver.findElement(RaiseComplaintmodule).isDisplayed()) {
				Reports.Pass_Test("RaiseComplaintmodule is displayed");
			} else {
				Reports.Fail_Test("RaiseComplaintmodule is not displayed");
			}

			if (driver.findElement(Societymembersmodule).isDisplayed()) {
				Reports.Pass_Test("Societymembersmodule is displayed");
			} else {
				Reports.Fail_Test("Societymembersmodule is not displayed");
			}
			if (driver.findElement(Securityalertmodule).isDisplayed()) {
				Reports.Pass_Test("Securityalertmodule is displayed");
			} else {
				Reports.Fail_Test("Securityalertmodule is not displayed");
			}
			if (driver.findElement(Messagetosecuritymodule).isDisplayed()) {
				Reports.Pass_Test("Messagetosecuritymodule is displayed");
			} else {
				Reports.Fail_Test("Messagetosecuritymodule is not displayed");
			}
			if (driver.findElement(Dailyhelpersmodule).isDisplayed()) {
				Reports.Pass_Test("Dailyhelpersmodule is displayed");
			} else {
				Reports.Fail_Test("Dailyhelpersmodule is not displayed");
			}
			if (driver.findElement(Newmembersmodule).isDisplayed()) {
				Reports.Pass_Test("Newmembersmodule is displayed");
			} else {
				Reports.Fail_Test("Newmembersmodule is not displayed");
			}
			if (driver.findElement(Securitymodule).isDisplayed()) {
				Reports.Pass_Test("Securitymodule is displayed");
			} else {
				Reports.Fail_Test("Securitymodule is not displayed");
			}
			if (driver.findElement(Activitiesmodule).isDisplayed()) {
				Reports.Pass_Test("Activitiesmodule is displayed");
			} else {
				Reports.Fail_Test("Activitiesmodule is not displayed");
			}
			if (driver.findElement(Moremodule).isDisplayed()) {
				Reports.Pass_Test("Moremodule is displayed");
			} else {
				Reports.Fail_Test("Moremodule is not displayed");
			}
			if (driver.findElement(Homepageprofile).isDisplayed()) {
				Reports.Pass_Test("Homepageprofile is displayed");
			} else {
				Reports.Fail_Test("Homepageprofile is not displayed");
			}
		}
	}
}
