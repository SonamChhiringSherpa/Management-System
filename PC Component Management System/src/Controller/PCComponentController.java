/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.PCComponent;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class PCComponentController {

    public boolean addComponent(String name, String type, String status, String quantityText, String priceText, String imagePath) {
        if (name.isEmpty() || status.isEmpty() || quantityText.isEmpty() || priceText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        int quantity;
        double price;
        try {
            quantity = Integer.parseInt(quantityText);
            price = Double.parseDouble(priceText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Quantity and Price must be valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        PCComponent pc = new PCComponent(name, type, status, quantity, price, imagePath);
        PCComponent.addComponent(pc);
        return true;
    }

    public boolean deleteComponent(PCComponent component) {
        if (component == null) {
            JOptionPane.showMessageDialog(null, "Please select a component to delete.", "Selection Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        PCComponent.removeComponent(component);
        return true;
    }

    public void updateComponent(PCComponent pc, String name, String type, String status, int quantity, double price) {
        if (name.isEmpty() || status.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Name and Status are required.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        pc.setName(name);
        pc.setType(type);
        pc.setStatus(status);
        pc.setQuantity(quantity);
        pc.setPrice(price);
    }

    // Sort by name (ascending)
    public LinkedList<PCComponent> sortByName() {
        LinkedList<PCComponent> sorted = new LinkedList<>(PCComponent.getComponents());
        if (!sorted.isEmpty()) {
            sorted.sort(Comparator.comparing(PCComponent::getName));
        }
        return sorted;
    }

    // Sort by price (ascending)
    public LinkedList<PCComponent> sortByPrice() {
        LinkedList<PCComponent> sorted = new LinkedList<>(PCComponent.getComponents());
        if (!sorted.isEmpty()) {
            sorted.sort(Comparator.comparing(PCComponent::getPrice));
        }
        return sorted;
    }

    // Search by name (case-insensitive and space-normalized)
    public LinkedList<PCComponent> searchByName(String searchTerm) {
        if (searchTerm.isEmpty()) {
            return getAllComponents();
        }

        String normalizedSearchTerm = searchTerm.trim().replaceAll("\\s+", " ").toLowerCase();
        LinkedList<PCComponent> results = new LinkedList<>();

        for (PCComponent pc : PCComponent.getComponents()) {
            String normalizedName = pc.getName().trim().replaceAll("\\s+", " ").toLowerCase();
            if (normalizedName.contains(normalizedSearchTerm)) {
                results.add(pc);
            }
        }

        return results;
    }

    // Filter by type
    public LinkedList<PCComponent> filterByType(String type) {
        if (type == null || type.isEmpty() || type.equals("Select Type")) {
            return getAllComponents();
        }

        LinkedList<PCComponent> filtered = new LinkedList<>();

        for (PCComponent pc : PCComponent.getComponents()) {
            if (pc.getType().equalsIgnoreCase(type)) {
                filtered.add(pc);
            }
        }

        return filtered;
    }

    // Get all components
    public LinkedList<PCComponent> getAllComponents() {
        return PCComponent.getComponents();
    }
}
