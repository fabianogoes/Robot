package com.robot.commands;

import com.robot.models.Ground;
import com.robot.models.Robot;

public class MoveUpCommand implements Command {

	private static final long serialVersionUID = 3746637947340847485L;

	@Override
	public Robot execute(Robot robot) {
		robot.getPosition().setVertical(robot.getPosition().getVertical()-1);
		if(robot.getPosition().getVertical() < Ground.MIN_LENGTH){
			robot.getPosition().setVertical(Ground.MAX_LENGTH);
		}
		return robot;
	}

}
