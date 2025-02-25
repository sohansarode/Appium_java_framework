package Base;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.logging.log4j.*;

public class Read_Property {

	public static Properties prop;
	public static Logger logger;

//----------------------------------------------------------------------------------------------------------//
	// This method is use to Read properties from property file
	protected void Readpropertyfile() {

		logger = LogManager.getLogger(Read_Property.class);

		String path = "C:\\Eclipse\\mobileframework\\src\\test\\resources\\config.properties";
		try {
			prop = new Properties();
			prop.load(new FileInputStream(path));

		} catch (Exception E) {
			System.out.println("Not able to read property file");
		}
	}
	
//----------------------------------------------------------------------------------------------------------------------------//
}
