package com.robot.commands;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.robot.models.Ground;
import com.robot.models.Robot;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControlCommandTest {
	
	//@Autowired
	private ControlCommand controlCommand;
	
	@Autowired
	private Robot robot;
	
	@Mock
	private Map<String, Command> commandsMocked;
	
	@Mock
	private Ground groundMocked;
	
	
	@Before
	public void setUp(){
		controlCommand = new ControlCommand(commandsMocked, groundMocked);
	}
	
	@Test
	public void testExecuteUp() throws IllegalArgumentException {	
		String command = "up";
		Command commandExecuteMocked = mock(MoveUpCommand.class);
		
		when(this.commandsMocked.get(command)).thenReturn(commandExecuteMocked);
		when(commandExecuteMocked.execute(robot, groundMocked)).thenReturn(robot);
		
		controlCommand.execute(robot, command);
		
		verify(this.commandsMocked, times(1)).get(command);
		verify(commandExecuteMocked, times(1)).execute(robot, groundMocked);
	}
	
	@Test
	public void testExecuteDown() throws IllegalArgumentException {	
		String command = "down";
		Command commantExecuteMocked = mock(MoveDownCommand.class);
		
		when(this.commandsMocked.get(command)).thenReturn(commantExecuteMocked);
		when(commantExecuteMocked.execute(robot, groundMocked)).thenReturn(robot);
		
		controlCommand.execute(robot, command);
		
		verify(this.commandsMocked, times(1)).get(command);
		verify(commantExecuteMocked, times(1)).execute(robot, groundMocked);
	}
	
	@Test
	public void testExecuteLeft() throws IllegalArgumentException {	
		String command = "left";
		Command commantExecuteMocked = mock(MoveLeftCommand.class);
		
		when(this.commandsMocked.get(command)).thenReturn(commantExecuteMocked);
		when(commantExecuteMocked.execute(robot, groundMocked)).thenReturn(robot);
		
		controlCommand.execute(robot, command);
		
		verify(this.commandsMocked, times(1)).get(command);
		verify(commantExecuteMocked, times(1)).execute(robot, groundMocked);
	}
	
	@Test
	public void testExecuteRight() throws IllegalArgumentException {	
		String command = "right";
		Command commantExecuteMocked = mock(MoveRightCommand.class);
		
		when(this.commandsMocked.get(command)).thenReturn(commantExecuteMocked);
		when(commantExecuteMocked.execute(robot, groundMocked)).thenReturn(robot);
		
		controlCommand.execute(robot, command);
		
		verify(this.commandsMocked, times(1)).get(command);
		verify(commantExecuteMocked, times(1)).execute(robot, groundMocked);
	}
	
}