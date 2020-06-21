package testcases;

import java.awt.List;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class DragAndDrop {
	public static AndroidDriver<MobileElement> driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException{
		// TODO Auto-generated method stub
DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("device", "Android");
		capabilities.setCapability("deviceName", "Nexus_AVD");
		capabilities.setCapability("platformVersion", "8.1.0");
		capabilities.setCapability("platformName", "Android");
		
		capabilities.setCapability("appPackage", "com.mobeta.android.demodslv");
		capabilities.setCapability("appActivity", "com.mobeta.android.demodslv.Launcher");
		
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		System.out.println(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

		driver.findElements(By.id("com.mobeta.android.demodslv:id/activity_title")).get(0).click();
		MobileElement firstelement = driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle")).get(0);
		MobileElement fifthelement = driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle")).get(4);
		TouchAction action = new TouchAction(driver);
		action.press(ElementOption.element(firstelement)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(ElementOption.element(fifthelement)).release().perform();
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

}
