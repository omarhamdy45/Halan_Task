@Login


Feature: Login to ismile on
  Scenario: User not able to login with invalid email and invalid password
  Given user navigate to login page
  When  user fill invalid email and invalid password
  And   user press login
  Then  Error message displayed