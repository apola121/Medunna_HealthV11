package stepdefinitions.ui_steps_defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.LoginPage;
import pages.PhysicianPage;
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
import static utilities.ReusableMethods.waitForVisibility;

public class Physician_MyAppointments {

    LoginPage loginPage = new LoginPage();
    PhysicianPage physicianPage = new PhysicianPage();

    @Given("Go to Medunna web site")
    public void go_to_medunna_web_site() {

        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));

    }

    @Given("Navigate and sign in with doctor credentials with username {string} and {string}")
    public void navigate_and_sign_in_with_doctor_credentials_with_username_and(String username, String password) {
        loginPage.loginDropdown.click();
        loginPage.signInButton.click();
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();

    }

    @Given("Click on My Pages tab and choose My Appointments")
    public void click_on_my_pages_tab_and_choose_my_appointments() throws ParseException {
        Driver.waitAndClick(physicianPage.myPages);
        Driver.waitAndClick(physicianPage.myAppointments);
        LocalDateTime ldt = LocalDateTime.now();
        String fromDate = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH).format(ldt);
        System.out.println(fromDate);
        //System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ldt));
        Driver.waitAndSendText(physicianPage.fromDate, fromDate);
        Driver.waitAndSendText(physicianPage.toDate, "03/21/2022");

    }

    @Then("Verify that Physician can see the appointments list and time slots on My Appointments")
    public void verify_that_physician_can_see_the_appointments_list_and_time_slots_on_my_appointments() {
//        String appDateTime="20/03/2022 20:00";
//        String appDateTimeActual=physicianPage.appDateTime.getText();
//        System.out.printf(appDateTime);
//        System.out.println(appDateTimeActual);
        Assert.assertTrue(physicianPage.appointmentText.isDisplayed());

    }
    @Then("Verify that user\\(doctor) can see patient id, start date, end date, status")
    public void verify_that_user_doctor_can_see_patient_id_start_date_end_date_status() {
        waitForVisibility(physicianPage.IDText,5);
        String dummy =physicianPage.IDText.getText();
        System.out.println(dummy);

        Assert.assertEquals("ID",physicianPage.IDText.getText());
        Assert.assertEquals("Start DateTime",physicianPage.startDateTime.getText());
        Assert.assertEquals("End DateTime",physicianPage.endDateTime.getText());
        Assert.assertEquals("Status",physicianPage.status.getText());



    }



}
