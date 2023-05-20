package classwork.day22;

import homework.day21.tests.SearchTests;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class Day22Tests {

    public static final Logger LOGGER = Logger.getLogger(SearchTests.class.getName());


    @Test
    @TestCaseId(id = "156378")
    public void firstTest() {
        LOGGER.info("Executing first test");
        int result = 2 + 5;
        Assert.assertEquals(7, result);
    }

    @Test
    @TestCaseId(id = "156380")
    public void secondTest() {
        LOGGER.info("Executing second test");
        int result = 4 + 5;
        Assert.assertEquals(9, result);
    }

    @Test
    @TestCaseId(id = "156382")
    public void thirdTest() {
        LOGGER.info("Executing third test");
        int result = 2 + 0;
        Assert.assertEquals(2, result);
    }

    @Test
    @TestCaseId(id = "156383")
    public void fourthTest() {
        LOGGER.info("Executing fourth test");
        int result = 2 + 1;
        Assert.assertEquals(7, result);
    }

}
