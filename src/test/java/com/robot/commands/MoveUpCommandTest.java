package com.robot.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.robot.builders.PositionBuilder;
import com.robot.builders.RobotBuilder;
import com.robot.commands.Command;
import com.robot.commands.MoveUpCommand;
import com.robot.models.Position;
import com.robot.models.Robot;

public class MoveUpCommandTest {

	@Test
	public void executeTest() {
		int positionVerticalInit = 10;
		Position position = new PositionBuilder().withVertical(positionVerticalInit).build();
		Robot robot = new RobotBuilder().withPosition(position).build();
		Command command = new MoveUpCommand();
		
		Robot robotActual = command.execute(robot);
		
		assertEquals("vertical position should be positionVerticalInit - 1", positionVerticalInit-1, robotActual.getPosition().getVertical());
	}	
	
	@Test
	public void executeLimitVerticalExceededToUpTest() {
		int positionVerticalInit = 1;
		Position position = new PositionBuilder().withVertical(positionVerticalInit).build();
		Robot robot = new RobotBuilder().withPosition(position).build();
		Command command = new MoveUpCommand();
		
		Robot robotActual = command.execute(robot);
		
		assertEquals("vertical position should be 10 after Limit Vertical Exceeded to Up", 10, robotActual.getPosition().getVertical());
	}
	
}
