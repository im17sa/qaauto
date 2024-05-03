package pages.registration;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.element;

public class RegistrationPage {

    //Находит поля для ввода, ссылки и кнопки XPath выражению
    private final By NAME = By.cssSelector("input[name='name']");
    private final By EMAIL = By.cssSelector("input[name='email']");
    private final By PASSWORD = By.cssSelector("input[name='password']");
    private final By REGISTRATION_BUTTON = By.cssSelector("button[type='submit']");
    private final By LINK_AUTHORIZATION = By.cssSelector("a.pl-2.common_link__2bwt_");
    private final By VALIDATOR = By.cssSelector("p.common_error__2wD2J.text.text_type_main-default.pb-6");

    //Методы для взаимодействия с элементами
    public SelenideElement getName() {
        return element(NAME);
    }

    public void setName(String name) {
        getName().setValue(name);
    }

    public SelenideElement getEmail() {
        return element(EMAIL);
    }

    public void setEmail(String email) {
        getEmail().setValue(email);
    }

    public SelenideElement getPassword() {
        return element(PASSWORD);
    }

    public void setPassword(String password) {
        getPassword().setValue(password);
    }

    public SelenideElement getRegistrationButton() {
        return element(REGISTRATION_BUTTON);
    }

    public SelenideElement getValidator() {
        return element(VALIDATOR);
    }

    public SelenideElement getLinkAuthorization() {
        return element(LINK_AUTHORIZATION);
    }
}
