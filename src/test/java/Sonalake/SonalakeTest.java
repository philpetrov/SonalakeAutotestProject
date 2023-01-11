package Sonalake;

import core.BaseSeleniumTest;
import org.junit.Test;

public class SonalakeTest extends BaseSeleniumTest {

    @Test
    public void checkFirstCalculationTest() {
        MainPage mainPage = new MainPage();
        mainPage.checkFirstCalculation();
        mainPage.checkCosinusCalculation();
    }


}
