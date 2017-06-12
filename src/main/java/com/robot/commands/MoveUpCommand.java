package com.robot.commands;

import com.robot.models.Ground;
import com.robot.models.Robot;

public class MoveUpCommand implements Command {

	private static final long serialVersionUID = 3746637947340847485L;

	@Override
	public Robot execute(Robot robot, Ground ground) {
		robot.getPosition().setVertical(robot.getPosition().getVertical()-1);
		if(robot.getPosition().getVertical() < 1){
			robot.getPosition().setVertical(ground.getLength());
		}
		return robot;
	}

}
