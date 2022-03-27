package ru.gb.lessons.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductPage goToFirstProductPage() {
        By firstProductLocator = By.xpath("//div[@data-widget='paginator']//a");
        findAndClickElement(firstProductLocator);
        return new ProductPage(webDriver);
    }
}
