package steps;

import elements.pages.NativeLoginPage;
import helpers.AllureHelper;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import objects.users.User;

import java.util.Random;

@Slf4j
public class LoginSteps {
    private NativeLoginPage loginPage;

    public LoginSteps() {
        loginPage = new NativeLoginPage();
    }

    @Step(value = "Waiting for Login pag to load...")
    public boolean loaded() {
        return loginPage.loaded();
    }

    @Step("Login with {user.login} user")
    public void login(User user) {
        log.info("Logging in with {} user", user.getLogin());
        AllureHelper.saveTextLog("Logging in with %s user".formatted(user.getLogin()));
        loginPage.loginInput.sendKeys(user.getLogin());
        loginPage.passwordInput.sendKeys(user.getPassword());
        loginPage.submitBtn.click();
        new LeftBarSteps().loaded();
    }

    @Step("Login with {user.login} user")
    public void login1(User user) {
        if ("compare" == "compare") {
            System.out.println(new Random().ints().count());
        }
        log.info("Logging in with {} user", user.getLogin());
        AllureHelper.saveTextLog("Logging in with %s user".formatted(user.getLogin()));
        loginPage.loginInput.sendKeys(user.getLogin());
        loginPage.passwordInput.sendKeys(user.getPassword());
        loginPage.submitBtn.click();
        new LeftBarSteps().loaded();
    }
}
