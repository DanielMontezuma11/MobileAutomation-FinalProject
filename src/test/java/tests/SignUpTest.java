package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.SignUpScreen;
import screens.components.BottomNavBar;

public class SignUpTest extends BaseTest{

    @Test
    public void signUpTest(){
        BottomNavBar nav = new BottomNavBar(appiumDriver);
        LoginScreen login = new LoginScreen(appiumDriver);
        SignUpScreen signUp = new SignUpScreen(appiumDriver);

        nav.goToLogin();
        login.goToSignUp();
        String email = signUp.signUp();

        Assert.assertNotNull(email);
        Assert.assertEquals(signUp.getConfirmationAlert(), "Signed Up!");
    }
}
