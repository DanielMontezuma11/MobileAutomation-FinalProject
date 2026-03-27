package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void testAppLaunch(){
        Assert.assertNotNull(appiumDriver);
    }
}
