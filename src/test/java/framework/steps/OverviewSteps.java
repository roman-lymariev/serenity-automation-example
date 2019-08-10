package framework.steps;

import framework.utils.TestData;
import org.hamcrest.MatcherAssert;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;

public class OverviewSteps extends NavigationSteps {
    private int usersCount = 0;

    @Then("Employee List is alphabeticaly sorted")
    public void checkEmployeeListSorting() {
        List<String> actualList = overviewForm.getEmployeesFullNames();

        List<String> expectedList = new ArrayList(actualList);
        expectedList.sort(Comparator.naturalOrder());

        MatcherAssert.assertThat("Employee list is not sorted as expected",
                actualList,
                equalTo(expectedList));
    }

    //select employee
    @Given("user selects an employee in Employee list")
    @When("user selects an employee in Employee list")
    public void selectFirstEmployeeWithClick() {
        overviewForm.clickEmployee(1);
    }

    @Given("user opens an employee in Employee list")
    @When("user opens an employee in Employee list")
    public void selectFirstEmployeeWithDoubleClick() {
        overviewForm.doubleClickEmployee(1);
    }

    @Given("user selects $employeeKey in list")
    public void selectEmployee(String employeeKey) {
        overviewForm.clickEmployee(TestData.getEmployeeByKey(employeeKey));
    }

    @Given("user double-clicks $employeeKey in list")
    @When("user double-clicks $employeeKey in list")
    public void doubleClickEmployee(String employeeKey) {
        overviewForm.doubleClickEmployee(TestData.getEmployeeByKey(employeeKey));
    }

    //employees count
    @Given("user gets total Employee count")
    public void getTotalEmployeesCount() {
        usersCount = overviewForm.getEmployeesCount();
    }

    @Then("employee count has incremented")
    public void employeeCountIncremented() {
        assertEmployeeCount(++usersCount);
    }

    @Then("employee count has decremented")
    public void employeeCountDecremented() {
        assertEmployeeCount(--usersCount);
    }

    @Then("employee count has not changed")
    public void employeeCountIsTheSame() {
        assertEmployeeCount(usersCount);
    }

    //reusable
    private void assertEmployeeCount(int expectedCount) {
        MatcherAssert.assertThat("Employee count is different from expected",
                overviewForm.getEmployeesCount(),
                equalTo(expectedCount));
    }
}
