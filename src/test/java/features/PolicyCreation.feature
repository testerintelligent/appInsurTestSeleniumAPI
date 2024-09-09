Feature: Policy creation Rest API

  @smoke
  @policy
  Scenario: Create a new policy using POST method and validate response code
    Given I have the following policy details
      | Name        | random           |
      | email       | random           |
      | Address     | Chennai          |
      | DateOfBirth | 2024-09-23       |
      | PolicyType  | Health Insurance |
      | Premium     | 10089            |
      | SumInsured  | 100000           |
    When I send a POST request to Endpoint "http://192.168.99.141:5000/Dashboard"
    Then the response code should be 201
    And the response body should contain "Insurance policy created successfully."

  @smoke
  @login
  Scenario: Validate login using POST method and validate response code
    Given I have the following login details
      | username | test@test.com |
      | password | 12345         |
    When I send a POST request to Endpoint "http://192.168.99.141:5000/home"
    Then the response code should be 200
    And the response body should contain "valid email or password"

  @smoke_performance
  Scenario: Create bulk policies for load test
    Given I have created 10 policies

  @smoke
  Scenario Outline: Create multiple policies with data combination using POST method and validate response code
    Given I have the following policy details
      | Name        | random       |
      | email       | random       |
      | Address     | <address>    |
      | DateOfBirth | 2024-09-23   |
      | PolicyType  | <policyType> |
      | Premium     | <premium>    |
      | SumInsured  | 100000       |
    When I send a POST request to Endpoint "http://192.168.99.141:5000/Dashboard"
    Then the response code should be 201
    And the response body should contain "Insurance policy created successfully."

    Examples:
      | premium | policyType         | address        |
      | 10089   | Health Insurance   | ChennaiMEPZ    |
      | 10189   | Vechicle Insurance | PrinceINFOCITY |