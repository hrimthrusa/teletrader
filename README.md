## Test project for stock exchange order processing and storing.

##### A Spring Boot app with PostgreSQL as the database and liquibase for creation and population of the tables.
Table `stocks` represents a made-up stock exchange with various stocks changing its price in a random manner from 50
to 100 every five seconds.

##### Guidelines

1. Please sign up by sending a POST request to `http://localhost:8080/api/v1/auth/signup`
```json
{
    "email" : "example@gmail.com",
    "firstName" : "John",
    "lastName" : "Doe",
    "password" : "user",
    "userName" : "superUser",
    "role" : "USER"
}
```

2. Please sign in by sending a POST request to `http://localhost:8080/api/v1/auth/signin`
```json
{
    "email" : "example@gmail.com",
    "password" : "user"
}
```
Your JWT token will be stored in the cookies. 

3. You may now place an order by sending a POST request to `http://localhost:8080/api/v1/order` for the market order:
```json
{
    "ticker" : "A",
    "amount" : "1",
    "orderType" : "MARKET",
    "operationType" : "SELL",
    "userId" : 1
}
```
or for a limit order:
```json
{
    "price" : 80,
    "ticker" : "A",
    "amount" : "1",
    "orderType" : "LIMIT",
    "operationType" : "SELL",
    "userId" : 1
}
```
the `price` parameter expresses the desired price of the stock to execute the order.

4. Table `processed_orders` is prefilled with test data and there is a possibility of getting the Order Book by sending a GET request to `http://localhost:8080/api/v1/order-book/sell` to get the Top 10 Sell orders and
   `http://localhost:8080/api/v1/order-book/buy` to get the Top 10 Buy orders.

###### Thank You for Your time.