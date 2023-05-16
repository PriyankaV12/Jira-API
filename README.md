# Jira API Test Automation

This project is specifically designed to facilitate comprehensive API testing of Jira, the renowned issue and project tracking software. The goal is to provide a reliable and efficient testing solution to ensure the seamless functioning of Jira's API endpoints.

# Prerequisites
1. Java 8 or higher
2. Maven 3.9.1 or higher
3. Google Chrome (for downloading ChromeDriver)
# Jenkins Integration
This project provides seamless integration with Jenkins, enabling you to incorporate automated API testing into your CI/CD pipelines.

To integrate this project with your Jenkins pipeline:

1. **Checkout**: This stage fetches the latest code from the specified Git repository using the GitSCM plugin. It checks out the code from the main branch of the GitHub repository specified in the url.

2. **Initialize**: This stage sets up the necessary environment variables for the pipeline. It echoes the values of PATH and M2_HOME environment variables, providing visibility into their configuration.

3. **Download ChromeDriver**: This stage downloads and extracts the required ChromeDriver for running tests that depend on it. It uses curl to download the chromedriver_mac64.zip file from the specified URL.
It extracts the contents of the zip file to the current directory. It grants executable permissions to the chromedriver binary.

4. **Create secrets.yaml**: This stage creates a secrets.yaml file and populates it with the necessary credentials obtained from Jenkins credentials. It creates an empty secrets.yaml file in the src/main/java/myResources/ directory.
It writes the baseURI, username, and password values obtained from Jenkins credentials into the secrets.yaml file.

5. **Run Tests**: This stage executes the tests using the Maven build tool. It lists the files and directories in the current directory using ls -al.
It runs the Maven command mvn test to execute the test suite.

# YAML File
The project uses a YAML file to derive values to be used in the test cases. The file is located in the src/main/java/myResources directory.

# Conclusion
This project offers API testing solution for Jira. With its comprehensive test cases, including commenting, adding attachments, and verifying issue details, it ensures the reliability and functionality of Jira's API. 

The use of YAML files allows for easy customization and dynamic configuration during runtime, enhancing flexibility and maintainability. Integrating this project into Jenkins pipelines further facilitates continuous testing and seamless integration with your CI/CD processes. 

