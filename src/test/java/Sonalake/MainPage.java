/*
 * The main page by the URL: "http://web2.0calc.com/"
 */
package Sonalake;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import readProperties.ConfigProvider;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class MainPage extends BaseSeleniumPage {

    //Numbers buttons:
    @FindBy(xpath = "//button[@value = 'consent']")
    private WebElement consent;
    @FindBy(xpath = "//button[@value = 'consent']")
    private List<WebElement> consentList;
    @FindBy(xpath = "//button[@aria-label = 'Consent']")
    private WebElement consent2;
    @FindBy(xpath = "//button[@aria-label = 'Consent']")
    private List<WebElement> consentList2;

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
    @FindBy(id = "BtnCos")
    private WebElement BtnCos; //cosinus "cos" button
    @FindBy(id = "BtnSqrt")
    private WebElement BtnSqrt; //Sqrt "BtnSqrt" button
    @FindBy(id = "BtnPi")
    private WebElement BtnPi; //"pi" button
    @FindBy(id = "BtnClear")
    private WebElement BtnClear; // operator Clear "C" button
    @FindBy(id = "BtnCalc")
    private WebElement BtnCalc; // operator "=" button

    //symbols buttons:
    @FindBy(id = "BtnParanL")
    private WebElement BtnParanL; //left bracket "(" button
    @FindBy(id = "BtnParanR")
    private WebElement BtnParanR; //right bracket ")" button

    //fields:
    @FindBy(id = "input")
    private WebElement inputField;

    //check-box and list of hist:
    @FindBy(xpath = "//input[@value = 'rad']")
    private WebElement checkBoxRad;
    @FindBy(id = "hist")
    private WebElement listOfHist;

    //result values:
    @FindBy(xpath = "//p[@title='34990']")
    private WebElement firstResult;
    @FindBy(xpath = "//p[@data-inp ='35*999+(100/4)']")
    private WebElement firstInputHist;
    @FindBy(xpath = "//p[@title='-1']")
    private WebElement secondResult;
    @FindBy(xpath = "//p[@data-inp ='cos(pi)']")
    private WebElement secondInputHist;
    @FindBy(xpath = "//p[@title='9']")
    private WebElement thirdResult;
    @FindBy(xpath = "//p[@data-inp ='sqrt(81)']")
    private WebElement thirdInputHist;

    public MainPage() {
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver,this);
        checkConsentFirstExist();
        checkConsentSecondExist();
    }

     private MainPage checkConsentFirstExist(){ //for close or ignore second first privacy windows
        int consentListCount = consentList.size();
        if(consentListCount == 1) {
            consent.click(); //click "consent"
        } else if (consentListCount == 0) {
            System.out.println("Consent doesn't exist. Go to the next step");
        }
         return this;
    }

    private MainPage checkConsentSecondExist(){ //for close or ignore second start privacy windows
        int consentList2Count = consentList2.size();
        if(consentList2Count == 1) {
            consent2.click(); //click 2 "consent"
        } else if (consentList2Count == 0) {
            System.out.println("Consent2 doesn't exist. Go to the next step");
        }
        return this;
    }

    private MainPage timeWait(int Millis){ //for waiting
        try {
            Thread.sleep(Millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    //1. Calculate 35*999+(100/4)= and assert the correct result 34990.
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
        timeWait(5000);
        assertEquals("34990", inputField.getAttribute("value")); //assert from insert field
        assertEquals("34990", firstResult.getAttribute("title")); //assert from history result (Devtools)
        BtnClear.click();
        return this;
    }

    //2. Calculate cos(pi) with the rad radio button and assert the correct result -1.
    public MainPage checkCosinusCalculation(){
        BtnCos.click();
        checkBoxRad.click();
        BtnPi.click();
        BtnParanR.click();
        BtnCalc.click();
        timeWait(5000);
        assertEquals("-1", inputField.getAttribute("value")); //assert from insert field
        assertEquals("-1", secondResult.getAttribute("title")); //assert from history result (Devtools)
        BtnClear.click();
        return this;
    }

    // 3. Calculate sqrt(81) and assert the correct result 9.
    public MainPage checkSqrtCalculation(){
        Btn8.click();
        Btn1.click();
        BtnSqrt.click();
        BtnCalc.click();
        timeWait(5000);
        assertEquals("9", inputField.getAttribute("value")); //assert from insert field
        assertEquals("9", thirdResult.getAttribute("title")); //assert from history result (Devtools)
        BtnClear.click();
        return this;
    }

    //4. Press history dropdown and assert that the list contains the 3 operations
    //executed e.g. 35*999+(100/4)=, cos(pi), sqrt(81)
    public MainPage checkHistInCalc(){
        listOfHist.click();
        timeWait(5000);
        assertEquals("35*999+(100/4)", firstInputHist.getAttribute("data-inp")); // assert 1 res from list
        assertEquals("cos(pi)", secondInputHist.getAttribute("data-inp")); // assert 1 res from list
        assertEquals("sqrt(81)", thirdInputHist.getAttribute("data-inp")); // assert 1 res from list
        return this;
    }

}
