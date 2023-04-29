package cucumberPrac.utils;

import cucumberPrac.constants.EnvType;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader()
    {
        String env = System.getProperty("env",String.valueOf(EnvType.STAGE));
        System.out.println("ENV : " + env);
        switch (EnvType.valueOf(env.toUpperCase()))
        {

            case STAGE -> properties = PropertyUtils.propertiesLoader("src/test/resources/stage_config.properties");
            case PROD -> properties = PropertyUtils.propertiesLoader("src/test/resources/prod_config.properties");
            default -> throw new IllegalStateException("INVALID ENV : " + env);
        }

    }
    public static ConfigLoader getInstance()
    {
        if(configLoader == null)
        {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }
    public String getBaseUrl()
    {
        String prop = properties.getProperty("baseUrl");
        if(prop!=null)return prop;
        else throw new RuntimeException("Properties baseUrl is not found in config.properties file ");
    }
}
