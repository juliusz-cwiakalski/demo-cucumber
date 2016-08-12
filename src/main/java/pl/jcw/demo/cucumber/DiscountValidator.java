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

		// validateDiscountNotGreater(discount, discountLimit, errorMsg);
		//
		// switch (profile) {
		// case "Silver":
		// validateDiscountNotGreater(discount, 5, "Silver user can have max 5
		// discount");
		// break;
		// case "Gold":
		// validateDiscountNotGreater(discount, 10, "Gold user can have max 10
		// discount");
		// break;
		// case "Platinium":
		// validateDiscountNotGreater(discount, 20, "Platinium user can have max
		// 20 discount");
		// break;
		// default:
		// validateDiscountNotGreater(discount, 0, "No discount allowed for
		// profile '" + profile + "'");
		// }

	}

	private void validateDiscountNotGreater(double current, double max, String errorMsg) {
		if (current > max) {
			throw new IllegalArgumentException(errorMsg);
		}
	}
}
