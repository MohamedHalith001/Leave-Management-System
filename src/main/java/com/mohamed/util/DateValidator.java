package com.mohamed.util;

import java.time.LocalDate;

public class DateValidator {
	private DateValidator() {
		// Default Constructor
	}

	/**
	 * This method is used to check the given date is not a past date.
	 * 
	 * Returns true if given date comes after present date.
	 * 
	 * @param date
	 * @return boolean
	 */
	public static boolean isValidDate(LocalDate date) {
		boolean valid = true;
		LocalDate today = LocalDate.now();
		if (date.isBefore(today)) {
			valid = false;
		}
		return valid;
	}
}
