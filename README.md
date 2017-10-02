# vending-machine
Vending Machine Kata 

This is the Vending Machine Kata, no additional setup is required other then importing the product and running it.

This Kata is built on JavaFX using Netbeans IDE, it provides a easy to use GUI for the vending machine.

To run vending machine: 
	1. Go to Vending Machine/dist/vending machine.jar
	2. Double click to run

To examine code:
	1. Open netbeans
	2. go to file -> import -> import from zip
	3. select zip and output folder

Test case running

	1. Accept Coins - run program and enter coin names in the text field seperated by commas. Pennies 	   will be rejected and sent to coin return. 
 
	2. Select Product - after coin input, prices will reflect the amount of currency entered. $0.00 will 	           show beside the product when the sufficient amount of change has been added. Select product to 	           purchase.
	
	3. Make Change - After purchase, dialog will popup and display your change. Select of to retrieve 	           your change.

	4. Return Coins - After entering your coins, press the "Return Money" button and accept the dialog 	           which will state your money is being returned. 

	5. Sold Out - After each purchase the inventory for each product will update, after selecting a 	           product at zero a sold out dialog will be shown.
	
	6. Exact Change Only - Cola requires exact change only, selecting without exact change will prompt a 	   dialog that lets you know that exact change is required and will open insert change dialog.