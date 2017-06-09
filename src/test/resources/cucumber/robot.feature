Feature: Robot
  As a user
  I want to use send commands to Robot move to
  So The robot must execute the received command and move 

  Scenario: Constructor Robot
    Given that robot is created
    When I get area 
    Then the area should have [10][10]  
  
  Scenario: Move to Right
    Given That exist a Robot in area
    When I send a command of movement to Right
    Then the robot must moved to Right
    
  Scenario: Move to Up
    Given That exist a Robot in area
    When I send a command of movement to Up
    Then the robot must moved to Up  
    
  Scenario: Move to Left
    Given That exist a Robot in area
    When I send a command of movement to Left
    Then the robot must moved to Left          
    
  Scenario: Move to Down
    Given That exist a Robot in area
    When I send a command of movement to Down
    Then the robot must moved to Down  
    
