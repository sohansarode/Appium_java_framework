package Base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Utilities extends Common_Methods {

	public static String Filepath;

//----------------------------------------------------------------------------------------------------------------------------//
	// This method is use to take screenshot of failed test

	protected static String Capture_Screenshot() {
		// Generate a timestamp for the screenshot filename
		String datename = new SimpleDateFormat("yyyyMMdd hhmmss").format(new Date());

		// Create a TakesScreenshot instance
		TakesScreenshot scrshot = ((TakesScreenshot) driver);

		// Capture the screenshot as a file
		File srcfile = scrshot.getScreenshotAs(OutputType.FILE);

		// Specify the destination path for the screenshot
		String destinationpath = Filepath + "/" + datename + ".png";
		File destfile = new File(destinationpath);

		try {
			// Copy the captured screenshot file to the destination path
			FileUtils.copyFile(srcfile, destfile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Return the filename of the captured screenshot
		return datename + ".png";
	}
//----------------------------------------------------------------------------------------------------------//

}
