package steps;

import configuration.Config;
import io.qameta.allure.Step;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web_driver.Driver;

@Slf4j
@NoArgsConstructor
public class BaseSteps {

    @Step("Navigate to Report Portal")
    public static void navigate() {
        log.info("Navigating to {}...", Config.BASE_URL);
        Driver.get().navigate().to(Config.BASE_URL);
    }
}
