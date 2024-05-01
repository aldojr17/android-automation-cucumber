package stepdefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.URL;

public class StepDefinitions {
    private static final String APP = "/Users/rivaldo.wattimena/Downloads/mda-1.0.13-15.apk";
    private static final String APPIUM = "http://127.0.0.1:4723";

    private AndroidDriver driver;
    WebDriverWait wait;
    String product_name;
    String color;
    String quantity;

    String USERNAME = "bod@example.com";
    String PASSWORD = "10203040";
    String FULL_NAME = "Rivaldo Stuart Wattimena";
    String ADDRESS = "Kuningan";
    String CITY = "Jakarta Selatan";
    String ZIP_CODE = "12345";
    String COUNTRY = "Indonesia";
    String CARD_NUMBER = "4321123443211234";
    String EXPIRATION_DATE = "0528";
    String SECURITY_CODE = "123";

    String HOME_PAGE_TARGETED_PRODUCT_TITLE_XPATH = "//android.widget.TextView[@text='%s']";

    String PRODUCT_PAGE_TITLE_ID = "com.saucelabs.mydemoapp.android:id/productTV";
    String PRODUCT_PAGE_TARGETED_COLOR_XPATH = "//android.widget.ImageView[@content-desc='%s color']";
    String PRODUCT_PAGE_ADD_QUANTITY_ID = "com.saucelabs.mydemoapp.android:id/plusIV";
    String PRODUCT_PAGE_QUANTITY_ID = "com.saucelabs.mydemoapp.android:id/noTV";
    String PRODUCT_PAGE_ADD_TO_CART_BUTTON_ID = "com.saucelabs.mydemoapp.android:id/cartBt";
    String PRODUCT_PAGE_CART_ID = "com.saucelabs.mydemoapp.android:id/cartRL";
    String PRODUCT_PAGE_NUMBER_OF_ITEMS_IN_CART_ID = "com.saucelabs.mydemoapp.android:id/cartTV";

    String CART_PAGE_ITEM_LIST_ID = "com.saucelabs.mydemoapp.android:id/productRV";
    String CART_PAGE_ITEM_NAME_ID = "com.saucelabs.mydemoapp.android:id/titleTV";
    String CART_PAGE_ITEM_QUANTITY_ID = "com.saucelabs.mydemoapp.android:id/noTV";
    String CART_PAGE_CHECKOUT_BUTTON_ID = "com.saucelabs.mydemoapp.android:id/cartBt";

    String LOGIN_PAGE_USERNAME_TEXT_EDIT_ID = "com.saucelabs.mydemoapp.android:id/nameET";
    String LOGIN_PAGE_PASSWORD_TEXT_EDIT_ID = "com.saucelabs.mydemoapp.android:id/passwordET";
    String LOGIN_PAGE_LOGIN_BUTTON_ID = "com.saucelabs.mydemoapp.android:id/loginBtn";

    String CHECKOUT_PAGE_FULL_NAME_ID = "com.saucelabs.mydemoapp.android:id/fullNameET";
    String CHECKOUT_PAGE_ADDRESS_FIRST_LINE_ID = "com.saucelabs.mydemoapp.android:id/address1ET";
    String CHECKOUT_PAGE_CITY_ID = "com.saucelabs.mydemoapp.android:id/cityET";
    String CHECKOUT_PAGE_ZIP_CODE_ID = "com.saucelabs.mydemoapp.android:id/zipET";
    String CHECKOUT_PAGE_COUNTRY_ID = "com.saucelabs.mydemoapp.android:id/countryET";
    String CHECKOUT_PAGE_PAYMENT_BUTTON_ID = "com.saucelabs.mydemoapp.android:id/paymentBtn";

    String PAYMENT_PAGE_FULL_NAME_ID = "com.saucelabs.mydemoapp.android:id/nameET";
    String PAYMENT_PAGE_CARD_NUMBER_ID = "com.saucelabs.mydemoapp.android:id/cardNumberET";
    String PAYMENT_PAGE_EXPIRATION_DATE_ID = "com.saucelabs.mydemoapp.android:id/expirationDateET";
    String PAYMENT_PAGE_SECURITY_CODE_ID = "com.saucelabs.mydemoapp.android:id/securityCodeET";
    String PAYMENT_PAGE_REVIEW_ORDER_BUTTON_ID = "com.saucelabs.mydemoapp.android:id/paymentBtn";

