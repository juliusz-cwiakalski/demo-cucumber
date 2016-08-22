package pl.jcw.demo.cucumber.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "cucumber-glue")
public class OrderTestParameters {

	private Double discount;

	private String profile;

	public Double getDiscount() {
		return discount;
	}

	public String getProfile() {
		return profile;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
}
