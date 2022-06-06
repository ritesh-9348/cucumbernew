
Feature: Click on About Us in Footer
  Scenario: Go to footer and select About us
  Given User launch the browser "https://www.nobroker.in/"
  When Go to footer section and click on About us
  Then Go to contact us section
  And print the text of the heading 
 