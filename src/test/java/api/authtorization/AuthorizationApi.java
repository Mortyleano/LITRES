package api.authtorization;

import data.AuthorizationData;

import static data.ConfigData.PATH_CONFIG;
import static io.restassured.RestAssured.given;
import static specs.AuthorizationSpecification.authorizationRequestSpec;
import static specs.AuthorizationSpecification.authorizationResponseSpec;

public class AuthorizationApi {

    public String getAuthorizationResponse() {
        AuthorizationData authData = new AuthorizationData();
        return given(authorizationRequestSpec)
                .body(authData)
                .when()
                .post()
                .then()
                .spec(authorizationResponseSpec)
                .extract()
                .path(PATH_CONFIG.getApiPathSid());
    }
}