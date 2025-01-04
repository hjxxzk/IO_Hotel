package ModelHotelu;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

/**
 * Factory Method
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "typ"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = GoscPrywatny.class, name = "prywatny"),
        @JsonSubTypes.Type(value = GoscSluzbowy.class, name = "sluzbowy"),
        @JsonSubTypes.Type(value = Wspollokator.class, name = "wspollokator")
})
public abstract class Gosc {
    private AdresZamieszkania adresZamieszkania;
    private String imieNazwisko;

    private String numerTelefonu;
    private String adresEmail;
    private boolean czyDlaKogos;
    private List<Wspollokator> wspollokatorzy;
    private String specjalneZyczenia;
    public String getImieNazwisko() {
        return this.imieNazwisko;
    }

    public AdresZamieszkania getAdresZamieszkania() {
        return adresZamieszkania;
    }

    public void setAdresZamieszkania(AdresZamieszkania adresZamieszkania) {
        this.adresZamieszkania = adresZamieszkania;
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
