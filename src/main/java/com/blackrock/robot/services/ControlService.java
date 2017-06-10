package com.blackrock.robot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackrock.robot.commands.ControlCommand;
import com.blackrock.robot.models.Ground;
import com.blackrock.robot.models.Position;
import com.blackrock.robot.models.Robot;
import com.blackrock.robot.repository.RobotRepository;

@Service
public class ControlService {
	
	private ControlCommand controlCommand;
	
	private RobotRepository repository;
	
	@Autowired
	public ControlService(ControlCommand controlCommand, RobotRepository repository){
		this.controlCommand = controlCommand;
		this.repository = repository;
	}
	

	public Robot executeCommand(String command){
		System.out.println("<<< ControlService.executeCommand("+command+") >>>");
		return this.controlCommand.execute(repository.getRobot(), command.toLowerCase());
	}
	
	public Position getPosition() {
		return repository.getRobot().getPosition();
	}

	public Ground getGround() {
		return repository.getRobot().getGround();
	}
	
	
}
