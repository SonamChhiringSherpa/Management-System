/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author user
 */
public class ImagePreviewer {
    public String chooseImage(java.awt.Component parent) {
        javax.swing.JFileChooser fc = new javax.swing.JFileChooser();

        java.io.File imageDir = new java.io.File("src/Image");
        if (imageDir.exists() && imageDir.isDirectory()) {
            fc.setCurrentDirectory(imageDir);
        }

        fc.setAcceptAllFileFilterUsed(false);
        fc.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
                "Images (jpg, jpeg, png)", "jpg", "jpeg", "png"
        ));

        int result = fc.showOpenDialog(parent);
        if (result != javax.swing.JFileChooser.APPROVE_OPTION) return null;

        java.io.File f = fc.getSelectedFile();
        return (f == null) ? null : f.getAbsolutePath();
    }

    public void preview(javax.swing.JLabel label, String path, int fallbackW, int fallbackH) {
        if (label == null) return;

        if (path == null || path.trim().isEmpty()) {
            label.setIcon(null);
            return;
        }

        javax.swing.ImageIcon icon = new javax.swing.ImageIcon(path);

        int w = label.getWidth();
        int h = label.getHeight();
        if (w <= 0) w = fallbackW;
        if (h <= 0) h = fallbackH;

        java.awt.Image scaled = icon.getImage().getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
        label.setIcon(new javax.swing.ImageIcon(scaled)); 
    }
}
