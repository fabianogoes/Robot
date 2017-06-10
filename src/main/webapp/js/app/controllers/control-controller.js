app.controller('ControlController', ['$timeout','$http', function($timeout, $http){
	
	var self = this;

	init = function(){
		$http.get("position").then(function(response){
			self.position = response.data;              		
    	});
	}
	
	self.movePersonagem = function(direction){
		console.log("movePersonagem("+direction+")");
    	$http.get("move/"+direction).then(function(response){
    		self.position = response.data;    		
    	});
	}
	
	init();
	
}])