package com.test.kerja.sqa.sqawebjavabdd.utils;

public enum TestCases {
	T1("Find article in Vermint.com");
	
	private String TestName;

	TestCases(String value){
		this.TestName  = value;
	}
	
	public String getTestName() {
		return TestName;
	}
	
	
	
}
