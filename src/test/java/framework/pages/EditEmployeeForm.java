package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditEmployeeForm extends EmployeeForm {
    private final By backButtonBy = By.xpath("//a[@class='subButton bBack']");

    public EditEmployeeForm(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return isElementPresent(backButtonBy) && isUrlCorrectForPage(this.getClass());
    }

    public void clickBackButton() {
        getDriver().findElement(backButtonBy).click();
    }
}
