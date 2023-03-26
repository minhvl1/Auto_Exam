package pageUI;

public class PhpTravelsLoginPageUI {
    public static String usernameTextbox = "//input[@name='email' and @placeholder=\" \"]";
    public static String passwordTextbox = "//input[@name='password' and @placeholder=\" \"]";
    public static String warningLoginText  = "//div[@class='alert alert-danger loading wow fadeIn animated animated']";
    public static String loginButton ="//button[@type='submit']";
    public static String usernameTextboxHolder = "//input[@name='email' and @placeholder=\" \"]//parent::label/span";
    public static String passwordTextboxHolder = "//input[@name='password' and @placeholder=\" \"]//parent::label/span";
    public static String rememberMeButton = "//div[@class='icheckbox_square-grey']";
    public static String rememberMeCheckbox = "//input[@name='remember']";
}
