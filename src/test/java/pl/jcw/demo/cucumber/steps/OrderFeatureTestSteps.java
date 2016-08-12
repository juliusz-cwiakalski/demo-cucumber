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
	 * This is business bean under tests - created with singleton scope
	 */
	@Autowired
	private DiscountValidator validator;

	/**
	 * Test object used to pass data between steps - spring creates new instance
	 * for every scenario execution -> setup
	 * by @Scope(scopeName="cucumber-glue") or in xml context configuration
	 */
	@Autowired
	private OrderTestParameters parameters;

	@Given("^User have profile '(.*)'$")
	public void userHaveProfile(String profile) throws Throwable {
		assertThat(this.parameters.profile).isNull();
		this.parameters.profile = profile;
	}

	@When("^he creates order with discount '(\\d+)'$")
	public void heCreatesOrderWithDiscountDiscount(double discount) throws Throwable {
		assertThat(this.parameters.discount).isNull();
		this.parameters.discount = discount;
	}

	@Then("^then order is processed$")
	public void thenOrderIsProcessed() throws Throwable {
		validator.validateDiscount(this.getProfile(), this.getDiscount());
	}

	@Then("^order is rejected with error '(.*)'$")
	public void orderIsRejectedWithError(String errorMessage) throws Throwable {
		Exception validationError = null;
		try {
			validator.validateDiscount(this.getProfile(), this.getDiscount());
		} catch (Exception e) {
			validationError = e;
		}
		assertThat(validationError).as("Correct error is thrown from discount validator").hasMessage(errorMessage);
	}

	private String getProfile() {
		return this.parameters.profile;
	}

	private double getDiscount() {
		return this.parameters.discount;
	}
}
