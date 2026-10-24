package com.example.azaniisp.dao;

import com.example.azaniisp.db.Database;
import com.example.azaniisp.exception.DataAccessException;
import com.example.azaniisp.model.LanNodeBand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.azaniisp.utils.SqlQueries.*;

public class LanNodeBandDaoImp implements LanNodeBandDao {

    @Override
    public List<LanNodeBand> findAll() {
        List<LanNodeBand> bands = new ArrayList<>();
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(LAN_NODE_BANDS_SELECT_ALL);
             ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) bands.add(mapRow(rs));
            return bands;
        } catch (SQLException e) {
            throw new DataAccessException("Could not find lan_node bands", e);
        }
    }

    @Override
    public Optional<LanNodeBand> findById(int Id) {
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(LAN_NODE_BANDS_SELECT_BY_ID)
        ) {
            ps.setLong(1, Id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? Optional.of(mapRow(rs)) : Optional.empty();
            }
        } catch (SQLException e) {
            throw new DataAccessException("Could not find lan_node bands", e);
        }
    }

    private LanNodeBand mapRow(ResultSet rs) throws SQLException {
        return new LanNodeBand(
               rs.getInt("band_id"),
                rs.getInt("min_nodes"),
                rs.getInt("max_nodes"),
                rs.getBigDecimal("cost")
        );
    }
}
