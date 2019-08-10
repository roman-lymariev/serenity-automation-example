package framework.pages;

import framework.model.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class OverviewForm extends Header {

    @FindBy(id = "greetings")
    private WebElement greetings;

    @FindBy(id = "bAdd")
    private WebElement addButton;

    @FindBy(id = "bEdit")
    private WebElement editButton;

    @FindBy(id = "bDelete")
    private WebElement deleteButton;

    private By employeeListRootBy = By.id("employee-list-container");
    private By employeeBy = By.xpath("//li[@ng-dblclick='editEmployee()']");


    public OverviewForm(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return isElementPresent(employeeListRootBy) && isUrlCorrectForPage(this.getClass());
    }

    public int getEmployeesCount() {
        return getEmployeesList().size();
    }

    public void clickEmployee(int x) {
        getEmployeesList().get(x).click();
    }

    public void clickEmployee(Employee employee) {
        getEmployeeElement(employee).click();
    }

    public void doubleClickEmployee(int x) {
        doubleClick(getEmployeesList().get(x));
    }

    public void doubleClickEmployee(Employee employee) {
        doubleClick(getEmployeeElement(employee));
    }

    public boolean isEmployeePresentInList(Employee employee) {
        return (getEmployeesList()
                .stream()
                .filter(element -> element.getText().equals(employee.getExpectedFullName()))
                .count() > 0);
    }

    public void clickCreate() {
        addButton.click();
    }

    public void clickEdit() {
        editButton.click();
    }

    public void clickDelete() {
        deleteButton.click();
    }

    public String getGreetingsText() {
        return greetings.getText();
    }

    public List<String> getEmployeesFullNames() {
        return getEmployeesList().stream().map(element -> element.getText()).collect(Collectors.toList());
    }

    //reusable
    private List<WebElement> getEmployeesList() {
        return getDriver().findElements(employeeBy);
    }

    private WebElement getEmployeeElement(Employee employee) {
        return getEmployeesList()
                .stream()
                .filter(element -> element.getText().equals(employee.getExpectedFullName()))
                .findFirst()
                .get();
    }
}
