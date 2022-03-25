package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserManagementPage {

    public UserManagementPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[contains(text(),'Administration')]")
    public WebElement Administration;

    @FindBy(xpath = "//*[text()='User management']")
    public WebElement userManagement;

    @FindBy(xpath = "//*[@id=\"user-management-page-heading\"]/a/span")
    public WebElement createNewUser;

    @FindBy(id = "login")
    public WebElement loginInput;

    @FindBy(id="firstName")
    public WebElement firstName;

    @FindBy(id="lastName")
    public WebElement lastName;

    @FindBy(id="email")
    public WebElement email;

    @FindBy(id="ssn")
    public WebElement ssn;

    @FindBy (xpath = "//*[@id=\"authorities\"]/option[5]")
    public WebElement rolePhysician;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div[2]/div/form/button/span")
    public WebElement saveButton;

    @FindBy (xpath = "//*[@id=\"entity-menu\"]/a/span")
    public WebElement itemsTitlesDD;

    @FindBy(xpath = "//*[@id=\"entity-menu\"]/div/a[3]/span")
    public WebElement physicianDD;

    @FindBy(xpath = "//*[@id=\"jh-create-entity\"]/span")
    public WebElement createPhysicianButton;

    @FindBy(id="useSSNSearch")
    public WebElement ssnSearchCheck;

    @FindBy(id="searchSSN")
    public WebElement ssnSearchTextBox;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div[2]/div/form/div[1]/div[2]/div/button")
    public WebElement searchUserButton;

    @FindBy(id="physician-phone")
    public WebElement physicianPhone;

    @FindBy(id="physician-examFee")
    public WebElement physicianExamFee;

    @FindBy(xpath = "//*[@id=\"save-entity\"]/span")
    public WebElement physicianSaveButton;





}
