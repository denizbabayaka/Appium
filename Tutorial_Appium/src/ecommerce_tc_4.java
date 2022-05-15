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
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;

public class ecommerce_tc_4 extends base {

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
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(4000);
		String amount = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
		String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		// This will remove the $ sign from the string which is at the first index
//		amount = amount.substring(1);
//		amount1 = amount1.substring(1);
//
//		// This will convert to string to decimal type of double
//		double amount_new = Double.parseDouble(amount);
//		double amount_new1 = Double.parseDouble(amount1);
		
		double amount_new=getAmountString(amount);
		double amount_new1=getAmountString(amount1);
		double  total = amount_new + amount_new1;

		System.out.println("Total sum of products :" + total);
		String total_real = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
//		total_real = total_real.substring(1);
//		double total_realnew = Double.parseDouble(total_real);
		
		double total_real_new=getAmountString(total_real);
		System.out.println("Total sum of app   :" + total_real);

		Assert.assertEquals(total, total_real_new);

	}
	public static    double  getAmountString (String value) {
		
		value= value.substring(1);
		double amount2value=Double.parseDouble(value);
		
		return amount2value;
	}
	
}
