Feature: Verify adding multiple items to the cart on Amazon.in

Background:
Given the user is on "https://www.amazon.in/"
Scenario Outline: Adding a “Monitor” Item in Cart and verifying sub total


When user search for "<item>" in the search field
And user select the first item in the list
And user add the "<item>" to the cart by clicking on "ADD TO CART"
And user open the cart from the top left navigation
Then user should verify that the price in the cart is identical to the product page
And  user should verify that the subtotal in the cart is identical to the product page

Examples:
|item|
|Monitor|

Scenario Outline: Adding a “Laptop” Item in Cart and verifying sub total

When user search for "<item>" in the search field
And user select the second item in the list
And user add the second "<item>" to the cart by clicking on "ADD TO CART"
And user open the cart from the top left navigation
Then user should verify that the price in the cart is identical to the product page
And  user should verify that the subtotal in the cart is identical to the product page

Examples:
|item|
|Laptop|

@smoke
Scenario Outline: Adding two items in Cart and verifying sub total

When user search for "<item>" in the search field
And user select the first item in the list
And user add the "<item>" to the cart by clicking on "ADD TO CART"
And user searches for next item as "Keyboard"
And user add the next item "Keyboard" to the cart by clicking on "ADD TO CART"
And user open the cart from the top left navigation
Then user should verify that the price in the cart for each items is identical to the product page
And  user should verify that the subtotal in the cart is sum of all the items added in the cart

#Then user should verify that the each price in the cart is identical to the product page
#And  user should verify that the subtotal in the cart is sum of items to the product page

Examples:
|item|
|Headphones|