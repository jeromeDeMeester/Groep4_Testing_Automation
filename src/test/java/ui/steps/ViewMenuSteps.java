package ui.steps;

//import domain.model.Examination;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import domain.model.Patient;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import ui.OverviewPage;
import ui.Page;
import ui.RegisterPage;

import java.util.List;

import static org.junit.Assert.*;

public class ViewMenuSteps {

    private WebDriver driver;
    //path needs to be the same as in the tomcat configuration.
    private String path = "http://localhost:8080/Controller";

    private Page currentPage;

    //starting up chrome driver
    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "/Users/.../web3pers/chromedriver");
        // windows: gebruik dubbele \\ om pad aan te geven
        // hint: zoek een werkende test op van web 2 ...
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\herre\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    //only checking the data, no need for cleanup
    @After
    public void clean() {
        driver.quit();
    }

    @Given("dat er maaltijden op het menu staan")
    public void Toon_alle_maaltijden_die_op_het_menu_staan(){
        //no need to register users as they are already registered
    }

    @When("“Jan” op het menu kijkt")
    public void Jan_requests_to_get_all_patients(){
        currentPage = PageFactory.initElements(driver, OverviewPage.class);
    }

    @Then("worden alle maaltijden getoond die op het menu staan")
    public void Alle_maaltijden_zouden_getoond_moeten_worden(){
        assertEquals("Patient Overview - BMI app", driver.getTitle());
        assertTrue(((OverviewPage)currentPage).containsMaaltijdenWithName("broodje1"));
        assertTrue(((OverviewPage)currentPage).containsMaaltijdenWithName("pasta1"));
        assertTrue(((OverviewPage)currentPage).containsMaaltijdenWithName("frietjes"));
        assertTrue(((OverviewPage)currentPage).containsMaaltijdenWithName("broodje2"));
    }

    /* //Examples given by the teachers, i think atleast
    @Given("there are patients registered")
    public void there_are_patients_registered() {
        RegisterPage page = PageFactory.initElements(driver, RegisterPage.class);
        page.setSSN("93051822361");
        page.setGender("MALE");
        page.setLength("180");
        page.setWeight("750000");
        page.submitValid();

        page = PageFactory.initElements(driver, RegisterPage.class);
        page.setSSN("87081220062");
        page.setGender("FEMALE");
        page.setLength("160");
        page.setWeight("800000");
        page.submitValid();
    }

    @When("Martha requests to get all patients")
    public void martha_requests_to_get_all_patients() {
        currentPage = PageFactory.initElements(driver, PatientsPage.class);
    }

    @Then("Martha should be able to get the list of all social security numbers of the registered patients")
    public void martha_should_be_able_to_get_the_list_of_all_social_security_numbers_of_the_registered_patients() {
        assertEquals("Patient Overview - BMI app", driver.getTitle());
        assertTrue(((PatientsPage)currentPage).containsPatientWithSSN("93051822361"));
        assertTrue(((PatientsPage)currentPage).containsPatientWithSSN("87081220062"));
    }

    @Given("there are no patients registered")
    public void there_are_no_patients_registered() {
        driver.get(path+"?command=DeleteAll");
    }

    @Then("Martha should be able to get a message that there are no patients registered")
    public void martha_should_be_able_to_get_a_message_that_there_are_no_patients_registered() {
        currentPage = PageFactory.initElements(driver, PatientsPage.class);
        assertFalse(((PatientsPage)currentPage).containsPatientWithSSN("93051822361"));
        assertTrue(((PatientsPage)currentPage).containsErrorMessage("No patients found"));
    }

    @Then("Martha should be able to get {string}")
    public void martha_should_be_able_to_get(String ssn) {
        assertTrue(((PatientsPage)currentPage).containsPatientWithSSN(ssn));
    }

    @Given("the following patients are registered")
    public void the_following_patients_are_registered(List<String> ssns) {
        RegisterPage page = PageFactory.initElements(driver, RegisterPage.class);
        page.setSSN("93051822361");
        page.setGender("MALE");
        page.setLength("180");
        page.setWeight("750000");
        page.submitValid();

        page = PageFactory.initElements(driver, RegisterPage.class);
        page.setSSN("87081220062");
        page.setGender("FEMALE");
        page.setLength("160");
        page.setWeight("800000");
        page.submitValid();
    }*/

}
