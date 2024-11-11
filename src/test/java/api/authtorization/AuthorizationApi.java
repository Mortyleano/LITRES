package api.authtorization;

import models.AuthorizationModel;

import static data.ConfigData.API_CONFIG;
import static io.restassured.RestAssured.given;
import static specs.AuthorizationSpecification.authorizationRequestSpec;
import static specs.AuthorizationSpecification.authorizationResponseSpec;

public class AuthorizationApi {

    public String getAuthorizationResponse() {
        AuthorizationModel authData = new AuthorizationModel();
        return given(authorizationRequestSpec)
                .body(authData)
                .when()
                .post()
                .then()
                .spec(authorizationResponseSpec)
                .extract()
                .path(API_CONFIG.getApiPathSid());
    }
}