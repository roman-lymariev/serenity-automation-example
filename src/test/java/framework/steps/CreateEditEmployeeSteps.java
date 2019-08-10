package framework.steps;

import framework.utils.TestData;
import org.hamcrest.MatcherAssert;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

import static org.hamcrest.CoreMatchers.equalTo;

public class CreateEditEmployeeSteps extends NavigationSteps {

    @Given("user fills in details for $employeeKey")
    public void fillInEmployeeDetails(String employeeKey) {
        newEmployeeForm.enterEmployeeData(TestData.getEmployeeByKey(employeeKey));
    }

    @Given("user fills in Employee details as follow: $firstName $lastName $startDate $email")
    public void fillInEmployeeDetails(final String firstName, final String lastName, final String startDate, final String email) {
        newEmployeeForm.setEmployeeFirstName(firstName);
        newEmployeeForm.setEmployeeLastName(lastName);
        newEmployeeForm.setEmployeeStartDate(startDate);
        newEmployeeForm.setEmployeeEmail(email);
    }

    @Given("user sets Employee email to $value")
    public void setEmployeeEmail(final String value) {
        newEmployeeForm.setEmployeeEmail(value);
    }

    @Given("user sets Employee start date to $value")
    public void setEmployeeStartDate(final String value) {
        newEmployeeForm.setEmployeeStartDate(value);
    }

    @Then("details for $employeeKey are displayed")
    public void compareEmployeeDetails(final String employeeKey) {
        MatcherAssert.assertThat("Employee details are different",
                editEmployeeForm.getEmployeeDetails(),
                equalTo(TestData.getEmployeeByKey(employeeKey)));
    }
}
