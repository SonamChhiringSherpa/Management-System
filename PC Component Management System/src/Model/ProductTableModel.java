/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.awt.Image;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author user
 */
public class ProductTableModel extends AbstractTableModel{

    private final String[] cols = {"Name", "Component Type", "Status", "Quantity", "Price", "Image"};
    private LinkedList<PCComponent> data = new LinkedList<PCComponent>();

    private int thumbW;
    private int thumbH;

    public ProductTableModel(int thumbW, int thumbH) {
        this.thumbW = thumbW;
        this.thumbH = thumbH;
    }

    public void setData(LinkedList<PCComponent> list) {
        if (list == null) {
            data = new LinkedList<PCComponent>();
        } else {
            data = list;
        }
        fireTableDataChanged(); // tells JTable to refresh [web:50]
    }

    public PCComponent getAt(int row) {
        return data.get(row);
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 3) {
            return Integer.class;
        }
        if (columnIndex == 4) {
            return Double.class;
        }
        if (columnIndex == 5) {
            return Icon.class; // Image column [web:52][web:51]
        }
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PCComponent pc = data.get(rowIndex);

        if (columnIndex == 0) {
            return pc.getName();
        }
        if (columnIndex == 1) {
            return pc.getType();
        }
        if (columnIndex == 2) {
            return pc.getStatus();
        }
        if (columnIndex == 3) {
            return pc.getQuantity();
        }
        if (columnIndex == 4) {
            return pc.getPrice();
        }
        if (columnIndex == 5) {
            return makeThumbnail(pc.getImagePath());
        }
        return null;
    }

    private ImageIcon makeThumbnail(String path) {
         if (path == null || path.trim().isEmpty()) return null;

    ImageIcon icon = null;

    // If it starts with "/", treat as classpath resource (src folder)
    if (path.startsWith("/")) {
        java.net.URL url = getClass().getResource(path);
        if (url != null) {
            icon = new ImageIcon(url);
        } else {
            // resource not found -> return null (no image)
            return null;
        }
    } else {
        // Otherwise treat as file system path (e.g., "images/cpu1.png")
        icon = new ImageIcon(path);
    }

    Image img = icon.getImage();
    Image scaled = img.getScaledInstance(thumbW, thumbH, Image.SCALE_SMOOTH);
    return new ImageIcon(scaled);
    }
}
