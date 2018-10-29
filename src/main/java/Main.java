import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    private final static String PROPERTIES_FILE = "config.properties";

    public static void main(String[] args) {
        Main app = new Main();
        Properties prop = app.loadPropertiesFile();
        prop.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    private Properties loadPropertiesFile() {
        Properties prop = new Properties();
        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + PROPERTIES_FILE);
        }

        return prop;

    }
}
