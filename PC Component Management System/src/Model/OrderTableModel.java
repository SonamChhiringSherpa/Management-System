/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author user
 */
public class OrderTableModel extends AbstractTableModel {
     private final String[] cols = {"OrderId", "Date", "Location", "Status", "Total Amount"};

    @Override
    public int getRowCount() {
        return OrderArrayQueue.size();
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
        if (col == 0) return Integer.class;
        if (col == 4) return Double.class;
        return String.class;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Order o = OrderArrayQueue.getAt(row);
        if (o == null) return null;

        if (col == 0) return o.getOrderId();
        if (col == 1) return o.getDate();
        if (col == 2) return o.getLocation();
        if (col == 3) return o.getStatus();
        if (col == 4) return o.getTotalAmount();
        return null;
    }

    public void refresh() {
        fireTableDataChanged(); // repaint table when queue changes [web:237]
    }
}
