Feature: Validate addition

  Background:
    * def getMediaURL = <endpoint>
	* configure headers = read('classpath:corejs/header.js')
	* header PREAUTH_USER_ID = <userid>

 
  Scenario: Validate get call
    Given url getMediaURL
    And param <key> = <value>
    And param <key> = <value>
    When method <method>
    Then status 200
	
	
