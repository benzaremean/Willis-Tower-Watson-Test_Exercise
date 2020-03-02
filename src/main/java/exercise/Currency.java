package exercise;

import java.math.BigDecimal;

enum Currency {
    GBP(new BigDecimal(1.0)),
    EUR(new BigDecimal(1.5));
 
    private final BigDecimal coefficient;

    public BigDecimal getCoefficient() {
        return coefficient;
    }
 
    private Currency(BigDecimal coefficient) {
        this.coefficient = coefficient;
    }

}