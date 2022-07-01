/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcaj.bean;

/**
 *
 * @author Marcos
 */
import java.io.Serializable;

public class BeanProduto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private Double price;
    private Integer quantity;
    private boolean check;

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public BeanProduto() {
    }

    public BeanProduto(String name, Double price, Integer quantity) {
        super();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BeanProduto{" + "name=" + name + ", price=" + price + ", quantity=" + quantity + ", check=" + check + '}';
    }

}
