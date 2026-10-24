package com.example.azaniisp.service;

import com.example.azaniisp.dao.BandwidthTierDao;
import com.example.azaniisp.dao.LanNodeBandDao;
import com.example.azaniisp.dto.HomePageDataDto;
import com.example.azaniisp.model.BandwidthTier;
import com.example.azaniisp.model.LanNodeBand;

import java.util.List;

public class HomePageService {
    private final LanNodeBandDao lanNodeBandDao;
    private final BandwidthTierDao bandwidthTierDao;

    public HomePageService(LanNodeBandDao lanNodeBandDao, BandwidthTierDao bandwidthTierDao) {
        this.lanNodeBandDao = lanNodeBandDao;
        this.bandwidthTierDao = bandwidthTierDao;
    }

    public HomePageDataDto getHomePageData() {
        List<BandwidthTier> bandwidthTiers = bandwidthTierDao.findAll();
        List<LanNodeBand> lanNodeBands = lanNodeBandDao.findAll();

        System.out.println(bandwidthTiers);
        System.out.println(lanNodeBands);
        return new HomePageDataDto(bandwidthTiers, lanNodeBands);
    }
}
