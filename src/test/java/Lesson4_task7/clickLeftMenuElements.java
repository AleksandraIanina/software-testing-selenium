package Lesson4_task7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class clickLeftMenuElements {
    private WebDriver driver;
    private WebDriver wait;

    @Before
    public void start(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void LeftMenuElements(){
//        driver.get("http://localhost:9080/litecart/litecart-2.2.3.6/public_html/admin/login.php");    //my actual url
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@name=\"login\"]")).click();


        By panelLocator = By.xpath("//div[@id='sidebar']//ul[@id='box-apps-menu']//li");
        By subPanelLocator = By.xpath("//li//span");

        List<WebElement> listOfMenuPanels = driver.findElements(panelLocator);

        for (int i = 0; i < listOfMenuPanels.size(); i++) {
            WebElement panel = getElementWithIndex(subPanelLocator, i);
            panel.click();
            assertTrue(isElementPresent(driver, By.xpath("//main//div[@class='panel-heading']")));
        }

    }
    private WebElement getElementWithIndex(By by, int indx) {
        return driver.findElements(by).get(indx);
    }

    boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
