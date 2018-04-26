package timetracker;

import javax.swing.*;

/**
 * Creates pop-ups.
 * @author Megan
 */
public class notifications {
    public static void notifs(String message, String titleBar) {
        JOptionPane.showMessageDialog(null, message, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    public static void error(String message, String titleBar) {
        JOptionPane.showMessageDialog(null, message, titleBar, JOptionPane.ERROR_MESSAGE);           
    }  
}
