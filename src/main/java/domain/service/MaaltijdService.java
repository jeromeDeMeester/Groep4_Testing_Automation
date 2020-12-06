package domain.service;

import domain.model.Maaltijd;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaaltijdService {

    private static MaaltijdService INSTANCE;
    private List<Maaltijd> maaltijden = new ArrayList<Maaltijd>();

    public MaaltijdService() {
        ArrayList<String> allergenen = new ArrayList<>();
        allergenen.add("Pindas");
        allergenen.add("Lactose");
        Maaltijd maaltijd = new Maaltijd("broodje1", 3,"broodje", false,new ArrayList<>());
        Maaltijd maaltijd2 = new Maaltijd("pasta1", 4,"pasta",false, new ArrayList<>());
        Maaltijd maaltijd3 = new Maaltijd("frietjes", 3,"snack", true, new ArrayList<>());
        Maaltijd maaltijd4 = new Maaltijd("broodje2", 5,"broodje", false, allergenen);
        this.add(maaltijd);
        this.add(maaltijd2);
        this.add(maaltijd3);
        this.add(maaltijd4);
        Collections.sort(maaltijden);
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
