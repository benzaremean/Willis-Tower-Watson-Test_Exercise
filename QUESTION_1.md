## (a) 
My strategy to test the currency conversion form will include

### 1. Unit Tests

I will ensure that all unique scenarios regarding rules for exchanging currency pairs and applying commission are covered at unit level
Key things to consider are 
    1. ensuring that the calculations are correct 
    2. the correct decimal places are applied
    3. And agreed rounding rules are correctly applied

### Integration Tests

Will ensure that APIs for retrieving and saving data in database are thoroughly tested in line with the functionality

###  User Interface Tests 

Validation
Ensure that the agreed validation feedback is provided when user inputs are not valid

Scenarios include
    1. Submitting empty form (no inputs selected)
    2. Base currency not provided
    3. Target currency not provided
    4. Amount to convert not provided

Key Business Functional Scenarios 
    1. Commission Included Scenarios
    2. No commission included scenarios

###  Non-Functional Tests
- ideally I will chase up for some non functional requirements regarding performance of the application
  and I will script and execute some non functional tests to ensure these are met

###  Exploratory Tests

## (b)
Maintain Currencies

Validation
Ensure that the agreed validation feedback is provided when user inputs are not valid

Key Functional Scenarios 
    1. Add new currency (validate by querying database)
    2. Add existing currency
    3. Edit Currency (validate by querying database)
    4. Delete Currency (validate by querying database)

## (c)
Maintain Commission Rates

###  Unit
Ensure at unit level that minimum commission scenarios are adequately tested
Apply boundary analysis to test ranges for commission rates

###  Interface
Validation
Ensure that the agreed validation feedback is provided when user inputs are not valid

###  Integration
Ensure that values entered via GUI are saved in database


 ## (d) Accessibility
Below are some guidelines I would push for
Ensure html form has the right semantics as this is the foundation for accessibility
    - Provide descriptive Labels for all fields
    - Group related groups of inputs using Fieldset tag and Legend for group descriptive text
Ensure application can be fully operated by keyboard only

Now regarding the testing to be carried out, this will be scoped to individuals with Visual, Cognitive and Literacy disabilities.

With regards to how it would be performed this will include manual tests and also using an accessibility audit tool like Wave to continuously audit and iterate towards improving the accessibility scoring of the application


## (e)
Provide ids for form inputs or data testing attributes to the html so that it’s easy to identify elements uniquely

## (f)
Will introduce internationalisation testing to ensure that the application enables localization for the supported locales languages etc

## (g)
1. Mandatory fields are not marked
2. Neither are non mandatory fields made clear
3. No hints provided for certain inputs
4. Use of abbreviation like N/A not suitable for most end users
5. The amount in target currency would ideally not be visible until after valid inputs are submitted