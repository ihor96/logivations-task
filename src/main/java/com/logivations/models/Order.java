package com.logivations.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ordder")
public class Order {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrder;
    private int count;
    @ManyToMany
    private List<Product> products;

    public Order(int numberOfProducts, List<Product> products) {
        this.count = numberOfProducts;
        this.products = products;
    }

    public Order(int numberOfProducts) {
        this.count = numberOfProducts;
    }

    public Order() {
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getNumberOfProducts() {
        return count;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.count = numberOfProducts;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", numberOfProducts=" + count +
                ", products=" + products +
                '}';
    }
}