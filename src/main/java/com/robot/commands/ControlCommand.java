package com.robot.commands;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.robot.models.Robot;

@Component
public class ControlCommand {

	private Map<String, Command> commands;
	
	private Command commantExecute;
	
	@Autowired
	public ControlCommand(Map<String, Command> commands){
		this.commands = commands;
	}
	
	public Robot execute(Robot robot, String command) throws IllegalArgumentException {
		System.out.println("<<< ControlCommand.execute("+command+") >>>");
		
		commantExecute = commands.get(command.toLowerCase());
		if (commantExecute == null) {
			throw new IllegalArgumentException();
		}

		return commantExecute.execute(robot);
	}

}
