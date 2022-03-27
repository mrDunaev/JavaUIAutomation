package ru.gb.lessons.lesson6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.gb.lessons.lesson6.pages.CartPage;
import ru.gb.lessons.lesson6.pages.MainPage;

public class CartTest extends BaseTest {

    CartPage cartPage;

    @BeforeEach
    void addProductToCart() {
        cartPage =
                new MainPage(webDriver)
                .getHeader()
                .goToElectronicPage()
                .goToProductsPage(By.xpath("//a[@href='/category/smartfony-15502/']"))
                .addProductToCart()
                .getHeader()
                .goToCart();
    }

    @Test
    void addProductToCartTest() {
        cartPage
                .checkCartIsNotEmpty();
    }

    @Test
    void deleteProductFromCartTest() {
        cartPage
                .refresh()
                .deleteAllFromCart()
                .confirmDeletion()
                .checkCartIsEmpty();
    }
}
