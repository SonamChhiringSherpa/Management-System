/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class OrderQueue {
     private static class Node {
        Order data;
        Node next;
        Node(Order data) { this.data = data; }
    }

    private Node front;
    private Node rear;
    private int size;

    public void enqueue(Order order) {
        Node n = new Node(order);
        if (rear == null) {
            front = rear = n;
        } else {
            rear.next = n;
            rear = n;
        }
        size++;
    }

    public Order dequeue() {
        if (front == null) return null;
        Order val = front.data;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return val;
    }

    public Order peek() {
        return (front == null) ? null : front.data;
    }

    public boolean isEmpty() { return front == null; }
    public int size() { return size; }

    // For displaying in admin table without destroying FIFO
    public List<Order> toList() {
        ArrayList<Order> out = new ArrayList<Order>();
        Node cur = front;
        while (cur != null) {
            out.add(cur.data);
            cur = cur.next;
        }
        return out;
    }

    // Optional helper for "View Order" by id
    public Order findById(int orderId) {
        Node cur = front;
        while (cur != null) {
            if (cur.data.getOrderId() == orderId) return cur.data;
            cur = cur.next;
        }
        return null;
    }
}
