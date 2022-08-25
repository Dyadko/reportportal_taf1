package scenarios.ui;

import com.google.inject.Inject;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;
import steps.BaseSteps;
import steps.LoginSteps;
import steps.StepsModule;

@Guice(modules = StepsModule.class)
class DefaultLoadingTest extends BaseUi {
    @Inject
    LoginSteps loginSteps;

    @Test
    @Issue("Test-1")
    @Severity(SeverityLevel.CRITICAL)
    void rpLoadsWithLoginPageByDefaultTest() {
        BaseSteps.navigate();
        Assert.assertTrue(loginSteps.loaded());
    }
}
