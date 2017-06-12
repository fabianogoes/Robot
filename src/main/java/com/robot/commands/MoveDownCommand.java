package com.robot.commands;

import com.robot.models.Ground;
import com.robot.models.Robot;

public class MoveDownCommand implements Command {

	private static final long serialVersionUID = 3499732989503817362L;

	@Override
	public Robot execute(Robot robot, Ground ground) {
		robot.getPosition().setVertical(robot.getPosition().getVertical()+1);
		if(robot.getPosition().getVertical() > ground.getLength()){
			robot.getPosition().setVertical(1);
		}
		return robot;
	}

}
