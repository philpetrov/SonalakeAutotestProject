/*
 * The main page by the URL: "http://web2.0calc.com/"
 */
package Sonalake;

import core.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import readProperties.ConfigProvider;

import static org.junit.Assert.assertEquals;

public class MainPage extends BaseSeleniumPage {

    //Numbers buttons:
    @FindBy(xpath = "//button[@value = 'consent']")
    private WebElement consent;
    @FindBy(xpath = "//button[@aria-label = 'Consent']")
    private WebElement consent2;
    @FindBy(id = "Btn0")
    private WebElement Btn0;
    @FindBy(id = "Btn1")
    private WebElement Btn1;
    @FindBy(id = "Btn2")
    private WebElement Btn2;
    @FindBy(id = "Btn3")
    private WebElement Btn3;
    @FindBy(id = "Btn4")
    private WebElement Btn4;
    @FindBy(id = "Btn5")
    private WebElement Btn5;
    @FindBy(id = "Btn6")
    private WebElement Btn6;
    @FindBy(id = "Btn7")
    private WebElement Btn7;
    @FindBy(id = "Btn8")
    private WebElement Btn8;
    @FindBy(id = "Btn9")
    private WebElement Btn9;

    //Operators buttons:
    @FindBy(id = "BtnDiv")
    private WebElement BtnDiv; //division "/" button
    @FindBy(id = "BtnMult")
    private WebElement BtnMult; //multiply "*" button
    @FindBy(id = "BtnMinus")
    private WebElement BtnMinus; //minus "-" button
    @FindBy(id = "BtnPlus")
    private WebElement BtnPlus; //plus "+" button
    @FindBy(id = "BtnCalc")
    private WebElement BtnCalc; // operator "=" button

    //symbols buttons:
    @FindBy(id = "BtnParanL")
    private WebElement BtnParanL; //left bracket "(" button

    //fields:
    @FindBy(id = "input")
    private WebElement inputField;

    //result values:

    @FindBy(xpath = "//p[@title='34990']")
    private WebElement firstResult;


    public MainPage() {
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver,  this);
        consent.click(); //click "consent" after start MainPage
        consent2.click(); // second "consent"
    }

    public MainPage checkFirstCalculation(){ //check both the availability of buttons and the input field
        Btn3.click();
        Btn5.click();
        BtnMult.click();
        Btn9.click();
        Btn9.click();
        Btn9.click();
        BtnPlus.click();
        BtnParanL.click();
        inputField.sendKeys("100/4)");
        BtnCalc.click();
        assertEquals("34990", firstResult.getAttribute("title"));
        return this;
    }

}
