package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen{

    @AndroidFindBy(accessibility = "Home")
    private WebElement title;

    public HomeScreen (AppiumDriver driver){
        super(driver);
    }

    public boolean isDisplayed(){
        return title.isDisplayed();
    }
}
