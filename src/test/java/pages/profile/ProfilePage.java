package pages.profile;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.element;

public class ProfilePage {

    //Находит поля для ввода, ссылки и кнопки XPath выражению
    private final By NAME = By.xpath("//input[@name='name']");
    private final By EMAIL = By.xpath("//input[@name='email']");
    private final By PASSWORD = By.xpath("//input[@name='password']");
    private final By LINK_PROFILE_HEADER = By.xpath("//a[contains(@class, 'app-header_link_position_last__3skWP')]"); /*универсальный класс для ссылки профиля на главной и в самом профиле, сделан
    для того чтобы отличать в первую очередь профиль в хэдере и в меню на странице профиля*/
    private final By LINK_PROFILE_MENU = By.xpath("//a[contains(@class, 'profile-menu_link__1GXQJ') and contains(@href, '/profile')]");/* уникальный поиск элемента для того
    чтобы во-первых не было пересечений с профилем в хэдере, во вторых нужно было дополнительное условие по href, т.к. в зависимости
    от активности кнопки в меню профиля класс менялся между "История заказов" и "Профиль", он динамический*/
    private final By LINK_HISTORY_ORDERS = By.xpath("//a[text()='История заказов']");
    private final By EXIT_BUTTON = By.xpath("//button[contains(text(), 'Выход')]");// Изменил с полного совпадения, потому что при полном совпадении не всегда кликает на кноку (не знаю по каким причинам)

    private final By SAVE_BUTTON = By.xpath("//button[text()='Сохранить']");
    private final By CANCEL_BUTTON = By.xpath("//button[text()='Отменить]");

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

    public SelenideElement getLinkProfileHeader() {
        return element(LINK_PROFILE_HEADER);
    }

    public SelenideElement getLinkProfileMenu() {
        return element(LINK_PROFILE_MENU);
    }

    public SelenideElement getLinkHistoryOrders() {
        return element(LINK_HISTORY_ORDERS);
    }

    public SelenideElement getExitButton() {
        return element(EXIT_BUTTON);
    }

    public SelenideElement getSaveButton() {
        return element(SAVE_BUTTON);
    }

    public SelenideElement getCancelButton() {
        return element(CANCEL_BUTTON);
    }
}
