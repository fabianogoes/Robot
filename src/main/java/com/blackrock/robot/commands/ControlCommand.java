package com.blackrock.robot.commands;

import org.springframework.stereotype.Component;

import com.blackrock.robot.models.Robot;

@Component
public class ControlCommand {

	public Robot execute(Robot robot, String command) throws IllegalArgumentException {
		System.out.println("<<< ControlCommand.execute("+command+") >>>");
		Command commantExecute = robot.getCommands().get(command);
		if (commantExecute == null) {
			throw new IllegalArgumentException();
		}

		return commantExecute.execute(robot);
	}

}
