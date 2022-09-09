package scenarios.ui;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import scenarios.BaseTest;
import web_driver.Driver;

@Slf4j
public class BaseUiTest extends BaseTest {
    @BeforeMethod()
    public void setUpDriver() {
        Driver.createWebDriver();
    }

    @AfterMethod
    public void shutDownDriver() {
        Driver.shutDownDriver();
    }
}
