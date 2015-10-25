package tn.med.model.dao;

/**
 * Created by med on 25/10/15.
 */
public class SimulationImpotEntity {

    private double montant1;
    private double montant2;
    private double deductions;
    private boolean onePart;
    private int nbChildren;
    private double impot;
    private double nbParts;

    public double getMontant1() {
        return montant1;
    }

    public void setMontant1(double montant1) {
        this.montant1 = montant1;
    }

    public double getMontant2() {
        return montant2;
    }

    public void setMontant2(double montant2) {
        this.montant2 = montant2;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public boolean isOnePart() {
        return onePart;
    }

    public void setOnePart(boolean onePart) {
        this.onePart = onePart;
    }

    public int getNbChildren() {
        return nbChildren;
    }

    public void setNbChildren(int nbChildren) {
        this.nbChildren = nbChildren;
    }

    public double getImpot() {
        return impot;
    }

    public void setImpot(double impot) {
        this.impot = impot;
    }

    public double getNbParts() {
        return nbParts;
    }

    public void setNbParts(double nbParts) {
        this.nbParts = nbParts;
    }
}
