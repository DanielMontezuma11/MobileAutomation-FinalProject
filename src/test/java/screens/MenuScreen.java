package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "tab-side-menu-panel")
    private WebElement menuPanel;

    public MenuScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean hasVisibleMenuElements() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOf(menuPanel));
            return menuPanel.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}