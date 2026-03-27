package screens.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import screens.BaseScreen;

public class BottomNavBar extends BaseScreen {

    @AndroidFindBy(accessibility = "Home")
    private WebElement homeBtn;

    @AndroidFindBy(accessibility = "WebView")
    private WebElement webBtn;

    @AndroidFindBy(accessibility = "Login")
    private WebElement loginBtn;

    @AndroidFindBy(accessibility = "Forms")
    private WebElement formsBtn;

    @AndroidFindBy(accessibility = "Swipe")
    private WebElement swipeBtn;

    @AndroidFindBy(accessibility = "Drag")
    private WebElement dragBtn;

    @AndroidFindBy(accessibility = "Menu")
    private WebElement menuBtn;

    public BottomNavBar (AppiumDriver driver){
        super(driver);
    }

    public void goToHome(){
        homeBtn.click();
    }

    public void goToWebView(){
        webBtn.click();
    }

    public void goToLogin(){
        loginBtn.click();
    }

    public void goToForms(){
        formsBtn.click();
    }

    public void goToSwipe(){
        swipeBtn.click();
    }

    public void goToDrag(){
        dragBtn.click();
    }

    public void goToMenu(){
        menuBtn.click();
    }
}
