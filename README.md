# peopleai
test ai speed development

Sure, if your Spring application is built using Maven instead of Gradle, the instructions for running the application locally would be slightly different. Here's how you can run the application using Maven:

Running the Application Locally with Maven:

    Clone the Repository: Begin by cloning the application's Git repository to your local machine using the command git clone <repository_url>.

    Navigate to Project Directory: Open a terminal window and navigate to the root directory of the cloned project using the cd command.

    Build the Application: Run the command mvn clean install to build the project. This will compile the code, run tests, and package the application.

    Run the Application: Once the build is successful, run the command mvn spring-boot:run to start the Spring Boot application. It will start an embedded server, and you should see logs indicating that the application is running.

    Access the Endpoint: With the application running, open a web browser or a tool like curl or Postman. Access the endpoint by making a GET request to http://localhost:8080/countries with appropriate query parameters.

Examples of Using the Endpoint:
Here are ten examples of how to use the developed /countries endpoint:

    Retrieve all countries: GET /countries
    Retrieve countries with a specific name: GET /countries?country=United
    Retrieve countries with a population less than 100 million: GET /countries?population=100
    Retrieve and sort countries in ascending order: GET /countries?sortOrder=ASC
    Retrieve and sort countries in descending order: GET /countries?sortOrder=DESC
    Retrieve top 5 countries by population: GET /countries?limit=5
	Retrieve top 2 countries by population: GET /countries?limit=2
    Retrieve countries with default sorting and limit: GET /countries?sortOrder=DEFAULT&limit=10
    Retrieve countries with a name containing "Republic" and population less 1 million: GET /countries?country=Republic&population=1
    Retrieve countries with no filter but limited to 3 results: GET /countries?limit=3
