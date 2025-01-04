package ModelHotelu;

public class GoscFactoryMethod {

    public static Gosc createGosc(String imieNazwisko, String numerTelefonu, String adresEmail, boolean czyDlaKogos, String specjalneZyczenia) {
        // Jeśli nie ma współlokatorów, tworzymy gościa prywatnego
        return new GoscPrywatny(imieNazwisko, numerTelefonu, adresEmail, czyDlaKogos, specjalneZyczenia);
    }

    public static Gosc createGosc(String nazwaFirmy, int numerVat, int numerNip, String imieNazwisko, String numerTelefonu, String adresEmail, boolean czyDlaKogos, String specjalneZyczenia) {
        return new GoscSluzbowy(nazwaFirmy, numerVat, numerNip, imieNazwisko, numerTelefonu, adresEmail, czyDlaKogos, specjalneZyczenia);
    }

    public static Gosc createGosc(String imieNazwisko, String numerTelefonu, String adresEmail) {
        // Jeśli gość nie ma współlokatorów, tworzymy współlokatora
        return new Wspollokator(imieNazwisko, adresEmail);
    }
}
