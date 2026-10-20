package com.example.azaniisp.dao;

import com.example.azaniisp.db.Database;
import com.example.azaniisp.exception.DataAccessException;
import com.example.azaniisp.model.InstitutionEntity;
import com.example.azaniisp.model.InstitutionStatus;
import com.example.azaniisp.model.InstitutionType;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.azaniisp.utils.SqlQueries.*;

public class InstitutionDaoImpl implements InstitutionDao {

    @Override
    public InstitutionEntity save(InstitutionEntity institution) {
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSTITUTIONS_INSERT, Statement.RETURN_GENERATED_KEYS)
        ) {
            ps.setString(1, institution.getRegistrationNo());
            ps.setString(2, institution.getName());
            ps.setString(3, institution.getInstitutionType().name());
            ps.setString(4, institution.getContactPhone());
            ps.setString(5, institution.getEmail());
            ps.setString(6, institution.getLocation());
            ps.setString(7, institution.getPhysicalAddress());
            ps.setDate(8, Date.valueOf(institution.getRegistrationDate()));
            ps.setString(9, institution.getStatus().name());
            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) institution.setId(keys.getInt(1));
            }
            return institution;
        } catch (SQLException e) {
           throw new DataAccessException("Could not save institution", e);
        }
    }

    @Override
    public void update(InstitutionEntity institution) {
        try(Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(INSTITUTION_UPDATE)
        ) {
            ps.setString(1, institution.getRegistrationNo());
            ps.setString(2, institution.getName());
            ps.setString(3, institution.getInstitutionType().name());
            ps.setString(4, institution.getContactPhone());
            ps.setString(5, institution.getEmail());
            ps.setString(6, institution.getLocation());
            ps.setString(7, institution.getPhysicalAddress());
            ps.setDate(8, Date.valueOf(institution.getRegistrationDate()));
            ps.setString(9, institution.getStatus().name());
            ps.setInt(10, institution.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DataAccessException("Could not update institution", e);
        }
    }

    @Override
    public Optional<InstitutionEntity> findById(Long id) {
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSTITUTION_SELECT_BY_ID)
        ) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? Optional.of(mapRow(rs)) : Optional.empty();
            }
        } catch (SQLException e) {
            throw new DataAccessException("Could not find institution with id " + id, e);
        }
    }

    @Override
    public Optional<InstitutionEntity> findByRegistrationNo(String registrationNo) {
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSTITUTION_SELECT_BY_REGISTRATION_NO)
        ) {
            ps.setString(1, registrationNo);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? Optional.of(mapRow(rs)) : Optional.empty();
            }
        } catch (SQLException e) {
            throw new DataAccessException("Could not find institution with registration no " + registrationNo, e);
        }
    }

    @Override
    public List<InstitutionEntity> findAll() {
        List<InstitutionEntity> results = new ArrayList<>();
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSTITUTION_SELECT_ALL);
             ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) results.add(mapRow(rs));
            return results;
        } catch (SQLException e) {
            throw new DataAccessException("Could not lists institutions", e);
        }
    }

    private InstitutionEntity mapRow(ResultSet rs) throws SQLException {
        return new InstitutionEntity(
                rs.getString("registration_no"),
                rs.getString("name"),
                InstitutionType.valueOf(rs.getString("institution_type")),
                rs.getString("contact_phone"),
                rs.getString("email"),
                rs.getString("location"),
                rs.getString("physical_address"),
                rs.getDate("registration_date").toLocalDate(),
                InstitutionStatus.valueOf(rs.getString("status"))
        );
    }
}
