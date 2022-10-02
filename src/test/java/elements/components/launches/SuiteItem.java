package elements.components.launches;

import elements.components.RelativeWebElement;
import elements.components.GridObjectItem;
import lombok.Getter;
import lombok.ToString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Getter
@ToString
public class SuiteItem extends GridObjectItem {

    private static final By NAME_BY = By.cssSelector("[class*=itemInfo__main-info--]");
    private static final By START_TIME_BY = By.cssSelector("[class *= absRelTime__relative-time--]");
    private static final By TOTAL_BY = By.cssSelector("[class *= executionStatistics__bold--]");
    private static final By PASSED_BY = By.cssSelector("[class *= 'launchSuiteGrid__passed-col--']");
    private static final By FAILED_BY = By.cssSelector("[class *= launchSuiteGrid__failed-col--]");
    private static final By SKIPPED_BY = By.cssSelector("[class *= launchSuiteGrid__skipped-col--]");
    private static final By PRODUCT_BUG_BY = By.cssSelector("[class*=launchSuiteGrid__pb-col--] [class*=donutChart__total]");
    private static final By AUTO_BUG_BY = By.cssSelector("[class*=launchSuiteGrid__ab-col--] [class*=donutChart__total]");
    private static final By SYSTEM_ISSUE_BY = By.cssSelector("[class*=launchSuiteGrid__si-col--] [class*=donutChart__total]");
    private static final By TO_INVEST_BY = By.cssSelector("[class*=launchSuiteGrid__ti-col--] [class*=donutChart__total]");

    private final RelativeWebElement name = new RelativeWebElement(gridObjectBody, NAME_BY);
    private final RelativeWebElement startTime = new RelativeWebElement(gridObjectBody, START_TIME_BY);
    private final RelativeWebElement total = new RelativeWebElement(gridObjectBody, TOTAL_BY);
    private final RelativeWebElement passed = new RelativeWebElement(gridObjectBody, PASSED_BY);
    private final RelativeWebElement failed = new RelativeWebElement(gridObjectBody, FAILED_BY);
    private final RelativeWebElement skipped = new RelativeWebElement(gridObjectBody, SKIPPED_BY);
    private final RelativeWebElement productBug = new RelativeWebElement(gridObjectBody, PRODUCT_BUG_BY);
    private final RelativeWebElement autoBug = new RelativeWebElement(gridObjectBody, AUTO_BUG_BY);
    private final RelativeWebElement systemIssue = new RelativeWebElement(gridObjectBody, SYSTEM_ISSUE_BY);
    private final RelativeWebElement toInvest = new RelativeWebElement(gridObjectBody, TO_INVEST_BY);

    public SuiteItem(WebElement gridObjectBody) {
        super(gridObjectBody);
    }
}
