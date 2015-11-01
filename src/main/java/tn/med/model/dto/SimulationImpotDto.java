package tn.med.model.dto;

public class SimulationImpotDto {

    private String amount;
    private String nbParts;
    private String impot;
    private String taux;
    private String situation;

    public SimulationImpotDto(String amount, String nbParts, String impot, String taux, String situation) {
        this.amount = amount;
        this.nbParts = nbParts;
        this.impot = impot;
        this.taux = taux;
        this.situation = situation;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getNbParts() {
        return nbParts;
    }

    public void setNbParts(String nbParts) {
        this.nbParts = nbParts;
    }

    public String getImpot() {
        return impot;
    }

    public void setImpot(String impot) {
        this.impot = impot;
    }

    public String getTaux() {
        return taux;
    }

    public void setTaux(String taux) {
        this.taux = taux;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }
}
