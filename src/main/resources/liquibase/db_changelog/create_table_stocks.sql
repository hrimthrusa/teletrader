CREATE TABLE stocks
(
    id               BIGSERIAL PRIMARY KEY,
    ticker           VARCHAR(256),
    price            DECIMAL(10, 2)
);