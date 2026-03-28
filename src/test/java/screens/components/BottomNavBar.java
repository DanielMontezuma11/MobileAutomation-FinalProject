package screens.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import screens.BaseScreen;

public class BottomNavBar extends BaseScreen {

    @AndroidFindBy(accessibility = "Home")
    private WebElement homeBtn;

    @AndroidFindBy(accessibility = "Webview")
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

    public boolean isTabDisplayed(String sectionName){
        return getTab(sectionName).isDisplayed();
    }

    public boolean isTabEnabled(String sectionName){
        return getTab(sectionName).isEnabled();
    }

    public boolean isTabSelected(String sectionName){
        String selected = getTab(sectionName).getAttribute("selected");
        return "true".equalsIgnoreCase(selected);
    }

    public String getTabLabel(String sectionName){
        WebElement tab = getTab(sectionName);
        String contentDesc = tab.getAttribute("content-desc");
        if (contentDesc != null && !contentDesc.trim().isEmpty()) {
            return contentDesc.trim();
        }
        return tab.getText().trim();
    }

    private WebElement getTab(String sectionName){
        switch (sectionName.toLowerCase()) {
            case "home":
                return homeBtn;
            case "webview":
                return webBtn;
            case "login":
                return loginBtn;
            case "forms":
                return formsBtn;
            case "swipe":
                return swipeBtn;
            case "drag":
                return dragBtn;
            case "menu":
                return menuBtn;
            default:
                throw new IllegalArgumentException("Seccion invalida en bottom nav: " + sectionName);
        }
    }
}