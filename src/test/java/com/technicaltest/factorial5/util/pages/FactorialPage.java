package com.technicaltest.factorial5.util.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FactorialPage {

    private WebDriver driver;
    private By numberField = By.id("number");
    private By calculateButton = By.id("getFactorial");
    private By resultDiv = By.id("resultDiv");

    public FactorialPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo() {
        driver.get("https://qainterview.pythonanywhere.com/");
    }

    public void enterNumber(String number) {
        driver.findElement(numberField).sendKeys(number);
    }

    public void clickCalculate() throws InterruptedException {
        driver.findElement(calculateButton).click();
        Thread.sleep(1000);
    }

    public String getResult() {
        return driver.findElement(resultDiv).getText();
    }
    public String calculateFactorial(int n) throws InterruptedException {
        driver.findElement(numberField).sendKeys(String.valueOf(n));
        driver.findElement(calculateButton).click();
        Thread.sleep(1000);
        return driver.findElement(resultDiv).getText();
    }
}



