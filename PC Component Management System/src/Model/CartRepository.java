/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author user
 */
public class CartRepository {
    
    private static final int MAX_USERS = 200;
    private static final String[] usernames = new String[MAX_USERS];
    private static final CartStack[] carts = new CartStack[MAX_USERS];
    private static int size = 0;

    private static int indexOf(String username) {
        if (username == null) return -1;
        int i;
        for (i = 0; i < size; i++) {
            if (usernames[i] != null && usernames[i].equalsIgnoreCase(username)) {
                return i;
            }
        }
        return -1;
    }

    public static CartStack getOrCreateCart(String username) {
        if (username == null) return null;
        username = username.trim();
        if (username.length() == 0) return null;

        int idx = indexOf(username);
        if (idx != -1) return carts[idx];

        if (size == MAX_USERS) return null;

        usernames[size] = username;
        carts[size] = new CartStack(100);
        size++;

        return carts[size - 1];
    }
}
