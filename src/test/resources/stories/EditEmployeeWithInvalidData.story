Meta:

Narrative:
As a user I want to have negative cases processed correctly


Scenario: Try updating Employee with an empty field

Given admin logs in to application
Given user opens an employee in Employee list
Given user fills in Employee details as follow: <firstName> <lastName> <startDate> <userEmail>
When user clicks Update button
Then Edit Employee form is still opened

Examples:
| firstName | lastName | startDate  | userEmail    |
|           | Last     | 2019-01-01 | fl@test.com  |
| First     |          | 2019-01-01 | fl@test.com  |
| First     | Last     |            | fl@test.com  |
| First     | Last     | 2019-01-01 |              |


Scenario: Try updating Employee with invalid Start Date
Meta:
@issue:XXXX-0005

Given admin logs in to application
Given user opens an employee in Employee list
Given user sets Employee start date to <startDate>
When user clicks Update button
Then Edit Employee form is still opened

Examples:
| startDate   |
| 2017/01/01  |
| 2000 A.D.   |
| 1899-12-31  |
| 2101-01-01  |
| 2019-13-01  |
| 2019-12-32  |


Scenario: Try updating Employee with invalid Email
Meta:
@issue:XXXX-0006

Given admin logs in to application
Given user opens an employee in Employee list
Given user sets Employee email to <userEmail>
When user clicks Update button
Then Edit Employee form is still opened

Examples:
| userEmail               |
| plainaddress            |
| @domain.com             |
| email.domain.com        |
| multi..dots@domain.com  |
| double@sign@domain.com  |