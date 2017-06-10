package com.blackrock.robot.commands;

import com.blackrock.robot.models.Robot;

public interface RobotCommand {
	
	Robot execute(Robot robot);
	
}
