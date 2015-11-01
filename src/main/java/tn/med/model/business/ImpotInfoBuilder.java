package tn.med.model.business;

import tn.med.model.dto.ImpotForm;
import tn.med.utility.DecimalUtils;

import java.math.BigDecimal;

public class ImpotInfoBuilder {

    private ImpotForm impotForm;

    public ImpotInfoBuilder() {

    }

    public ImpotInfo build() {

        BigDecimal amount1 = DecimalUtils.convertToBigDecimal(impotForm.getAmount1())
                .subtract(DecimalUtils.convertToBigDecimal(impotForm.getDeductions()));
        boolean isOnePart = impotForm.isCelibataire();

        if(isOnePart) {
            return new ImpotInfo(amount1,BigDecimal.ONE);
        }else {
            BigDecimal amount2 = DecimalUtils.convertToBigDecimal(impotForm.getAmount2());
            double nbParts = 2 + ((impotForm.getNbChildren() <= 2)? impotForm.getNbChildren() * 0.5 : 3 + (impotForm.getNbChildren()-2));
            return new ImpotInfo(amount1.add(amount2),BigDecimal.valueOf(nbParts));
        }
    }

    public ImpotInfoBuilder withImpotForm(ImpotForm impotForm) {
        this.setImpotForm(impotForm);
        return this;
    }

    public ImpotForm getImpotForm() {
        return impotForm;
    }

    public void setImpotForm(ImpotForm impotForm) {
        this.impotForm = impotForm;
    }

}
