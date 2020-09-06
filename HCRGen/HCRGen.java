/**
 *  * <h1>JavaDoc</h1>
 * 
 *  HCRGen application for generating Hood Cleaning Reports (or HCRGen.java).
 * 	I created this program for the South west Technical College software Development_Capstone Project 2019-20
 * 	 
 * 
	<p>Date created 8/17/2020 <p/>
	
	@author Jason Waters
 */
package HCRGen;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.control.ScrollPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.AnchorPane;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import javax.imageio.ImageIO;
import java.awt.image.*;
import java.awt.Rectangle;
import java.awt.Robot;

/*to do list:
	*Fix the wrap text problem for the notes TextArea in the print stage.
	*On action event for the technician notes and miscellaneous notes text areas. to help with flow
	*Remove cleaning, claims, and Event notice from user UI

*/
/**
 * 
 */
public class HCRGen extends Application {
	String licNumTech1 = "Lic. # KE82431";
	String licNumTech2 = "Lic. # KE113954";
	String address1 = "P.O. Box 3101 \nCedar City, UT 84721";
	String address1p = "P.O. Box 3101";
	String address1c = "Cedar City,";
	String address1z = "UT 84721";
	String tech1p = "1-435-201-2182";
	String address2 = "P.O. Box 135 \nElsinore, UT 84724";
	String address2p = "P.O. Box 135";
	String address2c = "Elsinore,";
	String address2z = "UT 84724";
	String tech2p = "1-435-896-3840";	
	int whichTech = 0;
	String endTech1 = "Tong's Fire Extinguisher Sales and Service \n" + address1p + "\n" + address1c + address1z + "\n" + tech1p + "\n" + licNumTech1;;
	String endTech1l = " ";
	String phoneNum = "(435) 201-2182";
	String serviceInit = "";
	String serviceReg = "";
	String serviceInsp = "";
	String dkWSt = "N/A";
	String fWPSt = "N/A";
	String dIFSt = "N/A";
	String aFHSt = "N/A";
	String fDWSt = "N/A";
	String hLWSt = "N/A";
	String hGPSt = "N/A";
	String rTCSSt = "N/A";
	String gBURFSt = "N/A";
	String gBUFBSt = "N/A";
	String gBUSDSt = "N/A";
	String gBUHSt = "N/A";
	String gBUFiSt = "N/A";
	String inAccCBSt = "N/A";
	String fWLRSt = "N/A";
	String rANFROSt = "N/A";
	String hIWDSt = "N/A";
	String kFCEWDSt = "N/A";
	String oARCSt = "N/A";
	String hSFPWSt = "N/A";
	String hDGLSt = "N/A";
	String aPGQSt = "N/A";
	String sDWTSt = "N/A";
	String pLRSt = "N/A";
	String hSRSt = "N/A";
	String photoTSt = "N/A";
	String keyCBSt = "N/A";
	String noAvailCBSt = "N/A";
	String moreHoodsSt = " ";
	LocalDate execDate;
	int repDate = 0000;
	
