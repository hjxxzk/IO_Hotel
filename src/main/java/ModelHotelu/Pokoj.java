package ModelHotelu;

import InterfejsHotelu.IPokoj;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
    public void deleteReservationDate(String dataRozpoczecia, String dataZakonczenia) {
        for (Termin termin : terminy) {
            if (termin.getData_rozpoczecia_pobytu().equals(dataRozpoczecia) &&
                    termin.getData_zakonczenia_pobytu().equals(dataZakonczenia)) {
                terminy.remove(termin);
                break;
            }
        }
    }

    /**
     * Edits an existing reservation by modifying the start and end dates.
     *
     * @param dataRozpoczecia the original start date
     * @param dataZakonczenia the original end date
     * @param zmienionaDataRozpoczecia the new start date
     * @param zmienionaDataZakonczenia the new end date
     */
    public void editReservationDate(String dataRozpoczecia, String dataZakonczenia,
                                    String zmienionaDataRozpoczecia, String zmienionaDataZakonczenia) {
        for (Termin termin : terminy) {
            if (termin.getData_rozpoczecia_pobytu().equals(dataRozpoczecia) &&
                    termin.getData_zakonczenia_pobytu().equals(dataZakonczenia)) {
                Termin nowyTermin = new Termin(zmienionaDataRozpoczecia, zmienionaDataZakonczenia);
                terminy.add(nowyTermin);
                terminy.remove(termin);
                break;
            }
        }
    }

    /**
     * Calculates the cost of a reservation based on the given start and end dates.
     *
     * @param dataRozpoczecia the start date of the reservation
     * @param dataZakonczenia the end date of the reservation
     * @return the total cost of the reservation
     */
    public float calculateCost(String dataRozpoczecia, String dataZakonczenia) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(dataRozpoczecia, formatter);
        LocalDate endDate = LocalDate.parse(dataZakonczenia, formatter);
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

        return daysBetween * koszt;
    }

    /**
     * Adds a reservation date to the list of reservation dates.
     *
     * @param nowyTermin the date of the reservation
     */
    public void addReservationDate(Termin nowyTermin) {
        terminy.add(nowyTermin);
    }
}
