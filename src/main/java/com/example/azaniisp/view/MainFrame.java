package com.example.azaniisp.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Azani ISP INFORMATION SYSTEM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        add(
                new JLabel(
                        "Azani ISP Dashboard",
                        SwingConstants.CENTER
                ),
                BorderLayout.CENTER
        );
    }
}
