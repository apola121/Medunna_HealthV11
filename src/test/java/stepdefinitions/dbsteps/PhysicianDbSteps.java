package stepdefinitions.dbsteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.ConfigurationReader;
import utilities.DatabaseUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static utilities.DatabaseUtility.createConnection;
import static utilities.DatabaseUtility.getColumnNames;
import static utilities.ReadTxt.*;
import static utilities.WriteToTxt.saveAppointmentDataDB;
import static utilities.WriteToTxt.savePhysicianDataDB;

public class PhysicianDbSteps {
    List<Map< String, Object>> actualMapData;
    @Given("user sends the appointment query {string} to DB")


    @Given("user sends the physician query {string} to DB")
    public void user_sends_the_physician_query_to_db(String query) {
        createConnection(ConfigurationReader.getProperty("db_credentials_url"),
                ConfigurationReader.getProperty("db_username"),
                ConfigurationReader.getProperty("db_password"));

        actualMapData = DatabaseUtility.getQueryResultMap(query);
        System.out.println(actualMapData);
    }
    @Given("user saves physician  data in correspondent files")
    public void user_saves_physician_data_in_correspondent_files() {
        savePhysicianDataDB(actualMapData);

    }

    @Then("user validates the physician data with UI data")
    public void user_validates_the_physician_data_with_ui_data() {
        List<String> actualPhysician = getPhysicianDB();
        System.out.println(actualPhysician);
        System.out.println("***************");
        List<String> expectedPhysicianData = getPhysicianUI_DB();
        System.out.println(expectedPhysicianData);
        Assert.assertTrue(actualPhysician.containsAll(expectedPhysicianData));
    }

}







