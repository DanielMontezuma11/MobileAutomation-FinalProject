package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import utils.DataGenerator;
import utils.WaitUtils;

public class SignUpScreen extends BaseScreen{

    @AndroidFindBy(accessibility = "input-email")
    private WebElement email;

    @AndroidFindBy(accessibility = "input-password")
    private WebElement password;

    @AndroidFindBy(accessibility = "input-repeat-password")
    private WebElement confirmPassword;

    @AndroidFindBy(accessibility = "button-SIGN UP")
    private WebElement signUbBtn;

    @AndroidFindBy(id = "com.wdiodemoapp:id/alert_title")
    private WebElement alert;

    @AndroidFindBy(accessibility = "button-login-container")
    private WebElement loginTab;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement okAlertBtn;

    public SignUpScreen (AppiumDriver driver){
        super(driver);
    }

    public String signUp(){
        String emailGenerated = DataGenerator.generatedEmail();
        email.sendKeys(emailGenerated);

        password.sendKeys("12345678");
        confirmPassword.sendKeys("12345678");
        signUbBtn.click();

        return emailGenerated;
    }

    public String getConfirmationAlert(){

        WaitUtils.waitForVisibility(wait, alert);
        return alert.getText();
    }

    public void signUpOk(){
        WaitUtils.waitForVisibility(wait, alert);
        okAlertBtn.click();
    }

    public void goToLogIn(){
        loginTab.click();
    }
}
