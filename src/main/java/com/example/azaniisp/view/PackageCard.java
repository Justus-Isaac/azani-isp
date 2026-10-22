package com.example.azaniisp.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PackageCard extends JPanel {

    public PackageCard(String tierName, Color headerColor, String speedText, String priceKsh, String[] features) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Soft outer card border with rounded corners effect using empty padding
        setBorder(BorderFactory.createLineBorder(new Color(226, 232, 240), 1));

        // --- 1. Colored Header Banner Panel ---
        JPanel headerPanel = new JPanel(new GridBagLayout());
        headerPanel.setBackground(headerColor);
        headerPanel.setPreferredSize(new Dimension(0, 50));

        JLabel nameLabel = new JLabel(tierName.toUpperCase());
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        nameLabel.setForeground(Color.WHITE);
        headerPanel.add(nameLabel);
        add(headerPanel, BorderLayout.NORTH);

        // --- 2. Central Content Body Area ---
        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
        bodyPanel.setOpaque(false);
        bodyPanel.setBorder(new EmptyBorder(25, 20, 20, 20));

        // Bandwidth Speed Value
        JLabel speedLabel = new JLabel(speedText);
        speedLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        speedLabel.setForeground(new Color(30, 41, 59));
        speedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bodyPanel.add(speedLabel);

        bodyPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Feature Bullet Points list (Using HTML checkmarks)
        for (String feature : features) {
            JLabel featLabel = new JLabel("<html><font color='#22C55E'>✓</font> &nbsp;" + feature + "</html>");
            featLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            featLabel.setForeground(new Color(100, 116, 139));
            featLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            bodyPanel.add(featLabel);
            bodyPanel.add(Box.createRigidArea(new Dimension(0, 8)));
        }

        bodyPanel.add(Box.createVerticalGlue());

        // Price Text Tag
        JLabel priceLabel = new JLabel(priceKsh);
        priceLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        priceLabel.setForeground(new Color(15, 23, 42));
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bodyPanel.add(priceLabel);

        JLabel cycleLabel = new JLabel("Valid for 30 days");
        cycleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        cycleLabel.setForeground(new Color(148, 163, 184));
        cycleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bodyPanel.add(cycleLabel);

        bodyPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // --- 3. Bottom CTA Action Button ---
        JButton getStartedBtn = createGetStartedBtn();

        bodyPanel.add(getStartedBtn);

        add(bodyPanel, BorderLayout.CENTER);
    }

    private static JButton createGetStartedBtn() {
        JButton getStartedBtn = new JButton("Get Connected");
        getStartedBtn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        getStartedBtn.setForeground(Color.WHITE);
        getStartedBtn.setBackground(new Color(34, 197, 94)); // Clean vibrant green button
        getStartedBtn.setFocusPainted(false);
        getStartedBtn.setBorderPainted(false);
        getStartedBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        getStartedBtn.setMaximumSize(new Dimension(160, 36));
        getStartedBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return getStartedBtn;
    }
}
