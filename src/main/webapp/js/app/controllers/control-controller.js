app.controller('ControlController', ['$timeout','$http'
,							 	function($timeout, $http){
	var self = this;
	self.stompClient = null;
	self.actualPosition = null;
									
	self.connect = function(){
		var socket = new SockJS('http://172.16.1.20:8080/robot/topic');
		stompClient = Stomp.over(socket);
		stompClient.connect({}, function (frame) {
			stompClient.subscribe('/server/position', function (response) {
	    		console.log("subscribe()...");
	    		self.actualPosition = JSON.parse(response.body).actualPosition; 
	    	});
		});
	}
	
	self.movePersonagem = function(direction){
		stompClient.send( "/app/move/" + direction, {}, {});
	}
	
	self.connect();
	
}])