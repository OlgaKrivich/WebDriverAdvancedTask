@Regression
Feature: Desktop Checkout for Guest User
  As a customer
  I want to be able proceed to checkout
  So that I can specify my delivery and payment details and place the order

  Scenario: Proceed to checkout, final review and place order as guest user

    Given I open the Initial home page
    When I search for 'Thinking in Java'
    Then I am redirected to a Search page
    And Search results contain the following products
      | Thinking in Java       |
      | Thinking Java Part I   |
      | Core Java Professional |
    When I apply the following search filters
      | Price range  | 30 € +         |
      | Availability | In Stock (6)   |
      | Language     | English (16)   |
      | Format       | Paperback (21) |
    Then Search results contain only the following products
      | Thinking in Java                                                      |
      | Think Java                                                            |
      | Thinking Recursively with Java                                        |
      | Java and Algorithmic Thinking for the Complete Beginner (2nd Edition) |
    When I click 'Add to basket' button for product with name 'Thinking in Java'
    And I select 'Basket Checkout' in basket pop-up
    Then I am redirected to a Basket page
    And Basket order summary is as following:
      | Delivery cost | Total    |
      | FREE          | 105,90 € |
    When I click 'Checkout' button on Basket page
    And I checkout as a new customer with email 'test@user.com'
    Then Checkout order summary is as following:
      | Sub-total | Delivery | VAT    | Total    |
      | 105,90 €  | FREE     | 0,00 € | 105,90 € |
    When I fill delivery address information manually:
      | Full name | Delivery country | Address line 1   | Address line 2   | Town/City | County/State | Postcode |
      | John      | Ukraine          | Random address 1 | Random address 2 | Kyiv      | Random State | 12345    |
    Then There is no validation error messages displayed on 'Delivery Address' form
    When I enter my card details
      | Card Number | 4111111111111111 |
      | Expiry Year | 2022 |
      | Expiry Month | 03 |
      | Cvv | 123 |


