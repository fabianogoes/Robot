package com.robot.commands;

import org.junit.Test;
import static org.junit.Assert.*;

import com.robot.builders.PositionBuilder;
import com.robot.builders.RobotBuilder;
import com.robot.commands.Command;
import com.robot.commands.MoveLeftCommand;
import com.robot.models.Position;
import com.robot.models.Robot;

public class MoveLeftCommandTest {

	@Test
	public void executeTest() {
		int positionHorizontalInit = 10;
		Position position = new PositionBuilder().withHorizontal(positionHorizontalInit).build();
		Robot robot = new RobotBuilder().withPosition(position).build();
		Command command = new MoveLeftCommand();
		
		Robot robotActual = command.execute(robot);
		
		assertEquals("vertical position should be positionHorizontalInit - 1", positionHorizontalInit-1, robotActual.getPosition().getHorizontal());
	}	
	
	@Test
	public void executeLimitHorizontalExceededToLeftTest() {
		int positionHorizontalInit = 1;
		Position position = new PositionBuilder().withHorizontal(positionHorizontalInit).build();
		Robot robot = new RobotBuilder().withPosition(position).build();
		Command command = new MoveLeftCommand();
		
		Robot robotActual = command.execute(robot);
		
		assertEquals("vertical position should be 10 after Limit Horizontal Exceeded to Left", 10, robotActual.getPosition().getHorizontal());
	}	
	
}
