package base;

import getProperties.BaseGetProperties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class Base extends BaseUtil {

    /** This class contains all the general methods along with their definition which can be repeatedly used in the test script
     * This class is super class of The scripting class **/

      BaseGetProperties baseGetProperties = new BaseGetProperties();
    /** This class constructor and it contains the default dynamic wait time of 10 seconds **/
    public Base(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /** This method is used to perform dynamic wait until page is ready **/
    protected void waitUntilPageReady(Duration DEFAULT_TIMEOUT){
        new WebDriverWait(driver, DEFAULT_TIMEOUT).until(
                webDriver -> {
                    try {
                        return ((JavascriptExecutor) webDriver).executeScript(baseGetProperties.documentReadyState()).equals(baseGetProperties.complete());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                });
    }

    /** This method is used to perfrom clicking opration using javascript to make click more efficient **/
    protected void javaScriptButtonClick(WebElement ele) throws IOException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(baseGetProperties.javaScriptClick(),ele);
    }
    /** This method is used to get the shadow DOM of the element **/
    protected SearchContext getShadowRoot(WebElement ele) throws IOException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return  (SearchContext) js.executeScript(baseGetProperties.shadowRoot(),ele);
    }

        protected void mouseHoverCustom(WebElement ele1, WebElement ele2) {
                Actions action = new Actions(driver);
                action.moveToElement(ele1).moveToElement(ele2).
                build().perform();
        }

    /** This method is used to remove the special characters and store it into the price list **/
    protected List<Integer> getPriceValues(List<Integer> pricelst, List<WebElement> itemPricelst) throws IOException {
        for (WebElement webElement : itemPricelst) {
            pricelst.add(Integer.parseInt(webElement.getText().replaceAll(baseGetProperties.integerRegix(), "").replace(baseGetProperties.poundSign(), "").replace(baseGetProperties.commaSign(), "")));
        }
        return pricelst;
    }

    /** This method is used to convert the price value from String to int**/
    protected int convertToInteger(String price) throws IOException {
       return (Integer.parseInt(price.replaceAll(baseGetProperties.integerRegix(), "").replace(baseGetProperties.poundSign(), "").replace(baseGetProperties.commaSign(), "")));
    }

    /** This method is used to take the screemshop and store it into the specified directory **/
    public void takeScreenShot() throws IOException {
            TakesScreenshot scrShot =((TakesScreenshot)driver);
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile=new File(baseGetProperties.screenshotPath());
            FileUtils.copyFile(SrcFile, DestFile);
    }

    /** This method is used to perfrom the dynamic wait for element until visible **/
    protected void waitUntilVisible(WebElement ele, Duration DEFAULT_TIMEOUT) {
        new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOf(ele));
    }

    /**This method is used to navigate to the specified page **/
    protected void goToPage(String url)
    {
        driver.navigate().to(url);
    }

    /** This method is used to perform to the scroll on page to the specified element **/
    protected void scrollToView(WebElement ele) throws IOException {
        ((JavascriptExecutor) driver).executeScript(baseGetProperties.scrollToView(), ele);
    }

    /** This method is used to perform to the scroll to the specified element **/
    public boolean elementExist(List<WebElement> ele) throws IOException {
         return (ele.size() > convertToInteger(baseGetProperties.zeroValue()));
    }
}