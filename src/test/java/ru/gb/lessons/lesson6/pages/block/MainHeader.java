package ru.gb.lessons.lesson6.pages.block;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.gb.lessons.lesson6.pages.*;

public class MainHeader extends BaseView {

    public MainHeader(WebDriver webDriver) {
        super(webDriver);
    }

    public ElectronicPage goToElectronicPage() {
        By electronicLocator = By.xpath("//a[text()='Электроника']");
        findAndClickElement(electronicLocator);
        return new ElectronicPage(webDriver);
    }

    public CartPage goToCart() {
        By cartLocator = By.xpath("//a[@href='/cart']");
        findAndClickElement(cartLocator);
        return new CartPage(webDriver);
    }

    public AllBrandsPage goToAllBrandsPage() {
        By brandsLocator = By.xpath("//a[text()='Бренды']");
        findAndClickElement(brandsLocator);
        return new AllBrandsPage(webDriver);
    }

    public FavoritesPage goToFavorites() {
        By favoritesLocator = By.xpath("//a[@href='/my/favorites']");
        findAndClickElement(favoritesLocator);
        return new FavoritesPage(webDriver);
    }
}
