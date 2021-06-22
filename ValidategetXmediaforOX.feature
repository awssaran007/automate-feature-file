Feature: ValidategetXmediaforOX

Background:

* def url = http://prv.aos.PRSMQA2.dds.net/prisma-masterdata-service/internal/xmedia/media
* configure headers = read('classpath:corejs/header.js')
* header PREAUTH_USER_ID = 331079957
Then status 200

Scenario: Validate ValidategetXmediaforOX
Given url http://prv.aos.PRSMQA2.dds.net/prisma-masterdata-service/internal/xmedia/media
And param agencyMediaoceanId = 35-1-6MSH-7B
And param systemCode = P
When method GET