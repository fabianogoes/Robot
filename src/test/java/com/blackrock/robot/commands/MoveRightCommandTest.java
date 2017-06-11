package com.blackrock.robot.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.blackrock.robot.builders.PositionBuilder;
import com.blackrock.robot.builders.RobotBuilder;
import com.blackrock.robot.models.Position;
import com.blackrock.robot.models.Robot;

public class MoveRightCommandTest {

	@Test
	public void executeTest() {
		int positionHorizontalInit = 1;
		Position position = new PositionBuilder().withHorizontal(positionHorizontalInit).build();
		Robot robot = new RobotBuilder().withPosition(position).build();
		Command command = new MoveRightCommand();
		
		Robot robotActual = command.execute(robot);
		
		assertEquals("vertical position should be positionHorizontalInit + 1", positionHorizontalInit+1, robotActual.getPosition().getHorizontal());
	}	
	
	@Test
	public void executeLimitHorizontalExceededToRightTest() {
		int positionHorizontalInit = 10;
		Position position = new PositionBuilder().withHorizontal(positionHorizontalInit).build();
		Robot robot = new RobotBuilder().withPosition(position).build();
		Command command = new MoveRightCommand();
		
		Robot robotActual = command.execute(robot);
		
		assertEquals("vertical position should be 1 after Limit Horizontal Exceeded to Right", 1, robotActual.getPosition().getHorizontal());
	}	
	
}
