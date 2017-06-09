package com.blackrock.robot;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BlackRockRobotApplication {

	public static Robot robot = new Robot();
	
	public static void main(String[] args) {
		SpringApplication.run(BlackRockRobotApplication.class, args);
	}
	
	@RequestMapping("/move")
	public Robot move() {
		System.out.println("<<< Move >>>");
		robot.moveToRight();
		return robot;
	}

	@RequestMapping("/position")
	public Robot position() throws Exception{
		System.out.println("<<< Position >>>");
		return robot;
	}	
	
	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public Robot send(String message) throws Exception {
		System.out.println("<<< Send()... >>>");
	    String time = new SimpleDateFormat("HH:mm").format(new Date());
	    System.out.println("message = "+message+" - time = "+time);
	    robot.moveToRight();
	    return robot;
	}
}
