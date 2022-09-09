package scenarios.ui;

import objects.users.DefaultUser;
import org.testng.annotations.BeforeMethod;
import steps.BaseSteps;
import steps.LoginSteps;

class LoggedInWithUserBaseTest extends BaseUiTest {
    @BeforeMethod
    public void beforeEach() {
        LoginSteps loginSteps = new LoginSteps();

        BaseSteps.navigate();
        loginSteps.loaded();
        loginSteps.login(new DefaultUser());
    }
}
