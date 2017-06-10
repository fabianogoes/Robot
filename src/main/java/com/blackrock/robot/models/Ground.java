package com.blackrock.robot.models;

public class Ground {

	public static final int MIN_WIDTH = 1;
	public static final int MAX_WIDTH = 10;
	public static final int MAX_HEIGHT = 10;
	public static final int MIN_HEIGHT = 1;
	
	private int width;
	private int height;

	public Ground() {
	}

	public Ground(int width, int height) {
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
