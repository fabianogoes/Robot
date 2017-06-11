package com.blackrock.robot.builders;

import com.blackrock.robot.models.Position;

public class PositionBuilder {
	private Position position = new Position();
	
	public Position build(){
		return this.position;
	}
	
	public PositionBuilder withHorizontal(int horizontal){
		this.position.setHorizontal(horizontal);
		return this;
	}
	
	public PositionBuilder withVertical(int vertical){
		this.position.setVertical(vertical);
		return this;
	}
}
