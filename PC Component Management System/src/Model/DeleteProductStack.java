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
public class DeleteProductStack {
    private static class Node {
        PCComponent data;
        Node next;
        Node(PCComponent data) { this.data = data; }
    }

    private Node top;
    private int size;

    public void push(PCComponent pc) {
        Node n = new Node(pc);
        n.next = top;
        top = n;
        size++;
    }

    public PCComponent pop() {
        if (top == null) return null;
        PCComponent val = top.data;
        top = top.next;
        size--;
        return val;
    }

    public PCComponent peek() {
        return (top == null) ? null : top.data;
    }

    public boolean isEmpty() { return top == null; }
    public int size() { return size; }

    public List<PCComponent> toList() {
        ArrayList<PCComponent> out = new ArrayList<PCComponent>();
        Node cur = top;
        while (cur != null) {
            out.add(cur.data);
            cur = cur.next;
        }
        return out;
    }
}
