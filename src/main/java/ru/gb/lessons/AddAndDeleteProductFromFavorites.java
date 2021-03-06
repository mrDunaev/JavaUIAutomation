package ru.gb.lessons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddAndDeleteProductFromFavorites {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imageEnabled=false");
        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();

        webDriver.get("https://www.ozon.ru/");

        webDriver.manage().window().setSize(new Dimension(1500, 1100));

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

        By favoritesProductsLocator = By.xpath("//div[@data-widget='paginator']");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(favoritesProductsLocator));
        System.out.print("TEST 2:\n");
        webDriver.findElement(favoritesProductsLocator)
                .findElements(By.xpath(".//a/span/span"))
                .forEach(product -> System.out.print(product.getText() + " "));
        System.out.println();

        By heartInFavoritesLocator = By.xpath("//div[@interactive='true']/div/button");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(heartInFavoritesLocator));
        webDriver.findElement(heartInFavoritesLocator).click();

        webDriver.navigate().refresh();

        By noProductsInFavorites = By.xpath("//div[@data-widget='paginator']//span[1]");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(noProductsInFavorites));
        System.out.println("TEST 3:");
        System.out.print(webDriver.findElement(noProductsInFavorites).getText());

        Thread.sleep(2000);

        webDriver.quit();
    }
}
