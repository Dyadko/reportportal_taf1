package scenarios.ui;

import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.extern.slf4j.Slf4j;
import objects.users.DefaultSuperAdmin;
import objects.users.DefaultUser;
import objects.users.User;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.BaseSteps;
import steps.LeftBarSteps;
import steps.LoginSteps;

@Slf4j
class LoginTest extends BaseUiTest {

    @DataProvider(name = "users", parallel = true)
    public Object[][] testData() {
        return new Object[][]{
                new Object[]{new DefaultUser()},
                new Object[]{new DefaultSuperAdmin()},
        };
    }

    @Test(description = "Logs in with different users", dataProvider = "users")
    @Issue("Test-2")
    @Severity(SeverityLevel.CRITICAL)
    void loginWithUserValidCredentials(User user) {
        LoginSteps loginSteps = new LoginSteps();
        LeftBarSteps leftBarSteps = new LeftBarSteps();

        BaseSteps.navigate();
        loginSteps.loaded();
        loginSteps.login(user);

        Assert.assertTrue(leftBarSteps.loaded());
    }
}
