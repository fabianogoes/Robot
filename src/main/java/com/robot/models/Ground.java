package com.robot.models;

public class Ground {

//	public static final int MIN_WIDTH = 1;
//	public static final int MAX_WIDTH = 10;
//	public static final int MAX_LENGTH = 10;
//	public static final int MIN_LENGTH = 1;
	
	private int width;
	private int length;

	public Ground() {
	}

	public Ground(int width, int length) {
		this.width = width;
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public int getLength() {
		return length;
	}

	@Override
	public String toString() {
		return "RobotGround [width=" + width + ", length=" + length + "]";
	}

}
