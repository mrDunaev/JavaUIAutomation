package ru.gb.lessons.lesson6.pages;

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

    public ProductsPage goToProductsPage(By locator) {
        findAndClickElement(locator);
        return new ProductsPage(webDriver);
    }

    public BasePage refresh() {
        webDriver.navigate().refresh();
        return this;
    }
}
