/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author user
 */
public class OrderItem {

    private PCComponent product; // snapshot copy
    private int qty;

    public OrderItem(PCComponent product, int qty) {
        this.product = product;
        this.qty = qty;
    }

    public PCComponent getProduct() {
        return product;
    }

    public int getQty() {
        return qty;
    }

    public double getTotal() {
        return product.getPrice() * qty;
    }
}
