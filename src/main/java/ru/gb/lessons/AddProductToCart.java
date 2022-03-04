package ru.gb.lessons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddProductToCart
{
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = WebDriverManager.chromedriver().create();

        webDriver.get("https://www.ozon.ru/");

        webDriver.manage().window().setSize(new Dimension(1500, 1100));

        By electronicLocator = By.xpath("//a[text()='Электроника']");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(electronicLocator));
        webDriver.findElement(electronicLocator).click();

        By smartphoneLocator = By.xpath("//a[@href='/category/smartfony-15502/']");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(smartphoneLocator));
        webDriver.findElement(smartphoneLocator).click();

        By anyProductToCartButton = By.xpath("//button/span/span[text()='В корзину']");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(anyProductToCartButton));
        webDriver.findElement(anyProductToCartButton).click();

        By cartLocator = By.xpath("//a[@href='/cart']");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(cartLocator));
        webDriver.findElement(cartLocator).click();

        System.out.print("TEST 1:\n");
        webDriver.findElement(By.className("at6"))
                .findElements(By.xpath("./div[@class='as3']"))
                .forEach(product -> System.out.print(product.findElement(By.className("s4a")).getText() + " "));
        System.out.println();

        Thread.sleep(2000);

        webDriver.quit();
    }
}
