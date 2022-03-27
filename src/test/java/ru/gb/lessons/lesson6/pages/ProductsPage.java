package ru.gb.lessons.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductsPage addProductToCart() {
        By firstProductToCartButton = By.xpath("//button//span[text()='В корзину']");
        findAndClickElement(firstProductToCartButton);
        return this;
    }

    public ProductsPage addProductToFavorites() {
        By heartLocator = By.xpath("//div[@interactive='true']/div/button");
        findAndClickElement(heartLocator);
        return this;
    }
}
