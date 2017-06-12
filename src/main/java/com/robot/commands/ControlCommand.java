package com.robot.commands;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.robot.models.Ground;
import com.robot.models.Robot;

@Component
public class ControlCommand {

	private Map<String, Command> commands;
	
	private Command commantExecute;
	
	private Ground ground;
	
	@Autowired
	public ControlCommand(Map<String, Command> commands, Ground ground){
		this.commands = commands;
		this.ground = ground;
	}
	
	public Robot execute(Robot robot, String command) throws IllegalArgumentException {
		System.out.println("<<< ControlCommand.execute("+command+") >>>");
		
		commantExecute = commands.get(command.toLowerCase());
		if (commantExecute == null) {
			throw new IllegalArgumentException();
		}

		return commantExecute.execute(robot, ground);
	}

}