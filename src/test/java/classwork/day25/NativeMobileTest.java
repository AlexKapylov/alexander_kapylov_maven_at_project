package classwork.day25;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class NativeMobileTest {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
        caps.setCapability("appPackage", "com.google.android.deskclock");
        caps.setCapability("appActivity", "com.android.deskclock.DeskClock");

        AndroidDriver driver =
                new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);

        Thread.sleep(3000);
        driver.quit();
    }

}
