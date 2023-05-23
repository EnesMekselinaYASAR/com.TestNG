package utilities;

import java.util.Properties;

public class ConfigReader {
    Properties properties;

    public String getProperty(String key){

        return properties.getProperty(key);
    }

}
