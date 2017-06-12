package com.robot.commands;

import com.robot.models.Ground;
import com.robot.models.Robot;

public class MoveLeftCommand implements Command {

	private static final long serialVersionUID = -5050078504946091188L;

	@Override
	public Robot execute(Robot robot, Ground ground) {
		robot.getPosition().setHorizontal(robot.getPosition().getHorizontal()-1);
		if(robot.getPosition().getHorizontal() < 1){
			robot.getPosition().setHorizontal(ground.getWidth());
		}
		return robot;
	}

}