    String REVIEW_PAGE_PRODUCT_TITLE_ID = "com.saucelabs.mydemoapp.android:id/titleTV";
    String REVIEW_PAGE_FULL_NAME_ID = "com.saucelabs.mydemoapp.android:id/fullNameTV";
    String REVIEW_PAGE_ADDRESS_ID = "com.saucelabs.mydemoapp.android:id/addressTV";
    String REVIEW_PAGE_CITY_ID = "com.saucelabs.mydemoapp.android:id/cityTV";
    String REVIEW_PAGE_COUNTRY_ID = "com.saucelabs.mydemoapp.android:id/countryTV";
    String REVIEW_PAGE_CARD_HOLDER_ID = "com.saucelabs.mydemoapp.android:id/cardHolderTV";
    String REVIEW_PAGE_CARD_NUMBER_ID = "com.saucelabs.mydemoapp.android:id/cardNumberTV";
    String REVIEW_PAGE_EXPIRATION_DATE_ID = "com.saucelabs.mydemoapp.android:id/expirationDateTV";
    String REVIEW_PAGE_QUANTITY_ID = "com.saucelabs.mydemoapp.android:id/itemNumberTV";
    String REVIEW_PAGE_PLACE_ORDER_BUTTON_ID = "com.saucelabs.mydemoapp.android:id/paymentBtn";


    @Given("User open app")
    public void openApp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appWaitActivity", "com.saucelabs.mydemoapp.android.view.activities.MainActivity");
        capabilities.setCapability("app", APP);

