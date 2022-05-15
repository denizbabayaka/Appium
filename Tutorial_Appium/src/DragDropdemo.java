import static java.time.Duration.ofSeconds;
import java.net.MalformedURLException;
import java.time.temporal.TemporalAmount;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.TouchAction;

public class DragDropdemo extends base  {
	
	
	

		public static void main(String[] args) throws MalformedURLException {

			AndroidDriver<AndroidElement> driver = capabilities();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
            
			driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
			
			TouchAction t = new TouchAction(driver);
			
	
			WebElement source= driver.findElementsByClassName("android.view.View").get(0);
			WebElement destination=driver.findElementsByClassName("android.view.View").get(1);


			// long press (source)/move(destination)//release 
			t.longPress(longPressOptions().withElement(element(source))).moveTo(element(destination)).release().perform();
}
	}
