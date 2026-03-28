package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class DragScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "drag-l1")
    private WebElement firstDraggable;

    @AndroidFindBy(accessibility = "drop-l1")
    private WebElement firstDropZone;

    public DragScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean hasExpectedElementsVisibleAndEnabled() {
        WaitUtils.waitForVisibility(wait, firstDraggable);
        return firstDraggable.isDisplayed() && firstDraggable.isEnabled()
                && firstDropZone.isDisplayed() && firstDropZone.isEnabled();
    }
}