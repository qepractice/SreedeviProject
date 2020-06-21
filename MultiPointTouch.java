

package testcases;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class MultiPointTouch {
	public static AndroidDriver<WebElement> driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "android");

		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.the511plus.MultiTouchTester");

		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.the511plus.MultiTouchTester.MultiTouchTester");
		
		// Open the app.
		 driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Thread.sleep(3000);
		 
		 TouchAction action1 = new TouchAction(driver).tap(point(300, 175)).waitAction(waitOptions(Duration.ofMillis(250)));

		 TouchAction action2 = new TouchAction(driver).tap(point(500, 845)).waitAction(waitOptions(Duration.ofMillis(250)));

		 TouchAction action3 = new TouchAction(driver).tap(point(321, 205)).waitAction(waitOptions(Duration.ofMillis(250)));
		 
		 TouchAction action4 = new TouchAction(driver).tap(point(100, 175)).waitAction(waitOptions(Duration.ofMillis(250)));
		 
		 TouchAction action5 = new TouchAction(driver).tap(point(200, 175));

		 Thread.sleep(3000);
		 new MultiTouchAction(driver).add(action1).add(action2).add(action3).add(action4).add(action5).perform();;
		 
		 Thread.sleep(3000);
		 
		 driver.quit();
	}

}
