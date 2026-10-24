package com.example.azaniisp.view;

import com.example.azaniisp.model.LanNodeBand;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LanBandCard extends JPanel {
    public LanBandCard(LanNodeBand band) {
        setLayout(new BorderLayout());
        setBackground(new Color(241, 245, 249)); // Distinct light slate background tint
        setBorder(BorderFactory.createLineBorder(new Color(203, 213, 225), 1));
        setPreferredSize(new Dimension(180, 110));

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setOpaque(false);
        contentPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        JLabel rangeLabel = new JLabel(band.getMinNodes() + " - " + band.getMaxNodes() + " Nodes");
        rangeLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        rangeLabel.setForeground(new Color(51, 65, 85));
        rangeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel typeLabel = new JLabel("LAN Infrastructure Setup");
        typeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        typeLabel.setForeground(new Color(148, 163, 184));
        typeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel costLabel = new JLabel("KSh " + String.format("%,.0f", band.getCost()));
        costLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        costLabel.setForeground(new Color(41, 128, 185)); // Professional blue highlight cost
        costLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        contentPanel.add(rangeLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 4)));
        contentPanel.add(typeLabel);
        contentPanel.add(Box.createVerticalGlue());
        contentPanel.add(costLabel);

        add(contentPanel, BorderLayout.CENTER);
    }
}
