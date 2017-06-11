package com.robot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.robot.commands.Command;
import com.robot.commands.MoveDownCommand;
import com.robot.commands.MoveLeftCommand;
import com.robot.commands.MoveRightCommand;
import com.robot.commands.MoveUpCommand;
import com.robot.models.Ground;
import com.robot.models.Robot;


@SpringBootApplication
public class RobotApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobotApplication.class, args);
	}
	

	@Bean
	public Ground ground(){
		return new Ground(10, 10);
	}
	
	@Bean
	public Robot robot(){
		return new Robot(ground(), commands());		
	}
	
	@Bean
	public  Map<String, Command> commands(){
		Map<String, Command> commands = new HashMap<>();
		commands.put("up", new MoveUpCommand());
		commands.put("down", new MoveDownCommand());
		commands.put("left", new MoveLeftCommand());
		commands.put("right", new MoveRightCommand());
		
		return commands;
	}
	
}
