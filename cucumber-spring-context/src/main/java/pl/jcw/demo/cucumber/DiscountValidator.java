package pl.jcw.demo.cucumber;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class DiscountValidator {

	private final Map<String, Double> discountLimits;

	public DiscountValidator() {
		discountLimits = new HashMap<String, Double>();
		discountLimits.put("Silver", 5.0);
		discountLimits.put("Gold", 10.0);
		discountLimits.put("Platinium", 20.0);
	}

	public void validateDiscount(String profile, double discount) {

		Double discountLimit = discountLimits.get(profile);

		if (discountLimit == null) {
			if (discount > 0) {
				throw new IllegalArgumentException("No discount allowed for profile '" + profile + "'");
			}
		} else if (discount > discountLimit) {
			throw new IllegalArgumentException(profile + " user can have max " + discountLimit + " discount");
		}

	}

}
