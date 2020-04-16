Feature: To verify API methods with RestAssured 

Scenario: Verify GET method 
	Given I want to execute /employees endpoint 
	When I submit the GET request 
	Then i should get status code 200 
	# and Then more requirements
	
Scenario: Verify POST method 
	Given I want to execute /create endpoint 
	When I submit the POST request 
	Then i should get status code 200 
	# and Then more requirements
	
	