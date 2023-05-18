package homework.day21.tests;

import homework.day21.steps.SearchSteps;
import homework.day21.utils.Parser;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

public class SearchTests {

    public static final Logger LOGGER = Logger.getLogger(SearchTests.class.getName());
    SearchSteps steps = new SearchSteps();
    Parser myParser = new Parser();

    @Before
    public void beforeSearchTests() {
        LOGGER.info("The search before method is started");
    }

    @After
    public void afterSearchTests() {
        LOGGER.info("The search after method is finished");
    }

    @Test
    public void fullShortNameTest() throws FileNotFoundException {
        LOGGER.debug("fullShortNameTest test is started");
        steps.sendRequest("b", true);
        Assert.assertEquals(myParser.fromJSONtoUsersList("empty_list"), steps.response);
    }

    @Test
    public void fullLongNameTest() throws FileNotFoundException {
        LOGGER.debug("fullLongNameTest test is started");
        steps.sendRequest("berta", true);
        Assert.assertEquals(myParser.fromJSONtoUsersList("user_berta"), steps.response);
    }

    @Test
    public void partShortNameTest() throws FileNotFoundException {
        LOGGER.debug("partShortNameTest test is started");
        steps.sendRequest("b", false);
        Assert.assertEquals(myParser.fromJSONtoUsersList("user_berta"), steps.response);
    }

    @Test
    public void partLongNameTest() throws FileNotFoundException {
        LOGGER.debug("partLongNameTest test is started");
        steps.sendRequest("berta", false);
        Assert.assertEquals(myParser.fromJSONtoUsersList("user_berta"), steps.response);
    }

    @Test
    public void allUsersTest() throws FileNotFoundException {
        LOGGER.debug("allUsersTest test is started");
        steps.sendRequest("", true);
        Assert.assertEquals(myParser.fromJSONtoUsersList("all_users"), steps.response);
    }

}
