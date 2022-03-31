package ru.gb.lessons.lesson6;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.gb.lessons.lesson6.pages.FavoritesPage;
import ru.gb.lessons.lesson6.pages.MainPage;

@DisplayName("Избранное")
public class FavoritesTest extends BaseTest {

    FavoritesPage favoritesPage;
    final static By dressesLocator  = By.xpath("//a[@href='/brand/1001-dress-139187046/category/odezhda-obuv-i-aksessuary-7500/']");
    final static String dressesPageName  = "1001 Dress";

    @BeforeEach
    void addProductToFavorites() {
         favoritesPage = new MainPage(webDriver)
                .getHeader()
                .goToAllBrandsPage()
                .goToClothesBrandsPage()
                .goToProductsPage(dressesPageName, dressesLocator)
                .addProductToFavorites()
                .getHeader()
                .goToFavorites();
    }

    @Test
    @DisplayName("Добавление товара в избранное")
    @Severity(SeverityLevel.NORMAL)
    @Description("Успешное добавление товара в избранное")
    void addProductToFavoritesTest() {
        favoritesPage
                .checkSelectedProducts();
    }

    @Test
    @DisplayName("Удаление товара из избранного")
    @Severity(SeverityLevel.NORMAL)
    @Description("Успешное удаление товара из избранного")
    void deleteProductFromFavoritesTest() {
        favoritesPage
                .deleteFromFavorites()
                .refresh()
                .checkFavoritesAreEmpty();
    }
}
