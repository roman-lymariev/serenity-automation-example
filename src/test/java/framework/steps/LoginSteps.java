package framework.steps;

import framework.utils.TestData;
import org.hamcrest.MatcherAssert;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.core.IsEqual.equalTo;

public class LoginSteps extends NavigationSteps {
    @Given("credentials are entered: $username $password")
    public void enterCredentials(final String login, final String password) {
        loginForm.enterCredentials(login, password);
    }

    @Given("$userKey logs in to application")
    @When("$userKey logs in to application")
    public void logInToApp(final String userKey) {
        anyPage.goToUrl(TestData.getAppUrl());
        enterCredentials(
                TestData.getUserLogin(userKey),
                TestData.getUserPassword(userKey)
        );
        submitCredentials();
    }

    @When("user submits credentials")
    public void submitCredentials() {
        loginForm.submitCredentials();
    }

    @Then("user is notified about invalid credentials")
    public void invalidCredentialsNotification() {
        MatcherAssert.assertThat(loginForm.isInvalidCredentialsMessageDisplayed(), equalTo(true));
    }
}
