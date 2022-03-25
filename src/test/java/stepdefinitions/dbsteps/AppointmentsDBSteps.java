package stepdefinitions.dbsteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.ConfigurationReader;
import utilities.DatabaseUtility;

import java.util.ArrayList;
import java.util.List;

import static utilities.DatabaseUtility.createConnection;
import static utilities.ReadTxt.getAppIDs;
import static utilities.ReadTxt.getSSNIDs;
import static utilities.WriteToTxt.saveAppointmentDataDB;

public class AppointmentsDBSteps {

    List<Object> allAppointmentsIDs;

    @Given("user sends the appointment query {string} to DB with column names {string}")
    public void user_sends_the_appointment_query_to_db_with_column_names(String query, String columnName) {


        createConnection(ConfigurationReader.getProperty("db_credentials_url"),
                ConfigurationReader.getProperty("db_username"),
                ConfigurationReader.getProperty("db_password"));

        allAppointmentsIDs = DatabaseUtility.getColumnData(query, columnName);
        System.out.println(allAppointmentsIDs);
    }

    @Given("user saves appointments  data in correspondent files")
    public void user_saves_appointments_data_in_correspondent_files() {
        saveAppointmentDataDB(allAppointmentsIDs);
    }

    @Then("user validates the appointment data")
    public void user_validates_the_appointment_data() {
        List<String> expectedAppIDs = new ArrayList<>();
        expectedAppIDs.add("12496");
        expectedAppIDs.add("21357");
        expectedAppIDs.add("12463");
        System.out.println(expectedAppIDs);
//        12496	Mar 21, 22	Mar 21, 22, 1:00:00 a	UNAPPROVED
//        21357	Mar 16, 22	Mar 16, 22, 1:00:00 a	UNAPPROVED
//        12463	Mar 15, 22	Mar 15, 22, 1:00:00 a	UNAPPROVED

        List<String> actualAppIDs = getAppIDs();
        Assert.assertTrue(actualAppIDs.containsAll(expectedAppIDs));
    }

}
