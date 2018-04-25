/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetracker;

import javax.swing.JOptionPane;

/**
 * Creates popups.
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
