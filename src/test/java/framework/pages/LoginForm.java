package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends AnyPage {

    @FindBy(xpath = "//input[@ng-model='user.name']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@ng-model='user.password']")
    private WebElement passwordInput;

    @FindBy(className = "error-message")
    private WebElement loginUnsuccessfullMessage;

    @FindBy(className = "error-message")
    private WebElement inputRequired;

    private By loginButtonBy = By.xpath("//button[@type='submit']");

    public LoginForm(WebDriver driver) { super(driver); }

    public boolean isOpened() {
        return isElementPresent(loginButtonBy) && isUrlCorrectForPage(this.getClass());
    }

    public void enterCredentials(final String login, final String password) {
        waitFor(loginInput);
        typeInto(loginInput, login);
        typeInto(passwordInput, password);
    }

    public void submitCredentials() {
        getLoginButton().click();
    }

    private WebElement getLoginButton () {
        return getDriver().findElement(loginButtonBy);
    }

    public String getLoginButtonText() {
        return getDriver().findElement(loginButtonBy).getText();
    }

    public boolean isInvalidCredentialsMessageDisplayed() {
        waitUntilVisible(loginUnsuccessfullMessage);
        return true;
    }

    public boolean isFieldMarkedRequired() {
        return inputRequired.isDisplayed();
    }
}
