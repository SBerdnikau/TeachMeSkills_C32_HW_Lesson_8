# Here, the following tasks are implemented:

*Task 1*

1. request the path and file name from the console
2. make the createParser method static and get rid of the need to create the parserFabric object
3. replace "" with the file name obtained from the scanner
4. implement a test scenario
5. add constants for card transfer limits
6. use these constants in methods for checking card limits before transfer
7. make the return value Check (the class is in the document package)
8. add input parameters to the method: card from..., card to..., transfer amount
9. implement the CardTransferService interface
10. add fields: transfer amount, transfer date, account number or card number
11. create a method for displaying receipt information on the screen
12. add fields at your discretion in the Invoice class
13. add the input parameter "amount for transfer" BaseCard to the method
14. implement a limit check. the essence of the check is that the amount for transfer does not exceed the limit in the checkCardLimitTransfer() method
15. (optional) * try to rewrite it to a switch-case construction, maybe this will be a more capacious entry in the ParserFabric class
16. add Docx parser
