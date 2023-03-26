package steps;

import common.BaseTest;
import cucumberHooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
import pageActions.PhpTravelsDashboardPageActions;
import pageActions.PhpTravelsLoginPageActions;


public class Exam2 extends BaseTest {
    WebDriver driver;
    private PhpTravelsLoginPageActions phpTravelsLoginPage;
    private PhpTravelsDashboardPageActions phpTravelsDashboardPage;

    public Exam2() {
        this.driver = Hooks.openAndQuitBrowser();
        phpTravelsLoginPage = new PhpTravelsLoginPageActions(driver);
        phpTravelsDashboardPage = new PhpTravelsDashboardPageActions(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    private static final Logger logger = LogManager.getLogger(Exam2.class);

    @Given("Go to {string}")
    public void goTo(String arg0) {
        driver.get(arg0);
    }

    @Given("input username {string}")
    public void inputUsername(String arg0) {
        logger.log(NOTICE,"username:" + arg0);
        phpTravelsLoginPage.inputUsername(arg0);
    }

    @And("input password {string}")
    public void inputPassword(String arg0) {
        logger.log(NOTICE,"password:" + arg0);
        phpTravelsLoginPage.inputPassword(arg0);
    }

    @When("Click login button")
    public void clickLoginButton() {
        phpTravelsLoginPage.clickLoginButton();
    }

    @Then("Verify dashboard page {string}")
    public void verifyDashboardPage(String arg0) {
        boolean warningTextPresent = phpTravelsLoginPage.isWarningTextPresent();
        if (warningTextPresent) {
            logger.info("Login fail");
        } else {
            logger.info("login success");
        }
        logger.info(phpTravelsDashboardPage.isDashboardDisplay());
        verifyEqualText(phpTravelsDashboardPage.isDashboardDisplay(), arg0);
        driver.manage().deleteAllCookies();
    }


    @Then("Verify placeholder is display")
    public void verifyPlaceholderIsDisplay() {
        logger.info("Email holder is display:" + phpTravelsLoginPage.isUsernamePlaceholderPresent());
        logger.info("Password holder is display:" + phpTravelsLoginPage.isPasswordPlaceholderPresent());
    }

    @And("Email placeholder have text should equal {string}")
    public void emailPlaceholderHaveTextShouldEqual(String arg0) {
        logger.info(phpTravelsLoginPage.getTextUsernamePlaceholder());
        verifyEqualText(phpTravelsLoginPage.getTextUsernamePlaceholder(), arg0);
    }

    @And("Password placeholder have text should equal {string}")
    public void passwordPlaceholderHaveTextShouldEqual(String arg0) {
        logger.info(phpTravelsLoginPage.getTextPasswordPlaceholder());
        verifyEqualText(phpTravelsLoginPage.getTextPasswordPlaceholder(), arg0);
    }

    @And("Verify check box Remember me is checked")
    public void verifyCheckBoxRememberMeIsChecked() {
        logger.info("Before click Remember button");
        logger.info(phpTravelsLoginPage.verifyRememberMeCheckboxIsChecked());
        phpTravelsLoginPage.clickRememberMeButton();
        logger.info("After click Remember button");
        logger.info(phpTravelsLoginPage.verifyRememberMeCheckboxIsChecked());
    }

}
