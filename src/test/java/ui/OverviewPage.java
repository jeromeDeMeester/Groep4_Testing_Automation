package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class OverviewPage extends Page {

    public OverviewPage(WebDriver driver) {
        super(driver);
        driver.get(getPath()+"?command=OverviewMaaltijden");
    }

    public boolean containsMaaltijdenWithName (String naam) {
        List<WebElement> trs = driver.findElements(By.cssSelector("td"));
        for (WebElement tr: trs) {
            if (tr.getText().equals(naam)){
                return true;
            }
        }
        return false;
    }

    public boolean containsAlergieWithName (String naam) {
        List<WebElement> trs = driver.findElements(By.cssSelector("td"));
        for (WebElement tr: trs) {
            if (tr.getText().equals(naam)){
                return true;
            }
        }
        return false;
    }
    public boolean containsMaaltijdenWithNameIsvegetarisch (String naam) {
        ArrayList<WebElement> listItems=(ArrayList<WebElement>) driver.findElements(By.cssSelector("table tr"));
        boolean found=false;
        for (WebElement listItem:listItems) {
            if (listItem.getText().contains(naam) &&  listItem.getText().contains("Ja")) {
                found=true;
            }
        }
        return found;
    }
    public boolean containsMaaltijdenWithNameAndAlergeen (String naam,String alergeen) {
        ArrayList<WebElement> listItems=(ArrayList<WebElement>) driver.findElements(By.cssSelector("table tr"));
        boolean found=false;
        for (WebElement listItem:listItems) {
            if (listItem.getText().contains(naam) &&  listItem.getText().contains(alergeen)) {
                found=true;
            }
        }
        return found;
    }
    public boolean containsMaaltijdenWithNameIsNotvegetarisch (String naam) {
        ArrayList<WebElement> listItems=(ArrayList<WebElement>) driver.findElements(By.cssSelector("table tr"));
        boolean found=false;
        for (WebElement listItem:listItems) {
            if (listItem.getText().contains(naam) &&  listItem.getText().contains("Nee")) {
                found=true;
            }
        }
        return found;
    }

    public boolean containsMaaltijdenWithNameAndPrice (String naam, String prijs) {
 //   TODO Geen idee hoe ge door rijen kunt iteraten
      ArrayList<WebElement> listItems=(ArrayList<WebElement>) driver.findElements(By.cssSelector("table tr"));
        boolean found=false;
        for (WebElement listItem:listItems) {
            if (listItem.getText().contains(naam) &&  listItem.getText().contains(prijs)) {
                found=true;
            }
        }
        return found;

    }
    public boolean containsMaaltijdenWithNameAndcategorie (String naam, String categorie) {
        //   TODO Geen idee hoe ge door rijen kunt iteraten
        ArrayList<WebElement> listItems=(ArrayList<WebElement>) driver.findElements(By.cssSelector("table tr"));
        boolean found=false;
        for (WebElement listItem:listItems) {
            if (listItem.getText().contains(naam) &&  listItem.getText().contains(categorie)) {
                found=true;
            }
        }
        return found;

    }

    public boolean containsErrorMessage (String naam) {
        WebElement error = driver.findElement(By.cssSelector("em"));
        return error.getText().equals(naam);
    }
}
