package ru.gb.lessons.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class CartPage extends BasePage {

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkCartIsNotEmpty() {
        By orderingButton = By.xpath("//div[@text='Перейти к оформлению' and @size='xxl']/button/span/span");
        assertThat(getElementText(orderingButton)).isEqualTo("Перейти к оформлению");
    }

    public CartPage deleteAllFromCart() {
        By deleteAllButton = By.xpath("//div[@data-widget='controls']/span");
        findAndClickElement(deleteAllButton);
        return this;
    }

    public CartPage confirmDeletion() {
        By confirmDeletionButton = By.xpath("//button/span/span[text()='Удалить']");
        findAndClickElement(confirmDeletionButton);
        return this;
    }

    public void checkCartIsEmpty() {
        By noProductsInCart = By.xpath("//div[@data-widget='emptyCart']/h1");
        assertThat(getElementText(noProductsInCart)).isEqualTo("Корзина пуста");
    }

    @Override
    public CartPage refresh() {
        return (CartPage) super.refresh();
    }
}
