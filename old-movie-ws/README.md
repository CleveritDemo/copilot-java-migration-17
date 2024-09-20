# Movie SOAP Service

This project is a SOAP service for managing movie data. It provides operations for creating, updating, deleting, and retrieving movie information.

## Project Structure

```
movie-soap-service
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com
│   │   │   │   └── example
│   │   │   │       ├── service
│   │   │   │       │   └── MovieService.java
│   │   │   │       ├── model
│   │   │   │       │   └── Movie.java
│   │   │   │       └── dao
│   │   │   │           └── MovieDAO.java
│   │   ├── resources
│   │   │   └── META-INF
│   │   │       └── persistence.xml
│   │   └── webapp
│   │       ├── WEB-INF
│   │       │   └── web.xml
│   │       └── wsdl
│   │           └── MovieService.wsdl
├── pom.xml
└── README.md
```

## Files

- `src/main/java/com/example/service/MovieService.java`: This file contains the implementation of the SOAP service for managing movies.

- `src/main/java/com/example/model/Movie.java`: This file defines the `Movie` entity class with the specified fields.

- `src/main/java/com/example/dao/MovieDAO.java`: This file contains the data access object (DAO) for interacting with the movie data.

- `src/main/resources/META-INF/persistence.xml`: This file is the configuration file for the Java Persistence API (JPA).

- `src/main/webapp/WEB-INF/web.xml`: This file is the deployment descriptor for the web application.

- `src/main/webapp/wsdl/MovieService.wsdl`: This file is the WSDL file for the SOAP service.

- `pom.xml`: This file is the Maven project object model (POM) file.

## Building and Running the Service

To build and run the SOAP service, follow these steps:

1. Ensure that you have Java 6 or later installed on your system.

2. Clone this repository to your local machine.

3. Open a terminal and navigate to the project directory.

4. Run the following command to build the project:

   ```
   mvn clean install
   ```

5. Deploy the generated WAR file to a Java EE container of your choice.

6. Access the SOAP service endpoint using a SOAP client tool or by sending SOAP requests programmatically.

For more information on how to use the SOAP service, refer to the `MovieService` class documentation.

```

This file is intentionally left blank.
```