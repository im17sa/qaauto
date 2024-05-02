package services.forgotPassword;

import base.BaseService;
import static com.codeborne.selenide.Selenide.open;

public class ForgotPasswordService extends BaseService {

    //Метод открывает браузер с определённой страницей
    public void openForgotPasswordPage() {
        open(baseUrl + "/forgot-password");
    }
}
