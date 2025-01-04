package InterfejsHotelu;

import ModelHotelu.Termin;

import java.time.LocalDate;

public interface IPokoj {

    /**
     * Dodaje rezerwację w podanym zakresie dat.
     *
     * @param nowyTermin Data rezerwacji
     */
    void addReservationDate(Termin nowyTermin);

    /**
     * Usuwa rezerwację w podanym zakresie dat.
     *
     * @param dataRozpoczecia Data rozpoczęcia rezerwacji
     * @param dataZakonczenia Data zakończenia rezerwacji
     */
    void deleteReservationDate(String dataRozpoczecia, String dataZakonczenia);

    /**
     * Edytuje istniejącą rezerwację, zmieniając zakres dat.
     *
     * @param dataRozpoczecia         Obecna data rozpoczęcia rezerwacji
     * @param dataZakonczenia         Obecna data zakończenia rezerwacji
     * @param zmienionaDataRozpoczecia Nowa data rozpoczęcia rezerwacji
     * @param zmienionaDataZakonczenia Nowa data zakończenia rezerwacji
     */
    void editReservationDate(String dataRozpoczecia, String dataZakonczenia,
                             String zmienionaDataRozpoczecia, String zmienionaDataZakonczenia);

    /**
     * Oblicza koszt rezerwacji na podstawie podanego zakresu dat.
     *
     * @param dataRozpoczecia Data rozpoczęcia rezerwacji
     * @param dataZakonczenia Data zakończenia rezerwacji
     * @return Koszt rezerwacji
     */
    float calculateCost(String dataRozpoczecia, String dataZakonczenia);
}
