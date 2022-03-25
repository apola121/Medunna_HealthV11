package stepdefinitions.apisteps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Appointment_API;
import pojos.PhysicianPojo;
import utilities.ConfigurationReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Hooks.Hooks.spec;
import static utilities.ApiUtils.getRequest;
import static utilities.Authentication.generateToken;
import static utilities.ReadTxt.*;
import static utilities.WriteToTxt.saveAppointmentAPIData;
import static utilities.WriteToTxt.savePhysicianAPIData;

public class PhysicianApiSteps {
    Response response;
    PhysicianPojo[] physicianPojo;
    String fileName = ConfigurationReader.getProperty("physician_API_records");

    @Given("user sets the necessary path params for physician data")
    public void user_sets_the_necessary_path_params_for_physician_data() {
        //  spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();
        spec.pathParams("first", "api", "second", "physicians");
    }

    @Given("user sends the get request for physician data")
    public void user_sends_the_get_request_for_physician_data() {
        response = getRequest(generateToken(), ConfigurationReader.getProperty("physicians_endpoint"));
        //response.prettyPrint();
    }

    @Given("user deserializes physician data to Java")
    public void user_deserializes_physician_data_to_java() throws IOException {
        ObjectMapper obj = new ObjectMapper();
        physicianPojo = obj.readValue(response.asString(), PhysicianPojo[].class);

        System.out.println("size: " + physicianPojo.length);
        for (int i = 0; i < physicianPojo.length; i++) {
            if (physicianPojo[i] != null) {//to ignore the null ones
                System.out.println("Name: " + physicianPojo[i].getFirstName());
                System.out.println("LastName: " + physicianPojo[i].getLastName());


                if (physicianPojo[i].getUser() != null)//to ignore the null ones
                    System.out.println("SSN: " + physicianPojo[i].getUser().getSsn());
            }
        }
    }

    @Given("user saves the physician data to correspondent files")
    public void user_saves_the_physician_data_to_correspondent_files() {
        savePhysicianAPIData(fileName, physicianPojo);
    }

    @Then("user validates physician with UI Physician data")
    public void user_validates_physician_with_ui_physician_data() {
        List<String> actualAppData = getPhysicianAPI();
        //System.out.println(actualAppData);

        System.out.println("*******");

        List<String> expectedAppData = getPhysicianUI();

        System.out.println(expectedAppData);
        Assert.assertTrue(actualAppData.containsAll(expectedAppData));


    }

}
