package scenarios.ui;

import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.BaseSteps;
import steps.LoginSteps;

@Test
public class DefaultLoadingTest extends BaseUiTest {

    @Test()
    @Issue("Test-1")
    @Severity(SeverityLevel.CRITICAL)
    void rpLoadsWithLoginPageByDefaultTest() {
        LoginSteps loginSteps = new LoginSteps();

        BaseSteps.navigate();
        Assert.assertTrue(loginSteps.waitUntilLoaded());
    }
}

