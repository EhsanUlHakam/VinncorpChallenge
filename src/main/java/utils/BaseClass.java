package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import page.RequestQuotePage;

import java.util.List;
import java.util.Random;

public class BaseClass {

    public WebDriver driver;
    RequestQuotePage requestQuotePage;

    public static void selectRandomOption(WebDriver driver, By dropdownLocator) {
        // Find the dropdown element
        WebElement dropdownElement = driver.findElement(dropdownLocator);

        // Create a Select object
        Select dropdown = new Select(dropdownElement);

        // Get all the options from the dropdown
        List<WebElement> options = dropdown.getOptions();

        // Generate a random index within the range of available options
        Random rand = new Random();
        int randomIndex = rand.nextInt(options.size());

        // Select the option at the random index
        dropdown.selectByIndex(randomIndex);
    }

    public WebDriver setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeSuite(alwaysRun = true)
    public RequestQuotePage launchApplication() {
        driver = setup();
        requestQuotePage = new RequestQuotePage(driver);
        requestQuotePage.navigateToRequestQuote();
        return requestQuotePage;
    }

    public void tearDown() {
        try {
            if (driver != null) {
                driver.close();
                driver.quit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
