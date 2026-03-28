package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SwipeScreen extends BaseScreen{

    @AndroidFindBy(xpath = "//*[@content-desc='card']")
    private List<WebElement> cards;

    private static final By CARDS_BY = AppiumBy.xpath("//*[@content-desc='card']");

    public SwipeScreen(AppiumDriver driver){
        super(driver);
    }

    private void waitForCardsToBePresent(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(CARDS_BY, 0));
    }

    public boolean hasCardsVisible(){
        waitForCardsToBePresent();
        for (WebElement card : driver.findElements(CARDS_BY)) {
            if (card.isDisplayed()) {
                return true;
            }
        }
        return false;
    }
}