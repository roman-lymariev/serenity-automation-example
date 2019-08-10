package framework.pages;

import framework.model.Employee;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class EmployeeForm extends Header {

    @FindBy(xpath = "//input[@ng-model='selectedEmployee.firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@ng-model='selectedEmployee.lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@ng-model='selectedEmployee.startDate']")
    private WebElement startDateInput;

    @FindBy(xpath = "//input[@ng-model='selectedEmployee.email']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@class='main-button']")
    private WebElement submitButton;

    public EmployeeForm(WebDriver driver) {
        super(driver);
    }


    public Employee getEmployeeDetails() {
        return new Employee(
                getEmployeeFirstName(),
                getEmployeeLastName(),
                getEmployeeStartDate(),
                getEmployeeEmail()
        );
    }

    public String getEmployeeFirstName() {
        return getAngularElementText(firstNameInput);
    }

    public String getEmployeeLastName() {
        return getAngularElementText(lastNameInput);
    }

    public String getEmployeeStartDate() {
        return getAngularElementText(startDateInput);
    }

    public String getEmployeeEmail() {
        return getAngularElementText(emailInput);
    }


    public void setEmployeeFirstName(final String value) {
        clearAndTypeInto(firstNameInput, value);
    }

    public void setEmployeeLastName(final String value) {
        clearAndTypeInto(lastNameInput, value);
    }

    public void setEmployeeStartDate(final String value) {
        clearAndTypeInto(startDateInput, value);
    }

    public void setEmployeeEmail(final String value) {
        clearAndTypeInto(emailInput, value);
    }


    public void submit() {
        submitButton.click();
    }

    public String getActiveSubmitButtonText() {
        return submitButton.getText();
    }

    public void enterEmployeeData(Employee employee) {
        setEmployeeFirstName(employee.getFirstName());
        setEmployeeLastName(employee.getLastName());
        setEmployeeStartDate(employee.getStartDate());
        setEmployeeEmail(employee.getEmail());
    }

    //reusable
    private void clearAndTypeInto(WebElement element, final String stringToType) {
        element.clear();
        typeInto(element, stringToType);
    }
}
