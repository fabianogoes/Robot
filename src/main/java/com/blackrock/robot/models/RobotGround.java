package com.blackrock.robot.models;

public class RobotGround {

	private int width;
	private int height;

	public RobotGround(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return "RobotGround [width=" + width + ", height=" + height + "]";
	}

}
