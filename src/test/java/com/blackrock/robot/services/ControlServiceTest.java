package com.blackrock.robot.services;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.blackrock.robot.commands.ControlCommand;
import com.blackrock.robot.models.Ground;
import com.blackrock.robot.models.Position;
import com.blackrock.robot.models.Robot;
import com.blackrock.robot.repository.RobotRepository;

public class ControlServiceTest {

	private ControlService service;
	
	@Before
	public void setup(){
		RobotRepository.initData();
		ControlCommand controlCommand = new ControlCommand();
		RobotRepository repository = new RobotRepository();
		this.service = new ControlService(controlCommand, repository);
	}
	
	@Test
	public void testExecuteCommandUp(){
		int expectedVerticalPosition = Ground.MAX_HEIGHT;
		Robot executeCommand = this.service.executeCommand("up");
		assertEquals("Vertical position of Robot should be Ground.MAX_HEIGHT = "+expectedVerticalPosition, expectedVerticalPosition, executeCommand.getPosition().getVertical());
	}
	
	@Test
	public void testExecuteCommandDown(){
		int expectedVerticalPosition = Ground.MIN_HEIGHT+1;
		Robot executeCommand = this.service.executeCommand("down");
		assertEquals("Vertical position of Robot should be Ground.MIN_HEIGHT+1 = "+expectedVerticalPosition, expectedVerticalPosition, executeCommand.getPosition().getVertical());
	}
	
	@Test
	public void testExecuteCommandLeft(){
		int expectedHorizontalPosition = Ground.MAX_WIDTH;
		Robot executeCommand = this.service.executeCommand("left");
		assertEquals("Vertical position of Robot should be Ground.MAX_WIDTH = "+expectedHorizontalPosition, expectedHorizontalPosition, executeCommand.getPosition().getHorizontal());
	}
	
	@Test
	public void testExecuteCommandRight(){
		int expectedHorizontalPosition = Ground.MIN_WIDTH+1;
		Robot executeCommand = this.service.executeCommand("right");
		assertEquals("Vertical position of Robot should be Ground.MIN_WIDTH+1 = "+expectedHorizontalPosition, expectedHorizontalPosition, executeCommand.getPosition().getHorizontal());
	}
	
	@Test
	public void testGetPositionInit() {
		int expectedVerticalPosition = Ground.MIN_HEIGHT;
		int expectedHorizontalPosition = Ground.MIN_WIDTH;
		Position position = this.service.getPosition();
		assertEquals("The vertical position of Robot should be Ground.MIN_HEIGHT = "+expectedVerticalPosition, expectedVerticalPosition, position.getVertical());
		assertEquals("The horizontal position of Robot should be Ground.MIN_WIDTH = "+expectedHorizontalPosition, expectedVerticalPosition, position.getHorizontal());
	}

	@Test
	public void testGetGround() {
		int heightSizeGroundExpected = Ground.MAX_HEIGHT;
		int widthSizeGroundExpected = Ground.MAX_WIDTH;
		Ground ground = this.service.getGround();
		assertEquals("The height size should be Ground.MAX_HEIGHT = "+heightSizeGroundExpected, heightSizeGroundExpected, ground.getHeight());
		assertEquals("The width size should be Ground.MAX_WIDTH = "+widthSizeGroundExpected, heightSizeGroundExpected, ground.getHeight());
	}
	
}
