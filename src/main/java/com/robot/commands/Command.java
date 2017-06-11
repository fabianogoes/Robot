package com.robot.commands;

import java.io.Serializable;

import com.robot.models.Robot;

public interface Command extends Serializable {
	
	Robot execute(Robot robot);
	
}
