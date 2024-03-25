import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ConnectionString {
    AppiumDriver driver;
    @BeforeTest
    public void initializer() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("avdLaunchTimeout", 200000);
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("app", System.getProperty("user.dir") + "/app/ApiDemos-debug.apk");
        capabilities.setCapability("noReset", true);
        driver = new AndroidDriver(new URL("http://localhost:4723"), capabilities);
        System.out.println("Opening Appium Server");
    }
    @Test
    public void sampleTest(){
        System.out.print("This is a 1st Sample Test");
    }
    @AfterTest
    public void teaDown(){
        driver.quit();
    }

}
