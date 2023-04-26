package com.technicaltest.factorial5.test;

import com.technicaltest.factorial5.util.pages.FactorialPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StepDefinitions {
    private static WebDriver driver;
    private FactorialPage factorialPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Given("I am on the Factorial calculator page")
    public void i_am_on_the_factorial_calculator_page() {
        factorialPage = new FactorialPage(driver);
        factorialPage.navigateTo();
    }

    @When("I enter {string} as the number")
    public void i_enter_as_the_number(String number) {
        factorialPage.enterNumber(number);
    }

    @When("I click the calculate button")
    public void i_click_the_calculate_button() throws InterruptedException {
        factorialPage.clickCalculate();
    }

    @Then("the result should be {string}")
    public void the_result_should_be(String expectedResult) {
        String result = factorialPage.getResult();
        Assertions.assertTrue(result.contains(expectedResult));
    }

    @After
    public void teardown() {
        driver.close();
    }
}
