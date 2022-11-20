CREATE TABLE orders
(
    id               BIGSERIAL PRIMARY KEY,
    ticker           VARCHAR(256),
    price            DECIMAL(10, 2),
    amount           BIGINT,
    operation_type   VARCHAR(256),
    order_type       VARCHAR(256)
);