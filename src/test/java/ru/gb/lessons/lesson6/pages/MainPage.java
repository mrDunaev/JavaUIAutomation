package ru.gb.lessons.lesson6.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Кликнуть на первый товар на странице")
    public ProductPage goToFirstProductPage() {
        By firstProductLocator = By.xpath("//div[@data-widget='paginator']//a");
        findAndClickElement(firstProductLocator);
        return new ProductPage(webDriver);
    }
}
