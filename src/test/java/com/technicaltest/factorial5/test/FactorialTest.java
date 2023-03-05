package com.technicaltest.factorial5.test;


import com.technicaltest.factorial5.util.pages.FactorialPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class FactorialTest {
    private WebDriver driver;

    public FactorialTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testFactorial() throws InterruptedException {
        FactorialPage factorialPage = new FactorialPage(driver);
        factorialPage.navigateTo();
        String result = factorialPage.calculateFactorial(5);
        Assertions.assertTrue(result.contains("120"));
        driver.quit();
    }
}
