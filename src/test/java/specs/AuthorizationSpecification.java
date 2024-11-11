package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static data.ConfigData.API_CONFIG;
import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;

public class AuthorizationSpecification {

    public static RequestSpecification authorizationRequestSpec = with()
            .filter(withCustomTemplates())
            .log().all()
            .contentType(JSON)
            .basePath(API_CONFIG.getApiPathLogin())
            .header("App-Id", "115");

    public static ResponseSpecification authorizationResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(STATUS)
            .log(BODY)
            .build();

    public static RequestSpecification unsuccessfulAuthorizationRequestSpec = with()
            .filter(withCustomTemplates())
            .log().all()
            .contentType(JSON)
            .basePath(API_CONFIG.getApiPathLogin())
            .header("App-Id", "114");

    public static ResponseSpecification unsuccessfulAuthorizationResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(422)
            .log(STATUS)
            .log(BODY)
            .build();
}