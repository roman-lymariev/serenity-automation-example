# SERENITY-AUTOMATION-EXAMPLE

This is an example test automation solution, testing a simple website. 
It is powered by SerenityBDD with Maven, jBehave and Selenium.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

### Prerequisites

The solution is OS-independent. You will need the following: 

* [installed and configured Java] (https://java.com/en/download/help/download_options.xml)
* [installed and configured Maven](https://maven.apache.org/install.html)
* [installed Chrome browser] (https://www.google.com/chrome/)
* [downloaded chromedriver.exe (depending on installed Chrome version)] (https://chromedriver.chromium.org/downloads)

### Installing

 - download the solution
 - open download folder
 - copy chromedriver.exe there


## Running the tests

To run the automated tests, go to the solution download folder, open command line (cmd, shell, etc) and run command:
```
mvn clean install
```

After execution is finished, you can open HTML report located in /target/site/serenity/ folder. There, you need to open index.html file.


## Built With

* [SerenityBDD](https://www.thucydides.info) - The framework used
* [Maven](https://maven.apache.org/) - Dependency Management

I used SerenityBDD framework because as this is currently my framework of choice. 
SerenityBDD supports SeleniumWebdriver, has functional and fancy HTML report and uses convention-over-configuration approach, all out-of-the box. 
That means that powerful, scalable and maintainable automated test solution can be set up really quick. For instance, I was able to implement 50 automated tests in ~20 hrs.    


## Solution Composition

This framework is built to store test data, scenarios and implementation separately, with OOP and SOLID in mind. 
The goal is to have a maintainable and reusable test solution, that starts small and scales up later.

test data - stored separately from code, in /resources-filtered/ folder as .properties.
stories - test scenarios written in Gherkin and stored in .story files. I prefer jBehave implementation. Stored in /resources/stories/
story - blank Java classes, one for each .story file. Allow jUnit test runner to pick stories.
steps - stored in the /java/framework/steps/ folder. This is essentially a glue code between Stories and PageObject implementation.
pages - essentialy PageObjects, here you interact with tested application website via Selenium. Here, each Page represents one website page/frame/etc.

Also, the solution contains lots of little goodies, like methods to work with cookies or angular, but the list would be too lenghty to mention it here.


##Tested Application 

Application under test is a small website with the following features:

1. The application allows you to login with a username and a password
2. The application displays a list of employees in a café. Details about
	each employee can be viewed by double clicking on the employee name
3. Employees can be added to the list of employees by adding their first
	and last names, start date (format YYYY-MM-DD) and email
4. Employee data can be changed by clicking on Edit
5. Employee data can be deleted by clicking on Delete
6. Users can log out from the application


##Test Coverage

I decided to cover the following:

- Login and Logout, including attempts to login with invalid credentials. Critical features.
- Employee management - create, edit and delete, main features naturaly. 
- Overview - to cover navigation across application via clicks, double-clicks and buttons.
- Create and Edit employee with invalid data - negative cases ensuring invalid inputs are processed correctly. Not the highest priority, but still important.

What was out of scope:
- Elements labels text - considered lesser priotity
- Warning messages text - also considered lesser priority, though I would create some bugs about some invalid Alert text 


##Test Results

11 of 50 tests were failed. The issues found are:

- After deleting an employee, Overview contains duplicated records. Workaround: to reload page.
- Application allows emails with multiple dots in a row (such emails are invalid).
- User is auto-redirected to Overview on attempt to edit Employee with invalid info. Expected: to stay on Edit form.
- Application allows to add duplicated Employees (though it was not in given features).
- Employee list is not sorted (though it was not in given features)

also:
- Alert text is invalid when attempting to create an Employee with invalid Start Date.


## Author

* **Roman Lymariev**


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details


## Acknowledgments

* Hat tip to all brilliant individuals I had a pleasure to work with and learn from.


