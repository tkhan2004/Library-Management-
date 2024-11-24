/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ValidateLogin {
    public static boolean validateLogin(String username, String password) {
        if (username == null || username.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your name");
            return false;
        }
        if (password == null || password.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your password");
            return false;
        }
        return true;
    }
}
