package services.authorization;

import base.BaseService;

import static com.codeborne.selenide.Selenide.*;

public class AuthorizationService extends BaseService { /* Публичный класс  AuthorizationService, который наследуется
 от BaseService, включая поле baseUrl */

  public void openAutorizationPage() { // Метод открывающий страницу авторизации
    open(baseUrl + "/login"); /* Метод open загружает страницу в браузере, в качестве
     аргумента мы даём унаследованное поле baseUrl  и конкатенацией добавляем к домену путь login*/
  }
}