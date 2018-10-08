Feature: Search existing customer
  In order to view a customer profile
  As an Internal User
  I want to be able to search a customer

  Scenario: Robert wants to search a customer with his preferred filter
    Given that Robert has search by USER with the EMAIL filter that STARTS_WITH the criteria Christian in the customer search
    When he looks at the search results table
    Then he should see that the search results matches the criteria of the filter
