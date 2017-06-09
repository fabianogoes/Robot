package com.blackrock.robot.bdd.steps;

import com.blackrock.robot.Robot;

import static org.junit.Assert.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RobotSteps {
	
	private Robot robot;
	
	@Before
	public void setUp(){
		this.robot = new Robot();
	}
	
	/******************************
	 * Scenario: Constructor Robot
	 ******************************/
	
	@Given("^that robot is created$")
	public void that_robot_is_created() throws Throwable {
	    assertNotNull("The robot should is created", this.robot);
	}

	@When("^I get area$")
	public void i_get_area() throws Throwable {
	    assertNotNull("The area should have the size", this.robot.getGround());
	}

	@Then("^the area should have \\[(\\d+)\\]\\[(\\d+)\\]$")
	public void the_area_should_have(int arg1, int arg2) throws Throwable {
	    assertEquals("The area[x] should be 10", 10, arg1);
	    assertEquals("The area[y] should be 10", 10, arg2);
	}	
	
	/******************************
	 * Scenario: Move to Right
	 ******************************/	
	
	@Given("^That exist a Robot in area$")
	public void that_exist_a_Robot_in_area() throws Throwable {
		boolean exists = this.robot.getExists();
		assertTrue("Should exist a robot in area", exists);
	}

	@When("^I send a command of movement to Right$")
	public void i_send_a_command_of_movement() throws Throwable {
		boolean commandExecuted = this.robot.moveToRight();
		assertTrue("The command should be executed", commandExecuted);
	}

	
	@Then("^the robot must moved to Right$")
	public void the_robot_must_moved_to_right() throws Throwable {
		int[] actualPositionExpected = this.robot.getActualPosition();
		assertEquals("The Robot should is on actualPosition[1]", 1, actualPositionExpected[0]);
	}
	
	/******************************
	 * Scenario: Move to Top
	 ******************************/		
	
	@When("^I send a command of movement to Up$")
	public void i_send_a_command_of_movement_to_Up() throws Throwable {
		boolean commandExecuted = this.robot.moveToUp();
		assertTrue("The command should be executed", commandExecuted);
	}

	@Then("^the robot must moved to Up$")
	public void the_robot_must_moved_to_Up() throws Throwable {
		int[] actualPositionExpected = this.robot.getActualPosition();
		assertEquals("The Robot should is on actualPosition[1]", 9, actualPositionExpected[1]);
	}
	
	/******************************
	 * Scenario: Move to Left
	 ******************************/		
	
	@When("^I send a command of movement to Left$")
	public void i_send_a_command_of_movement_to_Left() throws Throwable {
		boolean commandExecuted = this.robot.moveToLeft();
		assertTrue("The command should be executed", commandExecuted);
	}

	@Then("^the robot must moved to Left$")
	public void the_robot_must_moved_to_Left() throws Throwable {
		int[] actualPositionExpected = this.robot.getActualPosition();
		assertEquals("The Robot should is on actualPosition[0]", 9, actualPositionExpected[0]);
	}	
	
	/******************************
	 * Scenario: Move to Down
	 ******************************/	
	
	@When("^I send a command of movement to Down$")
	public void i_send_a_command_of_movement_to_Down() throws Throwable {
		boolean commandExecuted = this.robot.moveToDown();
		assertTrue("The command should be executed", commandExecuted);
	}

	@Then("^the robot must moved to Down$")
	public void the_robot_must_moved_to_Down() throws Throwable {
		int[] actualPositionExpected = this.robot.getActualPosition();
		assertEquals("The Robot should is on actualPosition[1]", 1, actualPositionExpected[1]);
	}	
	
}
