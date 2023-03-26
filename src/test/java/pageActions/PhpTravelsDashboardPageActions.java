package pageActions;

import common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pageUI.PhpTravelsHomePageUI;
import pageUI.PhpTravelsLoginPageUI;

public class PhpTravelsDashboardPageActions extends BaseTest {
    WebDriver driver;
    public PhpTravelsDashboardPageActions(WebDriver driver) {
        this.driver = driver;
    }

    public String isDashboardDisplay() {
        boolean dashboard = isElementPresent(driver, PhpTravelsHomePageUI.dashboardTitle);
        if (dashboard) {
            return "Dashboard is display";
        } else {
            return "Dashboard isn't display";
        }
    }
}
