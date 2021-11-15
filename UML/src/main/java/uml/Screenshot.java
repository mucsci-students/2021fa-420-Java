package uml;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Screenshot {

    public static void screenshot() {
        // Creates image
        BufferedImage image = new BufferedImage(View.panel.getWidth(), View.panel.getHeight(),
                BufferedImage.TYPE_INT_RGB);
        View.panel.paint(image.getGraphics());
        Graphics g = image.getGraphics();
        Arrows.updateArrows(g);

        // JFileChooser points to user's default directory
        JFileChooser j = new JFileChooser();
        // Only allows jpg/jpeg files to show
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG File", "jpg", "jpeg");
        j.setFileFilter(filter);
        // Open the save dialog
        int response = j.showSaveDialog(null);
        // User saved image
        if (response == JFileChooser.APPROVE_OPTION) {
            File file;
            String name = j.getSelectedFile().getName();
            // Prevents new files being created when they already exist
            if (name.contains(".jpg") || name.contains(".jpeg")) {
                int i = name.lastIndexOf('.');
                name = name.substring(0, i);
            }
            file = new File(j.getSelectedFile().getParent(), name + ".jpg");

            try {
                // File does not exist and is created
                if (file.createNewFile()) {
                    if (Driver.guiUp) {
                        JOptionPane.showMessageDialog(View.frmUmlEditor, "File Created!", "File",
                                JOptionPane.PLAIN_MESSAGE);
                    } else {
                        System.out.println("File Created!");
                    }
                }
                // File exists and is overwritten
                else {
                    if (Driver.guiUp) {
                        JOptionPane.showMessageDialog(View.frmUmlEditor, "This file exists, it was overwritten!",
                                "File", JOptionPane.PLAIN_MESSAGE);
                    } else {
                        System.out.println("This file exists, it was overwritten!");
                    }
                }
                // Writes image to file
                ImageIO.write(image, "jpg", file);

            } catch (IOException e) {
                if (Driver.guiUp) {
                    JOptionPane.showMessageDialog(View.frmUmlEditor, e.getMessage(), "File Error!",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    System.out.println(e.getMessage());
                }
            }
        }
        // User cancelled save
        else {
            if (!Driver.guiUp) {
                System.out.println("File save operation was cancelled!");
            }
        }
    }
}