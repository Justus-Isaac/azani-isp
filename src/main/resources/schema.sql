
CREATE TABLE bandwidth_tiers (
                                       tier_id           INT AUTO_INCREMENT PRIMARY KEY,
                                       bandwidth_mbps    INT NOT NULL UNIQUE,
                                       monthly_cost      DECIMAL(10,2) NOT NULL
);

INSERT INTO bandwidth_tiers (bandwidth_mbps, monthly_cost) VALUES
            (4, 1200), (10, 2000),(20, 3500),
            (25, 4000), (50, 7000);


CREATE TABLE lan_node_bands (
                                       band_id      INT AUTO_INCREMENT PRIMARY KEY,
                                       min_nodes    INT NOT NULL,
                                       max_nodes    INT NOT NULL,
                                       cost         DECIMAL(10,2) NOT NULL
);

INSERT INTO lan_node_bands (min_nodes, max_nodes, cost) VALUES
                 (2, 10, 10000), (11, 20, 20000),
                 (21, 40, 30000), (41, 100, 40000);


CREATE TABLE institutions (
                                       institution_id  INT AUTO_INCREMENT PRIMARY KEY,
                                       registration_no  VARCHAR(20) NOT NULL UNIQUE,
                                       name             VARCHAR(150) NOT NULL,
                                       institution_type   ENUM('PRIMARY', 'JUNIOR', 'SENIOR', 'COLLEGE') NOT NULL,
                                       contact_phone    VARCHAR(20) NOT NULL,
                                       email            VARCHAR(100) NOT NULL,
                                       location         VARCHAR(150),
                                       physical_address  VARCHAR(200),
                                       registration_date DATE NOT NULL DEFAULT (CURRENT_DATE),
                                       status    ENUM('PENDING_REGISTRATION','REGISTERED','ACTIVE','DISCONNECTED','SUSPENDED')
        NOT NULL DEFAULT 'PENDING_REGISTRATION',
                                       created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE readiness_assessments (
                                       assessment_id       INT AUTO_INCREMENT PRIMARY KEY,
                                       institution_id      INT NOT NULL,
                                       assessment_date     DATE NOT NULL,
                                       num_users           INT NOT NULL,
                                       existing_computers  INT DEFAULT 0,
                                       existing_lan_nodes  INT DEFAULT 0,
                                       is_ready            BOOLEAN NOT NULL,
                                       notes               VARCHAR(255),
                                       FOREIGN             KEY (institution_id) REFERENCES institutions(institution_id)
);

CREATE TABLE equipment_purchases (
                                     purchase_id     INT AUTO_INCREMENT PRIMARY KEY,
                                     institution_id  INT NOT NULL,
                                     item_type       ENUM('COMPUTER','LAN_NODES') NOT NULL,
                                     quantity        INT NOT NULL,           -- # PCs, or # nodes (falls within a band)
                                     lan_band_id     INT NULL,               -- set only when item_type = LAN_NODES
                                     unit_cost       DECIMAL(10,2),          -- 40000 for a PC; NULL for LAN (band cost used)
                                     total_cost      DECIMAL(10,2) NOT NULL,
                                     purchase_date   DATE NOT NULL,
                                     FOREIGN         KEY (institution_id) REFERENCES institutions(institution_id),
                                     FOREIGN         KEY (lan_band_id) REFERENCES lan_node_bands(band_id)
);


CREATE TABLE installations (
                               installation_id        INT AUTO_INCREMENT PRIMARY KEY,
                               institution_id         INT NOT NULL UNIQUE,
                               installation_fee       DECIMAL(10,2) NOT NULL DEFAULT 10000,
                               installation_date      DATE,
                               FOREIGN                KEY (institution_id) REFERENCES institutions(institution_id)
);


CREATE TABLE subscriptions (
                               subscription_id INT AUTO_INCREMENT PRIMARY KEY,
                               institution_id INT NOT NULL,
                               tier_id INT NOT NULL,
                               start_date DATE NOT NULL,
                               end_date DATE NULL,
                               change_type ENUM('NEW','UPGRADE','DOWNGRADE') NOT NULL DEFAULT 'NEW',
                               discount_percent DECIMAL(5,2) NOT NULL DEFAULT 0.00,

                               CONSTRAINT chk_subscription_discount
                                   CHECK (discount_percent BETWEEN 0.00 AND 100.00),

                               FOREIGN KEY (institution_id)
                                   REFERENCES institutions(institution_id),

                               FOREIGN KEY (tier_id)
                                   REFERENCES bandwidth_tiers(tier_id)
);

CREATE TABLE monthly_bills (
                               bill_id INT AUTO_INCREMENT PRIMARY KEY,
                               institution_id INT NOT NULL,
                               subscription_id INT NOT NULL,
                               cycle_start DATE NOT NULL,
                               cycle_end DATE NOT NULL,
                               base_amount DECIMAL(10,2) NOT NULL,
                               fine_amount DECIMAL(10,2) NOT NULL DEFAULT 0.00,
                               total_due DECIMAL(10,2) NOT NULL,
                               due_date DATE NOT NULL,
                               disconnect_date DATE NULL,
                               payment_status ENUM( 'PENDING','PAID', 'OVERDUE') NOT NULL DEFAULT 'PENDING',
                               paid_date DATE NULL,

                               CONSTRAINT uq_subscription_billing_cycle
                                   UNIQUE (subscription_id, cycle_start),

                               FOREIGN KEY (institution_id)
                                   REFERENCES institutions(institution_id),

                               FOREIGN KEY (subscription_id)
                                   REFERENCES subscriptions(subscription_id)
);


CREATE TABLE disconnections (
                                disconnection_id INT AUTO_INCREMENT PRIMARY KEY,
                                institution_id INT NOT NULL,
                                bill_id INT NOT NULL,
                                disconnected_on DATE NOT NULL,
                                reconnected_on DATE NULL,
                                reconnection_fee DECIMAL(10,2) NOT NULL DEFAULT 1000.00,

                                FOREIGN KEY (institution_id)
                                    REFERENCES institutions(institution_id),

                                FOREIGN KEY (bill_id)
                                    REFERENCES monthly_bills(bill_id)
);



CREATE TABLE payments (
                          payment_id      INT AUTO_INCREMENT PRIMARY KEY,
                          institution_id  INT NOT NULL,
                          payment_type    ENUM('REGISTRATION','INSTALLATION','EQUIPMENT',
    'MONTHLY_BILL','FINE','RECONNECTION') NOT NULL,
                          reference_id    INT NULL,      -- id in related table (bill_id, purchase_id, disconnection_id...)
                          amount          DECIMAL(10,2) NOT NULL,
                          payment_date    DATE NOT NULL,
                          FOREIGN         KEY (institution_id) REFERENCES institutions(institution_id)
);