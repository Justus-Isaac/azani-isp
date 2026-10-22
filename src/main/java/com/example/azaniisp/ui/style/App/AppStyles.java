package com.example.azaniisp.ui.style.App;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public final class AppStyles {

    public static void styleSidebarButtons(JButton button) {
        button.setFont(AppFonts.FONT_NAV);
        button.setForeground(AppColors.TEXT_LIGHT);
        button.setBackground(AppColors.BG_SIDEBAR);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(200, 40));

        button.setBorder(new EmptyBorder(10, 15, 10, 15));

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(36, 49, 77));
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(MouseEvent e) {
                button.setBackground(AppColors.BG_SIDEBAR);
            }
        });
    }

    private AppStyles() {}
}
