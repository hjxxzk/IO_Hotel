package ModelHotelu;

import InterfejsHotelu.IPlatnosc;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Platnosc implements IPlatnosc {

    private float przedplata;
    private final float koszt;
    private FormaPlatnosci formaPlatnosci;
    private String dataPlatnosci;
    private String dataPrzedplaty;
    @JsonCreator
    public Platnosc(
            @JsonProperty("przedplata") float przedplata,
            @JsonProperty("koszt") float koszt,
            @JsonProperty("formaPlatnosci") FormaPlatnosci formaPlatnosci,
            @JsonProperty("dataPlatnosci") String dataPlatnosci,
            @JsonProperty("dataPrzedplaty") String dataPrzedplaty) {
        this.przedplata = przedplata;
        this.koszt = koszt;
        this.formaPlatnosci = formaPlatnosci;
        this.dataPlatnosci = dataPlatnosci;
        this.dataPrzedplaty = dataPrzedplaty;
    }
    public float getPrzedplata() {
        return this.przedplata;
    }

    public void setPrzedplata(float przedplata) {
        this.przedplata = przedplata;
    }

    public float getKoszt() {
        return this.koszt;
    }

    public FormaPlatnosci getFormaPlatnosci() {
        return this.formaPlatnosci;
    }

    public void setFormaPlatnosci(FormaPlatnosci formaPlatnosci) {
        this.formaPlatnosci = formaPlatnosci;
    }

    public String getDataPlatnosci() {
        return this.dataPlatnosci;
    }

    public void setDataPlatnosci(String dataPlatnosci) {
        this.dataPlatnosci = dataPlatnosci;
    }

    public String getDataPrzedplaty() {
        return this.dataPrzedplaty;
    }

    public void setDataPrzedplaty(String dataPrzedplaty) {
        this.dataPrzedplaty = dataPrzedplaty;
    }

    /**
     * Pays in advance with the given prepayment amount.
     *
     * @param przedplata the prepayment amount
     */
    @Override
    public void payInAdvance(float przedplata) {
        this.przedplata = przedplata;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.dataPrzedplaty = sdf.format(new Date());
    }

    /**
     * Pays the full price using the specified payment method.
     *
     * @param formaPlatnosci the payment method
     */
    @Override
    public void payFullPrice(FormaPlatnosci formaPlatnosci) {
        this.formaPlatnosci = formaPlatnosci;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.dataPlatnosci = sdf.format(new Date());
        this.przedplata = koszt;
    }

    /**
     * Calculates the remaining price to be paid after prepayment.
     *
     * @return the remaining price to be paid
     */
    @Override
    public float calculatePriceLeftToPay() {
        return this.koszt - this.przedplata;
    }
}
