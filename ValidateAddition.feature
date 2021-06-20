Feature: Validate addition

  Background:
    * def getMediaURL = http://prv.aos.PRSMQA2.dds.net/prisma-masterdata-service/internal/xmedia/media
	* configure headers = read('classpath:corejs/header.js')
	* header PREAUTH_USER_ID = USER_ID

 
  Scenario: Validate get call
    Given url getMediaURL
    And param agencyMediaoceanId = 35-1-6MSH-7B
    And param systemCode = P
    When method get
    Then status 200
	
	
