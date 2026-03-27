package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.SignUpScreen;
import screens.components.BottomNavBar;

public class LoginTest extends BaseTest{
    @Test
    public void loginTest(){
        BottomNavBar nav = new BottomNavBar(appiumDriver);
        LoginScreen login = new LoginScreen(appiumDriver);
        SignUpScreen signUp = new SignUpScreen(appiumDriver);

        nav.goToLogin();
        login.goToSignUp();

        String email = signUp.signUp();

        signUp.signUpOk();

        signUp.goToLogIn();

        login.login(email, "12345678");

        Assert.assertEquals(login.getLogInConfirmationAlert(), "Success");
    }
}
