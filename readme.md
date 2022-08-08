Amazon assessment

**Summary**: A web automation project to automate Amazon website and select samsung television with the second-highest cost to retrieve the product details.

Requirements In order to utilise this project you need to have the following installed locally:

1. Java 11
2. IDE
3. Maven 3

UI tests use Chrome by default, it can be changed by passing firefox, safari from the testng.xml in the browser parameter value

**Libraries used**
* Maven
* Selenium 4
* TestNG
* Log4j
* Extent report
* Webdriver Manager
* Maven surefire

**Usage**
To run the clipboardhealth_auto project clone it from the github URL and run the below command in the terminal of your IDE. As maven-surefire-plugin is also added in the pom.xml all the dependencies will be automatically downloaded and would start executing the testng.xml:

mvn clean install

Alternatively, you can also run by executing the testNG.xml

**Report**
Test results for each test are written into reports directory with the name ch_report.html