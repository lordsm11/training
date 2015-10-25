package tn.med.model.dto;

public class ImpotForm {
    
    private String amount1;
    private String amount2;
    private String deductions;
    private boolean onePart;
    private String nbChildren;

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

    public boolean isOnePart() {
        return onePart;
    }

    public void setOnePart(boolean onePart) {
        this.onePart = onePart;
    }

    public String getNbChildren() {
        return nbChildren;
    }

    public void setNbChildren(String nbChildren) {
        this.nbChildren = nbChildren;
    }
}
