package tn.med.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.med.model.business.ImpotInfo;
import tn.med.model.business.ImpotInfoBuilder;
import tn.med.model.constants.ImpotEnum;
import tn.med.model.dto.ImpotForm;
import tn.med.model.dto.SimulationImpotDto;
import tn.med.persistance.ImpotsDao;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ImpotsService {

    private static BigDecimal TAUX_CHARGE = BigDecimal.valueOf(90);
    private static BigDecimal CENT = BigDecimal.valueOf(100);

    @Autowired
    private ImpotsDao impotsDao;

    public SimulationImpotDto calculateImpots(ImpotForm impotForm){
        ImpotInfo impotInfo = new ImpotInfoBuilder().withImpotForm(impotForm).build();
        BigDecimal amount = substractCharges(impotInfo.getAmount());
        BigDecimal impot = calculateImpots(amount,impotInfo.getNbParts());
        BigDecimal taux = impot.multiply(CENT).divide(amount,2,RoundingMode.HALF_UP);
        impotsDao.saveObject(impotForm,impotInfo,impot);
        return new SimulationImpotDto(amount+"",impotInfo.getNbParts()+"",impot+"",taux+"");
    }

    private BigDecimal substractCharges(BigDecimal amount) {
        return amount.multiply(TAUX_CHARGE).divide(CENT, 2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateImpots(BigDecimal amount, BigDecimal nbParts) {
        BigDecimal impot = BigDecimal.ZERO;
        for(ImpotEnum impotEnum : ImpotEnum.values()){
            impot = impot.add(calculateImpotsPlage(amount, impotEnum, nbParts));
        }
        return impot;
    }

    private BigDecimal calculateImpotsPlage(BigDecimal amount, ImpotEnum impotEnum, BigDecimal nbParts) {

        BigDecimal seuil1 = impotEnum.getSeuil1().multiply(nbParts);
        BigDecimal seuil2 = impotEnum.getSeuil2().multiply(nbParts);

        BigDecimal minSeuil2Amount;
        if(seuil2.compareTo(BigDecimal.ZERO) == 0 || seuil2.compareTo(amount) > 0) {
            minSeuil2Amount = amount;
        }else {
            minSeuil2Amount = seuil2;
        }

        if(seuil1.compareTo(amount) < 0) {
            return minSeuil2Amount.subtract(seuil1).multiply(impotEnum.getTaux()).divide(CENT, 2, RoundingMode.HALF_UP);
        }

        return BigDecimal.ZERO;
    }

}