        driver = new AndroidDriver<>(new URL(APPIUM), capabilities);
        wait = new WebDriverWait(driver, 5);
    }

    @When("User want to buy {string}")
    public void buyProduct(String query_product_name) {
        product_name = query_product_name;
        String product_xpath = String.format(HOME_PAGE_TARGETED_PRODUCT_TITLE_XPATH, query_product_name);

        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(product_xpath)));
        Assert.assertEquals(product.getText(), query_product_name);

        WebElement targeted_product = driver.findElement(By.xpath(product_xpath + "/.."));
        targeted_product.click();
    }

    @When("Choose the {string} color")
    public void chooseColor(String query_color) {
        color = query_color;
        String color_xpath = String.format(PRODUCT_PAGE_TARGETED_COLOR_XPATH, query_color);

        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PRODUCT_PAGE_TITLE_ID)));
        Assert.assertEquals(title.getText(), product_name);

        WebElement color_button = driver.findElement(By.xpath(color_xpath));
        Assert.assertEquals(color_button.getAttribute("content-desc"), String.format("%s color", query_color));

        color_button.click();
    }

    @When("Want to buy {string} products")
    public void addQuantity(String query_quantity) {
        quantity = query_quantity;

        driver.findElement(By.id(PRODUCT_PAGE_ADD_QUANTITY_ID)).click();

        WebElement quantity_element = driver.findElement(By.id(PRODUCT_PAGE_QUANTITY_ID));
        Assert.assertEquals(quantity_element.getText(), query_quantity);

        driver.findElement(By.id(PRODUCT_PAGE_ADD_TO_CART_BUTTON_ID)).click();
    }

    @When("Checkout the products")
    public void checkout() {
        WebElement number_of_items = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PRODUCT_PAGE_NUMBER_OF_ITEMS_IN_CART_ID)));
        Assert.assertEquals(number_of_items.getText(), quantity);

        driver.findElement(By.id(PRODUCT_PAGE_CART_ID)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CART_PAGE_ITEM_LIST_ID)));

        WebElement product_title = driver.findElement(By.id(CART_PAGE_ITEM_NAME_ID));
        Assert.assertEquals(product_title.getText(), product_name);

        WebElement product_quantity = driver.findElement(By.id(CART_PAGE_ITEM_QUANTITY_ID));
        Assert.assertEquals(product_quantity.getText(), quantity);

        driver.findElement(By.id(CART_PAGE_CHECKOUT_BUTTON_ID)).click();
    }

    @When("Login into the app")
    public void login() {
        WebElement username_text_edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LOGIN_PAGE_USERNAME_TEXT_EDIT_ID)));
        WebElement password_text_edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LOGIN_PAGE_PASSWORD_TEXT_EDIT_ID)));

        username_text_edit.sendKeys(USERNAME);
        password_text_edit.sendKeys(PASSWORD);

        driver.findElement(By.id(LOGIN_PAGE_LOGIN_BUTTON_ID)).click();
    }

    @When("Enter the shipping address")
    public void enterShippingAddress() {
        WebElement full_name_text_edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CHECKOUT_PAGE_FULL_NAME_ID)));
        WebElement address_text_edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CHECKOUT_PAGE_ADDRESS_FIRST_LINE_ID)));
        WebElement city_text_edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CHECKOUT_PAGE_CITY_ID)));
        WebElement zip_code_text_edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CHECKOUT_PAGE_ZIP_CODE_ID)));
        WebElement country_text_edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CHECKOUT_PAGE_COUNTRY_ID)));

        full_name_text_edit.sendKeys(FULL_NAME);
        address_text_edit.sendKeys(ADDRESS);
        city_text_edit.sendKeys(CITY);
        zip_code_text_edit.sendKeys(ZIP_CODE);
        country_text_edit.sendKeys(COUNTRY);

        Assert.assertEquals(full_name_text_edit.getText(), FULL_NAME);
        Assert.assertEquals(address_text_edit.getText(), ADDRESS);
        Assert.assertEquals(city_text_edit.getText(), CITY);
        Assert.assertEquals(zip_code_text_edit.getText(), ZIP_CODE);
        Assert.assertEquals(country_text_edit.getText(), COUNTRY);

        driver.findElement(By.id(CHECKOUT_PAGE_PAYMENT_BUTTON_ID)).click();
    }

    @When("Enter the payment method")
    public void enterPaymentMethod() {
        WebElement full_name_payment_text_edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PAYMENT_PAGE_FULL_NAME_ID)));
        WebElement card_number_text_edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PAYMENT_PAGE_CARD_NUMBER_ID)));
        WebElement expiration_date_text_edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PAYMENT_PAGE_EXPIRATION_DATE_ID)));
        WebElement security_code_text_edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PAYMENT_PAGE_SECURITY_CODE_ID)));

        full_name_payment_text_edit.sendKeys(FULL_NAME);
        card_number_text_edit.sendKeys(CARD_NUMBER);
        expiration_date_text_edit.sendKeys(EXPIRATION_DATE);
        security_code_text_edit.sendKeys(SECURITY_CODE);

        Assert.assertEquals(full_name_payment_text_edit.getText(), FULL_NAME);
        Assert.assertEquals(card_number_text_edit.getText(), String.format("%s %s %s %s", CARD_NUMBER.substring(0, 4), CARD_NUMBER.substring(4, 8), CARD_NUMBER.substring(8, 12), CARD_NUMBER.substring(12)));
        Assert.assertEquals(expiration_date_text_edit.getText(), String.format("%s/%s", EXPIRATION_DATE.substring(0, 2), EXPIRATION_DATE.substring(2)));
        Assert.assertEquals(security_code_text_edit.getText(), SECURITY_CODE);

        driver.findElement(By.id(PAYMENT_PAGE_REVIEW_ORDER_BUTTON_ID)).click();
    }

    @When("Place the order")
    public void placeOrder() {
        WebElement place_order_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(REVIEW_PAGE_PLACE_ORDER_BUTTON_ID)));

        String REVIEW_PAGE_PRODUCT_TITLE_ID = "com.saucelabs.mydemoapp.android:id/titleTV";
        String REVIEW_PAGE_FULL_NAME_ID = "com.saucelabs.mydemoapp.android:id/fullNameTV";
        String REVIEW_PAGE_ADDRESS_ID = "com.saucelabs.mydemoapp.android:id/addressTV";
        String REVIEW_PAGE_CITY_ID = "com.saucelabs.mydemoapp.android:id/cityTV";
        String REVIEW_PAGE_COUNTRY_ID = "com.saucelabs.mydemoapp.android:id/countryTV";
        String REVIEW_PAGE_CARD_HOLDER_ID = "com.saucelabs.mydemoapp.android:id/cardHolderTV";
        String REVIEW_PAGE_CARD_NUMBER_ID = "com.saucelabs.mydemoapp.android:id/cardNumberTV";
        String REVIEW_PAGE_EXPIRATION_DATE_ID = "com.saucelabs.mydemoapp.android:id/expirationDateTV";
        String REVIEW_PAGE_QUANTITY_ID = "com.saucelabs.mydemoapp.android:id/itemNumberTV";

        WebElement product_title = driver.findElement(By.id(REVIEW_PAGE_PRODUCT_TITLE_ID));
        WebElement full_name = driver.findElement(By.id(REVIEW_PAGE_FULL_NAME_ID));
        WebElement address = driver.findElement(By.id(REVIEW_PAGE_ADDRESS_ID));
        WebElement city = driver.findElement(By.id(REVIEW_PAGE_CITY_ID));
        WebElement country = driver.findElement(By.id(REVIEW_PAGE_COUNTRY_ID));

        Assert.assertEquals(product_title.getText(), product_name);
        Assert.assertEquals(full_name.getText(), FULL_NAME);
        Assert.assertEquals(address.getText(), ADDRESS);
        Assert.assertEquals(city.getText(), String.format("%s, ", CITY));
        Assert.assertEquals(country.getText(), String.format("%s, %s", COUNTRY, ZIP_CODE));

        place_order_button.click();
    }

    @Then("Proceed until product placed")
    public void productPlaced() {
        driver.quit();
    }
}
