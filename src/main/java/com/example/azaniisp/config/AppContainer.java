package com.example.azaniisp.config;

import com.example.azaniisp.controller.HomeController;
import com.example.azaniisp.dao.BandwidthTierDao;
import com.example.azaniisp.dao.BandwidthTierDaoImpl;
import com.example.azaniisp.dao.LanNodeBandDao;
import com.example.azaniisp.dao.LanNodeBandDaoImp;
import com.example.azaniisp.service.HomePageService;
import com.example.azaniisp.view.HomePanel;
import com.example.azaniisp.view.MainFrame;
import lombok.Getter;


@Getter
public class AppContainer {

    private final MainFrame mainFrame;
    private final HomePanel homePanel;

    private final HomeController homeController;

    public AppContainer() {


        //Build the data
        BandwidthTierDao bandwidthTierDao = new BandwidthTierDaoImpl();
        LanNodeBandDao lanNodeBandDao = new LanNodeBandDaoImp();

        //Build the services
        HomePageService homePageService = new HomePageService(lanNodeBandDao, bandwidthTierDao);

        //Build the controllers
        this.homeController = new HomeController(homePageService);


        //Build the windows and set them in their specific controllers
        this.homePanel = new HomePanel();
        this.homeController.setHomePanel(homePanel);

        this.mainFrame = new MainFrame(this);
    }


}
