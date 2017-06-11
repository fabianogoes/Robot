package com.robot.bdd.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import com.robot.commands.Command;
import com.robot.commands.ControlCommand;
import com.robot.commands.MoveDownCommand;
import com.robot.commands.MoveLeftCommand;
import com.robot.commands.MoveRightCommand;
import com.robot.commands.MoveUpCommand;
import com.robot.models.Ground;
import com.robot.models.Position;
import com.robot.models.Robot;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RobotSteps {
	
	private static Robot robot;
	private static Ground ground;
	private static Map<String, Command> commands;
	private static ControlCommand controlCommand;
	
	@Before
	public void setUp(){
		ground = new Ground(10, 10);
		
		commands = new HashMap<>();
		commands.put("up", new MoveUpCommand());
		commands.put("down", new MoveDownCommand());
		commands.put("left", new MoveLeftCommand());
		commands.put("right", new MoveRightCommand());
		
		robot = new Robot(ground, commands);
		controlCommand = new ControlCommand(commands);
	}
	
	/******************************
	 * Scenario: Constructor Robot
	 ******************************/
	
	@Given("^that robot is created$")
	public void that_robot_is_created() throws Throwable {
	    assertNotNull("The robot should is created", robot);
	}

	@When("^I get area$")
	public void i_get_area() throws Throwable {
	    assertNotNull("The area should have the size", robot.getGround());
	}

	@Then("^the area should have \\[(\\d+)\\]\\[(\\d+)\\]$")
	public void the_area_should_have(int groundWidthSize, int groundHeightSize) throws Throwable {
	    assertEquals("The area width should be "+Ground.MAX_WIDTH, Ground.MAX_WIDTH, groundWidthSize);
	    assertEquals("The area height should be "+Ground.MAX_LENGTH, Ground.MAX_LENGTH, groundHeightSize);
	}	
	
	/******************************
	 * Scenario: Move to Right
	 ******************************/	
	
	@Given("^That exist a Robot in area$")
	public void that_exist_a_Robot_in_area() throws Throwable {
		boolean exists = robot != null;
		assertTrue("Should exist a robot in area", exists);
	}

	@When("^I send a command of movement to Right$")
	public void i_send_a_command_of_movement() throws Throwable {
		Robot execute = controlCommand.execute(robot, "right");
		assertTrue("The command should be executed", execute != null);
	}

	
	@Then("^the robot must moved to Right$")
	public void the_robot_must_moved_to_right() throws Throwable {
		Position positionExpected = robot.getPosition();
		assertEquals("The Robot should is on Position = "+Ground.MIN_WIDTH+1, Ground.MIN_WIDTH+1, positionExpected.getHorizontal());
	}
	
	/******************************
	 * Scenario: Move to Top
	 ******************************/		
	
	@When("^I send a command of movement to Up$")
	public void i_send_a_command_of_movement_to_Up() throws Throwable {
		Robot execute = controlCommand.execute(robot, "up");
		assertTrue("The command should be executed", execute != null);
	}

	@Then("^the robot must moved to Up$")
	public void the_robot_must_moved_to_Up() throws Throwable {
		Position positionExpected = robot.getPosition();
		assertEquals("The Robot should is on Ground.MAX_LENGTH = "+Ground.MAX_LENGTH, Ground.MAX_LENGTH, positionExpected.getVertical());
	}
	
	/******************************
	 * Scenario: Move to Left
	 ******************************/		
	
	@When("^I send a command of movement to Left$")
	public void i_send_a_command_of_movement_to_Left() throws Throwable {
		Robot execute = controlCommand.execute(robot, "left");
		assertTrue("The command should be executed", execute != null);
	}

	@Then("^the robot must moved to Left$")
	public void the_robot_must_moved_to_Left() throws Throwable {
		Position positionExpected = robot.getPosition();
		assertEquals("The Robot should is on Ground.MAX_WIDTH = "+Ground.MAX_WIDTH, Ground.MAX_WIDTH, positionExpected.getHorizontal());
	}	
	
	/******************************
	 * Scenario: Move to Down
	 ******************************/	
	
	@When("^I send a command of movement to Down$")
	public void i_send_a_command_of_movement_to_Down() throws Throwable {
		Robot execute = controlCommand.execute(robot, "down");
		assertTrue("The command should be executed", execute != null);
	}

	@Then("^the robot must moved to Down$")
	public void the_robot_must_moved_to_Down() throws Throwable {
		Position positionExpected = robot.getPosition();
		assertEquals("The Robot should is on position = "+Ground.MIN_LENGTH+1, Ground.MIN_LENGTH+1, positionExpected.getVertical());
	}	
	
}
