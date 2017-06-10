app.controller("IndexController", ['$rootScope', '$http', '$timeout', function($rootScope, $http, $timeout){

    self = this;
    self.MATRIZ_X = new Array(10);  
    self.MATRIZ_Y = new Array(10);  
    
    self.mytimeout = null;
	self.response = "";
	self.statusTimer = "Stop";
     
    init = function(){
        $("#area").height(window.innerHeight - $("#areaHeader").height() * 4);
        $("#robo").offset(
            { 
                top: $("#areaBody").offset().top + ($("#areaBody").height()/2) - ($("#robo").height()/2), 
                left: $("#areaBody").offset().left + ($("#areaBody").width()/2) - ($("#robo").width()/2) 
            }
        );

        $http.get("ground").then(function(response){
        	var GROUND = new Array(2);
        	GROUND[0] = response.data.width; // X    		
        	GROUND[1] = response.data.height; // Y  
        	
            var spaceMove = $("#area").width() / GROUND[0];
            self.MATRIZ_X[0] =  Math.round($("#area").offset().left)-20;
            for(var i = 1; i < 9; i++){
                self.MATRIZ_X[i] =  Math.round(self.MATRIZ_X[i-1] + spaceMove);
            }
            self.MATRIZ_X[9] =  Math.round($("body").width() - $("#area").offset().left - $("#robo").width())+20;
            
            spaceMove = $("#area").height() / GROUND[1];
            self.MATRIZ_Y[0] =  Math.round($("#area").offset().top)-15;
            for(var i = 1; i < 9; i++){
                self.MATRIZ_Y[i] = Math.round(self.MATRIZ_Y[i-1] + spaceMove);
            }
            self.MATRIZ_Y[9] =  Math.round($("body").height() - $("#robo").height())-20;        	
        	
    	});

        self.refresh();
    }

	self.display = function(robot){
        var positionX = robot.actualPosition[0];
        var positionY = robot.actualPosition[1];
        $("#robo").offset({ top: self.MATRIZ_Y[positionY], left: self.MATRIZ_X[positionX] });
        console.log("positionX["+positionX+"] - positionY["+positionY+"]" );
	}	            
    
	var socket = new SockJS('/robot/topic');
	var stompClient = null;
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
    	stompClient.subscribe('/server/position', function (response) {
    		console.log("subscribe()...");
    		self.display(JSON.parse(response.body)); 
    	});
    });	
	
	self.moveToDown = function(){
    	$http.get("move/down").then(function(response){
    		self.display(response.data);    		
    	});
		
	}	            
    
	self.moveToRight = function(){
		$http.get("move/right").then(function(response){
			self.display(response.data);    		
		});
		
	}	            
	
	self.moveToUp = function(){
		$http.get("move/up").then(function(response){
			self.display(response.data);    		
		});
		
	}	            
	
	self.moveToLeft = function(){
		$http.get("move/left").then(function(response){
			self.display(response.data);    		
		});
		
	}	            
	
	self.refresh = function(){
    	$http.get("position").then(function(response){
    		self.display(response.data);	            		
    	});
	}    
	
    init();

}]);