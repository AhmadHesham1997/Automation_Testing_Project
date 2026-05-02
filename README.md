
Automation Testing Project EYOUTH
(Selenium + TestNG)

Description: Automate the following functionalities on the EYOUTH website (Home- eyouth) using Selenium WebDriver, TestNG, and Page Object Model (POM).
Notes: Use Page Object Model (POM). Use explicit waits where necessary and avoid using Thread.sleep(). Write meaningful assertions for all test cases.
 
Test Case #1: Search with a valid keyword
•	Locate the search input field from the side menu or header
” كيف تنضم إلى البنكkeyword:” Enter  •
•	Click Search
•	Assert The page title contains “البنك إلى تنضم كيف”




Test Case #2: Open course details
•	From the side menu or header, select all courses “الدورات جميع”
•	From the Courses page, select any course
•	Click on the course card
•	Assert the course details page opens
•	Assert the section “التدريبية الدورة حول” is displayed




Test Case #3: Open registration page
•	Click on “لنا انضم”
•	Assert the URL contains /signup




Test Case #4: Register with an empty username field
•	Enter all data except the username field
•	Click “انشاء”
•	Assert validation error message are displayed “مطلوب المستخدم اسم”
 
Test Case #5: Login with invalid credentials
•	Open the login page
•	Enter an invalid username and password
•	Click Login
•	Assert error message is displayed




Test Case #6: Login with empty fields
•	Leave username and password empty
•	Click Login
•	Assert that the required fields' validation messages appear




Test Case #7: end-to-end
•	log in to the website
•	From the side menu or header, click all courses
•	Subscribe to any course
•	Assert that your card will contain the selected course
Note that:
-	The user must be logged in with valid credentials
-	Data can be hardcoded or read from config




Test Case #8: Verify Facebook link
•	Scroll to the footer
•	Click on the Facebook icon
•	Assert URL contains facebook.com
 
Test Case #G: Verify LinkedIn link
•	Navigate to the footer
•	Click on the LinkedIn icon
•	Assert URL contains linkedin.com




Test Case #10: Verify YouTube link
•	Navigate to the footer
•	Click on the YouTube icon
•	Assert the new tab URL contains youtube.com




Test Case #11: Verify course cards UI
•	Open Courses page
•	Assert that the course card contains (only one card):
o	Course image
o	Course title
o	Instructor name
o	subscribe button




Bonus (Optional):
•	Generate an Allure Report for the test execution.
•	The report should include test cases, steps, and execution results.
 
Submission Instructions:
•	Create a new GitHub repository for this project named: automation-testing-project.
•	Push your complete project to the repository.
•	Make sure your repository is set to Public.
•	Send your repo link via email to: Soadmagdy.route@gmail.com
•	Please make sure to strictly follow the email subject format below when sending your task:

