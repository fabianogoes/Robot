package com.blackrock.robot.models;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.blackrock.robot.commands.Command;

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

	public boolean getExists() {
		return true;
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

	// public boolean moveToRight() {
	// this.position.setHorizontal(this.position.getHorizontal() + 1);
	// if (this.position.getHorizontal() > ground.getWidth()) {
	// this.position.setHorizontal(1);
	// }
	// return true;
	// }
	//
	// public boolean moveToUp() {
	// this.position.setVertical(this.position.getHorizontal() - 1);
	// if (this.position.getVertical() < 1) {
	// this.position.setVertical(ground.getHeight());
	// }
	// return true;
	// }
	//
	// public boolean moveToLeft() {
	// this.position.setHorizontal(this.position.getHorizontal() - 1);
	// if (this.position.getHorizontal() < 1) {
	// this.position.setHorizontal(ground.getWidth());
	// }
	// return true;
	// }
	//
	// public boolean moveToDown() {
	// this.position.setVertical(this.position.getVertical() + 1);
	// if (this.position.getVertical() > ground.getHeight()) {
	// this.position.setVertical(1);
	// }
	// return true;
	// }

}
