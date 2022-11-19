CREATE TABLE orders
(
    id               BIGSERIAL PRIMARY KEY,
    price            DECIMAL(10, 2),
    amount           BIGINT,
    operation_type    VARCHAR(256),
    order_type        VARCHAR(256)
);