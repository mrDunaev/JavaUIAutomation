package ru.gb.lessons.lesson6.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.gb.lessons.lesson6.pages.block.AuthFrame;

import java.time.Duration;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Кликнуть на значок с пятью звездами под названием товара")
    public ProductPage goToProductScore() {
        By productScoreLocator = By.xpath("//div[@data-widget='webReviewProductScore']/div/div/div");
        findAndClickElement(productScoreLocator);
        return this;
    }

    @Step("Кликнуть на кнопку 'Написать отзыв'")
    public AuthFrame createReview() {
        By createReviewButton = By.xpath("//div[@data-widget='createReview']/div/button");
        By authFrameLocator = By.xpath("//iframe[@id='authFrame']");
        findAndClickElement(createReviewButton);
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(authFrameLocator));
        return new AuthFrame(webDriver);
    }
}
