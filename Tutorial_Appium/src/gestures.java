import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.offset.ElementOption.element;


public class gestures extends base  {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		
		//Tap  ==> this method is for tapping the elements in mobile 
		TouchAction t =new TouchAction(driver);
		
		WebElement expandList=driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");

		// we pass the element to that method and we tap this element instead of click option  
		t.tap(tapOptions().withElement(element(expandList))).perform();
		driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
		
		
		WebElement expandList1=driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		// this method will go this element and will long press for 2 seconds 
		t.longPress(longPressOptions().withElement(element(expandList1)).withDuration(ofSeconds(2))).release().perform();
		
		//Thread.sleep(2000);
		System.out.println(driver.findElementById("android:id/title").isDisplayed());
				

		
	
        
	}

}
