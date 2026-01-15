/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author user
 */
public class OrderItemList {
    private OrderItem[] data;
    private int size;

    public OrderItemList(int capacity) {
        data = new OrderItem[capacity];
        size = 0;
    }

    public int size() { return size; }

    public void add(OrderItem item) {
        if (item == null) return;
        if (size == data.length) return;
        data[size] = item;
        size++;
    }

    public OrderItem getAt(int index) {
        if (index < 0 || index >= size) return null;
        return data[index];
    }
}
