package com.example.azaniisp;

import com.example.azaniisp.view.MainFrame;

import javax.swing.*;

public class AzaniApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
