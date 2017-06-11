package com.blackrock.robot.commands;

import org.junit.Test;
import static org.junit.Assert.*;

import com.blackrock.robot.builders.PositionBuilder;
import com.blackrock.robot.builders.RobotBuilder;
import com.blackrock.robot.models.Position;
import com.blackrock.robot.models.Robot;

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
