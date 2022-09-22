package steps;

import elements.components.launches.Header;
import elements.components.launches.SuiteItem;
import elements.pages.LaunchesPage;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LaunchSteps {
    private final Header header;
    private final LaunchesPage launchesPage;

    public LaunchSteps() {
        this.header = new Header();
        this.launchesPage = new LaunchesPage();
    }

    @Step(value = "Assert header is present")
    public void assertHeaderPresent() {
        Assertions.assertThat(header.getHeaderList())
                .as("Launches header elements list")
                .allSatisfy(WebElement::isDisplayed);
    }

    @Step(value = "Get suites")
    public List<SuiteItem> getSuites() {
        return launchesPage.getSuites();
    }

    @Step(value = "Waiting for Launch page to load...")
    public boolean loaded() {
        return launchesPage.loaded();
    }
}
