Feature: Find article in Vermint.com
  Scenario: Find article in Vermint.com with title contain customer solution
  	Given Go to Verint.com
  	When Click on search button
  	And Input customer solution
  	Then Check if article title contains customer solution in the Search Result