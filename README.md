# clipboardhealth_auto

**Amazon assessment**

**Summary:**
A web automation project to automate Amazon website and select samsung television with the second-highest cost to retrieve the product details.

**Requirements:**
In order to utilise this project you need to have the following installed locally:

* Java 11
* IDE
* Maven 3
* Libraries used
* Maven build tool
* Selenium 4
* TestNG
* Log4j
* Extent report
* Webdriver Manager

**Usage:**
To run the clipboardhealth_auto project clone it from the github URL and run the below command in the terminal of your IDE.
As maven-surefire-plugin is also added in the pom.xml all the dependencies will be automatically downloaded and would start executing the testng.xml:

UI tests use Chrome by default, it can be changed by passing firefox, safari from the testng.xml in the browser parameter value

**mvn clean install**

Alternatively, you can also run by executing the testNG.xml

**Report:**
Test results for each test are written into reports directory under the name ch_report.html
