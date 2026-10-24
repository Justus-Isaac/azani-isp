package com.example.azaniisp.view;

import com.example.azaniisp.config.AppContainer;
import com.example.azaniisp.ui.style.App.AppColors;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements SidebarPanel.NavigationListener {

    private final JPanel contentPanel;
    private final CardLayout cardLayout;
    private final AppContainer appContainer;

    public MainFrame(AppContainer appContainer) {

        this.appContainer = appContainer;


        setTitle("Azani ISP INFORMATION SYSTEM");
        setSize(1100, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        SidebarPanel sidebarPanel = new SidebarPanel(this);
        add(sidebarPanel, BorderLayout.WEST);

        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        contentPanel.setBackground(AppColors.BG_CONTENT);

        contentPanel.add(appContainer.getHomePanel(), "HOME");
        contentPanel.add(new JLabel("Welcome to Dashboard", SwingConstants.CENTER), "DASHBOARD");
        contentPanel.add(new JLabel("Institution Management Screen", SwingConstants.CENTER), "INSTITUTIONS");
        contentPanel.add(new JLabel("Subscriptions Screen", SwingConstants.CENTER), "SUBSCRIPTIONS");
        contentPanel.add(new JLabel("Billing Screen", SwingConstants.CENTER), "BILLING");

        add(contentPanel, BorderLayout.CENTER);

        cardLayout.show(contentPanel, "HOME");


        appContainer.getHomeController().loadHomePage();
    }

    private JPanel createPlaceholderScreen(String screenTitle) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(AppColors.BG_CONTENT);

        JLabel label = new JLabel(screenTitle);
        label.setFont(new Font("Segoe UI", Font.BOLD, 22));
        label.setForeground(new Color(51, 65, 85)); // Slate deep gray text for bright readability

        panel.add(label);
        return panel;
    }

    @Override
    public void onNavigate(String viewName) {
        if (viewName.equals("LOGOUT")) {

            System.exit(0);
        } else {
            cardLayout.show(contentPanel, viewName);
        }
    }
}
