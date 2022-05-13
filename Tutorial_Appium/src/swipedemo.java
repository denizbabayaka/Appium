import static java.time.Duration.ofSeconds;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import io.appium.java_client.TouchAction;

public class swipedemo extends base {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
		// driver.findElementByXPath("//android.widget.TextView[@text=' 2.
		// Inline']").click();
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();

		// start means go and find any attribute value which match ==>
		// [@content-desc-'9']
		// we use star as a tag name because at class name some letters which Appium
		// does not support
		driver.findElementByXPath("//*[@content-desc='9']").click();

		TouchAction t = new TouchAction(driver);
		WebElement first = driver.findElementByXPath("//*[@content-desc='15']");
		WebElement second= driver.findElementByXPath("//*[@content-desc='45']");


		// long press //on element/I2sec// move to another element and you release
		t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2)))
		            .moveTo(element(second)).release().perform();

	}
}