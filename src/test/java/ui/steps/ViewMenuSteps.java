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
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/drivers/chromedriver.exe");//laat deze lijn staan, zorgt dat het multiplatform werkt
        driver = new ChromeDriver();
    }

    //only checking the data, no need for cleanup
    @After
    public void clean() {
        driver.get(path+"?command=DeleteAll");
        driver.quit();
    }

    @Given("dat er maaltijden op het menu staan")
    public void Toon_alle_maaltijden_die_op_het_menu_staan(){
        RegisterPage page = PageFactory.initElements(driver, RegisterPage.class);
        page.setNaam("broodje1");
        page.setPrijs("3.0");
        page.setType("broodje");
        page.submitValid();

        page = PageFactory.initElements(driver, RegisterPage.class);
        page.setNaam("broodje2");
        page.setPrijs("5.0");
        page.setType("broodje");
        page.setAllergenen("Pindas Lactose");
        page.submitValid();

        page = PageFactory.initElements(driver, RegisterPage.class);
        page.setNaam("pasta1");
        page.setPrijs("4.0");
        page.setType("pasta");
        page.submitValid();

        page = PageFactory.initElements(driver, RegisterPage.class);
        page.setNaam("frietjes");
        page.setPrijs("3.0");
        page.setType("snack");
        page.setVegetarisch(true);
        page.submitValid();
    }

    @When("“Jan” op het menu kijkt")
    public void Jan_requests_to_get_all_patients(){
        currentPage = PageFactory.initElements(driver, OverviewPage.class);
    }

    @Then("worden alle maaltijden getoond die op het menu staan")
    public void Alle_maaltijden_zouden_getoond_moeten_worden(){
        assertEquals("Overzicht Menu", driver.getTitle());
        assertTrue(((OverviewPage)currentPage).containsMaaltijdenWithName("broodje1"));
        assertTrue(((OverviewPage)currentPage).containsMaaltijdenWithName("broodje2"));
        assertTrue(((OverviewPage)currentPage).containsMaaltijdenWithName("pasta1"));
        assertTrue(((OverviewPage)currentPage).containsMaaltijdenWithName("frietjes"));
    }

    @Given("er geen maaltijden op het menu staan")
    public void er_geen_maaltijden_op_het_menu_staan(){
        //maaltijden moet leeg zijn dus dit is ok
    }

    @Then("krijgt “Jan” een melding dat er momenteel nog geen broodjes op het menu staan")
    public void krijgt_Jan_een_melding_dat_er_momenteel_nog_geen_broodjes_op_het_menu_staan(){
        assertEquals("Overzicht Menu", driver.getTitle());
        assertTrue(((OverviewPage)currentPage).containsErrorMessage("No patients found"));
    }

    @Given("Dat een “broodje brie” “walnoten” bevat")
    public void datEenBroodjeBrieWalnotenBevat() {
        RegisterPage page = PageFactory.initElements(driver, RegisterPage.class);
        page.setNaam("Broodje Brie");
        page.setPrijs("3.0");
        page.setType("broodje");
        page.setAllergenen("Walnoten");
        page.submitValid();
    }

    @Then("ziet hij dat de maaltijd sporen van walnoten bevat")
    public void zietHijDatDeMaaltijdSporenVanWalnotenBevat() {
        assertEquals("Overzicht Menu", driver.getTitle());
        assertTrue(((OverviewPage)currentPage).containsAlergieWithName("Walnoten"));
    }




    @Given("dat er maaltijden zijn met prijs informatie")
    public void datErMaaltijdenZijnMetPrijsInformatie() {

        RegisterPage page = PageFactory.initElements(driver, RegisterPage.class);
        page.setNaam("Broodje martino");
        page.setPrijs("2.0");
        page.setType("broodje");
        page.submitValid();

        page = PageFactory.initElements(driver, RegisterPage.class);

        page.setNaam("Lasagne");
        page.setPrijs("4.30");
        page.setType("maaltijd");
        page.submitValid();
    }
    

    @Then("zou “Jan” de maaltijden zien met hun prijs")
    public void zouJanDeMaaltijdenZienMetHunPrijs() {
        assertEquals("Overzicht Menu", driver.getTitle());
        assertTrue(((OverviewPage)currentPage).containsMaaltijdenWithNameAndPrice("Broodje martino","2.0"));
        assertTrue(((OverviewPage)currentPage).containsMaaltijdenWithNameAndPrice("Lasagne", "4.3"));
    }
    @Given("lijst van maaltijden")
    public void lijst_van_maaltijden() {
        RegisterPage page = PageFactory.initElements(driver, RegisterPage.class);
        page.setNaam("broodje1");
        page.setPrijs("3.0");
        page.setType("broodje");
        page.submitValid();

        page = PageFactory.initElements(driver, RegisterPage.class);
        page.setNaam("broodje2");
        page.setPrijs("5.0");
        page.setType("broodje");
        page.setAllergenen("Pindas Lactose");
        page.submitValid();

        page = PageFactory.initElements(driver, RegisterPage.class);
        page.setNaam("pasta1");
        page.setPrijs("4.0");
        page.setType("pasta");
        page.submitValid();

        page = PageFactory.initElements(driver, RegisterPage.class);
        page.setNaam("frietjes");
        page.setPrijs("3.0");
        page.setType("snack");
        page.setVegetarisch(true);
        page.setAllergenen("glutenvrij");
        page.submitValid();
    }

    @Then("ziet hij dat de maaltijd vegetarisch is")
    public void ziet_hij_dat_de_maaltijd_vegetarisch_is() {
        assertEquals("Overzicht Menu", driver.getTitle());
        assertTrue(((OverviewPage)currentPage).containsMaaltijdenWithNameIsvegetarisch("frietjes"));

    }
    @When("“Jan” het menu opent")
    public void jan_het_menu_opent() {
        currentPage = PageFactory.initElements(driver, OverviewPage.class);
    }
    @Then("ziet hij dat de maaltijd glutenvrij is")
    public void ziet_hij_dat_de_maaltijd_glutenvrij_is() {
        assertEquals("Overzicht Menu", driver.getTitle());
        assertTrue(((OverviewPage)currentPage).containsMaaltijdenWithNameAndAlergeen("frietjes","glutenvrij"));
    }
    @Given("dat er maaltijden zijn met categorie informatie")
    public void dat_er_maaltijden_zijn_met_categorie_informatie(io.cucumber.datatable.DataTable dataTable) {

        for(int i=1; i<dataTable.height();i++){
            RegisterPage page = PageFactory.initElements(driver, RegisterPage.class);
            page.setNaam(dataTable.row(i).get(0));
            page.setPrijs("3.0");
            page.setType(dataTable.row(i).get(1));

            page.submitValid();
        }
    }
    @Then("zou “Jan” de maaltijden zien met hun categorie")
    public void zou_jan_de_maaltijden_zien_met_hun_categorie() {

        assertEquals("Overzicht Menu", driver.getTitle());
        assertTrue(((OverviewPage)currentPage).containsMaaltijdenWithNameAndcategorie("Broodje martino","broodjes"));
        assertTrue(((OverviewPage)currentPage).containsMaaltijdenWithNameAndcategorie("Lasagne","pasta"));
        assertTrue(((OverviewPage)currentPage).containsMaaltijdenWithNameAndcategorie("tomatensoep","soepen"));
    }
}
