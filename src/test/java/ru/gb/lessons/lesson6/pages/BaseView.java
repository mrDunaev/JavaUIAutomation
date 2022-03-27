package ru.gb.lessons.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseView {
    protected WebDriver webDriver;

    public BaseView(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void findAndClickElement(By locator) {
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(locator));
        webDriver.findElement(locator).click();
    }

    public String getElementText(By locator) {
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(locator));
        return webDriver.findElement(locator).getText();
    }
}
