package ru.gb.lessons.lesson6.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class FavoritesPage extends BasePage {

    public FavoritesPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Проверить, что выбраны товары бренда '1001 Dress'")
    public void checkSelectedProducts() {
        By favoritesProductsLocator = By.xpath("//div[@data-widget='paginator']");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(favoritesProductsLocator));
        List<String> products = webDriver.findElement(favoritesProductsLocator)
                .findElements(By.xpath(".//a/span/span"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        assertThat(products).containsAnyOf("Платье 1001 Dress", "Юбка 1001 Dress","Блузка 1001 Dress","Жилет 1001 Dress");
    }

    @Step("Кликнуть на значок сердца у товара в избранном")
    public FavoritesPage deleteFromFavorites() {
        By heartInFavoritesLocator = By.xpath("//div[@interactive='true']/div/button");
        findAndClickElement(heartInFavoritesLocator);
        return this;
    }

    @Step("Проверить, что на странице отображается надпись 'В Избранном пока ничего нет'")
    public void checkFavoritesAreEmpty() {
        By noProductsInFavorites = By.xpath("//div[@data-widget='paginator']//span[1]");
        assertThat(getElementText(noProductsInFavorites)).isEqualTo("В Избранном пока ничего нет");
    }

    @Override
    public FavoritesPage refresh() {
        return (FavoritesPage) super.refresh();
    }
}
