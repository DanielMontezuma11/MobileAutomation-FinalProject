package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.*;
import screens.components.BottomNavBar;

public class BottomNavigationTest extends BaseTest {

    @Test
    public void bottomNavigationBarTest() {
        BottomNavBar nav = new BottomNavBar(appiumDriver);
        WebViewScreen webView = new WebViewScreen(appiumDriver);
        LoginScreen login = new LoginScreen(appiumDriver);
        FormsScreen forms = new FormsScreen(appiumDriver);
        SwipeScreen swipe = new SwipeScreen(appiumDriver);
        DragScreen drag = new DragScreen(appiumDriver);
        MenuScreen menu = new MenuScreen(appiumDriver);

        assertTabBaseState(nav, "Home");

        nav.goToWebView();
        assertTabStateAndLabel(nav, "Webview");
        Assert.assertTrue(webView.hasVisibleWebView(), "No se encontro contenido visible en la seccion WebView");

        nav.goToLogin();
        assertTabStateAndLabel(nav, "Login");
        Assert.assertTrue(login.hasExpectedElementsVisibleAndEnabled(), "Elementos esperados de Login no visibles/habilitados");

        nav.goToForms();
        assertTabStateAndLabel(nav, "Forms");
        Assert.assertTrue(forms.hasExpectedElementsVisibleAndEnabled(), "Elementos esperados de Forms no visibles/habilitados");

        nav.goToSwipe();
        assertTabStateAndLabel(nav, "Swipe");
        Assert.assertTrue(swipe.hasCardsVisible(), "No se visualizaron cards en la seccion Swipe");

        nav.goToDrag();
        assertTabStateAndLabel(nav, "Drag");
        Assert.assertTrue(drag.hasExpectedElementsVisibleAndEnabled(), "Elementos esperados de Drag no visibles/habilitados");

        nav.goToMenu();
        Assert.assertTrue(menu.hasVisibleMenuElements(), "El menu no se abrio o no tiene elmeentos visibles");
    }

    private void assertTabBaseState(BottomNavBar nav, String sectionName) {
        Assert.assertTrue(nav.isTabDisplayed(sectionName), "El tab " + sectionName + " no es visible en el bottom nav");
        Assert.assertTrue(nav.isTabEnabled(sectionName), "El tab " + sectionName + " no esta habilitado");
        Assert.assertEquals(nav.getTabLabel(sectionName), sectionName, "El label del tab no coincide para " + sectionName);
    }

    private void assertTabStateAndLabel(BottomNavBar nav, String sectionName) {
        assertTabBaseState(nav, sectionName);
        Assert.assertTrue(nav.isTabSelected(sectionName), "El tab " + sectionName + " no quedo seleccionado tras navegar");
    }
}