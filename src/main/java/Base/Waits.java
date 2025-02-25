package Base;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits extends Common_Methods {

	// This method is use to apply explicit wait to specific element
	public static void Waitforelement(WebElement element, int a) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(a));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

//----------------------------------------------------------------------------------------------------------//
	// This method is use to apply explicit wait to specific element
	public static void Waitforvisibilityofelement(By element, int a) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(a));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));

	}

//----------------------------------------------------------------------------------------------------------//
	// This method verify that locator is visible or page or not
	public static boolean waitForVisibilityOfElement(By element, int a) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(a));
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			return true; // Element is visible
		} catch (TimeoutException e) {
			return false; // Element is not visible within the time
		}
	}

//----------------------------------------------------------------------------------------------------------//	

	public static void WaitForElement(List<WebElement> elements, int a) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(a));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

//----------------------------------------------------------------------------------------------------------//

	// This method is use to stop execution for sometime
	public static void HardWait(int timeOutInMiliSec) throws InterruptedException {

		Thread.sleep(timeOutInMiliSec);
	}

//----------------------------------------------------------------------------------------------------------//	

	// This method is use to wait till frame appears
	public static void waitForIframe(WebElement element) {

		Object a = prop.get("Waittime");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds((long) prop.get(a)));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		driver.switchTo().frame(element);

	}

//----------------------------------------------------------------------------------------------------------//
	// This method is use to wait for specific time for element
	public static void waitfortime(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

//----------------------------------------------------------------------------------------------------------//

	public void waitUntilPageLoadsCompletely() {
		Object a = prop.get("Waittime");
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds((long) prop.get(a)));
		wait.until(d -> javascriptExecutor.executeScript("return document.readyState").toString().equals("complete"));
	}
}
