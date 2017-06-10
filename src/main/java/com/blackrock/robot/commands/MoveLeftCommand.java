package com.blackrock.robot.commands;

import com.blackrock.robot.models.Ground;
import com.blackrock.robot.models.Robot;

public class MoveLeftCommand implements Command {

	private static final long serialVersionUID = -5050078504946091188L;

	@Override
	public Robot execute(Robot robot) {
		robot.getPosition().setHorizontal(robot.getPosition().getHorizontal()-1);
		if(robot.getPosition().getHorizontal() < Ground.MIN_WIDTH){
			robot.getPosition().setHorizontal(Ground.MAX_WIDTH);
		}
		return robot;
	}

}
