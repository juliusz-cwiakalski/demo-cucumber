# demo-cucumber
Simple project do demonstrate features of cucumber and possibilities to integrate with other frameworks

You can checkout with Git or SVN using web URL: https://github.com/juliusz-cwiakalski/demo-cucumber.git
You can also download zip file from repository webpage: https://github.com/juliusz-cwiakalski/demo-cucumber

It's maven project - you can run tests from command line using standard `mvn test` 
or just import to your favourite IDE and run junits.

## Most interesting files in project cucumber-spring-context

| File                                                                | Description                                                                                                                |
|---------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------|
| src/test/resources/premium_users_discount.feature                   | Example feature description using Gherkin language                                                                         |
| src/test/java/pl/jcw/demo/cucumber/FeaturesTest.java                | JUnit test that runs feature test                                                                                          |
| src/test/java/pl/jcw/demo/cucumber/TestContextConfiguration.java    | Spring test context configuation                                                                                           |
| src/test/java/pl/jcw/demo/cucumber/steps/OrderFeatureTestSteps.java | Scenarios steps implementation (glue code)                                                                                 |
| src/test/java/pl/jcw/demo/cucumber/model/OrderTestParameters.java   | POJO used to pass test data between steps - instantiated by Spring using 'cucumber-glue' scope (one instance per scenario) |

