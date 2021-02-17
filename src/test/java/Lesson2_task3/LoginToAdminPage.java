package Lesson2_task3;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginToAdminPage {
    private WebDriver driver;
    private WebDriver wait;

    @Before
    public void start(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void LoginAdminPage(){
//        driver.get("http://localhost:9080/litecart/litecart-2.2.3.6/public_html/admin/login.php");    //my actual url
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@name=\"login\"]")).click();

        System.out.println(driver.getTitle());

    }
}
