package com.blackrock.robot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blackrock.robot.models.Ground;
import com.blackrock.robot.models.Position;
import com.blackrock.robot.models.Robot;
import com.blackrock.robot.services.ControlService;

@CrossOrigin
@RestController
public class ControlController {

	@Autowired
	private ControlService service;
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;	
	
	@RequestMapping("/position")
	public Position position() throws Exception{
		System.out.println("<<< position >>>");
		return service.getPosition();
	}	
	
	@RequestMapping(value="/move/{direction}", produces="application/json")
	public Position move(@PathVariable("direction") String direction) throws Exception{
		System.out.println("<<< ControlController.move("+direction+") >>>");
		
		/**
		 * Execute Movement by Command Pattern
		 */
		Robot robot = service.executeCommand(direction);
		
		/**
		 * Send to websocket for refresh position in Front-end on realtime 
		 */
		this.simpMessagingTemplate.convertAndSend("/server/position", robot.getPosition());
		
		return robot.getPosition();
	}	
	
	@RequestMapping("/ground")
	public Ground ground() throws Exception{
		System.out.println("<<< ground >>>");
		return service.getGround();
	}	
	
}
