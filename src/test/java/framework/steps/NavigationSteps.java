package framework.steps;

import framework.pages.EditEmployeeForm;
import framework.pages.LoginForm;
import framework.pages.NewEmployeeForm;
import framework.pages.OverviewForm;
import org.hamcrest.MatcherAssert;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.core.IsEqual.equalTo;

public class NavigationSteps extends BrowserSteps {
    protected LoginForm loginForm;
    protected OverviewForm overviewForm;
    protected EditEmployeeForm editEmployeeForm;
    protected NewEmployeeForm newEmployeeForm;

    @Given("${Login|Overview|New Employee|Edit Employee} form {is|is still} opened")
    @Then("${Login|Overview|New Employee|Edit Employee} form {is|is still} opened")
    public void isMainFormOpened(final String formName) {
        MatcherAssert.assertThat(
                String.format("%s form opened condition failed", formName),
                isFormOpened(formName),
                equalTo(true));
    }

    @Given("user clicks ${Create|Delete|Edit|Logout|Add|Update|Cancel|Back} button")
    @When("user clicks ${Create|Delete|Edit|Logout|Add|Update|Cancel|Back} button")
    public void clickCreateButton(final String button) {
        switch (button.toLowerCase().replace("$", "")) {
            case "create":
                overviewForm.clickCreate();
                break;
            case "delete":
                overviewForm.clickDelete();
                break;
            case "edit":
                overviewForm.clickEdit();
                break;
            case "logout":
                overviewForm.clickLogout();
                break;
            case "add":
                newEmployeeForm.submit();
                break;
            case "update":
                editEmployeeForm.submit();
                break;
            case "cancel":
                newEmployeeForm.clickCancelButton();
                break;
            case "back":
                editEmployeeForm.clickBackButton();
                break;
            default:
                throw new RuntimeException("Button is not recognized: ".concat(button));
        }
        anyPage.pauseFor(1000);
    }

    private boolean isFormOpened(final String formName) {
        switch (formName) {
            case "Login":
                return loginForm.isOpened();
            case "Overview":
                return overviewForm.isOpened();
            case "Edit Employee":
            case "Edit":
                return editEmployeeForm.isOpened();
            case "New Employee":
            case "New":
                return newEmployeeForm.isOpened();
            default:
                throw new RuntimeException("Specified form name is not recognized: ".concat(formName));
        }
    }
}
