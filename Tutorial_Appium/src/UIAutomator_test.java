import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UIAutomator_test extends base {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// we just write "(attribute(\"value\")" to find a locator inside the double
		// qoute
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();

		// Validate clickable feature for all options
		// method for selecting elements with properties==>("new Uiselector().property(value)");
		
        // we are finding size of elements which is has true clickable property 
		System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());
	}

}
