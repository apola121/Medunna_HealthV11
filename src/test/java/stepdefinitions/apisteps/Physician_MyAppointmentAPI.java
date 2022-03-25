package stepdefinitions.apisteps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import org.junit.Assert;
import pojos.Appointment_API;
import utilities.ConfigurationReader;
import io.restassured.response.Response;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Hooks.Hooks.spec;
import static junit.framework.TestCase.assertEquals;
import static utilities.ApiUtils.getRequest;
import static utilities.Authentication.generateToken;
import static utilities.ReadTxt.getAPIAppointments;
import static utilities.WriteToTxt.*;

public class Physician_MyAppointmentAPI {
    Response response;
    //String token;
    //String appointmentEndpoint = ConfigurationReader.getProperty("appointments_endpoint");
    String fileName = ConfigurationReader.getProperty("appointment_API_records");
    Appointment_API[] appointment_apis;

    @Given("user sets the necessary path params for appointments")
    public void user_sets_the_necessary_path_params_for_appointments() {
        //spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();
        //spec.pathParams("first", "api", "second", "appointments");
    }

    @Given("user sends the get request for appointment data")
    public void user_sends_the_get_request_for_appointment_data() {
        response = getRequest(generateToken(), ConfigurationReader.getProperty("appointments_endpoint"));
        //response.prettyPrint();
    }

    @Given("user deserializes appointment data to Java")

    public void user_deserializes_appointment_data_to_java() throws IOException {
        ObjectMapper obj = new ObjectMapper();
        appointment_apis = obj.readValue(response.asString(), Appointment_API[].class);
        System.out.println("size: " + appointment_apis.length);
        for (int i = 0; i < appointment_apis.length; i++) {
            if (appointment_apis[i].getPatient() != null) {//to ignore the null ones
                System.out.println("Name: " + appointment_apis[i].getPatient().getFirstName());
                System.out.println("LastName: " + appointment_apis[i].getPatient().getLastName());
                System.out.println("Patient ID: " + appointment_apis[i].getPatient().getId());
                System.out.println("App Start Date: " + appointment_apis[i].getStartDate());
                System.out.println("App End Date: " + appointment_apis[i].getEndDate());

                if (appointment_apis[i].getPatient().getUser() != null)//to ignore the null ones
                    System.out.println("SSN: " + appointment_apis[i].getPatient().getUser().getSsn());
            }
        }


    }


    @Given("user saves the users appointment data to correspondent files")
    public void user_saves_the_users_appointment_data_to_correspondent_files() {
        saveAppointmentAPIData(fileName, appointment_apis);

    }

    @Then("user validates api appointment with {string} , {string}, {string}, {string}")
    public void user_validates_api_appointment_with(String id, String startDate, String endDate, String status) {

        List<String> actualAppData = getAPIAppointments();
        System.out.println(actualAppData);
        List<String> expectedAppData = new ArrayList<>();
        expectedAppData.add(id);
        //Assert.assertTrue(actualAppData.containsAll(expectedAppData));

        expectedAppData.add(startDate);
        expectedAppData.add(endDate);
        expectedAppData.add(status);
        System.out.println("*******");
        System.out.println(expectedAppData);
        Assert.assertTrue(actualAppData.containsAll(expectedAppData));
    }
}
