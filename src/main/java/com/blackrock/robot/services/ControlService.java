package com.blackrock.robot.services;

import org.springframework.stereotype.Service;

import com.blackrock.robot.models.Robot;

@Service
public class ControlService {
	
	// TODO: Implement Tests to Service
	
	public static Robot robot = new Robot();

	public Robot moveToDown() {
		robot.moveToDown();
		return robot;
	}

	public Robot moveToRight() {
		robot.moveToRight();
		return robot;
	}

	public Robot moveToLeft() {
		robot.moveToLeft();
		return robot;
	}

	public Robot moveToUp() {
		robot.moveToUp();
		return robot;
	}

	public Robot getPosition() {
		return robot;
	}

	public int[] getGround() {
		return robot.getGround();
	}
	
	
}
