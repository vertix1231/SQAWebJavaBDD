package com.test.kerja.sqa.sqawebjavabdd.utils;

public enum ScenarioTestCases {
	SCT1("Scenario Input Username and Password Login to Main Web"),
	SCT2("Scenario Buy Product"),
	SCT3("Scenario Buy All Product");
	
	private String scenarioTestName;

	ScenarioTestCases(String value){
		this.scenarioTestName  = value;
	}
	
	public String getScenarioTestName() {
		return scenarioTestName;
	}
	
	
	
}
