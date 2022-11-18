package com.test.kerja.sqa.sqawebjavabdd;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features")
public class RunTest {
	
	@Test
	public void test() {
		
	}

}
