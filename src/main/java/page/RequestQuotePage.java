package page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseClass;
import utils.ConfigUtil;

import java.time.Duration;
import java.util.Properties;

@Slf4j
public class RequestQuotePage extends BaseClass {
    static Properties configProperties;
    protected static String workEmail = setConfig().getProperty("workEmail");
    protected static String firstName = setConfig().getProperty("firstName");
    protected static String lastName = setConfig().getProperty("lastName");
    protected static String phoneNumber = setConfig().getProperty("phoneNum");
    protected static String quoteCompany = setConfig().getProperty("quoteCompany");
    protected static String numberOfEmployees = setConfig().getProperty("numberOfEmployees");
    static String requestQuoteUrl = setConfig().getProperty("requestQuoteUrl");
    By workEmailTextBox = By.id("email");
    By firstStepNextButton = By.id("next-btn");
    By firstNameTextBox = By.id("first-name");
    By lastNameTextBox = By.id("last-name");
    By phoneTextBox = By.id("phone");
    By secondStepNextButton = By.id("nexttwo-btn");
    By companyTextBox = By.id("company");
    By numberOfEmployeesTextBox = By.id("no-of-employees");
    By countryDropDown = By.id("Countries");
    By stateDropDown = By.id("State");
    By primaryInterestDropDown = By.id("primaryInterest");
    By futureCommunicationCheckBox = By.id("checkbox-consent");
    By submitButton = By.id("submit-btn");

    private WebDriver driver;

    public RequestQuotePage(WebDriver driver) {
        this.driver = driver;
    }

    public static Properties setConfig() {
        return configProperties = ConfigUtil.getConfig("config");
    }

    public void navigateToRequestQuote() {
        driver.get(requestQuoteUrl);
    }

    public void enterWorkEmail() {
        driver.findElement(workEmailTextBox).sendKeys(workEmail);
    }

    public void clickFirstStepNextButton() {
        driver.findElement(firstStepNextButton).click();
    }

    public void enterFirstName() {
        driver.findElement(firstNameTextBox).sendKeys(firstName);
    }

    public void enterLastName() {
        driver.findElement(lastNameTextBox).sendKeys(lastName);
    }

    public void enterPhone() {
        driver.findElement(phoneTextBox).sendKeys(phoneNumber);
    }

    public void clickSecondStepNextButton() {
        driver.findElement(secondStepNextButton).click();
    }

    public void enterCompany() {
        driver.findElement(companyTextBox).sendKeys(quoteCompany);
    }

    public void enterNumberOfEmployees() {
        driver.findElement(numberOfEmployeesTextBox).sendKeys(numberOfEmployees);
    }

    public void selectCountry() throws InterruptedException {
        WebElement dropdown = driver.findElement(countryDropDown);
        dropdown.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement option =
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Canada')]")));
        option.click();
    }

    public void selectState() {
        selectRandomOption(driver, stateDropDown);
    }

    public void selectPrimaryInterest() {
        WebElement dropdown = driver.findElement(primaryInterestDropDown);
        dropdown.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement option =
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Other')]")));
        option.click();
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

    public void verifyTheRequestIsSubmitted() {
        String pageSource = driver.getPageSource();

        String expectedText = "Your request has been submitted";

        if (pageSource.contains(expectedText)) {
            log.info("Text verification passed!");
        } else {
            log.info("Text verification failed!");
        }
    }
}
