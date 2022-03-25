package stepdefinitions.ui_steps_defs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.LoginPage;
import pages.PhysicianPage;
import pages.UserManagementPage;
import pojos.PhysicianPojo;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import static utilities.DateUtils.getDate;
import static utilities.Driver.getDriver;
import static utilities.Driver.jsClick;
import static utilities.ReusableMethods.waitForVisibility;
import static utilities.WriteToTxt.savePhysicianData;

public class UserManagementSteps {
    UserManagementPage userManagementPage = new UserManagementPage();
    Faker faker = new Faker();
    PhysicianPojo physicianPojo = new PhysicianPojo();


    @Given("user clicks on Administration DropDown")
    public void user_clicks_on_administration_drop_down() throws InterruptedException {
        Driver.wait(1);
        //Driver.waitAndClick(userManagementPage.Administration);
        jsClick(userManagementPage.Administration);


    }


    @Given("user clicks user management")
    public void user_clicks_user_management() {
        //Driver.wait(1);
        jsClick(userManagementPage.userManagement);
        //Driver.wait(1);

    }


    @Given("user clicks create a new user button")
    public void user_clicks_create_a_new_user_button() {
        Driver.waitAndClick(userManagementPage.createNewUser);
    }

    @Given("user enters login {string},First Name {string},Last Name {string},Email {string}, SSN {string}")
    public void user_enters_login_first_name_last_name_email_ssn(String login, String firstName, String lastName,
                                                                 String email, String ssn) {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        login = firstName + "." + lastName;
        email = faker.internet().emailAddress();
        ssn = faker.idNumber().ssnValid();
        physicianPojo.setFirstName(firstName);
        physicianPojo.setLastName(lastName);
        physicianPojo.setLogin(login);
        physicianPojo.setEmail(email);
        physicianPojo.setSsn(ssn);

        System.out.println(physicianPojo.getFirstName());
        System.out.println(physicianPojo.getSsn());
        savePhysicianData(physicianPojo);
        //System.out.println(firstName+"\n"+lastName+"\n"+login+"\n"+email+"\n"+ssn);

        Driver.waitAndSendText(userManagementPage.loginInput, login);
        Driver.waitAndSendText(userManagementPage.firstName, firstName);
        Driver.waitAndSendText(userManagementPage.lastName, lastName);
        Driver.waitAndSendText(userManagementPage.email, email);
        Driver.waitAndSendText(userManagementPage.ssn, ssn);
        Driver.waitAndClick(userManagementPage.rolePhysician);
        Driver.waitAndClick(userManagementPage.saveButton);
    }

    @Given("user choose items and titles and clicks physician")
    public void user_choose_items_and_titles_and_clicks_physician() {
        Driver.wait(1);
        Driver.waitAndClick(userManagementPage.itemsTitlesDD);
        Driver.waitAndClick(userManagementPage.physicianDD);
    }

    @Given("user hit create a new physician button and search by ssn")
    public void user_hit_create_a_new_physician_button_and_search_by_ssn() {

        jsClick(userManagementPage.createPhysicianButton);
        jsClick(userManagementPage.ssnSearchCheck);
        Driver.waitAndSendText(userManagementPage.ssnSearchTextBox, physicianPojo.getSsn());
        jsClick(userManagementPage.searchUserButton);

    }

    @Given("user adds phone number {string}, exam fee \"{int}\"and hit save button")
    public void user_adds_phone_number_exam_fee_and_hit_save_button(String phoneNumber, Integer examFee) {
        //phoneNumber = String.valueOf(faker.phoneNumber());
        Driver.waitAndSendText(userManagementPage.physicianPhone, phoneNumber);
        Driver.waitAndSendText(userManagementPage.physicianExamFee, String.valueOf(examFee));
        Driver.wait(1);
        Driver.waitAndClick(userManagementPage.physicianSaveButton);
    }

}

