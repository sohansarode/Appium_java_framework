package Base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.javafaker.Faker;
import com.google.common.collect.ImmutableMap;

public class Common_Methods extends Base_Page {

	public void Click(By By) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By));
		element.click();
	}

//----------------------------------------------------------------------------------------------------------------------------//
	// Clears the text content of the input field identified by the given, By
	// selector after ensuring it is clickable.
	public void Clear(By By) {
		// Create a WebDriverWait instance with a timeout of 20 seconds
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Wait until the element identified by the 'by' selector is clickable
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By));

		// Clear the text content of the input field
		element.clear();
	}

//----------------------------------------------------------------------------------------------------------------------------//
	// Sets the screen orientation of the device to the specified type.
	public void Set_Screen_Orientation(String OrientationType) {
		// Convert the orientationType parameter to lowercase for case-insensitive
		// comparison
		String orientationTypeLowerCase = OrientationType.toLowerCase();

		// Set the screen orientation based on the specified type
		if (orientationTypeLowerCase.equals("landscape")) {
			// Set the screen orientation to landscape
			driver.rotate(ScreenOrientation.LANDSCAPE);
		} else if (orientationTypeLowerCase.equals("portrait")) {
			// Set the screen orientation to portrait
			driver.rotate(ScreenOrientation.PORTRAIT);
		} else {
			// Log or throw an exception for unsupported orientation types
			System.out.println("Unsupported orientation type: " + OrientationType);
			// Alternatively, throw an exception to indicate an error state
			throw new IllegalArgumentException("Unsupported orientation type: " + OrientationType);
		}
	}
//----------------------------------------------------------------------------------------------------------------------------//

//Enters the specified text (code) into the input field identified by the given By selector after ensuring it is visible.

	public void Send_Keys(By By, String Data) {
		// Create a WebDriverWait instance with a timeout of 20 seconds
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Wait until the element identified by the 'by' selector is visible
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By));

		// Enter the specified text (code) into the input field
		element.sendKeys(Data);
	}
//----------------------------------------------------------------------------------------------------------------------------//

	// This method is designed to simulate pressing the "Enter" key on the device.

	public void Press_Enter() throws IOException, InterruptedException {
		// Use adb shell command to simulate pressing the "Enter" key
		Process process = Runtime.getRuntime().exec("adb shell input keyevent 66");

		// Wait for the process to complete
		process.waitFor();
	}
//----------------------------------------------------------------------------------------------------------------------------//

	// Hides the on-screen keyboard if it is currently displayed
	public void Hide_Keyboard() {
		// Use the WebDriver's hideKeyboard() method to hide the on-screen keyboard
		driver.hideKeyboard();
	}
//----------------------------------------------------------------------------------------------------------------------------//

	// Opens the notification center or panel on the device.
	public void Open_Notification() {
		// Use the WebDriver's openNotifications() method to open the notification
		// center
		driver.openNotifications();
	}

//----------------------------------------------------------------------------------------------------------------------------//
	// This method is use to Accept & Dismiss Alerts

	public static void Handle_Alerts(String Action) {
		try {
			// Switch to the currently active alert
			Alert alert = driver.switchTo().alert();

			// Check the specified action and perform the corresponding alert operation
			if ("accept".equalsIgnoreCase(Action)) {
				// Accept the alert (click OK or Yes)
				alert.accept();
			} else if ("dismiss".equalsIgnoreCase(Action)) {
				// Dismiss the alert (click Cancel or No)
				alert.dismiss();
			} else {
				// Print a message if the specified action is not recognized
				System.out.println("Invalid alert action: " + Action);
			}
		} catch (NoAlertPresentException e) {
			// Print a message if no alert is present
			System.out.println("Alert is not present");
		}
	}
//-----------------------------------------------------------------------------------------------------------------------------------------//

	// This method is used to perform a context-switch to an alert and retrieve its
	// text

	public static String Switch_To_Alert_And_Get_Text() {
		try {
			// Switch to the currently active alert
			Alert alert = driver.switchTo().alert();

			// Get the text of the alert
			String alertText = alert.getText();

			// Log information about switching to the alert and retrieving text
			logger.info("Switched to alert and retrieved text: " + alertText);

			// Return the text of the alert
			return alertText;
		} catch (NoAlertPresentException e) {
			// Log information if no alert is present
			logger.info("No alert present.");

			// Return null if no alert is present
			return null;
		}
	}

//----------------------------------------------------------------------------------------------------------------------------//

	// Adds an image file from the local file system to a specified destination on
	// the device.

	public void addImage(String destination, String location) throws IOException {
		// Use the WebDriver's pushFile() method to push the image file to the specified
		// destination
		driver.pushFile(destination, new File(location));
	}

