package com.example.azaniisp.controller;

import com.example.azaniisp.dto.HomePageDataDto;
import com.example.azaniisp.service.HomePageService;
import com.example.azaniisp.view.HomePanel;
import lombok.Setter;

import javax.swing.*;


public class HomeController {

    private final HomePageService homePageService;

    @Setter
    private HomePanel homePanel;

    public HomeController(HomePageService homePageService) {
        this.homePageService = homePageService;
    }

    public void loadHomePage() {
        try {
            HomePageDataDto data = homePageService.getHomePageData();

            SwingUtilities.invokeLater(() -> {
                homePanel.updateContent(data.bandwidthTiers(), data.lanNodeBands());
            });
        } catch (Exception e) {
            e.printStackTrace();
            SwingUtilities.invokeLater(() -> {
                JOptionPane.showMessageDialog(homePanel,
                        "Error connecting to service layer: " + e.getMessage(),
                        "Database Error", JOptionPane.ERROR_MESSAGE);
            });

        }

    }
}
