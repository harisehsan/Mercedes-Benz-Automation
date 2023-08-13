package getProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/** To avoid the Hardcoded values inside the script, This class contains methods that fetch the required property from .Properties file  **/
public class BaseGetProperties {

    String FILE_PATH="src/test/java/properties/base.properties"; /** This cannot be avoided and it remains only as hardcoded **/

    private Properties prop = new Properties();
    private void fileInputStream() throws IOException, FileNotFoundException {
        prop.load(new FileInputStream(FILE_PATH));
    }

    public String javaScriptClick() throws IOException {
        fileInputStream();
        return prop.getProperty("JAVASCRIPT_CLICK");
    }

    public String documentReadyState() throws IOException {
        fileInputStream();
        return prop.getProperty("DOCUMENT_READY_STATE");
    }

    public String complete() throws IOException {
        fileInputStream();
        return prop.getProperty("COMPLETE");
    }

    public String shadowRoot() throws IOException {
        fileInputStream();
        return prop.getProperty("SHADOW_ROOT");
    }

    public String maxAttempts() throws IOException {
        fileInputStream();
        return prop.getProperty("MAX_ATTEMPTS");
    }

    public String screenshotPath() throws IOException {
        fileInputStream();
        return prop.getProperty("SCREENSHOT_PATH");
    }

    public String scrollToView() throws IOException {
        fileInputStream();
        return prop.getProperty("SCROLL_TO_VIEW");
    }

    public String integerRegix() throws IOException {
        fileInputStream();
        return prop.getProperty("INTEGER_REGIX");
    }

    public String poundSign() throws IOException {
        fileInputStream();
        return prop.getProperty("POUND_SIGN");
    }

    public String commaSign() throws IOException {
        fileInputStream();
        return prop.getProperty("COMMA");
    }

    public String zeroValue() throws IOException {
        fileInputStream();
        return prop.getProperty("ZERO");
    }








}
