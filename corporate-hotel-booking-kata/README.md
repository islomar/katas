# Corporate hotel booking kata
https://katalyst.codurance.com/corporate-hotel-booking

## Requirements
1. You need **Maven 3.x** (variables M2_HOME, M2, MAVEN_OPTS, PATH...)
   * https://maven.apache.org/install.html
   * Example in Ubuntu: https://www.vultr.com/docs/how-to-install-apache-maven-on-ubuntu-16-04
2. Install **JDK 13**
   * Recommended: use [SDKMAN](https://sdkman.io/) 
3. Connectivity to the Internet

## How to run the tests
`mvn clean test`

## TO DO
* Actors
    * **Hotel Manager**: Set all the different types of rooms and respective quantities for her hotel.
    * **Company Admin**: Add/delete employees and also create booking policies for her company and employees.
    * **Employee**: Book a hotel room
* Concepts
    * Hotel
    * Room
    * Employee
    * Company policy -> depends on employeeId, roomTypes
    * Employee policy -> depends on employeeId, roomTypes
* Services
    * Hotel service: it requires hotel and room
    * Company service: it requires company and employee
    * Booking policy service: it requires company, employee and room
    * Booking service: it requires employee, hotel, room