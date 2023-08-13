package getProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/** To avoid the Hardcoded values inside the script, This class contains methods that fetch the required property from .Properties file  **/
public class ScriptGetProperty {
    String FILE_PATH="src/test/java/properties/script.properties"; /** This cannot be avoided and it remains only as hardcoded **/
    private Properties prop = new Properties();
    private void fileInputStream() throws IOException, FileNotFoundException {
        prop.load(new FileInputStream(FILE_PATH));
    }

    public String mainURL() throws IOException {
        fileInputStream();
        return prop.getProperty("MAIN_URL");
    }

    public String valueOne() throws IOException {
        fileInputStream();
        return prop.getProperty("ONE_VALUE");
    }

    public String maxTries() throws IOException {
        fileInputStream();
        return prop.getProperty("MAX_TRIES");
    }

    public String valueFive() throws IOException {
        fileInputStream();
        return prop.getProperty("FIVE_VALUE");
    }

    public String nameAttribute() throws IOException {
        fileInputStream();
        return prop.getProperty("NAME");
    }

    public String screenShotPath() throws IOException {
        fileInputStream();
        return prop.getProperty("SCREENSHOT_PATH");
    }

    public String textFilePath() throws IOException {
        fileInputStream();
        return prop.getProperty("TEXT_FILE_PATH");
    }

    public String textFiles() throws IOException {
        fileInputStream();
        return prop.getProperty("TEXT_FILES");
    }

    public String lowestPrice() throws IOException {
        fileInputStream();
        return prop.getProperty("LOWEST_PRICE");
    }

    public String highestPrice() throws IOException {
        fileInputStream();
        return prop.getProperty("HIGHEST_PRICE");
    }
}
