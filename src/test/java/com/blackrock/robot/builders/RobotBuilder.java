package com.blackrock.robot.builders;

import java.util.Map;

import com.blackrock.robot.commands.Command;
import com.blackrock.robot.models.Ground;
import com.blackrock.robot.models.Position;
import com.blackrock.robot.models.Robot;

public class RobotBuilder {
	
	private Robot robot = new Robot(); 
	
	public Robot build(){
		return this.robot;
	}
	
	public RobotBuilder withGround(Ground ground){
		this.robot.setGround(ground);
		return this;
	}
	
	public RobotBuilder withPosition(Position position){
		this.robot.setPosition(position);
		return this;
	}
	
	public RobotBuilder withCommands(Map<String, Command> commands){
		this.robot.setCommands(commands);
		return this;
	}

}
