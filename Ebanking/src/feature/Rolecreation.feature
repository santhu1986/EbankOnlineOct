Feature: Role Creation Functionality

Scenario Outline: Role Creation with Multiple sets of Data

Given Tester Should on Ranford Home Page

When Tester enters Username and Password

Then Tester Click on Role button

When Tester click on New Role and enter "<RoleName>" and "<RoleType>"

When Tester Close the Application

Examples:

         | RoleName | RoleType |
         | ClerkHYDbrnch | E |
         | PoHYDbrnch | E |
         | CashierHYDbrnch | E |