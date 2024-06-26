Android Automation with Appium, Java, and Cucumber

Introduction-:
This Project is designed to use Appium for Automating Android Application on real device.
The framework used is Cucumber Framework in Java that supports Behavior Driven Development(BDD).

Prerequisites-:

Before begin, ensure you have the following installed on your machine

JDK 21,
Android SDK,
Appium server,
Node.js,
Maven,
An Android device connected to System

Setup-:
1. Clone Repository
    git clone https://github.com/swapnilkumbharkar/MobileAppAutomation.git
2. Ensure Maven is Installed
3. configure device - **_adb devices_**
4. Start Appium server for the given url - http://127.0.0.1:4723
5. Add your device configuration in **_config.properties_** file
6. Build the project

Run-:
To run execute tests use - **_mvn test_**

Reports-:
After the complete execution for the reports refer **test-output** folder

For Scenarios - please refer the **_LoginScenario.feature_** file
Adding Project Structure for reference
       
+---src
|   +---main
|   |   \---java
|   |       \---Features
|   |           \---example
|   |                   App.java
|   |                   
|   \---test
|       +---java
|       |   +---Features
|       |   |       LoginScenario.feature
|       |   |       
|       |   +---Pages
|       |   |       FirstPage.java
|       |   |       LoginPage.java
|       |   |       
|       |   +---Steps
|       |   |       AppSteps.java
|       |   |       BasePage.java
|       |   |       
|       |   \---Utils
|       |           AppUtil.java
|       |           ConfigUtil.java
|       |           TestContext.java
|       |           TestRunner.java
|       |           
|       \---resources
|               Android-MyDemoAppRN.1.3.0.build-244.apk
|               config.properties
|               cucumber.properties
|               
|               
\---test-output
        Cucumber.html
        Cucumber.json

