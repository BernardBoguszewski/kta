package pl.com.britenet.kta.entity.crm;

import java.util.Set;

public class Beneficjent extends Kontakt {

    private String rokUrodzenia;

    private boolean niepelnosprawny;
    private String dataWystawieniaZaswiadczenia;
    private String dataWaznosciZaswiadczenia;

    //Otoczenie - z sekcji 1.1.10. Lista osób wpisana w projekty
    private boolean rodzic;
    private boolean rodzenstwo;

    // z sekcji 1.1.10. Lista osób wpisana w projekty
//2.3. Nazwa projektu (możliwość wpisania więcej niż jednego)
    private Set<String> projekty;
    private int liczbaGodzinUdzielonegoWsparcia;
    private String rok; ///???
}
