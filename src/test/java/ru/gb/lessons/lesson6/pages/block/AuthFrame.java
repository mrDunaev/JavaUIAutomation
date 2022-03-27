package ru.gb.lessons.lesson6.pages.block;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.gb.lessons.lesson6.pages.BaseView;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthFrame extends BaseView {

    public AuthFrame(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkUnableToMakeReviewWithoutAuthorization() {
        /*
        Вы рекомендовали поменять локатор на //button[.='Получить код'], но не теряется ли тогда смысл ассерта?
        Ведь я изначально ищу кнопку с таким текстом, смысл потом проверять, что ее текст именно такой?
        Или как-то по-другому оформить ассерт?
        */
        By getCodeButton = By.xpath("//div[@data-widget='loginOrRegistration']/div/div/button/span/span");
        assertThat(getElementText(getCodeButton)).isEqualTo("Получить код");
    }
}
