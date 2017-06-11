package com.robot.commands;

import com.robot.models.Ground;
import com.robot.models.Robot;

public class MoveRightCommand implements Command {

	private static final long serialVersionUID = -103378375731713218L;

	@Override
	public Robot execute(Robot robot) {
		robot.getPosition().setHorizontal(robot.getPosition().getHorizontal()+1);
		if(robot.getPosition().getHorizontal() > Ground.MAX_WIDTH){
			robot.getPosition().setHorizontal(Ground.MIN_WIDTH);
		}
		return robot;
	}

}
