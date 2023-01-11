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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class MainPage extends BaseSeleniumPage {


    //List<WebElement> consentList = driver.findElements(By.xpath("//button[@value = 'consent']")).size();


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

    //check-boxes:
    @FindBy(xpath = "//input[@value = 'rad']")
    private WebElement checkBoxRad;

    //result values:
    @FindBy(xpath = "//p[@title='34990']")
    private WebElement firstResult;

    @FindBy(xpath = "//p[@title='-1']")
    private WebElement secondResult;


    public MainPage() {
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver,this);
        checkConsentFirstExist();
        checkConsentSecondExist();
    }

     private MainPage checkConsentFirstExist(){

        int consentListCount = consentList.size();
        if(consentListCount == 1) {
            consent.click(); //click "consent"
        } else if (consentListCount == 0) {
            System.out.println("Consent doesn't exist. Go next step");
        }
         return this;
    }

    private MainPage checkConsentSecondExist(){

        int consentList2Count = consentList2.size();
        if(consentList2Count == 1) {
            consent2.click(); //click 2 "consent"
        } else if (consentList2Count == 0) {
            System.out.println("Consent2 doesn't exist. Go next step");
        }
        return this;
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
        //String resultFromFieldString = inputField.getAttribute("value");
        //int resultFromField = Integer.valueOf(resultFromFieldString);

        //System.out.println(resultFromField);
        //int calculationWithParentheses = (1 + 1) + 3 * (2 + 5);
        //System.out.println(calculationWithParentheses); // prints 23
        assertEquals("34990", firstResult.getAttribute("title"));
        System.out.println(firstResult.getAttribute("title"));
        BtnClear.click();
        return this;
    }

    public MainPage checkCosinusCalculation(){ //second task, check cosinus
        BtnCos.click();
        checkBoxRad.click();
        BtnPi.click();
        BtnParanR.click();
        BtnCalc.click();
        assertEquals("-1", secondResult.getAttribute("title"));
        System.out.println(secondResult.getAttribute("title"));
        return this;
    }


}
