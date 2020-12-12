package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public boolean containsMaaltijdenWithNameAndPrice (String naam, String prijs) {
/*    TODO Geen idee hoe ge door rijen kunt iteraten
      List<WebElement> trsWithNameId = driver.findElements(By.id("naam"));
        List<WebElement> trsWithPrijsId = driver.findElements(By.id("prijs"));
        for (WebElement tr: trsWithNameId) {
            for (WebElement tr:
                 ) {

            }
            if (tr.getText().equals(naam)){
                return true;
            }
        }*/

        return false;

    }

    public boolean containsErrorMessage (String naam) {
        WebElement error = driver.findElement(By.cssSelector("em"));
        return error.getText().equals(naam);
    }
}
