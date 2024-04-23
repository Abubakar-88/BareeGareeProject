
Feature: Looking Vehicles of online MarketPlace
As a Customer 
I am looking a car
So that I can find exclusive car

Scenario Outline: Customer can be Looked a car with successfully
  Given I am on the homepage
  When Satisfy that homepage is visible
  Then I enter "car" in the search bar
  And I click the search button
  Then I should see search results related of car
  And  I click on Toyota Axio car name
  Then I should see the following information in the car details
    | name                | value      |
    | Condition           |  New       |
    | Brand               | Toyota     |
    | Transmission        | Automatic  |
    | Edition             | 2020       |
    | EngineCapacityCC    | 1500       |
    | ManufectureYear     | 2020       |
    | MileageKM           | 1000       |
    | RegistrationYear    |2022        |
    | BodyType            |Coupe/Sports|
    | FuelType            |Diesel      |
    |IsNegotiable         |No          |

  And I click on the Signup Menu
  Then I click on the General User of dropdown menu
  And I should see the "Sign Up General User" title on the signup page
  And I fill out the signup form with data from "<SheetName>" and <RowNumber>
  And I fill first name
  And I fill last name
  Then I fill userName
  And I fill email
  And I fill mobile number
  And I fill whatsapp number
  And I select district name
  And I select thana name
  And I fill password
  And I fill confirm password
  And I agree with the terms and conditions
  Then I click on the Sign Up button
  
  Examples:
  |SheetName | RowNumber |
  |bareegaree |  0       |
