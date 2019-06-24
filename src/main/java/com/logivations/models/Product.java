package com.logivations.models;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private double productSizeX;
    private double productSizeY;
    private double productSizeZ;
    private double productV;

    public Product(double productSizeX, double productSizeY, double productSizeZ) {
        this.productSizeX = productSizeX;
        this.productSizeY = productSizeY;
        this.productSizeZ = productSizeZ;
        this.productV = productSizeX*productSizeY*productSizeZ;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public double getProductSizeX() {
        return productSizeX;
    }

    public void setProductSizeX(double productSizeX) {
        this.productSizeX = productSizeX;
    }

    public double getProductSizeY() {
        return productSizeY;
    }

    public void setProductSizeY(double productSizeY) {
        this.productSizeY = productSizeY;
    }

    public double getProductSizeZ() {
        return productSizeZ;
    }

    public void setProductSizeZ(double productSizeZ) {
        this.productSizeZ = productSizeZ;
    }

    public double getProductV() {
        return productV;
    }

    public void setProductV(double productV) {
        this.productV = productV;
    }

    @Override
    public String toString() {
        return "Product{ " +
                "productSizeX=" + productSizeX +
                ", "+ "productSizeY=" + productSizeY +
                ", "+ "productSizeZ=" + productSizeZ +
                '}';
    }
}
