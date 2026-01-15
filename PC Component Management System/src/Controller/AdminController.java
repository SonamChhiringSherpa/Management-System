/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Inventory;
import Model.PCComponent;
import java.util.LinkedList;

/**
 *
 * @author user
 */
public class AdminController {

    public LinkedList<PCComponent> getInventory() {
        return Inventory.getAll(); // shared inventory (same list user sees)
    }
}
