/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.PCComponent;

/**
 *
 * @author user
 */
public class PCComponentController {

    public boolean addComponent(
            String name,
            String type,
            String status,
            String quantityText,
            String priceText,
            String imagePath
    ) {

        // Validation
        if (name.isEmpty() || status.isEmpty()
                || quantityText.isEmpty() || priceText.isEmpty()) {
            return false;
        }

        int quantity;
        double price;

        try {
            quantity = Integer.parseInt(quantityText);
            price = Double.parseDouble(priceText);
        } catch (NumberFormatException e) {
            return false;
        }

        // Create model object
        PCComponent pc = new PCComponent(
                name,
                type,
                status,
                quantity,
                price,
                imagePath
        );

        // Add to shared LinkedList (Model)
        PCComponent.addComponent(pc);

        return true;
    }

    public boolean deleteComponent(PCComponent component) {

        if (component == null) {
            return false;
        }

        PCComponent.removeComponent(component);
        return true;
    }

    public void updateComponent(PCComponent pc, String name, String type, String status, int quantity, double price) {
        pc.setName(name);
        pc.setType(type);
        pc.setStatus(status);
        pc.setQuantity(quantity);
        pc.setPrice(price);
        
    }
}
