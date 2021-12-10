# BillControlAPI

## Introduction
REST API in spring boot for bills management.


## Execution

For execute enter in the BillControlAPI folder in terminal and write the code below to start a server to run the API.

>$ mvn spring-boot:run

## Funcionalities

The API allow to add a new Bill by Id if not exists a bill with same ID, remove a bill by ID, show all bills and show a bill by ID.

## Manipulating database 
  
 For use the REST API is necessary pass the information through the following HTML methods:
  
### Create a new bill
  
  > [POST HTTP METHOD] [url/api/v1/bills] [Elements in JSON]
  
### get a certain bill by ID
  
  > [GET HTTP METHOD] [url/api/v1/bills/bill_ID]
  
### Show all bills
  
  > [GET HTTP METHOD] [url/api/v1/bills]
  
### Deleting an existing bill by ID
  
  > [DELETE HTTP METHOD] [url/api/v1/bills/bill_ID]
