package homework.at_project.tests.junit4;

import homework.at_project.driver.Driver;
import homework.at_project.pages.booking_pages.HomePage;
import homework.at_project.pages.booking_pages.SignInPage;
import homework.at_project.pages.tempmail_pages.MainPage;
import homework.at_project.utils.ActionsUtil;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class BookingRegistrationTest {

    HomePage bookingHomePage = new HomePage();
    MainPage tempmail = new MainPage();
    SignInPage bookingSignInPage = new SignInPage();
    ActionsUtil actions = new ActionsUtil();

    public static final Logger LOGGER = Logger.getLogger(BookingRegistrationTest.class.getName());
    WebDriver driver = Driver.getWebDriver();

    @Before
    public void beforeTest() {
        tempmail.getUrl();
        tempmail.getEmail();
        LOGGER.info("The booking registration junit Before method is started");
    }

    @After
    public void afterTest() {
        LOGGER.info("The booking registration junit After method is finished");
    }

    @Test
    public void registerTest() {
        actions.openNewTab();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        bookingHomePage.getUrl();
        bookingHomePage.skipSignInOffer();
        bookingHomePage.clickRegister();
        actions.selectingPaste();
        bookingSignInPage.clickSubmit();
        bookingSignInPage.enterPassword("Lalala123456!");
        actions.clickAndHold(bookingSignInPage.getCaptcha());
        LOGGER.debug("Test 'registerTest' is executed");
    }

}
