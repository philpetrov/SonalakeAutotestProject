package Sonalake;

import core.BaseSeleniumTest;
import org.junit.Test;

public class SonalakeTest extends BaseSeleniumTest {
    private final static String BaseUrl = "http://web2.0calc.com/";
    private final static String firstCalcValue = "35*999+(100/4)";

    @Test
    public void checkFirstCalculationTest(){
        MainPage mainPage = new MainPage();
        mainPage.checkFirstCalculation();
    }
}
