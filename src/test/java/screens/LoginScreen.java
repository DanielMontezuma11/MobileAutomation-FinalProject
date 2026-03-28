package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class LoginScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "input-email")
    private WebElement email;

    @AndroidFindBy(accessibility = "input-password")
    private WebElement password;

    @AndroidFindBy(accessibility = "button-LOGIN")
    private WebElement loginBtn;

    @AndroidFindBy(accessibility = "button-sign-up-container")
    private WebElement signUpTab;

    @AndroidFindBy(id = "com.wdiodemoapp:id/alert_title")
    private WebElement logInAlert;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement okAlertBtn;

    public LoginScreen (AppiumDriver driver){
        super(driver);
    }

    public void goToSignUp(){
        signUpTab.click();
    }

    public void login(String user, String pass){
        email.sendKeys(user);
        password.sendKeys(pass);
        loginBtn.click();
    }

    public String getLogInConfirmationAlert(){
        WaitUtils.waitForVisibility(wait, logInAlert);
        return logInAlert.getText();
    }

    public boolean hasExpectedElementsVisibleAndEnabled(){
        WaitUtils.waitForVisibility(wait, email);
        return email.isDisplayed() && email.isEnabled()
                && password.isDisplayed() && password.isEnabled()
                && loginBtn.isDisplayed() && loginBtn.isEnabled();
    }
}
