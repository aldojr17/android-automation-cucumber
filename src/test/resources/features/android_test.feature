Feature: Buy Product Feature

Scenario: Open app and buy a product
Given User open app
When User want to buy "Sauce Lab Back Packs"
And Choose the "Blue" color
And Want to buy "2" products
And Checkout the products
And Login into the app
And Enter the shipping address
And Enter the payment method
And Place the order
Then Proceed until product placed