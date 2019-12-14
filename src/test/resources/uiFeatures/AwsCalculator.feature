
@TECTC-110 @ui @SmokeTest
  Feature: Testing AWS Calculator

    Scenario: Testing calculation of prices for EC2 instances
      Given User navigate to AWS Calculator homepage
      When User adds 2 EC2 Instances
      And User adds 2 EC2 Dedicated Hosts
      Then Total estimated cost has to match with prices on "testData" "Sheet2" excel file