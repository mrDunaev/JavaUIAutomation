package ru.gb.lessons.lesson6;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.gb.lessons.lesson6.pages.CartPage;
import ru.gb.lessons.lesson6.pages.MainPage;

@DisplayName("Корзина")
public class CartTest extends BaseTest {

    CartPage cartPage;
    final static By smartphonesLocator  = By.xpath("//a[@href='/category/smartfony-15502/']");
    final static String smartphonesPageName  = "Смартфоны";

    @BeforeEach
    void addProductToCart() {
        cartPage =
                new MainPage(webDriver)
                .getHeader()
                .goToElectronicPage()
                .goToProductsPage(smartphonesPageName, smartphonesLocator)
                .addProductToCart()
                .getHeader()
                .goToCart();
    }

    @Test
    @DisplayName("Добавление товара в корзину")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Успешное добавление товара в корзину")
    void addProductToCartTest() {
        cartPage
                .checkCartIsNotEmpty();
    }

    @Test
    @DisplayName("Удаление товара из корзины")
    @Severity(SeverityLevel.NORMAL)
    @Description("Успешное удаление товара из корзины")
    void deleteProductFromCartTest() {
        cartPage
                .refresh()
                .deleteAllFromCart()
                .confirmDeletion()
                .checkCartIsEmpty();
    }
}
