# LoanApplication

Description: This is a Spring boot project with simplified solution for customers to apply for loan. There are two modules in this application, they are user module which include register, login and log out functions, and loan application module which include doing application and viewing application functions. There are two roles in this application, Customer and Adviser. Customer can send appliction form, and Adviser and view all the applications.

Technology:Java 8, Spring boot, Maven

Database: Mysql

Implementation of authentication and authorization mechanisms：

There are register, login and logout functions in this application to ensure that only authorized users can access the API, and only adviser role can view all the applications, and only customers can apply for loan.

MD5 encyption is adopted in ensuring the security of user password and Token cache is used to store the user information, when a cutomer do a loan application, customer user name is taken from session as the customer_ssn for application.

How to deploy and run the application:

Step 1. Install Idea, Java 8, maven, Mysql 8, git

Step 2. Git clone code to your working folder

Step 3. Install all the maven denpendency

Step 4. Modify the "application.propertise" file, set the database connection information as your own.

Step 5. Run the application

How to do the test:
Find the "test" folder, all the unit test is in the folder, run the unit test methods.
I used postman for integration test, for more details of how to call the API, please see the API document.

