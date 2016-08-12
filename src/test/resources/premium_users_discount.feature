Feature: Premium users can get special discount when placing order. 
	Orders with discount exceeding configured discount limits for profile should be rejected

Scenario Outline: Orders with discount not exceeding limit configured for profile will be processed 
	Given User have profile '<profile>' 
	When he creates order with discount '<discount>' 
	Then then order is processed 
	
	Examples: 
		| profile   | discount |
		| Platinium | 20       |	
		| Platinium | 10       |	
		| Gold      | 10       |
		| Silver    | 5        |
		
		
Scenario Outline: Orders with dicscount exceeding limit configured for profile are rejected 
	Given User have profile '<profile>' 
	When he creates order with discount '<discount>' 
	Then order is rejected with error '<error>' 
	
	Examples: 
		| profile   | discount | error                                    |
		| Platinium | 21       | Platinium user can have max 20.0 discount  |	
		| Gold      | 11       | Gold user can have max 10.0 discount       |
		| Silver    | 6        | Silver user can have max 5.0 discount	  |
		
		
Scenario: Unknown profile should be rejected if discount is greater than 0 
	Given User have profile 'Unregistered profile' 
	When he creates order with discount '1' 
	Then order is rejected with error 'No discount allowed for profile 'Unregistered profile'' 
	
	
Scenario: Orders with unknown profile and without discount are processed correctly 
	Given User have profile 'Unregistered profile' 
	When he creates order with discount '0' 
	Then then order is processed 
