package pl.jcw.demo.cucumber;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:premium_users_discount.feature" }, //
		glue = { "pl.jcw.demo.cucumber.steps" }, //
		snippets = SnippetType.CAMELCASE)
@ContextConfiguration(classes = { TestContextConfiguration.class })
public class FeaturesTestRunner {
}
