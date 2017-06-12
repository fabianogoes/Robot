package com.robot.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.robot.builders.PositionBuilder;
import com.robot.builders.RobotBuilder;
import com.robot.commands.Command;
import com.robot.commands.MoveRightCommand;
import com.robot.models.Ground;
import com.robot.models.Position;
import com.robot.models.Robot;

public class MoveRightCommandTest {

	private Ground ground = new Ground(10, 10);
	
	@Test
	public void executeTest() {
		int positionHorizontalInit = 1;
		Position position = new PositionBuilder().withHorizontal(positionHorizontalInit).build();
		Robot robot = new RobotBuilder().withPosition(position).build();
		Command command = new MoveRightCommand();
		
		Robot robotActual = command.execute(robot, ground);
		
		assertEquals("vertical position should be positionHorizontalInit + 1", positionHorizontalInit+1, robotActual.getPosition().getHorizontal());
	}	
	
	@Test
	public void executeLimitHorizontalExceededToRightTest() {
		int positionHorizontalInit = 10;
		Position position = new PositionBuilder().withHorizontal(positionHorizontalInit).build();
		Robot robot = new RobotBuilder().withPosition(position).build();
		Command command = new MoveRightCommand();
		
		Robot robotActual = command.execute(robot, ground);
		
		assertEquals("vertical position should be 1 after Limit Horizontal Exceeded to Right", 1, robotActual.getPosition().getHorizontal());
	}	
	
}
