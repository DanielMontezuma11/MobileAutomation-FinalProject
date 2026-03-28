package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class FormsScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "text-input")
    private WebElement textInput;

    @AndroidFindBy(accessibility = "button-Active")
    private WebElement activeButton;

    public FormsScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean hasExpectedElementsVisibleAndEnabled() {
        WaitUtils.waitForVisibility(wait, textInput);
        return textInput.isDisplayed() && textInput.isEnabled()
                && activeButton.isDisplayed() && activeButton.isEnabled();
    }
}