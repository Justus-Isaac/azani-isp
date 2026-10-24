package com.example.azaniisp.view;

import com.example.azaniisp.model.BandwidthTier;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PackageCard extends JPanel {

    public PackageCard(BandwidthTier tier, Color headerColor) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(new Color(226, 232, 240), 1));

        // Header Section
        JPanel headerPanel = new JPanel(new GridBagLayout());
        headerPanel.setBackground(headerColor);
        headerPanel.setPreferredSize(new Dimension(0, 45));

        JLabel nameLabel = new JLabel("FIBER SERVICE");
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        nameLabel.setForeground(Color.WHITE);
        headerPanel.add(nameLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Body Content
        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
        bodyPanel.setOpaque(false);
        bodyPanel.setBorder(new EmptyBorder(20, 15, 20, 15));

        JLabel speedLabel = new JLabel(tier.getBandwidthMbps() + " MBPS");
        speedLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        speedLabel.setForeground(new Color(30, 41, 59));
        speedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bodyPanel.add(speedLabel);

        bodyPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        JLabel features = new JLabel("<html><center>✓ High Availability<br>✓ Learning Optimized</center></html>");
        features.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        features.setForeground(new Color(100, 116, 139));
        features.setAlignmentX(Component.CENTER_ALIGNMENT);
        bodyPanel.add(features);

        bodyPanel.add(Box.createVerticalGlue());

        JLabel priceLabel = new JLabel("KSh " + String.format("%,.0f", tier.getMonthlyCost()));
        priceLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        priceLabel.setForeground(new Color(15, 23, 42));
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bodyPanel.add(priceLabel);

        JLabel cycleLabel = new JLabel("per month");
        cycleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        cycleLabel.setForeground(new Color(148, 163, 184));
        cycleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bodyPanel.add(cycleLabel);

        add(bodyPanel, BorderLayout.CENTER);
    }
}
