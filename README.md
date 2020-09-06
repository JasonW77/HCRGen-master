# ITEC_2905_Capstone

# **Javafx HCRGen application**

## Synopsis
This is an application to Generate reports for Tong's Fire Extinguisher Sales and Service, 

## Motivation
This is a program for the ITEC_2905_Capstone class at Southwest Tech. 
I created this program for my Capstone project in that class. In cooperation with Tong's Fire Extinguisher Sales and Service

## How to use
This program is utilized via a javafx GUI.

The user will enter customer information for the report through the GUI using text fields, dropdown boxes, date picker, and text area.
![Alt text](https://github.com/JasonW77/ITEC_2905_Capstone/blob/master/screens/topscreen.png)

The user will add report information for the service that was completed in the kitchen hodd area of the GUI.
![Alt text](https://github.com/JasonW77/ITEC_2905_Capstone/blob/master/screens/KitchenScreen.png)

The User will finish the report after all the information has been input, by clicking the print preview button on the bottom of the page.
![Alt text](https://github.com/JasonW77/ITEC_2905_Capstone/blob/master/screens/Bottomscreen.png)

here is a screen shot of the report that will be generated.
![Alt text](https://github.com/JasonW77/ITEC_2905_Capstone/blob/master/screens/reportscreen.png)

the User can capture the report as a file in two ways, by clicking the print button on the print pane, or by selecting the page and hitting the enter key.
![Alt text](https://github.com/JasonW77/ITEC_2905_Capstone/blob/master/screens/printscreen.png)

## Code Example
here is a code example of the user adding information through the UI using radio buttons.
```
	public void setYes(String input, String btName){
		switch (btName){
			case "dKWrb1": dkWSt = "Yes"; break;
			case "fWPrb1": fWPSt = "Yes"; break;
			case "dIFrb1": dIFSt = "Yes"; break;
			case "aFHrb1": aFHSt = "Yes"; break;
			case "fDWrb1": fDWSt = "Yes"; break;
			case "hLWrb1": hLWSt = "Yes"; break;
			case "hGPrb1": hGPSt = "Yes"; break;
			case "rTCSrb1": rTCSSt = "Yes"; break;
			case "fWLRrb1": fWLRSt = "Yes"; break;
			case "rANFROrb1": rANFROSt = "Yes"; break;
			case "hIWDrb1": hIWDSt = "Yes"; break;
			case "kFCEWDrb1": kFCEWDSt = "Yes"; break;
			case "oARCrb1": oARCSt = "Yes"; break;
			case "hSFPWrb1": hSFPWSt = "Yes"; break;
			case "hDGLrb1": hDGLSt = "Yes"; break;
			case "aPGQrb1": aPGQSt = "Yes"; break;
			case "sDWTrb1": sDWTSt = "Yes"; break;
			case "pLRrb1": pLRSt = "Yes"; break;
			case "hSRrb1": hSRSt = "Yes"; break;
			case "photoTrb1": photoTSt = "Yes"; break;
		}
	}

```
## Code Example
here is a code example of part of the Report that is generated.

```
			+ "\n"
				+ "Notes to cleaning Technicians:\n"
				+ taServ1.getText() + "\n"
				+ "\n"
				+ "\n"
				+ "                   KITCHEN EXHAUST CLEANING SERVICE REPORT FOR HOOD:  " + moreHoods2.getText()+ "\n"
				+ "Type of Service completed - Initial Service: " + serviceInit + "                 Regular Service: " + serviceReg + "                Inspection: " + serviceInsp + "\n"
				+ "Check in: \t\t\t\t\t\t\t\t\t\t Check Out: " + "\n"
				+ "1. Key works: \t\t\t\t\t\t\t" + dkWSt + "\t\t\t" + "1. Fans working and left running:\t\t\t\t " + fWLRSt +"\n"
				+ "2. Fans working propperly: \t\t\t\t" + fWPSt + "\t\t\t" + "2. Roof area near fan rised off:\t\t\t\t " + rANFROSt +"\n"
				+ "3. Defects in fan wiring: \t\t\t\t" + dIFSt + "\t\t\t" + "3. Hood interior wiped dry:\t\t\t\t\t " + hIWDSt +"\n"
				+ "4. Fans hinged: \t\t\t\t\t\t" + aFHSt + "\t\t\t" + "4. Kitchen floor clean/Equipment wiped down:\t " + kFCEWDSt + "\n"
				+ "5. Floor drains working: \t\t\t\t" + fDWSt + "\t\t\t" + "5. Outside area rinsed and clean:\t\t\t\t " + oARCSt + "\n"
				+ "6. Hood lights working: \t\t\t\t\t" + hLWSt + "\t\t\t" + "6. Hood, Stack, Fan pressure washed:\t\t\t " + hSFPWSt + "\n"
				+ "7. Hood globes present: \t\t\t\t" + hGPSt + "\t\t\t" + "7. Any horizontal ductwork:\t\t\t\t\t " + aFHSt + "\n"
				+ "8. Rooftop grease containment system: \t" + rTCSSt + "\t\t\t" + "8. any acess panels:\t\t\t\t\t\t " + aPGQSt + "\n"
				+ "9. Grease buildup around roof fan: \t\t" + gBURFSt + "\t\t\t" + "9. Stack/Ductwork water tight:\t\t\t\t " + sDWTSt + "\n"
				+ "10. Grease build up on fan blades: \t\t" + gBUFBSt + "\t\t\t" + "10. Pilot lights reignited:\t\t\t\t\t " + pLRSt + "\n"
				+ "11. Grease build up on Stacks/Ductwork: \t" + gBUSDSt + "\t\t\t" + "11. Photos taken:\t\t\t\t\t\t\t " + photoTSt + "\n"
				+ "12. Grease build up on Hoods: \t\t\t" + gBUHSt + "\t\t\t" + "12. Hood Sticker replaced:\t\t\t\t\t " + hSRSt + "\n"
				+ "13. Grease build up on Filter: \t\t\t" + gBUFiSt + "\t\t\t" + "Inaccessible areas?:  " + inAccCBSt + "            Key Available?:  " + keyCBSt +"\n" + "\n"
				+ "Cleaning Technician that performed service:      " + techtf.getValue() + "\n"
				+ "Date Completed: " + techDatetf.getValue() 
				+ "                  Time In: " + tfTI.getText()+ "                  Time Out: " + tfTO.getText()+ "\n"+ "\n"
				+ "Miscellaneous Notes:\n"
				+ miscNotTa.getText() + "\n"
				+ "IN THE EVENT OF DEFAULT, TONG'S FIRE EXTINGUISHER SHALL BE ENTITLED TO RECOVER COST OF COLLECTION, \nINCLUDING REASONABLE ATTORNEY FEES. \nACKNOWLEDGMENT OF KITCHEN CONDITION & KEC SERVICE COMPLETED. BY SIGNING BELOW THE CUSTOMER \nACKNOWLEDGES SERVICE WAS COMPLETED AND THE KITCHEN WAS LEFT CLEAN AND IN SATISFACTORY CONDITION.\n"
				+ "\nCustomer Signature: " + custSignSt + "                                                                                                         Date:\n"
				+ "                                   --------------------------------------------------------------              -------------------------"  
				+ "\nClaims of unsatisfactory workmanship must be made within 48 hours. Invoices are subject to an intrest charge of the lesser of \n1.5% per month(18% per year) or the maximum rate allowed by law on any unpaid invoices outstanding after 30 days from date \nof service. The Customer herby waives thier rights of subrogation by thier insurance carrier against Tong's Fire Extinguisher \nunder any fire or liability insurance policy.\n"
				
```

## Future Goals, updates, Bugs, and fixes.
*email functionality to send the customer the report directly from the Application.
*Photograph integration, access the camera from the aplication and attach the files along with the report for email to customer.
*Fix the wrap text problem for the notes TextArea in the print stage.

