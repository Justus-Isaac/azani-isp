package com.example.azaniisp.dao;

import com.example.azaniisp.db.Database;
import com.example.azaniisp.exception.DataAccessException;
import com.example.azaniisp.model.BandwidthTier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.azaniisp.utils.SqlQueries.BANDWIDTH_TIERS_SELECT_ALL;
import static com.example.azaniisp.utils.SqlQueries.BANDWIDTH_TIERS_SELECT_BY_ID;

public class BandwidthTierDaoImpl implements BandwidthTierDao {

    @Override
    public List<BandwidthTier> findAll() {
        List<BandwidthTier> tiers = new ArrayList<>();
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(BANDWIDTH_TIERS_SELECT_ALL);
             ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) tiers.add(mapRow(rs));
            return tiers;
        } catch (SQLException e) {
            throw new DataAccessException("Could not find bandwidth tiers", e);
        }
    }

    @Override
    public Optional<BandwidthTier> findById(int id) {
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(BANDWIDTH_TIERS_SELECT_BY_ID)
        ) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? Optional.of(mapRow(rs)) : Optional.empty();
            }
        } catch (SQLException e) {
            throw new DataAccessException("Could not find bandwidth tier", e);
        }
    }

    private BandwidthTier mapRow (ResultSet rs) throws SQLException {
        return new BandwidthTier(
                rs.getInt("tier_id"),
                rs.getInt("bandwidth_mbps"),
                rs.getBigDecimal("monthly_cost")
        );
    }
}
