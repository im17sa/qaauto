package services.resetPassword;

import base.BaseService;
import static com.codeborne.selenide.Selenide.open;

public class ResetPasswordService extends BaseService {

    //Метод открывает браузер с определённой страницей
    public void openResetPasswordPage() {
        open(baseUrl + "/reset-password");
    }
}
