@EXAM2
Feature: AUTOMATION TEST EXAM2

  Background: Go to phptravels website
    Given Go to "https://phptravels.net/admin"


  @exam2_part1
  Scenario Outline: Dashboard page
    Given input username "<username>"
    And   input password "<password>"
    When  Click login button
    Then  Verify dashboard page "<display>"
    Examples:
      | username             | password   | display                 |
      | admin@phptravels.com | demoadmin  | Dashboard is display    |
      | admin@phptravels.com | demoadmin1 | Dashboard isn't display |

  @exam2_part2
  Scenario: PHP Travels
    Then Verify placeholder is display
    And Email placeholder have text should equal "Email"
    And Password placeholder have text should equal "Password"
    And Verify check box Remember me is checked