Feature: Testing different request on the student application

Scenario: Verify if the placeholder application can be accessed by users
  When User sends a GET request to posts endpoint
  Then User must get back a valid status code 200

  Scenario: Verify if the response has the keys such as userId,id,title and body
    When User sends a GET reques with userId to posts endpoint
    Then Response body has userId key "userId"
    And Response body has id key "id"
    And Response body has title key "title"
    And Response body has body key "body"