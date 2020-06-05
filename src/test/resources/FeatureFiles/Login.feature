Feature: Login


To perform successful login 
As a user I want to 
Enter correct username and password

@tag2
Scenario: In order to verify log in to Expedia

         Given user navigates to Expedia website
         When user verifies the homepage title
         Then user click on logIn button
         Then user enter the username and password
         
         |username|password|
         |tffs.s.chakra@gmail.com|Recurtion2040$|
        
         Then user click on button in LogIN page
         Then the user should be successfully logged in
         
         