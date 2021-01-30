Feature: Accounts

Scenario: Get All ChangeRequests



When Send the Get Request
Then Validate the Status Code as 200
Then verify Response contentType
