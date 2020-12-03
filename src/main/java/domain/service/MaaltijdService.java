package domain.service;

import domain.model.Maaltijd;


import java.util.ArrayList;
import java.util.List;

public class MaaltijdService {

    private static MaaltijdService INSTANCE;
    private List<Maaltijd> maaltijden = new ArrayList<Maaltijd>();

    public MaaltijdService() {
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
