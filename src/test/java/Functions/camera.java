package Functions;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;


public class camera
{
	public static DesiredCapabilities dc= new DesiredCapabilities();
    public static AndroidDriver driver;

    @Test
	public void Camera1() throws InterruptedException, IOException
	{
        dc.setCapability("appium:automationName", "Appium");
		
		dc.setCapability("appium:platformName", "Android");
		
		dc.setCapability("appium:platformVersion", "9.0");	
		
		dc.setCapability("appium:deviceName", "Android Emulator");
		
        dc.setCapability("appium:appPackage", "com.android.camera2");
		
		dc.setCapability("appium:appActivity", "com.android.camera.CameraActivity");
	
		URL url=new URL("http://localhost:4723/wd/hub");
        driver =new AndroidDriver(url,dc);	
        Thread.sleep(2000);
		
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("com.android.camera2:id/confirm_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.android.camera2:id/three_dots")).click();
		
	    WebElement e=driver.findElement(By.id("com.android.camera2:id/countdown_toggle_button"));
	    
		    e.click();
	     	e.click();	
	     	e.click();
	     	
		driver.findElement(By.id("com.android.camera2:id/shutter_button")).click();// to click the photo
		Thread.sleep(2000);
		driver.findElement(By.id("com.android.camera2:id/rounded_thumbnail_view")).click();//to view the photo
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"More options\"]")).click();
		
		WebElement text =driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"));
		text.click();
		
	    List<WebElement> l=driver.findElements(By.id("android:id/text1"));
	    
	    System.out.println(l.size());
	    
	    TakesScreenshot screen=(TakesScreenshot)driver;
	    File SrcFile=screen.getScreenshotAs(OutputType.FILE);
	    
	    File DestFile=new File("/home/niveus/Music/Niv/Screenshots/details.jpg");

	    //Copy file at destination

	    FileUtils.copyFile(SrcFile, DestFile);
	    
		for(int j=1;j<=l.size();j++)
		{
		String s=driver.findElement(By.xpath("(/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView["+j+"])")).getText();

		Thread.sleep(1000);
		
	    System.out.println(s);
		}
		
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/button1")).click();//close the details
	//
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();//to navigate back
		Thread.sleep(10000);
		driver.quit();
    }
}