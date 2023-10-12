CREATE SEQUENCE IF NOT EXISTS user_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE clients
(
    client_id      BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    first_name     VARCHAR(45),
    last_name      VARCHAR(45),
    email          VARCHAR(45)                             NOT NULL,
    age            INTEGER                                 NOT NULL,
    contact_number VARCHAR(12),
    address        VARCHAR(255),
    gender         VARCHAR(255),
    created_at     TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_clients PRIMARY KEY (client_id)
);

CREATE TABLE medicine_procedure
(
    medical_procedure_id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    created_at           TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at           VARCHAR(255),
    notes                VARCHAR(255),
    remarks              VARCHAR(255),
    status               SMALLINT,
    next_due_date        TIMESTAMP WITHOUT TIME ZONE,
    pet_id               BIGINT                                  NOT NULL,
    medicine_stock_id    BIGINT                                  NOT NULL,
    CONSTRAINT pk_medicine_procedure PRIMARY KEY (medical_procedure_id)
);

CREATE TABLE medicine_stocks
(
    medicine_stock_id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    quantity          DOUBLE PRECISION,
    out_whole         DOUBLE PRECISION,
    out_fraction      DOUBLE PRECISION,
    expiry_date       TIMESTAMP WITHOUT TIME ZONE,
    user_id           BIGINT                                  NOT NULL,
    CONSTRAINT pk_medicine_stocks PRIMARY KEY (medicine_stock_id)
);

CREATE TABLE medicines
(
    medicine_id        BIGINT           NOT NULL,
    name               VARCHAR(45)      NOT NULL,
    description        VARCHAR(255)     NOT NULL,
    label              VARCHAR(45)      NOT NULL,
    label_volume       VARCHAR(45)      NOT NULL,
    quantity_per_stock DOUBLE PRECISION NOT NULL,
    code               VARCHAR(150)     NOT NULL,
    manufacturer       VARCHAR(150)     NOT NULL,
    supplier           VARCHAR(150)     NOT NULL,
    user_id            BIGINT           NOT NULL,
    medicine_stock_id  BIGINT           NOT NULL,
    CONSTRAINT pk_medicines PRIMARY KEY (medicine_id)
);

CREATE TABLE pets
(
    pet_id       BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name         VARCHAR(45)                             NOT NULL,
    photo_url    VARCHAR(255),
    breed        VARCHAR(45),
    species      VARCHAR(45)                             NOT NULL,
    birth_date   TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    gender       VARCHAR(12),
    color        VARCHAR(45),
    microchip_id VARCHAR(45),
    weight       VARCHAR(45),
    next_visit   TIMESTAMP WITHOUT TIME ZONE,
    client_id    BIGINT                                  NOT NULL,
    CONSTRAINT pk_pets PRIMARY KEY (pet_id)
);

CREATE TABLE roles
(
    role_id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name    VARCHAR(45)                             NOT NULL,
    CONSTRAINT pk_roles PRIMARY KEY (role_id)
);

CREATE TABLE schedule
(
    schedule_id     BIGINT NOT NULL,
    time_start      TIMESTAMP WITHOUT TIME ZONE,
    time_end        TIMESTAMP WITHOUT TIME ZONE,
    all_day         INTEGER,
    veterinarian_id BIGINT NOT NULL,
    CONSTRAINT pk_schedule PRIMARY KEY (schedule_id)
);

CREATE TABLE user_roles
(
    role_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT pk_user_roles PRIMARY KEY (role_id, user_id)
);

CREATE TABLE users
(
    user_id           BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    first_name        VARCHAR(45),
    last_name         VARCHAR(45),
    email             VARCHAR(45)                             NOT NULL,
    contact_number    VARCHAR(12),
    password          VARCHAR(64)                             NOT NULL,
    profile_image_url VARCHAR(255),
    created_at        TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (user_id)
);

CREATE TABLE veterinarians
(
    veterinarian_id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    first_name      VARCHAR(45),
    last_name       VARCHAR(45),
    email           VARCHAR(45)                             NOT NULL,
    age             INTEGER                                 NOT NULL,
    contact_number  VARCHAR(12),
    address         VARCHAR(45),
    designation     VARCHAR(150),
    license         VARCHAR(150),
    legend_color    VARCHAR(150),
    created_at      TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_veterinarians PRIMARY KEY (veterinarian_id)
);

ALTER TABLE clients
    ADD CONSTRAINT uc_clients_email UNIQUE (email);

ALTER TABLE roles
    ADD CONSTRAINT uc_roles_name UNIQUE (name);

ALTER TABLE veterinarians
    ADD CONSTRAINT uc_veterinarians_email UNIQUE (email);

ALTER TABLE users
    ADD CONSTRAINT users_email_unique UNIQUE (email);

ALTER TABLE medicines
    ADD CONSTRAINT FK_MEDICINES_ON_MEDICINE_STOCK FOREIGN KEY (medicine_stock_id) REFERENCES medicine_stocks (medicine_stock_id);

ALTER TABLE medicines
    ADD CONSTRAINT FK_MEDICINES_ON_USER FOREIGN KEY (user_id) REFERENCES users (user_id);

ALTER TABLE medicine_procedure
    ADD CONSTRAINT FK_MEDICINE_PROCEDURE_ON_MEDICINE_STOCK FOREIGN KEY (medicine_stock_id) REFERENCES medicine_stocks (medicine_stock_id);

ALTER TABLE medicine_procedure
    ADD CONSTRAINT FK_MEDICINE_PROCEDURE_ON_PET FOREIGN KEY (pet_id) REFERENCES pets (pet_id);

ALTER TABLE medicine_stocks
    ADD CONSTRAINT FK_MEDICINE_STOCKS_ON_USER FOREIGN KEY (user_id) REFERENCES users (user_id);

ALTER TABLE pets
    ADD CONSTRAINT FK_PETS_ON_CLIENT FOREIGN KEY (client_id) REFERENCES clients (client_id);

ALTER TABLE schedule
    ADD CONSTRAINT FK_SCHEDULE_ON_VETERINARIAN FOREIGN KEY (veterinarian_id) REFERENCES veterinarians (veterinarian_id);

ALTER TABLE user_roles
    ADD CONSTRAINT fk_userol_on_role FOREIGN KEY (role_id) REFERENCES roles (role_id);

ALTER TABLE user_roles
    ADD CONSTRAINT fk_userol_on_user FOREIGN KEY (user_id) REFERENCES users (user_id);