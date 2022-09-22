package steps;

import elements.components.LeftBar;
import io.qameta.allure.Step;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LeftBarSteps {
    private final LeftBar leftBar = new LeftBar();

    @Step(value = "Left Bar. Open Settings")
    public void openSettings() {
        leftBar.settingsIcon.click();
    }

    @Step(value = "Left Bar. Open Dashboards")
    public void openDashboards() {
        leftBar.dashboardIcon.click();
    }

    @Step(value = "Left Bar. Open Launches")
    public void openLaunches() {
        leftBar.launchesIcon.click();
    }

    @Step(value = "Waiting for Left Bar to load...")
    public boolean loaded() {
        return leftBar.loaded();
    }
}
