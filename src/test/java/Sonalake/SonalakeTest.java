package Sonalake;

import core.BaseSeleniumTest;
import org.junit.Test;

import java.beans.Expression;
import java.util.Scanner;
import java.util.Stack;

public class SonalakeTest extends BaseSeleniumTest {

    @Test
    public void checkFirstCalculationTest() {
        MainPage mainPage = new MainPage();
        mainPage.checkFirstCalculation();
        mainPage.checkCosinusCalculation();

    }
}
