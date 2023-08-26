Feature: Login

  Scenario Outline: Scenario Input Username and Password Login to Main Web
    Given Navigation to : Main Web Login
    When input username <Username> and password <Password> to login to web
    Then enter dashboard page

    Examples: 
      | Username      | Password     |
      | standard_user | secret_sauce |
