package ru.gb.lessons.lesson5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class CartTest extends BaseTest{

    @BeforeEach
    void addProductToCart() {
        By electronicLocator = By.xpath("//a[text()='Электроника']");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(electronicLocator));
        webDriver.findElement(electronicLocator).click();

        By smartphoneLocator = By.xpath("//a[@href='/category/smartfony-15502/']");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(smartphoneLocator));
        webDriver.findElement(smartphoneLocator).click();

        By anyProductToCartButton = By.xpath("//div[@type='addToCartButton']//button//span[text()='В корзину']");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(anyProductToCartButton));
        webDriver.findElement(anyProductToCartButton).click();

        By cartLocator = By.xpath("//a[@href='/cart']");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(cartLocator));
        webDriver.findElement(cartLocator).click();
    }

    @Test
    void addProductToCartTest() {
        By orderingButton = By.xpath("//div[@text='Перейти к оформлению' and @size='xxl']");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(orderingButton));
        String orderingButtonText = webDriver.findElement(orderingButton).findElement(By.xpath("./button/span/span")).getText();

        assertThat(orderingButtonText).isEqualTo("Перейти к оформлению");
    }

    @Test
    void deleteProductFromCartTest() {
        webDriver.navigate().refresh();

        By deleteAllButton = By.xpath("//div[@data-widget='controls']/span");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(deleteAllButton));
        webDriver.findElement(deleteAllButton).click();

        //new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='avt-gtm-script']")));

        By confirmDeletionButton = By.xpath("//button/span/span[text()='Удалить']");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(confirmDeletionButton));
        webDriver.findElement(confirmDeletionButton).click();

        By noProductsInCart = By.xpath("//div[@data-widget='emptyCart']/h1");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(noProductsInCart));
        String noProductsInCartMessage = webDriver.findElement(noProductsInCart).getText();

        assertThat(noProductsInCartMessage).isEqualTo("Корзина пуста");
    }
}
