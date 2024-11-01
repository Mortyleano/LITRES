package data;

import config.AuthConfig;
import lombok.Data;
import models.AuthorizationModel;
import org.aeonbits.owner.ConfigFactory;

@Data
public class AuthorizationData {

    private String login;
    private String password;

    public AuthorizationData() {
        AuthorizationModel authModel = getAuthModel();
        this.login = authModel.getLogin();
        this.password = authModel.getPassword();
    }

    private AuthorizationModel getAuthModel() {
        AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());
        return new AuthorizationModel(config.login(), config.password());
    }
}