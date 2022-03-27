package ru.gb.lessons.lesson6;

import org.junit.jupiter.api.Test;
import ru.gb.lessons.lesson6.pages.MainPage;

public class CommentsTest extends BaseTest {

    @Test
    void addCommentTest() {
        new MainPage(webDriver)
                .goToFirstProductPage()
                .goToProductScore()
                .createReview()
                .checkUnableToMakeReviewWithoutAuthorization();
    }
}
