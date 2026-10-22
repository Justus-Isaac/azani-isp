package com.example.azaniisp.view;

import com.example.azaniisp.ui.style.App.AppColors;
import com.example.azaniisp.ui.style.App.AppFonts;
import com.example.azaniisp.ui.style.App.AppStyles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SidebarPanel extends JPanel {

    public interface NavigationListener {
        void onNavigate(String viewName);
    }


    private final NavigationListener navigationListener;

    public SidebarPanel(NavigationListener navigationListener) {
        this.navigationListener = navigationListener;


        setBackground(AppColors.BG_SIDEBAR);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(230, 0));
        setBorder(BorderFactory.createEmptyBorder(30, 15, 30, 15));

        JLabel titleLabel = new JLabel("Azani ISP");
        titleLabel.setForeground(AppColors.TEXT_LIGHT);
        titleLabel.setFont(AppFonts.FONT_TITLE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(titleLabel);

        add(Box.createRigidArea(new Dimension(0, 35)));

        addNavigationItem("Home", "HOME");
        addNavigationItem("Dashboard", "DASHBOARD");
        addNavigationItem("Institutions", "INSTITUTIONS");
        addNavigationItem("Subscriptions", "SUBSCRIPTIONS");
        addNavigationItem("Billing", "BILLING");

        add(Box.createVerticalGlue());

        addNavigationItem("LOGOUT", "LOGOUT");
    }


    private void addNavigationItem(String text, String command) {
        JButton button = new JButton(text);
        AppStyles.styleSidebarButtons(button);

        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        if ("LOGOUT".equals(command)) {
            button.setForeground(new Color(239, 68, 68));
            button.setFont(new Font("Segou UI", Font.BOLD, 14));
        }

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(navigationListener != null) {
                    navigationListener.onNavigate(command);
                }
            }
        });

        add(button);
        add(Box.createRigidArea(new Dimension(0, 12)));

        if (!"LOGOUT".equals(command)) {
            add(Box.createRigidArea(new Dimension(0, 12)));
        }
    }
}
