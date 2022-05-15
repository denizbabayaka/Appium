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

public class ecommerce_tc_3 extends base {

	public static void main(String[] args) throws MalformedURLException {

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
		
        //This method will store all the products as a list of element and scroll down 
		// till the matching element 
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));

		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        
		//Iterate through each every product name den z
		for (int i = 0; i < count; i++)

		{

			String text = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            
			System.out.println(text);
			if (text.equalsIgnoreCase("Jordan 6 Rings"))

			{

				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();

				break;

			}

		}

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		String lastpageText = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();

		Assert.assertEquals("Jordan 6 Rings", lastpageText);

	}
}