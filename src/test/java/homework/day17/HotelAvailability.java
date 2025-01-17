package homework.day17;

import homework.at_project.driver.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HotelAvailability {

    WebDriver driver = Driver.getWebDriver();

    @Before
    public void beforeTests() {
        Driver.setTimeOuts(10,10,10);
    }

    @After
    public void afterTests() {
        driver.quit();
    }

    @Test
    public void hotelAvailabilityTest() {
        driver.get("https://booking.com");
        driver.findElement(By.xpath("//div[@role='dialog'][@aria-modal='true']//button")).click();
        driver.findElement(By.cssSelector("[name='ss']")).sendKeys("Париж");
        driver.findElement(By.xpath("//*[@data-testid='autocomplete-result']/div/div[text()='Париж']")).click();
        driver.findElement(By.cssSelector("[data-date='2023-05-15']")).click();
        driver.findElement(By.cssSelector("[data-date='2023-05-21']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertTrue("There are no hotels", driver.findElements(By.cssSelector("[data-testid='property-card']")).size() > 0);
    }

}
