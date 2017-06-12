package com.robot.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.robot.builders.PositionBuilder;
import com.robot.builders.RobotBuilder;
import com.robot.models.Ground;
import com.robot.models.Position;
import com.robot.models.Robot;

public class MoveDownCommandTest {

	private Ground ground = new Ground(10, 10);
	
	@Test
	public void executeTest() {
		int positionVerticalInit = 1;
		Position position = new PositionBuilder().withVertical(positionVerticalInit).build();
		Robot robot = new RobotBuilder().withPosition(position).build();
		Command command = new MoveDownCommand();
		
		Robot robotActual = command.execute(robot, ground);
		
		assertEquals("vertical position should be positionVerticalInit + 1", positionVerticalInit+1, robotActual.getPosition().getVertical());
	}	
	
	@Test
	public void executeLimitVerticalExceededToDownTest() {
		int positionVerticalInit = 10;
		Position position = new PositionBuilder().withVertical(positionVerticalInit).build();
		Robot robot = new RobotBuilder().withPosition(position).build();
		Command command = new MoveDownCommand();
		
		Robot robotActual = command.execute(robot, ground);
		
		assertEquals("vertical position should be 1 after Limit Vertical Exceeded to Down", 1, robotActual.getPosition().getVertical());
	}
	
}
