package pages.forgotPassword;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.element;

public class ForgotPasswordPage {

    //Находит поля для ввода, ссылки и кнопки XPath выражению
    private final By EMAIL = By.xpath("//input[@name='email']");
    private final By RECOVER_BUTTON = By.xpath("//button[text()='Восстановить']");
    private final By LINK_AUTHORIZATION = By.xpath("//a[text()='Войти']");

    //Методы для взаимодействия с элементами
    public SelenideElement getEmail() {
        return element(EMAIL);
    }

    public void setEmail(String email) {
        getEmail().setValue(email);
    }

    public SelenideElement getRecoverButton() {
        return element(RECOVER_BUTTON);
    }

    public SelenideElement getLinkAuthorization() {
        return element(LINK_AUTHORIZATION);
    }
}
