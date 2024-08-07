package pages.authorization;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.element;

public class AuthorizationPage { // Класс для поиска элементов на странице и создания методов для подстановки данных для ввода

  private final By EMAIL = By.xpath("//input[@name='email']"); //Находит поле для ввода email по XPath выражению
  private final By PASSWORD = By.xpath("//input[@name='password']"); //Находит поле для ввода password по XPath выражению
  private final By ENTER_BUTTON = By.xpath("//button[contains(text(), 'Войти')]"); //Находит кнопку войти по XPath выражению
  private final By LINK_REGISTER = By.xpath("//a[contains(text(), 'Зарегистрироваться')]"); //Находит ссылку зарегистрироваться по XPath выражению
  private final By LINK_FORGOT_PASSWORD = By.xpath("//a[contains(text(), 'Восстановить пароль')]");//Находит ссылку восстановить пароль по XPath выражению
  private final By VALIDATOR = By.xpath("//*[text()='email or password are incorrect']"); //Находит валидатор по XPath выражению

  public SelenideElement getEmail() { // Метод для получения доступа к полю ввода email, возвращает объект, имплементирующий интерфейс SelenideElement
    return element(EMAIL); // Метод element получает доступ к полю ввода EMAIL, который передали в аргументе
  }
  //wdwd
  //hjqgjh
  //hjh
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

  public SelenideElement getValidator() { //Метод для получения доступа к валидатору, возвращает объект, имплементирующий интерфейс SelenideElement
    return element(VALIDATOR); // Для получения доступа к элементу, который передали в аргументе
  }

  public SelenideElement getLinkRegister() { // Метод для получения  доступа к ссылке регистрации, возвращает объект, имплементирующий интерфейс SelenideElement
    return element(LINK_REGISTER);// Метод element получает доступ к ссылке регистрации, которую передали в аргументе
  }

  public SelenideElement getLinkForgotPassword() { // Метод для получения  доступа к ссылке восстановления пароля, возвращает объект, имплементирующий интерфейс SelenideElement
    return element(LINK_FORGOT_PASSWORD);// Метод element получает доступ к ссылке восстановления пароля, которую передали в аргументе
  }
}