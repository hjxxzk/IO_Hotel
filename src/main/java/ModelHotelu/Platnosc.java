package ModelHotelu;

import InterfejsHotelu.IPlatnosc;

import java.time.LocalDate;

public class Platnosc implements IPlatnosc {

    private float przedplata;
    private float koszt;
    private FormaPlatnosci formaPlatnosci;
    private LocalDate dataPlatnosci;
    private LocalDate dataPrzedplaty;

    public float getPrzedplata() {
        return this.przedplata;
    }

    public void setPrzedplata(float przedplata) {
        this.przedplata = przedplata;
    }

    public float getKoszt() {
        return this.koszt;
    }

    public void setKoszt(float koszt) {
        this.koszt = koszt;
    }

    public FormaPlatnosci getFormaPlatnosci() {
        return this.formaPlatnosci;
    }

    public void setFormaPlatnosci(FormaPlatnosci formaPlatnosci) {
        this.formaPlatnosci = formaPlatnosci;
    }

    public LocalDate getDataPlatnosci() {
        return this.dataPlatnosci;
    }

    public void setDataPlatnosci(LocalDate dataPlatnosci) {
        this.dataPlatnosci = dataPlatnosci;
    }

    public LocalDate getDataPrzedplaty() {
        return this.dataPrzedplaty;
    }

    public void setDataPrzedplaty(LocalDate dataPrzedplaty) {
        this.dataPrzedplaty = dataPrzedplaty;
    }

    /**
     * Pays in advance with the given prepayment amount.
     *
     * @param przedplata the prepayment amount
     */
    @Override
    public void payInAdvance(float przedplata) {
        // Implement payInAdvance logic
        this.przedplata = przedplata;
    }

    /**
     * Pays the full price using the specified payment method.
     *
     * @param formaPlatnosci the payment method
     */
    @Override
    public void payFullPrice(FormaPlatnosci formaPlatnosci) {
        // Implement payFullPrice logic
        this.formaPlatnosci = formaPlatnosci;
        this.koszt = 1000; // Example: set full cost to 1000 or however it's calculated
    }

    /**
     * Calculates the remaining price to be paid after prepayment.
     *
     * @return the remaining price to be paid
     */
    @Override
    public float calculatePriceLeftToPay() {
        // Calculate the remaining price to pay
        return this.koszt - this.przedplata;
    }
}
