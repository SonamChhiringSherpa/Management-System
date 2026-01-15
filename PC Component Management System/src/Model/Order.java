/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author user
 */
public class Order {

    private int orderId;
    private LocalDateTime dateTime;
    private double total;

    public Order(int orderId, LocalDateTime dateTime, double total) {
        this.orderId = orderId;
        this.dateTime = dateTime;
        this.total = total;
    }

    public int getOrderId() { return orderId; }
    public LocalDateTime getDateTime() { return dateTime; }
    public double getTotal() { return total; }
}
