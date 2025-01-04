package InterfejsHotelu;

import ModelHotelu.FormaPlatnosci;

public interface IPlatnosc {

    /**
     * Pays in advance with a given prepayment amount.
     *
     * @param przedplata the prepayment amount
     */
    void payInAdvance(float przedplata);

    /**
     * Pays the full price using a specified payment method.
     *
     * @param formaPlatnosci the payment method
     */
    void payFullPrice(FormaPlatnosci formaPlatnosci);

    /**
     * Calculates the remaining price to be paid.
     *
     * @return the remaining price to be paid
     */
    float calculatePriceLeftToPay();
}
