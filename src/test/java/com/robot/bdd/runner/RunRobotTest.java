package com.robot.bdd.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome = true,
		plugin = { "pretty", "html:target/cucumber", "json:target/cucumber/cucumber-json-report.json" },
        glue = "com.blackrock.robot.bdd.steps",
        features = "classpath:cucumber/robot.feature"
)
public class RunRobotTest {

}
