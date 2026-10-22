package com.example.azaniisp.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HomePanel extends JPanel {
    public HomePanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(248, 250, 252)); // Ultra light blue-gray background

        // --- Header Banner Section ---
        JPanel headerPanel = new JPanel();
        headerPanel.setOpaque(false);
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBorder(new EmptyBorder(30, 20, 10, 20));

        JLabel titleLabel = new JLabel("Explore Internet Packages");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(new Color(15, 23, 42));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitleLabel = new JLabel("High-speed reliable fiber links tailored for learning institutions and colleges.");
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitleLabel.setForeground(new Color(100, 116, 139));
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        headerPanel.add(titleLabel);
        headerPanel.add(Box.createRigidArea(new Dimension(0, 6)));
        headerPanel.add(subtitleLabel);
        add(headerPanel, BorderLayout.NORTH);

        // --- Scrollable Grid Layout Container for Reusable Cards ---
        // Changed to a standard 5-column setup to comfortably showcase the official Azani Tiers
        JPanel cardsGrid = new JPanel(new GridLayout(1, 5, 16, 0));
        cardsGrid.setOpaque(false);
        cardsGrid.setBorder(new EmptyBorder(20, 25, 30, 25));

        // Package Data definitions matched with Assignment Specification Pricing Models
        cardsGrid.add(new PackageCard(
                "Bronze", new Color(180, 100, 60), "4 MBPS", "KSh 1,200",
                new String[]{"Basic Browsing", "Junior Schools", "LAN Compatible"}
        ));

        cardsGrid.add(new PackageCard(
                "Silver", new Color(148, 163, 184), "10 MBPS", "KSh 2,000",
                new String[]{"HD Video Streaming", "Primary Schools", "Assorted Support"}
        ));

        cardsGrid.add(new PackageCard(
                "Gold", new Color(234, 179, 8), "20 MBPS", "KSh 3,500",
                new String[]{"Multiple Devices", "Senior Schools", "10% Upgrade Deal"}
        ));

        cardsGrid.add(new PackageCard(
                "Diamond", new Color(219, 39, 119), "25 MBPS", "KSh 4,000",
                new String[]{"High Capacity Line", "Large Campus Units", "24/7 Monitoring"}
        ));

        cardsGrid.add(new PackageCard(
                "Platinum", new Color(147, 51, 234), "50 MBPS", "KSh 7,000",
                new String[]{"Uncapped Bandwidth", "Colleges & Admin", "SLA Guarantee"}
        ));

        // Embed inside a nice scrollpane container so it scales nicely across small screen windows
        JScrollPane scrollPane = new JScrollPane(cardsGrid);
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        add(scrollPane, BorderLayout.CENTER);
    }
}
