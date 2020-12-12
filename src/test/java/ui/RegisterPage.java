package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends Page {

    @FindBy(id="naam")
    private WebElement naamField;

    @FindBy(id="prijs")
    private WebElement prijsField;

    @FindBy(id="type")
    private WebElement typeField;

    @FindBy(id="vegetarisch")
    private WebElement vegetarischField;

    @FindBy(id="allergenen")
    private WebElement allergenenField;

    @FindBy(id="register")
    private WebElement registerButton;

    public RegisterPage (WebDriver driver) {
        super(driver);
        this.driver.get(getPath()+"?command=SignUp");
    }

    public void setNaam(String Naam) {
        naamField.clear();
        naamField.sendKeys(Naam);
    }

    public void setPrijs(String Prijs) {
        prijsField.clear();
        prijsField.sendKeys(Prijs);
    }

    public void setType(String Type) {
        typeField.clear();
        typeField.sendKeys(Type);
    }

    public void setVegetarisch(Boolean Vegetarisch) {
        if(Vegetarisch){
            vegetarischField.click();
        }
    }

    public void setAllergenen(String allergenen) {
        allergenenField.clear();
        allergenenField.sendKeys(allergenen);
    }

    public void submitValid() {
        registerButton.click();
    }

}
