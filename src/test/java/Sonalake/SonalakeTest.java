package Sonalake;

import core.BaseSeleniumTest;
import org.junit.Test;

public class SonalakeTest extends BaseSeleniumTest {

    @Test
    public void checkFirstCalculationTest() {
        MainPage mainPage = new MainPage();
        mainPage.checkFirstCalculation(); // 1. Calculate 35*999+(100/4)= and assert the correct result 34990.
        mainPage.checkCosinusCalculation(); // 2. Calculate cos(pi) with the rad radio button and assert the correct result -1.
        mainPage.checkSqrtCalculation(); // 3. Calculate sqrt(81) and assert the correct result 9.
        mainPage.checkHistInCalc(); // 4. //4. Press history dropdown and assert that the list contains the 3 operations
                                 //executed e.g. 35*999+(100/4)=, cos(pi), sqrt(81)
    }


}
