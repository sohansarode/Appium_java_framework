package Pages;

import java.io.IOException;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import Base.Reports;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RaiseComplaintspage extends Reports {

	private static final By Raisecompmodule = AppiumBy.xpath("//*[@bounds=\"[41,809][289,1029]\"]");

	private static final By Complaintslabel = AppiumBy.xpath("//android.view.View[@content-desc=\"Complaints\"]");

	private static final By Addcomplaintbtn = AppiumBy.xpath("//android.widget.Button[@content-desc=\"ADD NEW\"]");

	private static final By Searchbar = AppiumBy.xpath("//*[@bounds=\"[28,248][1053,358]\"]");

	private static final By Addnewcomplaintlabel = AppiumBy.xpath("//*[@bounds=\"[154,111][644,175]\"]");

	private static final By Categorylabel = AppiumBy.xpath("//android.view.View[@content-desc=\"Category\"]");

	private static final By Selectcategorydropdown = AppiumBy
			.xpath("//android.widget.ImageView[@content-desc=\"Select Category\"]");

	private static final By Complaintypelabel = AppiumBy
			.xpath("//android.view.View[@content-desc=\"Complains Types:\"]");

	private static final By Personalcomp = AppiumBy.xpath("//android.view.View[@content-desc=\"Personal\"]");

	private static final By Communitycomp = AppiumBy.xpath("//android.view.View[@content-desc=\"Community\"]");

	private static final By Isurgentlabel = AppiumBy.xpath("//android.view.View[@content-desc=\"Is it urgent?\"]");

	private static final By Isurgentbtn = AppiumBy.xpath("//*[@bounds=\"[42,801][200,959]\"]");

	private static final By Descriptionlabel = AppiumBy.xpath("//android.view.View[@content-desc=\"Description\"]");

	private static final By Descriptiontextbox = AppiumBy.xpath("//*[@bounds=\"[33,1051][1047,1381]\"]");

	private static final By Attachmentlabel = AppiumBy.xpath("//android.view.View[@content-desc=\"Attachment\"]");

	private static final By Attachmentfile = AppiumBy.xpath("//android.widget.Button[@content-desc=\"Choose file\"]");

	private static final By Attachmentfromgallery = AppiumBy
			.xpath("//android.widget.ImageView[@content-desc=\"Image Take From Gallery\"]");

	private static final By Showroots = AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Show roots\"]");

	private static final By Androiddownloads = AppiumBy.xpath("//*[@bounds=\"[176,578][748,631]\"]");

	private static final By Image = AppiumBy.xpath("//*[@bounds=\"[66,418][198,550]\"]");

	private static final By Submitbtn = AppiumBy.xpath("//android.widget.Button[@content-desc=\"Submit\"]");

	private static final By Categorycarparking = AppiumBy.xpath("//android.view.View[@content-desc=\"Car parking\"]");
	private static final By Categorycarpenter = AppiumBy.xpath("//android.view.View[@content-desc=\"Carpenter\"]");
	private static final By Categorycommonarea = AppiumBy.xpath("//android.view.View[@content-desc=\"Common area\"]");
	private static final By Categorydrainage = AppiumBy.xpath("//android.view.View[@content-desc=\"Drainage\"]");
	private static final By Categoryelectrical = AppiumBy.xpath("//android.view.View[@content-desc=\"Electrical\"]");
	private static final By Categoryfiresafety = AppiumBy.xpath("//android.view.View[@content-desc=\"Fire Safety\"]");
	private static final By Categoryintercom = AppiumBy.xpath("//android.view.View[@content-desc=\"Intercom\"]");
	private static final By Categorylifeservice = AppiumBy.xpath("//android.view.View[@content-desc=\"Life Service\"]");
	private static final By Categorylifts = AppiumBy.xpath("//android.view.View[@content-desc=\"Lifts\"]");
	private static final By Categoryother = AppiumBy.xpath("//android.view.View[@content-desc=\"Other\"]");

	public RaiseComplaintspage() {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void Raisecomplaintstest() throws InterruptedException, IOException {
		if (prop.get("Raisecomp").equals("Yes")) {
			Reports.Info("Want to Raise Complaints");
			if (driver.findElement(Raisecompmodule).isDisplayed()) {
				Reports.Info("Clicking on Raisecompmodule");
				Click(Raisecompmodule);
				Reports.Pass_Test("Raisecompmodule is displayed & Clicked");

				if (driver.findElement(Complaintslabel).isDisplayed()) {
					Reports.Pass_Test("Complaintslabel is displayed");
				} else {
					Reports.Fail_Test("Complaintslabel is not displayed");
				}
				// ------------------------------------------------------------------------//
				if (driver.findElement(Addcomplaintbtn).isDisplayed()) {
					Reports.Info("Clicking on Addcomplaintbtn");
					Click(Addcomplaintbtn);
					Reports.Pass_Test("Addcomplaintbtn is displayed & Clicked");
				} else {
					Reports.Fail_Test("Complaintslabel is not displayed & not Clicked");
				}
				// ------------------------------------------------------------------------//
				Thread.sleep(5000);
				// ------------------------------------------------------------------------//
				if (driver.findElement(Addnewcomplaintlabel).isDisplayed()) {
					Reports.Pass_Test("Addnewcomplaintlabel is displayed");
				} else {
					Reports.Fail_Test("Addnewcomplaintlabel is not displayed");
				}
				// ------------------------------------------------------------------------//
				if (driver.findElement(Categorylabel).isDisplayed()) {
					Reports.Pass_Test("Categorylabel is displayed");
				} else {
					Reports.Fail_Test("Categorylabel is not displayed");
				}
				// ------------------------------------------------------------------------//
				if (driver.findElement(Selectcategorydropdown).isDisplayed()) {
					Reports.Info("Selecting Category from dropdown");
					Click(Selectcategorydropdown);
					if (prop.get("Category").equals("Carparking")) {
						Click(Categorycarparking);
					} else if (prop.get("Category").equals("Carpenter")) {
						Click(Categorycarpenter);
					} else if (prop.get("Category").equals("Commonarea")) {
						Click(Categorycommonarea);
					} else if (prop.get("Category").equals("Drinage")) {
						Click(Categorydrainage);
					} else if (prop.get("Category").equals("Electrical")) {
						Click(Categoryelectrical);
					} else if (prop.get("Category").equals("Firesafety")) {
						Click(Categoryfiresafety);
					} else if (prop.get("Category").equals("Intercom")) {
						Click(Categoryintercom);
					} else if (prop.get("Category").equals("Lifeservice")) {
						Click(Categorylifeservice);
					} else if (prop.get("Category").equals("Lifts")) {
						Click(Categorylifts);
					} else if (prop.get("Category").equals("Other")) {
						Click(Categoryother);
					} else {

					}
					Reports.Pass_Test("Category is Selected from dropdown");
				} else {
					Reports.Fail_Test("Category is not Selected from dropdown");
				}
				// ------------------------------------------------------------------------//
				Thread.sleep(5000);
				// ------------------------------------------------------------------------//
				if (driver.findElement(Complaintypelabel).isDisplayed()) {
					Reports.Info("Complaintypelabel is displayed & Selecting Category");
					if (prop.get("Complainttype").equals("Personal")) {
						Click(Personalcomp);
					} else if (prop.get("Complainttype").equals("Community")) {
						Click(Communitycomp);
					}
					Reports.Pass_Test("Complaintypelabel is Selected");
				} else {
					Reports.Fail_Test("Complaintypelabel is not ssSelected");
				}
				// ------------------------------------------------------------------------//
				if (driver.findElement(Isurgentlabel).isDisplayed()) {
					Reports.Info("Isurgent is displayed & Selecting isurgent");
					if (prop.get("Isurgent").equals("Yes")) {
						Reports.Info("Clicking on Isurgentbtn");
						Click(Isurgentbtn);
						Reports.Pass_Test("Clicked on Isurgent btn");

					} else if (prop.get("isurgent").equals("No")) {
						Reports.Pass_Test("Is urgent not selcted");
					} else {
						Reports.Fail_Test("isurgent failed");
					}
					Reports.Pass_Test("Isurgent is Selected");
				} else {
					Reports.Fail_Test("Isurgent is not Selected");
				}
				// ------------------------------------------------------------------------//
				if (driver.findElement(Descriptionlabel).isDisplayed()) {
					Reports.Info("Descriptionlabel is displayed & entering Description");
					if (driver.findElement(Descriptiontextbox).isDisplayed()) {
						Click(Descriptiontextbox);
						String randomString = RandomStringUtils.randomAlphabetic(10);
						String a = "Test";
						String r = a + randomString;
						Send_Keys(Descriptiontextbox, r);
					}
					Reports.Pass_Test("Description is Entered");
				} else {
					Reports.Fail_Test("Description is not Entered");
				}
				// ------------------------------------------------------------------------//
				Hide_Keyboard();
				// ------------------------------------------------------------------------//
				if (driver.findElement(Attachmentlabel).isDisplayed()) {
					Reports.Info("Attachmentlabel is displayed");
					if (driver.findElement(Attachmentfile).isDisplayed()) {
						Reports.Info("Attachmentfile is displayed & Attaching file");
						Click(Attachmentfile);
						Click(Attachmentfromgallery);
						Click(Showroots);
						Click(Androiddownloads);
						Click(Image);
						Hide_Keyboard();
						Reports.Pass_Test("File is Attached");

					} else {
						Reports.Fail_Test("File is not Attached");
					}
				}
				// ------------------------------------------------------------------------//

				if (driver.findElement(Submitbtn).isDisplayed()) {
					Reports.Info("Clicking on Addcomplaintbtn");
					Click(Submitbtn);
					Reports.Pass_Test("Submitbtn is displayed & Clicked");
				} else {
					Reports.Fail_Test("Submitbtn is not displayed & not Clicked");
				}
				// ------------------------------------------------------------------------//

				if (driver.findElement(Searchbar).isDisplayed()) {
					Reports.Info("Clicking on Searchbar");
					Click(Searchbar);
					Reports.Info("Sending keys to Searchbar");
					Send_Keys(Searchbar, "Test");
					Reports.Pass_Test("Clicked on search bar & send keys");
				} else {
					Reports.Fail_Test("not Clicked on search bar & send keys");
				}

			} else {
				Reports.Fail_Test("Raisecompmodule is not displayed & Clicked");
			}
		} else {
			Reports.Info("Dont want to Raise Comp");
		}

	}

}