//----------------------------------------------------------------------------------------------------------------------------//
	// Toggles the specified device setting based on the provided toggle parameter.
	public void Toggle_Action(String Toggle) {
		// Convert the toggle parameter to lowercase for case-insensitive comparison
		String toggleLowerCase = Toggle.toLowerCase();

		// Perform the toggle action based on the provided setting
		if (toggleLowerCase.equals("location")) {
			// Toggle location services
			driver.toggleLocationServices();
		} else if (toggleLowerCase.equals("data")) {
			// Toggle data
			driver.toggleData();
		} else if (toggleLowerCase.equals("wifi")) {
			// Toggle Wi-Fi
			driver.toggleWifi();
		} else if (toggleLowerCase.equals("airplanemode")) {
			// Toggle airplane mode
			driver.toggleAirplaneMode();
		} else {
			// Log or throw an exception for unsupported toggle values
			System.out.println("Unsupported toggle value: " + Toggle);
			// Alternatively, throw an exception to indicate an error state
			// throw new IllegalArgumentException("Unsupported toggle value: " + toggle);
		}
	}

//-----------------------------------------------------------------------------------------------------------------------------------------//	

	public static String Random_String(int Length) {
		// Generate a random string consisting of alphabetic characters
		String randomString = RandomStringUtils.randomAlphabetic(Length);

		// Print the generated random string (optional, for debugging purposes)
		System.out.println(randomString);

		// Return the generated random string
		return randomString;
	}
//-----------------------------------------------------------------------------------------------------------------------------------------//

	// This method is use to generate random number

	public String Random_Number(int Digit) {
		// Create a Faker instance for generating random data
		Faker faker = new Faker();

		// Generate a random number with the specified number of digits
		String randomNumber = faker.number().digits(Digit);

		// Return the generated random number
		return randomNumber;
	}
//-----------------------------------------------------------------------------------------------------------------------------------------//

	// This method is used to generate a random email address

	public String Random_Email() {
		// Create a Faker instance for generating random data
		Faker faker = new Faker();

		// Generate a random email address
		String randomEmail = faker.internet().emailAddress();

		// Return the generated random email address
		return randomEmail;
	}
//-----------------------------------------------------------------------------------------------------------------------------------------//

	// This method is use to generate random names

	public String Random_Name(String Nametype) {
		// Create a Faker instance for generating random data
		Faker faker = new Faker();

		// Variable to store the generated name
		String generatedName = "";

		// Determine the name type and generate the corresponding name
		if (Nametype.equals("firstname")) {
			generatedName = faker.name().firstName();
		} else if (Nametype.equals("lastname")) {
			generatedName = faker.name().lastName();
		} else if (Nametype.equals("fullname")) {
			generatedName = faker.name().fullName();
		} else if (Nametype.equals("username")) {
			generatedName = faker.name().username();
		}
		// Return the generated name
		return generatedName;
	}

//-----------------------------------------------------------------------------------------------------------------------------------------//
	// This method is use to generate random Street Address

	public String Random_Address() {
		// Create a Faker instance for generating random data
		Faker faker = new Faker();

		// Generate a random street address
		String randomAddress = faker.address().streetAddress();

		// Return the generated random street address
		return randomAddress;
	}
//----------------------------------------------------------------------------------------------------------------------------//

	public void selectDropdownByValue(By by, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));

		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(value);
	}

//----------------------------------------------------------------------------------------------------------------------------//

	public void Scrollvertical(String axis, int startY, int endY) {
		int startX, endX;
		int screenHeight = driver.manage().window().getSize().height;
		int screenWidth = driver.manage().window().getSize().width;

		if (axis.equalsIgnoreCase("up")) {
			startX = screenWidth / 2;
			startY = (int) (screenHeight * 0.8);
			endX = screenWidth / 2;
			endY = (int) (screenHeight * 0.2);
		} else if (axis.equalsIgnoreCase("down")) {
			startX = screenWidth / 2;
			startY = (int) (screenHeight * 0.2);
			endX = screenWidth / 2;
			endY = (int) (screenHeight * 0.8);
		} else if (axis.equalsIgnoreCase("left")) {
			startX = (int) (screenWidth * 0.8);
			startY = screenHeight / 2;
			endX = (int) (screenWidth * 0.2);
			endY = screenHeight / 2;
		} else if (axis.equalsIgnoreCase("right")) {
			startX = (int) (screenWidth * 0.2);
			startY = screenHeight / 2;
			endX = (int) (screenWidth * 0.8);
			endY = screenHeight / 2;
		} else {
			throw new IllegalArgumentException("Invalid axis value. Please use 'up', 'down', 'left', or 'right'.");
		}

		// Create a new PointerInput object
		PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

		// Create a new sequence for the scroll action
		Sequence scrollAction = new Sequence(input, 0);

		// Add a move action to the sequence, starting from the starting point
		scrollAction.addAction(
				input.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));

		// Add a down action to the sequence, simulating the touch down on the screen
		scrollAction.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

		// Add a move action to the sequence, moving to the ending point
		// You can adjust the duration value to make the scroll faster or slower
		scrollAction.addAction(
				input.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));

		// Add an up action to the sequence, simulating the touch up on the screen
		scrollAction.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		// Perform the scroll action by executing the sequence
		driver.perform(Arrays.asList(scrollAction));
	}

