package pages.resetPassword;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.element;

public class ResetPasswordPage {

    //Находит поля для ввода, ссылки и кнопки XPath выражению
    private final By PASSWORD = By.xpath("//input[@name='password']");
    private final By CODE_MESSAGE = By.xpath("//input[@name='token']");
    private final By SAVE_BUTTON = By.xpath("//button[text()='Сохранить']");
    private final By LINK_AUTHORIZATION = By.xpath("//a[text()='Войти']");

    //Методы для взаимодействия с элементами
    public SelenideElement getPassword() {
        return element(PASSWORD);
    }

    public void setPassword(String password) {
        getPassword().setValue(password);
    }

    public SelenideElement getCodeMessage() {
        return element(CODE_MESSAGE);
    }

    public void setCodeMessage(String codeMessage) {
        getCodeMessage().setValue(codeMessage);
    }

    public SelenideElement getSaveButton() {
        return element(SAVE_BUTTON);
    }

    public SelenideElement getLinkAuthorization() {
        return element(LINK_AUTHORIZATION);
    }
}
