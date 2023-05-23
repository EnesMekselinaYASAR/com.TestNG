package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties;

    static {
        String dosyaYolu="configuration.properties";
        //her seferinde class isminin yanına throws atmak yerine try-cathch kullanıyoruz.

        try {
            FileInputStream fis=new FileInputStream(dosyaYolu);
            //fis dosya yolunu tanımladığımız configuration.properties dosyasını okudu
            properties=new Properties(); //değer atadık
            properties.load(fis); // FileInputStream in okuduğu değerleri propertiese yükledim


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key ){
        /*
        test methodundan yolladığımız string key değerini alıp Properties classından getProperty() methodunu
        kullanarak bu key'e ait value'yu bize getirdi.
         */

        return properties.getProperty(key);
    }

}
