import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class basics extends base{
	
	
	public static void main(String[] args) throws MalformedURLException {
		
		
		AndroidDriver<AndroidElement>driver=capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		/*
		   when locating element we mostly use xpath.id,lassName, androidUIautomator
		   xpath Syntax  
		   //tagname[@attribute='value']
		 */
	      
		// in UI automation-viewer class name is at the same time tag name  
		  driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
		  driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		  driver.findElement(By.id("android:id/checkbox")).click();
		  //if there is same tagname and no specific identifier we use index we just write tag and index number 
		  driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		  //driver.findElement(By.id("android:id/edit"));
		  driver.findElementByClassName("android.widget.EditText").sendKeys("Deniz Babayaka");
		  driver.findElementsByClassName("android.widget.Button").get(1).click();


		  
		  
		  

		
		
		
		
		
	}

}
