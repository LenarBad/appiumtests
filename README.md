# APPIUMTESTS

Solution for Penn Interactive Assessment

## Configuration

 - desired-capabilities.properties contains configuration info for the device and application
 ```
 platformName=ANDROID
 version=10
 deviceName=emulator-5554
 automationName=UiAutomator2
 noreset=true
 appPackage=org.wikipedia.dev
 appActivity=org.wikipedia.main.MainActivity
 app=D:\\penn-interactive-assessment\\app-dev-debug.apk
 ```
 Put _app-dev-debug.apk_ into the folder **D:\penn-interactive-assessment**\ or update _app_ accordingly
 
 - test.properties contains the appium server url
 
## How To Run

You can run the test from IDE or with the Maven command `mvn clean test`

## Possible Improvements

 - Add proper logging
 - Add possibility to set configuration parameters or at least some of them specific for particular environments with the Maven command