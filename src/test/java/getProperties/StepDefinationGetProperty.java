package getProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/** To avoid the Hardcoded values inside the script, This class contains methods that fetch the required property from .Properties file  **/

public class StepDefinationGetProperty {
    String FILE_PATH = "src/test/java/properties/stepdefination.properties";
    /**
     * This cannot be avoided and it remains only as hardcoded
     **/
    private Properties prop = new Properties();

    private void fileInputStream() throws IOException, FileNotFoundException {
        prop.load(new FileInputStream(FILE_PATH));
    }

    public String validation1() throws IOException {
        fileInputStream();
        return prop.getProperty("VALIDATION_1");
    }

    public String validation2() throws IOException {
        fileInputStream();
        return prop.getProperty("VALIDATION_2");
    }

    public String validation3() throws IOException {
        fileInputStream();
        return prop.getProperty("VALIDATION_3");
    }
    public String validation4() throws IOException {
        fileInputStream();
        return prop.getProperty("VALIDATION_4");
    }

    public String validation5() throws IOException {
        fileInputStream();
        return prop.getProperty("VALIDATION_5");
    }

    public String validation6() throws IOException {
        fileInputStream();
        return prop.getProperty("VALIDATION_6");
    }

    public String validation7() throws IOException {
        fileInputStream();
        return prop.getProperty("VALIDATION_7");
    }

    public String validation8() throws IOException {
        fileInputStream();
        return prop.getProperty("VALIDATION_8");
    }

    public String validation9() throws IOException {
        fileInputStream();
        return prop.getProperty("VALIDATION_9");
    }
}
