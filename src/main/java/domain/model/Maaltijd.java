package domain.model;

public class Maaltijd {
    private String naam;
    private double prijs;
    private String type;

    public Maaltijd(String naam, double prijs, String type) {
        this.naam = naam;
        this.prijs = prijs;
        this.type = type;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
