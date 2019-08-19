# MapSynq Automation Suite
##### **Developer:** Arka Halder
##### **Important:** *This automation suite has been developed specifically for the application of the SDET role in Quantum Inventions. This code, wholly or partially cannot be used in any test automation requirements.*
## Requirements and Completion Status
As per the problem statement, please find corresponding remarks beside each of the mentioned requirements.
### SDET coding challenge
Here you are! We're ecstatic that you're interested in working for Quantum Inventions's QA team. To get a better idea of your current automation skills, we'd like you to complete a code challenge - build automation according to a set of requirements. The actual requirements are listed further down, but here are the general tech requirements:
- Write your code in any programming language of your choice. **(I have used Java)**
- Make sure your app is runnable not only on Windows, but on Mac OS X and Linux as well. **(This feature has been implemented)**
- Do not require any for-pay software **(No paid tool has been used)**
- Include instructions for setting up and running your application **(This information has been provided in this document)**
- Containerized app is a plus **(This feature has not been implemented due to time constraint)**
#### Description 
Write tests to load the Mapsynq (http://www.mapsynq.com) website, design and implement all important test cases (be ready to explain importance). 
**Complete the assignment as you would do for the real-life production environment.**
#### Automation requirements
- The automation must run via the UI within a browser **(This feature has been implemented)**
- Your solution must produce a detailed and clean report file **(This feature has been implemented)**
#### Functional requirements
- Tests are runnable from the command line **(This feature has been implemented)**
- Tests are run against a configurable host, use http://www.mapsynq.com as the default **(This feature has been implemented)**
- Tests can be configured to run on a various browser and OS combinations against a testing service **(This feature has been partially implemented)**
- Testing service credentials and all configuration settings are passed as environment variables **(This feature has been implemented)**
- Tests are run in parallel **(This feature has been implemented)**
#### Bonus
- Tests run against mobile browsers **(This feature has not been implemented due to time constraint)**
- Tests run headlessly **(This feature has not been implemented due to time constraint)**
- Tests capture screenshots of failures  **(This feature has been implemented)**
## Prerequisites for Execution
Irrespective of the operating system on which this suite will be run, the following softwares/tools must be installed and setup properly before execution.
1. JDK 8 **(The environment path variable must be set)**
2. Maven 3.5.4 **(The environment path variable must be set)**
3. Git 2.14.1 **(The environment path variable must be set)**
4. Allure Commandline Tool **(I used Node.js to install it)**
4. Intellij Idea 2019.2 Community Edition
## Cloning, Execution and Reporting
* To clone this repository, please type `git clone https://github.com/chego25/MapSynq.git` in the terminal or command prompt and press `enter` after navigating into the desired directory.
* To execute the suite from command line, navigate into the suite directory in the terminal or command prompt, then type `mvn test -Dbrowser=<BROWSER>` and press `enter`. Valid values for the parameter `<BROWSER>` are `chrome`, `firefox`, `ie`, `edge` and `safari`. However, for Microsoft Edge and Apple Safari Browsers, the suite will throw an `org.openqa.selenium.UnsupportedCommandException` mentioning that, `Microsoft Edge Browser is not supported` or `Apple Safari Browser is not supported` respectively. That's why it has been mentioned that, the Cross-Browser feature has been partially implemented. If the `browser` parameter is not supplied in the command, the suite will also throw the same exception with message `Environment Variable 'browser' contains an invalid value: null`.
* To view the generated test report after execution, please type `allure serve allure-results` and press `enter` in the terminal or command prompt. The report will be displayed in the system's default browser.