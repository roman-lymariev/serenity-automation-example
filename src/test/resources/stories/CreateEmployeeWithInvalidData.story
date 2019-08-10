Meta:

Narrative:
As a user I want to have negative cases processed correctly

Scenario: Try creating duplicated Employee
Meta:
@issue:XXXX-0003

Given admin logs in to application
Given user clicks Create button
Given user fills in details for employee_2
Given user clicks Add button
Given user gets total Employee count
Given user clicks Create button
Given user fills in details for employee_2
When user clicks Add button
Then New Employee form is still opened


Scenario: Try creating Employee with an empty field

Given admin logs in to application
Given user gets total Employee count
Given user clicks Create button
Given user fills in Employee details as follow: <firstName> <lastName> <startDate> <userEmail>
When user clicks Add button
Then New Employee form is still opened
When user clicks Cancel button
Then employee count has not changed

Examples:
| firstName | lastName | startDate  | userEmail    |
|           | Last     | 2019-01-01 | fl@test.com  |
| First     |          | 2019-01-01 | fl@test.com  |
| First     | Last     |            | fl@test.com  |
| First     | Last     | 2019-01-01 |              |


Scenario: Try creating Employee with invalid Start Date

Given admin logs in to application
Given user gets total Employee count
Given user clicks Create button
Given user fills in details for employee_2
Given user sets Employee start date to <startDate>
When user clicks Add button
Then alert is diplayed
When user accepts alert
Then New Employee form is still opened
When user clicks Cancel button
Then employee count has not changed

Examples:
| startDate   |
| 2017/01/01  |
| 2000 A.D.   |
| 1899-12-31  |
| 2101-01-01  |
| 2019-13-01  |
| 2019-12-32  |


Scenario: Try creating Employee with invalid Email
Meta:
@issue:XXXX-0004

Given admin logs in to application
Given user gets total Employee count
Given user clicks Create button
Given user fills in details for employee_2
Given user sets Employee email to <userEmail>
When user clicks Add button
Then New Employee form is still opened
When user clicks Cancel button
Then employee count has not changed

Examples:
| userEmail               |
| plainaddress            |
| @domain.com             |
| email.domain.com        |
| multi..dots@domain.com  |
| double@sign@domain.com  |
