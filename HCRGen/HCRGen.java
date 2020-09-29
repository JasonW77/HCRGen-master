/**
 *  * <h1>JavaDoc</h1>
 * 
 *  HCRGen application for generating Hood Cleaning Reports (or HCRGen.java).
 * 	I created this program for Tong's Fire Extinguisher Sales and Service to help them move from paper reports to an all digital report system.
 * 
 *  Version 2.0 adds the RFSSR class and the CustCrea class, this allows for a second report to be generated and the customer information to be saved.
 * 
	<p>Date created 8/17/2020 <p/>
	<p>Version 2.0 <p/>
	
	@author Jason Waters
 */
package HCRGen;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HCRGen extends Application {
	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();
	
	String GENlicNumTech1 = "Lic. # KE82431";
	String GENlicNumTech2 = "Lic. # KE113954";
	String GENaddress1 = "P.O. Box 3101 \nCedar City, UT 84721";
	String GENaddress1p = "P.O. Box 3101";
	String GENaddress1c = "Cedar City,";
	String GENaddress1z = "UT 84721";
	String GENtech1p = "1-435-201-2182";
	String GENaddress2 = "P.O. Box 135 \nElsinore, UT 84724";
	String GENaddress2p = "P.O. Box 135";
	String GENaddress2c = "Elsinore,";
	String GENaddress2z = "UT 84724";
	String GENtech2p = "1-435-896-3840";	
	int GENwhichTech = 0;
	String GENendTech1 = "Tong's Fire Extinguisher Sales and Service \n" + GENaddress1p + "\n" + GENaddress1c + GENaddress1z + "\n" + GENtech1p + "\n" + GENlicNumTech1;;
	String GENendTech1l = " ";
	String GENphoneNum = "(435) 201-2182";
	String GENserviceInit = "";
	String GENserviceReg = "";
	String GENserviceInsp = "";
	String GENdkWSt = "N/A";
	String GENfWPSt = "N/A";
	String GENdIFSt = "N/A";
	String GENaFHSt = "N/A";
	String GENfDWSt = "N/A";
	String GENhLWSt = "N/A";
	String GENhGPSt = "N/A";
	String GENrTCSSt = "N/A";
	String GENgBURFSt = "N/A";
	String GENgBUFBSt = "N/A";
	String GENgBUSDSt = "N/A";
	String GENgBUHSt = "N/A";
	String GENgBUFiSt = "N/A";
	String GENinAccCBSt = "N/A";
	String GENfWLRSt = "N/A";
	String GENrANFROSt = "N/A";
	String GENhIWDSt = "N/A";
	String GENkFCEWDSt = "N/A";
	String GENoARCSt = "N/A";
	String GENhSFPWSt = "N/A";
	String GENhDGLSt = "N/A";
	String GENaPGQSt = "N/A";
	String GENsDWTSt = "N/A";
	String GENpLRSt = "N/A";
	String GENhSRSt = "N/A";
	String GENphotoTSt = "N/A";
	String GENkeyCBSt = "N/A";
	String GENnoAvailCBSt = "N/A";
	String GENmoreHoodsSt = " ";
	String GENlabel1TG = "N/A";
	String GENlabel2TG = "N/A";
	String GENlabel3TG = "N/A";
	String GENlabel4TG = "N/A";
	String GENlabel5TG = "N/A";
	String GENlabel6TG = "N/A";
	String GENlabel7TG = "N/A";
	String GENlabel8TG = "N/A";
	String GENlabel9TG = "N/A";
	String GENlabel10TG = "N/A";
	String GENlabel11TG = "N/A";
	String GENlabel12TG = "N/A";
	String GENlabel13TG = "N/A";
	String GENlabel14TG = "N/A";
	String GENlabel15TG = "N/A";
	String GENlabel16TG = "N/A";
	String GENlabel17TG = "N/A";
	String GENlabel18TG = "N/A";
	String GENlabel19TG = "N/A";
	String GENlabel20TG = "N/A";
	String GENlabel21TG = "N/A";
	String GENlabel22TG = "N/A";
	String GENlabel23TG = "N/A";
	String GENlabel24TG = "N/A";
	String GENlabel25TG = "N/A";
	String GENlabel26TG = "N/A";
	String GENlabel27TG = "N/A";
	String GENlabel28TG = "N/A";
	String GENlabel29TG = "N/A";
	String GENlabel30TG = "N/A";
	String GENlabel31TG = "N/A";
	LocalDate GENexecDate;
	LocalDate GENNHTDDPDate;
	
	int GENrepDate = 0000;
	
	String CUSTOBJFOCUS = "";
	
	static Map<String,Object> map = new HashMap<>();
	java.io.File mapFile = new java.io.File("HCRGen/Map");
	String mapFileLoc = mapFile.getAbsolutePath();

	
	/** 
	 * Program Start window  
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException{	
		String MapFilePATH = mapFileLoc;
		String MapFiledirName = MapFilePATH;
		File MapFiledirectory = new File(MapFiledirName);
				
		if (! MapFiledirectory.exists()) {
				MapFiledirectory.mkdirs();
				System.out.println("Directory Made");
			}
			try (
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(MapFiledirectory + "/" + "ClientList.txt"));	
					
					){
					map.putAll((Map<? extends String, ? extends Object>) ois.readObject());
					System.out.println(" Object read from file");
					//ois.close();
						
			} catch (Exception exe) {
				exe.printStackTrace();
				System.out.println("Failed to read file");
			}
						
		//create ImageView for the Company logo and place in the grid
		File GENf = new File("TONGS-FIRE-EXTINGUISHER-SALES-AND-SERVICE.jpg");
		String GENfilLoc = GENf.getAbsolutePath();
		
		//Creating a Graphical Label
		Label GENlogo = new Label();
		Label GENreportLogo = new Label();
		Label GENStartWindowLogo = new Label();
		
		//Creating a graphic for the HCR window
		Image GENimg = new Image(new FileInputStream(GENfilLoc));
		ImageView GENview = new ImageView(GENimg);
		GENview.setFitHeight(125);
		GENview.setFitWidth(225);
		GENview.setPreserveRatio(false);
		
		//create report logo
		ImageView GENview2 = new ImageView(GENimg);
		GENview2.setFitHeight(125);
		GENview2.setFitWidth(225);
		GENview2.setPreserveRatio(false);
		
		//create Start Window logo
		ImageView GENview3 = new ImageView(GENimg);
		GENview3.setFitHeight(225);
		GENview3.setFitWidth(325);
		GENview3.setPreserveRatio(false);
		
		GENlogo.setGraphic(GENview);
		GENreportLogo.setGraphic(GENview2);
		GENStartWindowLogo.setGraphic(GENview3);
		
		//Create Start Window and add its components
		ScrollPane GENstartWindow = new ScrollPane();
		
		VBox GENmainVB = new VBox();
		
		HBox GENCustHB = new HBox();
		HBox GENRepHB = new HBox();
		HBox GENnewCustHB = new HBox();
		
		TextField GENCustNameTF = new TextField("Customer Name");
		GENCustNameTF.setPrefWidth(200);
		
		Button GENHCR = new Button("HCR");
		Button GENRFSSR = new Button("RFSSR");
		Button GENnewCustBT = new Button("New");
		Button GENeditCustBT = new Button("Edit");
		
		
		Label GENCustTF = new Label("Customer: ");
		GENCustTF.setFont(new Font("Arial", 20));
		Label GENRepSel = new Label("Report to Generate: ");
		GENRepSel.setFont(new Font("Arial", 20));
		Label GENAddNewCust = new Label("Customer Creation:  ");
		GENAddNewCust.setFont(new Font("Arial", 20));
		
		//Set Window Component Attributes
		VBox.setVgrow(GENstartWindow, Priority.ALWAYS);
		
		GENmainVB.setMinSize(325, 300);
		GENmainVB.setPadding(new Insets(10,10,10,10));
		GENmainVB.setAlignment(Pos.TOP_CENTER);
		
		GENCustHB.setPadding(new Insets(10,10,10,10));
		GENRepHB.setPadding(new Insets(10,10,10,10));
		GENnewCustHB.setPadding(new Insets(10,10,10,10));
		
		//Button SetOnAction functions
		GENHCR.setOnAction(e ->{
			CUSTOBJFOCUS = GENCustNameTF.getText();
						
			try {startHCR(primaryStage);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
		}});
		
		GENRFSSR.setOnAction(e ->{
			CUSTOBJFOCUS = GENCustNameTF.getText();
			try {startRFSSR(primaryStage);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
			}});
		
		GENnewCustBT.setOnAction(e -> 	{
			try {CusAddstart(primaryStage);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
	}	});
		GENeditCustBT.setOnAction(e -> {
			CUSTOBJFOCUS = GENCustNameTF.getText();
			try {CusEdstart(primaryStage);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
			}});
		
		//Combine all components and add components to the Start Window
		GENCustHB.getChildren().addAll(GENCustTF, GENCustNameTF);
		GENRepHB.getChildren().addAll(GENRepSel, GENHCR, GENRFSSR);
		GENnewCustHB.getChildren().addAll(GENAddNewCust, GENnewCustBT,GENeditCustBT);
		
		GENmainVB.getChildren().addAll(GENStartWindowLogo,GENCustHB,GENRepHB, GENnewCustHB);
		GENstartWindow.setContent(GENmainVB);
		
		Scene GENscene = new Scene(GENstartWindow , 350, 400);
		
		primaryStage.setTitle("HCRGen");
		primaryStage.setX(0);
		primaryStage.setY(0);
		primaryStage.setScene(GENscene);
		primaryStage.show();
	}
	
	/** 
	 * Hood Cleaning Report Window HCR  
	 */
	public void startHCR(Stage primaryStage) throws FileNotFoundException{
		

		//Create a main page VBox and set its attributes
		ScrollPane HCRsp = new ScrollPane();
		VBox HCRmainVB = new VBox();
		VBox.setVgrow(HCRsp, Priority.ALWAYS);
		HCRsp.setContent(HCRmainVB);

		HCRmainVB.setMinSize(400, 400);
		HCRmainVB.setPadding(new Insets(10,10,10,10));
		HCRmainVB.setAlignment(Pos.TOP_CENTER);

		//Create the main page HBoxs, VBoxs and set their attributes
		HBox HCRhb1 = new HBox();
		HCRhb1.setAlignment(Pos.TOP_CENTER);
		HCRhb1.setPadding(new Insets(10,10,10,10));
		HCRhb1.setSpacing(10);
		
		HBox HCRhb2 = new HBox();
		HCRhb2.setAlignment(Pos.TOP_CENTER);
		HCRhb2.setPadding(new Insets(10,10,10,10));
		HCRhb2.setSpacing(10);
		
		HBox HCRhb3 = new HBox();
		HCRhb3.setAlignment(Pos.TOP_CENTER);
		HCRhb3.setPadding(new Insets(10,10,10,10));
		HCRhb3.setSpacing(10);
		
		HBox HCRhb4 = new HBox();
		HCRhb4.setAlignment(Pos.TOP_CENTER);
		HCRhb4.setPadding(new Insets(10,10,10,10));
		HCRhb4.setSpacing(10);
		
		HBox HCRhb5 = new HBox();
		HCRhb5.setAlignment(Pos.TOP_CENTER);
		HCRhb5.setPadding(new Insets(10,10,10,10));
		HCRhb5.setSpacing(10);
		
		HBox HCRhb6 = new HBox();
		HCRhb6.setAlignment(Pos.TOP_LEFT);
		HCRhb6.setPadding(new Insets(10,10,10,10));
		HCRhb6.setSpacing(10);
		
		HBox HCRhb7 = new HBox();
		HCRhb7.setAlignment(Pos.TOP_LEFT);
		HCRhb7.setPadding(new Insets(10,10,10,10));
		HCRhb7.setSpacing(10);
		
		HBox HCRhb8 = new HBox();
		HCRhb8.setAlignment(Pos.TOP_LEFT);
		HCRhb8.setPadding(new Insets(10,10,10,10));
		HCRhb8.setSpacing(10);
		
		HBox HCRhb9 = new HBox();
		HCRhb9.setAlignment(Pos.TOP_LEFT);
		HCRhb9.setPadding(new Insets(10,10,10,10));
		HCRhb9.setSpacing(10);
		
		HBox HCRhb10 = new HBox();
		HCRhb10.setAlignment(Pos.TOP_LEFT);
		HCRhb10.setPadding(new Insets(10,10,10,10));
		HCRhb10.setSpacing(10);
		
		HBox HCRhb11 = new HBox();
		HCRhb11.setAlignment(Pos.TOP_LEFT);
		HCRhb11.setPadding(new Insets(10,10,10,10));
		HCRhb11.setSpacing(10);
		
		HBox HCRhb12 = new HBox();
		HCRhb12.setAlignment(Pos.TOP_LEFT);
		HCRhb12.setPadding(new Insets(10,10,10,10));
		HCRhb12.setSpacing(10);
			
		VBox HCRvb1 = new VBox();
		HCRvb1.setAlignment(Pos.BOTTOM_LEFT);
		HCRvb1.setMinWidth(100);
		
		VBox HCRvb2 = new VBox();
		HCRvb2.setAlignment(Pos.BOTTOM_LEFT);
		HCRvb2.setMinWidth(100);
		
		VBox HCRvb3 = new VBox();
		HCRvb3.setAlignment(Pos.TOP_CENTER);
		HCRvb3.setMinWidth(100);
		
		VBox HCRvb4 = new VBox();
		HCRvb4.setAlignment(Pos.TOP_LEFT);
		HCRvb4.setMinWidth(100);
		
		VBox HCRvb5 = new VBox();
		HCRvb5.setAlignment(Pos.TOP_LEFT);
		HCRvb5.setMinWidth(100);
	/**
	Items that go in HCRhb1 go here
		~ Imageview of logo
		~ Business Info
		~ Invoice box
	*/
		//create GridPane for the logo, business information and invoice Box
		GridPane HCRheadPane = new GridPane();
		HCRheadPane.setMinSize(200, 100);
		HCRheadPane.setPadding(new Insets(10,10,10,10));
		HCRheadPane.setVgap(50);
		HCRheadPane.setHgap(60);
		HCRheadPane.setAlignment(Pos.TOP_LEFT);
		HCRheadPane.setGridLinesVisible(false);
		
		//create ImageView for logo and place in the grid
		File HCRf = new File("TONGS-FIRE-EXTINGUISHER-SALES-AND-SERVICE.jpg");
		String HCRfilLoc = HCRf.getAbsolutePath();
		
		//Creating a Label
		Label HCRlogo = new Label();
		Label HCRreportLogo = new Label();
		
		//Creating a graphic
		Image HCRimg = new Image(new FileInputStream(HCRfilLoc));
		ImageView HCRview = new ImageView(HCRimg);
		HCRview.setFitHeight(125);
		HCRview.setFitWidth(225);
		HCRview.setPreserveRatio(false);
		ImageView HCRview2 = new ImageView(HCRimg);
		HCRview2.setFitHeight(125);
		HCRview2.setFitWidth(225);
		HCRview2.setPreserveRatio(false);
		
		HCRlogo.setGraphic(HCRview);
		HCRreportLogo.setGraphic(HCRview2);

		//create address box labels for Tong's Fire Extinguisher Sales and Service
		Label HCRtongAdr1 = new Label(GENaddress1);
		Label HCRtongAdr2 = new Label(GENaddress2);
		Label HCRtongPhone = new Label(GENphoneNum);
		Label HCRtongLicNum1 = new Label(GENlicNumTech1);
		Label HCRtongLicNum2 = new Label(GENlicNumTech2);
		
		//Create Address VBox for Tong's Fire Extinguisher Sales and Service information
		HCRvb1.getChildren().addAll(HCRtongAdr1, HCRtongAdr2, HCRtongPhone, HCRtongLicNum1, HCRtongLicNum2);
		
		//Create Invoice HBox and place it in the pane
		VBox HCRinvVBox = new VBox();
		HCRinvVBox.setAlignment(Pos.TOP_LEFT);
		
		Label HCRinvRefNum = new Label(" Invoice Reference #");
		TextField HCRtfInvoice = new TextField("####");
		HCRtfInvoice.setFont(new Font("Cambria", 10));
		HCRinvVBox.getChildren().addAll(HCRinvRefNum, HCRtfInvoice);
		
		//place boxes in the top pane
		HCRheadPane.add(HCRlogo, 0,0);		
		HCRheadPane.add(HCRvb1, 1,0);
		HCRheadPane.add(HCRinvVBox, 2,0);
		
		//add completed headPane to HCRhb1
		HCRhb1.getChildren().addAll(HCRheadPane);
		
	/**
	Items that go in HCRhb2 and go here
		~ Service Info Box
		~ Customer Info Box
	*/
		//Create Service Schedule Information box
		Label HCRservSchLabel = new Label(" Service Scheduled with: ");
		Label HCRstoreCMLabel = new Label(" Store Closing Manager: ");
		Label HCRdateOSLabel = new Label(" Date of Service: ");
		Label HCRserviceELabel = new Label(" Service Frequency ");
		Label HCRtimeOSLabel = new Label(" Time of Service: ");
		TextField HCRservSchTF = new TextField(((CusOb) map.get(CUSTOBJFOCUS)).getSSw());
		HCRservSchTF.setMinWidth(205);
		HCRservSchTF.setFont(new Font("Cambria", 10));
		TextField HCRstoreCMTF = new TextField(((CusOb) map.get(CUSTOBJFOCUS)).getSCM());
		HCRstoreCMTF.setFont(new Font("Cambria", 10));
		HCRstoreCMTF.setMaxWidth(275);
		DatePicker HCRdateOSDP = new DatePicker();
		
		ComboBox<String> HCRserviceECB = new ComboBox<String>();
		HCRserviceECB.setValue(((CusOb) map.get(CUSTOBJFOCUS)).getSF());
		HCRserviceECB.getItems().addAll("Annually", "Bi-Annually", "Quarterly");
		
		TextField HCRtimeOSTF = new TextField("00:00");
		HCRtimeOSTF.setFont(new Font("Cambria", 10));
		HCRtimeOSTF.setMaxWidth(75);
		
		GridPane HCRservGrid = new GridPane();
		HCRservGrid.setMinSize(400, 100);
				
		HCRservGrid.add(HCRservSchLabel,0,0);
		HCRservGrid.add(HCRservSchTF,1,0);
		HCRservGrid.add(HCRstoreCMLabel,0,1);
		HCRservGrid.add(HCRstoreCMTF,1,1);
		HCRservGrid.add(HCRdateOSLabel,0,2);
		HCRservGrid.add(HCRdateOSDP,1,2);
		HCRservGrid.add(HCRtimeOSLabel,0,3);
		HCRservGrid.add(HCRtimeOSTF,1,3);
		HCRservGrid.add(HCRserviceELabel,0,4);
		HCRservGrid.add(HCRserviceECB,1,4);

		HCRservGrid.setAlignment(Pos.TOP_LEFT);
		
		//Create Second row of boxes for Customer information and place them on the grid
		Label HCRcustPhoneLabel = new Label(" Phone: ");
		Label HCRcustNameLabel = new Label(" Client: ");
		Label HCRcustAdrLabel = new Label(" Address: ");
		Label HCRcustAdrCityLabel = new Label(" City: ");
		Label HCRcustAdrStateLabel = new Label(" State: ");
		Label HCRcustAdrZipLabel = new Label(" Zip: ");
		
		TextField HCRtfcustPhone = new TextField(((CusOb) map.get(CUSTOBJFOCUS)).getPhone());
		HCRtfcustPhone.setFont(new Font("Cambria", 10));
		HCRtfcustPhone.setMaxWidth(115);
		TextField HCRtfcustName = new TextField(((CusOb) map.get(CUSTOBJFOCUS)).getClient());
		HCRtfcustName.setFont(new Font("Cambria", 10));
		HCRtfcustName.setMinWidth(205);
		TextField HCRtfcustAdr = new TextField(((CusOb) map.get(CUSTOBJFOCUS)).getAddress());
		HCRtfcustAdr.setFont(new Font("Cambria", 10));
		HCRtfcustAdr.setMaxWidth(275);
		TextField HCRtfcustAdrCity = new TextField(((CusOb) map.get(CUSTOBJFOCUS)).getCity());
		HCRtfcustAdrCity.setFont(new Font("Cambria", 10));
		HCRtfcustAdrCity.setMaxWidth(115);
		TextField HCRtfcustAdrState = new TextField(((CusOb) map.get(CUSTOBJFOCUS)).getState());
		HCRtfcustAdrState.setFont(new Font("Cambria", 10));
		HCRtfcustAdrState.setMaxWidth(115);
		TextField HCRtfcustAdrZip = new TextField(((CusOb) map.get(CUSTOBJFOCUS)).getZip());
		HCRtfcustAdrZip.setFont(new Font("Cambria", 10));
		HCRtfcustAdrZip.setMaxWidth(115);
		
		GridPane HCRcustGrid = new GridPane();
		HCRcustGrid.add(HCRcustNameLabel,0,0);
		HCRcustGrid.add(HCRtfcustName,1,0);
		
		HCRcustGrid.add(HCRcustAdrLabel,0,1);
		HCRcustGrid.add(HCRtfcustAdr,1,1);
		
		HCRcustGrid.add(HCRcustAdrCityLabel,0,2);
		HCRcustGrid.add(HCRtfcustAdrCity,1,2);
		
		HCRcustGrid.add(HCRcustAdrStateLabel,0,3);
		HCRcustGrid.add(HCRtfcustAdrState,1,3);
		
		HCRcustGrid.add(HCRcustAdrZipLabel,0,4);
		HCRcustGrid.add(HCRtfcustAdrZip,1,4);
		
		HCRcustGrid.add(HCRcustPhoneLabel,0,5);
		HCRcustGrid.add(HCRtfcustPhone,1,5);
		
		HCRhb2.setAlignment(Pos.TOP_LEFT);
		
		HCRhb2.getChildren().addAll(HCRservGrid, HCRcustGrid);
		
	/**
	Items that go in HCRvb2 go here
		~ Notes to technicians *servLabel7*
		~ TextArea *taServ1*
	*/
		
		//Create cleaning notes text area and label
		TextArea HCRtaServ1 = new TextArea();
		HCRtaServ1.setWrapText(true);
		HCRtaServ1.setPrefHeight(50);
		HCRtaServ1.setMaxWidth(750);

		Label HCRservLabel7 = new Label(" Notes for cleaning technicians: ");
		
		HCRvb2.getChildren().addAll(HCRservLabel7, HCRtaServ1);
		
	/**
	Items that go in HCRhb3 go here
		~ cleaning notice label *cLNOLabel*
	*/
		//Create the cleaning notice and place it in the grid
		Label HCRclNoLabel = new Label("All cleaning is in accordance with the local fire codes and/or NFPA Standard Code #96. This courtesy follow-up report is provided as a free customer service only; it is not a paid consultation. The inspection of the exhaust system is limited to the possible need for improved access and cleaning only. Other deficiencies, whether reported or not, are beyond the scope of our cleaning crew's knowledge. It is the owner of the exhaust system's responsibility to take appropriate action to modify any deficiencies noted herein or elsewhere.");
		HCRclNoLabel.setFont(new Font("Cambria", 10));
		HCRclNoLabel.setMaxWidth(750);
		HCRclNoLabel.setWrapText(true);
		//HCRhb3.getChildren().add(HCRclNoLabel);
		

	/**
	Items that go in HCRvb3 go here
		~ Kitchen Exhaust Cleaning Service Report Title bar
		~ Initial service check boxes
	*/
		
		//Create the kitchen cleaning service report boxes and place them in the grid
		Label HCRkECSRLabel = new Label("KITCHEN EXHAUST CLEANING SERVICE REPORT");
		
		RadioButton HCRiScb = new RadioButton("INITIAL SERVICE ");
		RadioButton HCRrScb = new RadioButton("REGULAR SERVICE ");
		RadioButton HCRiNcb = new RadioButton("INSPECTION ");
		
		HCRhb4.getChildren().addAll(HCRiScb, HCRrScb, HCRiNcb);
		
		HCRvb3.getChildren().addAll(HCRkECSRLabel, HCRhb4);
		
	/**
	Items that go in HCRhb5 go here
		~ Check In Box
		~ Check Out Box
	*/
	
		//Check In Box
		Label HCRcheckInLabel = new Label("Check In: ");
		Label HCRcIYLabel = new Label("Yes ");
		HCRcIYLabel.setFont(new Font("Cambria", 10));
		Label HCRcINLabel = new Label("No");
		HCRcINLabel.setFont(new Font("Cambria", 10));
		Label HCRlightLabel = new Label("Light ");
		HCRlightLabel.setFont(new Font("Cambria", 10));
		Label HCRmediumLabel = new Label("Med ");
		HCRmediumLabel.setFont(new Font("Cambria", 10));
		Label HCRheavyLabel = new Label("Heavy");
		HCRheavyLabel.setFont(new Font("Cambria", 10));
		Label HCRdKWLabel = new Label("1. Key works ");
		Label HCRfWPLabel = new Label("2. Fans working properly ");
		Label HCRdIFWLabel = new Label("3. Defects in fan wiring ");
		Label HCRaFHLabel = new Label("4. Fans hinged ");
		Label HCRfDWLabel = new Label("5. Floor drains working ");
		Label HCRhLWLabel = new Label("6. Hood lights working ");
		Label HCRhGPLabel = new Label("7. Hood globes present ");
		Label HCRrTCSLabel = new Label("8. Rooftop grease containment system ");
		Label HCRgBURFLabel = new Label("9. Grease build-up around roof fan ");
		Label HCRgBUFBLabel = new Label("10. Grease build-up fan blades ");
		Label HCRgBUSDLabel = new Label("11. Grease build-up stacks/ductwork ");
		Label HCRgBUHLabel = new Label("12. Grease build-up on hoods ");
		Label HCRgBUFiLabel = new Label("13. Grease build-up on filter ");	
		
		ToggleGroup HCRdkW = new ToggleGroup();
		RadioButton HCRdKWrb1 = new RadioButton();
		HCRdKWrb1.setToggleGroup(HCRdkW);
		RadioButton HCRdKWrb2 = new RadioButton();
		HCRdKWrb2.setToggleGroup(HCRdkW);
		
		ToggleGroup HCRfWP = new ToggleGroup();
		RadioButton HCRfWPrb1 = new RadioButton();
		HCRfWPrb1.setToggleGroup(HCRfWP);
		RadioButton HCRfWPrb2 = new RadioButton();
		HCRfWPrb2.setToggleGroup(HCRfWP);
		
		ToggleGroup HCRdIF = new ToggleGroup();
		RadioButton HCRdIFrb1 = new RadioButton();
		HCRdIFrb1.setToggleGroup(HCRdIF);
		RadioButton HCRdIFrb2 = new RadioButton();
		HCRdIFrb2.setToggleGroup(HCRdIF);
		
		ToggleGroup HCRaFH = new ToggleGroup();
		RadioButton HCRaFHrb1 = new RadioButton();
		HCRaFHrb1.setToggleGroup(HCRaFH);
		RadioButton HCRaFHrb2 = new RadioButton();
		HCRaFHrb2.setToggleGroup(HCRaFH);
		
		ToggleGroup HCRfDW = new ToggleGroup();
		RadioButton HCRfDWrb1 = new RadioButton();
		HCRfDWrb1.setToggleGroup(HCRfDW);
		RadioButton HCRfDWrb2 = new RadioButton();
		HCRfDWrb2.setToggleGroup(HCRfDW);
		
		ToggleGroup HCRhLW = new ToggleGroup();
		RadioButton HCRhLWrb1 = new RadioButton();
		HCRhLWrb1.setToggleGroup(HCRhLW);
		RadioButton HCRhLWrb2 = new RadioButton();
		HCRhLWrb2.setToggleGroup(HCRhLW);
		
		ToggleGroup HCRhGP = new ToggleGroup();
		RadioButton HCRhGPrb1 = new RadioButton();
		HCRhGPrb1.setToggleGroup(HCRhGP);
		RadioButton HCRhGPrb2 = new RadioButton();
		HCRhGPrb2.setToggleGroup(HCRhGP);
		
		ToggleGroup HCRrTCS = new ToggleGroup();
		RadioButton HCRrTCSrb1 = new RadioButton();
		HCRrTCSrb1.setToggleGroup(HCRrTCS);
		RadioButton HCRrTCSrb2 = new RadioButton();
		HCRrTCSrb2.setToggleGroup(HCRrTCS);
		
		ToggleGroup HCRgBURF = new ToggleGroup();
		RadioButton HCRgBURFrb1 = new RadioButton();
		HCRgBURFrb1.setToggleGroup(HCRgBURF);
		RadioButton HCRgBURFrb2 = new RadioButton();
		HCRgBURFrb2.setToggleGroup(HCRgBURF);
		RadioButton HCRgBURFrb3 = new RadioButton();
		HCRgBURFrb3.setToggleGroup(HCRgBURF);
		
		ToggleGroup HCRgBUFB = new ToggleGroup();
		RadioButton HCRgBUFBrb1 = new RadioButton();
		HCRgBUFBrb1.setToggleGroup(HCRgBUFB);
		RadioButton HCRgBUFBrb2 = new RadioButton();
		HCRgBUFBrb2.setToggleGroup(HCRgBUFB);
		RadioButton HCRgBUFBrb3 = new RadioButton();
		HCRgBUFBrb3.setToggleGroup(HCRgBUFB);
		
		ToggleGroup HCRgBUSD = new ToggleGroup();
		RadioButton HCRgBUSDrb1 = new RadioButton();
		HCRgBUSDrb1.setToggleGroup(HCRgBUSD);
		RadioButton HCRgBUSDrb2 = new RadioButton();
		HCRgBUSDrb2.setToggleGroup(HCRgBUSD);
		RadioButton HCRgBUSDrb3 = new RadioButton();
		HCRgBUSDrb3.setToggleGroup(HCRgBUSD);
		
		ToggleGroup HCRgBUH = new ToggleGroup();
		RadioButton HCRgBUHrb1 = new RadioButton();
		HCRgBUHrb1.setToggleGroup(HCRgBUH);
		RadioButton HCRgBUHrb2 = new RadioButton();
		HCRgBUHrb2.setToggleGroup(HCRgBUH);
		RadioButton HCRgBUHrb3 = new RadioButton();
		HCRgBUHrb3.setToggleGroup(HCRgBUH);
		
		ToggleGroup HCRgBUFi = new ToggleGroup();
		RadioButton HCRgBUFirb1 = new RadioButton();
		HCRgBUFirb1.setToggleGroup(HCRgBUFi);
		RadioButton HCRgBUFirb2 = new RadioButton();
		HCRgBUFirb2.setToggleGroup(HCRgBUFi);
		RadioButton HCRgBUFirb3 = new RadioButton();
		HCRgBUFirb3.setToggleGroup(HCRgBUFi);

	
		GridPane HCRcIBGrid = new GridPane();
		HCRcIBGrid.add(HCRcheckInLabel,0,0);
		HCRcIBGrid.add(HCRcIYLabel,1,0);
		HCRcIBGrid.add(HCRcINLabel,2,0);
		
		HCRcIBGrid.add(HCRdKWLabel,0,1);
		HCRcIBGrid.add(HCRdKWrb1,1,1);
		HCRcIBGrid.add(HCRdKWrb2,2,1);
		
		HCRcIBGrid.add(HCRfWPLabel,0,2);
		HCRcIBGrid.add(HCRfWPrb1,1,2);
		HCRcIBGrid.add(HCRfWPrb2,2,2);
		
		HCRcIBGrid.add(HCRdIFWLabel,0,3);
		HCRcIBGrid.add(HCRdIFrb1,1,3);
		HCRcIBGrid.add(HCRdIFrb2,2,3);
						
		HCRcIBGrid.add(HCRaFHLabel,0,4);
		HCRcIBGrid.add(HCRaFHrb1,1,4);
		HCRcIBGrid.add(HCRaFHrb2,2,4);
		
		HCRcIBGrid.add(HCRfDWLabel,0,5);
		HCRcIBGrid.add(HCRfDWrb1,1,5);
		HCRcIBGrid.add(HCRfDWrb2,2,5);
		
		HCRcIBGrid.add(HCRhLWLabel,0,6);
		HCRcIBGrid.add(HCRhLWrb1,1,6);
		HCRcIBGrid.add(HCRhLWrb2,2,6);
		
		HCRcIBGrid.add(HCRhGPLabel,0,7);
		HCRcIBGrid.add(HCRhGPrb1,1,7);
		HCRcIBGrid.add(HCRhGPrb2,2,7);
		
		HCRcIBGrid.add(HCRrTCSLabel,0,8);
		HCRcIBGrid.add(HCRrTCSrb1,1,8);
		HCRcIBGrid.add(HCRrTCSrb2,2,8);
		
		HCRcIBGrid.add(HCRlightLabel,1,9);
		HCRcIBGrid.add(HCRmediumLabel,2,9);
		HCRcIBGrid.add(HCRheavyLabel,3,9);
		
		HCRcIBGrid.add(HCRgBURFLabel,0,10);
		HCRcIBGrid.add(HCRgBURFrb1,1,10);
		HCRcIBGrid.add(HCRgBURFrb2,2,10);
		HCRcIBGrid.add(HCRgBURFrb3,3,10);
		
		HCRcIBGrid.add(HCRgBUFBLabel,0,11);
		HCRcIBGrid.add(HCRgBUFBrb1,1,11);
		HCRcIBGrid.add(HCRgBUFBrb2,2,11);
		HCRcIBGrid.add(HCRgBUFBrb3,3,11);
				
		HCRcIBGrid.add(HCRgBUSDLabel,0,12);
		HCRcIBGrid.add(HCRgBUSDrb1,1,12);
		HCRcIBGrid.add(HCRgBUSDrb2,2,12);
		HCRcIBGrid.add(HCRgBUSDrb3,3,12);
		
		HCRcIBGrid.add(HCRgBUHLabel,0,13);
		HCRcIBGrid.add(HCRgBUHrb1,1,13);
		HCRcIBGrid.add(HCRgBUHrb2,2,13);
		HCRcIBGrid.add(HCRgBUHrb3,3,13);
		
		HCRcIBGrid.add(HCRgBUFiLabel,0,14);
		HCRcIBGrid.add(HCRgBUFirb1,1,14);
		HCRcIBGrid.add(HCRgBUFirb2,2,14);
		HCRcIBGrid.add(HCRgBUFirb3,3,14);
			
		//Check Out Box
		Label HCRcheckOutLabel = new Label("Check Out: ");
		Label HCRcOYLabel = new Label("Yes");
		HCRcOYLabel.setFont(new Font("Cambria", 10));
		Label HCRcONLabel = new Label("No");
		HCRcONLabel.setFont(new Font("Cambria", 10));
		Label HCRcONewLabel = new Label("NEW    ");
		HCRcONewLabel.setFont(new Font("Cambria", 10));
		Label HCRcOULabel = new Label("UPDATE");
		HCRcOULabel.setFont(new Font("Cambria", 10));		
		Label HCRfWLRLabel = new Label("1. Fans working and left running ");
		Label HCRrANFROLabel = new Label("2. Roof area near fan rinsed off ");
		Label HCRhIWDLabel = new Label("3. Hood interior wiped dry ");
		Label HCRkFCEWDLabel = new Label("4. Kitchen floor clean / Equipment wiped down ");
		Label HCRoARCLabel = new Label("5. Outside area rinsed and clean ");
		Label HCRhSFPWLabel = new Label("6. Hood, stack, fan pressure washed ");
		Label HCRhDGLLabel = new Label("7. Any horizontal ductwork / give length ");
		Label HCRaPGQLabel = new Label("8. Any access panels / give quantity ");
		Label HCRsDWTLabel = new Label("9. Stack / ductwork water tight ");
		Label HCRpLRLabel = new Label("10. Pilot lights reignited ");
		Label HCRphotoTLabel = new Label("11. Photos taken ");
		Label HCRhSRLabel = new Label("12. Hood sticker replaced ");

		CheckBox HCRinAccCB = new CheckBox("INACESSIBLE AREAS AND/OR FIRE CODE VIOLATIONS EXIST");
		HCRinAccCB.setFont(new Font("Cambria", 10));
		Label HCRmoreHoods = new Label("Hood Description");
		HCRmoreHoods.setFont(new Font("Cambria", 10));
		HCRmoreHoods.setMaxWidth(115);
		TextField HCRmoreHoods2 = new TextField();
		HCRmoreHoods2.setFont(new Font("Cambria", 10));
		HCRmoreHoods2.setMaxWidth(200);
		
		ToggleGroup HCRfWLR = new ToggleGroup();
		RadioButton HCRfWLRrb1 = new RadioButton();
		HCRfWLRrb1.setToggleGroup(HCRfWLR);
		RadioButton HCRfWLRrb2 = new RadioButton();
		HCRfWLRrb2.setToggleGroup(HCRfWLR);
	
		ToggleGroup HCRrANFRO = new ToggleGroup();
		RadioButton HCRrANFROrb1 = new RadioButton();
		HCRrANFROrb1.setToggleGroup(HCRrANFRO);
		RadioButton HCRrANFROrb2 = new RadioButton();
		HCRrANFROrb2.setToggleGroup(HCRrANFRO);
	
		ToggleGroup HCRhIWD = new ToggleGroup();
		RadioButton HCRhIWDrb1 = new RadioButton();
		HCRhIWDrb1.setToggleGroup(HCRhIWD);
		RadioButton HCRhIWDrb2 = new RadioButton();
		HCRhIWDrb2.setToggleGroup(HCRhIWD);
		
		ToggleGroup HCRkFCEWD = new ToggleGroup();
		RadioButton HCRkFCEWDrb1 = new RadioButton();
		HCRkFCEWDrb1.setToggleGroup(HCRkFCEWD);
		RadioButton HCRkFCEWDrb2 = new RadioButton();
		HCRkFCEWDrb2.setToggleGroup(HCRkFCEWD);
		
		ToggleGroup HCRoARC = new ToggleGroup();
		RadioButton HCRoARCrb1 = new RadioButton();
		HCRoARCrb1.setToggleGroup(HCRoARC);
		RadioButton HCRoARCrb2 = new RadioButton();
		HCRoARCrb2.setToggleGroup(HCRoARC);
	
		ToggleGroup HCRhSFPW = new ToggleGroup();
		RadioButton HCRhSFPWrb1 = new RadioButton();
		HCRhSFPWrb1.setToggleGroup(HCRhSFPW);
		RadioButton HCRhSFPWrb2 = new RadioButton();
		HCRhSFPWrb2.setToggleGroup(HCRhSFPW);
		
		ToggleGroup HCRhDGL = new ToggleGroup();
		RadioButton HCRhDGLrb1 = new RadioButton();
		HCRhDGLrb1.setToggleGroup(HCRhDGL);
		RadioButton HCRhDGLrb2 = new RadioButton();
		HCRhDGLrb2.setToggleGroup(HCRhDGL);
		
		ToggleGroup HCRaPGQ = new ToggleGroup();
		RadioButton HCRaPGQrb1 = new RadioButton();
		HCRaPGQrb1.setToggleGroup(HCRaPGQ);
		RadioButton HCRaPGQrb2 = new RadioButton();
		HCRaPGQrb2.setToggleGroup(HCRaPGQ);
		
		ToggleGroup HCRsDWT = new ToggleGroup();
		RadioButton HCRsDWTrb1 = new RadioButton();
		HCRsDWTrb1.setToggleGroup(HCRsDWT);
		RadioButton HCRsDWTrb2 = new RadioButton();
		HCRsDWTrb2.setToggleGroup(HCRsDWT);
		
		ToggleGroup HCRpLR = new ToggleGroup();
		RadioButton HCRpLRrb1 = new RadioButton();
		HCRpLRrb1.setToggleGroup(HCRpLR);
		RadioButton HCRpLRrb2 = new RadioButton();
		HCRpLRrb2.setToggleGroup(HCRpLR);
		
		ToggleGroup HCRhSR = new ToggleGroup();
		RadioButton HCRhSRrb1 = new RadioButton();
		HCRhSRrb1.setToggleGroup(HCRhSR);
		RadioButton HCRhSRrb2 = new RadioButton();
		HCRhSRrb2.setToggleGroup(HCRhSR);
		
		ToggleGroup HCRphotoT = new ToggleGroup();
		RadioButton HCRphotoTrb1 = new RadioButton();
		HCRphotoTrb1.setToggleGroup(HCRphotoT);
		RadioButton HCRphotoTrb2 = new RadioButton();
		HCRphotoTrb2.setToggleGroup(HCRphotoT);
		
		GridPane HCRcOBGrid = new GridPane();
		HCRcOBGrid.add(HCRcheckOutLabel,0,0);
		HCRcOBGrid.add(HCRcOYLabel,1,0);
		HCRcOBGrid.add(HCRcONLabel,2,0);
		
		HCRcOBGrid.add(HCRfWLRLabel,0,1);
		HCRcOBGrid.add(HCRfWLRrb1,1,1);
		HCRcOBGrid.add(HCRfWLRrb2,2,1);
		
		HCRcOBGrid.add(HCRrANFROLabel,0,2);
		HCRcOBGrid.add(HCRrANFROrb1,1,2);
		HCRcOBGrid.add(HCRrANFROrb2,2,2);
		
		HCRcOBGrid.add(HCRhIWDLabel,0,3);
		HCRcOBGrid.add(HCRhIWDrb1,1,3);
		HCRcOBGrid.add(HCRhIWDrb2,2,3);
						
		HCRcOBGrid.add(HCRkFCEWDLabel,0,4);
		HCRcOBGrid.add(HCRkFCEWDrb1,1,4);
		HCRcOBGrid.add(HCRkFCEWDrb2,2,4);
		
		HCRcOBGrid.add(HCRoARCLabel,0,5);
		HCRcOBGrid.add(HCRoARCrb1,1,5);
		HCRcOBGrid.add(HCRoARCrb2,2,5);
		
		HCRcOBGrid.add(HCRhSFPWLabel,0,6);
		HCRcOBGrid.add(HCRhSFPWrb1,1,6);
		HCRcOBGrid.add(HCRhSFPWrb2,2,6);
		
		HCRcOBGrid.add(HCRhDGLLabel,0,7);
		HCRcOBGrid.add(HCRhDGLrb1,1,7);
		HCRcOBGrid.add(HCRhDGLrb2,2,7);
		
		HCRcOBGrid.add(HCRaPGQLabel,0,8);
		HCRcOBGrid.add(HCRaPGQrb1,1,8);
		HCRcOBGrid.add(HCRaPGQrb2,2,8);
		
		HCRcOBGrid.add(HCRsDWTLabel,0,9);
		HCRcOBGrid.add(HCRsDWTrb1,1,9);
		HCRcOBGrid.add(HCRsDWTrb2,2,9);
		
		HCRcOBGrid.add(HCRpLRLabel,0,10);
		HCRcOBGrid.add(HCRpLRrb1,1,10);
		HCRcOBGrid.add(HCRpLRrb2,2,10);
		
		HCRcOBGrid.add(HCRphotoTLabel,0,11);
		HCRcOBGrid.add(HCRphotoTrb1,1,11);
		HCRcOBGrid.add(HCRphotoTrb2,2,11);
		
		HCRcOBGrid.add(HCRcONewLabel,1,12);
		HCRcOBGrid.add(HCRcOULabel,2,12);
		
		HCRcOBGrid.add(HCRhSRLabel,0,13);
		HCRcOBGrid.add(HCRhSRrb1,1,13);
		HCRcOBGrid.add(HCRhSRrb2,2,13);
		
		HCRcOBGrid.add(HCRinAccCB,0,14);
		
		HCRcOBGrid.add(HCRmoreHoods,0,15);
		HCRcOBGrid.add(HCRmoreHoods2,0,16);
		
		HCRhb5.getChildren().addAll(HCRcIBGrid, HCRcOBGrid);
		
	/*
	Items that go in HCRhb6 go here
		~ Time in Time out boxes 
	*/
	
		Label HCRtILabel = new Label("TIME IN: ");
		Label HCRtOLabel = new Label("TIME OUT: ");
		
		TextField HCRtfTI = new TextField("00:00");
		HCRtfTI.setFont(new Font("Cambria", 10));
		HCRtfTI.setMaxWidth(80);
		TextField HCRtfTO = new TextField("00:00");
		HCRtfTO.setFont(new Font("Cambria", 10));
		HCRtfTO.setMaxWidth(80);
		
		HCRhb6.getChildren().addAll(HCRtILabel, HCRtfTI, HCRtOLabel, HCRtfTO);
		
	/*
	Items that go in HCRhb7 go here
		~ Miscellaneous notes text field
		~ Acknowledgement box
	*/
		//Create the miscellaneous Notes and Acknowledgment Boxes and place them in the grid
		Label HCRmiscNotLabel = new Label("Misc. Notes: All items marked no must have an explanation");
		Label HCRtechSigLabel = new Label("Technician Name:");
		Label HCRclaimLabel = new Label("\nClaims of unsatisfactory workmanship must be made within 48 hours. Invoices are subject to an intrest charge of the lesser of 1.5% per month(18% per year) or the maximum rate allowed by law on any unpaid invoices outstanding after 30 days from date of service. The Customer herby waives thier rights of subrogation by thier insurance carrier against Tong's Fire Extinguisher under any fire or liability insurance policy.");
		HCRclaimLabel.setMaxWidth(375);
		HCRclaimLabel.setFont(new Font("Cambria", 10));
		HCRclaimLabel.setWrapText(true);

		Label HCReventLabel = new Label("IN THE EVENT OF DEFAULT, TONG'S FIRE EXTINGUISHER SHALL BE ENTITLED TO RECOVER COST OF COLLECTION, INCLUDING REASONABLE ATTORNEY FEES.");
		HCReventLabel.setMaxWidth(375);
		HCReventLabel.setWrapText(true);
		Label HCRackLabel = new Label("ACKNOWLEDGMENT OF KITCHEN CONDITION & KEC SERVICE COMPLETED. BY SIGNING BELOW THE CUSTOMER ACKNOWLEDGES SERVICE WAS COMPLETED AND THE KITCHEN WAS LEFT CLEAN AND IN SATISFACTORY CONDITION.");
		HCRackLabel.setFont(new Font("Cambria", 10));
		HCRackLabel.setWrapText(true);
		HCRackLabel.setMaxWidth(375);
		Label HCRcustSignLabel = new Label("Customer Name: ");
		
		TextArea HCRmiscNotTa = new TextArea();
		HCRmiscNotTa.setWrapText(true);
		HCRmiscNotTa.setFont(new Font("Cambria", 10));
		HCRmiscNotTa.setWrapText(true);
		HCRmiscNotTa.setMaxWidth(375);

		ComboBox<String> HCRtechtf = new ComboBox<String>();
		HCRtechtf.getItems().addAll("Scott", "Dusten");
		TextField HCRcustSigntf = new TextField( "                                                                                                         Date: ");
		HCRcustSigntf.setFont(new Font("Cambria", 10));
		Button HCRbtPreView = new Button("Preview");
		Button HCRbtBack = new Button("Back");
		Button HCRbtPrint = new Button("Print");
		CheckBox HCRkeyCB = new CheckBox("Key ");
		CheckBox HCRnoAvailCB = new CheckBox("No one available to sign ");

		
		HCRhb7.getChildren().addAll(HCRvb4, HCRvb5);
		HCRhb8.getChildren().addAll(HCRkeyCB, HCRnoAvailCB);
		HCRhb9.getChildren().addAll(HCRtechSigLabel,HCRtechtf);
		HCRhb10.getChildren().addAll(HCRbtPreView, HCRbtBack);
		HCRhb11.getChildren().addAll(HCRcustSignLabel,HCRcustSigntf);
		
		HCRvb4.getChildren().addAll(HCRmiscNotLabel, HCRmiscNotTa);
		HCRvb5.getChildren().addAll(HCRhb9, HCRhb11, HCRhb8, HCRhb10);
		
		//OnAction events for radio buttons and check boxes
		HCRdKWrb1.setOnAction(e -> {setYes(GENdkWSt, "HCRdKWrb1"); });
		HCRdKWrb2.setOnAction(e -> {setNo(GENdkWSt, "HCRdKWrb2"); });
				
		HCRfWPrb1.setOnAction(e -> {setYes(GENdkWSt, "HCRfWPrb1"); });
		HCRfWPrb2.setOnAction(e -> {setNo(GENdkWSt, "HCRfWPrb2"); });
		
		HCRdIFrb1.setOnAction(e -> {setYes(GENdIFSt, "HCRdIFrb1"); });
		HCRdIFrb2.setOnAction(e -> {setNo(GENdIFSt, "HCRdIFrb2"); });
		
		HCRaFHrb1.setOnAction(e -> {setYes(GENaFHSt, "HCRaFHrb1"); });
		HCRaFHrb2.setOnAction(e -> {setNo(GENaFHSt, "HCRaFHrb2"); });
		
		HCRfDWrb1.setOnAction(e -> {setYes(GENfDWSt, "HCRfDWrb1"); });
		HCRfDWrb2.setOnAction(e -> {setNo(GENfDWSt, "HCRfDWrb2"); });
		
		HCRhLWrb1.setOnAction(e -> {setYes(GENhLWSt, "HCRhLWrb1"); });
		HCRhLWrb2.setOnAction(e -> {setNo(GENhLWSt, "HCRhLWrb2"); });
		
		HCRhGPrb1.setOnAction(e -> {setYes(GENhGPSt, "HCRhGPrb1"); });
		HCRhGPrb2.setOnAction(e -> {setNo(GENhGPSt, "HCRhGPrb2"); });
		
		HCRrTCSrb1.setOnAction(e -> {setYes(GENrTCSSt, "HCRrTCSrb1"); });
		HCRrTCSrb2.setOnAction(e -> {setNo(GENrTCSSt, "HCRrTCSrb2"); });
		
		HCRgBURFrb1.setOnAction(e -> {setLight(GENgBURFSt, "HCRgBURFrb1"); });
		HCRgBURFrb2.setOnAction(e -> {setMedium(GENgBURFSt, "HCRgBURFrb2"); });
		HCRgBURFrb3.setOnAction(e -> {setHeavy(GENgBURFSt, "HCRgBURFrb3"); });
		
		HCRgBUFBrb1.setOnAction(e -> {setLight(GENgBUFBSt, "HCRgBUFBrb1"); });
		HCRgBUFBrb2.setOnAction(e -> {setMedium(GENgBUFBSt, "HCRgBUFBrb2"); });
		HCRgBUFBrb3.setOnAction(e -> {setHeavy(GENgBUFBSt, "HCRgBUFBrb3"); });
		
		HCRgBUSDrb1.setOnAction(e -> {setLight(GENgBUSDSt, "HCRgBUSDrb1"); });
		HCRgBUSDrb2.setOnAction(e -> {setMedium(GENgBUSDSt, "HCRgBUSDrb2"); });
		HCRgBUSDrb3.setOnAction(e -> {setHeavy(GENgBUSDSt, "HCRgBUSDrb3"); });
		
		HCRgBUHrb1.setOnAction(e -> {setLight(GENgBUHSt, "HCRgBUHrb1"); });
		HCRgBUHrb2.setOnAction(e -> {setMedium(GENgBUHSt, "HCRgBUHrb2"); });
		HCRgBUHrb3.setOnAction(e -> {setHeavy(GENgBUHSt, "HCRgBUHrb3"); });
		
		HCRgBUFirb1.setOnAction(e -> {setLight(GENgBUFiSt, "HCRgBUFirb1"); });
		HCRgBUFirb2.setOnAction(e -> {setMedium(GENgBUFiSt, "HCRgBUFirb2"); });
		HCRgBUFirb3.setOnAction(e -> {setHeavy(GENgBUFiSt, "HCRgBUFirb3"); });
		
		HCRfWLRrb1.setOnAction(e -> {setYes(GENfWLRSt, "HCRfWLRrb1"); });
		HCRfWLRrb2.setOnAction(e -> {setNo(GENfWLRSt, "HCRfWLRrb2"); });
		
		HCRrANFROrb1.setOnAction(e -> {setYes(GENrANFROSt, "HCRrANFROrb1"); });
		HCRrANFROrb2.setOnAction(e -> {setNo(GENrANFROSt, "HCRrANFROrb2"); });
		
		HCRhIWDrb1.setOnAction(e -> {setYes(GENhIWDSt, "HCRhIWDrb1"); });
		HCRhIWDrb2.setOnAction(e -> {setNo(GENhIWDSt, "HCRhIWDrb2"); });
		
		HCRkFCEWDrb1.setOnAction(e -> {setYes(GENkFCEWDSt, "HCRHCRkFCEWDrb1"); });
		HCRkFCEWDrb2.setOnAction(e -> {setNo(GENkFCEWDSt, "HCRkFCEWDrb2"); });
		
		HCRoARCrb1.setOnAction(e -> {setYes(GENoARCSt, "HCRoARCrb1"); });
		HCRoARCrb2.setOnAction(e -> {setNo(GENoARCSt, "HCRoARCrb2"); });
		
		HCRhSFPWrb1.setOnAction(e -> {setYes(GENhSFPWSt, "HCRhSFPWrb1"); });
		HCRhSFPWrb2.setOnAction(e -> {setNo(GENhSFPWSt, "HCRhSFPWrb2"); });
		
		HCRhDGLrb1.setOnAction(e -> {setYes(GENhDGLSt, "HCRhDGLrb1"); });
		HCRhDGLrb2.setOnAction(e -> {setNo(GENhDGLSt, "HCRhDGLrb2"); });
		
		HCRaPGQrb1.setOnAction(e -> {setYes(GENaPGQSt, "HCRaPGQrb1"); });
		HCRaPGQrb2.setOnAction(e -> {setNo(GENaPGQSt, "HCRaPGQrb2"); });
		
		HCRsDWTrb1.setOnAction(e -> {setYes(GENsDWTSt, "HCRsDWTrb1"); });
		HCRsDWTrb2.setOnAction(e -> {setNo(GENsDWTSt, "HCRsDWTrb2"); });
		
		HCRpLRrb1.setOnAction(e -> {setYes(GENpLRSt, "HCRpLRrb1"); });
		HCRpLRrb2.setOnAction(e -> {setNo(GENpLRSt, "HCRpLRrb2"); });
		
		HCRhSRrb1.setOnAction(e -> {setNew(GENhSRSt, "HCRhSRrb1"); });
		HCRhSRrb2.setOnAction(e -> {setUp(GENhSRSt, "HCRhSRrb2"); });
		
		HCRphotoTrb1.setOnAction(e -> {setYes(GENphotoTSt, "HCRphotoTrb1"); });
		HCRphotoTrb2.setOnAction(e -> {setNo(GENphotoTSt, "HCRphotoTrb2"); });
				
		HCRiScb.setOnAction(e -> {
			if (HCRiScb.isSelected() == true) {
				GENserviceInit = "YES";
			}
			else if (HCRiScb.isSelected() == false) {
				GENserviceInit = "NO";
			}
		});
		
		HCRrScb.setOnAction(e -> {
			if (HCRrScb.isSelected() == true) {
				GENserviceReg = "YES";
			}
			else if (HCRrScb.isSelected() == false) {
				GENserviceReg = "NO";
			}
		});
		
		HCRiNcb.setOnAction(e -> {
			if (HCRiNcb.isSelected() == true) {
				GENserviceInsp = "YES";
			}
			else if (HCRiNcb.isSelected() == false) {
				GENserviceInsp = "NO";
			}
		});
		
        // action event 
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e){ 
                // get the date picker value 
            	GENrepDate = HCRdateOSDP.getValue().getYear();
            } 
        };

        HCRdateOSDP.setOnAction(event);
	
        HCRserviceECB.setOnAction(e -> {
			if (HCRserviceECB.getValue() == "Annually") {
				GENexecDate = HCRdateOSDP.getValue().plusMonths(12);
			}
			else if (HCRserviceECB.getValue() == "Bi-Annually") {
				GENexecDate = HCRdateOSDP.getValue().plusMonths(6);
			}
			else if (HCRserviceECB.getValue() == "Quarterly") {
				GENexecDate = HCRdateOSDP.getValue().plusMonths(3);
			}
		});
		
        HCRtechtf.setOnAction(e -> {
			if (HCRtechtf.getValue() == "Scott") {
				GENendTech1 = "Scott Tong \n" + GENaddress1p + "\n" + GENaddress1c + GENaddress1z + "\n" + GENtech1p + "\n" + GENlicNumTech1;
			}
			else if (HCRtechtf.getValue() == "Dusten") {
				GENendTech1 = "Dusten Newby \n" + GENaddress2p + "\n" + GENaddress2c + GENaddress2z + "\n" + GENtech2p + "\n" + GENlicNumTech2;
				
			}
		});
		
        HCRinAccCB.setOnAction(e -> {
			if (HCRinAccCB.isSelected() == true) {
				GENinAccCBSt = "YES";
			}
			else if (HCRinAccCB.isSelected() == false) {
				GENinAccCBSt = "NO";
		}});		
		
        HCRkeyCB.setOnAction(e -> {
			if (HCRkeyCB.isSelected() == true) {
				GENkeyCBSt = "YES";
			}
			else if (HCRkeyCB.isSelected() == false) {
				GENkeyCBSt = "NO";
		}});
		
        HCRnoAvailCB.setOnAction(e -> {
			if (HCRnoAvailCB.isSelected() == true) {
				HCRcustSigntf.setText("No one available to sign                                                               Date: ");
			}
			else if (HCRnoAvailCB.isSelected() == false) {
				HCRcustSigntf.setText( "                                                                                                         Date: ");
		}});
		
		//send image of GUI to file.
        HCRbtPreView.setOnAction(e -> {
			String HCRcustadd1na = HCRtfcustName.getText().trim();
			String HCRcustadd1po = HCRtfcustAdr.getText().trim();
			String HCRcustadd1csz = HCRtfcustAdrCity.getText().trim() + ", " + HCRtfcustAdrState.getText().trim() + ", " +HCRtfcustAdrZip.getText().trim();
			String HCRcustadd1ph = HCRtfcustPhone.getText().trim();
			String HCRcustSignSt = HCRcustSigntf.getText();
			
			if (GENrepDate != 0000) {
				System.out.println(GENrepDate);
				GENrepDate = HCRdateOSDP.getValue().getYear();
			}
				
			StackPane HCRprintBtStage = new StackPane();
				
				Button HCRcancel = new Button("Close Preview");

				TextArea HCRprintTa = new TextArea();
				HCRprintTa.setMinHeight(height);
				HCRprintTa.setMinWidth(775);
				HCRprintTa.setEditable(false);
				
				TextArea HCRtechAddta = new TextArea();
				HCRtechAddta.setMaxHeight(125);
				HCRtechAddta.setMaxWidth(300);
				HCRtechAddta.setEditable(false);
				HCRtechAddta.setStyle("-fx-focus-color: transparent; -fx-text-box-border: transparent;");
				
				TextArea HCRcustAddta = new TextArea();
				HCRcustAddta.setMaxHeight(125);
				HCRcustAddta.setMaxWidth(300);
				HCRcustAddta.setEditable(false);
				HCRcustAddta.setStyle("-fx-focus-color: transparent; -fx-text-box-border: transparent;");
				
				TextArea HCRcleanNotice = new TextArea();
				HCRcleanNotice.setMinHeight(125);
				HCRcleanNotice.setMinWidth(450);
				HCRcleanNotice.setEditable(false);
				HCRcleanNotice.setStyle("-fx-highlight-fill: #7ecfff;"
									+"-fx-focus-color: transparent;"
									+"-fx-text-box-border: transparent;"
									+"-fx-font-size:10;"
								    +"-fx-background-insets: 0;"
								    +"-fx-background-color: transparent;"
								    +"-fx-padding: 10px;"
									);
				
				AnchorPane HCRprintStage = new AnchorPane(HCRprintTa,HCRreportLogo,HCRcleanNotice,HCRtechAddta,HCRcustAddta);

				AnchorPane.setTopAnchor(HCRreportLogo,10.0);
				AnchorPane.setLeftAnchor(HCRreportLogo,0.0);
				AnchorPane.setTopAnchor(HCRprintTa,0.0);
				AnchorPane.setLeftAnchor(HCRprintTa,0.0);
				AnchorPane.setTopAnchor(HCRtechAddta,10.0);
				AnchorPane.setLeftAnchor(HCRtechAddta,225.0);
				AnchorPane.setTopAnchor(HCRcustAddta,10.0);
				AnchorPane.setRightAnchor(HCRcustAddta,0.0);
				AnchorPane.setTopAnchor(HCRcleanNotice,110.0);
				AnchorPane.setRightAnchor(HCRcleanNotice,70.0);

				HCRtechAddta.appendText(GENendTech1);
				HCRcustAddta.appendText("Invoice Number: " + HCRtfInvoice.getText() + "\n" + HCRcustadd1na + "\n" + HCRcustadd1po + "\n" + HCRcustadd1csz + "\n" + HCRcustadd1ph);
				HCRcleanNotice.appendText("\nAll cleaning is in accordance with the local fire codes and/or NFPA Standard Code #96. This\n"
						+ "courtesy follow-up report is provided as a free customer service only; it is not a paid consul-\n"
						+ "tation. The inspection of the exhaust system is limited to the possible need for improved \n"
						+ "access and cleaning only. Other deficiencies, whether reported or not, are beyond the scope\nof"
						+ " our cleaning crew's knowledge. It is the owner of the exhaust system's responsibility to \ntake"
						+ " appropriate action to modify any deficiencies noted herein or elsewhere.\n");
				
				HCRprintTa.appendText("\n" + "\n" + "\n" + "\n" + "\n"+"\n" + "\n" + "\n"
				+ "    Service Scheduled with: " + HCRservSchTF.getText() + "\n"
				+ "    Store Closing Manager: " + HCRstoreCMTF.getText()+ "\n"
				+ "    Date of Service:\t\t" + HCRdateOSDP.getValue()+ "\n"
				+ "    Service Frequency:\t" + HCRserviceECB.getValue()+ "\n"
				+ "    Time of Service:\t\t" + HCRtimeOSTF.getText()+ "\n"
				+ "    Next Service Due:\t" + GENexecDate + "\n"
								+ "\t__________________________________________________________________________________________________________________________________________\n"
				+ "\n"				+ "\t\t\t\t\t\t\t\t\tKITCHEN EXHAUST HOOD CLEANING REPORT\n\n" 
				+ "\tType of Service completed "+"\t\t\t\t\t\t\t\t\tHood Location:  " + HCRmoreHoods2.getText()+ "\n\t\t\tInitial Service: " + GENserviceInit + "\n\t\t\tRegular Service: " + GENserviceReg + "\n\t\t\tInspection: " + GENserviceInsp + "\n\n"
				+ "\tCheck in: \t\t\t\t\t\t\t\t\t\t\t Check Out: " + "\n"
				+ "\t\t1. Key works: \t\t\t\t\t\t\t" + GENdkWSt + "\t\t\t" + "1. Fans working and left running:\t\t\t\t " + GENfWLRSt +"\n"
				+ "\t\t2. Fans working properly: \t\t\t\t" + GENdkWSt + "\t\t\t" + "2. Roof area near fan rinsed off:\t\t\t\t " + GENrANFROSt +"\n"
				+ "\t\t3. Defects in fan wiring: \t\t\t\t\t" + GENdIFSt + "\t\t\t" + "3. Hood interior wiped dry:\t\t\t\t\t " + GENhIWDSt +"\n"
				+ "\t\t4. Fans hinged: \t\t\t\t\t\t" + GENaFHSt + "\t\t\t" + "4. Kitchen floor clean/equipment wiped down:\t " + GENkFCEWDSt + "\n"
				+ "\t\t5. Floor drains working: \t\t\t\t\t" + GENfDWSt + "\t\t\t" + "5. Outside area rinsed and clean:\t\t\t\t " + GENoARCSt + "\n"
				+ "\t\t6. Hood lights working: \t\t\t\t\t" + GENhLWSt + "\t\t\t" + "6. Hood, stack, fan pressure washed:\t\t\t " + GENhSFPWSt + "\n"
				+ "\t\t7. Hood globes present: \t\t\t\t\t" + GENhGPSt + "\t\t\t" + "7. Any horizontal ductwork:\t\t\t\t\t " + GENaFHSt + "\n"
				+ "\t\t8. Rooftop grease containment system: \t\t" + GENrTCSSt + "\t\t\t" + "8. Any access panels:\t\t\t\t\t\t " + GENaPGQSt + "\n"
				+ "\t\t9. Grease buildup around roof fan: \t\t" + GENgBURFSt + "\t\t\t" + "9. Stack/ductwork water tight:\t\t\t\t\t " + GENsDWTSt + "\n"
				+ "\t\t10. Grease build up on fan blades: \t\t\t" + GENgBUFBSt + "\t\t\t" + "10. Pilot lights reignited:\t\t\t\t\t\t " + GENpLRSt + "\n"
				+ "\t\t11. Grease build up on stacks/ductwork: \t" + GENgBUSDSt + "\t\t\t" + "11. Photos taken:\t\t\t\t\t\t\t " + GENphotoTSt + "\n"
				+ "\t\t12. Grease build up on Hoods: \t\t\t" + GENgBUHSt + "\t\t\t" + "12. Hood sticker replaced:\t\t\t\t\t " + GENhSRSt + "\n"
				+ "\t\t13. Grease build up on filter: \t\t\t\t" + GENgBUFiSt + "\t\t\t" + "Inaccessible areas?:  " + GENinAccCBSt + "               Key available?:  " + GENkeyCBSt +"\n" + "\n"
				+ "\tNotes to Cleaning Technicians: "
				+ "\t" + HCRtaServ1.getText() + "\n"
				+ "\tMiscellaneous Notes: "
				+ HCRmiscNotTa.getText() + "\n\n"
				+ "\tService performed by:      " + HCRtechtf.getValue() + "\t\tDate Completed: " + HCRdateOSDP.getValue()	+ "                  Time In: " + HCRtfTI.getText()+ "                  Time Out: " + HCRtfTO.getText()+ "\n"
				+ "\t__________________________________________________________________________________________________________________________________________\n"

				+ "\tIN THE EVENT OF DEFAULT, TONG'S FIRE EXTINGUISHER SHALL BE ENTITLED TO RECOVER COST OF COLLECTION, INCLUDING\n\tREASONABLE ATTORNEY FEES. ACKNOWLEDGMENT OF KITCHEN CONDITION & KEC SERVICE COMPLETED. BY SIGNING BELOW \n\tTHE CUSTOMER ACKNOWLEDGES ALL SERVICE WAS COMPLETED AND THE KITCHEN WAS LEFT CLEAN AND IN SATISFACTORY \n\tCONDITION."
				+ "\n\tClaims of unsatisfactory workmanship must be made within 48 hours. Invoices are subject to an interest charge of the lesser of \n\t1.5% per month(18% per year) or the maximum rate allowed by law on any unpaid invoices outstanding after 30 days from date \n\tof service. The Customer herby waives thier rights of subrogation by thier insurance carrier against Tong's Fire Extinguisher \n\tunder any fire or liability insurance policy.\n"
				+ "\t__________________________________________________________________________________________________________________________________________\n"
				+ "\n\n\n\tCustomer Signature: " + HCRcustSignSt + "\n"
				+ "                                         --------------------------------------------------------------                        -------------------------"  
				
				);
				
				HBox HCRprintHBox = new HBox();
				
				HCRprintHBox.getChildren().addAll(HCRbtPrint,HCRcancel);
				
				HCRprintBtStage.getChildren().addAll(HCRprintHBox);

				Scene HCRprintScene = new Scene(HCRprintStage , width, height);
				Scene HCRprintBtScene = new Scene(HCRprintBtStage , 200, 50);
				
				Stage HCRprintWindow = new Stage();
				Stage HCRprintBtWindow = new Stage();
				
				HCRprintWindow.setTitle("HCRGen Report");
				HCRprintWindow.setScene(HCRprintScene);
				HCRprintWindow.setMinWidth(775);
				HCRprintWindow.setMaxWidth(775);
				
				HCRprintWindow.setX(0);
				HCRprintWindow.setY(0);
				
				HCRprintBtWindow.setTitle("Print/Cancel");
				HCRprintBtWindow.setScene(HCRprintBtScene);
				
				HCRprintBtWindow.setX(900);
				HCRprintBtWindow.setY(100);
				
				HCRprintWindow.show();
				HCRprintBtWindow.show();
				
				HCRcancel.setOnAction(ex -> {
					HCRprintWindow.close();	
					HCRprintBtWindow.close();	
				});
				
				HCRprintTa.setOnKeyPressed(ex -> {
					if (ex.getCode().equals(KeyCode.ENTER)) {
						String HCRPATH = "HCRGen/Reports/";
						String HCRdirName = HCRPATH.concat(HCRtfcustName.getText().trim());
						File HCRdirectory = new File(HCRdirName + "/" + GENrepDate + "/");
						
						if (! HCRdirectory.exists()) {
							HCRdirectory.mkdirs();
						}
						try (
							FileOutputStream HCRoos = new FileOutputStream(HCRdirectory +"/"+ HCRtfInvoice.getText().trim() + ".png", true);
							){
							captureScreen(HCRdirectory +"/"+ HCRtfInvoice.getText().trim() + ".png");
							System.out.println("Image saved to file!");
							HCRoos.close();
						} catch (Exception exe) {
							exe.printStackTrace();
						}
					}
					else if (ex.getCode().equals(KeyCode.ESCAPE)) {
						HCRprintWindow.close();	
						HCRprintBtWindow.close();
					}	
	
				});
		});
		
        HCRbtPrint.setOnAction(e -> {
			String HCRPATH = "HCRGen/Reports/";
			String HCRdirName = HCRPATH.concat(HCRtfcustName.getText().trim());
			File HCRdirectory = new File(HCRdirName + "/" + GENrepDate + "/");
			
			if (! HCRdirectory.exists()) {
				HCRdirectory.mkdirs();
			}
			try (
				FileOutputStream HCRoos = new FileOutputStream(HCRdirectory +"/"+ HCRtfInvoice.getText()+ ".png", true);
				){
				captureScreen(HCRdirectory +"/"+  HCRtfInvoice.getText()+ ".png");
				System.out.println("Image saved to file!");
				HCRoos.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
        HCRbtBack.setOnAction(e -> {
        	try {start(primaryStage);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
		}});
        
        HCRmainVB.getChildren().addAll(HCRhb1, HCRhb2, HCRvb2, HCRvb3, HCRhb5, HCRhb6, HCRhb7);
		
		Scene HCRscene = new Scene(HCRsp , width, height);
		
		primaryStage.setTitle("HCRGen");
		primaryStage.setX(0);
		primaryStage.setY(0);
		primaryStage.setScene(HCRscene);
		primaryStage.setMinWidth(775);
		primaryStage.setMaxWidth(775);
		primaryStage.show();
	}
	
	/** 
	 * Restaurant Fire Suppression Systems Report Window RFSSR 
	 */
	public void startRFSSR(Stage primaryStage) throws FileNotFoundException{
						
		//Create a main page VBox and set its attributes
		ScrollPane RFSSRsp = new ScrollPane();
		VBox RFSSRmainVB = new VBox();
		VBox.setVgrow(RFSSRsp, Priority.ALWAYS);
		RFSSRsp.setContent(RFSSRmainVB);
	
		RFSSRmainVB.setMinSize(400, 450);
		RFSSRmainVB.setPadding(new Insets(10,10,10,10));
		RFSSRmainVB.setAlignment(Pos.TOP_CENTER);
		
		//Create the main page HBoxs, and set their attributes
		HBox RFSSRhb1 = new HBox();
		RFSSRhb1.setAlignment(Pos.TOP_CENTER);
		RFSSRhb1.setPadding(new Insets(10,10,10,10));
		RFSSRhb1.setSpacing(10);
		
		HBox RFSSRhb2 = new HBox();
		RFSSRhb2.setAlignment(Pos.TOP_LEFT);
		RFSSRhb2.setPadding(new Insets(10,10,10,10));
		RFSSRhb2.setSpacing(10);
		
		HBox RFSSRhb3 = new HBox();
		RFSSRhb3.setAlignment(Pos.TOP_LEFT);
		RFSSRhb3.setPadding(new Insets(10,10,10,10));
		RFSSRhb3.setSpacing(10);
		
		HBox RFSSRhb4 = new HBox();
		RFSSRhb4.setAlignment(Pos.TOP_LEFT);
		RFSSRhb4.setPadding(new Insets(10,10,10,10));
		RFSSRhb4.setSpacing(10);
		
		HBox RFSSRhb5 = new HBox();
		RFSSRhb5.setAlignment(Pos.TOP_CENTER);
		RFSSRhb5.setPadding(new Insets(10,10,10,10));
		RFSSRhb5.setSpacing(10);
		
		HBox RFSSRhb6 = new HBox();
		RFSSRhb6.setAlignment(Pos.TOP_LEFT);
		RFSSRhb6.setPadding(new Insets(10,10,10,10));
		RFSSRhb6.setSpacing(10);
		
		HBox RFSSRhb7 = new HBox();
		RFSSRhb7.setAlignment(Pos.TOP_LEFT);
		RFSSRhb7.setPadding(new Insets(10,10,10,10));
		RFSSRhb7.setSpacing(10);
		
		HBox RFSSRhb8 = new HBox();
		RFSSRhb8.setAlignment(Pos.TOP_LEFT);
		RFSSRhb8.setPadding(new Insets(10,10,10,10));
		RFSSRhb8.setSpacing(10);
		
		HBox RFSSRhb9 = new HBox();
		RFSSRhb9.setAlignment(Pos.TOP_LEFT);
		RFSSRhb9.setPadding(new Insets(10,10,10,10));
		RFSSRhb9.setSpacing(10);
		
		HBox RFSSRhb10 = new HBox();
		RFSSRhb10.setAlignment(Pos.TOP_LEFT);
		RFSSRhb10.setPadding(new Insets(10,10,10,10));
		RFSSRhb10.setSpacing(10);
		
		HBox RFSSRhb11 = new HBox();
		RFSSRhb11.setAlignment(Pos.TOP_LEFT);
		RFSSRhb11.setPadding(new Insets(10,10,10,10));
		RFSSRhb11.setSpacing(10);
		
		HBox RFSSRhb12 = new HBox();
		RFSSRhb12.setAlignment(Pos.TOP_LEFT);
		RFSSRhb12.setPadding(new Insets(10,10,10,10));
		RFSSRhb12.setSpacing(10);
		
		VBox RFSSRvb1 = new VBox();
		RFSSRvb1.setAlignment(Pos.BOTTOM_LEFT);
		RFSSRvb1.setMinWidth(100);
		
		VBox RFSSRvb2 = new VBox();
		RFSSRvb2.setAlignment(Pos.BOTTOM_LEFT);
		RFSSRvb2.setMinWidth(100);
		
		VBox RFSSRvb3 = new VBox();
		RFSSRvb3.setAlignment(Pos.TOP_CENTER);
		RFSSRvb3.setMinWidth(100);
		
		VBox RFSSRvb4 = new VBox();
		RFSSRvb4.setAlignment(Pos.TOP_LEFT);
		RFSSRvb4.setMinWidth(100);
		
		VBox RFSSRvb5 = new VBox();
		RFSSRvb5.setAlignment(Pos.TOP_LEFT);
		RFSSRvb5.setMinWidth(100);
		
		
		/*
		Items that go in RFSSRhb1 go here
			~ ImageView of logo
			~ Business Info
			~ Invoice box
		*/
			//create GridPane for the logo, business information and invoice Box
			GridPane RFSSRheadPane = new GridPane();
			RFSSRheadPane.setMinSize(200, 100);
			RFSSRheadPane.setPadding(new Insets(10,10,10,10));
			RFSSRheadPane.setVgap(50);
			RFSSRheadPane.setHgap(60);
			RFSSRheadPane.setAlignment(Pos.TOP_LEFT);
			RFSSRheadPane.setGridLinesVisible(false);
			
			//create ImageView for logo and place in the grid
			File RFSSRf = new File("TONGS-FIRE-EXTINGUISHER-SALES-AND-SERVICE.jpg");
			String RFSSRfilLoc = RFSSRf.getAbsolutePath();
			
			//Creating a Label
			Label RFSSRlogo = new Label();
			Label RFSSRreportLogo = new Label();
			
			//Creating a graphic
			Image RFSSRimg = new Image(new FileInputStream(RFSSRfilLoc));
			ImageView RFSSRview = new ImageView(RFSSRimg);
			RFSSRview.setFitHeight(125);
			RFSSRview.setFitWidth(225);
			RFSSRview.setPreserveRatio(false);
			ImageView RFSSRview2 = new ImageView(RFSSRimg);
			RFSSRview2.setFitHeight(125);
			RFSSRview2.setFitWidth(225);
			RFSSRview2.setPreserveRatio(false);
			
			RFSSRlogo.setGraphic(RFSSRview);
			RFSSRreportLogo.setGraphic(RFSSRview2);
	
			//create address box labels for Tong's Fire Extinguisher Sales and Service
			Label RFSSRtongAdr1 = new Label(GENaddress1);
			Label RFSSRtongAdr2 = new Label(GENaddress2);
			Label RFSSRtongPhone = new Label(GENphoneNum);
			Label RFSSRtongLicNum1 = new Label(GENlicNumTech1);
			Label RFSSRtongLicNum2 = new Label(GENlicNumTech2);
			
			//Create Address VBox for Tong's Fire Extinguisher Sales and Service information
			RFSSRvb1.getChildren().addAll(RFSSRtongAdr1, RFSSRtongAdr2, RFSSRtongPhone, RFSSRtongLicNum1, RFSSRtongLicNum2);
			
			//Create Invoice HBox and place it in the pane
			VBox RFSSRinvVBox = new VBox();
			RFSSRinvVBox.setAlignment(Pos.TOP_LEFT);
			
			Label RFSSRinvRefNum = new Label(" Invoice Reference #");
			TextField RFSSRtfInvoice = new TextField("####");
			RFSSRtfInvoice.setFont(new Font("Cambria", 10));
			RFSSRinvVBox.getChildren().addAll(RFSSRinvRefNum, RFSSRtfInvoice);
			
			//place boxes in the top pane
			RFSSRheadPane.add(RFSSRlogo, 0,0);		
			RFSSRheadPane.add(RFSSRvb1, 1,0);
			RFSSRheadPane.add(RFSSRinvVBox, 2,0);
			
			//add completed headPane to RFSSRhb1
			RFSSRhb1.getChildren().addAll(RFSSRheadPane);
			
		/*
		Items that go in RFSSRhb2 and go here
			~ Service Info Box
			~ Customer Info Box
		*/
			//Create Service Schedule Information box
			Label RFSSRservSchLabel = new Label(" Service Scheduled with: ");
			Label RFSSRstoreCMLabel = new Label(" Store Closing Manager: ");
			Label RFSSRdateOSLabel = new Label(" Date of Service: ");
			Label RFSSRtimeOSLabel = new Label(" Time of Service: ");
			Label RFSSRselOneL = new Label(" Service Type: ");
	
			TextField RFSSRservSchTF = new TextField(((CusOb) map.get(CUSTOBJFOCUS)).getSSw());
			RFSSRservSchTF.setMinWidth(205);
			RFSSRservSchTF.setFont(new Font("Cambria", 10));
			TextField RFSSRstoreCMTF = new TextField(((CusOb) map.get(CUSTOBJFOCUS)).getSCM());
			RFSSRstoreCMTF.setFont(new Font("Cambria", 10));
			RFSSRstoreCMTF.setMaxWidth(275);
			DatePicker RFSSRdateOSDP = new DatePicker();
			
			ComboBox<String> RFSSRselOneCB = new ComboBox<String>();
			//RFSSRselOneCB.setValue(((CusOb) map.get(CUSTOBJFOCUS)).getSF());
			RFSSRselOneCB.getItems().addAll("Semi-Annual", "Recharge", "Installation", "Renovation");
			
			TextField RFSSRtimeOSTF = new TextField("00:00");
			RFSSRtimeOSTF.setFont(new Font("Cambria", 10));
			RFSSRtimeOSTF.setMaxWidth(75);
			
			GridPane RFSSRservGrid = new GridPane();
			RFSSRservGrid.setMinSize(400, 100);
			RFSSRservGrid.setAlignment(Pos.TOP_LEFT);
			
			RFSSRservGrid.add(RFSSRservSchLabel,0,0);
			RFSSRservGrid.add(RFSSRservSchTF,1,0);
			RFSSRservGrid.add(RFSSRstoreCMLabel,0,1);
			RFSSRservGrid.add(RFSSRstoreCMTF,1,1);
			RFSSRservGrid.add(RFSSRdateOSLabel,0,2);
			RFSSRservGrid.add(RFSSRdateOSDP,1,2);
			RFSSRservGrid.add(RFSSRtimeOSLabel,0,3);
			RFSSRservGrid.add(RFSSRtimeOSTF,1,3);
			RFSSRservGrid.add(RFSSRselOneL,0,4);
			RFSSRservGrid.add(RFSSRselOneCB,1,4);
			
			//Create Second row of boxes for Customer information and place them on the grid
			Label RFSSRcustPhoneLabel = new Label(" Phone: ");
			Label RFSSRcustNameLabel = new Label(" Client: ");
			Label RFSSRcustAdrLabel = new Label(" Address: ");
			Label RFSSRcustAdrCityLabel = new Label(" City: ");
			Label RFSSRcustAdrStateLabel = new Label(" State: ");
			Label RFSSRcustAdrZipLabel = new Label(" Zip: ");
			
			TextField RFSSRtfcustPhone = new TextField(((CusOb) map.get(CUSTOBJFOCUS)).getPhone());
			RFSSRtfcustPhone.setFont(new Font("Cambria", 10));
			RFSSRtfcustPhone.setMaxWidth(115);
			TextField RFSSRtfcustName = new TextField(((CusOb) map.get(CUSTOBJFOCUS)).getClient());
			RFSSRtfcustName.setFont(new Font("Cambria", 10));
			RFSSRtfcustName.setMinWidth(205);
			TextField RFSSRtfcustAdr = new TextField(((CusOb) map.get(CUSTOBJFOCUS)).getAddress());
			RFSSRtfcustAdr.setFont(new Font("Cambria", 10));
			RFSSRtfcustAdr.setMaxWidth(275);
			TextField RFSSRtfcustAdrCity = new TextField(((CusOb) map.get(CUSTOBJFOCUS)).getCity());
			RFSSRtfcustAdrCity.setFont(new Font("Cambria", 10));
			RFSSRtfcustAdrCity.setMaxWidth(115);
			TextField RFSSRtfcustAdrState = new TextField(((CusOb) map.get(CUSTOBJFOCUS)).getState());
			RFSSRtfcustAdrState.setFont(new Font("Cambria", 10));
			RFSSRtfcustAdrState.setMaxWidth(115);
			TextField RFSSRtfcustAdrZip = new TextField(((CusOb) map.get(CUSTOBJFOCUS)).getZip());
			RFSSRtfcustAdrZip.setFont(new Font("Cambria", 10));
			RFSSRtfcustAdrZip.setMaxWidth(115);
			
			GridPane RFSSRcustGrid = new GridPane();
			RFSSRcustGrid.add(RFSSRcustNameLabel,0,0);
			RFSSRcustGrid.add(RFSSRtfcustName,1,0);
			
			RFSSRcustGrid.add(RFSSRcustAdrLabel,0,1);
			RFSSRcustGrid.add(RFSSRtfcustAdr,1,1);
			
			RFSSRcustGrid.add(RFSSRcustAdrCityLabel,0,2);
			RFSSRcustGrid.add(RFSSRtfcustAdrCity,1,2);
			
			RFSSRcustGrid.add(RFSSRcustAdrStateLabel,0,3);
			RFSSRcustGrid.add(RFSSRtfcustAdrState,1,3);
			
			RFSSRcustGrid.add(RFSSRcustAdrZipLabel,0,4);
			RFSSRcustGrid.add(RFSSRtfcustAdrZip,1,4);
			
			RFSSRcustGrid.add(RFSSRcustPhoneLabel,0,5);
			RFSSRcustGrid.add(RFSSRtfcustPhone,1,5);
			
			RFSSRhb2.getChildren().addAll(RFSSRservGrid, RFSSRcustGrid);
			
			/*
			 * RFSSRhb3 Items go here
			 * Service Type and Basic Service information
			 * 
			 */
			GridPane RFSSRSiGrid = new GridPane();
			RFSSRSiGrid.setAlignment(Pos.TOP_LEFT);
			
			VBox RFSSRvb6 = new VBox();
			
			Label RFSSRGasL = new Label("Gas/");
			RFSSRGasL.setFont(new Font("Cambria", 10));
			Label RFSSRElecL = new Label("Elect");
			RFSSRElecL.setFont(new Font("Cambria", 10));
			Label RFSSREoGLabel = new Label("Shut off");
			Label RFSSRlocLabel = new Label("Location of cylinders: ");
			Label RFSSRmanLabel = new Label("Manufacturer: ");
			Label RFSSRmodLabel = new Label("Model: ");
			Label RFSSRWDLabel1 = new Label("Wet/");
			RFSSRWDLabel1.setFont(new Font("Cambria", 10));
			Label RFSSRWDLabel2= new Label("Dry");
			RFSSRWDLabel2.setFont(new Font("Cambria", 10));
			Label RFSSRWoDLabel= new Label("Wet Dry ");
			Label RFSSRCSLabel = new Label("Cylinder size: ");
			Label RFSSRCSSLabelM = new Label("Master");
			RFSSRCSSLabelM.setFont(new Font("Cambria", 10));
			Label RFSSRCSSLabelS = new Label("Slave");
			RFSSRCSSLabelS.setFont(new Font("Cambria", 10));
			Label RFSSRfl360Label = new Label("Fuse  Links 360: ");
			Label RFSSRfl450Label = new Label("Fuse  Links 450: ");
			Label RFSSRfl500Label = new Label("Fuse  Links 500: ");
			Label RFSSRLRDLabel = new Label("Last recharge");
			Label RFSSRNRDLabel = new Label("Next recharge");
			Label RFSSRLHTDLabel = new Label("Last hydro test");
			Label RFSSRNHTDLabel = new Label("Next hydro test");
			Label RFSSRCALLabel = new Label("Appliance location");
			
			ComboBox<String> RFSSRmanCB = new ComboBox<String>();
			RFSSRmanCB.getItems().addAll("Amerex", "Ansul", "PyroChem", "Range Guard");
			ComboBox<String> RFSSRmodCB = new ComboBox<String>();
			RFSSRmodCB.getItems().addAll("KP275", "KP375","KP475");
			ComboBox<String> RFSSRCSMCB = new ComboBox<String>();
			RFSSRCSMCB.getItems().addAll("1.5","1.6","2.5","2.75","3","3.75","4","4.6","4.75","6");
			ComboBox<String> RFSSRCSSMCB = new ComboBox<String>();
			RFSSRCSSMCB.getItems().addAll("1.5","1.6","2.5","2.75","3","3.75","4","4.6","4.75","6");
			ComboBox<String> RFSSRfl360CB = new ComboBox<String>();
			RFSSRfl360CB.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12");
			ComboBox<String> RFSSRfl450CB = new ComboBox<String>();
			RFSSRfl450CB.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12");
			ComboBox<String> RFSSRfl500CB = new ComboBox<String>();
			RFSSRfl500CB.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12");
			
			DatePicker RFSSRLRDDP = new DatePicker();
			DatePicker RFSSRLHTDDP = new DatePicker();
			DatePicker RFSSRNRDDP = new DatePicker();

			TextField RFSSRlocTF = new TextField("locTF");
			TextField RFSSRNHTDDP = new TextField("NHTDDP");
			TextField RFSSRCALTF = new TextField("CALTF");
			
			RadioButton RFSSRWDrb1 = new RadioButton("Wet");
			RadioButton RFSSRWDrb2 = new RadioButton("Dry");
			RadioButton RFSSREoGrb1 = new RadioButton("Gas");
			RadioButton RFSSREoGrb2 = new RadioButton("Elect");
			
			RFSSRSiGrid.add(RFSSRCALLabel,		0,0);
			RFSSRSiGrid.add(RFSSRlocLabel,		0,1);
			RFSSRSiGrid.add(RFSSRLRDLabel,		0,2);
			RFSSRSiGrid.add(RFSSRNRDLabel,		0,3);
			RFSSRSiGrid.add(RFSSRLHTDLabel,		0,4);
			RFSSRSiGrid.add(RFSSRNHTDLabel,		0,5);	
			RFSSRSiGrid.add(RFSSRmanLabel,		0,6);
			RFSSRSiGrid.add(RFSSRmodLabel,		0,7);
			
			RFSSRSiGrid.add(RFSSRCALTF,			1,0);
			RFSSRSiGrid.add(RFSSRlocTF,			1,1);	
			RFSSRSiGrid.add(RFSSRLRDDP,			1,2);
			RFSSRSiGrid.add(RFSSRNRDDP,			1,3);
			RFSSRSiGrid.add(RFSSRLHTDDP,		1,4);
			RFSSRSiGrid.add(RFSSRNHTDDP,		1,5);
			RFSSRSiGrid.add(RFSSRmanCB,			1,6);
			RFSSRSiGrid.add(RFSSRmodCB,			1,7);
			
			GridPane RFSSRservInfoGrid = new GridPane();
			//RFSSRservInfoGrid.setMinSize(400, 100);
			
			RFSSRservInfoGrid.add(RFSSRCSLabel,			0,1);
			RFSSRservInfoGrid.add(RFSSRWoDLabel,		0,2);
			RFSSRservInfoGrid.add(RFSSREoGLabel,		0,3);
			RFSSRservInfoGrid.add(RFSSRfl360Label,		0,4);
			RFSSRservInfoGrid.add(RFSSRfl450Label,		0,5);
			RFSSRservInfoGrid.add(RFSSRfl500Label,		0,6);
			
			RFSSRservInfoGrid.add(RFSSRWDrb1,			1,2);
			RFSSRservInfoGrid.add(RFSSRWDrb2,			2,2);
			
			RFSSRservInfoGrid.add(RFSSRCSSLabelM,		1,0);
			RFSSRservInfoGrid.add(RFSSRCSSLabelS,		2,0);
			
			RFSSRservInfoGrid.add(RFSSREoGrb1,			1,3);
			RFSSRservInfoGrid.add(RFSSREoGrb2,			2,3);
			
			RFSSRservInfoGrid.add(RFSSRfl360CB,			1,4);
			RFSSRservInfoGrid.add(RFSSRfl450CB,			1,5);
			RFSSRservInfoGrid.add(RFSSRfl500CB,			1,6);
			
			
			RFSSRservInfoGrid.add(RFSSRCSMCB,			1,1);
			RFSSRservInfoGrid.add(RFSSRCSSMCB,			2,1);
			
			Label RFSSRtILabel = new Label("TIME IN: ");
			Label RFSSRtOLabel = new Label("TIME OUT: ");
			
			TextField RFSSRtfTI = new TextField("00:00");
			RFSSRtfTI.setFont(new Font("Cambria", 10));
			RFSSRtfTI.setMaxWidth(80);
			TextField RFSSRtfTO = new TextField("00:00");
			RFSSRtfTO.setFont(new Font("Cambria", 10));
			RFSSRtfTO.setMaxWidth(80);
			
			Label RFSSRmiscNotLabel = new Label("Comments and Deficiencies: ");
			
			TextArea RFSSRmiscNotTa = new TextArea("None");
			RFSSRmiscNotTa.setWrapText(true);
			RFSSRmiscNotTa.setFont(new Font("Cambria", 10));
			RFSSRmiscNotTa.setWrapText(true);
			RFSSRmiscNotTa.setMaxWidth(375);
			
			RFSSRhb6.getChildren().addAll(RFSSRtILabel, RFSSRtfTI, RFSSRtOLabel, RFSSRtfTO);
			
			VBox RFFSRvb7 = new VBox();
			
			GridPane RFSSRrbGrid = new GridPane();
			//RFSSRrbGrid.setMinSize(400, 100);
			RFSSRrbGrid.setAlignment(Pos.TOP_LEFT);
			
			Label RFSSRlabelYes = new Label("Yes");
			Label RFSSRlabelNo = new Label("No");
			
			Label RFSSRlabel1 = new Label(" 1. All appliances covered with correct nozzles ");
			Label RFSSRlabel2 = new Label(" 2. Duct and plenum covered with correct nozzles ");
			Label RFSSRlabel3 = new Label(" 3. Positioning of all nozzles checked ");
			Label RFSSRlabel4 = new Label(" 4. System installed in accordance with MFG UL listing ");
			Label RFSSRlabel5 = new Label(" 5. Hood duct penetrations sealed with weld or UL device ");
			Label RFSSRlabel6 = new Label(" 6. Seal intact and free of tampering ");
			Label RFSSRlabel7 = new Label(" 7. System fully charged, free from discharge ");
			Label RFSSRlabel8 = new Label(" 8. Pressure gauge in proper range ");
			Label RFSSRlabel9 = new Label(" 9. Check cartridge weight if applicable ");
			Label RFSSRlabel10 = new Label("10. Inspect cylinder mount ");
			Label RFSSRlabel11 = new Label("11. Operate system from Terminal Link ");
			Label RFSSRlabel12 = new Label("12. Test for proper operation from remote pull station ");
			Label RFSSRlabel13 = new Label("13. Check operation from gas valve");
			Label RFSSRlabel14 = new Label("14. Clean nozzles ");
			Label RFSSRlabel15 = new Label("15. Proper separation between fryers and flames");
			Label RFSSRlabel16 = new Label("16. Replace fuse links");
			Label RFSSRlabel17 = new Label("17. Check travel of cable nuts s-hooks ");
			Label RFSSRlabel18 = new Label("18. Piping and conduit securely bracketed ");
			Label RFSSRlabel19 = new Label("19. Proper clearance flame to filters min. 28inch ");	
			Label RFSSRlabel20 = new Label("20. Exhaust fan in operating order ");
			Label RFSSRlabel21 = new Label("21. All hood filters in place ");
			Label RFSSRlabel22 = new Label("22. Fuel shutoff in \"on\" position ");
			Label RFSSRlabel23 = new Label("23. Manual and remote set seals in place ");
			Label RFSSRlabel24 = new Label("24. System cover replaced ");
			Label RFSSRlabel25 = new Label("25. System operation and seals in place ");
			Label RFSSRlabel26 = new Label("26. Slave system operational ");
			Label RFSSRlabel27 = new Label("27. Fan warning sign on hood ");
			Label RFSSRlabel28 = new Label("28. Personnel instructed in manual operation of system ");
			Label RFSSRlabel29 = new Label("29. Proper hand portable extinguishers ");	
			Label RFSSRlabel30 = new Label("30. Portable extinguishers properly serviced ");
			Label RFSSRlabel31 = new Label("31. Service and certification tag on system ");
	
			//add labels to RFSSRrbGrid
			RFSSRrbGrid.add(RFSSRlabelYes,      1,0);
			RFSSRrbGrid.add(RFSSRlabelNo,  	    2,0);

			RFSSRrbGrid.add(RFSSRlabel1,		0,1);
			RFSSRrbGrid.add(RFSSRlabel2,	 	0,2);	
			RFSSRrbGrid.add(RFSSRlabel3,		0,3);
			RFSSRrbGrid.add(RFSSRlabel4,	 	0,4);
			RFSSRrbGrid.add(RFSSRlabel5,		0,5);
			RFSSRrbGrid.add(RFSSRlabel6,	 	0,6);
			RFSSRrbGrid.add(RFSSRlabel7,		0,7);
			RFSSRrbGrid.add(RFSSRlabel8,	 	0,8);
			RFSSRrbGrid.add(RFSSRlabel9,		0,9);
			RFSSRrbGrid.add(RFSSRlabel10,	 	0,10);
			RFSSRrbGrid.add(RFSSRlabel11,		0,11);
			RFSSRrbGrid.add(RFSSRlabel12,	 	0,12);	
			RFSSRrbGrid.add(RFSSRlabel13,		0,13);
			RFSSRrbGrid.add(RFSSRlabel14,	 	0,14);
			RFSSRrbGrid.add(RFSSRlabel15,		0,15);
			RFSSRrbGrid.add(RFSSRlabel16,	 	0,16);
			RFSSRrbGrid.add(RFSSRlabel17,		0,17);
			RFSSRrbGrid.add(RFSSRlabel18,	 	0,18);
			RFSSRrbGrid.add(RFSSRlabel19,		0,19);
			RFSSRrbGrid.add(RFSSRlabel20,	 	0,20);
			RFSSRrbGrid.add(RFSSRlabel21,		0,21);
			RFSSRrbGrid.add(RFSSRlabel22,	 	0,22);	
			RFSSRrbGrid.add(RFSSRlabel23,		0,23);
			RFSSRrbGrid.add(RFSSRlabel24,	 	0,24);
			RFSSRrbGrid.add(RFSSRlabel25,		0,25);
			RFSSRrbGrid.add(RFSSRlabel26,	 	0,26);
			RFSSRrbGrid.add(RFSSRlabel27,		0,27);
			RFSSRrbGrid.add(RFSSRlabel28,	 	0,28);
			RFSSRrbGrid.add(RFSSRlabel29,		0,29);
			RFSSRrbGrid.add(RFSSRlabel30,	 	0,30);
			RFSSRrbGrid.add(RFSSRlabel31,		0,31);
			
			ToggleGroup RFSSRlabel1TG = new ToggleGroup();
			RadioButton RFSSRrb1 = new RadioButton( );
				RFSSRrb1.setToggleGroup(RFSSRlabel1TG);
			RadioButton RFSSRrb1N = new RadioButton( );
				RFSSRrb1N.setToggleGroup(RFSSRlabel1TG);
			
			ToggleGroup RFSSRlabel2TG = new ToggleGroup();
			RadioButton RFSSRrb2 = new RadioButton( );
				RFSSRrb2.setToggleGroup(RFSSRlabel2TG);
			RadioButton RFSSRrb2N = new RadioButton( );
				RFSSRrb2N.setToggleGroup(RFSSRlabel2TG);
			
			ToggleGroup RFSSRlabel3TG = new ToggleGroup();
			RadioButton RFSSRrb3 = new RadioButton( );
				RFSSRrb3.setToggleGroup(RFSSRlabel3TG);
			RadioButton RFSSRrb3N = new RadioButton( );
				RFSSRrb3N.setToggleGroup(RFSSRlabel3TG);
			
			ToggleGroup RFSSRlabel4TG = new ToggleGroup();
			RadioButton RFSSRrb4 = new RadioButton( );
				RFSSRrb4.setToggleGroup(RFSSRlabel4TG);
			RadioButton RFSSRrb4N = new RadioButton( );
				RFSSRrb4N.setToggleGroup(RFSSRlabel4TG);
			
			ToggleGroup RFSSRlabel5TG = new ToggleGroup();
			RadioButton RFSSRrb5 = new RadioButton( );
				RFSSRrb5.setToggleGroup(RFSSRlabel5TG);
			RadioButton RFSSRrb5N = new RadioButton( );
				RFSSRrb5N.setToggleGroup(RFSSRlabel5TG);
			
			ToggleGroup RFSSRlabel6TG = new ToggleGroup();
			RadioButton RFSSRrb6 = new RadioButton( );
				RFSSRrb6.setToggleGroup(RFSSRlabel6TG);
			RadioButton RFSSRrb6N = new RadioButton( );
				RFSSRrb6N.setToggleGroup(RFSSRlabel6TG);
			
			ToggleGroup RFSSRlabel7TG = new ToggleGroup();
			RadioButton RFSSRrb7 = new RadioButton( );
				RFSSRrb7.setToggleGroup(RFSSRlabel7TG);
			RadioButton RFSSRrb7N = new RadioButton( );
				RFSSRrb7N.setToggleGroup(RFSSRlabel7TG);
			
			ToggleGroup RFSSRlabel8TG = new ToggleGroup();
			RadioButton RFSSRrb8 = new RadioButton( );
				RFSSRrb8.setToggleGroup(RFSSRlabel8TG);
			RadioButton RFSSRrb8N = new RadioButton( );
				RFSSRrb8N.setToggleGroup(RFSSRlabel8TG);
			
			ToggleGroup RFSSRlabel9TG = new ToggleGroup();
			RadioButton RFSSRrb9 = new RadioButton( );
				RFSSRrb9 .setToggleGroup(RFSSRlabel9TG);
			RadioButton RFSSRrb9N = new RadioButton( );
			RFSSRrb9N .setToggleGroup(RFSSRlabel9TG);
			
			ToggleGroup RFSSRlabel10TG = new ToggleGroup();
			RadioButton RFSSRrb10 = new RadioButton( );
			RFSSRrb10.setToggleGroup(RFSSRlabel10TG);
			RadioButton RFSSRrb10N = new RadioButton( );
			RFSSRrb10N.setToggleGroup(RFSSRlabel10TG);
			
			ToggleGroup RFSSRlabel11TG = new ToggleGroup();
			RadioButton RFSSRrb11 = new RadioButton( );
			RFSSRrb11.setToggleGroup(RFSSRlabel11TG);
			RadioButton RFSSRrb11N = new RadioButton( );
			RFSSRrb11N.setToggleGroup(RFSSRlabel11TG);
			
			ToggleGroup RFSSRlabel12TG = new ToggleGroup();
			RadioButton RFSSRrb12 = new RadioButton( );
			RFSSRrb12.setToggleGroup(RFSSRlabel12TG);
			RadioButton RFSSRrb12N = new RadioButton( );
			RFSSRrb12N.setToggleGroup(RFSSRlabel12TG);
			
			ToggleGroup RFSSRlabel13TG = new ToggleGroup();
			RadioButton RFSSRrb13 = new RadioButton( );
			RFSSRrb13.setToggleGroup(RFSSRlabel13TG);
			RadioButton RFSSRrb13N = new RadioButton( );
			RFSSRrb13N.setToggleGroup(RFSSRlabel13TG);
			
			ToggleGroup RFSSRlabel14TG = new ToggleGroup();
			RadioButton RFSSRrb14 = new RadioButton( );
			RFSSRrb14.setToggleGroup(RFSSRlabel14TG);
			RadioButton RFSSRrb14N = new RadioButton( );
			RFSSRrb14N.setToggleGroup(RFSSRlabel14TG);
			
			ToggleGroup RFSSRlabel15TG = new ToggleGroup();
			RadioButton RFSSRrb15 = new RadioButton( );
			RFSSRrb15.setToggleGroup(RFSSRlabel15TG);
			RadioButton RFSSRrb15N = new RadioButton( );
			RFSSRrb15N.setToggleGroup(RFSSRlabel15TG);
			
			ToggleGroup RFSSRlabel16TG = new ToggleGroup();
			RadioButton RFSSRrb16 = new RadioButton( );
			RFSSRrb16.setToggleGroup(RFSSRlabel16TG);
			RadioButton RFSSRrb16N = new RadioButton( );
			RFSSRrb16N.setToggleGroup(RFSSRlabel16TG);
			
			ToggleGroup RFSSRlabel17TG = new ToggleGroup();
			RadioButton RFSSRrb17 = new RadioButton( );
			RFSSRrb17.setToggleGroup(RFSSRlabel17TG);
			RadioButton RFSSRrb17N = new RadioButton( );
			RFSSRrb17N.setToggleGroup(RFSSRlabel17TG);
			
			ToggleGroup RFSSRlabel18TG = new ToggleGroup();
			RadioButton RFSSRrb18 = new RadioButton( );
			RFSSRrb18.setToggleGroup(RFSSRlabel18TG);
			RadioButton RFSSRrb18N = new RadioButton( );
			RFSSRrb18N.setToggleGroup(RFSSRlabel18TG);
			
			ToggleGroup RFSSRlabel19TG = new ToggleGroup();
			RadioButton RFSSRrb19 = new RadioButton( );
			RFSSRrb19.setToggleGroup(RFSSRlabel19TG);
			RadioButton RFSSRrb19N = new RadioButton( );
			RFSSRrb19N.setToggleGroup(RFSSRlabel19TG);
			
			ToggleGroup RFSSRlabel20TG = new ToggleGroup();
			RadioButton RFSSRrb20 = new RadioButton( );
			RFSSRrb20.setToggleGroup(RFSSRlabel20TG);
			RadioButton RFSSRrb20N = new RadioButton( );
			RFSSRrb20N.setToggleGroup(RFSSRlabel20TG);
			
			ToggleGroup RFSSRlabel21TG = new ToggleGroup();
			RadioButton RFSSRrb21 = new RadioButton( );
			RFSSRrb21.setToggleGroup(RFSSRlabel21TG);
			RadioButton RFSSRrb21N = new RadioButton( );
			RFSSRrb21N.setToggleGroup(RFSSRlabel21TG);
			
			ToggleGroup RFSSRlabel22TG = new ToggleGroup();
			RadioButton RFSSRrb22 = new RadioButton( );
			RFSSRrb22.setToggleGroup(RFSSRlabel22TG);
			RadioButton RFSSRrb22N = new RadioButton( );
			RFSSRrb22N.setToggleGroup(RFSSRlabel22TG);
			
			ToggleGroup RFSSRlabel23TG = new ToggleGroup();
			RadioButton RFSSRrb23 = new RadioButton( );
			RFSSRrb23.setToggleGroup(RFSSRlabel23TG);
			RadioButton RFSSRrb23N = new RadioButton( );
			RFSSRrb23N.setToggleGroup(RFSSRlabel23TG);
			
			ToggleGroup RFSSRlabel24TG = new ToggleGroup();
			RadioButton RFSSRrb24 = new RadioButton( );
			RFSSRrb24.setToggleGroup(RFSSRlabel24TG);
			RadioButton RFSSRrb24N = new RadioButton( );
			RFSSRrb24N.setToggleGroup(RFSSRlabel24TG);
			
			ToggleGroup RFSSRlabel25TG = new ToggleGroup();
			RadioButton RFSSRrb25 = new RadioButton( );
			RFSSRrb25.setToggleGroup(RFSSRlabel25TG);
			RadioButton RFSSRrb25N = new RadioButton( );
			RFSSRrb25N.setToggleGroup(RFSSRlabel25TG);
			
			ToggleGroup RFSSRlabel26TG = new ToggleGroup();
			RadioButton RFSSRrb26 = new RadioButton( );
			RFSSRrb26.setToggleGroup(RFSSRlabel26TG);
			RadioButton RFSSRrb26N = new RadioButton( );
			RFSSRrb26N.setToggleGroup(RFSSRlabel26TG);
			
			ToggleGroup RFSSRlabel27TG = new ToggleGroup();
			RadioButton RFSSRrb27 = new RadioButton( );
			RFSSRrb27.setToggleGroup(RFSSRlabel27TG);
			RadioButton RFSSRrb27N = new RadioButton( );
			RFSSRrb27N.setToggleGroup(RFSSRlabel27TG);
			
			ToggleGroup RFSSRlabel28TG = new ToggleGroup();
			RadioButton RFSSRrb28 = new RadioButton( );
			RFSSRrb28.setToggleGroup(RFSSRlabel28TG);
			RadioButton RFSSRrb28N = new RadioButton( );
			RFSSRrb28N.setToggleGroup(RFSSRlabel28TG);
			
			ToggleGroup RFSSRlabel29TG = new ToggleGroup();
			RadioButton RFSSRrb29 = new RadioButton( );
			RFSSRrb29.setToggleGroup(RFSSRlabel29TG);
			RadioButton RFSSRrb29N = new RadioButton();
			RFSSRrb29N.setToggleGroup(RFSSRlabel29TG);
			
			ToggleGroup RFSSRlabel30TG = new ToggleGroup();
			RadioButton RFSSRrb30 = new RadioButton();
			RFSSRrb30.setToggleGroup(RFSSRlabel30TG);
			RadioButton RFSSRrb30N = new RadioButton();
			RFSSRrb30N.setToggleGroup(RFSSRlabel30TG);
			
			ToggleGroup RFSSRlabel31TG = new ToggleGroup();
			RadioButton RFSSRrb31 = new RadioButton();
			RFSSRrb31.setToggleGroup(RFSSRlabel31TG);
			RadioButton RFSSRrb31N = new RadioButton();
			RFSSRrb31N.setToggleGroup(RFSSRlabel31TG);
			
			//Add radio buttons to RFSSRrbGrid
			RFSSRrbGrid.add(RFSSRrb1,		1,1);
			RFSSRrbGrid.add(RFSSRrb1N,		2,1);		
			RFSSRrbGrid.add(RFSSRrb2,	 	1,2);	
			RFSSRrbGrid.add(RFSSRrb2N,		2,2);
			RFSSRrbGrid.add(RFSSRrb3,		1,3);
			RFSSRrbGrid.add(RFSSRrb3N,		2,3);
			RFSSRrbGrid.add(RFSSRrb4,	 	1,4);
			RFSSRrbGrid.add(RFSSRrb4N,		2,4);
			RFSSRrbGrid.add(RFSSRrb5,		1,5);
			RFSSRrbGrid.add(RFSSRrb5N,		2,5);
			RFSSRrbGrid.add(RFSSRrb6,	 	1,6);
			RFSSRrbGrid.add(RFSSRrb6N,		2,6);
			RFSSRrbGrid.add(RFSSRrb7,		1,7);
			RFSSRrbGrid.add(RFSSRrb7N,		2,7);
			RFSSRrbGrid.add(RFSSRrb8,	 	1,8);
			RFSSRrbGrid.add(RFSSRrb8N,		2,8);
			RFSSRrbGrid.add(RFSSRrb9,		1,9);
			RFSSRrbGrid.add(RFSSRrb9N,		2,9);
			RFSSRrbGrid.add(RFSSRrb10,	 	1,10);
			RFSSRrbGrid.add(RFSSRrb10N,		2,10);
			RFSSRrbGrid.add(RFSSRrb11,		1,11);
			RFSSRrbGrid.add(RFSSRrb11N,		2,11);
			RFSSRrbGrid.add(RFSSRrb12,	 	1,12);	
			RFSSRrbGrid.add(RFSSRrb12N,		2,12);
			RFSSRrbGrid.add(RFSSRrb13,		1,13);
			RFSSRrbGrid.add(RFSSRrb13N,		2,13);
			RFSSRrbGrid.add(RFSSRrb14,	 	1,14);
			RFSSRrbGrid.add(RFSSRrb14N,		2,14);
			RFSSRrbGrid.add(RFSSRrb15,		1,15);
			RFSSRrbGrid.add(RFSSRrb15N,		2,15);
			RFSSRrbGrid.add(RFSSRrb16,	 	1,16);
			RFSSRrbGrid.add(RFSSRrb16N,		2,16);
			RFSSRrbGrid.add(RFSSRrb17,		1,17);
			RFSSRrbGrid.add(RFSSRrb17N,		2,17);
			RFSSRrbGrid.add(RFSSRrb18,	 	1,18);
			RFSSRrbGrid.add(RFSSRrb18N,		2,18);
			RFSSRrbGrid.add(RFSSRrb19,		1,19);
			RFSSRrbGrid.add(RFSSRrb19N,		2,19);
			RFSSRrbGrid.add(RFSSRrb20,	 	1,20);
			RFSSRrbGrid.add(RFSSRrb20N,		2,20);
			RFSSRrbGrid.add(RFSSRrb21,		1,21);
			RFSSRrbGrid.add(RFSSRrb21N,		2,21);
			RFSSRrbGrid.add(RFSSRrb22,	 	1,22);	
			RFSSRrbGrid.add(RFSSRrb22N,		2,22);
			RFSSRrbGrid.add(RFSSRrb23,		1,23);
			RFSSRrbGrid.add(RFSSRrb23N,		2,23);
			RFSSRrbGrid.add(RFSSRrb24,	 	1,24);
			RFSSRrbGrid.add(RFSSRrb24N,		2,24);
			RFSSRrbGrid.add(RFSSRrb25,		1,25);
			RFSSRrbGrid.add(RFSSRrb25N,		2,25);
			RFSSRrbGrid.add(RFSSRrb26,	 	1,26);
			RFSSRrbGrid.add(RFSSRrb26N,		2,26);
			RFSSRrbGrid.add(RFSSRrb27,		1,27);
			RFSSRrbGrid.add(RFSSRrb27N,		2,27);
			RFSSRrbGrid.add(RFSSRrb28,	 	1,28);
			RFSSRrbGrid.add(RFSSRrb28N,		2,28);
			RFSSRrbGrid.add(RFSSRrb29,		1,29);
			RFSSRrbGrid.add(RFSSRrb29N,		2,29);
			RFSSRrbGrid.add(RFSSRrb30,	 	1,30);
			RFSSRrbGrid.add(RFSSRrb30N,		2,30);
			RFSSRrbGrid.add(RFSSRrb31,		1,31);
			RFSSRrbGrid.add(RFSSRrb31N,		2,31);
				
			//Create the miscellaneous Notes and Acknowledgment Boxes and place them in the grid
			Label RFSSRtechSigLabel = new Label("Technician Name:");	
			ComboBox<String> RFSSRtechtf = new ComboBox<String>();
			RFSSRtechtf.getItems().addAll("Scott", "Dusten");
			TextField RFSSRcustSigntf = new TextField( "                                                                                                         Date: ");
			RFSSRcustSigntf.setFont(new Font("Cambria", 10));
			Button RFSSRbtPreView = new Button("Preview");
			Button RFSSRbtBack = new Button("Back");
			Button RFSSRbtPrint = new Button("Print");

	        
	        
			RFSSRhb7.getChildren().addAll(RFSSRtechSigLabel,RFSSRtechtf,RFSSRbtPreView,RFSSRbtBack);
			
			RFSSRvb6.getChildren().addAll(RFSSRSiGrid,RFSSRservInfoGrid,RFSSRhb6,RFSSRmiscNotLabel,RFSSRmiscNotTa, RFSSRhb7);	
				
			RFFSRvb7.getChildren().addAll(RFSSRrbGrid);
			
			RFSSRhb3.getChildren().addAll(RFFSRvb7,RFSSRvb6);	
			
			//Button OnAction assignments
			RFSSRrb1.setOnAction(e -> {setYes(GENlabel1TG, "RFSSRrb1"); });
			RFSSRrb1N.setOnAction(e -> {setNo(GENlabel1TG, "RFSSRrb1N"); });
			
			RFSSRrb2.setOnAction(e -> {setYes(GENlabel2TG, "RFSSRrb2"); });
			RFSSRrb2N.setOnAction(e -> {setNo(GENlabel2TG, "RFSSRrb2N"); });
			
			RFSSRrb3.setOnAction(e -> {setYes(GENlabel3TG, "RFSSRrb3"); });
			RFSSRrb3N.setOnAction(e -> {setNo(GENlabel3TG, "RFSSRrb3N"); });
			
			RFSSRrb4.setOnAction(e -> {setYes(GENlabel4TG, "RFSSRrb4"); });
			RFSSRrb4N.setOnAction(e -> {setNo(GENlabel4TG, "RFSSRrb4N"); });
			
			RFSSRrb5.setOnAction(e -> {setYes(GENlabel5TG, "RFSSRrb5"); });
			RFSSRrb5N.setOnAction(e -> {setNo(GENlabel5TG, "RFSSRrb5N"); });
			
			RFSSRrb6.setOnAction(e -> {setYes(GENlabel6TG, "RFSSRrb6"); });
			RFSSRrb6N.setOnAction(e -> {setNo(GENlabel6TG, "RFSSRrb6N"); });
			
			RFSSRrb7.setOnAction(e -> {setYes(GENlabel7TG, "RFSSRrb7"); });
			RFSSRrb7N.setOnAction(e -> {setNo(GENlabel7TG, "RFSSRrb7N"); });
			
			RFSSRrb8.setOnAction(e -> {setYes(GENlabel8TG, "RFSSRrb8"); });
			RFSSRrb8N.setOnAction(e -> {setNo(GENlabel8TG, "RFSSRrb8N"); });
			
			RFSSRrb9.setOnAction(e -> {setYes(GENlabel9TG, "RFSSRrb9"); });
			RFSSRrb9N.setOnAction(e -> {setNo(GENlabel9TG, "RFSSRrb9N"); });
			
			RFSSRrb10.setOnAction(e -> {setYes(GENlabel10TG, "RFSSRrb10"); });
			RFSSRrb10N.setOnAction(e -> {setNo(GENlabel10TG, "RFSSRrb10N"); });
			
			RFSSRrb11.setOnAction(e -> {setYes(GENlabel11TG, "RFSSRrb11"); });
			RFSSRrb11N.setOnAction(e -> {setNo(GENlabel11TG, "RFSSRrb11N"); });
			
			RFSSRrb12.setOnAction(e -> {setYes(GENlabel12TG, "RFSSRrb12"); });
			RFSSRrb12N.setOnAction(e -> {setNo(GENlabel12TG, "RFSSRrb12N"); });
			
			RFSSRrb13.setOnAction(e -> {setYes(GENlabel13TG, "RFSSRrb13"); });
			RFSSRrb13N.setOnAction(e -> {setNo(GENlabel13TG, "RFSSRrb13N"); });
			
			RFSSRrb14.setOnAction(e -> {setYes(GENlabel14TG, "RFSSRrb14"); });
			RFSSRrb14N.setOnAction(e -> {setNo(GENlabel14TG, "RFSSRrb14N"); });
			
			RFSSRrb15.setOnAction(e -> {setYes(GENlabel15TG, "RFSSRrb15"); });
			RFSSRrb15N.setOnAction(e -> {setNo(GENlabel15TG, "RFSSRrb15N"); });
			
			RFSSRrb16.setOnAction(e -> {setYes(GENlabel16TG, "RFSSRrb16"); });
			RFSSRrb16N.setOnAction(e -> {setNo(GENlabel16TG, "RFSSRrb16N"); });
			
			RFSSRrb17.setOnAction(e -> {setYes(GENlabel17TG, "RFSSRrb17"); });
			RFSSRrb17N.setOnAction(e -> {setNo(GENlabel17TG, "RFSSRrb17N"); });
			
			RFSSRrb18.setOnAction(e -> {setYes(GENlabel18TG, "RFSSRrb18"); });
			RFSSRrb18N.setOnAction(e -> {setNo(GENlabel18TG, "RFSSRrb18N"); });
			
			RFSSRrb19.setOnAction(e -> {setYes(GENlabel19TG, "RFSSRrb19"); });
			RFSSRrb19N.setOnAction(e -> {setNo(GENlabel19TG, "RFSSRrb19N"); });
			
			RFSSRrb20.setOnAction(e -> {setYes(GENlabel20TG, "RFSSRrb20"); });
			RFSSRrb20N.setOnAction(e -> {setNo(GENlabel20TG, "RFSSRrb20N"); });
			
			RFSSRrb21.setOnAction(e -> {setYes(GENlabel21TG, "RFSSRrb21"); });
			RFSSRrb21N.setOnAction(e -> {setNo(GENlabel21TG, "RFSSRrb21N"); });
			
			RFSSRrb22.setOnAction(e -> {setYes(GENlabel22TG, "RFSSRrb22"); });
			RFSSRrb22N.setOnAction(e -> {setNo(GENlabel22TG, "RFSSRrb22N"); });
			
			RFSSRrb23.setOnAction(e -> {setYes(GENlabel23TG, "RFSSRrb23"); });
			RFSSRrb23N.setOnAction(e -> {setNo(GENlabel23TG, "RFSSRrb23N"); });
			
			RFSSRrb24.setOnAction(e -> {setYes(GENlabel24TG, "RFSSRrb24"); });
			RFSSRrb24N.setOnAction(e -> {setNo(GENlabel24TG, "RFSSRrb24N"); });
			
			RFSSRrb25.setOnAction(e -> {setYes(GENlabel25TG, "RFSSRrb25"); });
			RFSSRrb25N.setOnAction(e -> {setNo(GENlabel25TG, "RFSSRrb25N"); });
			
			RFSSRrb26.setOnAction(e -> {setYes(GENlabel26TG, "RFSSRrb26"); });
			RFSSRrb26N.setOnAction(e -> {setNo(GENlabel26TG, "RFSSRrb26N"); });
			
			RFSSRrb27.setOnAction(e -> {setYes(GENlabel27TG, "RFSSRrb27"); });
			RFSSRrb27N.setOnAction(e -> {setNo(GENlabel27TG, "RFSSRrb27N"); });
			
			RFSSRrb28.setOnAction(e -> {setYes(GENlabel28TG, "RFSSRrb28"); });
			RFSSRrb28N.setOnAction(e -> {setNo(GENlabel28TG, "RFSSRrb28N"); });
			
			RFSSRrb29.setOnAction(e -> {setYes(GENlabel29TG, "RFSSRrb29"); });
			RFSSRrb29N.setOnAction(e -> {setNo(GENlabel29TG, "RFSSRrb29N"); });
			
			RFSSRrb30.setOnAction(e -> {setYes(GENlabel30TG, "RFSSRrb30"); });
			RFSSRrb30N.setOnAction(e -> {setNo(GENlabel30TG, "RFSSRrb30N"); });
			
			RFSSRrb31.setOnAction(e -> {setYes(GENlabel31TG, "RFSSRrb31"); });
			RFSSRrb31N.setOnAction(e -> {setNo(GENlabel31TG, "RFSSRrb31N"); });
			
			RFSSRbtPreView.setOnAction(e -> {
					String RFSSRcustadd1na = RFSSRtfcustName.getText().trim();
					String RFSSRcustadd1po = RFSSRtfcustAdr.getText().trim();
					String RFSSRcustadd1csz = RFSSRtfcustAdrCity.getText().trim() + ", " + RFSSRtfcustAdrState.getText().trim() + ", " +RFSSRtfcustAdrZip.getText().trim();
					String RFSSRcustadd1ph = RFSSRtfcustPhone.getText().trim();
					String RFSSRcustSignSt = RFSSRcustSigntf.getText();
					
					if (GENrepDate != 0000) {
						System.out.println(GENrepDate);
						GENrepDate = RFSSRdateOSDP.getValue().getYear();
					}
						
					StackPane RFSSRprintBtStage = new StackPane();
						
						Button RFSSRcancel = new Button("Close Preview");

						TextArea RFSSRprintTa = new TextArea();
						RFSSRprintTa.setMinHeight(height);
						RFSSRprintTa.setMinWidth(775);
						RFSSRprintTa.setEditable(false);
						
						TextArea RFSSRtechAddta = new TextArea();
						RFSSRtechAddta.setMaxHeight(125);
						RFSSRtechAddta.setMaxWidth(300);
						RFSSRtechAddta.setEditable(false);
						RFSSRtechAddta.setStyle("-fx-focus-color: transparent; -fx-text-box-border: transparent;");
						
						TextArea RFSSRcustAddta = new TextArea();
						RFSSRcustAddta.setMaxHeight(125);
						RFSSRcustAddta.setMaxWidth(300);
						RFSSRcustAddta.setEditable(false);
						RFSSRcustAddta.setStyle("-fx-focus-color: transparent; -fx-text-box-border: transparent;");
						
						TextArea RFSSRcleanNotice = new TextArea();
						RFSSRcleanNotice.setMinHeight(125);
						RFSSRcleanNotice.setMinWidth(450);
						RFSSRcleanNotice.setEditable(false);
						RFSSRcleanNotice.setStyle("-fx-highlight-fill: #7ecfff;"
											+"-fx-focus-color: transparent;"
											+"-fx-text-box-border: transparent;"
											+"-fx-font-size:10;"
										    +"-fx-background-insets: 0;"
										    +"-fx-background-color: transparent;"
										    +"-fx-padding: 10px;"
											);
						
						AnchorPane RFSSRprintStage = new AnchorPane(RFSSRprintTa,RFSSRreportLogo,RFSSRcleanNotice,RFSSRtechAddta,RFSSRcustAddta);

						AnchorPane.setTopAnchor(RFSSRreportLogo,10.0);
						AnchorPane.setLeftAnchor(RFSSRreportLogo,0.0);
						AnchorPane.setTopAnchor(RFSSRprintTa,0.0);
						AnchorPane.setLeftAnchor(RFSSRprintTa,0.0);
						AnchorPane.setTopAnchor(RFSSRtechAddta,10.0);
						AnchorPane.setLeftAnchor(RFSSRtechAddta,225.0);
						AnchorPane.setTopAnchor(RFSSRcustAddta,10.0);
						AnchorPane.setRightAnchor(RFSSRcustAddta,0.0);
						AnchorPane.setTopAnchor(RFSSRcleanNotice,110.0);
						AnchorPane.setRightAnchor(RFSSRcleanNotice,70.0);

						RFSSRtechAddta.appendText(GENendTech1);
						RFSSRcustAddta.appendText("Invoice Number: " + RFSSRtfInvoice.getText() + "\n" + RFSSRcustadd1na + "\n" + RFSSRcustadd1po + "\n" + RFSSRcustadd1csz + "\n" + RFSSRcustadd1ph);
						RFSSRcleanNotice.appendText("\nOn this date, the below was tested and inspected in accordance with procedures of the \n"
								+ "presently adopted editions of NFPA 17, 17A, refrences to Fire suppression Systems contained \n"
								+ "in NFPA 96, and the manufacturer's manual, and was operated according to these procedures \n"
								+ "with results indicated herein.\n"
						);
						
						RFSSRprintTa.appendText("\n" + "\n" + "\n" + "\n" + "\n"+"\n" + "\n" + "\n"
						+ "    Service Scheduled with: " + RFSSRservSchTF.getText() + "\n"
						+ "    Store Closing Manager: " + RFSSRstoreCMTF.getText()+ "\n"
						+ "    Date of Service:\t\t" + RFSSRdateOSDP.getValue()+ "\n"
						+ "    Service Frequency:\t" + RFSSRselOneCB.getValue()+ "\n"
						+ "    Time of Service:\t\t" + RFSSRtimeOSTF.getText()+ "\n"
						+ "    Next Service Due:\t" + GENexecDate + "\n"
										+ "\t__________________________________________________________________________________________________________________________________________\n"
						+ "\n"				+ "\t\t\t\t\t\t\t\t\tRESTAURANT FIRE SUPPRESSION SYSTEMS REPORT\n\n" 
						+ "\tAppliance Location:  " +  RFSSRCALTF.getText() + "\n\n"
						+ "\tCompleted Service: "+RFSSRselOneCB.getValue() +"\n\n"
						+ "\tItem: \t\t\t\t\t\t\t\t\t\t" +"\t\t\t\tItem:\n"
						+ " "+ RFSSRlabel1.getText() + "\t\t\t" + GENlabel1TG + "\t\t\t" + RFSSRlabel17.getText() + "\t\t\t\t\t" +  GENlabel17TG +"\n"
						+ " "+ RFSSRlabel2.getText() + "\t\t" + GENlabel2TG + "\t\t\t" + RFSSRlabel18.getText() + "\t\t\t\t" +  GENlabel18TG +"\n"
						+ " "+ RFSSRlabel3.getText() + "\t\t\t\t\t" + GENlabel3TG + "\t\t\t" + RFSSRlabel19.getText() + "\t\t\t" +  GENlabel19TG +"\n"
						+ " "+ RFSSRlabel4.getText() + "\t"  + GENlabel4TG + "\t\t\t" + RFSSRlabel20.getText() + "\t\t\t\t\t\t" +  GENlabel20TG + "\n"
						+ " "+ RFSSRlabel5.getText() + "\t"  + GENlabel5TG + "\t\t\t" + RFSSRlabel21.getText() + "\t\t\t\t\t\t\t" +  GENlabel21TG + "\n"
						+ " "+ RFSSRlabel6.getText() + "\t\t\t\t\t"  + GENlabel6TG + "\t\t\t" + RFSSRlabel22.getText() + "\t\t\t\t\t\t" +  GENlabel22TG + "\n"
						+ " "+ RFSSRlabel7.getText() + "\t\t\t"  + GENlabel7TG + "\t\t\t" + RFSSRlabel23.getText() + "\t\t\t\t" +  GENlabel23TG + "\n"
						+ " "+ RFSSRlabel8.getText() + "\t\t\t\t\t"  + GENlabel8TG + "\t\t\t" + RFSSRlabel24.getText() + "\t\t\t\t\t\t\t" +  GENlabel24TG + "\n"
						+ " "+ RFSSRlabel9.getText() + "\t\t\t\t"  + GENlabel9TG + "\t\t\t" + RFSSRlabel25.getText() + "\t\t\t\t" +  GENlabel25TG + "\n"
						+ " "+ RFSSRlabel10.getText() + "\t\t\t\t\t\t\t"  + GENlabel10TG + "\t\t\t" + RFSSRlabel26.getText() + "\t\t\t\t\t\t\t" +  GENlabel26TG + "\n"
						+ " "+ RFSSRlabel11.getText() + "\t\t\t\t"  + GENlabel11TG + "\t\t\t" + RFSSRlabel27.getText() + "\t\t\t\t\t\t" +  GENlabel27TG + "\n"
						+ " "+ RFSSRlabel12.getText() + "\t"  + GENlabel12TG + "\t\t\t" + RFSSRlabel28.getText() + "\t" +  GENlabel28TG + "\n"
						+ " "+ RFSSRlabel13.getText() + "\t\t\t\t\t"   + GENlabel13TG + "\t\t\t" + RFSSRlabel29.getText() + "\t\t\t\t\t" +  GENlabel29TG + "\n"
						+ " "+ RFSSRlabel14.getText() + "\t\t\t\t\t\t\t\t\t"  + GENlabel14TG + "\t\t\t" + RFSSRlabel30.getText() + "\t\t\t\t" +  GENlabel30TG + "\n"
						+ " "+ RFSSRlabel15.getText() + "\t\t\t" + GENlabel15TG + "\t\t\t" + RFSSRlabel31.getText() + "\t\t\t\t" +  GENlabel31TG + "\n"
						+ " "+ RFSSRlabel16.getText() + "\t\t\t\t\t\t\t\t" + GENlabel16TG +"\n\n"
						+ " "+ RFSSRmiscNotLabel.getText() + " "+RFSSRmiscNotTa.getText() + "\n\n"
						+ "\tService performed by:      " + RFSSRtechtf.getValue() + "\t\tDate Completed: " + RFSSRdateOSDP.getValue()	+ "                  Time In: " + RFSSRtfTI.getText()+ "                  Time Out: " + RFSSRtfTO.getText()+ "\n"
						+ "\t__________________________________________________________________________________________________________________________________________\n"

						+ "\tIN THE EVENT OF DEFAULT, TONG'S FIRE EXTINGUISHER SHALL BE ENTITLED TO RECOVER COST OF COLLECTION, INCLUDING\n\tREASONABLE ATTORNEY FEES. ACKNOWLEDGMENT OF KITCHEN CONDITION & KEC SERVICE COMPLETED. BY SIGNING BELOW \n\tTHE CUSTOMER ACKNOWLEDGES ALL SERVICE WAS COMPLETED AND THE KITCHEN WAS LEFT CLEAN AND IN SATISFACTORY \n\tCONDITION."
						+ "\n\tClaims of unsatisfactory workmanship must be made within 48 hours. Invoices are subject to an interest charge of the lesser of \n\t1.5% per month (18% per year) or the maximum rate allowed by law on any unpaid invoices outstanding after 30 days from date \n\tof service. The Customer herby waives thier rights of subrogation by thier insurance carrier against Tong's Fire Extinguisher \n\tunder any fire or liability insurance policy.\n"
						+ "\t__________________________________________________________________________________________________________________________________________\n"
						+ "\n\n\n\tCustomer Signature: " + RFSSRcustSignSt + "\n"
						+ "                                         --------------------------------------------------------------                        -------------------------"  
						
						);
						
						HBox RFSSRprintHBox = new HBox();
						
						RFSSRprintHBox.getChildren().addAll(RFSSRbtPrint,RFSSRcancel);
						
						RFSSRprintBtStage.getChildren().addAll(RFSSRprintHBox);

						Scene RFSSRprintScene = new Scene(RFSSRprintStage , width, height);
						Scene RFSSRprintBtScene = new Scene(RFSSRprintBtStage , 200, 50);
						
						Stage RFSSRprintWindow = new Stage();
						Stage RFSSRprintBtWindow = new Stage();
						
						RFSSRprintWindow.setTitle("HCRGen Report");
						RFSSRprintWindow.setScene(RFSSRprintScene);
						RFSSRprintWindow.setMinWidth(775);
						RFSSRprintWindow.setMaxWidth(775);
						
						RFSSRprintWindow.setX(0);
						RFSSRprintWindow.setY(0);
						
						RFSSRprintBtWindow.setTitle("Print/Cancel");
						RFSSRprintBtWindow.setScene(RFSSRprintBtScene);
						
						RFSSRprintBtWindow.setX(900);
						RFSSRprintBtWindow.setY(100);
						
						RFSSRprintWindow.show();
						RFSSRprintBtWindow.show();
						
						RFSSRcancel.setOnAction(ex -> {
							RFSSRprintWindow.close();	
							RFSSRprintBtWindow.close();	
						});
						
						RFSSRprintTa.setOnKeyPressed(ex -> {
							if (ex.getCode().equals(KeyCode.ENTER)) {
								String RFSSRPATH = "HCRGen/Reports/";
								String RFSSRdirName = RFSSRPATH.concat(RFSSRtfcustName.getText().trim());
								File RFSSRdirectory = new File(RFSSRdirName + "/" + GENrepDate + "/");
								
								if (! RFSSRdirectory.exists()) {
									RFSSRdirectory.mkdirs();
								}
								try (
									FileOutputStream RFSSRoos = new FileOutputStream(RFSSRdirectory +"/"+ RFSSRtfInvoice.getText().trim() + ".png", true);
									){
									captureScreen(RFSSRdirectory +"/"+ RFSSRtfInvoice.getText().trim() + ".png");
									System.out.println("Image saved to file!");
									RFSSRoos.close();
								} catch (Exception exe) {
									exe.printStackTrace();
								}
							}
							else if (ex.getCode().equals(KeyCode.ESCAPE)) {
								RFSSRprintWindow.close();	
								RFSSRprintBtWindow.close();
							}	
			
						});
				});
				
			 RFSSRbtPrint.setOnAction(e -> {
					String RFSSRPATH = "HCRGen/Reports/";
					String RFSSRdirName = RFSSRPATH.concat(RFSSRtfcustName.getText().trim());
					File RFSSRdirectory = new File(RFSSRdirName + "/" + GENrepDate + "/");
					
					if (! RFSSRdirectory.exists()) {
						RFSSRdirectory.mkdirs();
					}
					try (
						FileOutputStream RFSSRoos = new FileOutputStream(RFSSRdirectory +"/"+ RFSSRtfInvoice.getText()+ ".png", true);
						){
						captureScreen(RFSSRdirectory +"/"+  RFSSRtfInvoice.getText()+ ".png");
						System.out.println("Image saved to file!");
						RFSSRoos.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});
	        
			RFSSRbtBack.setOnAction(e -> {
	        	try {start(primaryStage);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
			}});

			
		RFSSRmainVB.getChildren().addAll(RFSSRhb1, RFSSRhb2, RFSSRhb3, RFSSRhb4, RFSSRhb5, RFSSRhb8);
		
		Scene RFSSRscene = new Scene(RFSSRsp , width, height);
		
		primaryStage.setTitle("RFSSRGen");
		primaryStage.setX(0);
		primaryStage.setY(0);
		primaryStage.setScene(RFSSRscene);
		primaryStage.setMinWidth(775);
		primaryStage.setMaxWidth(775);
		primaryStage.show();
	}	
	
	/** 
	 * Add Client window CusAdd
	 */
	public void CusAddstart(Stage primaryStage) throws FileNotFoundException{
		
		ScrollPane CusAddsp = new ScrollPane();	
		VBox CusAddmainVB = new VBox();
		VBox.setVgrow(CusAddsp, Priority.ALWAYS);
		CusAddsp.setContent(CusAddmainVB);
	
		CusAddmainVB.setMinSize(400, 250);
		CusAddmainVB.setPadding(new Insets(10,10,10,10));
		CusAddmainVB.setAlignment(Pos.TOP_CENTER);
		
		HBox CusAddhb1 = new HBox();
		CusAddhb1.setAlignment(Pos.TOP_CENTER);
		CusAddhb1.setPadding(new Insets(10,10,10,10));
		CusAddhb1.setSpacing(10);
		
		//create GridPane for the logo, business information and invoice Box
		GridPane CusAddheadPane = new GridPane();
		CusAddheadPane.setMinSize(200, 100);
		CusAddheadPane.setPadding(new Insets(10,10,10,10));
		CusAddheadPane.setVgap(50);
		CusAddheadPane.setHgap(60);
		CusAddheadPane.setAlignment(Pos.TOP_LEFT);
		CusAddheadPane.setGridLinesVisible(false);
		
		//create ImageView for logo and place in the grid
		File CusAddf = new File("TONGS-FIRE-EXTINGUISHER-SALES-AND-SERVICE.jpg");
		String CusAddfilLoc = CusAddf.getAbsolutePath();
		
		//Creating a Label
		Label CusAddlogo = new Label();
				
		//Creating a graphic
		Image CusAddimg = new Image(new FileInputStream(CusAddfilLoc));
		ImageView CusAddview = new ImageView(CusAddimg);
		CusAddview.setFitHeight(125);
		CusAddview.setFitWidth(225);
		CusAddview.setPreserveRatio(false);
		
		CusAddlogo.setGraphic(CusAddview);
				
		//place boxes in the top pane
		CusAddheadPane.add(CusAddlogo, 0,0);		
		
		//Create Service Schedule Information box
		Label CusAddcustNameLabel = new Label(" Client: ");
		Label CusAddcustAdrLabel = new Label(" Address: ");
		Label CusAddcustAdrCityLabel = new Label(" City: ");
		Label CusAddcustAdrStateLabel = new Label(" State: ");
		Label CusAddcustAdrZipLabel = new Label(" Zip: ");
		Label CusAddcustPhoneLabel = new Label(" Phone: ");
		Label CusAddservSchLabel = new Label(" Service Scheduled with: ");
		Label CusAddstoreCMLabel = new Label(" Store Closing Manager: ");
		Label CusAddserviceELabel = new Label(" Service Frequency ");

		TextField CusAddtfcustPhone = new TextField("847-9916");
		CusAddtfcustPhone.setFont(new Font("Cambria", 10));
		CusAddtfcustPhone.setMaxWidth(115);
		TextField CusAddtfcustName = new TextField("Customer Name");
		CusAddtfcustName.setFont(new Font("Cambria", 10));
		CusAddtfcustName.setMinWidth(205);
		TextField CusAddtfcustAdr = new TextField("Address");
		CusAddtfcustAdr.setFont(new Font("Cambria", 10));
		CusAddtfcustAdr.setMaxWidth(275);
		TextField CusAddtfcustAdrCity = new TextField("City");
		CusAddtfcustAdrCity.setFont(new Font("Cambria", 10));
		CusAddtfcustAdrCity.setMaxWidth(115);
		TextField CusAddtfcustAdrState = new TextField("Utah");
		CusAddtfcustAdrState.setFont(new Font("Cambria", 10));
		CusAddtfcustAdrState.setMaxWidth(115);
		TextField CusAddtfcustAdrZip = new TextField("84720");
		CusAddtfcustAdrZip.setFont(new Font("Cambria", 10));
		CusAddtfcustAdrZip.setMaxWidth(115);
		TextField CusAddservSchTF = new TextField();
		CusAddservSchTF.setMinWidth(205);
		CusAddservSchTF.setFont(new Font("Cambria", 10));
		TextField CusAddstoreCMTF = new TextField();
		CusAddstoreCMTF.setFont(new Font("Cambria", 10));
		CusAddstoreCMTF.setMaxWidth(275);
		
		ComboBox<String> CusAddserviceECB = new ComboBox<String>();
		CusAddserviceECB.getItems().addAll("Annually", "Bi-Annually", "Quarterly");
		
		Button CusAddbtFin = new Button("Finish");
		Button CusAddbtBack = new Button("Back");
		Button CusAddbtCreate = new Button("Create");
		
		CusAddbtFin.setOnAction(e -> {
			
			String client = CusAddtfcustName.getText().trim();
			String address = CusAddtfcustAdr.getText().trim();
			String city = CusAddtfcustAdrCity.getText().trim();
			String state = CusAddtfcustAdrState.getText().trim();
			String zip= CusAddtfcustAdrZip.getText().trim();
			String phone= CusAddtfcustPhone.getText().trim();
			String SSw = CusAddservSchTF.getText().trim();
			String SCM = CusAddstoreCMTF.getText().trim();
			String SF = CusAddserviceECB.getValue().trim();
			
			CusOb obj = new CusOb(client,address,city,state,zip,phone,SSw,SCM,SF);
			map.put(obj.getClient(), obj);
			System.out.println("Object written to map!");
			
			String MapFilePATH = mapFileLoc;
			String MapFiledirName = MapFilePATH;
			File MapFiledirectory = new File(MapFiledirName);
			
			if (! MapFiledirectory.exists()) {
				MapFiledirectory.mkdirs();
				System.out.println("Directory Made Via File creation method");
			}
			try (
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(MapFiledirectory + "/" + "ClientList" + ".txt", true));
				){
				oos.writeObject(map);
				System.out.println("Object written to file!");
				System.out.println("CUSTOBJFOCUS = " + map.containsKey(obj.getClient()));
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("didnt work");
			}
			
			
			System.out.println("Object: 				" + obj.toString());
			System.out.println("Client Name: 				" + obj.getClient());
			System.out.println("Map: 					" + map);
			
		});
		
		CusAddbtCreate.setOnAction(e -> {
        	
			String client = "South Street Cafe";
					CusAddtfcustName.setText(client);
			String address = "65 North Public View Drive";
					CusAddtfcustAdr.setText(address);
			String city = "Cedar City";
					CusAddtfcustAdrCity.setText(city);
			String state = "Utah";
					CusAddtfcustAdrState.setText(state);
			String zip = "84701";
					CusAddtfcustAdrZip.setText(zip);
			String phone= "(435)896-9966";
					CusAddtfcustPhone.setText(phone);
			String SSw = "Ricky";
					CusAddservSchTF.setText(SSw);
			String SCM = "Bobby";
					CusAddstoreCMTF.setText(SCM);
			String SF = "Quarterly";
					CusAddserviceECB.setValue(SF);
					
		});
					
					
		CusAddbtBack.setOnAction(e -> {
        	try {start(primaryStage);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
		}});
		
		GridPane CusAddservGrid = new GridPane();
		CusAddservGrid.setMinSize(400, 100);
		CusAddservGrid.setAlignment(Pos.TOP_LEFT);
		
		CusAddservGrid.add(CusAddcustNameLabel,0,0);
		CusAddservGrid.add(CusAddtfcustName,1,0);
		
		CusAddservGrid.add(CusAddcustAdrLabel,0,1);
		CusAddservGrid.add(CusAddtfcustAdr,1,1);
		
		CusAddservGrid.add(CusAddcustAdrCityLabel,0,2);
		CusAddservGrid.add(CusAddtfcustAdrCity,1,2);
		
		CusAddservGrid.add(CusAddcustAdrStateLabel,0,3);
		CusAddservGrid.add(CusAddtfcustAdrState,1,3);
		
		CusAddservGrid.add(CusAddcustAdrZipLabel,0,4);
		CusAddservGrid.add(CusAddtfcustAdrZip,1,4);
		
		CusAddservGrid.add(CusAddcustPhoneLabel,0,5);
		CusAddservGrid.add(CusAddtfcustPhone,1,5);
		
		CusAddservGrid.add(CusAddservSchLabel,0,6);
		CusAddservGrid.add(CusAddservSchTF,1,6);
		
		CusAddservGrid.add(CusAddstoreCMLabel,0,7);
		CusAddservGrid.add(CusAddstoreCMTF,1,7);
		
		CusAddservGrid.add(CusAddserviceELabel,0,8);
		CusAddservGrid.add(CusAddserviceECB,1,8);
		
		CusAddservGrid.add(CusAddbtFin, 0, 9);
		CusAddservGrid.add(CusAddbtBack, 1, 9);
		CusAddservGrid.add(CusAddbtCreate, 2, 9);
		
		CusAddhb1.getChildren().addAll(CusAddheadPane, CusAddservGrid);
		
		CusAddmainVB.getChildren().addAll(CusAddhb1);
	
		Scene CusAddscene = new Scene(CusAddsp , 700, 400);
		
		primaryStage.setTitle("Add new Client");
		primaryStage.setX(0);
		primaryStage.setY(0);
		primaryStage.setScene(CusAddscene);
		primaryStage.show();
	}
	
	/** 
	 * Edit Client window CusAdd
	 */
	public void CusEdstart(Stage primaryStage) throws FileNotFoundException{
		
		ScrollPane CusEdsp = new ScrollPane();	
		VBox CusEdmainVB = new VBox();
		VBox.setVgrow(CusEdsp, Priority.ALWAYS);
		CusEdsp.setContent(CusEdmainVB);
	
		CusEdmainVB.setMinSize(400, 250);
		CusEdmainVB.setPadding(new Insets(10,10,10,10));
		CusEdmainVB.setAlignment(Pos.TOP_CENTER);
		
		HBox CusEdhb1 = new HBox();
		CusEdhb1.setAlignment(Pos.TOP_CENTER);
		CusEdhb1.setPadding(new Insets(10,10,10,10));
		CusEdhb1.setSpacing(10);
		
		//create GridPane for the logo, business information and invoice Box
		GridPane CusEdheadPane = new GridPane();
		CusEdheadPane.setMinSize(200, 100);
		CusEdheadPane.setPadding(new Insets(10,10,10,10));
		CusEdheadPane.setVgap(50);
		CusEdheadPane.setHgap(60);
		CusEdheadPane.setAlignment(Pos.TOP_LEFT);
		CusEdheadPane.setGridLinesVisible(false);
		
		//create ImageView for logo and place in the grid
		File CusEdf = new File("TONGS-FIRE-EXTINGUISHER-SALES-AND-SERVICE.jpg");
		String CusEdfilLoc = CusEdf.getAbsolutePath();
		
		//Creating a Label
		Label CusEdlogo = new Label();
				
		//Creating a graphic
		Image CusEdimg = new Image(new FileInputStream(CusEdfilLoc));
		ImageView CusEdview = new ImageView(CusEdimg);
		CusEdview.setFitHeight(125);
		CusEdview.setFitWidth(225);
		CusEdview.setPreserveRatio(false);
		
		CusEdlogo.setGraphic(CusEdview);
				
		//place boxes in the top pane
		CusEdheadPane.add(CusEdlogo, 0,0);		
		
		//Create Service Schedule Information box
		Label CusEdcustNameLabel = new Label(" Client: ");
		Label CusEdcustAdrLabel = new Label(" Address: ");
		Label CusEdcustAdrCityLabel = new Label(" City: ");
		Label CusEdcustAdrStateLabel = new Label(" State: ");
		Label CusEdcustAdrZipLabel = new Label(" Zip: ");
		Label CusEdcustPhoneLabel = new Label(" Phone: ");
		Label CusEdservSchLabel = new Label(" Service Scheduled with: ");
		Label CusEdstoreCMLabel = new Label(" Store Closing Manager: ");
		Label CusEdserviceELabel = new Label(" Service Frequency ");

		TextField CusEdtfcustPhone = new TextField("Phone");
		CusEdtfcustPhone.setFont(new Font("Cambria", 10));
		CusEdtfcustPhone.setMaxWidth(115);
		TextField CusEdtfcustName = new TextField("Customer Name");
		CusEdtfcustName.setFont(new Font("Cambria", 10));
		CusEdtfcustName.setMinWidth(205);
		TextField CusEdtfcustAdr = new TextField("Address");
		CusEdtfcustAdr.setFont(new Font("Cambria", 10));
		CusEdtfcustAdr.setMaxWidth(275);
		TextField CusEdtfcustAdrCity = new TextField("City");
		CusEdtfcustAdrCity.setFont(new Font("Cambria", 10));
		CusEdtfcustAdrCity.setMaxWidth(115);
		TextField CusEdtfcustAdrState = new TextField("Utah");
		CusEdtfcustAdrState.setFont(new Font("Cambria", 10));
		CusEdtfcustAdrState.setMaxWidth(115);
		TextField CusEdtfcustAdrZip = new TextField("Zip");
		CusEdtfcustAdrZip.setFont(new Font("Cambria", 10));
		CusEdtfcustAdrZip.setMaxWidth(115);
		TextField CusEdservSchTF = new TextField();
		CusEdservSchTF.setMinWidth(205);
		CusEdservSchTF.setFont(new Font("Cambria", 10));
		TextField CusEdstoreCMTF = new TextField();
		CusEdstoreCMTF.setFont(new Font("Cambria", 10));
		CusEdstoreCMTF.setMaxWidth(275);
		
		ComboBox<String> CusEdserviceECB = new ComboBox<String>();
		CusEdserviceECB.getItems().addAll("Annually", "Bi-Annually", "Quarterly");
						
		Button CusEdbtFin = new Button("Submit");
		Button CusEdbtBack = new Button("Back");
		Button CusEdbtCreate = new Button("Create");
					
		CusEdbtFin.setOnAction(e ->{ });
		
		CusEdbtBack.setOnAction(e -> {
        	try {start(primaryStage);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
		}});
		
		GridPane CusEdservGrid = new GridPane();
		CusEdservGrid.setMinSize(400, 100);
		CusEdservGrid.setAlignment(Pos.TOP_LEFT);
		
		CusEdservGrid.add(CusEdcustNameLabel,0,0);
		CusEdservGrid.add(CusEdtfcustName,1,0);
		
		CusEdservGrid.add(CusEdcustAdrLabel,0,1);
		CusEdservGrid.add(CusEdtfcustAdr,1,1);
		
		CusEdservGrid.add(CusEdcustAdrCityLabel,0,2);
		CusEdservGrid.add(CusEdtfcustAdrCity,1,2);
		
		CusEdservGrid.add(CusEdcustAdrStateLabel,0,3);
		CusEdservGrid.add(CusEdtfcustAdrState,1,3);
		
		CusEdservGrid.add(CusEdcustAdrZipLabel,0,4);
		CusEdservGrid.add(CusEdtfcustAdrZip,1,4);
		
		CusEdservGrid.add(CusEdcustPhoneLabel,0,5);
		CusEdservGrid.add(CusEdtfcustPhone,1,5);
		
		CusEdservGrid.add(CusEdservSchLabel,0,6);
		CusEdservGrid.add(CusEdservSchTF,1,6);
		
		CusEdservGrid.add(CusEdstoreCMLabel,0,7);
		CusEdservGrid.add(CusEdstoreCMTF,1,7);
		
		CusEdservGrid.add(CusEdserviceELabel,0,8);
		CusEdservGrid.add(CusEdserviceECB,1,8);
		
		CusEdservGrid.add(CusEdbtFin, 0, 9);
		CusEdservGrid.add(CusEdbtBack, 1, 9);
		CusEdservGrid.add(CusEdbtCreate, 2, 9);
		
		CusEdhb1.getChildren().addAll(CusEdheadPane, CusEdservGrid);
		
		CusEdmainVB.getChildren().addAll(CusEdhb1);
	
		Scene CusEdscene = new Scene(CusEdsp , 700, 400);
		
		primaryStage.setTitle("Add new Client");
		primaryStage.setX(0);
		primaryStage.setY(0);
		primaryStage.setScene(CusEdscene);
		primaryStage.show();
	}
	
	/**
	 * Method for setting the radio group to yes
	 * @param input name for radio group
	 * @param btName name of button 
	 */
	public void setYes(String input, String btName){
		switch (btName){
			//HCR
			case "HCRdKWrb1": GENdkWSt = "Yes"; break;
			case "HCRfWPrb1": GENdkWSt = "Yes"; break;
			case "HCRdIFrb1": GENdIFSt = "Yes"; break;
			case "HCRaFHrb1": GENaFHSt = "Yes"; break;
			case "HCRfDWrb1": GENfDWSt = "Yes"; break;
			case "HCRhLWrb1": GENhLWSt = "Yes"; break;
			case "HCRhGPrb1": GENhGPSt = "Yes"; break;
			case "HCRrTCSrb1": GENrTCSSt = "Yes"; break;
			case "HCRfWLRrb1": GENfWLRSt = "Yes"; break;
			case "HCRrANFROrb1": GENrANFROSt = "Yes"; break;
			case "HCRhIWDrb1": GENhIWDSt = "Yes"; break;
			case "HCRHCRkFCEWDrb1": GENkFCEWDSt = "Yes"; break;
			case "HCRoARCrb1": GENoARCSt = "Yes"; break;
			case "HCRhSFPWrb1": GENhSFPWSt = "Yes"; break;
			case "HCRhDGLrb1": GENhDGLSt = "Yes"; break;
			case "HCRaPGQrb1": GENaPGQSt = "Yes"; break;
			case "HCRsDWTrb1": GENsDWTSt = "Yes"; break;
			case "HCRpLRrb1": GENpLRSt = "Yes"; break;
			case "HCRhSRrb1": GENhSRSt = "Yes"; break;
			case "HCRphotoTrb1": GENphotoTSt = "Yes"; break;
			//RFSSR
			case "RFSSRrb1": GENlabel1TG = "Yes"; break;
			case "RFSSRrb2": GENlabel2TG = "Yes"; break;
			case "RFSSRrb3": GENlabel3TG = "Yes"; break;
			case "RFSSRrb4": GENlabel4TG = "Yes"; break;
			case "RFSSRrb5": GENlabel5TG = "Yes"; break;
			case "RFSSRrb6": GENlabel6TG = "Yes"; break;
			case "RFSSRrb7": GENlabel7TG = "Yes"; break;
			case "RFSSRrb8": GENlabel8TG = "Yes"; break;
			case "RFSSRrb9": GENlabel9TG = "Yes"; break;
			case "RFSSRrb10": GENlabel10TG = "Yes"; break;
			case "RFSSRrb11": GENlabel11TG = "Yes"; break;
			case "RFSSRrb12": GENlabel12TG = "Yes"; break;
			case "RFSSRrb13": GENlabel13TG = "Yes"; break;
			case "RFSSRrb14": GENlabel14TG = "Yes"; break;
			case "RFSSRrb15": GENlabel15TG = "Yes"; break;
			case "RFSSRrb16": GENlabel16TG = "Yes"; break;
			case "RFSSRrb17": GENlabel17TG = "Yes"; break;
			case "RFSSRrb18": GENlabel18TG = "Yes"; break;
			case "RFSSRrb19": GENlabel19TG = "Yes"; break;
			case "RFSSRrb20": GENlabel20TG = "Yes"; break;
			case "RFSSRrb21": GENlabel21TG = "Yes"; break;
			case "RFSSRrb22": GENlabel22TG = "Yes"; break;
			case "RFSSRrb23": GENlabel23TG = "Yes"; break;
			case "RFSSRrb24": GENlabel24TG = "Yes"; break;
			case "RFSSRrb25": GENlabel25TG = "Yes"; break;
			case "RFSSRrb26": GENlabel26TG = "Yes"; break;
			case "RFSSRrb27": GENlabel27TG = "Yes"; break;
			case "RFSSRrb28": GENlabel28TG = "Yes"; break;
			case "RFSSRrb29": GENlabel29TG = "Yes"; break;
			case "RFSSRrb30": GENlabel30TG = "Yes"; break;
			case "RFSSRrb31": GENlabel31TG = "Yes"; break;
		}
	}
	
	/**
	 * Method for setting the radio group to no
	 * @param input name for radio group
	 * @param btName name of button 
	 */
	public void setNo(String input, String btName){
		switch (btName){
		//HCR
		case "HCRdKWrb2": GENdkWSt = "No"; break;
		case "HCRfWPrb2": GENdkWSt = "No"; break;
		case "HCRdIFrb2": GENdIFSt = "No"; break;
		case "HCRaFHrb2": GENaFHSt = "No"; break;
		case "HCRfDWrb2": GENfDWSt = "No"; break;
		case "HCRhLWrb2": GENhLWSt = "No"; break;
		case "HCRhGPrb2": GENhGPSt = "No"; break;
		case "HCRrTCSrb2": GENrTCSSt = "No"; break;
		case "HCRfWLRrb2": GENfWLRSt = "No"; break;
		case "HCRrANFROrb2": GENrANFROSt = "No"; break;
		case "HCRhIWDrb2": GENhIWDSt = "No"; break;
		case "HCRkFCEWDrb2": GENkFCEWDSt = "No"; break;
		case "HCRoARCrb2": GENoARCSt = "No"; break;
		case "HCRhSFPWrb2": GENhSFPWSt = "No"; break;
		case "HCRhDGLrb2": GENhDGLSt = "No"; break;
		case "HCRaPGQrb2": GENaPGQSt = "No"; break;
		case "HCRsDWTrb2": GENsDWTSt = "No"; break;
		case "HCRpLRrb2": GENpLRSt = "No"; break;
		case "HCRhSRrb2": GENhSRSt = "No"; break;
		case "HCRphotoTrb2": GENphotoTSt = "No"; break;
		//RFSSR
		case "RFSSRrb1N": GENlabel1TG = "No"; break;
		case "RFSSRrb2N": GENlabel2TG = "No"; break;
		case "RFSSRrb3N": GENlabel3TG = "No"; break;
		case "RFSSRrb4N": GENlabel4TG = "No"; break;
		case "RFSSRrb5N": GENlabel5TG = "No"; break;
		case "RFSSRrb6N": GENlabel6TG = "No"; break;
		case "RFSSRrb7N": GENlabel7TG = "No"; break;
		case "RFSSRrb8N": GENlabel8TG = "No"; break;
		case "RFSSRrb9N": GENlabel9TG = "No"; break;
		case "RFSSRrb10N": GENlabel10TG = "No"; break;
		case "RFSSRrb11N": GENlabel11TG = "No"; break;
		case "RFSSRrb12N": GENlabel12TG = "No"; break;
		case "RFSSRrb13N": GENlabel13TG = "No"; break;
		case "RFSSRrb14N": GENlabel14TG = "No"; break;
		case "RFSSRrb15N": GENlabel15TG = "No"; break;
		case "RFSSRrb16N": GENlabel16TG = "No"; break;
		case "RFSSRrb17N": GENlabel17TG = "No"; break;
		case "RFSSRrb18N": GENlabel18TG = "No"; break;
		case "RFSSRrb19N": GENlabel19TG = "No"; break;
		case "RFSSRrb20N": GENlabel20TG = "No"; break;
		case "RFSSRrb21N": GENlabel21TG = "No"; break;
		case "RFSSRrb22N": GENlabel22TG = "No"; break;
		case "RFSSRrb23N": GENlabel23TG = "No"; break;
		case "RFSSRrb24N": GENlabel24TG = "No"; break;
		case "RFSSRrb25N": GENlabel25TG = "No"; break;
		case "RFSSRrb26N": GENlabel26TG = "No"; break;
		case "RFSSRrb27N": GENlabel27TG = "No"; break;
		case "RFSSRrb28N": GENlabel28TG = "No"; break;
		case "RFSSRrb29N": GENlabel29TG = "No"; break;
		case "RFSSRrb30N": GENlabel30TG = "No"; break;
		case "RFSSRrb31N": GENlabel31TG = "No"; break;
		
		}
	}
	/**
	 * Method for setting the radio group to Light
	 * @param input name for radio group
	 * @param btName name of button 
	 */
	public void setLight(String input, String btName){
		switch (btName) {
			case "HCRgBURFrb1": GENgBURFSt = "Lit"; break;
			case "HCRgBUFBrb1": GENgBUFBSt = "Lit"; break;
			case "HCRgBUSDrb1": GENgBUSDSt = "Lit"; break;
			case "HCRgBUHrb1": GENgBUHSt = "Lit"; break;
			case "HCRgBUFirb1": GENgBUFiSt = "Lit"; break;
		}
	}
	/**
	 * Method for setting the radio group to Medium
	 * @param input name for radio group
	 * @param btName name of button 
	 */
	public void setMedium(String input, String btName){
		switch (btName) {
			case "HCRgBURFrb2": GENgBURFSt = "Med"; break;
			case "HCRgBUFBrb2": GENgBUFBSt = "Med"; break;
			case "HCRgBUSDrb2": GENgBUSDSt = "Med"; break;
			case "HCRgBUHrb2": GENgBUHSt = "Med"; break;
			case "HCRgBUFirb2": GENgBUFiSt = "Med"; break;
		}
	}
	/**
	 * Method for setting the radio group to Heavy
	 * @param input name for radio group
	 * @param btName name of button 
	 */
	public void setHeavy(String input, String btName){
		switch (btName) {
			case "HCRgBURFrb3": GENgBURFSt = "Hvy"; break;
			case "HCRgBUFBrb3": GENgBUFBSt = "Hvy"; break;
			case "HCRgBUSDrb3": GENgBUSDSt = "Hvy"; break;
			case "HCRgBUHrb3": GENgBUHSt = "Hvy"; break;
			case "HCRgBUFirb3": GENgBUFiSt = "Hvy"; break;
		}
	}
	/**
	 * Method for setting the radio group to New when changing the label
	 * @param input name for radio group
	 * @param btName name of button 
	 */
	public void setNew(String input, String btName){
		switch (btName){		
		case "HCRhSRrb1": GENhSRSt = "New"; break;
		}
	}
	/**
	 * Method for setting the radio group to Update when changing the label
	 * @param input name for radio group
	 * @param btName name of button 
	 */
	public void setUp(String input, String btName){
		switch (btName){		
		case "HCRhSRrb2": GENhSRSt = "Update"; break;
		}
	}
/**
 	* Method for Capturing the screen as a file to save the report
 * @param fileName name for the file to be generated
 * @throws Exception listed for IO file not found exception
 */
	public void captureScreen(String fileName) throws Exception {
		Rectangle screenRectangle = new Rectangle(7, 45, 761, 1005);
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screenRectangle);
		ImageIO.write(image, "png", new File(fileName));
	}
	public static void main(String[] args){
		Application.launch(args);
		}
}
