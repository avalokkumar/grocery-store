# grocery-store

## Micro Services built on Spring Boot with Mongo DB for E-Commerce application.

Users

Customers
Employees
Caretaker
Products

## Microservices for Grocery Store

CustomerRegistrationService
CustomerLoginService
ProductCatalogueService
ShoppingCartService
ProductSaleService
OrderDeliveryService
InvoiceAndPaymentService
ProductWarehouseService
CustomerRegistrationService

## Endpoints:

Base URI : /nexcorp/api/v1

To register user:

	Method: POST
	ServiceURI: /users
	Request Body:
		- first_name
		- last_name
		- email_id
		- gender
		- username
		- password
		- phone_number
		- address 1
		- address 2
		- town/city
		- state
	
	Response
		- registration_id
		- isRegistrationSuccess - boolean
		- createdBy
		- createdTimestamp
		
To update user's registration details:
	Method: POST
	ServiceURI: /users
	Request Body:
		- first_name
		- last_name
		- email_id
		- gender
		- username
		- password
		- phone_number
		- address 1
		- address 2
		- town/city
		- state
	
	Response
		- registration_id
		- isRegistrationSuccess - boolean
		- createdBy
		- createdTimestamp
	
To Get a user details:

	Method: GET
	ServiceURI: /users/{username}
		
	Response
		- first_name
		- last_name
		- email_id
		- gender
		- username
		- phone_number
		- address 1
		- address 2
		- town/city
		- state

To Get all users:

	Method: GET
	ServiceURI: /users
		
	Response
		- first_name
		- last_name
		- email_id
		- gender
		- username
		- phone_number
		- address 1
		- address 2
		- town/city
		- state

To Get user's contact:

	Method: GET
	ServiceURI: /users/contacts?username=clay
		
	Response
		- phone_number

CustomerLoginService
