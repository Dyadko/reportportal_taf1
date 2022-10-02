package elements.components.launches;

import elements.components.Component;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Stream;

public class Header extends Component {
    @FindBy(xpath = "//span[contains(@class, 'headerCell__title-short')][.='name']")
    public WebElement name;

    @FindBy(xpath = "//span[contains(@class, 'headerCell__title-short')][.='start']")
    public WebElement startTime;

    @FindBy(xpath = "//span[contains(@class, 'headerCell__title-short')][.='ttl']")
    public WebElement total;

    @FindBy(xpath = "//span[contains(@class, 'headerCell__title-short')][.='ps']")
    public WebElement passed;

    @FindBy(xpath = "//span[contains(@class, 'headerCell__title-short')][.='fl']")
    public WebElement failed;

    @FindBy(xpath = "//span[contains(@class, 'headerCell__title-short')][.='skp']")
    public WebElement skipped;

    @FindBy(xpath = "//span[contains(@class, 'headerCell__title-short')][.='product bug']")
    public WebElement productBug;

    @FindBy(xpath = "//span[contains(@class, 'headerCell__title-short')][.='auto bug']")
    public WebElement autoBug;

    @FindBy(xpath = "//span[contains(@class, 'headerCell__title-short')][.='system issue']")
    public WebElement systemIssue;

    @FindBy(xpath = "//span[contains(@class, 'headerCell__title-short')][.='to invest']")
    public WebElement toInvestigate;

    /**
     * Returns a list of header elements.
     * Actually it is a list of all the class fields.
     *
     * @return Can return empty list.
     */
    public List<WebElement> getHeaderList() {
        return Stream.of(this.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(FindBy.class))
                .map(field -> {
                    try {
                        return (WebElement) field.get(this);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();
    }
}
