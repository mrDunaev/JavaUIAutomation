package ru.gb.lessons.lesson5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class FavoritesTest extends BaseTest {

    @BeforeEach
    void addProductToFavorites() {
        By brandLocator = By.xpath("//a[text()='Бренды']");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(brandLocator));
        webDriver.findElement(brandLocator).click();

        By clothesLocator = By.xpath("//a[@href='https://www.ozon.ru/brand/odezhda-obuv-i-aksessuary/']");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(clothesLocator));
        webDriver.findElement(clothesLocator).click();

        By anyClothesBrandLocator = By.xpath("//a[@href='/brand/1001-dress-139187046/category/odezhda-obuv-i-aksessuary-7500/']");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(anyClothesBrandLocator));
        webDriver.findElement(anyClothesBrandLocator).click();

        By heartLocator = By.xpath("//div[@interactive='true']/div/button");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(heartLocator));
        webDriver.findElement(heartLocator).click();

        By favoritesLocator = By.xpath("//a[@href='/my/favorites']");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(favoritesLocator));
        webDriver.findElement(favoritesLocator).click();
    }

    @Test
    void addProductToFavoritesTest() {
        By favoritesProductsLocator = By.xpath("//div[@data-widget='paginator']");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(favoritesProductsLocator));
        List<String> products = webDriver.findElement(favoritesProductsLocator)
                .findElements(By.xpath(".//a/span/span"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        assertThat(products).containsAnyOf("Платье 1001 Dress", "Юбка 1001 Dress","Блузка 1001 Dress","Жилет 1001 Dress");
    }

    @Test
    void deleteProductFromFavoritesTest() {
        By heartInFavoritesLocator = By.xpath("//div[@interactive='true']/div/button");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(heartInFavoritesLocator));
        webDriver.findElement(heartInFavoritesLocator).click();

        webDriver.navigate().refresh();

        By noProductsInFavorites = By.xpath("//div[@data-widget='paginator']//span[1]");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(noProductsInFavorites));
        String noProductsInFavoritesMessage = webDriver.findElement(noProductsInFavorites).getText();

        assertThat(noProductsInFavoritesMessage).isEqualTo("В Избранном пока ничего нет");
    }
}
