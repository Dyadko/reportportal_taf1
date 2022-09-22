package elements.components;

import lombok.Getter;
import lombok.ToString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Getter
@ToString(onlyExplicitlyIncluded = true)
public class RelativeWebElement {
    WebElement parent;
    By by;
    WebElement webElement;
    @ToString.Include
    String text;

    /**
     * A sub-object of a WebElement. Its selector describes location relatively to its
     * parent node rather than absolute selector.
     *
     * @param parent parent element.
     * @param by     relative selector.
     */
    public RelativeWebElement(WebElement parent, By by) {
        this.parent = parent;
        this.by = by;
        this.webElement = this.parent.findElements(this.by).stream()
                .findFirst()
                .orElse(null);
        this.text = defineText();
    }

    /**
     * Defines text value of a node.
     * <p>
     * As node can be nonexistent or can be just without text,
     * these cases should be handled.
     *
     * @return text in String representation.
     */
    private String defineText() {
        if (null != webElement) {
            if (null != webElement.getText() && !webElement.getText().isEmpty()) {
                return webElement.getText();
            }
        }
        return null;
    }
}
