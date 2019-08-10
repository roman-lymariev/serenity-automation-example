Meta:
Narrative:
As a user I want to perform create, edit and delete employees


Scenario: Add Employee

Given admin logs in to application
Given user gets total Employee count
Given user clicks Create button
Given user fills in details for employee_1
When user clicks Add button
Then employee count has incremented


Scenario: Edit Employee

Given admin logs in to application
Given user gets total Employee count
Given user selects employee_1 in list
Given user clicks Edit button
Given user fills in details for employee_1_edit
When user clicks Update button
Then employee count has not changed
When user double-clicks employee_1_edit in list
Then details for employee_1_edit are displayed


Scenario: Delete Employee
Meta:
@issue:XXXX-0002

Given admin logs in to application
Given user gets total Employee count
Given user selects employee_1_edit in list
Given user clicks Delete button
When user accepts alert
Then employee count has decremented