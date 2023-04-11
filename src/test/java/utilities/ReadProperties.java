package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    public String  readProperties(String property) throws IOException {
        FileReader read = new FileReader("src/test/resources/config.properties");
        Properties credentials = new Properties();
        credentials.load(read);
        return credentials.getProperty(property);
    }

}
