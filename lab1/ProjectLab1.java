
package project.lab1;


import javax.swing.*;

public class ProjectLab1 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainMenu().setVisible(true);
        });
    }
}
