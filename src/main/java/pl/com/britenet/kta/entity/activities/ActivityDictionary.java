package pl.com.britenet.kta.entity.activities;

public class ActivityDictionary {

    //zajecia terapeutyczne, porada, opinia, zaświadczenie, diagnoza
    // na razie takie tylko aktywnosci pozniej ma byc mozliwosc dodawania
    private String name; //nazwaAktywności
    //1.3. Rodzaj aktywności (wybór z listy - możliwość dodania rodzaju aktywności w widoku dodawania aktywności)


    public ActivityDictionary(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
