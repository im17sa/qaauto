package pages.authorization;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.element;

public class AuthorizationPage {

  private final By EMAIL = By.xpath("//input[@name='email']");
  private final By PASSWORD = By.xpath("//input[@name='password']");
  private final By ENTER_BUTTON = By.xpath("//button[contains(text(), 'Войти')]");
  private final By LINK_REGISTER = By.xpath("//a[contains(text(), 'Зарегистрироваться')]");
  private final By LINK_FORGOT_PASSWORD = By.xpath("//a[contains(text(), 'Восстановить пароль')]");
  private final By POPUP_VALIDATOR = By.xpath("//*[text()='email or password are incorrect']"); //ищем точное совпадение

  public SelenideElement getEmail() { // Метод для получения доступа к полю ввода email, возвращает объект, имплементирующий интерфейс SelenideElement
    return element(EMAIL); // Метод element получает доступ к полю ввода EMAIL, который передали в аргументе
  }

  public void setEmail(String email) { // Метод, который принимает параметр email, вызывет метод getEmail, очищает и вставляет в поле переданный email
    getEmail().setValue(email); // получаем доступ к элементу к полю ввода Email, дальше с помощью метода setValue очищаем поле и вставляет строку с email, переданную в качестве аргумента
  }

  public SelenideElement getPassword() { // Метод для получения доступа к полю ввода password, возвращает объект, имплементирующий интерфейс SelenideElement
    return element(PASSWORD); // Метод element получает доступ к полю ввода password, который передали в аргументе
  }

  public void setPassword(String password) { // Метод, который принимает параметр password, вызывет метод getPassword, очищает и вставляет в поле переданный password
    getPassword().setValue(password); // получаем доступ к элементу к полю ввода password, дальше с помощью метода setValue очищаем поле и вставляет строку с password, переданную в качестве аргумента
  }

  public SelenideElement getEnterButton() { // Метод для получения  доступа к кнопке Войти, возвращает объект, имплементирующий интерфейс SelenideElement
    return element(ENTER_BUTTON); // Метод element получает доступ к кнопке Войти, которую передали в аргументе
  }
  public SelenideElement getValidator() {
    return element(POPUP_VALIDATOR);
  }
  public void checkingThePopupValidator(){
    $x(getValidator().getText()); //проверка существует ли данный элемент, если нет, выкидывается исключение
  }

  public SelenideElement getLinkRegister() { // Метод для получения  доступа к ссылке регистрации, возвращает объект, имплементирующий интерфейс SelenideElement
    return element(LINK_REGISTER);// Метод element получает доступ к ссылке регистрации, которую передали в аргументе
  }

  public SelenideElement getLinkForgotPassword() { // Метод для получения  доступа к ссылке восстановления пароля, возвращает объект, имплементирующий интерфейс SelenideElement
    return element(LINK_FORGOT_PASSWORD);// Метод element получает доступ к ссылке восстановления пароля, которую передали в аргументе
  }
}