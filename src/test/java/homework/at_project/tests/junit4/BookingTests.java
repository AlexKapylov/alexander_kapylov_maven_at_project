package homework.at_project.tests.junit4;

import homework.at_project.driver.Driver;
import homework.at_project.pages.booking_pages.HomePage;
import homework.at_project.pages.booking_pages.HotelPage;
import homework.at_project.pages.booking_pages.ResultsPage;
import org.apache.log4j.Logger;
import org.junit.*;

import homework.at_project.utils.DateUtil;
import homework.at_project.utils.ActionsUtil;


public class BookingTests {

    HomePage bookingHomePage = new HomePage();
    ResultsPage bookingResultsPage = new ResultsPage();
    HotelPage bookingHotelPage = new HotelPage();

    DateUtil date = new DateUtil();
    ActionsUtil actions = new ActionsUtil();

    public static final Logger LOGGER = Logger.getLogger(BookingTests.class.getName());


    @Before
    public void beforeTests() {
        Driver.getWebDriver();
        LOGGER.info("The booking junit Before method is started");
    }

    @After
    public void afterTests() {
        Driver.closeDriver();
        LOGGER.info("The booking junit After method is finished");
    }

    @Test
    public void pricePerNightTest() {
        bookingHomePage.getUrl();
        bookingHomePage.skipSignInOffer();
        bookingHomePage.selectingPlace("Париж");
        bookingHomePage.selectingDate(date.setDay(3));
        bookingHomePage.selectingDate(date.setDay(10));
        bookingHomePage.clickOnOccupancyDropdown();
        bookingHomePage.clickOnTheAdults();
        bookingHomePage.clickOnTheAdults();
        bookingHomePage.clickOnTheApartments();
        bookingHomePage.clickOnTheSubmit();
        bookingResultsPage.clickOnTheMaxPricePerNight();
        bookingResultsPage.waitForSpinner();
        bookingResultsPage.clickOnTheSortDropdown();
        bookingResultsPage.clickOnThePriceSorting();
        bookingResultsPage.assertPricePerNight();
        LOGGER.debug("Test 'pricePerNightTest' is executed");
    }

    @Test
    public void colorsTest() {
        bookingHomePage.getUrl();
        bookingHomePage.skipSignInOffer();
        bookingHomePage.selectingPlace("Париж");
        bookingHomePage.selectingDate(date.setDay(3));
        bookingHomePage.selectingDate(date.setDay(10));
        bookingHomePage.clickOnTheSubmit();
        actions.scrollToElement(bookingResultsPage.findHotel(10));
        actions.changeElementBackground(bookingResultsPage.findHotel(10));
        actions.changeElementTextColor(bookingResultsPage.findHotelTitle(10));
        Assert.assertEquals("The text color isn't red", "color: red;", bookingResultsPage.findHotelTitle(10).getAttribute("style"));
        LOGGER.debug("Test 'colorsTest' is executed");
    }

    @Test
    public void hotelAvailabilityTest() {
        bookingHomePage.getUrl();
        bookingHomePage.skipSignInOffer();
        bookingHomePage.selectingPlace("Париж");
        bookingHomePage.selectingDate(date.setDay(3));
        bookingHomePage.selectingDate(date.setDay(10));
        bookingHomePage.clickOnTheSubmit();
        Assert.assertTrue("There are no hotels", bookingResultsPage.findHotels().size() > 0);
        LOGGER.debug("Test 'hotelAvailabilityTest' is executed");
    }

    @Test
    public void hotelRatingTest() {
        bookingHomePage.getUrl();
        bookingHomePage.skipSignInOffer();
        bookingHomePage.selectingPlace("Париж");
        bookingHomePage.selectingDate(date.setDay(3));
        bookingHomePage.selectingDate(date.setDay(10));
        bookingHomePage.clickOnTheSubmit();
        bookingResultsPage.clickOnTheMaxRating();
        bookingResultsPage.waitForSpinner();
        int rating = bookingResultsPage.getNumberOfMaxRating();
        bookingResultsPage.openFirstHotelUrl();
        Assert.assertTrue("The hotel rating is less than 9",
                bookingHotelPage.getNumberOfHotelRating() >= rating
        );
        LOGGER.debug("Test 'hotelRatingTest' is executed");
    }

    @Test
    public void currencyTest() {
        bookingHomePage.getUrl();
        bookingHomePage.skipSignInOffer();
        actions.hoverElement(bookingHomePage.findCurrency());
        String tooltip = bookingHomePage.getCurrencyTooltip();
        Assert.assertEquals("There is an incorrect tooltip", "Выберите валюту", tooltip);
        LOGGER.debug("Test 'currencyTest' is executed");
    }

    @Test
    public void languageTest() {
        bookingHomePage.getUrl();
        bookingHomePage.skipSignInOffer();
        actions.hoverElement(bookingHomePage.findLanguage());
        String tooltip = bookingHomePage.getLanguageTooltip();
        Assert.assertEquals("There is an incorrect tooltip", "Выберите язык", tooltip);
        LOGGER.debug("Test 'languageTest' is executed");
    }

}
