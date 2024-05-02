# Android Cucumber Testing

## Project Setup Instructions
To setup the project, make sure that you have installed
1. Android Studio (This one will needed to run the Android Virtual Machine)
2. Maven (To check if this already installed, you can type command `mvn -v` in your terminal)
3. Appium (To check if this already installed, you can type command `appium` in your terminal)
4. UiAutomator2 Appium Plugin (To check if this already installed, see the appium server when running, the log should be like this)
```
[Appium] Available drivers:
[Appium]   - uiautomator2@3.1.0 (automationName 'UiAutomator2')
```

## Run Project Instructions
To run the project, follow these steps:
1. Start appium server using command `appium` in your terminal
2. Run the Android Virtual Machine from Android Studio
3. Change the constant `APP` in the `StepDefinitions.java` file to the directory where the apk is located
4. Run the project using command `mvn clean test` in your terminal