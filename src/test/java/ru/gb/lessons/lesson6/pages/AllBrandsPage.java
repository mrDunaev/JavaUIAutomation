package ru.gb.lessons.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllBrandsPage extends BasePage {

    public AllBrandsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ClothesBrandsPage goToClothesBrandsPage() {
        By clothesLocator = By.xpath("//a[@href='https://www.ozon.ru/brand/odezhda-obuv-i-aksessuary/']");
        findAndClickElement(clothesLocator);
        return new ClothesBrandsPage(webDriver);
    }
}
