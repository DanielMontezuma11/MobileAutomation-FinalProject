package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SwipeScreen extends BaseScreen {

    private static final By CARDS_BY = AppiumBy.xpath("//*[@content-desc='card']");
    private static final By CAROUSEL_BY = AppiumBy.id("Carousel");
    private static final By FOUND_ME_TEXT = AppiumBy.xpath("//*[@text='You found me!!!']");

    public SwipeScreen(AppiumDriver driver) {
        super(driver);
    }

    private void waitForCardsToBePresent() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(CARDS_BY, 0));
    }

    public boolean hasCardsVisible() {
        waitForCardsToBePresent();
        for (WebElement card : driver.findElements(CARDS_BY)) {
            if (card.isDisplayed()) {
                return true;
            }
        }
        return false;
    }

    private List<WebElement> getVisibleCards() {
        return driver.findElements(CARDS_BY).stream()
                .filter(WebElement::isDisplayed)
                .collect(Collectors.toList());
    }

    private void performSwipe(int startX, int startY, int endX, int endY, long durationMs) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 0);
        sequence.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        sequence.addAction(finger.createPointerDown(0));
        sequence.addAction(finger.createPointerMove(Duration.ofMillis(durationMs), PointerInput.Origin.viewport(), endX, endY));
        sequence.addAction(finger.createPointerUp(0));
        driver.perform(Collections.singletonList(sequence));
    }

    private Rectangle getSwipeAreaRect() {
        try {
            WebElement carousel = new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.presenceOfElementLocated(CAROUSEL_BY));
            return carousel.getRect();
        } catch (Exception ignored) {
            List<WebElement> visible = getVisibleCards();
            if (!visible.isEmpty()) {
                return visible.get(0).getRect();
            }
            Dimension size = driver.manage().window().getSize();
            return new Rectangle((int) (size.getWidth() * 0.1), (int) (size.getHeight() * 0.2),
                    (int) (size.getWidth() * 0.8), (int) (size.getHeight() * 0.4));
        }
    }

    private void swipeOnVisibleCard(boolean leftDirection) {
        waitForCardsToBePresent();
        Rectangle rect = getSwipeAreaRect();
        int y = rect.getY() + (rect.getHeight() / 2);
        int startX = leftDirection
                ? rect.getX() + (int) (rect.getWidth() * 0.85)
                : rect.getX() + (int) (rect.getWidth() * 0.15);
        int endX = leftDirection
                ? rect.getX() + (int) (rect.getWidth() * 0.15)
                : rect.getX() + (int) (rect.getWidth() * 0.85);
        performSwipe(startX, y, endX, y, 650);
    }

    public boolean swipeRightAndWaitCardChange() {
        swipeOnVisibleCard(true);
        try {
            Thread.sleep(450);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return hasCardsVisible();
    }

    private void swipeVerticalAboveCarousel() {
        Dimension size = driver.manage().window().getSize();
        int x = size.getWidth() / 2;
        int startY = (int) (size.getHeight() * 0.38);
        int endY = (int) (size.getHeight() * 0.14);

        try {
            WebElement carousel = driver.findElement(CAROUSEL_BY);
            Rectangle rect = carousel.getRect();
            int maxStartAbove = rect.getY() - 10;
            if (maxStartAbove > 120) {
                startY = Math.min(startY, maxStartAbove);
                endY = Math.max(80, startY - (int) (size.getHeight() * 0.20));
            }
        } catch (Exception ignored) {
        }

        performSwipe(x, startY, x, endY, 800);
        try {
            Thread.sleep(450);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void swipeVerticalVeryHigh() {
        Dimension size = driver.manage().window().getSize();
        int x = size.getWidth() / 2;
        int startY = (int) (size.getHeight() * 0.30);
        int endY = (int) (size.getHeight() * 0.08);
        performSwipe(x, startY, x, endY, 780);
        try {
            Thread.sleep(420);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void swipeVerticalFromMidLow() {
        Dimension size = driver.manage().window().getSize();
        int x = (int) (size.getWidth() * 0.20);
        int startY = (int) (size.getHeight() * 0.82);
        int endY = (int) (size.getHeight() * 0.52);
        performSwipe(x, startY, x, endY, 820);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean findYouFoundMeWithVerticalSwipes(int maxSwipes) {
        if (isFoundMeTextVisible()) {
            return true;
        }
        if (maxSwipes <= 0) {
            return false;
        }

        swipeVerticalAboveCarousel();
        if (isFoundMeTextVisible()) {
            return true;
        }

        if (maxSwipes > 1) {
            swipeVerticalVeryHigh();
            if (isFoundMeTextVisible()) {
                return true;
            }
        }

        for (int i = 2; i < maxSwipes; i++) {
            swipeVerticalFromMidLow();
            if (isFoundMeTextVisible()) {
                return true;
            }
        }
        return false;
    }

    public boolean isOnlyOneCardVisible() {
        return getVisibleCards().size() == 1;
    }

    public boolean isPreviousCardHidden(int swipeCount) {
        return hasCardsVisible();
    }

    public boolean goToLastCard(int maxSwipes) {
        for (int i = 0; i < maxSwipes; i++) {
            swipeRightAndWaitCardChange();
            if (isOnlyOneCardVisible()) {
                return true;
            }
        }
        return isOnlyOneCardVisible();
    }

    public boolean isLastCardVisible() {
        return isOnlyOneCardVisible();
    }

    public boolean isFoundMeTextVisible() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOfElementLocated(FOUND_ME_TEXT));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}