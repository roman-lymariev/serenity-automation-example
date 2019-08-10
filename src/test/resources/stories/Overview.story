Meta:

Narrative:
As a user I want to be able to manage employees from Overview form

Scenario: Employee list is alphabeticaly sorted
Meta:
@issue:XXXX-0001

When admin logs in to application
Then Employee List is alphabeticaly sorted


Scenario: Select Employee with double-click

Given admin logs in to application
When user opens an employee in Employee list
Then Edit Employee form is opened


Scenario: Select Employee with Edit button

Given admin logs in to application
Given user selects an employee in Employee list
When user clicks Edit button
Then Edit Employee form is opened


Scenario: Cancel employee deletion

Given admin logs in to application
Given user gets total Employee count
Given user selects an employee in Employee list
Given user clicks Delete button
When user dismisses alert
Then employee count has not changed


Scenario: Delete employee from Edit Employee

Given admin logs in to application
Given user opens an employee in Employee list
When user clicks Delete button
Then alert is diplayed


Scenario: Delete employee from Overview

Given admin logs in to application
Given user selects an employee in Employee list
When user clicks Delete button
Then alert is diplayed