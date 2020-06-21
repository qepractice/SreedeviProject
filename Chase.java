package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Chase {
	
	public static AndroidDriver driver;
	
	public static void main(String[] args)throws MalformedURLException {
		// TODO Auto-generated method stub
		//Set the capabilities
				DesiredCapabilities capabilities = new DesiredCapabilities();
				
				capabilities.setCapability("chromedriverExecutable", "C:/Users/srchintalapati/Documents/Sree/Selenium/Chrome Driver/chromedriver.exe");
				
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
				
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_AVD");
				
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				
				System.out.println(driver);
				
				//Opening Chase Site
				driver.get("http://chase.com");
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driver.findElementByXPath("//*[@id=\"skip-sidemenu\"]").click();
				
				ScrollUtil.scrollToElement(By.xpath("//*[@id=\"side-menu-header\"]/div[5]/div[2]/ul/li[1]/a" + 
			    ""), driver).click();
				
				ScrollUtil.scrollToElement(By.xpath("//*[@id=\"SubHeaderOriginal\"]/ul/li[2]/a" + 
					    ""), driver).click();
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//driver.findElementByXPath("//*[@id="popular"]/div[2]/div/div/div/div[2]/div/div/div/div/div/ul/li[8]/a").click();
				
				driver.navigate().back();
				
				driver.findElementByXPath("//*[@id=\"skip-sidemenu\"]").click();
				
				ScrollUtil.scrollToElement(By.xpath("//*[@id=\"side-menu-header\"]/div[5]/div[2]/ul/li[2]/a" + 
					    ""), driver).click();
				
				
				//driver.findElementByXPath("//*[@name="overall"]").click();
				
				driver.navigate().back();
				
				//driver.findElementByXPath("/html/body/div/div[4]/header/div[4]/div[3]/ul/li[3]/a").click();
				
				driver.close();
				driver.quit();
			}
	}


