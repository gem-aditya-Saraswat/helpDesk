@regression
Feature: Ticket Creation

  Scenario Outline: Create an Incident without file
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When click on create ticket
    And Fill Details <Subject>, <Description>
    And Select ticket type as Incident
    And Select Department as <Department>
    Then User verify the incident with details <Subject>, <Description>
    And User Clicks on Submit Button
    And User fetch the Incident ID
    Then Verify Incident with <Subject>, <Description> without file
    Examples:
      | Subject       | Description             | Department |
      | Sample Ticket | Sample Description text | IT         |
      | Sample Ticket | Sample Description text | Accounts   |
      | Sample Ticket | Sample Description text | HR         |
      | Sample Ticket | Sample Description text | Admin      |

  Scenario Outline: Create an Incident with file
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When click on create ticket
    And Fill Details <Subject>, <Description>
    And Select ticket type as Incident
    And Select Department as <Department>
    And User uploads file from <filepath>
    Then User verify the incident with details <Subject>, <Description>
    And User Clicks on Submit Button
    And User fetch the Incident ID
    Then Verify Incident with <Subject>, <Description> with file
    Examples:
      | Subject       | Description             | Department | filepath                                  |
      | Sample Ticket | Sample Description text | IT         | src\test\resources\sampleFiles\sample.doc |
      | Sample Ticket | Sample Description text | Accounts   | src\test\resources\sampleFiles\sample.doc |
      | Sample Ticket | Sample Description text | HR         | src\test\resources\sampleFiles\sample.doc |
      | Sample Ticket | Sample Description text | Admin      | src\test\resources\sampleFiles\sample.doc |

  Scenario: Close button click verify
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When click on create ticket
    Then User clicks on close button

  Scenario Outline: Create an Request without file
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When click on create ticket
    And Fill Details <Subject>, <Description>
    And Select ticket type as Request
    And Select Department as <Department>
    And User Fill Details <Category>, <Sub-Category> details
    And User Clicks on Submit Button
    And User fetch the Request ID
    Then Verify Request with <Subject>, <Description> without file
    Examples:
      | Subject        | Description                 | Department | Category         | Sub-Category                   |
      | Sample Request | This is for Request testing | IT         | sample req type  | sub type 1                     |
      | Sample Request | This is for Request testing | IT         | sample req type  | sub type 2                     |
      | Sample Request | This is for Request testing | IT         | Access Request   | Creation Of DL/o365 group      |
      | Sample Request | This is for Request testing | IT         | Access Request   | Modification of DL/o365 group  |
      | Sample Request | This is for Request testing | IT         | Access Request   | Modification of security group |
      | Sample Request | This is for Request testing | IT         | Access Request   | New Security group             |
      | Sample Request | This is for Request testing | IT         | Hardware         | Docking station                |
      | Sample Request | This is for Request testing | IT         | Hardware         | Keyboard                       |
      | Sample Request | This is for Request testing | IT         | Hardware         | Monitor                        |
      | Sample Request | This is for Request testing | IT         | Hardware         | Mouse                          |
      | Sample Request | This is for Request testing | IT         | Software         | Software License               |
      | Sample Request | This is for Request testing | IT         | Software         | Unlicensed/OpenSource          |
      | Sample Request | This is for Request testing | Accounts   | Travel           | Travel cards                   |
      | Sample Request | This is for Request testing | Accounts   | Travel           | Travel insurance               |
      | Sample Request | This is for Request testing | HR         | Leave Management | Compensatory Off               |
      | Sample Request | This is for Request testing | HR         | Leave Management | LNSA                           |
      | Sample Request | This is for Request testing | HR         | Leave Management | Missed Leaves                  |
      | Sample Request | This is for Request testing | Admin      | sample req type  | sub type 3                     |
      | Sample Request | This is for Request testing | Admin      | sample req type  | sub type 4                     |
      | Sample Request | This is for Request testing | Admin      | Facility         | Courier requirements           |
      | Sample Request | This is for Request testing | Admin      | Facility         | Lunch in office                |
      | Sample Request | This is for Request testing | Admin      | Facility         | Chair                          |
      | Sample Request | This is for Request testing | Admin      | Hardware         | Mobile Devices                 |
      | Sample Request | This is for Request testing | Admin      | Registration     | Access card or Face scanner    |
      | Sample Request | This is for Request testing | Admin      | Travel           |                                |

  Scenario Outline: Create an Request with file
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When click on create ticket
    And Fill Details <Subject>, <Description>
    And Select ticket type as Request
    And Select Department as <Department>
    And User Fill Details <Category>, <Sub-Category> details
    And User uploads file from <filepath>
    And User Clicks on Submit Button
    And User fetch the Request ID
    Then Verify Request with <Subject>, <Description> with file
    Examples:
      | Subject        | Description                 | Department | Category         | Sub-Category                   | filepath                                  |
      | Sample Request | This is for Request testing | IT         | sample req type  | sub type 1                     | src\test\resources\sampleFiles\sample.doc |
      | Sample Request | This is for Request testing | IT         | sample req type  | sub type 2                     | src\test\resources\sampleFiles\sample.doc |
      | Sample Request | This is for Request testing | IT         | Access Request   | Creation Of DL/o365 group      | src\test\resources\sampleFiles\sample.doc |
      | Sample Request | This is for Request testing | IT         | Access Request   | Modification of DL/o365 group  | src\test\resources\sampleFiles\sample.doc |
      | Sample Request | This is for Request testing | IT         | Access Request   | Modification of security group | src\test\resources\sampleFiles\sample.doc |
      | Sample Request | This is for Request testing | IT         | Access Request   | New Security group             | src\test\resources\sampleFiles\sample.doc |
      | Sample Request | This is for Request testing | IT         | Hardware         | Docking station                | src\test\resources\sampleFiles\sample.doc |
      | Sample Request | This is for Request testing | IT         | Hardware         | Keyboard                       | src\test\resources\sampleFiles\sample.doc |
      | Sample Request | This is for Request testing | IT         | Hardware         | Monitor                        | src\test\resources\sampleFiles\sample.doc |
      | Sample Request | This is for Request testing | IT         | Hardware         | Mouse                          | src\test\resources\sampleFiles\sample.doc |
      | Sample Request | This is for Request testing | IT         | Software         | Software License               | src\test\resources\sampleFiles\sample.doc |
      | Sample Request | This is for Request testing | IT         | Software         | Unlicensed/OpenSource          | src\test\resources\sampleFiles\sample.doc |
      | Sample Request | This is for Request testing | Accounts   | Travel           | Travel cards                   | src\test\resources\sampleFiles\sample.doc |
      | Sample Request | This is for Request testing | Accounts   | Travel           | Travel insurance               | src\test\resources\sampleFiles\sample.doc |
      | Sample Request | This is for Request testing | HR         | Leave Management | Compensatory Off               | src\test\resources\sampleFiles\sample.doc |
      | Sample Request | This is for Request testing | HR         | Leave Management | LNSA                           | src\test\resources\sampleFiles\sample.doc |
      | Sample Request | This is for Request testing | HR         | Leave Management | Missed Leaves                  | src\test\resources\sampleFiles\sample.doc |
      | Sample Request | This is for Request testing | Admin      | sample req type  | sub type 3                     | src\test\resources\sampleFiles\sample.doc |
      | Sample Request | This is for Request testing | Admin      | sample req type  | sub type 4                     | src\test\resources\sampleFiles\sample.doc |
      | Sample Request | This is for Request testing | Admin      | Facility         | Courier requirements           | src\test\resources\sampleFiles\sample.doc |
      | Sample Request | This is for Request testing | Admin      | Facility         | Lunch in office                | src\test\resources\sampleFiles\sample.doc |
      | Sample Request | This is for Request testing | Admin      | Facility         | Chair                          | src\test\resources\sampleFiles\sample.doc |
      | Sample Request | This is for Request testing | Admin      | Hardware         | Mobile Devices                 | src\test\resources\sampleFiles\sample.doc |
      | Sample Request | This is for Request testing | Admin      | Registration     | Access card or Face scanner    | src\test\resources\sampleFiles\sample.doc |
      | Sample Request | This is for Request testing | Admin      | Travel           |                                | src\test\resources\sampleFiles\sample.doc |

  Scenario Outline: Create Incident without filling mandatory fields
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When click on create ticket
    And User Clicks on Submit Button
    Then Verify ticket not created and remaining mandatory fields
    And User fill incident "subject" as <Subject>
    And User Clicks on Submit Button
    Then Verify ticket not created and remaining mandatory fields
    And User fill incident "description" as <Description>
    And User Clicks on Submit Button
    Then Verify ticket not created and remaining mandatory fields
    And User fill incident "department" as <Department>
    And User clicks on close button
    Examples:
      | Subject       | Description             | Department |
      | Sample ticket | Sample Description text | IT         |
      | Sample ticket | Sample Description text | HR         |

  Scenario Outline: Create Request without filling mandatory fields
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When click on create ticket
    And User Clicks on Submit Button
    Then Verify ticket not created and remaining mandatory fields
    And User fill request "subject" as <Subject>
    And User Clicks on Submit Button
    Then Verify ticket not created and remaining mandatory fields
    And User fill request "description" as <Description>
    And User Clicks on Submit Button
    Then Verify ticket not created and remaining mandatory fields
    And User fill request "department" as <Department>
    And User Clicks on Submit Button
    Then Verify ticket not created and remaining mandatory fields
    And User fill request "category" as <Category>
    And User Clicks on Submit Button
    Then Verify ticket not created and remaining mandatory fields
    And User fill request "Sub-Category" as <Sub-Category>
    And User clicks on close button
    Examples:
      | Subject       | Description             | Department | Category        | Sub-Category |
      | Sample ticket | Sample Description text | IT         | sample req type | sub type 1   |
      | Sample ticket | Sample Description Text | HR         | sample req type | sub type 1   |

  Scenario: Upload files with valid size
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When click on create ticket
    And User upload "valid" size file
    Then Verify file upload for the "valid" scenario

  Scenario: Upload files with Invalid size
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When click on create ticket
    And User upload "invalid" size file
    Then Verify file upload for the "invalid" scenario

  Scenario: Upload files with valid Extentions
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When click on create ticket
    And User upload "valid" extensions file
    Then Verify file upload for the "valid" scenario

  Scenario: Upload files with invalid Extentions
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When click on create ticket
    And User upload "invalid" extensions file
    Then Verify file upload for the "invalid" scenario

  Scenario: Comment in a ticket
    Given User Do Login with "Userid" and "Password" on "Employee" view
    When click on create ticket
    And Fill Details Sample ticket, Sample Description text
    And Select ticket type as Incident
    And Select Department as IT
    Then User verify the incident with details Sample ticket, Sample Description text
    And User Clicks on Submit Button
    And User get the Incident ID
    And User search the Ticket ID
    And User click on the ticket
    And User comment on the ticket
