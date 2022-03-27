package ru.gb.lessons.lesson6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.gb.lessons.lesson6.pages.FavoritesPage;
import ru.gb.lessons.lesson6.pages.MainPage;

public class FavoritesTest extends BaseTest {

    FavoritesPage favoritesPage;

    @BeforeEach
    void addProductToFavorites() {
         favoritesPage = new MainPage(webDriver)
                .getHeader()
                .goToAllBrandsPage()
                .goToClothesBrandsPage()
                .goToProductsPage(By.xpath("//a[@href='/brand/1001-dress-139187046/category/odezhda-obuv-i-aksessuary-7500/']"))
                .addProductToFavorites()
                .getHeader()
                .goToFavorites();
    }

    @Test
    void addProductToFavoritesTest() {
        favoritesPage
                .checkSelectedProducts();
    }

    @Test
    void deleteProductFromFavoritesTest() {
        favoritesPage
                .deleteFromFavorites()
                .refresh()
                .checkFavoritesAreEmpty();
    }
}
