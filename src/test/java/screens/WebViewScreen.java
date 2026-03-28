package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebViewScreen extends BaseScreen {

    @AndroidFindBy(className = "android.webkit.WebView")
    private List<WebElement> webViews;

    public WebViewScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean hasVisibleWebView() {
        for (WebElement webView : webViews) {
            if (webView.isDisplayed()) {
                return true;
            }
        }
        return false;
    }
}