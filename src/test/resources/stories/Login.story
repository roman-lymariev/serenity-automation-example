Meta:

Narrative:
As a user I want to be able to log in and log out from the application

Scenario: Application is reachable

When application URL is opened in browser
Then Login form is opened


Scenario: Trying to login with invalid credentials

Given application URL is opened in browser
Given credentials are entered: <login> <password>
When user submits credentials
Then Login form is opened

Examples:
| login   | password   |
|         | Skywalker  |
|         |            |
| Luke    |            |
| Luke    | password   |
| login   | Skywalker  |
| login   | password   |


Scenario: User is notified about invalid credentials

Given application URL is opened in browser
Given credentials are entered: login1 password1
When user submits credentials
Then user is notified about invalid credentials


Scenario: Login with valid credentials

Given application URL is opened in browser
Given credentials are entered: Luke Skywalker
When user submits credentials
Then Overview form is opened