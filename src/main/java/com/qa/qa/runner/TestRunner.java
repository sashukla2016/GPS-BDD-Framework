package com.qa.qa.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\Saumya\\SeleniumAutomation\\GPSBDDFramework\\src\\main\\java\\com\\gps\\qa\\Features\\login.feature",
		glue = {"com/gps/qa/stepDefinition"},
		format = {"pretty","html:test-output","json:json-output\\cucumber.json","junit:junit_xml\\cucumber.xml"},
		dryRun = false, // to check if the mapping is proper between feature file and step definition file
		monochrome = true,// display the console output in a proper readable format
		strict = true, // checks that each step of the feature file is present in step definition
		tags = {"@End2End"}
		)

public class TestRunner {
	

}
