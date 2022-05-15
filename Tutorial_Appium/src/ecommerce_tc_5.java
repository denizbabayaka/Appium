import static java.time.Duration.ofSeconds;
import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;

public class ecommerce_tc_5 extends base {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
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

		// since there is more than 1 product we use findElements and get the product
		// based on index number
		// but after clicking index comes to beginning so we have to write 0 for the
		// second element
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));

		TouchAction t = new TouchAction(driver);
		// Tap our checkbox
		t.tap(tapOptions().withElement(element(checkbox))).perform();

		WebElement expandList1 = driver.findElementByXPath("//*[@text='Please read our terms of conditions']");

		// this method will go this element and will long press for 2 seconds
		t.longPress(longPressOptions().withElement(element(expandList1)).withDuration(ofSeconds(2))).release()
				.perform();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

		Thread.sleep(7000);

		// This code for channging from NATIVE APP to
		// WEBVIEW_com.androidsample.generalstore
		// so we can use selenium full capabilities for this APP in browser view

		Set<String> contexts = driver.getContextHandles();
		for (String contextName : contexts) {
			System.out.println(contextName); // prints out something like NATIVE APP \n WEBVIEW1
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");

		// Now context changed to chromedriver
		driver.findElement(By.name("q")).sendKeys("Deniz Babayaka");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		// now context changed to android native app
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		// and we can continue validations with native app
		driver.context("NATIVE_APP"); 

	}
}
