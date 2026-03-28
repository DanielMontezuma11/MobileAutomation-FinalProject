package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.components.BottomNavBar;
import screens.SwipeScreen;

public class SwipeCardsTest extends BaseTest {
    @Test
    public void swipeCardsTest() {
        BottomNavBar nav = new BottomNavBar(appiumDriver);
        nav.goToSwipe();
        Assert.assertTrue(new SwipeScreen(appiumDriver).hasCardsVisible(), "Las tarjetas no están visibles en la sección Swipe");

        SwipeScreen swipeScreen = new SwipeScreen(appiumDriver);

        Assert.assertTrue(swipeScreen.swipeRightAndWaitCardChange(), "El swipe no cambió la card visible");
        Assert.assertTrue(swipeScreen.isPreviousCardHidden(1), "La tarjeta anterior no se ocultó después del swipe");

        Assert.assertTrue(swipeScreen.goToLastCard(8), "No se pudo llegar a la última card con los swipes");
        Assert.assertTrue(swipeScreen.isLastCardVisible(), "La última tarjeta no es la única visible");

        boolean foundText = swipeScreen.findYouFoundMeWithVerticalSwipes(12);
        Assert.assertTrue(foundText, "No se encontró el texto 'You found me!!!' después de los swipes verticales");
    }
}