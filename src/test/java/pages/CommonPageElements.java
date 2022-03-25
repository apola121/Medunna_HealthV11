package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CommonPageElements {

    public CommonPageElements(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Administration']")
    public WebElement Administration;

    @FindBy(className = "dropdown-item")
    public WebElement logout;

//    @FindBy(xpath = "//*[text()='Sign out']")
//    public WebElement Logout;

}
