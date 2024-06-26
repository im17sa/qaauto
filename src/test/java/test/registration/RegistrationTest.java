package test.registration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.registration.RegistrationPage;
import services.registration.RegistrationService;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static java.time.Duration.ofSeconds;

public class RegistrationTest {

    private final RegistrationService registrationService = new RegistrationService();
    private final RegistrationPage registrationPage = new RegistrationPage();

    @Test // Тест регистрации пользователя
    public void checkRegistration() {
        String name = "Artyom";
        String email = "self-03shgg@mail.ru";
        String password = "022093Aa";

        registrationService.openRegistrationPage();
        registrationPage.setName(name);
        registrationPage.setEmail(email);
        registrationPage.setPassword(password);
        registrationPage.getRegistrationButton().shouldBe(visible).click();
    }

    @Test // Тест проверки регистрации с существующей почтой
    public void checkRegistrationValidator() {
        String name = "Artyom";
        String email = "alex20-03sh@mail.ru";
        String password = "022093Aa";

        registrationService.openRegistrationPage();
        registrationPage.setName(name);
        registrationPage.setEmail(email);
        registrationPage.setPassword(password);
        registrationPage.getRegistrationButton().shouldBe(visible, ofSeconds(10)).click(); // изменил для тренировки с конфликтами
        registrationPage.getValidator()
                        .shouldBe(visible.because("Ожидаемая валидация существующего пользователя отсутствует"), ofSeconds(10)); // изменил для тренировки с конфликтами
    }

    @Test // Тест перехода со страницы регистрации на авторизацию
    public void switchingToAuthorization() {
        registrationService.openRegistrationPage();
        registrationPage.getLinkAuthorization().shouldBe(visible).click();
    }

    @AfterMethod
    public void closeTheBrowser() {
        closeWebDriver();
    }
}
