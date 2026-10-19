package com.example.azaniisp.utils;

public final class SqlQueries {

    private SqlQueries() {}

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
}
