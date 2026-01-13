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

    private static int NEXT_ID = 1;

    private final int orderId;
    private final String username;
    private final LocalDateTime orderDateTime;
    private final List<CartItem> items;   // snapshot of cart at order time
    private final double total;

    public Order(String username, LocalDateTime orderDateTime, List<CartItem> items) {
        this.orderId = NEXT_ID++;
        this.username = username;
        this.orderDateTime = orderDateTime;

        // snapshot copy (so later cart edits don't affect old orders)
        this.items = new ArrayList<CartItem>(items);

        double sum = 0;
        for (CartItem ci : this.items) {
            sum += ci.getTotalPrice();
        }
        this.total = sum;
    }

    public int getOrderId() { return orderId; }
    public String getUsername() { return username; }
    public LocalDateTime getOrderDateTime() { return orderDateTime; }
    public List<CartItem> getItems() { return new ArrayList<CartItem>(items); }
    public double getTotal() { return total; }
}
