package tn.med.model.constants;

import java.math.BigDecimal;

public enum  ImpotEnum {
    
    TRANCHE0(0,9700,0),
    TRANCHE1(9701,26791,14),
    TRANCHE2(26792,71826,30),
    TRANCHE3(71827,152108,41),
    TRANCHE4(152108,0,45);
    
    private Integer seuil1;
    private Integer seuil2;
    private Integer taux;

    ImpotEnum(Integer seuil1, Integer seuil2, Integer taux) {
        this.seuil1 = seuil1;
        this.seuil2 = seuil2;
        this.taux = taux;
    }

    public BigDecimal getSeuil1() {
        return BigDecimal.valueOf(seuil1);
    }

    public BigDecimal getSeuil2() {
        return BigDecimal.valueOf(seuil2);
    }

    public BigDecimal getTaux() {
        return BigDecimal.valueOf(taux);
    }

}
