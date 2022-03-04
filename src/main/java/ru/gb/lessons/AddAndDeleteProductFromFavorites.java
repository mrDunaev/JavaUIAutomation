package ru.gb.lessons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

        By anyClothesBrandLocator = By.xpath("//div[@class='zh4']/a[2]");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(anyClothesBrandLocator));
        webDriver.findElement(anyClothesBrandLocator).click();

        By heartLocator = By.xpath("//div[@class='y8h']/div[@interactive='true']/div/button");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(heartLocator));
        webDriver.findElement(heartLocator).click();

        By favoritesLocator = By.xpath("//a[@href='/my/favorites']");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(favoritesLocator));
        webDriver.findElement(favoritesLocator).click();

        System.out.print("TEST 2:\n");
        webDriver.findElement(By.className("ij4"))
                .findElements(By.className("yh5"))
                .forEach(product -> System.out.print(product.findElement(By.xpath("./a/span/span")).getText() + " "));
        System.out.println();

        By heartInFavoritesLocator = By.xpath("//div[@class='y8h']/div[@interactive='true']/div/button");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(heartInFavoritesLocator));
        webDriver.findElement(heartInFavoritesLocator).click();

        webDriver.navigate().refresh();

        System.out.println("TEST 3:");
        System.out.print(webDriver.findElement(By.xpath("//span[@class='eg8']")).getText());

        Thread.sleep(2000);

        webDriver.quit();
    }
}
