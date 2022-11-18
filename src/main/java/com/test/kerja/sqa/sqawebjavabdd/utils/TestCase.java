package com.test.kerja.sqa.sqawebjavabdd.utils;

public enum TestCase {
	T1("Find article in Vermint.com");
	
	private String TestNama;

	TestCase(String value){
		this.TestNama  = value;
	}
	
	public String getTestNama() {
		return TestNama;
	}
	
	
	
}
