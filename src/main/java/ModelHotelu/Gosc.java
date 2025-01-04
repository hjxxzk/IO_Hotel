package ModelHotelu;

import java.util.List;

/**
 * Factory Method
 */
public abstract class Gosc {

    private String imieNazwisko;
    private String numerTelefonu;
    private String adresEmail;
    private boolean czyDlaKogos;
    private List<Wspollokator> wspollokatorzy;
    private String specjalneZyczenia;

    public String getImieNazwisko() {
        return this.imieNazwisko;
    }

    public void setImieNazwisko(String imieNazwisko) {
        this.imieNazwisko = imieNazwisko;
    }

    public String getNumerTelefonu() {
        return this.numerTelefonu;
    }

    public void setNumerTelefonu(String numerTelefonu) {
        this.numerTelefonu = numerTelefonu;
    }

    public String getAdresEmail() {
        return this.adresEmail;
    }

    public void setAdresEmail(String adresEmail) {
        this.adresEmail = adresEmail;
    }

    public boolean isCzyDlaKogos() {
        return this.czyDlaKogos;
    }

    public void setCzyDlaKogos(boolean czyDlaKogos) {
        this.czyDlaKogos = czyDlaKogos;
    }

    public List<Wspollokator> getWspollokatorzy() {
        return this.wspollokatorzy;
    }

    public void setWspollokatorzy(List<Wspollokator> wspollokatorzy) {
        this.wspollokatorzy = wspollokatorzy;
    }

    public String getSpecjalneZyczenia() {
        return this.specjalneZyczenia;
    }

    public void setSpecjalneZyczenia(String specjalneZyczenia) {
        this.specjalneZyczenia = specjalneZyczenia;
    }

    private void addBusinessTrip() {
        // Implement logic
        throw new UnsupportedOperationException();
    }

    private void addRoommates() {
        // Implement logic
        throw new UnsupportedOperationException();
    }

    private void editContactInfo() {
        // Implement logic
        throw new UnsupportedOperationException();
    }

    private void editRoommatesContactInfo() {
        // Implement logic
        throw new UnsupportedOperationException();
    }

    private void deleteRoommate() {
        // Implement logic
        throw new UnsupportedOperationException();
    }
}
