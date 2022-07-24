package web_driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

@Slf4j
class WebDriverFabric {
    private WebDriverFabric() {
    }

    protected static WebDriver createWebDriver(String name) {
        log.debug("Initializing a WebDriver by name {}...", name);

        if (null == name) {
            return createChromeDriver();
        } else if (name.matches(("[Cc]hrome"))) {
            return createChromeDriver();
        } else if (name.matches("[Ff]irefox")) {
            return createFirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unable to get the %s driver type".formatted(name));
        }
    }

    private static ChromeDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    }

    private static FirefoxDriver createFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(options);
    }
}
