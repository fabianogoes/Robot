app.controller("IndexController", ['$rootScope', '$http', '$timeout', '$window', function($rootScope, $http, $timeout, $window){

    self = this;
    self.MATRIZ_X = new Array(10);  
    self.MATRIZ_Y = new Array(10);  
	self.position = null;
	self.scenario = "House";
	self.backgroundImageUrl = "img/ground-house.jpg";
	
     
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
        	GROUND[1] = response.data.length; // Y  
        	
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

        self.actualPosition();
    }

    self.actualPosition = function(){
    	$http.get("position").then(function(response){
    		self.displayPersonagem(response.data);	            		
    	});
    } 
    
	self.displayPersonagem = function(position){
		console.log("displayPersonagem()...");
		console.log(position);
		self.position = position;
        $("#robo").offset({ top: self.MATRIZ_Y[position.vertical-1], left: self.MATRIZ_X[position.horizontal-1] });
	}	            
    
	self.moveTo = function(direction){
		console.log("moveTo("+direction+")");
    	$http.get("move/"+direction).then(function(response){
    		self.displayPersonagem(response.data);    		
    	});
		
	}	
	
	self.changeScenario = function(value){
		console.log(value);
		if(value == "Star Wars"){
			console.log("Star Wars - Selected");
			self.backgroundImageUrl = "img/ground-starwars.jpg";
			self.imageRobo = "img/robot-starwars.png";
		}else if(value == "House"){
			console.log("House - Selected");
			self.backgroundImageUrl = "img/ground-house.jpg";
			self.imageRobo = "img/robot-house.png";
		}
		console.log("backgroundImageUrl = "+self.backgroundImageUrl);
		$('#areaBody').css("background-image", "url("+self.backgroundImageUrl+")");
		$('#robo').attr('src', self.imageRobo);
	}
    
	/**
	 * Connect to Backend by Websocket to refresh Position on realtime
	 */
	//var socket = new SockJS('http://localhost:8080/robot/topic');
	var socket = new SockJS('/robot/topic');
	var stompClient = null;
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
    	console.log("connect()...");
    	stompClient.subscribe('/server/position', function (response) {
    		console.log("subscribe()..")
    		self.actualPosition();
    	});
    });		
	
    init();

}]);