package ru.gb.lessons.lesson6.pages.block;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.gb.lessons.lesson6.pages.*;

public class MainHeader extends BaseView {

    public MainHeader(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Кликнуть на ссылку 'Электроника'")
    public ElectronicPage goToElectronicPage() {
        By electronicLocator = By.xpath("//a[text()='Электроника']");
        findAndClickElement(electronicLocator);
        return new ElectronicPage(webDriver);
    }

    @Step("Кликнуть на ссылку 'Корзина'")
    public CartPage goToCart() {
        By cartLocator = By.xpath("//a[@href='/cart']");
        findAndClickElement(cartLocator);
        return new CartPage(webDriver);
    }

    @Step("Кликнуть на ссылку 'Бренды'")
    public AllBrandsPage goToAllBrandsPage() {
        By brandsLocator = By.xpath("//a[text()='Бренды']");
        findAndClickElement(brandsLocator);
        return new AllBrandsPage(webDriver);
    }

    @Step("Кликнуть на ссылку 'Избранное'")
    public FavoritesPage goToFavorites() {
        By favoritesLocator = By.xpath("//a[@href='/my/favorites']");
        findAndClickElement(favoritesLocator);
        return new FavoritesPage(webDriver);
    }
}
