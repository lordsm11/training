package tn.med.model.dto;

public class ImpotForm {

    private String amount1;
    private String amount2;
    private String deductions;
    private int onePart;
    private int nbChildren;

    public String getAmount1() {
        return amount1;
    }

    public void setAmount1(String amount1) {
        this.amount1 = amount1;
    }

    public String getAmount2() {
        return amount2;
    }

    public void setAmount2(String amount2) {
        this.amount2 = amount2;
    }

    public String getDeductions() {
        return deductions;
    }

    public void setDeductions(String deductions) {
        this.deductions = deductions;
    }

    public int getOnePart() {
        return onePart;
    }

    public boolean isCelibataire() {
        return 0 == onePart;
    }

    public void setOnePart(int onePart) {
        this.onePart = onePart;
    }

    public int getNbChildren() {
        return nbChildren;
    }

    public void setNbChildren(int nbChildren) {
        this.nbChildren = nbChildren;
    }

    @Override
    public String toString() {
        return "ImpotForm{" +
                "amount1='" + amount1 + '\'' +
                ", amount2='" + amount2 + '\'' +
                ", deductions='" + deductions + '\'' +
                ", onePart=" + onePart +
                ", nbChildren='" + nbChildren + '\'' +
                '}';
    }
}
