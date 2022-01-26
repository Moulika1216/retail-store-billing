"# retail-store-billing" 

#Sample request:
curl --location --request POST 'http://localhost:8080/finalBill' \
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
}'

#Response:
{
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
}
