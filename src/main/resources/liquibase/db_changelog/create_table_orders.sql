CREATE TABLE orders
(
    id               BIGSERIAL PRIMARY KEY,
    price            DECIMAL(10, 2),
    amount           BIGINT,
    type             VARCHAR(256)
);