/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author user
 */
public class OrderDetailTableModel extends AbstractTableModel {
    private final String[] cols = {"Image", "Name", "Quantity", "Price", "Total"};
    private OrderItemList items;
    private int thumbW;
    private int thumbH;

    public OrderDetailTableModel(int thumbW, int thumbH) {
        this.thumbW = thumbW;
        this.thumbH = thumbH;
        this.items = null;
    }

    public void setItems(OrderItemList items) {
        this.items = items;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        if (items == null) return 0;
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public String getColumnName(int col) {
        return cols[col];
    }

    @Override
    public Class<?> getColumnClass(int col) {
        if (col == 0) return Icon.class;
        if (col == 2) return Integer.class;
        if (col == 3) return Double.class;
        if (col == 4) return Double.class;
        return String.class;
    }

    @Override
    public Object getValueAt(int row, int col) {
        if (items == null) return null;

        OrderItem it = items.getAt(row);
        if (it == null) return null;

        PCComponent p = it.getProduct();

        if (col == 0) return makeThumbnail(p.getImagePath());
        if (col == 1) return p.getName();
        if (col == 2) return it.getQty();
        if (col == 3) return p.getPrice();
        if (col == 4) return it.getTotal();
        return null;
    }

    private ImageIcon makeThumbnail(String path) {
        if (path == null || path.trim().isEmpty()) return null;

        ImageIcon icon = null;

        // Works with your "/Image/xxx.jpg" paths
        if (path.startsWith("/")) {
            java.net.URL url = getClass().getResource(path);
            if (url == null) return null;
            icon = new ImageIcon(url);
        } else {
            icon = new ImageIcon(path);
        }

        Image scaled = icon.getImage().getScaledInstance(thumbW, thumbH, Image.SCALE_SMOOTH);
        return new ImageIcon(scaled);
    }
}
