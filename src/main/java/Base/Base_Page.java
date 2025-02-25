package Base;

import java.io.File;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.SessionNotCreatedException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base_Page extends Read_Property {

	public static AndroidDriver driver;
	static AppiumDriverLocalService service;
	AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();

	// Initializes and starts the Appium server as part of the test suite setup.
	@BeforeSuite
	public void Start_Appium() {
		// Specify the path to the Appium server executable (main.js)
		File appiumJS = new File(
				"C:\\Users\\sohan\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");

		// Specify the IP address and port for the Appium server
		String ipAddress = "192.168.75.10";
		int port = 4723;

		// Create an instance of AppiumDriverLocalService with the specified
		// configuration
		service = new AppiumServiceBuilder().withAppiumJS(appiumJS).withIPAddress(ipAddress).usingPort(port).build();

		// Start the Appium server
		service.start();
	}

	// Setup method executed before the test class to initialize the AndroidDriver
	// with UiAutomator2 capabilities.
	@BeforeClass
	public void setupDriver() throws MalformedURLException, ConnectException {
		try {
			// Create UiAutomator2Options for configuring the AndroidDriver
			UiAutomator2Options options = new UiAutomator2Options();

			// Set capabilities for the AndroidDriver
			options.setCapability("ANDROID_HOME", "C:\\Users\\sohan\\AppData\\Local\\Android\\Sdk");
			options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
			options.setPlatformName("Android");
			options.setDeviceName("Pixel 4a");
			options.setUdid("emulator-5554");
			options.setCapability("appium-plugins",
					"images,appium-dashboard,appium-reporter-plugin,element-wait,execute-driver,universal-xml");

			// Connect to Appium server
			// options.setPlatformVersion("9");
			options.setAppPackage("com.android.chrome");
			options.setAppActivity("com.google.android.apps.chrome.Main");

			// Create AndroidDriver instance with the specified URL and options
			// Note: Ensure that the Appium server is running at http://192.168.1.132:4729
			// before executing this test.
			driver = new AndroidDriver(new URL("http://192.168.75.10:4723"), options);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (SessionNotCreatedException e) {
			e.printStackTrace();
		}
	}

	// Stop the Appium server after the test suite execution.
	@AfterSuite
	public void CloseService() {
		 service.stop(); // Stops the Appium server
	}
}
