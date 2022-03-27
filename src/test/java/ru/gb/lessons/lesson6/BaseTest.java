package ru.gb.lessons.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    protected WebDriver webDriver;

    @BeforeEach
    void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imageEnabled=false");
        webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.get("https://www.ozon.ru/");
        webDriver.manage().window().setSize(new Dimension(1500, 1100));
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        webDriver.quit();
    }
}
