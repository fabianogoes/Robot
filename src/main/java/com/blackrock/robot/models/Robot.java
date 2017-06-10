package com.blackrock.robot.models;

import org.springframework.stereotype.Component;

@Component
public class Robot {

	private RobotGround ground;
	private int[] actualPosition = new int[2];
	
	// TODO: Uncouple Ground
	public Robot(){
		this.ground = new RobotGround(10, 10);
		this.actualPosition[0] = 0;
		this.actualPosition[1] = 0;
	}
	
	public boolean getExists() {
		return true;
	}

	public boolean moveToRight() {
		this.actualPosition[0] += 1; 
		if(this.actualPosition[0] > ground.getWidth()-1){
			this.actualPosition[0] = 0;
		}
		return true;
	}

	public int[] getActualPosition() {
		return this.actualPosition;
	}

	public RobotGround getGround() {
		return this.ground;
	}

	public boolean moveToUp() {
		this.actualPosition[1] -= 1; 
		if(this.actualPosition[1] < 0){
			this.actualPosition[1] = ground.getHeight()-1;
		}		
		return true;
	}

	public boolean moveToLeft() {
		this.actualPosition[0] -= 1; 
		if(this.actualPosition[0] < 0){
			this.actualPosition[0] = ground.getWidth()-1;
		}		
		return true;
	}

	public boolean moveToDown() {
		this.actualPosition[1] += 1; 
		if(this.actualPosition[1] > ground.getHeight()-1){
			this.actualPosition[1] = 0;
		}		
		return true;
	}

}
