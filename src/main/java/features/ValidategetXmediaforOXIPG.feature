Feature: ValidategetXmediaforOXIPG

Background:

* def url = http://prv.aos.PRSMQA2.dds.net/prisma-masterdata-service/internal/xmedia/media
* configure headers = read('classpath:corejs/header.js')
* header PREAUTH_USER_ID = {{oxtest11@ipg.com}}
Then status 200

Scenario: Validate ValidategetXmediaforOXIPG
Given url http://prv.aos.PRSMQA2.dds.net/prisma-masterdata-service/internal/xmedia/media
And param agencyMediaoceanId = 35-1-6MSH-7B
And param systemCode = P
When method GET