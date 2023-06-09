package common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.service.ExtentService;
import constants.FrameworkConstants;
import org.apache.commons.validator.GenericValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import steps.Exam2;

import java.time.Duration;
import java.util.InputMismatchException;


public class BaseTest {
    private Duration longTimeout = FrameworkConstants.WAIT_DEFAULT;

    public WebElement getElementByXpath(WebDriver driver, String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public static final Level NOTICE = Level.forName("NOTICE", 450);
    private static final Logger logger = LogManager.getLogger();

    public static void addExtentReportEnvironment(WebDriver driver) {
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        ExtentReports extentReports = ExtentService.getInstance();

        extentReports.setSystemInfo("Author", FrameworkConstants.AUTHOR);
        extentReports.setSystemInfo("Report Title", FrameworkConstants.REPORT_TITLE);
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
        extentReports.setSystemInfo("Browser", cap.getBrowserName() + " " + cap.getBrowserVersion());

    }

    public void waitForElementClickable(WebDriver driver, String xpath) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public void waitForElementVisible(WebDriver driver, String xpath) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public Boolean isElementDisplayed(WebDriver driver, String locatorType) {
        waitForElementVisible(driver, locatorType);
        return getElementByXpath(driver, locatorType).isDisplayed();
    }

    public Boolean isCheckboxChecked(WebDriver driver, String xpath) {
//        waitForElementVisible(driver, xpath);
        return getElementByXpath(driver, xpath).isSelected();
    }

    public void clickElement(WebDriver driver, String xpath) {
        waitForElementClickable(driver, xpath);
        getElementByXpath(driver, xpath).click();
    }

    public String getTextElement(WebDriver driver, String xpath) {
        waitForElementVisible(driver, xpath);
        return getElementByXpath(driver, xpath).getText();
    }

    public void sendKeyToElement(WebDriver driver, String xpath, String text) {
        waitForElementVisible(driver, xpath);
        getElementByXpath(driver, xpath).sendKeys(text);
    }

    public void verifyEqualText(String actualString, String expectedString) {
        SoftAssert assertEqual = new SoftAssert();
        assertEqual.assertEquals(actualString, expectedString);
        logger.info("Verify " +"'"+actualString +"'"+ " is equal to " + "'"+expectedString+"'");
        assertEqual.assertAll();
    }

    public String verifyStringIsValidDate(String date) {
        Boolean valid = GenericValidator.isDate(date, "yyyyMMdd", true);
        if (valid == true) {
            return date + " is valid date";
        } else
            throw new InputMismatchException(date + " is not valid date");
    }

    public boolean isElementPresent(WebDriver driver, String xpath) {
        int sizeElements = driver.findElements(By.xpath(xpath)).size();
        if (sizeElements > 0) {
            return true;
        } else {
            return false;
        }
    }

}
