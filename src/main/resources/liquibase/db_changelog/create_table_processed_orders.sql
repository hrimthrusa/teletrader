CREATE TABLE processed_orders
(
    id               BIGSERIAL PRIMARY KEY,
    ticker           VARCHAR(256),
    amount           BIGINT,
    momentary_price  DECIMAL(10, 2),
    operation_type   VARCHAR(256),
    order_type       VARCHAR(256),
    user_id          BIGINT,

    FOREIGN KEY (user_id) REFERENCES users (id)
);