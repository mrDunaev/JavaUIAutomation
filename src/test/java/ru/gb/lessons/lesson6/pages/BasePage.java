package ru.gb.lessons.lesson6.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.gb.lessons.lesson6.pages.block.MainHeader;

public class BasePage extends BaseView {

    public BasePage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainHeader getHeader() {
        return new MainHeader(webDriver);
    }

    @Step("Перейти на страницу с товарами '{pageName}'")
    public ProductsPage goToProductsPage(String pageName, By locator) {
        findAndClickElement(locator);
        return new ProductsPage(webDriver);
    }

    @Step("Обновить страницу")
    public BasePage refresh() {
        webDriver.navigate().refresh();
        return this;
    }
}
