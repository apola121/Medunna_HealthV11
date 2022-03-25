package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

import static utilities.DatabaseUtility.createConnection;

public class Hooks {
    @Before
    public void setUp() {
    }

    //
    public static RequestSpecification spec;

    @Before(order =0 ,value = "@PhysicianAPI")
    public void setup() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();
    }


    @Before(order = 1, value = "@UIRegistration")
    public void navigateToRegistrationPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_registration_url"));
    }

    @Before(order = 1, value = "@PhysicianUI")
    public void navigateToMedunnaAndLogin() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));

    }

//UIRegistration

    @Before(order=0,value = "@DBPhysician")
    public void createNewDBConnection() {
        createConnection(ConfigurationReader.getProperty("db_credentials_url"),
                ConfigurationReader.getProperty("db_username"),
                ConfigurationReader.getProperty("db_password"));
    }

   // @Before(order = 1, value = "@DBTest")
    //public void connectionDB() {
   // }

//    @After
//    public void tearDown(Scenario scenario) throws IOException {
//
//        if (scenario.isFailed()) {
//            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//
//            scenario.attach(screenshot, "image/png", "screenshots");
//
//            if (scenario.isFailed()) {
//            screenshot = ReusableMethods.getScreenshot("failed/" + scenario.getName());
//        }else{
//            screenshot = ReusableMethods.getScreenshot("passed/" + scenario.getName());
//        }
//        scenario.attach(screenshot,"image/png", scenario.getName());
//        }
//        //Driver.closeDriver();

    @After
    public void tearDown(Scenario scenario) {

        byte[] screenshot;
        if (scenario.isFailed()) {
            screenshot = ReusableMethods.takeScreenshot("failed/" + scenario.getName());
        }else{
            screenshot = ReusableMethods.takeScreenshot("passed/" + scenario.getName());
        }
        scenario.attach(screenshot,"image/png", scenario.getName());

        Driver.closeDriver();
    }
}