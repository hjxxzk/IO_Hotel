package ModelHotelu;

public class Wspollokator extends Gosc {

    private String imieNazwisko;
    private String adresEmail;

    // Konstruktor
    public Wspollokator(String imieNazwisko, String adresEmail) {
        this.imieNazwisko = imieNazwisko;
        this.adresEmail = adresEmail;
    }

    // Gettery i settery
    public String getImieNazwisko() {
        return this.imieNazwisko;
    }

    public void setImieNazwisko(String imieNazwisko) {
        this.imieNazwisko = imieNazwisko;
    }

    public String getAdresEmail() {
        return this.adresEmail;
    }

    public void setAdresEmail(String adresEmail) {
        this.adresEmail = adresEmail;
    }

    // Edytowanie danych kontaktowych
    public void editRoommatesContactInfo(String nowyEmail) {
        this.adresEmail = nowyEmail;
        System.out.println("Zaktualizowano email współlokatora: " + imieNazwisko);
    }
}
