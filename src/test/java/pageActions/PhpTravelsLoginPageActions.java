package pageActions;

import common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pageUI.PhpTravelsLoginPageUI;

public class PhpTravelsLoginPageActions extends BaseTest {
    WebDriver driver;
    public PhpTravelsLoginPageActions(WebDriver driver) {
        this.driver = driver;
    }

    public void inputUsername(String username) {
        sendKeyToElement(driver, PhpTravelsLoginPageUI.usernameTextbox,username);
    }

    public void inputPassword(String password) {
        sendKeyToElement(driver, PhpTravelsLoginPageUI.passwordTextbox,password);
    }

    public void clickLoginButton(){
        clickElement(driver,PhpTravelsLoginPageUI.loginButton);
    }

    public boolean isWarningTextPresent(){
        return isElementPresent(driver,PhpTravelsLoginPageUI.warningLoginText);
    }

    public boolean isUsernamePlaceholderPresent(){
        return isElementDisplayed(driver,PhpTravelsLoginPageUI.usernameTextboxHolder);
    }

    public boolean isPasswordPlaceholderPresent(){
        return isElementDisplayed(driver,PhpTravelsLoginPageUI.passwordTextboxHolder);
    }

    public String getTextUsernamePlaceholder(){
        return getTextElement(driver,PhpTravelsLoginPageUI.usernameTextboxHolder);
    }

    public String getTextPasswordPlaceholder(){
        return getTextElement(driver,PhpTravelsLoginPageUI.passwordTextboxHolder);
    }

    public void clickRememberMeButton(){
        clickElement(driver,PhpTravelsLoginPageUI.rememberMeButton);
    }

    public String verifyRememberMeCheckboxIsChecked(){
        boolean checked = isCheckboxChecked(driver,PhpTravelsLoginPageUI.rememberMeCheckbox);
        if(checked){
            return "Remember me checkbox IS CHECKED";
        }
        else {
            return "Remember me checkbox ISN'T CHECKED";
        }
    }
}
