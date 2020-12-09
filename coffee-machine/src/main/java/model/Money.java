package model;

import java.math.BigDecimal;

public record Money(BigDecimal amountInEuroCents) {

    public boolean isLessThan(Money otherMoney) {
        return this.amountInEuroCents.intValue() < otherMoney.amountInEuroCents.intValue();
    }

    public BigDecimal differenceInCentsWith(Money otherMoney) {
        return this.amountInEuroCents().subtract(otherMoney.amountInEuroCents());
    }
}
