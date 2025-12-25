/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.swing.JOptionPane;
import Model.LoginModel;
import View.AdminDashboard;
import View.Login;
import View.UserView;

/**
 *
 * @author user
 */
public class LoginController {

    private Login View;
    private LoginModel Model;

    public LoginController(Login view) {
        this.View = view;
        this.Model = new LoginModel();
    }

    public void login() {

        String username = View.getUsername();
        String password = View.getPassword();
        String role = View.getSelectedRole();

        if (role.isEmpty()) {
            JOptionPane.showMessageDialog(View, "Please select User or Admin");
            return;
        }

        boolean isValid = false;

        if (role.equals("USER")) {
            isValid = Model.validateUser(username, password);
            if (isValid) {
                new UserView().setVisible(true);
                View.dispose();
            }
        }

        if (role.equals("ADMIN")) {
            isValid = Model.validateAdmin(username, password);
            if (isValid) {
                new AdminDashboard().setVisible(true);
                View.dispose();
            }
        }

        if (!isValid) {
            JOptionPane.showMessageDialog(View, "Invalid Login Credentials");
        }
    }
}
