package com.blackrock.robot.commands;

import com.blackrock.robot.models.Ground;
import com.blackrock.robot.models.Robot;

public class MoveUpCommand implements Command {

	private static final long serialVersionUID = 3746637947340847485L;

	@Override
	public Robot execute(Robot robot) {
		robot.getPosition().setVertical(robot.getPosition().getVertical()-1);
		if(robot.getPosition().getVertical() < Ground.MIN_HEIGHT){
			robot.getPosition().setVertical(Ground.MAX_HEIGHT);
		}
		return robot;
	}

}
