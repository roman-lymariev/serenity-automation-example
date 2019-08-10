package framework.pages;

import framework.utils.TestData;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class AnyPage extends PageObject {

    @Managed
    private WebDriver driver;

    public AnyPage(final WebDriver driver) {
        super(driver);

        if (driver == null) {
            throw new NullPointerException("WebDriver is null.");
        }
    }

    protected boolean isUrlCorrectForPage(Class callingClass) {
        return currentUrlEndsWith(
                TestData.getExpectedUriExtension(callingClass)
        );
    }

    public void goToUrl(final String url) {
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("path is null or empty.");
        }

        getDriver().get(url);
        final String currentUrl = getDriver().getCurrentUrl();

        if (currentUrl == null || currentUrl.isEmpty()) {
            throw new IllegalStateException("The current url is null or empty.");
        }
    }

    protected void waitUntilClickable(final WebElement element, final int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitUntilClickable(final WebElement element) {
        waitUntilClickable(element, getCustomTimeoutMsec());
    }

    protected void clickWithAction(final WebElement element) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).click().perform();
    }

    protected void doubleClick(final WebElement element) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).doubleClick().perform();
    }

    protected void clickWithJS(final WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }


    protected void waitUntilVisible(final WebElement element, int timeoutInSeconds) {
        new WebDriverWait(getDriver(), timeoutInSeconds).until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitUntilVisible(WebElement element) {
        waitUntilVisible(element, getCustomTimeoutMsec());
    }

    protected void waitUntilNotVisible(By by) {
        new WebDriverWait(getDriver(), getCustomTimeoutMsec())
                .until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    protected void waitUntilNotVisible(WebElement element) {
        new WebDriverWait(getDriver(), getCustomTimeoutMsec())
                .until(ExpectedConditions.invisibilityOf(element));
    }

    protected void sendEnterToElement(WebElement element) {
        element.sendKeys(Keys.ENTER);
    }

    protected void sendSpaceToElement(WebElement element) {
        element.sendKeys(Keys.SPACE);
    }

    protected void implicitlyWait(int milliseconds) {
        getDriver().manage().timeouts().implicitlyWait(milliseconds, TimeUnit.MILLISECONDS);
    }

    protected void scrollToElementAndClick(WebElement element) {
        scrollElementIntoMiddleByJS(element);
        element.click();
    }

    public void pageDown() {
        getDriver().findElement(By.xpath("/*")).sendKeys(Keys.PAGE_DOWN);
    }

    protected void scrollTo(WebElement element) {
        scrollElementIntoMiddleByJS(element);
    }

    private void scrollElementIntoMiddleByJS(WebElement element) {
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

        ((JavascriptExecutor) getDriver()).executeScript(scrollElementIntoMiddle, element);
    }

    public void waitForPageToLoad() {
        new WebDriverWait(getDriver(), getCustomTimeoutMsec()).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitForPage(final String uriFraction) {
        waitForPage(uriFraction, getCustomTimeoutMsec());
    }

    public void waitForPage(final String uriFraction, int seconds) {
        waitForCondition()
                .withTimeout(seconds, TimeUnit.MILLISECONDS)
                .until(ExpectedConditions.urlContains(uriFraction));
    }

    public boolean currentUrlEndsWith(final String uriFraction) {
        return getDriver().getCurrentUrl().endsWith(uriFraction);
    }

    public boolean currentUrlContains(final String uriFraction) {
        return getDriver().getCurrentUrl().contains(uriFraction);
    }

    public void pauseFor (int milliseconds) {
        getClock().pauseFor(milliseconds);
    }

    protected Select getSelectBy(By by) {
        return new Select(getDriver().findElement(by));
    }

    protected boolean isCheckboxSet (WebElement checkbox) {
        return checkbox.isSelected();
    }

    protected boolean isElementPresent(By by) {
        return !getDriver().findElements(by).isEmpty();
    }

    protected String getAngularElementText(WebElement element) {
        return element.getAttribute("value");
    }

    private static int getCustomTimeoutMsec() {
        return TestData.getCustomTimeout();
    }
}
