package test.profile;

import org.testng.annotations.Test;
import pages.authorization.AuthorizationPage;
import pages.profile.ProfilePage;
import services.authorization.AuthorizationService;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class ChangePasswordFromProfile {

    private final AuthorizationService authorizationService = new AuthorizationService();
    private final AuthorizationPage authorizationPage = new AuthorizationPage();
    private final ProfilePage profilePage = new ProfilePage();

    @Test // Тест с проверкой изменения пароля через профиль и вход по новому паролю
    public void ChangePasswordInProfile() {
        String email = "sadart1998@mail.ru";
        String oldPassword = "123qweasdzxc";
        String newPassword = "123qweasd";
        String name = "Артём";

        authorizationService.openAutorizationPage();
        authorizationPage.setEmail(email);
        authorizationPage.setPassword(oldPassword);
        authorizationPage.getEnterButton().shouldBe(visible).click();
        profilePage.getLinkProfileHeader().shouldBe(visible).click();
        profilePage.getName().shouldHave(value(name)); // Проверка данных пользака
        profilePage.getEmail().shouldHave(value(email)); // Проверка данных пользака
        profilePage.setPassword(newPassword);
        profilePage.getSaveButton().shouldBe(visible).click();
        profilePage.getExitButton().shouldBe(visible).click();
        webdriver().shouldHave(url( authorizationService.baseUrl + "/login")); // только после этого костыля с проверкой url повторно вносится текст в поля авторизации,
        // без него поля остаются пустыми, если выполнять следующие строки кода и тест падает
        authorizationPage.setEmail(email);
        authorizationPage.setPassword(newPassword);
        authorizationPage.getEnterButton().shouldBe(visible).click();
    }

    @Test // Тест с проверкой кнопок меню профиля и истории заказов (сделал для проверки разделения кнопок в хэдере и меню)
    public void checkProfileInMenu() {
        String email = "sadart1998@mail.ru";
        String Password = "123qweasd";

        authorizationService.openAutorizationPage();
        authorizationPage.setEmail(email);
        authorizationPage.setPassword(Password);
        authorizationPage.getEnterButton().shouldBe(visible).click();
        profilePage.getLinkProfileHeader().shouldBe(visible).click();
        profilePage.getLinkHistoryOrders().click();
        profilePage.getLinkProfileMenu().shouldBe(visible).click();
    }
}
