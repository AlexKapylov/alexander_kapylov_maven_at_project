package homework.at_project.tests.testng;

import homework.at_project.driver.Driver;
import homework.at_project.pages.google_pages.MainPage;
import homework.at_project.pages.www_w3schools_pages.Java;
import homework.at_project.utils.ActionsUtil;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class W3SchoolsTestNGTests {

    Java w3schools = new Java();
    ActionsUtil actions = new ActionsUtil();
    MainPage google = new MainPage();

    public static final Logger LOGGER = Logger.getLogger(W3SchoolsTestNGTests.class.getName());


    @BeforeMethod
    public void beforeTests() {
        Driver.getWebDriver();
        LOGGER.info("The w3schools testNG Before method is started");
    }

    @AfterMethod
    public void afterTests() {
        Driver.closeDriver();
        LOGGER.info("The w3schools testNG After method is finished");
    }

    @Test
    public void tutorialTest() {
        w3schools.getJavaUrl();
        actions.selectingCopyElement(w3schools.findTutorial());
        google.getUrl();
        actions.selectingPasteElement(google.findSearchField());
        Assert.assertEquals(google.displayedResultsCountContainsTutorial(), google.displayedResultsCount().size(), "Some links don't contain the 'Tutorial' word");
        LOGGER.debug("Test 'tutorialTest' is executed");
    }

}
