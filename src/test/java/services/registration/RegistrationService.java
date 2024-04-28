package services.registration;

import base.BaseService;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationService extends BaseService {

    //Метод открывает браузер с определённой страницей
    public void openRegistrationPage() {
        open(baseUrl + "/register");
    }
}
