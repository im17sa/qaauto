package services.profile;

import base.BaseService;
import static com.codeborne.selenide.Selenide.open;

public class ProfileService extends BaseService {

    //Метод открывает браузер с определённой страницей
    public void openProfilePage() {
        open(baseUrl + "/profile");
    }
}