//----------------------------------------------------------------------------------------------------------------------------//

	public void Scrollhorizontal(String axis, int startX, int startY, int endX, int endY) {

		if (axis.equalsIgnoreCase("left")) {

		} else if (axis.equalsIgnoreCase("right")) {

		} else {
			throw new IllegalArgumentException("Invalid axis value. Please use 'up', 'down', 'left', or 'right'.");
		}

		// Create a new PointerInput object
		PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

		// Create a new sequence for the scroll action
		Sequence scrollAction = new Sequence(input, 0);

		// Add a move action to the sequence, starting from the starting point
		scrollAction.addAction(
				input.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));

		// Add a down action to the sequence, simulating the touch down on the screen
		scrollAction.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

		// Add a move action to the sequence, moving to the ending point
		// You can adjust the duration value to make the scroll faster or slower
		scrollAction.addAction(
				input.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));

		// Add an up action to the sequence, simulating the touch up on the screen
		scrollAction.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		// Perform the scroll action by executing the sequence
		driver.perform(Arrays.asList(scrollAction));
	}

//----------------------------------------------------------------------------------------------------------------------------//

	public void scrollToElement(By locator) {
		// Get the size of the screen
		Dimension size = driver.manage().window().getSize();

		// Calculate start and end y coordinates
		int startY = (int) (size.height * 0.8);
		int endY = (int) (size.height * 0.2);

		// Find the element to scroll to
		WebElement element = driver.findElement(locator);

		// Scroll until the element is visible
		while (!element.isDisplayed()) {
			// Scroll from startY to endY
			driver.executeScript("mobile:scroll",
					ImmutableMap.of("direction", "down", "element", ((RemoteWebElement) element).getId()));

			// Wait for the scroll to complete
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

//----------------------------------------------------------------------------------------------------------------------------//

	public boolean isAppRunning(String bundleId) {
		return driver.isAppInstalled(bundleId);
	}

//----------------------------------------------------------------------------------------------------------------------------//
	public void handleAlerts(String alert) throws Exception {
		if (alert.equalsIgnoreCase("accept")) {
			driver.switchTo().alert().accept();
		} else

		if (alert.equalsIgnoreCase("dismiss")) {
			driver.switchTo().alert().dismiss();
		} else {
			throw new Exception("Invalid alert action: " + alert);
		}
	}
//----------------------------------------------------------------------------------------------------------------------------//

	public void lock_unlock_device(String device) {

		if (device.equalsIgnoreCase("lock")) {
			driver.lockDevice();
		} else if (device.equalsIgnoreCase("unlock")) {
			driver.unlockDevice();
		}
	}
//----------------------------------------------------------------------------------------------------------------------------//

	public void Close_App() {
		// Close the currently running app
		driver.close();
	}

//----------------------------------------------------------------------------------------------------------------------------//

	public void verifyElementTextEquals(By by, String expectedText) {
		WebElement element = driver.findElement(by);
		Assert.assertEquals(element.getText(), expectedText);
	}

//----------------------------------------------------------------------------------------------------------------------------//

	public boolean isElementPresent(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			return element.isEnabled();
		} catch (Exception e) {
			// Handle timeout exception if needed
			e.printStackTrace(); // Print the exception for debugging
		}

		return false;
	}

//----------------------------------------------------------------------------------------------------------------------------//

	public boolean isElementEnabled(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			return element.isEnabled();
		} catch (Exception e) {
			// Handle timeout exception if needed
			e.printStackTrace(); // Print the exception for debugging
		}

		return false;
	}

//----------------------------------------------------------------------------------------------------------------------------//	

	public boolean Is_Element_Clickable(By by) {
		// Create a WebDriverWait instance with a timeout of 10 seconds
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			// Wait until the element identified by the 'by' selector is clickable
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));

			// Check if the element is enabled
			return element.isEnabled();
		} catch (Exception e) {
			// Handle timeout exception if needed
			e.printStackTrace(); // Print the exception for debugging
		}

		// Return false if the element is not clickable within the timeout or if an
		// exception occurs
		return false;
	}

//----------------------------------------------------------------------------------------------------------------------------//

	// Performs a swipe gesture using the TouchAction API in Selenium.

	public void Swipe(int startX, int startY, int endX, int endY) {
		// Create a new touch input (finger)
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

		// Create a sequence of touch actions for the swipe
		Sequence swipe = new Sequence(finger, 1);

		// Move the finger to the starting position
		swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));

		// Press down the left mouse button (simulate touch down)
		swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

		// Add a pause to simulate a delay between touch down and touch move
		swipe.addAction(new Pause(finger, Duration.ofMillis(5)));

		// Move the finger to the ending position
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(5), PointerInput.Origin.viewport(), endX, endY));

		// Release the left mouse button (simulate touch up)
		swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		// Perform the swipe action using the WebDriver instance
		driver.perform(Arrays.asList(swipe));
	}
}
