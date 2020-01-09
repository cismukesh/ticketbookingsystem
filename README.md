# Cinema Ticket Booking

Display all the seats in the theater and allow users to book it by clicking it. Only one user should be allowed to reserved a specific seat.
If another user clicks a seat that was booked, he should get an error. You must handle the concurrency scenarios and avoid data inconsistency.

Seats can be unbooked by clicking the booked seat again.


Hosting a live solution is encouraged and will increase the chance of scoring higher ratings on this assignment.

The solution should have:

Basic feature of the application should include:

* A single web page with the seats displayed in a grid (you could start by a smaller number of seats, maybe 20-30)

* If a seat is available, the user should be asked for their details like name, email ID, etc and send an email to them with a confirmation


it is a online ticket booking platfor which has follwing functinality.

  - Booking ticket
  - cancel ticket
  - Login/register 


### Tech

project uses a following technology :

* Spring boot - for backend services
* MySql - for database 
* JSP - for front end
* JUnit - for testing

### Installation

project requires Java 8 or above to run , Eclipse IDE and MySql for database .

* Import project as maven project in eclipse
* Right click project in run as maven install, it will install all dependencies (if not getting option then install maven tool from eclipse marketplace in eclipse if needed )
* Configure or put mysql and Email credentials in application.properties file in project
* Now right click on project and run as spring boot project(if not getting option goto market place and install spring sts tool )
* Now goto browser and run http://localhost:9080 it will open home page showing booking tickets
