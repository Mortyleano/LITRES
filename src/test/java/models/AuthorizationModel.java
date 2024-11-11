package models;

import config.AuthConfig;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.aeonbits.owner.ConfigFactory;

@AllArgsConstructor
@Data
@Builder
public class AuthorizationModel {

    private String login;
    private String password;

    public AuthorizationModel() {
        AuthorizationModel authModel = getAuthModel();
        this.login = authModel.getLogin();
        this.password = authModel.getPassword();
    }

    private AuthorizationModel getAuthModel() {
        AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());
        return new AuthorizationModel(config.login(), config.password());
    }
}