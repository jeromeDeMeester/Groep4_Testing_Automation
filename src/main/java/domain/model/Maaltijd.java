package domain.model;

import java.util.List;

public class Maaltijd implements Comparable<Maaltijd>{
    private String naam;
    private double prijs;
    private String type;
    private boolean vegetarisch;
    private List<String> allergenen;

    public Maaltijd(String naam, double prijs, String type, Boolean vegetarisch, List<String> allergenen) {
        this.naam = naam;
        this.prijs = prijs;
        this.type = type;
        this.vegetarisch = vegetarisch;
        this.allergenen = allergenen;

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
    public boolean isVegetarisch() {
        return vegetarisch;
    }

    public void setVegetarisch(boolean vegetarisch) {
        this.vegetarisch = vegetarisch;
    }

    public List<String> getAllergenen() {
        return allergenen;
    }

    public void setAllergenen(List<String> allergenen) {
        this.allergenen = allergenen;
    }

    @Override
    public int compareTo(Maaltijd o) {
        return this.type.compareTo(o.type);
    }
}
