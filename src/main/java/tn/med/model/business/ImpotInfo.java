package tn.med.model.business;

import java.math.BigDecimal;

public class ImpotInfo {

    private BigDecimal amount;
    private BigDecimal nbParts;

    public ImpotInfo(BigDecimal amount, BigDecimal nbParts) {
        this.amount = amount;
        this.nbParts = nbParts;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getNbParts() {
        return nbParts;
    }

    public void setNbParts(BigDecimal nbParts) {
        this.nbParts = nbParts;
    }
}
