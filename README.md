# Welcome to Retail-Store-Billing!

This file shall help you understand the flow and test the APIs in this spring-boot based project.

# Flow Execution

A local user data has been stored in a file called as *SampleDataGenerator.java* to simulate database of users for a particular retail store. Each user is uniquely  identified by their **phone-number**, also, users can be differentiated by their user types like *employee, affliate, customer*

List of Project Files
- **User.java** - This is the dto being used specific to user details like *mobile-number, user-type, username, createDt*
- **BillingAmount.java**  - This file has the sole responsibility to keep the data of various bill types, with their amount in actuals (product-amount, product-type). As of now the application supports two product-types, *others, groceries*
- **BillingDetails.java** - This is the dto object being used for billing-details. It contains of following attributes :
  *user, list of billing-amount, discount amount, amount eligible for discout, amount not eligible for percentage based discount, number of items.*
- **BillingController.java** - This is the only entry point for the billing API and contains only 1 method, which is a **POST** method and has relative path of */finalBill*, the expected request and response both are BillingDetails object.
- **BillingService.java** - This is the responsible service file to calculate the final bill amount, it contains only 1 public method which is being called from BillingController.java, further it has been modularized to multiple private methods basis different percentage and amount based calculations.
-

## Sample Request Object

Please utilize this curl command to get the request object in your postman :

> `curl --location --request POST 'http://localhost:8080/finalBill' \  
--header 'Content-Type: application/json' \  
--data-raw '{  
"user":{  
"mobileNo":"9898989898"  
},  
"billingAmount":[{  
"productType":"groceries",  
"amount":280  
},  
{  
"productType":"others",  
"amount":990  
}],  
"finalBillAmount":890,  
"noOfItems":8  
}'`

## Sample Response Object

> `{  
"user": {  
"userId": 2,  
"username": "affliate",  
"mobileNo": "9898989898",  
"userType": "affliate",  
"createdDt": "2022-01-26"  
},  
"billingAmount": [  
{  
"productType": "groceries",  
"amount": 280.0  
},  
{  
"productType": "others",  
"amount": 990.0  
}  
],  
"discountAmount": 154.0,  
"finalBillAmount": 1116.0,  
"amountEligibleForDiscount": 990.0,  
"amountNotEligibleForDiscount": 280.0,  
"noOfItems": 8  
}`

## Rules Addressed in the project

On a retail website, the following discounts apply:

1. If the user is an employee of the store, he gets a 30% discount
2. If the user is an affiliate of the store, he gets a 10% discount
3. If the user has been a customer for over 2 years, he gets a 5% discount.
4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45 as a discount).
5. The percentage based discounts do not apply on groceries.
6. A user can get only one of the percentage based discounts on a bill.


## UML Diagram
Here is a glance of the UML diagram of the java classes being used:
![UML Diagram](src/main/resources/static/UMLDiagram.png?raw=true)


## Code Coverage
Here is the glance of the code coverage for the classes being used:
![Code Coverage](src/main/resources/static/Code_coverage_ss.png?raw=true)
