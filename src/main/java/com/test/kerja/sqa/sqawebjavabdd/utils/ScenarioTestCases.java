package com.test.kerja.sqa.sqawebjavabdd.utils;

public enum ScenarioTestCases {
	SCT1("Scenario Input Username and Password Login to main web"),
	SCT2("Scenario Add data from admin menu");
	
	private String scenarioTestName;

	ScenarioTestCases(String value){
		this.scenarioTestName  = value;
	}
	
	public String getScenarioTestName() {
		return scenarioTestName;
	}
	
	
	
}
