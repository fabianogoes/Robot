package com.blackrock.robot.commands;

import com.blackrock.robot.models.Ground;
import com.blackrock.robot.models.Robot;

public class MoveDownCommand implements Command {

	private static final long serialVersionUID = 3499732989503817362L;

	@Override
	public Robot execute(Robot robot) {
		robot.getPosition().setVertical(robot.getPosition().getVertical()+1);
		if(robot.getPosition().getVertical() > Ground.MAX_HEIGHT){
			robot.getPosition().setVertical(Ground.MIN_HEIGHT);
		}
		return robot;
	}

}
