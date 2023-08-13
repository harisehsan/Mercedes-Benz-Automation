package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/** This is the test class contains the page objects that are required selenium web driver to locate the required element during automation
 * NOTE: As per framework design, This class can only contain the hardcoded data items. it cannot be avoided **/

public class MercedesTaskPageObject {

    @FindBy(xpath = "//dh-io-vmos[@class='webcomponent aem-GridColumn aem-GridColumn--default--12']") public WebElement our_models_shadow_root;
    @FindBy(xpath = "(//cmm-cookie-banner[@class='hydrated'])[1]") public WebElement main_shadow_root;
    @FindBy(xpath = "//owcc-car-configurator[@class='webcomponent aem-GridColumn aem-GridColumn--default--12']") public WebElement car_config_root;
    @FindBy(css = "owcc-car-configurator[class='webcomponent aem-GridColumn aem-GridColumn--default--12") public WebElement diseal_Type_Shadow;

    public By car_Categories_lbl_by = By.className("dh-io-vmos_3gsRF");
    public By class_A_lbl_by = By.className("dh-io-vmos_2pz0m");
    public By hatchback_price_lbl_by = By.className("dh-io-vmos_2xn0k");
    public By first_Car_options_lst_by = By.className("dh-io-vmos_3jEGe");
    public By accept_All_btn_by = By.className("button--accept-all");
    public By car_widgt_home_screen_by = By.className("dh-io-vmos_2rNPP");
    public By our_models_header_by = By.className("dh-io-vmos_2ulYg");
    public By catelog_items_lbl_by = By.className("cc-motorization-header__vehicle-name");
    public By fuel_info_lbl_by = By.className("cc-motorization-comparison__tag");
    public By item_price_lst_by = By.className("cc-motorization-header__price");
    public By car_Config_Nested_root_By = By.cssSelector(".cc-motorization-filters-primary-filters--multi-select.wb-multi-select.hydrated");
    public By diesal_type_shadow_by_2 = By.cssSelector(".ng-untouched.ng-pristine.ng-valid.ng-star-inserted.wb-checkbox.hydrated");
    public By diesal_chkBox = By.cssSelector("input[value='false']");
    public By fuel_type_drpDown_by = By.cssSelector(".label");
}

