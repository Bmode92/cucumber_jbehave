Feature: Credit Offer

  Scenario:  Business credit offer - VIP customer
    Given There is a business credit offer
    When We have a vip customer named Stefan
    And Add customer to a business credit offer
    Then Customer is added to a business credit offer
    And Customer cannot be removed from a business credit offer

  Scenario: Business credit offer - Usual customer
    Given There is a business credit offer
    When We have a usual customer named Alex
    Then Customer cannot be added to a business credit offer

  Scenario:  Economy credit offer - VIP customer
    Given There is an economy credit offer
    When We have a vip customer named Adi
    And Add customer to an economy credit offer
    Then Customer is added to an economy credit offer
    And Customer cannot be removed from an economy credit offer

  Scenario: Economy credit offer - Usual customer
    Given There is an economy credit offer
    When We have a usual customer named Andrei
    And Add customer to an economy credit offer
    Then Customer is added to an economy credit offer
    And Customer can be removed from an economy credit offer

  Scenario:  Premium credit offer - VIP customer
    Given There is a premium credit offer
    When We have a vip customer named Adi
    And Add customer to a premium credit offer
    Then Customer is added to a premium credit offer
    And Customer can be removed from a premium credit offer

  Scenario: Premium credit offer - Usual customer
    Given There is a premium credit offer
    When We have a usual customer named Andrei
    Then Customer cannot be added to a premium credit offer

  Scenario: Business credit offer - VIP customer cannot be added more than once to credit offer
    Given There is a business credit offer
    When We have a vip customer named Stefan
    And Add customer to a business credit offer
    Then Customer cannot be added more than once to a business credit offer

  Scenario:  Economy credit offer - VIP customer cannot be added more than once to credit offer
    Given There is an economy credit offer
    When We have a vip customer named Adi
    And Add customer to an economy credit offer
    Then Customer cannot be added more than once to an economy credit offer

  Scenario: Economy credit offer - Usual customer cannot be added more than once to credit offer
    Given There is an economy credit offer
    When We have a usual customer named Andrei
    And Add customer to an economy credit offer
    Then Customer cannot be added more than once to an economy credit offer

  Scenario:  Premium credit offer - VIP customer cannot be added more than once to credit offer
    Given There is a premium credit offer
    When We have a vip customer named Adi
    And Add customer to a premium credit offer
    Then Customer cannot be added more than once to a premium credit offer

  Scenario Outline: Economy credit offer - Check bonus points
    Given There is an economy credit offer
    When We have a <userType> customer named <name>
    And Add customer to an economy credit offer
    Then Customer bonus points should be <expectedPoints>

    Examples:
      | expectedPoints | userType | name   |
      | 10             | vip      | Stefan |
      | 5              | usual    | Alex   |