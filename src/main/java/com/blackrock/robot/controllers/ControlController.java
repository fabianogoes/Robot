package com.blackrock.robot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blackrock.robot.models.Robot;
import com.blackrock.robot.models.RobotGround;
import com.blackrock.robot.services.ControlService;

@CrossOrigin
@RestController
public class ControlController {

	@Autowired
	private ControlService service;
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;	
	
	@MessageMapping(value="/move/down")
	@SendTo(value="/server/position")
	public Robot moveToDown() {
		System.out.println("<<< moveToDown >>>");
		Robot robot = service.moveToDown();
		return robot;
	}

	@MessageMapping(value="/move/right")
	@SendTo(value="/server/position")
	public Robot moveToRight() {
		System.out.println("<<< moveToRight >>>");
		Robot robot = service.moveToRight();
		return robot;
	}
	
	@MessageMapping(value="/move/left")
	@SendTo(value="/server/position")
	public Robot moveToLeft() {
		System.out.println("<<< moveToLeft >>>");
		Robot robot = service.moveToLeft();
		return robot;
	}
	
	@MessageMapping(value="/move/up")
	@SendTo(value="/server/position")
	public Robot moveToUp() {
		System.out.println("<<< moveToUp >>>");
		Robot robot = service.moveToUp();
		return robot;
	}
	
	@RequestMapping("/position")
	public Robot position() throws Exception{
		System.out.println("<<< position >>>");
		return service.getPosition();
	}	
	
	@RequestMapping("/move/{direction}")
	public Robot move(@PathVariable("direction") String direction) throws Exception{
		System.out.println("<<< move >>>");
		
		switch (direction.toUpperCase()) {
		case "UP":
			service.moveToUp();
			break;
		case "LEFT":
			service.moveToLeft();
			break;
		case "DOWN":
			service.moveToDown();
			break;
		case "RIGHT":
			service.moveToRight();
			break;
		default:
			throw new RuntimeException("Movement not implemented"); 
		}
		this.simpMessagingTemplate.convertAndSend("/server/position", service.getPosition());
		return service.getPosition();
	}	
	
	@RequestMapping("/ground")
	public RobotGround ground() throws Exception{
		System.out.println("<<< ground >>>");
		return service.getGround();
	}	
	
}
