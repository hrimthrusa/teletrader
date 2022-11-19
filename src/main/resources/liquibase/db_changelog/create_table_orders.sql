CREATE TABLE orders
(
    id               BIGSERIAL PRIMARY KEY,
    price            DECIMAL(10, 2),
    amount           BIGINT,
    operationType    VARCHAR(256),
    orderType        VARCHAR(256)
);