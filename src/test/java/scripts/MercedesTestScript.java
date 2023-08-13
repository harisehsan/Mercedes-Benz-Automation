package scripts;

import base.Base;
import getProperties.ScriptGetProperty;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import pageObject.MercedesTaskPageObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** This is the test script class that contains the main business logic of the test **/

public class MercedesTestScript extends Base {
    WebDriver driver;
    MercedesTaskPageObject mercedesTaskPageObject = new MercedesTaskPageObject();
    ScriptGetProperty scriptGetProperty = new ScriptGetProperty();

    /** Class Constructor which is used initialize the Web Elements of the MercedesTaskPageObject class by using the page factory method **/
    public MercedesTestScript(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, mercedesTaskPageObject);
        /** The default dynamic timeout for element wait is 10 second **/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(convertToInteger(scriptGetProperty.maxTries())));
    }

    /** This method is used to open mercedes benz UK market web Page **/
    public void navigateToMercedesBenzPageUK() throws IOException {
        goToPage(scriptGetProperty.mainURL());
        waitUntilPageReady(Duration.ofMinutes(convertToInteger(scriptGetProperty.valueOne())));
        /** Accept the all cookie when cookie popup appears **/
        List<WebElement> acceptAll_btn = getShadowRoot(mercedesTaskPageObject.main_shadow_root).findElements(mercedesTaskPageObject.accept_All_btn_by);
        if (elementExist(acceptAll_btn))
            for (WebElement webElement : acceptAll_btn)
                     javaScriptButtonClick(webElement);
    }

    /** This method is used to scroll the page our model section on the page **/
    public boolean selectHatchbacks(String hatchBacks) throws IOException {
       WebElement our_model = getShadowRoot(mercedesTaskPageObject.our_models_shadow_root).findElement(mercedesTaskPageObject.our_models_header_by);
       waitUntilVisible(our_model,Duration.ofSeconds(convertToInteger(scriptGetProperty.maxTries())));
       scrollToView(our_model);
       WebElement car_Categories_lbl =  getShadowRoot(mercedesTaskPageObject.our_models_shadow_root).findElement(mercedesTaskPageObject.car_Categories_lbl_by);
       waitUntilVisible(car_Categories_lbl,Duration.ofSeconds(convertToInteger(scriptGetProperty.maxTries())));
       List  <WebElement> car_Categories_lst =  getShadowRoot(mercedesTaskPageObject.our_models_shadow_root).findElements(mercedesTaskPageObject.car_Categories_lbl_by);
       /** select the Hatchbacks model from the list of models **/
       for (WebElement catlst : car_Categories_lst) {
           if (catlst.getText().contains(hatchBacks)) {
               catlst.click();
               return true;
           }
       }
      return false;
   }

    /** Look for the first Class A car in list and hover the mouse on it to view the dropdown options **/
   public boolean mouseOverClassACar(String aClass, String BuildYourCar) throws IOException {
       List <WebElement> hatchbackcars = getShadowRoot(mercedesTaskPageObject.our_models_shadow_root).findElements(mercedesTaskPageObject.class_A_lbl_by);
       for (int i=0; i< hatchbackcars.size()-1; i+=2) {
           if (hatchbackcars.get(i).getText().contains(aClass)) {
               /** Upon getting class A car, call the method to proceed to Build Your Car **/
              return proceedToBuildYourCar(i, BuildYourCar);
           }
       }
       return false;
   }

    /** This method is used when the Class A car dropdown options are shown then select Build Your Car option in it **/
   private boolean proceedToBuildYourCar(int index, String buildYourCar) throws IOException {
      List<WebElement> hatchBackCarPrices = getShadowRoot(mercedesTaskPageObject.our_models_shadow_root).findElements(mercedesTaskPageObject.hatchback_price_lbl_by);
      WebElement hatchBackCarPrice = getShadowRoot(mercedesTaskPageObject.our_models_shadow_root).findElement(mercedesTaskPageObject.hatchback_price_lbl_by);
      List<WebElement> carWidgts = getShadowRoot(mercedesTaskPageObject.our_models_shadow_root).findElements(mercedesTaskPageObject.car_widgt_home_screen_by);
      boolean build_your_car_flag = false;
      waitUntilVisible(hatchBackCarPrice,Duration.ofSeconds(convertToInteger(scriptGetProperty.valueFive())));
      mouseHoverCustom(carWidgts.get(index),hatchBackCarPrices.get(index));
      List<WebElement> carOptions2 = getShadowRoot(mercedesTaskPageObject.our_models_shadow_root).findElements(mercedesTaskPageObject.first_Car_options_lst_by);
         for (WebElement webElement : carOptions2) {
             if (webElement.getText().contains(buildYourCar)) {
                 build_your_car_flag = true;
                 webElement.click();
                 waitUntilPageReady(Duration.ofMinutes(convertToInteger(scriptGetProperty.valueOne())));
                 break;
             }
         }
      return build_your_car_flag;
   }

    /** This method is used to select the Diesel fuel type to get the item for diesal only **/
   public void filterByDieselFuelType(String diesel) throws InterruptedException, IOException {
       waitUntilPageReady(Duration.ofMinutes(convertToInteger(scriptGetProperty.valueOne())));
       waitUntilVisible(mercedesTaskPageObject.car_config_root,Duration.ofSeconds(convertToInteger(scriptGetProperty.valueFive())));
       SearchContext shadowRoot = mercedesTaskPageObject.car_config_root.getShadowRoot();
       waitUntilVisible(shadowRoot.findElement(mercedesTaskPageObject.car_Config_Nested_root_By),Duration.ofSeconds(convertToInteger(scriptGetProperty.valueFive())));
       SearchContext shadowRoot2 = shadowRoot.findElement(mercedesTaskPageObject.car_Config_Nested_root_By).getShadowRoot();
       waitUntilVisible(shadowRoot2.findElement(mercedesTaskPageObject.fuel_type_drpDown_by),Duration.ofSeconds(convertToInteger(scriptGetProperty.valueFive())));
       WebElement fuelType = shadowRoot2.findElement(mercedesTaskPageObject.fuel_type_drpDown_by);
       /** Scroll the Page to the fuel type sections **/
       scrollToView(fuelType);
       /** Select the fuel type Dropdown **/
       javaScriptButtonClick(fuelType);
       SearchContext shadowRoot3 = mercedesTaskPageObject.diseal_Type_Shadow.getShadowRoot();
       SearchContext shadowRoot4 = shadowRoot3.findElement(mercedesTaskPageObject.diesal_type_shadow_by_2).getShadowRoot();
       WebElement dieselChkBox  =  shadowRoot4.findElement(mercedesTaskPageObject.diesal_chkBox);
       /** Select the diesel fuel Type in the Dropdown **/
       if (dieselChkBox.getAttribute(scriptGetProperty.nameAttribute()).equalsIgnoreCase(diesel) && !dieselChkBox.isSelected()) {
           javaScriptButtonClick(dieselChkBox);
       }
       javaScriptButtonClick(fuelType);
   }

    /** This method is to verify that After the selction of the diesel fuel Type atleast one item should exist **/
   public boolean oneOrMoreItemsShouldBePresentInCatelog() throws InterruptedException, IOException {
       List <WebElement> catelog = getShadowRoot(mercedesTaskPageObject.car_config_root).findElements(mercedesTaskPageObject.catelog_items_lbl_by);
       scrollToView(catelog.get(convertToInteger(scriptGetProperty.valueOne())));
       return elementExist(catelog);
   }

    /** This method is to verify that all the available items must have the fuel type diesal **/
   public boolean allItemsMustHaveDiesalFuelType(String Diesal) throws IOException {
       List <WebElement> fuelType = getShadowRoot(mercedesTaskPageObject.car_config_root).findElements(mercedesTaskPageObject.fuel_info_lbl_by);
       for (int i=1; i<fuelType.size()-1; i+=3)
       {
           if (!fuelType.get(i).getText().contains(Diesal))
               return false;
       }
       return true;
   }

    /** This method is to verify that item(s) must be sorted in ascending order by price
     * which is used to check the default sorting method **/
   public boolean verifyTheItemCatelogIsSortedInTheDefaultOrder() throws IOException {
       List<Integer> pricelst = getPricesListInInteger();
       return pricelst.stream().sorted().collect(Collectors.toList()).equals(pricelst);
   }

    /** This method is used to take the screenshot of the Web screen **/
    public void getScreenShotOfWebPage() throws IOException {
       takeScreenShot();
   }

    /** This method is to verify that the taken screenshot must be saved properly in the specified directory **/
   public boolean verifyTheScreenshotExists() throws IOException {
       File f = new File(scriptGetProperty.screenShotPath());
       return (f.exists());
   }

    /** This method is used to create the text file and Save the lowest price and the highest price in the text file **/
   public void saveTheLowestAndHighestPriceInTextFile() throws IOException
   {
       String path = scriptGetProperty.textFilePath();
       Path path1 = Paths.get(path);
       File f = new File(path);
       /** Create a new director and empty text file or replace if already exist **/
       if (!Files.isRegularFile(path1)) {
           new File(scriptGetProperty.textFiles()).mkdirs();
           f.createNewFile();
       }
       /** Fill the text file with the low and high price **/
       List <WebElement> itemPricelst = getShadowRoot(mercedesTaskPageObject.car_config_root).findElements(mercedesTaskPageObject.item_price_lst_by);
       String content = scriptGetProperty.lowestPrice()+itemPricelst.get(0).getText()+"\n"+scriptGetProperty.highestPrice()+itemPricelst.get(itemPricelst.size()- convertToInteger(scriptGetProperty.valueOne())).getText();
       Files.write(path1, content.getBytes());
   }

    /** This method is to verify that the text file should exist and must contain the values **/
   public boolean verifyTheTextFileShouldExistAndNotEmpty() throws IOException {
       File f = new File(scriptGetProperty.textFilePath());
       return (f.exists() && f.length() > 0);
   }

    /** Get all the prices of the available item(s) in list and compare that all the item(s) price must be between the £15,000 and £60,000 **/
   public boolean verifyThatAllItemsShouldBeBetweenSpecifiedRange(String lowerBound, String upperBound) throws IOException {
       int lowerPriceRange = convertToInteger(lowerBound);
       int higherPriceRange = convertToInteger(upperBound);
       List<Integer> pricelst = getPricesListInInteger();
       for (Integer price : pricelst) {
           if (price < lowerPriceRange || price > higherPriceRange)
               return false;
       }
           return true;
   }

    private List<Integer> getPricesListInInteger() throws IOException {
       /** This method is to store all the item(s) prices in the single price list **/
        List <Integer> pricelst = new ArrayList<>();
        List <WebElement> itemPricelst = getShadowRoot(mercedesTaskPageObject.car_config_root).findElements(mercedesTaskPageObject.item_price_lst_by);
        pricelst = getPriceValues(pricelst, itemPricelst);
        return pricelst;
    }
}
