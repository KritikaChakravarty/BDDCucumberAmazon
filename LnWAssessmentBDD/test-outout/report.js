$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("/Users/kritikachakravarty/eclipse-workspace/Kritika/LnWAssessmentBDD/src/main/java/Features/Login.feature");
formatter.feature({
  "line": 1,
  "name": "Deal data creation",
  "description": "",
  "id": "deal-data-creation",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Free CRM Create a new deal scenario",
  "description": "",
  "id": "deal-data-creation;free-crm-create-a-new-deal-scenario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "user is on amazonpage",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "title of login page is amazon",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDefinition.user_is_on_amazonpage()"
});
formatter.result({
  "duration": 472744194,
  "error_message": "java.lang.IllegalStateException: The driver executable does not exist: /Users/kritikachakravarty/eclipse-workspace/Kritika/LnWAssessmentBDD/Users\\kritikachakravarty\\Downloads\\chromediver\n\tat com.google.common.base.Preconditions.checkState(Preconditions.java:585)\n\tat org.openqa.selenium.remote.service.DriverService.checkExecutable(DriverService.java:146)\n\tat org.openqa.selenium.remote.service.DriverService.findExecutable(DriverService.java:141)\n\tat org.openqa.selenium.chrome.ChromeDriverService.access$000(ChromeDriverService.java:35)\n\tat org.openqa.selenium.chrome.ChromeDriverService$Builder.findDefaultExecutable(ChromeDriverService.java:159)\n\tat org.openqa.selenium.remote.service.DriverService$Builder.build(DriverService.java:355)\n\tat org.openqa.selenium.chrome.ChromeDriverService.createDefaultService(ChromeDriverService.java:94)\n\tat org.openqa.selenium.chrome.ChromeDriver.\u003cinit\u003e(ChromeDriver.java:123)\n\tat stepDefinitions.LoginStepDefinition.user_is_on_amazonpage(LoginStepDefinition.java:23)\n\tat ✽.Given user is on amazonpage(/Users/kritikachakravarty/eclipse-workspace/Kritika/LnWAssessmentBDD/src/main/java/Features/Login.feature:5)\n",
  "status": "failed"
});
formatter.match({
  "location": "LoginStepDefinition.title_of_login_page_is_amazon()"
});
formatter.result({
  "status": "skipped"
});
});