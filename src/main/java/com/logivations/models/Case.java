package com.logivations.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "box")
public class Case {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int caseId;
    private double caseSizeX;
    private double caseSizeY;
    private double caseSizeZ;
    private double caseV ;
    @OneToOne
    private Product product;

    public Case(double caseSizeX, double caseSizeY, double caseSizeZ, Product product) {
        this.caseSizeX = caseSizeX;
        this.caseSizeY = caseSizeY;
        this.caseSizeZ = caseSizeZ;
        this.product = product;
        this.caseV=caseSizeX*caseSizeY*caseSizeZ;
    }

    public Case(double caseSizeX, double caseSizeY, double caseSizeZ) {
        this.caseSizeX = caseSizeX;
        this.caseSizeY = caseSizeY;
        this.caseSizeZ = caseSizeZ;
        this.caseV=caseSizeX*caseSizeY*caseSizeZ;
    }

    public Case(Product product) {
        this.product = product;
    }

    public Case() {
    }

    public double getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public double getCaseSizeX() {
        return caseSizeX;
    }

    public void setCaseSizeX(double caseSizeX) {
        this.caseSizeX = caseSizeX;
    }

    public double getCaseSizeY() {
        return caseSizeY;
    }

    public void setCaseSizeY(double caseSizeY) {
        this.caseSizeY = caseSizeY;
    }

    public double getCaseSizeZ() {
        return caseSizeZ;
    }

    public void setCaseSizeZ(double caseSizeZ) {
        this.caseSizeZ = caseSizeZ;
    }

    public double getCaseV() {
        return caseV;
    }

    public void setCaseV(double caseV) {
        this.caseV = caseV;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Case{" +
                "caseSizeX=" + caseSizeX +
                ","+ "caseSizeY=" + caseSizeY +
                ","+ "caseSizeZ=" + caseSizeZ +
                ","+ "product=" + product +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Case aCase = (Case) o;
        return Objects.equals(caseId, aCase.caseId) &&
                Objects.equals(caseSizeX, aCase.caseSizeX) &&
                Objects.equals(caseSizeY, aCase.caseSizeY) &&
                Objects.equals(caseSizeZ, aCase.caseSizeZ);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caseId, caseSizeX, caseSizeY, caseSizeZ);
    }
}
