package ModelHotelu;

import InterfejsHotelu.IPokoj;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class Pokoj implements IPokoj {

    private String numer;
    private int pietro;
    private int liczbaGosci;
    private String standard;
    private String udogodnienia;
    private List<Termin> terminy;
    private int koszt;

    @JsonCreator
    public Pokoj(
            @JsonProperty("numer") String numer,
            @JsonProperty("pietro") int pietro,
            @JsonProperty("liczbaGosci") int liczbaGosci,
            @JsonProperty("standard") String standard,
            @JsonProperty("udogodnienia") String udogodnienia,
            @JsonProperty("terminy") List<Termin> terminy,
            @JsonProperty("koszt") int koszt) {
        this.numer = numer;
        this.pietro = pietro;
        this.liczbaGosci = liczbaGosci;
        this.standard = standard;
        this.udogodnienia = udogodnienia;
        this.terminy = terminy;
        this.koszt = koszt;
    }
    public void setTerminy(List<Termin> terminy) {
        this.terminy = terminy;
    }

    public String getNumer() {
        return this.numer;
    }

    public int getPietro() {
        return this.pietro;
    }

    public int getLiczbaGosci() {
        return this.liczbaGosci;
    }

    public String getStandard() {
        return this.standard;
    }

    public String getUdogodnienia() {
        return this.udogodnienia;
    }

    public List<Termin> getTerminy() {
        return this.terminy;
    }

    public int getKoszt() {
        return this.koszt;
    }

    /**
     * Deletes a reservation from the list of reservation dates.
     *
     * @param dataRozpoczecia the start date of the reservation
     * @param dataZakonczenia the end date of the reservation
     */
    public void deleteReservationDate(LocalDate dataRozpoczecia, LocalDate dataZakonczenia) {
        // TODO - implement Pokoj.deleteReservationDate
        throw new UnsupportedOperationException();
    }

    /**
     * Edits an existing reservation by modifying the start and end dates.
     *
     * @param dataRozpoczecia the original start date
     * @param dataZakonczenia the original end date
     * @param zmienionaDataRozpoczecia the new start date
     * @param zmienionaDataZakonczenia the new end date
     */
    public void editReservationDate(LocalDate dataRozpoczecia, LocalDate dataZakonczenia,
                                    LocalDate zmienionaDataRozpoczecia, LocalDate zmienionaDataZakonczenia) {
        // TODO - implement Pokoj.editReservationDate
        throw new UnsupportedOperationException();
    }

    /**
     * Calculates the cost of a reservation based on the given start and end dates.
     *
     * @param dataRozpoczecia the start date of the reservation
     * @param dataZakonczenia the end date of the reservation
     * @return the total cost of the reservation
     */
    public float calculateCost(LocalDate dataRozpoczecia, LocalDate dataZakonczenia) {
        // TODO - implement Pokoj.calculateCost
        throw new UnsupportedOperationException();
    }

    /**
     * Adds a reservation date to the list of reservation dates.
     *
     * @param dataRozpoczecia the start date of the reservation
     * @param dataZakonczenia the end date of the reservation
     */
    public void addReservationDate(LocalDate dataRozpoczecia, LocalDate dataZakonczenia) {
        // TODO - implement Pokoj.addReservationDate
        throw new UnsupportedOperationException();
    }
}
