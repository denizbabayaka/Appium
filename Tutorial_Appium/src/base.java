import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {

	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException

	{

		// we place the apk file and this method will bring the path
		File appDir = new File("src");
		File app = new File(appDir, "General-Store.apk");
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Deniz_device");

		cap.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));

		// This will bring the path of apk file
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		// this will bring the testing framework of uiautomator2
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		// we pass the capability object to that method so our driver can send codes
		// to our device and we pass the url
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		return driver;

	}

	/*
	 * 1-Basically what we did is we give "File" format to "ApiDemos-debug.apk" and
	 * establish "Desired capability"for our device. "Deniz_device" so we can send
	 * that file through our driver which we created as a AndroidDriver an we pass
	 * url of our server which sends to code to device and var "cap" which has got
	 * t7he capabilites of our device it like sending Header to API 2.driver will
	 * send this apk file to our device
	 */

}
