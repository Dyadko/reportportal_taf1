package elements.pages;

import elements.WaitFor;
import elements.components.launches.SuiteItem;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LaunchesPage extends Page {
    @FindBy(xpath = "//*[.='All launches']")
    private WebElement allLaunchesBtn;

    @FindBy(css = "[class*=gridHeader__grid-header]")
    private WebElement gridHeader;

    @FindBy(css = "[class*=gridRow__grid-row--]:nth-of-type(2)")
    List<WebElement> suites;

    @WaitFor
    @FindBy(xpath = "(//div[contains(@class, 'itemInfo__main-info--')])[1]")
    WebElement firstSuiteTitle;

    public List<SuiteItem> getSuites() {
        return suites.stream()
                .map(SuiteItem::new)
                .toList();
    }
}
