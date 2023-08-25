package Functions;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class f1 {
	public static DesiredCapabilities dc= new DesiredCapabilities();
    public static AndroidDriver driver;

    @Test
	public void gmail() throws InterruptedException, IOException
	{
        dc.setCapability("appium:automationName", "Appium");
		
		dc.setCapability("appium:platformName", "Android");
		
		dc.setCapability("appium:platformVersion", "9.0");	
		
		dc.setCapability("appium:deviceName", "Android Emulator");
		dc.setCapability("appium:app","/home/niveus/Downloads/2.0.104-UAT.apk");
		dc.setCapability(AndroidMobileCapabilityType.ADB_EXEC_TIMEOUT, 800000);
		dc.setCapability(AndroidMobileCapabilityType.ANDROID_DEVICE_READY_TIMEOUT, 800000);
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
        driver =new AndroidDriver(url,dc);	
        
}
}