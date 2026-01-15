/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author user
 */
public class UserSession {
    private static String currentUsername = null;
    private static String currentRole = null; // "ADMIN" or "USER"

    public static void login(String username, String role) {
        currentUsername = username;
        currentRole = role;
    }

    public static void logout() {
        currentUsername = null;
        currentRole = null;
    }

    public static String getUsername() {
        return currentUsername;
    }

    public static String getRole() {
        return currentRole;
    }

    public static boolean isLoggedIn() {
        return currentUsername != null && currentUsername.trim().length() > 0;
    }
}
