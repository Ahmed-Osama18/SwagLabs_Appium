# SwagLabs - Appium 
![Logo](https://www.saucedemo.com/static/media/Login_Bot_graphic.20658452.png)

 Testing some test cases for SwagLabs APK with appium using java and selenium while adding shaft in the pom.xml to get the reporting features and more. :robot:



 ## :dart:Test Cases


 - Login with valid username and passowrd.:smile:
 - Login with valid email and invalid password.:confused:
 - Add Any Item to the cart and validate that Title and price of the Item at Home page equals the item and price at the cart.
 - Validate Removing Items from the cart and validate that the cart is empty.
 - Online Ordering and complete the flow from adding element to cart till the checkout, Also Validate the price and success purchase.




## :star2:Features

- Implemented modular design by using the Page Object Model design pattern. :boom:
- Creating an automated test execution report
- Attaching a screenshot to the report
- External Test Data
- Documented code



## :gear:Installation

  - [@Maven](https://mvnrepository.com/)
  - [@Node.js](https://nodejs.org/en/download/)
  - [@Appium](https://github.com/appium/appium-desktop/releases/tag/v1.22.3-4)
  - [@Appium-Inspector](https://github.com/appium/appium-inspector/releases) :robot:
  - [@SwagLabs-Apk](https://github.com/saucelabs/sample-app-mobile/releases/download/2.2.0/Android.SauceLabs.Mobile.Sample.app.2.2.0.apk)
  - [@SHAFT_ENGINE](https://github.com/ShaftHQ/SHAFT_ENGINE)
        Due to a known issue with IntelliJ you need to edit your run configuration templates before running your tests by following these steps:
    - Open 'Edit Run/Debug Configurations' dialog > Edit Configurations... > Edit configuration templates...
    - Select TestNG > Listeners > and add these listeners one by one:
        com.shaft.tools.listeners.AlterSuiteListener, com.shaft.tools.listeners.SuiteListener, com.shaft.tools.listeners.InvokedMethodListener

## :blush:Author

- [@AhmedOsama](https://github.com/Ahmed-Osama18)