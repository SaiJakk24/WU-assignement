


# WU Assignment

Customerportal  demo is demonstrating how to implement simple CRUD operations with a Customer entity and implementing rate limiter to the endpoints.

This project is based on the Spring Boot project and uses these packages :
- Spring Boot 3
- Maven
- Spring Boot JPA
- H2 Database
- Resilience4j

Below table shows the API endpoints created and the description of endpoints.

| Method  | Url                | Description                          |
| ------------- |--------------------|--------------------------------------|
| GET  | /api/customer      | To retrieve all the customer details |
| GET | /api/customer/{id} | retrieve by specicic customer ID     |
|POST|/api/customer| To create a record of customer       |
|PUT|/api/customer/{id}| To Update a record of customer by ID |
|DELETE|/api/customer/{id}| To Delete a customer record by ID    |


You can test them using postman or any other rest client.
## Rate Limiter

Rate limiting is an architectural tactic for a server to limit access to an API. It helps to:

- protect against server overload due to clients that call the server in a short time frame too often
- increase the fairness of how clients use server resources
- Allow price systems for varied quantities of requests.

Allow me to provide a brief introduction to resilience4j-ratelimiter configurations.

**limit-for-period:** The number of allowed requests during one “limit-refresh-period”.

**limit-refresh-period:** Specifies the duration after which “limit-for-period” will be reset.

**timeout-duration:** Sets the maximum wait time for the rate limiter to permit subsequent requests.

- Hit any API more than 5 times in a limit refresh period(set to 30seconds), we will not be able to see the response the 6th hit.
It will throw a message "Too many requests". 
