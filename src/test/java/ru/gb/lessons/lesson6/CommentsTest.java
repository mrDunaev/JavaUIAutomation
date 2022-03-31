package ru.gb.lessons.lesson6;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.lessons.lesson6.pages.MainPage;

@DisplayName("Комментарии")
public class CommentsTest extends BaseTest {

    @Test
    @DisplayName("Добавление комментария незарегистрированным пользователем")
    @Severity(SeverityLevel.NORMAL)
    @Description("При попытке незарегистрированного пользователя добавить комментарий сайт предлагает залогиниться")
    void addCommentTest() {
        new MainPage(webDriver)
                .goToFirstProductPage()
                .goToProductScore()
                .createReview()
                .checkUnableToMakeReviewWithoutAuthorization();
    }
}
