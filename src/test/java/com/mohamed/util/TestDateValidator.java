package com.mohamed.util;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestDateValidator {

	@Test
	public void testIsValidDateWithValidDate() {
		String date = "2022-06-01";
		LocalDate checkDate = LocalDate.parse(date);
		boolean result = DateValidator.isValidDate(checkDate);
		assertTrue(result);
	}

	@Test
	public void testIsValidDateWithInvalidDate() {
		String date = "2000-06-01";
		LocalDate checkDate = LocalDate.parse(date);
		boolean result = DateValidator.isValidDate(checkDate);
		assertFalse(result);
	}
}
