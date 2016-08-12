package pl.jcw.demo.cucumber.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName="cucumber-glue")
public class OrderTestParameters {
	public String profile;
	public Double discount;
}
