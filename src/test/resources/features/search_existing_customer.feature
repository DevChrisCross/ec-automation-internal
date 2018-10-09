Feature: Search existing customer
  In order to view a customer profile
  As an Internal User
  I want to be able to search a customer

  Scenario Outline: Robert wants to search a customer with his preferred filter
    Given that Robert decided to find a specific customer using the customer search
    When he searches for a criteria that <match> the term <word> using the <filter> filter shown by <group> category
    Then he should see that the search results matches the criteria of the filter
    Examples:
      | match           | word                        | filter | group |
      | CONTAINS        | christian                   | EMAIL  | USER  |
      | EXACTLY_MATCHES | christian.molina@elavon.com | EMAIL  | USER  |

