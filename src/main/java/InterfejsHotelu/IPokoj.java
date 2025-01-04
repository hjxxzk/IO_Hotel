package InterfejsHotelu;

import java.time.LocalDate;

public interface IPokoj {

    /**
     * Dodaje rezerwację w podanym zakresie dat.
     *
     * @param dataRozpoczecia Data rozpoczęcia rezerwacji
     * @param dataZakonczenia Data zakończenia rezerwacji
     */
    void addReservationDate(LocalDate dataRozpoczecia, LocalDate dataZakonczenia);

    /**
     * Usuwa rezerwację w podanym zakresie dat.
     *
     * @param dataRozpoczecia Data rozpoczęcia rezerwacji
     * @param dataZakonczenia Data zakończenia rezerwacji
     */
    void deleteReservationDate(LocalDate dataRozpoczecia, LocalDate dataZakonczenia);

    /**
     * Edytuje istniejącą rezerwację, zmieniając zakres dat.
     *
     * @param dataRozpoczecia         Obecna data rozpoczęcia rezerwacji
     * @param dataZakonczenia         Obecna data zakończenia rezerwacji
     * @param zmienionaDataRozpoczecia Nowa data rozpoczęcia rezerwacji
     * @param zmienionaDataZakonczenia Nowa data zakończenia rezerwacji
     */
    void editReservationDate(LocalDate dataRozpoczecia, LocalDate dataZakonczenia,
                             LocalDate zmienionaDataRozpoczecia, LocalDate zmienionaDataZakonczenia);

    /**
     * Oblicza koszt rezerwacji na podstawie podanego zakresu dat.
     *
     * @param dataRozpoczecia Data rozpoczęcia rezerwacji
     * @param dataZakonczenia Data zakończenia rezerwacji
     * @return Koszt rezerwacji
     */
    float calculateCost(LocalDate dataRozpoczecia, LocalDate dataZakonczenia);
}
