package homework.at_project.tests.testng;

import homework.at_project.driver.Driver;
import homework.at_project.objects.demoqa_objects.SelectMenuItems;
import homework.at_project.pages.demoqa_pages.SelectMenu;
import org.apache.log4j.Logger;
import org.testng.annotations.*;


public class DemoQATestNGTests {

    SelectMenu selectMenu = new SelectMenu();
    SelectMenuItems selectMenuItems = new SelectMenuItems();

    public static final Logger LOGGER = Logger.getLogger(DemoQATestNGTests.class.getName());

    @BeforeMethod
    public void beforeTests() {
        LOGGER.info("The demoQA testNG Before method is started");
        Driver.getWebDriver();
        LOGGER.info("The demoQA testNG Before method is finished");
    }

    @AfterMethod
    public void afterTests() {
        LOGGER.info("The demoQA testNG After method is started");
        Driver.closeDriver();
        LOGGER.info("The demoQA testNG After method is finished");
    }

    @Test
    public void selectTest() {
        selectMenu.getUrlToSelectMenu();
        selectMenu.clickSelectValueDropdown();
        selectMenuItems.selectGroup1Option1OfSelectValue();
        selectMenu.clickSelectOneDropdown();
        selectMenuItems.selectDrOfSelectOne();
        selectMenuItems.selectBlueOfOldStyleSelectMenu();
        selectMenu.clickMultiSelectDropdown();
        selectMenuItems.selectGreenOfMultiSelectDropdown();
        selectMenuItems.selectAudiOfStandardMultiSelect();
        LOGGER.debug("Test 'selectTest' is executed");
    }

}
