ALTER TABLE clients
    ADD user_id BIGINT;

ALTER TABLE veterinarians
    ADD user_id BIGINT;

ALTER TABLE clients
    ADD CONSTRAINT FK_CLIENTS_ON_USER FOREIGN KEY (user_id) REFERENCES users (user_id);

ALTER TABLE veterinarians
    ADD CONSTRAINT FK_VETERINARIANS_ON_USER FOREIGN KEY (user_id) REFERENCES users (user_id);