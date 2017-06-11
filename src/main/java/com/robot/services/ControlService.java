package com.robot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robot.commands.ControlCommand;
import com.robot.models.Ground;
import com.robot.models.Position;
import com.robot.models.Robot;

@Service
public class ControlService {
	
	private ControlCommand controlCommand;
	
	//private RobotRepository repository;
	private Robot robot;
	
	
	@Autowired
	public ControlService(ControlCommand controlCommand, Robot robot){
		this.controlCommand = controlCommand;
		this.robot = robot;
	}
	

	public Robot executeCommand(String command){
		System.out.println("<<< ControlService.executeCommand("+command+") >>>");
		return this.controlCommand.execute(robot, command);
	}
	
	public Position getPosition() {
		return robot.getPosition();
	}

	public Ground getGround() {
		return robot.getGround();
	}
	
	
}
