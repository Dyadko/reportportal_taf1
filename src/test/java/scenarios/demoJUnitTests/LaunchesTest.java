package scenarios.demoJUnitTests;

import elements.components.launches.SuiteItem;
import junit.framework.AssertionFailedError;
import objects.users.DefaultUser;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import steps.BaseSteps;
import steps.LaunchSteps;
import steps.LeftBarSteps;
import steps.LoginSteps;
import web_driver.Driver;

import java.util.List;
import java.util.stream.Stream;

@Execution(ExecutionMode.CONCURRENT)
class LaunchesTest {
    LoginSteps loginSteps;
    LeftBarSteps leftBarSteps;
    LaunchSteps launchSteps;

    private static Stream<Arguments> launchesParamStream() {
        return Stream.of(
                Arguments.of("Demo Api Tests#10", "30", "30", null, null, null, null, null, null),
                Arguments.of("Demo Api Tests#5", "30", "30", null, null, null, null, null, null),
                Arguments.of("Demo Api Tests#9", "25", "20", "5", null, "4", "1", null, "2"),
                Arguments.of("Demo Api Tests#8", "20", "10", "8", "2", "4", "4", null, "10"),
                Arguments.of("Demo Api Tests#7", "15", "5", "9", "1", "1", "5", "4", "8"),
                Arguments.of("Demo Api Tests#6", "10", "1", "9", null, null, "1", "8", "5"),
                Arguments.of("Demo Api Tests#4", "25", "20", "5", null, "4", "1", null, "2"),
                Arguments.of("Demo Api Tests#3", "20", "10", "8", "2", "4", "4", null, "10"),
                Arguments.of("Demo Api Tests#2", "15", "5", "9", "1", "1", "5", "4", "8"),
                Arguments.of("Demo Api Tests#1", "10", "1", "9", null, null, "1", "8", "5")
        );
    }

    @BeforeEach
    public void navigateToLaunches() {
        Driver.createWebDriver();
        BaseSteps.navigate();

        loginSteps = new LoginSteps();
        leftBarSteps = new LeftBarSteps();
        launchSteps = new LaunchSteps();

        loginSteps.loaded();
        loginSteps.login(new DefaultUser());
        leftBarSteps.openLaunches();
        launchSteps.loaded();
    }

    @Test
    public void launchesHeaderTest() {
        launchSteps.assertHeaderPresent();
    }

    @ParameterizedTest
    @MethodSource("launchesParamStream")
    void demoLaunchesTest(
            String name,
            String total,
            String passed,
            String failed,
            String skipped,
            String productBug,
            String autoBug,
            String systemIssue,
            String toInvest) {

        List<SuiteItem> suites = launchSteps.getSuites();
        Assertions.assertThat(suites).hasSizeGreaterThan(0);

        SuiteItem suite = suites.stream()
                .filter(it -> it.getName().getText().equals(name))
                .findFirst()
                .orElseThrow(() -> new AssertionFailedError("Unable to find %s test suite".formatted(name)));

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(suite.getName().getText()).as("name").isEqualTo(name);
            softly.assertThat(suite.getTotal().getText()).as("total").isEqualTo(total);
            softly.assertThat(suite.getPassed().getText()).as("passed").isEqualTo(passed);
            softly.assertThat(suite.getFailed().getText()).as("failed").isEqualTo(failed);
            softly.assertThat(suite.getSkipped().getText()).as("skipped").isEqualTo(skipped);
            softly.assertThat(suite.getProductBug().getText()).as("productBug").isEqualTo(productBug);
            softly.assertThat(suite.getAutoBug().getText()).as("autoBug").isEqualTo(autoBug);
            softly.assertThat(suite.getSystemIssue().getText()).as("systemIssue").isEqualTo(systemIssue);
            softly.assertThat(suite.getToInvest().getText()).as("toInvest").isEqualTo(toInvest);
        });
    }
}
