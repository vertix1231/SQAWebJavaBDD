Feature: Dashboard Product

  Scenario Outline: Scenario Buy Product
    Given In the dashboard page
    When Click Add to Chart One of Products in Dashboard Product
    When Click Shopping Cart Icon with Number at The Right Top Corner
    When Click Checkout Shoping Cart
    When Input Form ID to Continue Checkout
    When Confirm to Finish Checkout
    Then Succesfuly Buy Product
    Then Back Home Dashboard
  
  Scenario Outline: Scenario Buy All Product
    Given In the dashboard page
    When Click Add to Chart All of Products in Dashboard Product
    When Click Shopping Cart Icon with Number at The Right Top Corner
    When Click Checkout Shoping Cart
    When Input Form ID to Continue Checkout
    When Confirm to Finish Checkout
    Then Succesfuly Buy Product
    Then Back Home Dashboard
