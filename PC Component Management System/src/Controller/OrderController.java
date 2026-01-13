/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.CartItem;
import Model.CartStack;
import Model.Order;
import Model.AppStore;
import java.time.LocalDateTime;
import java.util.List;
/**
 *
 * @author user
 */
public class OrderController {
     private final AppStore store = AppStore.getInstance();

    // Create order from user's cart stack and enqueue it
    public Order placeOrder(String username, CartStack cartStack) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username missing.");
        }
        if (cartStack == null || cartStack.isEmpty()) {
            throw new IllegalArgumentException("Cart is empty.");
        }

        List<CartItem> itemsSnapshot = cartStack.toList(); // top->bottom snapshot
        Order order = new Order(username, LocalDateTime.now(), itemsSnapshot); // store date/time [web:634]
        store.getOrders().enqueue(order);

        // Clear cart after placing order (optional but typical)
        cartStack.clear();   // implement clear() in your CartStack (shown below)

        return order;
    }
}
