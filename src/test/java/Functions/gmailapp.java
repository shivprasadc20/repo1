package Functions;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class gmailapp {
	public static DesiredCapabilities dc= new DesiredCapabilities();
    public static AndroidDriver driver;

    @Test
	public void gmail() throws InterruptedException, IOException
	{
        dc.setCapability("appium:automationName", "Appium");
		
		dc.setCapability("appium:platformName", "Android Emulator");
		
		dc.setCapability("appium:platformVersion", "9.0");	
		
		dc.setCapability("appium:deviceName", "Google Pixel 6 Pro");
		
        dc.setCapability("appium:appPackage", "com.google.android.gm");
		
		dc.setCapability("appium:appActivity", "org.chromium.chrome.browser.firstrun.FirstRunActivity");
	
		URL url=new URL("http://localhost:4723/");
		
        driver =new AndroidDriver(url,dc);	

}}
