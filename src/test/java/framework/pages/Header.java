package framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class Header extends AnyPage {
    @FindBy(xpath = "//p[@ng-click='logout()']")
    private WebElement logoutButton;

    public Header(WebDriver driver) {
        super(driver);
    }

    public void clickLogout() {
        clickWithAction(logoutButton);
    }
}
