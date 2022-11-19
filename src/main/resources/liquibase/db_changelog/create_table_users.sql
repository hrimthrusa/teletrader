CREATE TABLE users
(
    id                  BIGSERIAL PRIMARY KEY,
    email               VARCHAR(256),
    firstName           VARCHAR(256),
    lastName            VARCHAR(256),
    password            VARCHAR(256),
    user_name           VARCHAR(256),
    role                VARCHAR(100)
);