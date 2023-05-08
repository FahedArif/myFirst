Feature: Application Login
Scenario: Loigin with valid credintials
Given open my Browsre
And Navigate to Login page
When user enters username as "arif@gmial.com" and password as "Arif@123" into the feilds
And user click on login button
Then verify user is able to successfully login
