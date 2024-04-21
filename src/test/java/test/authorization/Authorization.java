package test.authorization;

import org.testng.annotations.Test;
import pages.authorization.AuthorizationPage;
import services.authorization.AuthorizationService;


public class Authorization { // класс, в котором запускаем тест

  private final AuthorizationService authorizationService = new AuthorizationService(); // создаём объект класса AuthorizationService
  private final AuthorizationPage authorizationPage = new AuthorizationPage(); // создаём объект класса AuthorizationPage

  @Test // Определяем, что это тест
  public void checkAuthorization() { // Метод проверки авторизации, который ничего не возращает
    String email = "alex20-03sh@mail.ru"; // строка с email, которую мы будем передавать в метод setEmail для ввода её в поле
    String password = "022093Aa"; // строка с password, которую мы будем передавать в метод setPassword для ввода её в поле

    authorizationService.openAutorizationPage(); //вызываем метод объекта authorizationService для загрузки браузера со страницей
    authorizationPage.setEmail(email); //вызываем метод объекта authorizationPage для ввода email
    authorizationPage.setPassword(password);//вызываем метод объекта  authorizationPage для ввода password
    authorizationPage.getEnterButton().click(); // //вызываем метод объекта  authorizationPage для получения доступа к кнопке и симуляции клика на неё с помощью метода click
  }
}