package data;

import config.AuthConfig;
import config.LaunchConfig;
import config.PathConfig;
import org.aeonbits.owner.ConfigFactory;

public class ConfigData {

    public static final AuthConfig AUTH_CONFIG = ConfigFactory.create(AuthConfig.class, System.getProperties());
    public static final PathConfig PATH_CONFIG = ConfigFactory.create(PathConfig.class, System.getProperties());
    public static final LaunchConfig LAUNCH_CONFIG = ConfigFactory.create(LaunchConfig.class, System.getProperties());
}