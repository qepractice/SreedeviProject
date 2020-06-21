package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestWebBrowser {
	
	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
	//Set the capabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("chromedriverExecutable", "C:/Users/srchintalapati/Documents/Sree/Selenium/Chrome Driver/chromedriver.exe");
		
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_AVD");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		System.out.println(driver);
		
		//Opening Amazon site
		
		driver.get("http://amazon.com");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByName("k").sendKeys("Appium book");
		
		driver.findElementByXPath("//*[@id=\"nav-search-form\"]/div[2]/div/input").click();		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		ScrollUtil.scrollToElement(By.xpath("//*[@id=\"search\"]/span[3]/div[2]/div[12]/div/span/div/div/div/div/div[1]/div/div/a/div[1]/h2"), driver).click();
		
		driver.findElementByXPath("//*[@id=\"acrCustomerReviewLink\"]/i").click();
		
		String Rating = driver.findElementByXPath("//*[@id=\"aw-udpv3-customer-reviews_feature_div\"]/span[1]/div/div/a/div/div/div[1]/span").getText();
		
		System.out.println("Rating of the 10th Appium Book is: " +Rating);
		
		driver.navigate().back();
		
		driver.findElementByXPath("//*[@id=\"add-to-cart-button\"]").click();
		
		driver.findElementByXPath("//*[@id=\"nav-search-keywords\"]").clear();
		
		driver.findElementByXPath("//*[@id=\"nav-search-keywords\"]").sendKeys("Selenium book");
		
		driver.findElementByXPath("//*[@id=\"nav-search-form\"]/div[2]/div/input").click();
		
		ScrollUtil.scrollToElement(By.xpath("//*[@id=\"search\"]/span[3]/div[2]/div[6]/div/span/div/div/div[1]/div/div/a/div[1]/h2/span" + 
				""), driver).click();
		
		driver.findElementByXPath("//*[@id=\"add-to-cart-button\"]").click();
		
		String Price = driver.findElementByXPath("//*[@id=\"sc-proceed-to-checkout-params-form\"]/div[1]/span[2]/span").getText();
		
		System.out.println("Total price of both books: " +Price);
		
		driver.close();
		
		driver.quit();
	}

}
