package Lesson3_Capabilities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CapabilitiesCheck {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--user-data-dir=C:\\Users\\alianina\\AppData\\Local\\Google\\Chrome\\User Data");
////        options.addArguments("user-data-dir=C:/Users/alianina/AppData/Local/Google/Chrome/User Data/");
//        options.addArguments("profile-directory=Default");

//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("unexpectedAlertBehaviour", "dismiss");

//        String userProfile= "C:\\Users\\alianina\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
//        ChromeOptions options1 = new ChromeOptions();
//        options1.addArguments("user-data-dir="+userProfile);
//        options1.addArguments("--start-maximized");
//        WebDriver driver = new ChromeDriver(options1);

        driver = new ChromeDriver();
        driver.manage().addCookie(new Cookie("NID", "210=oxUM00GXuMLuByeKzeZz-1FT8AJKZS4F6rtNjoEmpnpB9uhqA9syTBIVQJ5WfmsNstfiJNT463eU2oG9Y_VT8kuIiNGoTQRnLp1fEV61QuP-qj4mzCGB4VqqK2XJV6TV5-eLeSw_idgKD9xsnb1l6HIMY9VDPkpjQ_RO59BQboadxrIotav4cSY-yNWG9Aya5YJFOyQU2Ywa7UO3Fo3sOxheJ2dX7xVdjAK0cJDhFc8NEy0iojB1"));




//        System.out.println(((HasCapabilities) driver).getCapabilities());


        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void myFirstTest() {
        driver.get("http://google.com/");

        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnK")).click();
        System.out.println(driver.getTitle());
//        wait.until(titleIs("webdriver - Поиск в Google"));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
