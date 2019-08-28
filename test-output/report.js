$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/Saumya/SeleniumAutomation/GPSBDDFramework/src/main/java/com/gps/qa/Features/login.feature");
formatter.feature({
  "line": 1,
  "name": "GPS Login Feature",
  "description": "",
  "id": "gps-login-feature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 10884486285,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "GPS Login Test Scenario",
  "description": "",
  "id": "gps-login-feature;gps-login-test-scenario",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@RegressionTest"
    },
    {
      "line": 3,
      "name": "@End2End"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "launch the browser and open the application",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user enters the credentials",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "user clicks on login button",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefiniton.launch_the_browser_and_open_the_application()"
});
formatter.result({
  "duration": 3286105368,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefiniton.user_enters_the_credentials()"
});
formatter.result({
  "duration": 858248274,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefiniton.user_clicks_on_login_button()"
});
formatter.result({
  "duration": 2985591128,
  "status": "passed"
});
formatter.after({
  "duration": 907553278,
  "status": "passed"
});
});