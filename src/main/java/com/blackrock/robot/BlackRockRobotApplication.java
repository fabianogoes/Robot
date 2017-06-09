package com.blackrock.robot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@SpringBootApplication
public class BlackRockRobotApplication {

	public static Robot robot = new Robot();
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(BlackRockRobotApplication.class, args);
	}
	
	@MessageMapping(value="/move/down")
	@SendTo(value="/server/position")
	public Robot moveToDown() {
		System.out.println("<<< moveToDown >>>");
		robot.moveToDown();
		return robot;
	}

	@MessageMapping(value="/move/right")
	@SendTo(value="/server/position")
	public Robot moveToRight() {
		System.out.println("<<< moveToRight >>>");
		robot.moveToRight();
		return robot;
	}
	
	@MessageMapping(value="/move/left")
	@SendTo(value="/server/position")
	public Robot moveToLeft() {
		System.out.println("<<< moveToLeft >>>");
		robot.moveToLeft();
		return robot;
	}
	
	@MessageMapping(value="/move/up")
	@SendTo(value="/server/position")
	public Robot moveToUp() {
		System.out.println("<<< moveToUp >>>");
		robot.moveToUp();
		return robot;
	}
	
	@RequestMapping("/position")
	public Robot position() throws Exception{
		System.out.println("<<< position >>>");
		return robot;
	}	
	
	@RequestMapping("/move/{direction}")
	public Robot move(@PathVariable("direction") String direction) throws Exception{
		System.out.println("<<< move >>>");
		
		switch (direction.toUpperCase()) {
		case "UP":
			robot.moveToUp();
			break;
		case "LEFT":
			robot.moveToLeft();
			break;
		case "DOWN":
			robot.moveToDown();
			break;
		case "RIGHT":
			robot.moveToRight();
			break;
		default:
			throw new RuntimeException("Movement not implemented"); 
		}
		this.simpMessagingTemplate.convertAndSend("/server/position", robot);
		return robot;
	}	
	
	@RequestMapping("/ground")
	public int[] ground() throws Exception{
		System.out.println("<<< ground >>>");
		return robot.getGround();
	}	
	
}
