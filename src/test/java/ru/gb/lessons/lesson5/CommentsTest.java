package ru.gb.lessons.lesson5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class CommentsTest extends BaseTest{

    @Test
    void addCommentTest() {
        By firstProductLocator = By.xpath("//div[@data-widget='paginator']//a");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(firstProductLocator));
        webDriver.findElement(firstProductLocator).click();

        By productScoreLocator = By.xpath("//div[@data-widget='webReviewProductScore']/div/div/div");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(productScoreLocator));
        webDriver.findElement(productScoreLocator).click();

        By createReviewButton = By.xpath("//div[@data-widget='createReview']/div/button");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(createReviewButton));
        webDriver.findElement(createReviewButton).click();

        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='authFrame']")));

        By getCodeButton = By.xpath("//div[@data-widget='loginOrRegistration']/div/div/button/span/span");
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(getCodeButton));
        String orderingButtonText = webDriver.findElement(getCodeButton).getText();

        assertThat(orderingButtonText).isEqualTo("Получить код");
    }
}
