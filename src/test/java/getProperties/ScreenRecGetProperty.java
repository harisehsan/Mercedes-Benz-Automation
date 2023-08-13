package getProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/** To avoid the Hardcoded values inside the script, This class contains methods that fetch the required property from .Properties file  **/
public class ScreenRecGetProperty {
    String FILE_PATH="src/test/java/properties/screenRecording.properties"; /** This cannot be avoided it can only as hardcoded **/
    private Properties prop = new Properties();
    private void fileInputStream() throws IOException, FileNotFoundException {
        prop.load(new FileInputStream(FILE_PATH));
    }

    public String notADirectory() throws IOException {
        fileInputStream();
        return prop.getProperty("NOT_A_DIR");
    }

    public String dateFormat() throws IOException {
        fileInputStream();
        return prop.getProperty("DATE_FORMAT");
    }

    public String video() throws IOException {
        fileInputStream();
        return prop.getProperty("VIDEO");
    }

    public String mp4() throws IOException {
        fileInputStream();
        return prop.getProperty("MP4");
    }

    public String directory() throws IOException {
        fileInputStream();
        return prop.getProperty("DIR");
    }

    public String zeroValue() throws IOException {
        fileInputStream();
        return prop.getProperty("ZERO_VALUE");
    }

    public String twentyFourValue() throws IOException {
        fileInputStream();
        return prop.getProperty("TWNTYFOUR_VALUE");
    }

    public String fifteenValue() throws IOException {
        fileInputStream();
        return prop.getProperty("FIFTEEN_VALUE");
    }

    public String oneFloatValue() throws IOException {
        fileInputStream();
        return prop.getProperty("ONE_FLOAT_VALUE");
    }

    public String sixtyValue() throws IOException {
        fileInputStream();
        return prop.getProperty("SIXTY_VALUE");
    }

    public String thirtyValue() throws IOException {
        fileInputStream();
        return prop.getProperty("THIRTY_VALUE");
    }

    public String black() throws IOException {
        fileInputStream();
        return prop.getProperty("BLACK");
    }
}
