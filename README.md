# Order Management REST API

This is a simple RESTful web service using Spring MVC and Java. this web service provides an in-memory order management service, with the capability to get a single order, get all orders, create an order, delete an order, and update an order. The purpose of this project is to understand the three common layers of a RESTful web service (namely domain, data source, and presentation), the common design decisions used when creating a webservice, and the functionality provided by the Spring framework for creating a web service (as well as supplemental functionality, such as creating [HATEOAS](http://projects.spring.io/spring-hateoas/) links). Try to learn:

- How to cate a domain model.
- How to store domain objects in a persistence layer.
- Hoe to wrap domain objects within resource objects.
- How to add HATEOAS links to a resource.
- How to serve up resources to a client over HTTP.
- How to provide RESTful Create, Read, Update, and Delete (CRUD) operations to change domain objects.
- How to create unit, integration, and acceptance tests that exercise a REST API.

## REST Endpoints
The following REST endpoints are available upon deployment of the order management system:

| HTTP Verb        | URL           | Description  | Status Codes |
| ------------- |-------------|:-----| ----|
| `GET` | `http://localhost:8080/order` | Obtains a list of all existing orders | <ul><li>`200 OK`</li></ul> |
| `GET` | `http://localhost:8080/order/{id}` | Obtains the order corresponding to the supplied order ID | <ul><li>`200 OK` if order exists</li><li>`404 Not Found` if order does not exist</li></ul> |
| `POST` | `http://localhost:8080/order` | Creates a new order based on the payload contained in the request body | <ul><li>`201 Created` if order successfully created</li></ul> |
| `PUT` | `http://localhost:8080/order/{id}` | Updated an existing order with the data contained in the request body | <ul><li>`200 OK` if order successfully updated</li><li>`404 Not Found` if order does not exist</li></ul> |
| `DELETE` | `http://localhost:8080/order/{id}` | Deletes an existing order that corresponds to the supplied order ID | <ul><li>`203 No Content` if order successfully deleted</li><li>`404 Not Found` if order does not exist</li></ul> |