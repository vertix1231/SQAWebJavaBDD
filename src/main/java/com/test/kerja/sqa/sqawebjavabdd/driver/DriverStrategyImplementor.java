package com.test.kerja.sqa.sqawebjavabdd.driver;

import com.test.kerja.sqa.sqawebjavabdd.utils.ConstantsDriver;

public class DriverStrategyImplementor {
	public static DriverStrategy chooseStrategy(String strategy) {
		switch (strategy) {
		case ConstantsDriver.CHROME:
			return new Chrome();

		case ConstantsDriver.FIREFOX:
			return new FireFox();

		default:
			return null;
		}
	}
}
