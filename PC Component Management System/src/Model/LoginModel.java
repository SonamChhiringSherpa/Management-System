/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author user
 */
public class LoginModel {
    
    
    private final String adminUsername = "admin";
    private final String adminPassword = "admin123";

    private final String userUsername = "user";
    private final String userPassword = "user123";

    public boolean validateAdmin(String username, String password) {
        return username.equals(adminUsername) && password.equals(adminPassword);
    }

    public boolean validateUser(String username, String password) {
        return username.equals(userUsername) && password.equals(userPassword);
    }
}
