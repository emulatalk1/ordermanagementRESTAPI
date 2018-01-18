# Order Management REST API

This is a simple RESTful web service using Spring MVC and Java. this web service provides an in-memory order management service, with the capability to get a single order, get all orders, create an order, delete an order, and update an order. The purpose of this project is to understand the three common layers of a RESTful web service (namely domain, data source, and presentation), the common design decisions used when creating a webservice, and the functionality provided by the Spring framework for creating a web service (as well as supplemental functionality, such as creating [HATEOAS](http://projects.spring.io/spring-hateoas/) links). Try to learn:

- How to cate a domain model.
- How to store domain objects in a persistence layer.
- Hoe to wrap domain objects within resource objects.
- How to add HATEOAS links to a resource.
- How to serve up resources to a client over HTTP.
- How to provide RESTful Create, Read, Update, and Delete (CRUD) operations to change domain objects.
- How to create unit, integration, and acceptance tests that exercise a REST API.

## A 3-Tier application

- Presentation layer (a series of REST endpoints).
- Domain layer (domain model) .
- Data source layer (a means of storing our domain objects, or a persistence layer).

Look at this architecture in terms of its interactions, as illustrated in the following diagram:

![Image of architecture](https://image.ibb.co/bsG4j6/rest_model.png)

There is an important addition that is made to architecture: Domain objects are not sent directly to the user. Instead, they are wrapped in resources and the resources are provided to the user. This provides a level of indirection between the domain object and how we present the domain object to the user. For example, if we wish to present the user with a different name for a field in our domain model (say `orderName` instead of simply `name`), we can do so using a resource.


## REST Endpoints

The following REST endpoints are available upon deployment of the order management system:

| HTTP Verb        | URL           | Description  | Status Codes |
| ------------- |-------------|:-----| ----|
| `GET` | `http://localhost:8080/order` | Obtains a list of all existing orders | <ul><li>`200 OK`</li></ul> |
| `GET` | `http://localhost:8080/order/{id}` | Obtains the order corresponding to the supplied order ID | <ul><li>`200 OK` if order exists</li><li>`404 Not Found` if order does not exist</li></ul> |
| `POST` | `http://localhost:8080/order` | Creates a new order based on the payload contained in the request body | <ul><li>`201 Created` if order successfully created</li></ul> |
| `PUT` | `http://localhost:8080/order/{id}` | Updated an existing order with the data contained in the request body | <ul><li>`200 OK` if order successfully updated</li><li>`404 Not Found` if order does not exist</li></ul> |
| `DELETE` | `http://localhost:8080/order/{id}` | Deletes an existing order that corresponds to the supplied order ID | <ul><li>`203 No Content` if order successfully deleted</li><li>`404 Not Found` if order does not exist</li></ul> |

## A plan of action to create app

1. Implement the domain model:
- [ ] Create the Order domain class.

2. Implement the data source layer:
- [ ] Create an in-memory database.
- [ ] Implement the CRUD operations for the Order domain class.

3. Implement the presentation layer:
- [ ] Create the REST endpoints.
- [ ] Create the Order resource.
- [ ] Create assembler to construct an Order resource with proper HATEOAS links.

4. Pull the application together:
- [ ] Create the main method that will run the application.