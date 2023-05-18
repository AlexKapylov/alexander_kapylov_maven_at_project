package homework.day21.steps;

import homework.day21.objects.SearchUser;
import homework.day21.objects.Specification;
import homework.day21.objects.UsersList;
import homework.day21.tests.SearchTests;
import io.restassured.RestAssured;
import org.apache.log4j.Logger;

public class SearchSteps {

    public static final Logger LOGGER = Logger.getLogger(SearchTests.class.getName());
    Specification mySpecification = new Specification();
    public UsersList response;

    public void sendRequest(String user, boolean strict) {
        response = RestAssured
                .given()
                .spec(mySpecification.getSpecification("http://178.124.206.46:8001/app/ws/"))
                .body(new SearchUser(user, strict))
                .when()
                .post()
                .then()
                .extract().body().as(UsersList.class);
        LOGGER.trace("Request is sent");
    }

}
