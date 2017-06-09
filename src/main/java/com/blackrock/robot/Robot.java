package com.blackrock.robot;

public class Robot {

	private int[] ground = {10, 10};
	private int[] actualPosition = new int[2];
	
	public Robot(){
		this.actualPosition[0] = 0;
		this.actualPosition[1] = 0;
	}
	
	public boolean getExists() {
		return true;
	}

	public boolean moveToRight() {
		this.actualPosition[0] += 1; 
		if(this.actualPosition[0] > ground[0]-1){
			this.actualPosition[0] = 0;
		}
		return true;
	}

	public int[] getActualPosition() {
		return this.actualPosition;
	}

	public int[] getGround() {
		return this.ground;
	}

	public boolean moveToUp() {
		this.actualPosition[1] -= 1; 
		if(this.actualPosition[1] < 0){
			this.actualPosition[1] = ground[1]-1;
		}		
		return true;
	}

	public boolean moveToLeft() {
		this.actualPosition[0] -= 1; 
		if(this.actualPosition[0] < 0){
			this.actualPosition[0] = ground[0]-1;
		}		
		return true;
	}

	public boolean moveToDown() {
		this.actualPosition[1] += 1; 
		if(this.actualPosition[1] > ground[1]-1){
			this.actualPosition[1] = 0;
		}		
		return true;
	}

}
