package specs;

import data.UserSessionData;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static data.ConfigData.LAUNCH_CONFIG;
import static data.ConfigData.PATH_CONFIG;
import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;

public class BooksSpecification {

    public static RequestSpecification getAddBookToCartRequestSpec() {
        return with()
                .filter(withCustomTemplates())
                .log().all()
                .contentType(JSON)
                .baseUri(LAUNCH_CONFIG.getBaseApiUrl())
                .basePath(PATH_CONFIG.getApiPathAddBook())
                .header("session-id", UserSessionData.getSessionId());
    }

    public static RequestSpecification getDeleteBookFromCartRequestSpec() {
        return with()
                .filter(withCustomTemplates())
                .log().all()
                .contentType(JSON)
                .baseUri(LAUNCH_CONFIG.getBaseApiUrl())
                .basePath(PATH_CONFIG.getApiPathDeleteBook())
                .header("session-id", UserSessionData.getSessionId());
    }

    public static RequestSpecification addBookToCartRequestSpec = with()
            .filter(withCustomTemplates())
            .log().all()
            .contentType(JSON)
            .baseUri(LAUNCH_CONFIG.getBaseApiUrl())
            .basePath(PATH_CONFIG.getApiPathAddBook());

    public static ResponseSpecification addBookToCartResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(STATUS)
            .log(BODY)
            .build();

    public static RequestSpecification deleteBookFromCartRequestSpec = with()
            .filter(withCustomTemplates())
            .log().all()
            .contentType(JSON)
            .baseUri(LAUNCH_CONFIG.getBaseApiUrl())
            .basePath(PATH_CONFIG.getApiPathDeleteBook());

    public static ResponseSpecification deleteBookFromCartResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(204)
            .log(STATUS)
            .log(BODY)
            .build();
}