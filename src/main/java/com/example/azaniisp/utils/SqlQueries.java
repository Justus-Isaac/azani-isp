package com.example.azaniisp.utils;

public final class SqlQueries {



    public static final String INSTITUTIONS_INSERT =
           """
               INSERT INTO institutions\s
               ( registration_no, name, institution_type, contact_phone, email,
                 location, physical_address, registration_date, status
               )\s
               VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);
          \s""";

    public static final String INSTITUTION_SELECT_BY_ID =
            """
              SELECT * FROM institutions WHERE institution_id = ?;
            """;

    public static final String INSTITUTION_SELECT_BY_REGISTRATION_NO =
            """
                SELECT * FROM institutions WHERE institution_registration_no = ?;
            """;

    public static final String INSTITUTION_SELECT_ALL =
            """
               SELECT * FROM institutions ORDER BY institution_id ASC;
            """;

    public static final String INSTITUTION_UPDATE =
    """
        UPDATE institutions\s
        SET registration_no = ?, name = ?, institution_type = ?, contact_name = ?, contact_phone = ?,\s
            email = ?, location = ?, physical_address = ?, registration_date = ?, status = ?
        WHERE institution_id = ?
   \s""";

    public static final String BANDWIDTH_TIERS_SELECT_BY_ID =
            """
                SELECT * FROM bandwidth_tiers WHERE tier_id = ?;
            """;

    public  static final String BANDWIDTH_TIERS_SELECT_ALL =
            """
                SELECT * FROM bandwidth_tiers ORDER BY tier_id ASC;
            """;

    public static final String LAN_NODE_BANDS_SELECT_BY_ID =
            """
                SELECT * FROM lan_node_bands WHERE band_id = ?;
            """;

    public static final String LAN_NODE_BANDS_SELECT_ALL =
            """
                SELECT * FROM lan_node_bands ORDER BY band_id ASC;
            """;

    private SqlQueries() {}
}
