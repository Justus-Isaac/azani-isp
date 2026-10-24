package com.example.azaniisp;

import com.example.azaniisp.config.AppContainer;


import javax.swing.*;

public class AzaniApp {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            AppContainer appContainer = new AppContainer();

            appContainer.getMainFrame().setVisible(true);
        });
    }
}
