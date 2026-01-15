/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class Order {

    private int orderId;
    private String date;
    private String location;
    private String status;
    private double totalAmount;
    private OrderItemList items;

    private String username; 

    public Order(int orderId, String date, String location, String status,
            double totalAmount, OrderItemList items, String username) {
        this.orderId = orderId;
        this.date = date;
        this.location = location;
        this.status = status;
        this.totalAmount = totalAmount;
        this.items = items;
        this.username = username;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public OrderItemList getItems() {
        return items;
    }

    public String getUsername() {
        return username;
    } // NEW

    public void setStatus(String status) {
        this.status = status;
    }
}
