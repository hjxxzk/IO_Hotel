package PrezenterHotelu;

public class RecepcjonistkaSingleton implements IRecepjonistkaAutoryzacja {
    private static RecepcjonistkaSingleton instance;

    private final String imie;
    private final String nazwisko;
    private final int id;

    private static IRecepjonistkaAutoryzacja zalogowanyRecepcjonista;

    RecepcjonistkaSingleton(String imie, String nazwisko, int id) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.id = id;
    }

    public static RecepcjonistkaSingleton getInstance(String imie, String nazwisko, int id) {
        if (instance == null) {
            instance = new RecepcjonistkaSingleton(imie, nazwisko, id);
        }
        return instance;
    }

    @Override
    public IRecepjonistkaAutoryzacja getZalogowany() {
        return zalogowanyRecepcjonista;
    }

    @Override
    public void setZalogowany(IRecepjonistkaAutoryzacja obecnieZalogowany) {
        zalogowanyRecepcjonista = obecnieZalogowany;
    }

    @Override
    public String getImie() {
        return this.imie;
    }

    @Override
    public String getNazwisko() {
        return this.nazwisko;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public static void resetInstance() {
        instance = null;
    }
}
