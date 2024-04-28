package test.forgotPassword;

import org.testng.annotations.Test;
import pages.forgotPassword.ForgotPasswordPage;
import pages.resetPassword.ResetPasswordPage;
import services.forgotPassword.ForgotPasswordService;
import static com.codeborne.selenide.Condition.visible;

public class ForgotAndResetPassword {

    private final ForgotPasswordService forgotPasswordService = new ForgotPasswordService();
    private final ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    private final ResetPasswordPage resetPasswordPage = new ResetPasswordPage();

    @Test // Тест сброса и изменения пароля, требует доработки для прикручивания почты
    public void resetPassword() {
        String email = "sadart1998@mail.ru";
        String password = "1234qazswx";
        String token = "4bf653cf-8168-49d6-b608-da48edf9326d";

        forgotPasswordService.openForgotPasswordPage();
        forgotPasswordPage.setEmail(email);
        forgotPasswordPage.getRecoverButton().shouldBe(visible).click();
        resetPasswordPage.setPassword(password);
        resetPasswordPage.setCodeMessage(token);
        resetPasswordPage.getSaveButton().shouldBe(visible).click();
    }

    @Test //Тест перехода со страницы восстановления пароля на авторизацию
    public void switchingToAuthorizationFromForgotPassword() {
        forgotPasswordService.openForgotPasswordPage();
        forgotPasswordPage.getLinkAuthorization().shouldBe(visible).click();
    }

    @Test // Тест перехода со страницы сброса пароля на авторизацию
    public void switchingToAuthorizationFromResetPassword() {
        String email = "sadart1998@mail.ru";

        forgotPasswordService.openForgotPasswordPage();
        forgotPasswordPage.setEmail(email);
        forgotPasswordPage.getRecoverButton().shouldBe(visible).click();
        resetPasswordPage.getLinkAuthorization().shouldBe(visible).click();
    }
}
