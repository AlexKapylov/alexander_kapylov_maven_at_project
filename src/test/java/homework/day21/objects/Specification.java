package homework.day21.objects;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specification {

    public RequestSpecification getSpecification(String uri) {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri(uri)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
        return requestSpec;
    }

}
