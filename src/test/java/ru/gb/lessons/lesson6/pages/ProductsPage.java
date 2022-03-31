package ru.gb.lessons.lesson6.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Кликнуть на кнопку 'В корзину' у первого товара в списке")
    public ProductsPage addProductToCart() {
        By firstProductToCartButton = By.xpath("//button//span[text()='В корзину']");
        findAndClickElement(firstProductToCartButton);
        return this;
    }

    @Step("Кликнуть на значок сердца у первого товара в списке")
    public ProductsPage addProductToFavorites() {
        By heartLocator = By.xpath("//div[@interactive='true']/div/button");
        findAndClickElement(heartLocator);
        return this;
    }
}
