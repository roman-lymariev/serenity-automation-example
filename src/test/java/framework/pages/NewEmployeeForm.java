package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewEmployeeForm extends EmployeeForm {
    private final By cancelButtonBy = By.xpath("//a[@class='subButton bCancel']");

    public NewEmployeeForm(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return isElementPresent(cancelButtonBy) && isUrlCorrectForPage(this.getClass());
    }

    public void clickCancelButton() {
        getDriver().findElement(cancelButtonBy).click();
    }
}
