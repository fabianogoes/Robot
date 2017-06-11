package com.blackrock.robot.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.blackrock.robot.builders.PositionBuilder;
import com.blackrock.robot.builders.RobotBuilder;
import com.blackrock.robot.models.Position;
import com.blackrock.robot.models.Robot;

public class MoveDownCommandTest {

	@Test
	public void executeTest() {
		int positionVerticalInit = 1;
		Position position = new PositionBuilder().withVertical(positionVerticalInit).build();
		Robot robot = new RobotBuilder().withPosition(position).build();
		Command command = new MoveDownCommand();
		
		Robot robotActual = command.execute(robot);
		
		assertEquals("vertical position should be positionVerticalInit + 1", positionVerticalInit+1, robotActual.getPosition().getVertical());
	}	
	
	@Test
	public void executeLimitVerticalExceededToDownTest() {
		int positionVerticalInit = 10;
		Position position = new PositionBuilder().withVertical(positionVerticalInit).build();
		Robot robot = new RobotBuilder().withPosition(position).build();
		Command command = new MoveDownCommand();
		
		Robot robotActual = command.execute(robot);
		
		assertEquals("vertical position should be 1 after Limit Vertical Exceeded to Down", 1, robotActual.getPosition().getVertical());
	}
	
}
