/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.LinkedList;

/**
 *
 * @author user
 */
public class PCComponent {
    
    private static LinkedList<PCComponent> components = new LinkedList<>(); 
    
    public static void initDummyData() {
    components.add(new PCComponent("Ryzen 5 5600X", "CPU", "Available",2 ,250.0, "images/cpu1.png"));
    components.add(new PCComponent("RTX 3060", "GPU", "Available",3, 400.0, "images/gpu1.png"));
    components.add(new PCComponent("B550M", "Motherboard", "Out of Stock",4, 150.0, "images/mb1.png"));
    components.add(new PCComponent("16GB DDR4", "RAM", "Available",7, 70.0, "images/ram1.png"));
    components.add(new PCComponent("650W PSU", "PSU", "Available",10, 90.0, "images/psu1.png"));
}
    
    public static LinkedList<PCComponent> getComponents() {
        return components;
    }

    public static void addComponent(PCComponent component) {
        components.add(component);
    }

    public static void removeComponent(PCComponent component) {
        components.remove(component);
    }
    private String name;
    private String type;
    private String status;
    private int quantity;
    private double price;
    private String imagePath;   // path to image file

    public PCComponent(String name, String type, String status,int quantity, double price, String imagePath) {
        this.name = name;
        this.type = type;
        this.status = status;
        this.quantity = quantity;
        this.price = price;
        this.imagePath = imagePath;
    }

    public String getName() { return name; }
    public String getType() { return type; }
    public String getStatus() { return status; }
    public int getQuantity(){return quantity;}
    public double getPrice() { return price; }
    public String getImagePath() { return imagePath; }

    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }
    public void setStatus(String status) { this.status = status; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }
}

