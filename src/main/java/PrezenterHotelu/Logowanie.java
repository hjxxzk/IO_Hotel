package PrezenterHotelu;

public class Logowanie implements IRecepjonistkaAutoryzacja {

    private String imie;
    private String nazwisko;
    private int id;
    private IRecepjonistkaAutoryzacja zalogowanyRecepcjonista; // Represents the logged-in receptionist

    // Constructor to initialize the receptionist details
    public Logowanie(String imie, String nazwisko, int id) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.id = id;
        this.zalogowanyRecepcjonista = null;  // Initially, no receptionist is logged in
    }

    @Override
    public IRecepjonistkaAutoryzacja getZalogowany() {
        return zalogowanyRecepcjonista;  // Return the logged-in receptionist object
    }

    @Override
    public void setZalogowany(IRecepjonistkaAutoryzacja obecnieZalogowany) {
        this.zalogowanyRecepcjonista = obecnieZalogowany;  // Set the logged-in receptionist
    }

    @Override
    public String getImie() {
        return this.imie;  // Return the receptionist's first name
    }

    @Override
    public String getNazwisko() {
        return this.nazwisko;  // Return the receptionist's last name
    }

    @Override
    public int getId() {
        return this.id;  // Return the receptionist's ID
    }

    // Additional methods (if needed):

    /**
     * Method to log out the current receptionist.
     */
    public void logout() {
        this.zalogowanyRecepcjonista = null;  // Set the logged-in receptionist to null (log out)
    }

    /**
     * Method to check if a receptionist is logged in.
     *
     * @return true if a receptionist is logged in, false otherwise
     */
    public boolean isLoggedIn() {
        return this.zalogowanyRecepcjonista != null;  // Return true if a receptionist is logged in
    }
}
