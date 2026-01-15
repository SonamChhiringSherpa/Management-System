/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author user
 */
public class CartStack {

    private CartItem[] data;
    private int top; // points to next free position

    public CartStack(int capacity) {
        data = new CartItem[capacity];
        top = 0;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public boolean isFull() {
        return top == data.length;
    }

    public void push(CartItem item) {
        if (isFull()) {
            return;
        }
        data[top] = item;
        top++;
    }

    public CartItem pop() {
        if (isEmpty()) {
            return null;
        }
        top--;
        CartItem item = data[top];
        data[top] = null;
        return item;
    }

    public int size() {
        return top;
    }

    public CartItem getAt(int index) {
        if (index < 0 || index >= top) {
            return null;
        }
        return data[index];
    }

    /**
     * Finds an item by product name (linear scan inside stack). This helps "Add
     * to cart" increase qty if already exists.
     */
    public int indexOfProductName(String name) {
        if (name == null) {
            return -1;
        }
        for (int i = 0; i < top; i++) {
            CartItem ci = data[i];
            if (ci != null && ci.getProduct().getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= top) {
            return;
        }

        for (int i = index; i < top - 1; i++) {
            data[i] = data[i + 1];
        }
        data[top - 1] = null;
        top--;
    }

    public void setQtyAt(int index, int qty) {
        CartItem ci = getAt(index);
        if (ci != null) {
            ci.setQty(qty);
        }
    }
}
