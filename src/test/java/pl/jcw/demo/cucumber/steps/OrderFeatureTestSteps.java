package pl.jcw.demo.cucumber.steps;

import static org.fest.assertions.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pl.jcw.demo.cucumber.DiscountValidator;
import pl.jcw.demo.cucumber.TestContextConfiguration;
import pl.jcw.demo.cucumber.model.OrderTestParameters;

@ContextConfiguration(classes = { TestContextConfiguration.class })
public class OrderFeatureTestSteps {

	/**
	 * Test object used to pass data between steps - spring creates new instance
	 * for every scenario execution -> setup
	 * by @Scope(scopeName="cucumber-glue") or in xml context configuration
	 */
	@Autowired
	private OrderTestParameters parameters;

	/**
	 * This is business bean under tests - created with singleton scope
	 */
	@Autowired
	private DiscountValidator validator;

	@When("^he creates order with discount '(\\d+)'$")
	public void heCreatesOrderWithDiscountDiscount(double discount) throws Throwable {
		this.parameters.setDiscount(discount);
	}

	@Then("^order is rejected with error '(.*)'$")
	public void orderIsRejectedWithError(String errorMessage) throws Throwable {
		Exception validationError = null;
		try {
			validator.validateDiscount(this.parameters.getProfile(), this.parameters.getDiscount());
		} catch (Exception e) {
			validationError = e;
		}
		assertThat(validationError).as("Correct error is thrown from discount validator").hasMessage(errorMessage);
	}

	@Then("^then order is processed$")
	public void thenOrderIsProcessed() throws Throwable {
		validator.validateDiscount(this.parameters.getProfile(), this.parameters.getDiscount());
	}

	@Given("^User have profile '(.*)'$")
	public void userHaveProfile(String profile) throws Throwable {
		this.parameters.setProfile(profile);
	}

}
