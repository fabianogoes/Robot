package com.blackrock.robot.commands;

import java.io.Serializable;

import com.blackrock.robot.models.Robot;

public interface Command extends Serializable {
	
	Robot execute(Robot robot);
	
}
