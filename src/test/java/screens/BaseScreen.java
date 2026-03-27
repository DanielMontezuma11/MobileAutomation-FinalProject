package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumElementLocatorFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseScreen {

    protected AppiumDriver driver;
    protected WebDriverWait wait;

    public BaseScreen(AppiumDriver appiumDriver){
        this.driver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

}
