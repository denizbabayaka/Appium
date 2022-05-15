import static java.time.Duration.ofSeconds;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import io.appium.java_client.TouchAction;

public class ecommerce_tc_1 extends base {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		// This method will hide keyboard
		driver.hideKeyboard();
		driver.findElementByXPath("//*[@text='Female']").click();
		driver.findElement(By.id("android:id/text1")).click();

		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		/*
		 * //if line 27 do not work use this code
		 * driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new
		 * UiSelector().scrollable(true).instance(0)) .scrollIntoView(new
		 * UiSelector().textMatches(\"" + containedText + "\").instance(0))"));
		 */

		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		// Toast message always with this tag we can write xpath just giving its tag
		// name and index number
		// and we get the message with attribute method
		String toast_message = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		// in case of negative scenario which we do not provide name will print the
		// error message
		// comment -on line 21
		System.out.println(toast_message);
		Assert.assertEquals("Please enter your name", toast_message);


	}
}