	/**
	 * 
	 */
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException{
		//Create a main page VBox and set its attributes
		ScrollPane sp = new ScrollPane();
		VBox mainVB = new VBox();
		VBox.setVgrow(sp, Priority.ALWAYS);
		sp.setContent(mainVB);

		mainVB.setMinSize(400, 400);
		mainVB.setPadding(new Insets(10,10,10,10));
		mainVB.setAlignment(Pos.TOP_CENTER);

		//Create the main page HBoxs, VBoxs and set their attributes
		HBox hb1 = new HBox();
		hb1.setAlignment(Pos.TOP_CENTER);
		hb1.setPadding(new Insets(10,10,10,10));
		hb1.setSpacing(10);
		
		HBox hb2 = new HBox();
		hb2.setAlignment(Pos.TOP_CENTER);
		hb2.setPadding(new Insets(10,10,10,10));
		hb2.setSpacing(10);
		
		HBox hb3 = new HBox();
		hb3.setAlignment(Pos.TOP_CENTER);
		hb3.setPadding(new Insets(10,10,10,10));
		hb3.setSpacing(10);
		
		HBox hb4 = new HBox();
		hb4.setAlignment(Pos.TOP_CENTER);
		hb4.setPadding(new Insets(10,10,10,10));
		hb4.setSpacing(10);
		
		HBox hb5 = new HBox();
		hb5.setAlignment(Pos.TOP_CENTER);
		hb5.setPadding(new Insets(10,10,10,10));
		hb5.setSpacing(10);
		
		HBox hb6 = new HBox();
		hb6.setAlignment(Pos.TOP_LEFT);
		hb6.setPadding(new Insets(10,10,10,10));
		hb6.setSpacing(10);
		
		HBox hb7 = new HBox();
		hb7.setAlignment(Pos.TOP_LEFT);
		hb7.setPadding(new Insets(10,10,10,10));
		hb7.setSpacing(10);
		
		HBox hb8 = new HBox();
		hb8.setAlignment(Pos.TOP_LEFT);
		hb8.setPadding(new Insets(10,10,10,10));
		hb8.setSpacing(10);
		
		HBox hb9 = new HBox();
		hb9.setAlignment(Pos.TOP_LEFT);
		hb9.setPadding(new Insets(10,10,10,10));
		hb9.setSpacing(10);
		
		HBox hb10 = new HBox();
		hb10.setAlignment(Pos.TOP_LEFT);
		hb10.setPadding(new Insets(10,10,10,10));
		hb10.setSpacing(10);
		
		HBox hb11 = new HBox();
		hb11.setAlignment(Pos.TOP_LEFT);
		hb11.setPadding(new Insets(10,10,10,10));
		hb11.setSpacing(10);
		
		HBox hb12 = new HBox();
		hb12.setAlignment(Pos.TOP_LEFT);
		hb12.setPadding(new Insets(10,10,10,10));
		hb12.setSpacing(10);
			
		VBox vb1 = new VBox();
		vb1.setAlignment(Pos.BOTTOM_LEFT);
		vb1.setMinWidth(100);
		
		VBox vb2 = new VBox();
		vb2.setAlignment(Pos.BOTTOM_LEFT);
		vb2.setMinWidth(100);
		
		VBox vb3 = new VBox();
		vb3.setAlignment(Pos.TOP_CENTER);
		vb3.setMinWidth(100);
		
		VBox vb4 = new VBox();
		vb4.setAlignment(Pos.TOP_LEFT);
		vb4.setMinWidth(100);
		
		VBox vb5 = new VBox();
		vb5.setAlignment(Pos.TOP_LEFT);
		vb5.setMinWidth(100);
	/*
	Items that go in hb1 go here
		~ Imageview of logo
		~ Business Info
		~ Invoice box
	*/
		//create GridPane for the logo, business information and invoice Box
		GridPane headPane = new GridPane();
		headPane.setMinSize(200, 100);
		headPane.setPadding(new Insets(10,10,10,10));
		headPane.setVgap(50);
		headPane.setHgap(60);
		headPane.setAlignment(Pos.TOP_LEFT);
		headPane.setGridLinesVisible(false);
		
		//create ImageView for logo and place in the grid
		File f = new File("TONGS-FIRE-EXTINGUISHER-SALES-AND-SERVICE.jpg");
		String filLoc = f.getAbsolutePath();
		
		//Creating a Label
		Label logo = new Label();
		Label reportLogo = new Label();
		
		//Creating a graphic
		Image img = new Image(new FileInputStream(filLoc));
		ImageView view = new ImageView(img);
		view.setFitHeight(125);
		view.setFitWidth(225);
		view.setPreserveRatio(false);
		ImageView view2 = new ImageView(img);
		view2.setFitHeight(125);
		view2.setFitWidth(225);
		view2.setPreserveRatio(false);
		
		logo.setGraphic(view);
		reportLogo.setGraphic(view2);

		//create address box labels for Tong's Fire Extinguisher Sales and Service
		Label tongAdr1 = new Label(address1);
		Label tongAdr2 = new Label(address2);
		Label tongPhone = new Label(phoneNum);
		Label tongLicNum1 = new Label(licNumTech1);
		Label tongLicNum2 = new Label(licNumTech2);
		
		//Create Address VBox for Tong's Fire Extinguisher Sales and Service information
		vb1.getChildren().addAll(tongAdr1, tongAdr2, tongPhone, tongLicNum1, tongLicNum2);
		
		//Create Invoice HBox and place it in the pane
		VBox invVBox = new VBox();
		invVBox.setAlignment(Pos.TOP_LEFT);
		
		Label invRefNum = new Label(" Invoice Reference #");
		TextField tfInvoice = new TextField("####");
		tfInvoice.setFont(new Font("Cambria", 10));
		invVBox.getChildren().addAll(invRefNum, tfInvoice);
		
		//place boxes in the top pane
		headPane.add(logo, 0,0);		
		headPane.add(vb1, 1,0);
		headPane.add(invVBox, 2,0);
		
		//add completed headPane to hb1
		hb1.getChildren().addAll(headPane);
		
	/*
	Items that go in hb2 and go here
		~ Service Info Box
		~ Customer Info Box
	*/
		//Create Service Schedule Information box
		Label servSchLabel = new Label(" Service Scheduled with: ");
		Label storeCMLabel = new Label(" Store Closing Manager: ");
		Label dateOSLabel = new Label(" Date of Service: ");
		Label serviceELabel = new Label(" Service Frequency ");
		Label timeOSLabel = new Label(" Time of Service: ");
		TextField servSchTF = new TextField();
		servSchTF.setMinWidth(205);
		servSchTF.setFont(new Font("Cambria", 10));
		TextField storeCMTF = new TextField();
		storeCMTF.setFont(new Font("Cambria", 10));
		storeCMTF.setMaxWidth(275);
		DatePicker dateOSDP = new DatePicker();
		
		ComboBox<String> serviceECB = new ComboBox<String>();
		serviceECB.getItems().addAll("Annually", "Bi-Annually", "Quarterly");
		
		TextField timeOSTF = new TextField("00:00");
		timeOSTF.setFont(new Font("Cambria", 10));
		timeOSTF.setMaxWidth(75);
		
		GridPane servGrid = new GridPane();
		servGrid.setMinSize(400, 100);
				
		servGrid.add(servSchLabel,0,0);
		servGrid.add(servSchTF,1,0);
		servGrid.add(storeCMLabel,0,1);
		servGrid.add(storeCMTF,1,1);
		servGrid.add(dateOSLabel,0,2);
		servGrid.add(dateOSDP,1,2);
		servGrid.add(timeOSLabel,0,3);
		servGrid.add(timeOSTF,1,3);
		servGrid.add(serviceELabel,0,4);
		servGrid.add(serviceECB,1,4);

		servGrid.setAlignment(Pos.TOP_LEFT);
		
		//Create Second row of boxes for Customer information and place them on the grid
		Label custPhoneLabel = new Label(" Phone: ");
		Label custNameLabel = new Label(" Client: ");
		Label custAdrLabel = new Label(" Address: ");
		Label custAdrCityLabel = new Label(" City: ");
		Label custAdrStateLabel = new Label(" State: ");
		Label custAdrZipLabel = new Label(" Zip: ");
		
		TextField tfcustPhone = new TextField("Phone");
		tfcustPhone.setFont(new Font("Cambria", 10));
		tfcustPhone.setMaxWidth(115);
		TextField tfcustName = new TextField("Customer Name");
		tfcustName.setFont(new Font("Cambria", 10));
		tfcustName.setMinWidth(205);
		TextField tfcustAdr = new TextField("Address");
		tfcustAdr.setFont(new Font("Cambria", 10));
		tfcustAdr.setMaxWidth(275);
		TextField tfcustAdrCity = new TextField("City");
		tfcustAdrCity.setFont(new Font("Cambria", 10));
		tfcustAdrCity.setMaxWidth(115);
		TextField tfcustAdrState = new TextField("Utah");
		tfcustAdrState.setFont(new Font("Cambria", 10));
		tfcustAdrState.setMaxWidth(115);
		TextField tfcustAdrZip = new TextField("Zip");
		tfcustAdrZip.setFont(new Font("Cambria", 10));
		tfcustAdrZip.setMaxWidth(115);
		
		GridPane custGrid = new GridPane();
		custGrid.add(custNameLabel,0,0);
		custGrid.add(tfcustName,1,0);
		
		custGrid.add(custAdrLabel,0,1);
		custGrid.add(tfcustAdr,1,1);
		
		custGrid.add(custAdrCityLabel,0,2);
		custGrid.add(tfcustAdrCity,1,2);
		
		custGrid.add(custAdrStateLabel,0,3);
		custGrid.add(tfcustAdrState,1,3);
		
		custGrid.add(custAdrZipLabel,0,4);
		custGrid.add(tfcustAdrZip,1,4);
		
		custGrid.add(custPhoneLabel,0,5);
		custGrid.add(tfcustPhone,1,5);
		
		hb2.setAlignment(Pos.TOP_LEFT);
		
		hb2.getChildren().addAll(servGrid, custGrid);
		
	/*
	Items that go in vb2 go here
		~ Notes to technicians *servLabel7*
		~ TextArea *taServ1*
	*/
		
		//Create cleaning notes text area and label
		TextArea taServ1 = new TextArea();
		taServ1.setWrapText(true);
		taServ1.setPrefHeight(50);
		taServ1.setMaxWidth(750);

		Label servLabel7 = new Label(" Notes for cleaning technicians: ");
		
		vb2.getChildren().addAll(servLabel7, taServ1);
		
	/*
	Items that go in hb3 go here
		~ cleaning notice label *cLNOLabel*
	*/
		//Create the cleaning notice and place it in the grid
		Label clNoLabel = new Label("All cleaning is in accordance with the local fire codes and/or NFPA Standard Code #96. This courtesy follow-up report is provided as a free customer service only; it is not a paid consultation. The inspection of the exhaust system is limited to the possible need for improved access and cleaning only. Other deficiencies, whether reported or not, are beyond the scope of our cleaning crew's knowledge. It is the owner of the exhaust system's responsibility to take appropriate action to modify any deficiencies noted herein or elsewhere.");
		clNoLabel.setFont(new Font("Cambria", 10));
		clNoLabel.setMaxWidth(750);
		clNoLabel.setWrapText(true);
		//hb3.getChildren().add(clNoLabel);
		

	/*
	Items that go in vb3 go here
		~ Kitchen Exhaust Cleaning Service Report Title bar
		~ Initial service check boxes
	*/
		
		//Create the kitchen cleaning service report boxes and place them in the grid
		Label kECSRLabel = new Label("KITCHEN EXHAUST CLEANING SERVICE REPORT");
		
		RadioButton iScb = new RadioButton("INITIAL SERVICE ");
		RadioButton rScb = new RadioButton("REGULAR SERVICE ");
		RadioButton iNcb = new RadioButton("INSPECTION ");
		
		hb4.getChildren().addAll(iScb, rScb, iNcb);
		
		vb3.getChildren().addAll(kECSRLabel, hb4);
		
	/*
	Items that go in hb5 go here
		~ Check In Box
		~ Check Out Box
	*/
	
		//Check In Box
		Label checkInLabel = new Label("Check In: ");
		Label cIYLabel = new Label("Yes ");
		cIYLabel.setFont(new Font("Cambria", 10));
		Label cINLabel = new Label("No");
		cINLabel.setFont(new Font("Cambria", 10));
		Label lightLabel = new Label("Light ");
		lightLabel.setFont(new Font("Cambria", 10));
		Label mediumLabel = new Label("Med ");
		mediumLabel.setFont(new Font("Cambria", 10));
		Label heavyLabel = new Label("Heavy");
		heavyLabel.setFont(new Font("Cambria", 10));
		Label dKWLabel = new Label("1. Key works ");
		Label fWPLabel = new Label("2. Fans working properly ");
		Label dIFWLabel = new Label("3. Defects in fan wiring ");
		Label aFHLabel = new Label("4. Fans hinged ");
		Label fDWLabel = new Label("5. Floor drains working ");
		Label hLWLabel = new Label("6. Hood lights working ");
		Label hGPLabel = new Label("7. Hood globes present ");
		Label rTCSLabel = new Label("8. Rooftop grease containment system ");
		Label gBURFLabel = new Label("9. Grease build-up around roof fan ");
		Label gBUFBLabel = new Label("10. Grease build-up fan blades ");
		Label gBUSDLabel = new Label("11. Grease build-up stacks/ductwork ");
		Label gBUHLabel = new Label("12. Grease build-up on hoods ");
		Label gBUFiLabel = new Label("13. Grease build-up on filter ");	
		
		ToggleGroup dkW = new ToggleGroup();
		RadioButton dKWrb1 = new RadioButton();
		dKWrb1.setToggleGroup(dkW);
		RadioButton dKWrb2 = new RadioButton();
		dKWrb2.setToggleGroup(dkW);
		
		ToggleGroup fWP = new ToggleGroup();
		RadioButton fWPrb1 = new RadioButton();
		fWPrb1.setToggleGroup(fWP);
		RadioButton fWPrb2 = new RadioButton();
		fWPrb2.setToggleGroup(fWP);
		
		ToggleGroup dIF = new ToggleGroup();
		RadioButton dIFrb1 = new RadioButton();
		dIFrb1.setToggleGroup(dIF);
		RadioButton dIFrb2 = new RadioButton();
		dIFrb2.setToggleGroup(dIF);
		
		ToggleGroup aFH = new ToggleGroup();
		RadioButton aFHrb1 = new RadioButton();
		aFHrb1.setToggleGroup(aFH);
		RadioButton aFHrb2 = new RadioButton();
		aFHrb2.setToggleGroup(aFH);
		
		ToggleGroup fDW = new ToggleGroup();
		RadioButton fDWrb1 = new RadioButton();
		fDWrb1.setToggleGroup(fDW);
		RadioButton fDWrb2 = new RadioButton();
		fDWrb2.setToggleGroup(fDW);
		
		ToggleGroup hLW = new ToggleGroup();
		RadioButton hLWrb1 = new RadioButton();
		hLWrb1.setToggleGroup(hLW);
		RadioButton hLWrb2 = new RadioButton();
		hLWrb2.setToggleGroup(hLW);
		
		ToggleGroup hGP = new ToggleGroup();
		RadioButton hGPrb1 = new RadioButton();
		hGPrb1.setToggleGroup(hGP);
		RadioButton hGPrb2 = new RadioButton();
		hGPrb2.setToggleGroup(hGP);
		
		ToggleGroup rTCS = new ToggleGroup();
		RadioButton rTCSrb1 = new RadioButton();
		rTCSrb1.setToggleGroup(rTCS);
		RadioButton rTCSrb2 = new RadioButton();
		rTCSrb2.setToggleGroup(rTCS);
		
		ToggleGroup gBURF = new ToggleGroup();
		RadioButton gBURFrb1 = new RadioButton();
		gBURFrb1.setToggleGroup(gBURF);
		RadioButton gBURFrb2 = new RadioButton();
		gBURFrb2.setToggleGroup(gBURF);
		RadioButton gBURFrb3 = new RadioButton();
		gBURFrb3.setToggleGroup(gBURF);
		
		ToggleGroup gBUFB = new ToggleGroup();
		RadioButton gBUFBrb1 = new RadioButton();
		gBUFBrb1.setToggleGroup(gBUFB);
		RadioButton gBUFBrb2 = new RadioButton();
		gBUFBrb2.setToggleGroup(gBUFB);
		RadioButton gBUFBrb3 = new RadioButton();
		gBUFBrb3.setToggleGroup(gBUFB);
		
		ToggleGroup gBUSD = new ToggleGroup();
		RadioButton gBUSDrb1 = new RadioButton();
		gBUSDrb1.setToggleGroup(gBUSD);
		RadioButton gBUSDrb2 = new RadioButton();
		gBUSDrb2.setToggleGroup(gBUSD);
		RadioButton gBUSDrb3 = new RadioButton();
		gBUSDrb3.setToggleGroup(gBUSD);
		
		ToggleGroup gBUH = new ToggleGroup();
		RadioButton gBUHrb1 = new RadioButton();
		gBUHrb1.setToggleGroup(gBUH);
		RadioButton gBUHrb2 = new RadioButton();
		gBUHrb2.setToggleGroup(gBUH);
		RadioButton gBUHrb3 = new RadioButton();
		gBUHrb3.setToggleGroup(gBUH);
		
		ToggleGroup gBUFi = new ToggleGroup();
		RadioButton gBUFirb1 = new RadioButton();
		gBUFirb1.setToggleGroup(gBUFi);
		RadioButton gBUFirb2 = new RadioButton();
		gBUFirb2.setToggleGroup(gBUFi);
		RadioButton gBUFirb3 = new RadioButton();
		gBUFirb3.setToggleGroup(gBUFi);

	
		GridPane cIBGrid = new GridPane();
		cIBGrid.add(checkInLabel,0,0);
		cIBGrid.add(cIYLabel,1,0);
		cIBGrid.add(cINLabel,2,0);
		
		cIBGrid.add(dKWLabel,0,1);
		cIBGrid.add(dKWrb1,1,1);
		cIBGrid.add(dKWrb2,2,1);
		
		cIBGrid.add(fWPLabel,0,2);
		cIBGrid.add(fWPrb1,1,2);
		cIBGrid.add(fWPrb2,2,2);
		
		cIBGrid.add(dIFWLabel,0,3);
		cIBGrid.add(dIFrb1,1,3);
		cIBGrid.add(dIFrb2,2,3);
						
		cIBGrid.add(aFHLabel,0,4);
		cIBGrid.add(aFHrb1,1,4);
		cIBGrid.add(aFHrb2,2,4);
		
		cIBGrid.add(fDWLabel,0,5);
		cIBGrid.add(fDWrb1,1,5);
		cIBGrid.add(fDWrb2,2,5);
		
		cIBGrid.add(hLWLabel,0,6);
		cIBGrid.add(hLWrb1,1,6);
		cIBGrid.add(hLWrb2,2,6);
		
		cIBGrid.add(hGPLabel,0,7);
		cIBGrid.add(hGPrb1,1,7);
		cIBGrid.add(hGPrb2,2,7);
		
		cIBGrid.add(rTCSLabel,0,8);
		cIBGrid.add(rTCSrb1,1,8);
		cIBGrid.add(rTCSrb2,2,8);
		
		cIBGrid.add(lightLabel,1,9);
		cIBGrid.add(mediumLabel,2,9);
		cIBGrid.add(heavyLabel,3,9);
		
		cIBGrid.add(gBURFLabel,0,10);
		cIBGrid.add(gBURFrb1,1,10);
		cIBGrid.add(gBURFrb2,2,10);
		cIBGrid.add(gBURFrb3,3,10);
		
		cIBGrid.add(gBUFBLabel,0,11);
		cIBGrid.add(gBUFBrb1,1,11);
		cIBGrid.add(gBUFBrb2,2,11);
		cIBGrid.add(gBUFBrb3,3,11);
				
		cIBGrid.add(gBUSDLabel,0,12);
		cIBGrid.add(gBUSDrb1,1,12);
		cIBGrid.add(gBUSDrb2,2,12);
		cIBGrid.add(gBUSDrb3,3,12);
		
		cIBGrid.add(gBUHLabel,0,13);
		cIBGrid.add(gBUHrb1,1,13);
		cIBGrid.add(gBUHrb2,2,13);
		cIBGrid.add(gBUHrb3,3,13);
		
		cIBGrid.add(gBUFiLabel,0,14);
		cIBGrid.add(gBUFirb1,1,14);
		cIBGrid.add(gBUFirb2,2,14);
		cIBGrid.add(gBUFirb3,3,14);
			
		//Check Out Box
		Label checkOutLabel = new Label("Check Out: ");
		Label cOYLabel = new Label("Yes");
		cOYLabel.setFont(new Font("Cambria", 10));
		Label cONLabel = new Label("No");
		cONLabel.setFont(new Font("Cambria", 10));
		Label cONewLabel = new Label("NEW    ");
		cONewLabel.setFont(new Font("Cambria", 10));
		Label cOULabel = new Label("UPDATE");
		cOULabel.setFont(new Font("Cambria", 10));		
		Label fWLRLabel = new Label("1. Fans working and left running ");
		Label rANFROLabel = new Label("2. Roof area near fan rinsed off ");
		Label hIWDLabel = new Label("3. Hood interior wiped dry ");
		Label kFCEWDLabel = new Label("4. Kitchen floor clean / Equipment wiped down ");
		Label oARCLabel = new Label("5. Outside area rinsed and clean ");
		Label hSFPWLabel = new Label("6. Hood, stack, fan pressure washed ");
		Label hDGLLabel = new Label("7. Any horizontal ductwork / give length ");
		Label aPGQLabel = new Label("8. Any access panels / give quantity ");
		Label sDWTLabel = new Label("9. Stack / ductwork water tight ");
		Label pLRLabel = new Label("10. Pilot lights reignited ");
		Label photoTLabel = new Label("11. Photos taken ");
		Label hSRLabel = new Label("12. Hood sticker replaced ");

		CheckBox inAccCB = new CheckBox("INACESSIBLE AREAS AND/OR FIRE CODE VIOLATIONS EXIST");
		inAccCB.setFont(new Font("Cambria", 10));
		Label moreHoods = new Label("Hood Description");
		moreHoods.setFont(new Font("Cambria", 10));
		moreHoods.setMaxWidth(115);
		TextField moreHoods2 = new TextField();
		moreHoods2.setFont(new Font("Cambria", 10));
		moreHoods2.setMaxWidth(200);
		
		ToggleGroup fWLR = new ToggleGroup();
		RadioButton fWLRrb1 = new RadioButton();
		fWLRrb1.setToggleGroup(fWLR);
		RadioButton fWLRrb2 = new RadioButton();
		fWLRrb2.setToggleGroup(fWLR);
	
		ToggleGroup rANFRO = new ToggleGroup();
		RadioButton rANFROrb1 = new RadioButton();
		rANFROrb1.setToggleGroup(rANFRO);
		RadioButton rANFROrb2 = new RadioButton();
		rANFROrb2.setToggleGroup(rANFRO);
	
		ToggleGroup hIWD = new ToggleGroup();
		RadioButton hIWDrb1 = new RadioButton();
		hIWDrb1.setToggleGroup(hIWD);
		RadioButton hIWDrb2 = new RadioButton();
		hIWDrb2.setToggleGroup(hIWD);
		
		ToggleGroup kFCEWD = new ToggleGroup();
		RadioButton kFCEWDrb1 = new RadioButton();
		kFCEWDrb1.setToggleGroup(kFCEWD);
		RadioButton kFCEWDrb2 = new RadioButton();
		kFCEWDrb2.setToggleGroup(kFCEWD);
		
		ToggleGroup oARC = new ToggleGroup();
		RadioButton oARCrb1 = new RadioButton();
		oARCrb1.setToggleGroup(oARC);
		RadioButton oARCrb2 = new RadioButton();
		oARCrb2.setToggleGroup(oARC);
	
		ToggleGroup hSFPW = new ToggleGroup();
		RadioButton hSFPWrb1 = new RadioButton();
		hSFPWrb1.setToggleGroup(hSFPW);
		RadioButton hSFPWrb2 = new RadioButton();
		hSFPWrb2.setToggleGroup(hSFPW);
		
		ToggleGroup hDGL = new ToggleGroup();
		RadioButton hDGLrb1 = new RadioButton();
		hDGLrb1.setToggleGroup(hDGL);
		RadioButton hDGLrb2 = new RadioButton();
		hDGLrb2.setToggleGroup(hDGL);
		
		ToggleGroup aPGQ = new ToggleGroup();
		RadioButton aPGQrb1 = new RadioButton();
		aPGQrb1.setToggleGroup(aPGQ);
		RadioButton aPGQrb2 = new RadioButton();
		aPGQrb2.setToggleGroup(aPGQ);
		
		ToggleGroup sDWT = new ToggleGroup();
		RadioButton sDWTrb1 = new RadioButton();
		sDWTrb1.setToggleGroup(sDWT);
		RadioButton sDWTrb2 = new RadioButton();
		sDWTrb2.setToggleGroup(sDWT);
		
		ToggleGroup pLR = new ToggleGroup();
		RadioButton pLRrb1 = new RadioButton();
		pLRrb1.setToggleGroup(pLR);
		RadioButton pLRrb2 = new RadioButton();
		pLRrb2.setToggleGroup(pLR);
		
		ToggleGroup hSR = new ToggleGroup();
		RadioButton hSRrb1 = new RadioButton();
		hSRrb1.setToggleGroup(hSR);
		RadioButton hSRrb2 = new RadioButton();
		hSRrb2.setToggleGroup(hSR);
		
		ToggleGroup photoT = new ToggleGroup();
		RadioButton photoTrb1 = new RadioButton();
		photoTrb1.setToggleGroup(photoT);
		RadioButton photoTrb2 = new RadioButton();
		photoTrb2.setToggleGroup(photoT);
		
		GridPane cOBGrid = new GridPane();
		cOBGrid.add(checkOutLabel,0,0);
		cOBGrid.add(cOYLabel,1,0);
		cOBGrid.add(cONLabel,2,0);
		
		cOBGrid.add(fWLRLabel,0,1);
		cOBGrid.add(fWLRrb1,1,1);
		cOBGrid.add(fWLRrb2,2,1);
		
		cOBGrid.add(rANFROLabel,0,2);
		cOBGrid.add(rANFROrb1,1,2);
		cOBGrid.add(rANFROrb2,2,2);
		
		cOBGrid.add(hIWDLabel,0,3);
		cOBGrid.add(hIWDrb1,1,3);
		cOBGrid.add(hIWDrb2,2,3);
						
		cOBGrid.add(kFCEWDLabel,0,4);
		cOBGrid.add(kFCEWDrb1,1,4);
		cOBGrid.add(kFCEWDrb2,2,4);
		
		cOBGrid.add(oARCLabel,0,5);
		cOBGrid.add(oARCrb1,1,5);
		cOBGrid.add(oARCrb2,2,5);
		
		cOBGrid.add(hSFPWLabel,0,6);
		cOBGrid.add(hSFPWrb1,1,6);
		cOBGrid.add(hSFPWrb2,2,6);
		
		cOBGrid.add(hDGLLabel,0,7);
		cOBGrid.add(hDGLrb1,1,7);
		cOBGrid.add(hDGLrb2,2,7);
		
		cOBGrid.add(aPGQLabel,0,8);
		cOBGrid.add(aPGQrb1,1,8);
		cOBGrid.add(aPGQrb2,2,8);
		
		cOBGrid.add(sDWTLabel,0,9);
		cOBGrid.add(sDWTrb1,1,9);
		cOBGrid.add(sDWTrb2,2,9);
		
		cOBGrid.add(pLRLabel,0,10);
		cOBGrid.add(pLRrb1,1,10);
		cOBGrid.add(pLRrb2,2,10);
		
		cOBGrid.add(photoTLabel,0,11);
		cOBGrid.add(photoTrb1,1,11);
		cOBGrid.add(photoTrb2,2,11);
		
		cOBGrid.add(cONewLabel,1,12);
		cOBGrid.add(cOULabel,2,12);
		
		cOBGrid.add(hSRLabel,0,13);
		cOBGrid.add(hSRrb1,1,13);
		cOBGrid.add(hSRrb2,2,13);
		
		cOBGrid.add(inAccCB,0,14);
		
		cOBGrid.add(moreHoods,0,15);
		cOBGrid.add(moreHoods2,0,16);
		
		hb5.getChildren().addAll(cIBGrid, cOBGrid);
		
	/*
	Items that go in hb6 go here
		~ Time in Time out boxes 
	*/
	
		Label tILabel = new Label("TIME IN: ");
		Label tOLabel = new Label("TIME OUT: ");
		
		TextField tfTI = new TextField("00:00");
		tfTI.setFont(new Font("Cambria", 10));
		tfTI.setMaxWidth(80);
		TextField tfTO = new TextField("00:00");
		tfTO.setFont(new Font("Cambria", 10));
		tfTO.setMaxWidth(80);
		
		hb6.getChildren().addAll(tILabel, tfTI, tOLabel, tfTO);
		
	/*
	Items that go in hb7 go here
		~ Miscellaneous notes text field
		~ Acknowledgement box
	*/
		//Create the miscellaneous Notes and Acknowledgment Boxes and place them in the grid
		Label miscNotLabel = new Label("Misc. Notes: All items marked no must have an explanation");
		Label techSigLabel = new Label("Technician Name:");
		Label techSigDate = new Label("Date:    	");
		Label claimLabel = new Label("\nClaims of unsatisfactory workmanship must be made within 48 hours. Invoices are subject to an intrest charge of the lesser of 1.5% per month(18% per year) or the maximum rate allowed by law on any unpaid invoices outstanding after 30 days from date of service. The Customer herby waives thier rights of subrogation by thier insurance carrier against Tong's Fire Extinguisher under any fire or liability insurance policy.");
		claimLabel.setMaxWidth(375);
		claimLabel.setFont(new Font("Cambria", 10));
		claimLabel.setWrapText(true);

		Label eventLabel = new Label("IN THE EVENT OF DEFAULT, TONG'S FIRE EXTINGUISHER SHALL BE ENTITLED TO RECOVER COST OF COLLECTION, INCLUDING REASONABLE ATTORNEY FEES.");
		eventLabel.setMaxWidth(375);
		eventLabel.setWrapText(true);
		Label ackLabel = new Label("ACKNOWLEDGMENT OF KITCHEN CONDITION & KEC SERVICE COMPLETED. BY SIGNING BELOW THE CUSTOMER ACKNOWLEDGES SERVICE WAS COMPLETED AND THE KITCHEN WAS LEFT CLEAN AND IN SATISFACTORY CONDITION.");
		ackLabel.setFont(new Font("Cambria", 10));
		ackLabel.setWrapText(true);
		ackLabel.setMaxWidth(375);
		Label custSignLabel = new Label("Customer Name: ");
		
		TextArea miscNotTa = new TextArea();
		miscNotTa.setWrapText(true);
		miscNotTa.setFont(new Font("Cambria", 10));
		miscNotTa.setWrapText(true);
		miscNotTa.setMaxWidth(375);

		ComboBox<String> techtf = new ComboBox<String>();
		techtf.getItems().addAll("Scott", "Dusten");
		DatePicker techDatetf = new DatePicker();
		TextField custSigntf = new TextField( "                                                                                                         Date: ");
		custSigntf.setFont(new Font("Cambria", 10));
		Button btPreView = new Button("Preview");
		Button btPrint = new Button("Print");
		CheckBox keyCB = new CheckBox("Key ");
		CheckBox noAvailCB = new CheckBox("No one available to sign ");

		hb7.getChildren().addAll(vb4, vb5);
		hb8.getChildren().addAll(keyCB, noAvailCB);
		hb9.getChildren().addAll(techSigLabel,techtf);
		hb10.getChildren().addAll(techSigDate, techDatetf);
		hb11.getChildren().addAll(custSignLabel,custSigntf);
		
		vb4.getChildren().addAll(miscNotLabel, miscNotTa);
		vb5.getChildren().addAll( hb9, hb11, hb8,/* hb10,*/ btPreView/*, claimLabel, eventLabel, ackLabel,*/ );
		
		//OnAction events for radio buttons and check boxes
		dKWrb1.setOnAction(e -> {setYes(dkWSt, "dKWrb1"); });
		dKWrb2.setOnAction(e -> {setNo(dkWSt, "dKWrb2"); });
				
		fWPrb1.setOnAction(e -> {setYes(fWPSt, "fWPrb1"); });
		fWPrb2.setOnAction(e -> {setNo(fWPSt, "fWPrb2"); });
		
		dIFrb1.setOnAction(e -> {setYes(dIFSt, "dIFrb1"); });
		dIFrb2.setOnAction(e -> {setNo(dIFSt, "dIFrb2"); });
		
		aFHrb1.setOnAction(e -> {setYes(aFHSt, "aFHrb1"); });
		aFHrb2.setOnAction(e -> {setNo(aFHSt, "aFHrb2"); });
		
		fDWrb1.setOnAction(e -> {setYes(fDWSt, "fDWrb1"); });
		fDWrb2.setOnAction(e -> {setNo(fDWSt, "fDWrb2"); });
		
		hLWrb1.setOnAction(e -> {setYes(hLWSt, "hLWrb1"); });
		hLWrb2.setOnAction(e -> {setNo(hLWSt, "hLWrb2"); });
		
		hGPrb1.setOnAction(e -> {setYes(hGPSt, "hGPrb1"); });
		hGPrb2.setOnAction(e -> {setNo(hGPSt, "hGPrb2"); });
		
		rTCSrb1.setOnAction(e -> {setYes(rTCSSt, "rTCSrb1"); });
		rTCSrb2.setOnAction(e -> {setNo(rTCSSt, "rTCSrb2"); });
		
		gBURFrb1.setOnAction(e -> {setLight(gBURFSt, "gBURFrb1"); });
		gBURFrb2.setOnAction(e -> {setMedium(gBURFSt, "gBURFrb2"); });
		gBURFrb3.setOnAction(e -> {setHeavy(gBURFSt, "gBURFrb3"); });
		
		gBUFBrb1.setOnAction(e -> {setLight(gBUFBSt, "gBUFBrb1"); });
		gBUFBrb2.setOnAction(e -> {setMedium(gBUFBSt, "gBUFBrb2"); });
		gBUFBrb3.setOnAction(e -> {setHeavy(gBUFBSt, "gBUFBrb3"); });
		
		gBUSDrb1.setOnAction(e -> {setLight(gBUSDSt, "gBUSDrb1"); });
		gBUSDrb2.setOnAction(e -> {setMedium(gBUSDSt, "gBUSDrb2"); });
		gBUSDrb3.setOnAction(e -> {setHeavy(gBUSDSt, "gBUSDrb3"); });
		
		gBUHrb1.setOnAction(e -> {setLight(gBUHSt, "gBUHrb1"); });
		gBUHrb2.setOnAction(e -> {setMedium(gBUHSt, "gBUHrb2"); });
		gBUHrb3.setOnAction(e -> {setHeavy(gBUHSt, "gBUHrb3"); });
		
		gBUFirb1.setOnAction(e -> {setLight(gBUFiSt, "gBUFirb1"); });
		gBUFirb2.setOnAction(e -> {setMedium(gBUFiSt, "gBUFirb2"); });
		gBUFirb3.setOnAction(e -> {setHeavy(gBUFiSt, "gBUFirb3"); });
		
		fWLRrb1.setOnAction(e -> {setYes(fWLRSt, "fWLRrb1"); });
		fWLRrb2.setOnAction(e -> {setNo(fWLRSt, "fWLRrb2"); });
		
		rANFROrb1.setOnAction(e -> {setYes(rANFROSt, "rANFROrb1"); });
		rANFROrb2.setOnAction(e -> {setNo(rANFROSt, "rANFROrb2"); });
		
		hIWDrb1.setOnAction(e -> {setYes(hIWDSt, "hIWDrb1"); });
		hIWDrb2.setOnAction(e -> {setNo(hIWDSt, "hIWDrb2"); });
		
		kFCEWDrb1.setOnAction(e -> {setYes(kFCEWDSt, "kFCEWDrb1"); });
		kFCEWDrb2.setOnAction(e -> {setNo(kFCEWDSt, "kFCEWDrb2"); });
		
		oARCrb1.setOnAction(e -> {setYes(oARCSt, "oARCrb1"); });
		oARCrb2.setOnAction(e -> {setNo(oARCSt, "oARCrb2"); });
		
		hSFPWrb1.setOnAction(e -> {setYes(hSFPWSt, "hSFPWrb1"); });
		hSFPWrb2.setOnAction(e -> {setNo(hSFPWSt, "hSFPWrb2"); });
		
		hDGLrb1.setOnAction(e -> {setYes(hDGLSt, "hDGLrb1"); });
		hDGLrb2.setOnAction(e -> {setNo(hDGLSt, "hDGLrb2"); });
		
		aPGQrb1.setOnAction(e -> {setYes(aPGQSt, "aPGQrb1"); });
		aPGQrb2.setOnAction(e -> {setNo(aPGQSt, "aPGQrb2"); });
		
		sDWTrb1.setOnAction(e -> {setYes(sDWTSt, "sDWTrb1"); });
		sDWTrb2.setOnAction(e -> {setNo(sDWTSt, "sDWTrb2"); });
		
		pLRrb1.setOnAction(e -> {setYes(pLRSt, "pLRrb1"); });
		pLRrb2.setOnAction(e -> {setNo(pLRSt, "pLRrb2"); });
		
		hSRrb1.setOnAction(e -> {setNew(hSRSt, "hSRrb1"); });
		hSRrb2.setOnAction(e -> {setUp(hSRSt, "hSRrb2"); });
		
		photoTrb1.setOnAction(e -> {setYes(photoTSt, "photoTrb1"); });
		photoTrb2.setOnAction(e -> {setNo(photoTSt, "photoTrb2"); });
				
		iScb.setOnAction(e -> {
			if (iScb.isSelected() == true) {
				serviceInit = "YES";
			}
			else if (iScb.isSelected() == false) {
				serviceInit = "NO";
			}
		});
		
		rScb.setOnAction(e -> {
			if (rScb.isSelected() == true) {
				serviceReg = "YES";
			}
			else if (rScb.isSelected() == false) {
				serviceReg = "NO";
			}
		});
		
		iNcb.setOnAction(e -> {
			if (iNcb.isSelected() == true) {
				serviceInsp = "YES";
			}
			else if (iNcb.isSelected() == false) {
				serviceInsp = "NO";
			}
		});
		
        // action event 
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e){ 
                // get the date picker value 
            	repDate = dateOSDP.getValue().getYear();
            } 
        };

		dateOSDP.setOnAction(event);
	
		serviceECB.setOnAction(e -> {
			if (serviceECB.getValue() == "Annually") {
				execDate = dateOSDP.getValue().plusMonths(12);
			}
			else if (serviceECB.getValue() == "Bi-Annually") {
				execDate = dateOSDP.getValue().plusMonths(6);
			}
			else if (serviceECB.getValue() == "Quarterly") {
				execDate = dateOSDP.getValue().plusMonths(3);
			}
		});
		
		techtf.setOnAction(e -> {
			if (techtf.getValue() == "Scott") {
				endTech1 = "Scott Tong \n" + address1p + "\n" + address1c + address1z + "\n" + tech1p + "\n" + licNumTech1;
			}
			else if (techtf.getValue() == "Dusten") {
				endTech1 = "Dusten Newby \n" + address2p + "\n" + address2c + address2z + "\n" + tech2p + "\n" + licNumTech2;
				
			}
		});
		
		inAccCB.setOnAction(e -> {
			if (inAccCB.isSelected() == true) {
				inAccCBSt = "YES";
			}
			else if (inAccCB.isSelected() == false) {
				inAccCBSt = "NO";
		}});		
		
		keyCB.setOnAction(e -> {
			if (keyCB.isSelected() == true) {
				keyCBSt = "YES";
			}
			else if (keyCB.isSelected() == false) {
				keyCBSt = "NO";
		}});
		
		noAvailCB.setOnAction(e -> {
			if (noAvailCB.isSelected() == true) {
				custSigntf.setText("No one available to sign                                                               Date: ");
			}
			else if (noAvailCB.isSelected() == false) {
				custSigntf.setText( "                                                                                                         Date: ");
		}});
		
		//send image of GUI to file.
		btPreView.setOnAction(e -> {
			String custadd1na = tfcustName.getText().trim();
			String custadd1po = tfcustAdr.getText().trim();
			String custadd1csz = tfcustAdrCity.getText().trim() + ", " + tfcustAdrState.getText().trim() + ", " +tfcustAdrZip.getText().trim();
			String custadd1ph = tfcustPhone.getText().trim();
			String custSignSt = custSigntf.getText();
			
			if (repDate != 0000) {
				System.out.println(repDate);
				repDate = dateOSDP.getValue().getYear();
			}
				
			StackPane printBtStage = new StackPane();
				
				Button cancel = new Button("Close Preview");

				TextArea printTa = new TextArea();
				printTa.setMinHeight(1000);
				printTa.setMinWidth(810);
				printTa.setEditable(false);
				
				TextArea techAddta = new TextArea();
				techAddta.setMaxHeight(125);
				techAddta.setMaxWidth(300);
				techAddta.setEditable(false);
				techAddta.setStyle("-fx-focus-color: transparent; -fx-text-box-border: transparent;");
				
				TextArea custAddta = new TextArea();
				custAddta.setMaxHeight(125);
				custAddta.setMaxWidth(300);
				custAddta.setEditable(false);
				custAddta.setStyle("-fx-focus-color: transparent; -fx-text-box-border: transparent;");
				
				TextArea cleanNotice = new TextArea();
				cleanNotice.setMinHeight(125);
				cleanNotice.setMinWidth(450);
				cleanNotice.setEditable(false);
				cleanNotice.setStyle("-fx-highlight-fill: #7ecfff;"
									+"-fx-focus-color: transparent;"
									+"-fx-text-box-border: transparent;"
									+"-fx-font-size:10;"
								    +"-fx-background-insets: 0;"
								    +"-fx-background-color: transparent;"
								    +"-fx-padding: 10px;"
									);
				
				AnchorPane printStage = new AnchorPane(printTa,reportLogo,cleanNotice,techAddta,custAddta);

				AnchorPane.setTopAnchor(reportLogo,10.0);
				AnchorPane.setLeftAnchor(reportLogo,0.0);
				AnchorPane.setTopAnchor(printTa,0.0);
				AnchorPane.setLeftAnchor(printTa,0.0);
				AnchorPane.setTopAnchor(techAddta,10.0);
				AnchorPane.setLeftAnchor(techAddta,225.0);
				AnchorPane.setTopAnchor(custAddta,10.0);
				AnchorPane.setRightAnchor(custAddta,0.0);
				AnchorPane.setTopAnchor(cleanNotice,110.0);
				AnchorPane.setRightAnchor(cleanNotice,70.0);

				techAddta.appendText(endTech1);
				custAddta.appendText("Invoice Number: " + tfInvoice.getText() + "\n" + custadd1na + "\n" + custadd1po + "\n" + custadd1csz + "\n" + custadd1ph);
				cleanNotice.appendText("\nAll cleaning is in accordance with the local fire codes and/or NFPA Standard Code #96. This\n"
						+ "courtesy follow-up report is provided as a free customer service only; it is not a paid consul-\n"
						+ "tation. The inspection of the exhaust system is limited to the possible need for improved \n"
						+ "access and cleaning only. Other deficiencies, whether reported or not, are beyond the scope\nof"
						+ " our cleaning crew's knowledge. It is the owner of the exhaust system's responsibility to \ntake"
						+ " appropriate action to modify any deficiencies noted herein or elsewhere.\n");
				
				printTa.appendText("\n" + "\n" + "\n" + "\n" + "\n"+"\n" + "\n" + "\n"
				+ "    Service Scheduled with: " + servSchTF.getText() + "\n"
				+ "    Store Closing Manager: " + storeCMTF.getText()+ "\n"
				+ "    Date of Service:\t\t" + dateOSDP.getValue()+ "\n"
				+ "    Service Frequency:\t" + serviceECB.getValue()+ "\n"
				+ "    Time of Service:\t\t" + timeOSTF.getText()+ "\n"
				+ "    Next Service Due:\t" + execDate + "\n"
								+ "\t__________________________________________________________________________________________________________________________________________\n"
				+ "\n"				+ "\t\t\t\t\t\t\t\t\tKITCHEN EXHAUST HOOD CLEANING REPORT\n\n" 
				+ "\tType of Service completed "+"\t\t\t\t\t\t\t\t\tHood Location:  " + moreHoods2.getText()+ "\n\t\t\tInitial Service: " + serviceInit + "\n\t\t\tRegular Service: " + serviceReg + "\n\t\t\tInspection: " + serviceInsp + "\n\n"
				+ "\tCheck in: \t\t\t\t\t\t\t\t\t\t\t Check Out: " + "\n"
				+ "\t\t1. Key works: \t\t\t\t\t\t\t" + dkWSt + "\t\t\t" + "1. Fans working and left running:\t\t\t\t " + fWLRSt +"\n"
				+ "\t\t2. Fans working properly: \t\t\t\t" + fWPSt + "\t\t\t" + "2. Roof area near fan rinsed off:\t\t\t\t " + rANFROSt +"\n"
				+ "\t\t3. Defects in fan wiring: \t\t\t\t\t" + dIFSt + "\t\t\t" + "3. Hood interior wiped dry:\t\t\t\t\t " + hIWDSt +"\n"
				+ "\t\t4. Fans hinged: \t\t\t\t\t\t" + aFHSt + "\t\t\t" + "4. Kitchen floor clean/equipment wiped down:\t " + kFCEWDSt + "\n"
				+ "\t\t5. Floor drains working: \t\t\t\t\t" + fDWSt + "\t\t\t" + "5. Outside area rinsed and clean:\t\t\t\t " + oARCSt + "\n"
				+ "\t\t6. Hood lights working: \t\t\t\t\t" + hLWSt + "\t\t\t" + "6. Hood, stack, fan pressure washed:\t\t\t " + hSFPWSt + "\n"
				+ "\t\t7. Hood globes present: \t\t\t\t\t" + hGPSt + "\t\t\t" + "7. Any horizontal ductwork:\t\t\t\t\t " + aFHSt + "\n"
				+ "\t\t8. Rooftop grease containment system: \t\t" + rTCSSt + "\t\t\t" + "8. Any access panels:\t\t\t\t\t\t " + aPGQSt + "\n"
				+ "\t\t9. Grease buildup around roof fan: \t\t" + gBURFSt + "\t\t\t" + "9. Stack/ductwork water tight:\t\t\t\t\t " + sDWTSt + "\n"
				+ "\t\t10. Grease build up on fan blades: \t\t\t" + gBUFBSt + "\t\t\t" + "10. Pilot lights reignited:\t\t\t\t\t\t " + pLRSt + "\n"
				+ "\t\t11. Grease build up on stacks/ductwork: \t" + gBUSDSt + "\t\t\t" + "11. Photos taken:\t\t\t\t\t\t\t " + photoTSt + "\n"
				+ "\t\t12. Grease build up on Hoods: \t\t\t" + gBUHSt + "\t\t\t" + "12. Hood sticker replaced:\t\t\t\t\t " + hSRSt + "\n"
				+ "\t\t13. Grease build up on filter: \t\t\t\t" + gBUFiSt + "\t\t\t" + "Inaccessible areas?:  " + inAccCBSt + "               Key available?:  " + keyCBSt +"\n" + "\n"
				+ "\tNotes to Cleaning Technicians: "
				+ "\t" + taServ1.getText() + "\n"
				+ "\tMiscellaneous Notes: "
				+ miscNotTa.getText() + "\n\n"
				+ "\tService performed by:      " + techtf.getValue() + "\t\tDate Completed: " + dateOSDP.getValue()	+ "                  Time In: " + tfTI.getText()+ "                  Time Out: " + tfTO.getText()+ "\n"
				+ "\t__________________________________________________________________________________________________________________________________________\n"

				+ "\tIN THE EVENT OF DEFAULT, TONG'S FIRE EXTINGUISHER SHALL BE ENTITLED TO RECOVER COST OF COLLECTION, INCLUDING\n\tREASONABLE ATTORNEY FEES. ACKNOWLEDGMENT OF KITCHEN CONDITION & KEC SERVICE COMPLETED. BY SIGNING BELOW \n\tTHE CUSTOMER ACKNOWLEDGES ALL SERVICE WAS COMPLETED AND THE KITCHEN WAS LEFT CLEAN AND IN SATISFACTORY \n\tCONDITION."
				+ "\n\tClaims of unsatisfactory workmanship must be made within 48 hours. Invoices are subject to an interest charge of the lesser of \n\t1.5% per month(18% per year) or the maximum rate allowed by law on any unpaid invoices outstanding after 30 days from date \n\tof service. The Customer herby waives thier rights of subrogation by thier insurance carrier against Tong's Fire Extinguisher \n\tunder any fire or liability insurance policy.\n"
				+ "\t__________________________________________________________________________________________________________________________________________\n"
				+ "\n\n\n\tCustomer Signature: " + custSignSt + "\n"
				+ "                                         --------------------------------------------------------------                        -------------------------"  
				
				);
				
				HBox printHBox = new HBox();
				
				printHBox.getChildren().addAll(btPrint,cancel);
				
				printBtStage.getChildren().addAll(printHBox);

				Scene printScene = new Scene(printStage , 810, 1010);
				Scene printBtScene = new Scene(printBtStage , 200, 50);
				
				Stage printWindow = new Stage();
				Stage printBtWindow = new Stage();
				
				printWindow.setTitle("HCRGen Report");
				printWindow.setScene(printScene);
				
				printWindow.setX(0);
				printWindow.setY(0);
				
				printBtWindow.setTitle("Print/Cancel");
				printBtWindow.setScene(printBtScene);
				
				printBtWindow.setX(900);
				printBtWindow.setY(100);
				
				printWindow.show();
				printBtWindow.show();
				
				cancel.setOnAction(ex -> {
					printWindow.close();	
					printBtWindow.close();	
				});
				
				printTa.setOnKeyPressed(ex -> {
					if (ex.getCode().equals(KeyCode.ENTER)) {
						String PATH = "HCRGen/Reports/";
						String dirName = PATH.concat(tfcustName.getText().trim());
						File directory = new File(dirName + "/" + repDate + "/");
						
						if (! directory.exists()) {
							directory.mkdirs();
						}
						try (
							FileOutputStream oos = new FileOutputStream(directory +"/"+ tfInvoice.getText().trim() + ".jpg", true);
							){
							captureScreen(directory +"/"+ tfInvoice.getText().trim() + ".jpg");
							System.out.println("Image saved to file!");
							oos.close();
						} catch (Exception exe) {
							exe.printStackTrace();
						}
					}
					else if (ex.getCode().equals(KeyCode.ESCAPE)) {
						printWindow.close();	
						printBtWindow.close();
					}	
	
				});
		});
		
		btPrint.setOnAction(e -> {
			String PATH = "HCRGen/Reports/";
			String dirName = PATH.concat(tfcustName.getText().trim());
			File directory = new File(dirName + "/" + repDate + "/");
			
			if (! directory.exists()) {
				directory.mkdirs();
			}
			try (
				FileOutputStream oos = new FileOutputStream(directory +"/"+ tfInvoice.getText()+ ".jpg", true);
				){
				captureScreen(directory +"/"+  tfInvoice.getText()+ ".jpg");
				System.out.println("Image saved to file!");
				oos.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		mainVB.getChildren().addAll(hb1, hb2, vb2, /*hb3,*/ vb3, hb5, hb6, hb7);
		
		Scene scene = new Scene(sp , 800, 1000);
		
		primaryStage.setTitle("HCRGen");
		primaryStage.setX(0);
		primaryStage.setY(0);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	/**
	 * Method for setting the radio group to yes
	 * @param input name for radio group
	 * @param btName name of button 
	 */
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
	/**
	 * Method for setting the radio group to no
	 * @param input name for radio group
	 * @param btName name of button 
	 */
	public void setNo(String input, String btName){
		switch (btName){
		case "dKWrb2": dkWSt = "No"; break;
		case "fWPrb2": fWPSt = "No"; break;
		case "dIFrb2": dIFSt = "No"; break;
		case "aFHrb2": aFHSt = "No"; break;
		case "fDWrb2": fDWSt = "No"; break;
		case "hLWrb2": hLWSt = "No"; break;
		case "hGPrb2": hGPSt = "No"; break;
		case "rTCSrb2": rTCSSt = "No"; break;
		case "fWLRrb2": fWLRSt = "No"; break;
		case "rANFROrb2": rANFROSt = "No"; break;
		case "hIWDrb2": hIWDSt = "No"; break;
		case "kFCEWDrb2": kFCEWDSt = "No"; break;
		case "oARCrb2": oARCSt = "No"; break;
		case "hSFPWrb2": hSFPWSt = "No"; break;
		case "hDGLrb2": hDGLSt = "No"; break;
		case "aPGQrb2": aPGQSt = "No"; break;
		case "sDWTrb2": sDWTSt = "No"; break;
		case "pLRrb2": pLRSt = "No"; break;
		case "hSRrb2": hSRSt = "No"; break;
		case "photoTrb2": photoTSt = "No"; break;
		}
	}
	/**
	 * Method for setting the radio group to Light
	 * @param input name for radio group
	 * @param btName name of button 
	 */
	public void setLight(String input, String btName){
		switch (btName) {
			case "gBURFrb1": gBURFSt = "Lit"; break;
			case "gBUFBrb1": gBUFBSt = "Lit"; break;
			case "gBUSDrb1": gBUSDSt = "Lit"; break;
			case "gBUHrb1": gBUHSt = "Lit"; break;
			case "gBUFirb1": gBUFiSt = "Lit"; break;
		}
	}
	/**
	 * Method for setting the radio group to Medium
	 * @param input name for radio group
	 * @param btName name of button 
	 */
	public void setMedium(String input, String btName){
		switch (btName) {
			case "gBURFrb2": gBURFSt = "Med"; break;
			case "gBUFBrb2": gBUFBSt = "Med"; break;
			case "gBUSDrb2": gBUSDSt = "Med"; break;
			case "gBUHrb2": gBUHSt = "Med"; break;
			case "gBUFirb2": gBUFiSt = "Med"; break;
		}
	}
	/**
	 * Method for setting the radio group to Heavy
	 * @param input name for radio group
	 * @param btName name of button 
	 */
	public void setHeavy(String input, String btName){
		switch (btName) {
			case "gBURFrb3": gBURFSt = "Hvy"; break;
			case "gBUFBrb3": gBUFBSt = "Hvy"; break;
			case "gBUSDrb3": gBUSDSt = "Hvy"; break;
			case "gBUHrb3": gBUHSt = "Hvy"; break;
			case "gBUFirb3": gBUFiSt = "Hvy"; break;
		}
	}
	/**
	 * Method for setting the radio group to New when changing the label
	 * @param input name for radio group
	 * @param btName name of button 
	 */
	public void setNew(String input, String btName){
		switch (btName){		
		case "hSRrb1": hSRSt = "New"; break;
		}
	}
	/**
	 * Method for setting the radio group to Update when changing the label
	 * @param input name for radio group
	 * @param btName name of button 
	 */
	public void setUp(String input, String btName){
		switch (btName){		
		case "hSRrb2": hSRSt = "Update"; break;
		}
	}
	/**
	 * Method for Capturing the screen as a file to save the report
	 * @param fileName name for the file to be generated
	 * @throws Exception listed for IO file not found exception
	 */
	public void captureScreen(String fileName) throws Exception {
		Rectangle screenRectangle = new Rectangle(10, 45, 800, 950);
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screenRectangle);
		ImageIO.write(image, "png", new File(fileName));
	}

	public static void main(String[] args){
		Application.launch(args);
		}
}