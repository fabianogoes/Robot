package com.robot.commands;

import java.io.Serializable;

import com.robot.models.Ground;
import com.robot.models.Robot;

public interface Command extends Serializable {
	
	Robot execute(Robot robot, Ground ground);
	
}
