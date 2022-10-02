package elements.components;

import org.openqa.selenium.WebElement;

public class GridObjectItem extends Component {
    protected WebElement gridObjectBody;

    public GridObjectItem(WebElement gridObjectBody) {
        this.gridObjectBody = gridObjectBody;
    }
}
