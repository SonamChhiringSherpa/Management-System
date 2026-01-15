/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author sonamchhiringsherpa
 */
public class AdminDashboardHelper {
    private AdminDashboardHelper() {} // utility class

    public static void setPreviewImage(JLabel label, String imagePath, int fallbackW, int fallbackH) {
        if (imagePath == null || imagePath.trim().isEmpty()) {
            label.setIcon(null);
            label.setText("ImagePreview");
            return;
        }

        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage();

        int w = label.getWidth();
        int h = label.getHeight();

        if (w <= 0 || h <= 0) {
            w = fallbackW;
            h = fallbackH;
        }

        Image scaledImg = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(scaledImg));
        label.setText("");
    }

    public static void clearAddProductForm(
            JTextField nameField,
            JComboBox<?> typeCombo,
            JComboBox<?> statusCombo,
            JTextField qtyField,
            JTextField priceField,
            JLabel imagePreviewLabel
    ) {
        nameField.setText("");
        typeCombo.setSelectedIndex(0);
        statusCombo.setSelectedIndex(0);
        qtyField.setText("");
        priceField.setText("");

        imagePreviewLabel.setIcon(null);
        imagePreviewLabel.setText("ImagePreview");
    }

    public static void clearUpdateProductForm(
            JTextField nameField,
            JComboBox<?> typeCombo,
            JComboBox<?> statusCombo,
            JTextField qtyField,
            JTextField priceField,
            JLabel imagePreviewLabel
    ) {
        nameField.setText("");
        typeCombo.setSelectedIndex(0);
        statusCombo.setSelectedIndex(0);
        qtyField.setText("");
        priceField.setText("");

        imagePreviewLabel.setIcon(null);
        imagePreviewLabel.setText("ImagePreview");
    }

    public static void refreshOrdersTable(JTable orderTable, java.util.List<Order> orders) {
        DefaultTableModel m = (DefaultTableModel) orderTable.getModel();
        m.setRowCount(0);

        for (Order o : orders) {
            m.addRow(new Object[]{o.getOrderId(), o.getUsername(), o.getOrderDateTime(), o.getTotal()});
        }
    }
    public static void loadTableData(Model.PCComponentTableModel tableModel) {
    tableModel.setData(Model.PCComponent.getComponents());
}

}
