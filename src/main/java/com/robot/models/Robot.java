package com.robot.models;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.robot.commands.Command;

@Component
public class Robot {

	private Ground ground;
	private Position position;
	private Map<String, Command> commands;

	public Robot() {
	}

	public Robot(Ground ground, Map<String, Command> commands) {
		this.ground = ground;
		this.commands = commands;
		this.position = new Position(1, 1);
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Position getPosition() {
		return this.position;
	}

	public Ground getGround() {
		return this.ground;
	}

	public Map<String, Command> getCommands() {
		return commands;
	}

	public void setGround(Ground ground) {
		this.ground = ground;
	}

	public void setCommands(Map<String, Command> commands) {
		this.commands = commands;
	}

}
