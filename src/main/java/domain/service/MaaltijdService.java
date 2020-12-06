package domain.service;

import domain.model.Maaltijd;


import java.util.ArrayList;
import java.util.List;

public class MaaltijdService {

    private static MaaltijdService INSTANCE;
    private List<Maaltijd> maaltijden = new ArrayList<Maaltijd>();

    public MaaltijdService() {
        Maaltijd maaltijd = new Maaltijd("broodje1", 3,"broodje");
        Maaltijd maaltijd2 = new Maaltijd("pasta1", 4,"pasta");
        Maaltijd maaltijd3 = new Maaltijd("frietjes", 3,"snack");
        Maaltijd maaltijd4 = new Maaltijd("broodje2", 5,"broodje");
        this.add(maaltijd);
        this.add(maaltijd2);
        this.add(maaltijd3);
        this.add(maaltijd4);
    }

    public static MaaltijdService getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new MaaltijdService();
        }
        return INSTANCE;
    }

    public List<Maaltijd> getMaaltijden () {
        return maaltijden;
    }

    public void add (Maaltijd maaltijd) {
        maaltijden.add(maaltijd);
    }


    public void deleteAll () {
        maaltijden = new ArrayList<Maaltijd>();
    }

    public Maaltijd getMaaltijdWitSSN(String naam) {
        for (Maaltijd maaltijd: maaltijden) {
            if (maaltijd.getNaam().equals(naam)) {
                return maaltijd;
            }
        }
        return null;
    }
}
