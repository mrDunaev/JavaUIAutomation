package ru.gb.lessons.lesson6.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllBrandsPage extends BasePage {

    public AllBrandsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Кликнуть на ссылку 'Одежда, обувь и аксессуары'")
    public ClothesBrandsPage goToClothesBrandsPage() {
        By clothesLocator = By.xpath("//a[@href='https://www.ozon.ru/brand/odezhda-obuv-i-aksessuary/']");
        findAndClickElement(clothesLocator);
        return new ClothesBrandsPage(webDriver);
    }
}
