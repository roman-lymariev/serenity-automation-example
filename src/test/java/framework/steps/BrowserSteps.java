package framework.steps;

import framework.pages.*;

import framework.utils.TestData;
import net.serenitybdd.core.Serenity;
import org.hamcrest.MatcherAssert;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;


import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.isEmptyString;

public class BrowserSteps {
    protected AnyPage anyPage;

    @Given("application URL is opened in browser")
    @When("application URL is opened in browser")
    public void openApplicationUrlInBrowser() {
        anyPage.goToUrl(TestData.getAppUrl());
    }

    @Given("user accepts alert")
    @When("user accepts alert")
    public void acceptAlert() {
        anyPage.getAlert().accept();
        anyPage.pauseFor(500);
    }

    @Given("user dismisses alert")
    @When("user dismisses alert")
    public void dismissAlert() {
        anyPage.getAlert().dismiss();
        anyPage.pauseFor(500);
    }

    @Then("alert is diplayed")
    public void alertIsdisplayed() {
        MatcherAssert.assertThat("Alert is not displayed",
                anyPage.getAlert().getText(),
                not(isEmptyString()));
    }


    //useful generic steps

    @Given("URL is opened: $url")
    @When("user opens URL: $url")
    public void openUrl(final String url) {
        anyPage.goToUrl(url);
    }

    @Given("browser page is refreshed")
    @When("user refreshes browser page")
    public void refresh() {
        anyPage.getDriver().navigate().refresh();
    }

    @Given("user navigates back")
    @When("user navigates back")
    public void goBack() {
        anyPage.getDriver().navigate().back();
    }

    @Given("cookie $cookie with value $value is added")
    public void addCookie(final String cookie, final String value) {
        anyPage.getDriver().manage().addCookie(new Cookie(cookie, value));
    }

    @Given("cookies are deleted")
    public void deleteAllookies() {
        anyPage.getDriver().manage().deleteAllCookies();
    }

    @Given("user switches to tab $number")
    public void changeTab(int number) {
        ArrayList<String> handles = new ArrayList<String>(anyPage.getDriver().getWindowHandles());
        anyPage.getDriver().switchTo().window(handles.get(number - 1));
    }

    @When("browser window is resized to $resolution")
    public void resizeBrowserWindow(final String resolutionAsString) {
        anyPage.getDriver().manage().window().setSize(getDimensionFromString(resolutionAsString));
    }

    @Then("screenshot is taken")
    public void takeScreenshot() {
        Serenity.takeScreenshot();
    }


    private Dimension getDimensionFromString(final String resolutionAsString) {
        String[] resolutions = resolutionAsString.split("x");
        return new Dimension(
                Integer.parseInt(resolutions[0]),
                Integer.parseInt(resolutions[1])
        );
    }
}
