package com.example.azaniisp.view;

import com.example.azaniisp.model.BandwidthTier;
import com.example.azaniisp.model.LanNodeBand;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import java.util.List;

public class HomePanel extends JPanel {
    private final JPanel packagesContainer;
    private final JPanel lanContainer;
    private final Color[] bannerColors = {
            new Color(180, 100, 60),  // Bronze
            new Color(148, 163, 184), // Silver
            new Color(234, 179, 8),   // Gold
            new Color(219, 39, 119),  // Diamond
            new Color(147, 51, 234)   // Platinum
    };

    public HomePanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(230, 233, 236));

        // Central Vertical Scroll Workspace Panel
        JPanel mainContentWorkspace = new JPanel();
        mainContentWorkspace.setLayout(new BoxLayout(mainContentWorkspace, BoxLayout.Y_AXIS));
        mainContentWorkspace.setOpaque(false);
        mainContentWorkspace.setBorder(new EmptyBorder(25, 30, 25, 30));

        // --- 1. Dynamic Bandwidth Tiers Sub-Section ---
        JLabel section1Header = new JLabel("Available High-Speed Internet Tiers");
        section1Header.setFont(new Font("Segoe UI", Font.BOLD, 18));
        section1Header.setForeground(new Color(15, 23, 42));
        mainContentWorkspace.add(section1Header);
        mainContentWorkspace.add(Box.createRigidArea(new Dimension(0, 12)));

        packagesContainer = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        packagesContainer.setOpaque(false);
        mainContentWorkspace.add(packagesContainer);

        mainContentWorkspace.add(Box.createRigidArea(new Dimension(0, 35)));

        // --- 2. Dynamic LAN Node Infrastructure Bands Sub-Section ---
        JLabel section2Header = new JLabel("Local Area Network (LAN) Nodes Pricing Scale");
        section2Header.setFont(new Font("Segoe UI", Font.BOLD, 18));
        section2Header.setForeground(new Color(15, 23, 42));
        mainContentWorkspace.add(section2Header);
        mainContentWorkspace.add(Box.createRigidArea(new Dimension(0, 12)));

        lanContainer = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        lanContainer.setOpaque(false);
        mainContentWorkspace.add(lanContainer);

        // Standard Scroll wrapper allocation
        JScrollPane verticalScroll = new JScrollPane(mainContentWorkspace);
        verticalScroll.setBorder(null);
        verticalScroll.setOpaque(false);
        verticalScroll.getViewport().setOpaque(false);

        add(verticalScroll, BorderLayout.CENTER);
    }

    /**
     * Clears current items and binds actual persistent database rows to UI widgets.
     */
    public void updateContent(List<BandwidthTier> bandwidths, List<LanNodeBand> lanBands) {
        packagesContainer.removeAll();
        lanContainer.removeAll();

        // Bind Internet Bundles
        for (int i = 0; i < bandwidths.size(); i++) {
            Color calculatedColor = bannerColors[i % bannerColors.length];
            PackageCard card = new PackageCard(bandwidths.get(i), calculatedColor);
            card.setPreferredSize(new Dimension(175, 180));
            packagesContainer.add(card);
        }

        // Bind Local Node infrastructure scales
        for (LanNodeBand band : lanBands) {
            lanContainer.add(new LanBandCard(band));
        }

        // Inform Swing layout subroutines to recalculate visual layout boundaries
        revalidate();
        repaint();
    }
}
