package getProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/** To avoid the Hardcoded values inside the script, This class contains methods that fetch the required property from .Properties file  **/
public class HooksGetProperty {
    String FILE_PATH="src/test/java/properties/hooks.properties"; /** This cannot be avoided and it remains only as hardcoded **/
    private Properties prop = new Properties();
    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream(FILE_PATH));
    }

    public String boundryPrice() throws IOException {
        fileInputStream();
        return prop.getProperty("BOUNDRY_PRICE");
    }

    public String screenshot() throws IOException {
        fileInputStream();
        return prop.getProperty("SCREENSHOT");
    }

    public String scenarioVideo() throws IOException {
        fileInputStream();
        return prop.getProperty("SCENARIO_VIDEO");
    }

    public String videoPath() throws IOException {
        fileInputStream();
        return prop.getProperty("VIDEO_PATH");
    }

    public String osName() throws IOException {
        fileInputStream();
        return prop.getProperty("OS_NAME");
    }

    public String windows() throws IOException {
        fileInputStream();
        return prop.getProperty("WINDOWS_OS");
    }

    public String chromeDriver() throws IOException {
        fileInputStream();
        return prop.getProperty("CHROME_DRIVER");
    }

    public String chromeDriverWindowsPath() throws IOException {
        fileInputStream();
        return prop.getProperty("CHROME_DRIVER_WIN_PATH");
    }

    public String chromeDriverLinuxPath() throws IOException {
        fileInputStream();
        return prop.getProperty("CHROME_DRIVER_LINUX_PATH");
    }

    public String remoteAllowOrigin() throws IOException {
        fileInputStream();
        return prop.getProperty("REMOTE_ALLOW_ORIGIN");
    }

    public String edgeDriver() throws IOException {
        fileInputStream();
        return prop.getProperty("EDGE_DRIVER");
    }

    public String edgeDriverPath() throws IOException {
        fileInputStream();
        return prop.getProperty("EDGE_DRIVER_PATH");
    }

    public String edgeDriverOptions() throws IOException {
        fileInputStream();
        return prop.getProperty("EDGE_OPTIONS");
    }
}
