package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import driver.DriverManager;

public class CheckoutPage {
    private WebDriver driver;

    // Localizadores que se encuentran en la página de Checkout
    private By proceedToCheckoutBtn = By.xpath("//a[@class='checkout-button button alt wc-forward']");
    private By firstNameField = By.xpath("//input[@name='billing_first_name']");
    private By lastNameField = By.xpath("//input[@name='billing_last_name']");
    private By contryDropDown = By.id("billing_country");
    private By streetAdressSelect = By.id("billing_address_1");
    private By cityField = By.id("billing_city");
    private By stateSelect = By.id("billing_state");
    private By zipField = By.id("billing_postcode");
    private By phoneField = By.id("billing_phone");
    private By emailField = By.id("billing_email");
    private By proceedToPayBtn = By.xpath("//button[@class='button alt']");

    // Constructor
    public CheckoutPage() {
        this.driver = DriverManager.getDriver();
    }
    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    public void selectCountry(String country) {
        WebElement dropdown = driver.findElement(contryDropDown);
        Select select = new Select(dropdown);
        select.selectByVisibleText(country);
    }
    public void enterStreetAdress(String streetAdress) {
        driver.findElement(streetAdressSelect).sendKeys(streetAdress);
    }
    public void enterCity(String city) {
        driver.findElement(cityField).sendKeys(city);
    }
    public void selectState(String state) {
        WebElement dropdown = driver.findElement(stateSelect);
        Select select2 = new Select(dropdown);
        select2.selectByVisibleText(state);
    }
    public void enterZip(String zip) {
        driver.findElement(zipField).sendKeys(zip);
    }
    public void enterPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    public void clickProceedToCheckout() {
        driver.findElement(proceedToCheckoutBtn).click();
    }
    public void clickProceedToPay() {
        driver.findElement(proceedToPayBtn).click();
    }
}
