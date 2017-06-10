package com.blackrock.robot.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.blackrock.robot.commands.Command;
import com.blackrock.robot.commands.MoveDownCommand;
import com.blackrock.robot.commands.MoveLeftCommand;
import com.blackrock.robot.commands.MoveRightCommand;
import com.blackrock.robot.commands.MoveUpCommand;
import com.blackrock.robot.models.Ground;
import com.blackrock.robot.models.Robot;

@Repository
public class RobotRepository {
	
	// TODO: To implement the actions/commands "Turn to"
	// TODO: To implement the ground with "Circular"
	
	private static Robot robot;
	private static Ground ground;
	private static Map<String, Command> commands;
	
	static{
		initData();
	}
	
	public static void initData(){
		ground = new Ground(10, 10);
		
		commands = new HashMap<>();
		commands.put("up", new MoveUpCommand());
		commands.put("down", new MoveDownCommand());
		commands.put("left", new MoveLeftCommand());
		commands.put("right", new MoveRightCommand());
		
		robot = new Robot(ground, commands);
	}
	
	public Robot getRobot(){
		return robot;
	}
	
	public Ground getGround(){
		return ground;
	}
	
	public Map<String, Command> getCommands(){
		return commands;
	}
	
}
