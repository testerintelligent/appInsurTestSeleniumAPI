Feature: Policy creation scenarios

  @smoke_UI
  @policy_UI
  Scenario: Create a policy and validate the success message
    Given I login ReactApp using below credentials
      | Username | test@test.com |
    When I create policy with below data
      | Address     | ChennaiMEPZ      |
      | DateOfBirth | 02/24/1989       |
      | PolicyType  | Health Insurance |
      | Premium     | 10089            |
      | SumInsured  | 100000           |
    Then I should see the "Insurance policy created successfully." message displayed

  @smoke_UI
    @policy_UI
  Scenario Outline: Create multiple policies with different data and validate the success message
    Given I login ReactApp using below credentials
      | Username | test@test.com |
    When I create policy with below data
      | Address     | <address>    |
      | DateOfBirth | 02/24/1989   |
      | PolicyType  | <policyType> |
      | Premium     | <premium>    |
      | SumInsured  | 100000       |
    Then I should see the "Insurance policy created successfully." message displayed

    Examples:
      | address       | policyType         | premium |
      | ChennaiPrince | Health Insurance   | 10089   |
      | ChennaiMEPZ   | Vechicle Insurance | 9089    |

  @smoke_UI_negativecheck
  @policy_UI
  Scenario: Login with invalid credentials - NEGATIVE CHECK FOR REPORT
    Given I login ReactApp using below credentials
      | Username | test1@test.com |