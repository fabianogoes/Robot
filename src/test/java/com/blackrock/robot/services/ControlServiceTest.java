package com.blackrock.robot.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.blackrock.robot.commands.ControlCommand;
import com.blackrock.robot.models.Ground;
import com.blackrock.robot.models.Position;
import com.blackrock.robot.models.Robot;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControlServiceTest {

	private ControlService service;
	
	@Mock
	private ControlCommand controlCommand;
	
	@Mock
	private Robot robotMocked;
	
	@Before
	public void setup(){
		this.service = new ControlService(controlCommand, robotMocked);
	}
	
	@Test
	public void testExecuteCommandUp(){
		String command = "up";

		when(this.controlCommand.execute(robotMocked, command)).thenReturn(robotMocked);
		
		this.service.executeCommand(command);
		
		verify(this.controlCommand, times(1)).execute(robotMocked, command);
	}
	
	@Test
	public void testExecuteCommandDown(){
		String command = "down";

		when(this.controlCommand.execute(robotMocked, command)).thenReturn(robotMocked);
		
		this.service.executeCommand(command);
		
		verify(this.controlCommand, times(1)).execute(robotMocked, command);	}
	
	@Test
	public void testExecuteCommandLeft(){
		String command = "left";

		when(this.controlCommand.execute(robotMocked, command)).thenReturn(robotMocked);
		
		this.service.executeCommand(command);
		
		verify(this.controlCommand, times(1)).execute(robotMocked, command);	}
	
	@Test
	public void testExecuteCommandRight(){
		String command = "right";

		when(this.controlCommand.execute(robotMocked, command)).thenReturn(robotMocked);
		
		this.service.executeCommand(command);
		
		verify(this.controlCommand, times(1)).execute(robotMocked, command);	}
	
	@Test
	public void testGetPosition() {
		Position positionMocked = mock(Position.class);
		when(this.robotMocked.getPosition()).thenReturn(positionMocked);
		
		this.service.getPosition();
		
		verify(this.robotMocked).getPosition();
	}

	@Test
	public void testGetGround() {
		Ground groundMocked = mock(Ground.class);
		when(this.robotMocked.getGround()).thenReturn(groundMocked);
		
		this.service.getGround();
		
		verify(this.robotMocked).getGround();
	}
	
}
