package tn.med.model.dto;

public class SimulationImpotDto {

    private String amount;
    private String nbParts;
    private String impot;
    private String taux;

    public SimulationImpotDto(String amount, String nbParts, String impot, String taux) {
        this.amount = amount;
        this.nbParts = nbParts;
        this.impot = impot;
        this.taux = taux;
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
}
