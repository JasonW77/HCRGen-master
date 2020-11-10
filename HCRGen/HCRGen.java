/**
 *  * <h1>JavaDoc</h1>
 * 
 *  HCRGen application for generating Hood Cleaning Reports (or HCRGen.java).
 * 	I created this program for Tong's Fire Extinguisher Sales and Service to help them move from paper reports to an all digital report system.
 * 
 * Version 2.0 changes:
 * * A new report form the (RFSSR) Restaurant Fire System Service Report window has been added~
 * * * the report for (RFSSR) Restaurant Fire System Service Report has been added~
 * * The HCRGen start window, Customer Creation window, and Customer edit windows have been added.
 * * * this allows for a choice in reports and the customer information edit/add windows to be selected.
 * * the CusOb class has been added, this allows customer information to be saved.
 * 
 * Version 2.1 changes:
 * * TechOb class and the Administration class, this allows:
 * * multiple Technicians can now be created and saved.
 * * * a technician pane has been added to edit this information.
 * * business information is being moved to a file system.
 * * * an Administration pane has been added to give the client a place to edit this information.
 * * A search Function has been added to aid the client in searching for customer information.
 * * * a search report window has been added to readout the search results.
 * 	 
 * 
	<p>Date created 8/17/2020 <p/>
	<p>current Version release Date 10/9/2020 <p/>
	<p>Version 2.1 <p/>
	
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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.imageio.ImageIO;
import javafx.application.Application;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.print.JobSettings;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
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
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class HCRGen extends Application {
	static Font font = Font.font("Verdana", FontWeight.BOLD,FontPosture.ITALIC,10);
	static Font font2 = Font.font("Verdana", FontWeight.BOLD,FontPosture.ITALIC,15);
	static Map<String,Object> clientmap = new HashMap<>();
	static Map<String,Object> techmap = new HashMap<>();
	static Map<Integer,String> busmap = new HashMap<>();
	static Set<String> techlist = new HashSet<>();
	static Label jobStatus = new Label();
	static java.io.File mapFile = new java.io.File("HCRGen/Map/");
	static String mapFileLoc = mapFile.getAbsolutePath();
	static File MapFiledirectory = new File(mapFileLoc + "/" + "ClientList.bin");
	static File techMapFiledirectory = new File(mapFileLoc + "/" + "TechList.bin");
	static File busMapFiledirectory = new File(mapFileLoc + "/" + "BusIn.bin");
	
	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();
	int GENrepDate = 0000;
	int GENwhichTech = 0;
	static String curVerNum = "1.2";
	
	static Label version = new Label("SoftwareVersion");
	static Label curVer = new Label(curVerNum);
	
	static String GENBusinessName = "";
	static String GENBusinessAdd = "";
	static String GENBusinessCity = "";
	static String GENBusinessState = "";
	static String GENBusinessZipcode = "";
	static String GENBusinessPhone = "";
	static String GENBusinessEmail = "";
	static String GENBusinessLicense = "";
	static String GENBusinessPassword = "";
	static boolean passProtection = false;
	
	static String GENTechName = "";
	static String GENTechAdd = "";
	static String GENTechZip = "";
	static String GENTechCity = "";
	static String GENTechState = "";
	static String GENTechPhone = "";
	static String GENTechLic = "";
	/*
	String GENaddress1 = "P.O. Box 3101 \nCedar City, UT 84721";
	String GENaddress1p = "P.O. Box 3101";
	String GENaddress1c = "Cedar City,";
	String GENaddress1z = "UT 84721";
	String GENtech1p = "1-435-201-2182";
	String GENlicNumTech1 = "Lic. # KE82431";
	
	String GENaddress2 = "P.O. Box 135 \nElsinore, UT 84724";
	String GENaddress2p = "P.O. Box 135";
	String GENaddress2c = "Elsinore,";
	String GENaddress2z = "UT 84724";
	String GENtech2p = "1-435-896-3840";	
	String GENlicNumTech2 = "Lic. # KE113954";
	*/
	static String GENendTech1 = ""; //GENBusinessName + "\n" 
			//+ GENBusinessAdd + "\n" 
			//+ GENBusinessCity + GENBusinessState + GENBusinessZipcode + "\n" 	
			//+ GENBusinessPhone ;
	
	String GENphoneNum = "(435) 201-2182";
	
	String GENendTech1l = " ";
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
	String GENlabel32TG = "N/A";
	String GENWoDST = "N/A";
	String GENEoGST = "N/A";
	static String CUSTOBJFOCUS = "";
	
	LocalDate GENdateNow = LocalDate.now();
	LocalDate GENexecDate = GENdateNow.plusMonths(12);
	LocalDate GENNHTDDPDate;
	
	/** HCRGen Program Start window  
	 */
	public void start(Stage primaryStage) throws FileNotFoundException{	
		if (! busMapFiledirectory.exists()) {
			if(busmap.isEmpty() == true){
				System.out.println("No Business Info found, creating default attributes!");
				makeBus();
			}
		}else if(busMapFiledirectory.exists()) {
			try {
				System.out.println("Getting Business Info!");
				getBus();
			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}

		if (! techMapFiledirectory.exists()) {
			if(techmap.isEmpty() == true){
				System.out.println("\nNo Technician list found, creating default Technician!");
				makeTech();
			}
		}else if(techMapFiledirectory.exists()) {
			try {
				System.out.println("\nGetting Technician List!");
				getTech();
			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		if (! MapFiledirectory.exists()) {
			if(clientmap.isEmpty() == true){
				System.out.println("\nNo customer list found, creating default customer!");
				makeCust();
			}
		}else if(MapFiledirectory.exists()) {
			try {
				System.out.println("\nGetting Customer List!");
				getCust();
			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		
		//create ImageView for the Company logo and place in the grid
		File GENf = new File("TONGS-FIRE-EXTINGUISHER-SALES-AND-SERVICE.jpg");
		String GENfilLoc = GENf.getAbsolutePath();
		
		//Creating a Graphical Label
		Label GENStartWindowLogo = new Label();
			version.setFont(new Font("Kalam", 9));
		
		//Creating a graphic for the HCR window
		Image GENimg = new Image(new FileInputStream(GENfilLoc));

		ImageView GENview = new ImageView(GENimg);
			GENview.setFitHeight(200);
			GENview.setFitWidth(300);
			GENview.setPreserveRatio(false);
			
			GENStartWindowLogo.setGraphic(GENview);
		
		//Create Start Window and add its components
		ScrollPane GENstartWindow = new ScrollPane();
			GENstartWindow.setCache(false);
		
		VBox GENmainVB = new VBox();
		
		HBox GENCustHB = new HBox();
		HBox GENRepHB = new HBox();
			GENRepHB.setAlignment(Pos.BOTTOM_RIGHT);
			GENRepHB.setPadding(new Insets(20,20,20,20));
		HBox GENnewCustHB = new HBox();
		HBox GENCurVerHB = new HBox();
			GENCurVerHB.setAlignment(Pos.BOTTOM_RIGHT);
			GENCurVerHB.setPadding(new Insets(10,10,10,10));
			
		
		TextField GENCustNameTF = new TextField("Customer Name");
			GENCustNameTF.setPrefWidth(190);
		
		Button GENHCR = new Button("HCR");
			GENHCR.setFont(new Font("Arial", 9));
		Button GENRFSSR = new Button("RFSSR");
			GENRFSSR.setFont(new Font("Arial", 9));
		Button GENSRCHCustBT = new Button("SRCH");
			GENSRCHCustBT.setFont(new Font("Arial", 9));
		Button GENLISTCustBT = new Button("LIST");
			GENLISTCustBT.setFont(new Font("Arial", 9));
		Button GENAdminBT = new Button("Admin");
				
		Label GENCustTF = new Label("Customer: ");
			GENCustTF.setFont(new Font("Arial", 20));
		Label GENRepSel = new Label("Report to Generate: ");
			GENRepSel.setFont(new Font("Arial", 20));
		Label GENAddNewCust = new Label(" ");
			GENAddNewCust.setFont(new Font("Arial", 20));
		
		//Set Window Component Attributes
		VBox.setVgrow(GENstartWindow, Priority.ALWAYS);
		
			GENmainVB.setMinSize(325, 300);
			GENmainVB.setPadding(new Insets(10,10,10,10));
			GENmainVB.setAlignment(Pos.TOP_LEFT);
			
			GENCustHB.setPadding(new Insets(10,10,10,10));
			GENRepHB.setPadding(new Insets(10,10,10,10));
			GENnewCustHB.setPadding(new Insets(10,10,10,10));
			
			//Button SetOnAction functions
			GENHCR.setOnAction(e ->{
				CUSTOBJFOCUS = GENCustNameTF.getText();
							
				try {startHCR(primaryStage);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
			});
			
			GENRFSSR.setOnAction(e ->{
				CUSTOBJFOCUS = GENCustNameTF.getText();
				try {startRFSSR(primaryStage);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
			});
			
			GENSRCHCustBT.setOnAction(e -> 	{
				custSrch(GENCustNameTF.getText());
			});
			
			GENLISTCustBT.setOnAction(e -> {
				custList();
			});
			
			GENAdminBT.setOnAction(e -> {
				if(passProtection == false)
					try {startAdminWin(primaryStage);
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
				else if(passProtection == true)
					passwordCheckWin(primaryStage);
					
			});
			
			//Combine all components and add components to the Start Window
			GENCurVerHB.getChildren().addAll(version,curVer);
			GENCustHB.getChildren().addAll(GENCustTF, GENCustNameTF);
			GENRepHB.getChildren().addAll(GENHCR, GENRFSSR,GENSRCHCustBT,GENLISTCustBT);
			GENnewCustHB.getChildren().addAll(GENAddNewCust,GENAdminBT);
			GENmainVB.getChildren().addAll(GENStartWindowLogo,GENCustHB,GENRepHB, GENnewCustHB,GENCurVerHB);
			GENstartWindow.setContent(GENmainVB);
		
		Scene GENscene = new Scene(GENstartWindow , 400, 450);
		
			primaryStage.setTitle("HCRGen");
			primaryStage.setX(0);
			primaryStage.setY(0);
			primaryStage.setMinWidth(400);
			primaryStage.setMaxWidth(400);
			primaryStage.setMinHeight(450);
			primaryStage.setMaxHeight(450);
			primaryStage.setScene(GENscene);
			primaryStage.show();
	}
	
	/** Hood Cleaning Report Window HCR  
	 */
	public void startHCR(Stage primaryStage) throws FileNotFoundException{
		ScrollPane HCRsp = new ScrollPane();
			HCRsp.setCache(false);
		
		VBox HCRmainVB = new VBox();
			HCRmainVB.setMinSize(400, 400);
			HCRmainVB.setPadding(new Insets(10,10,10,10));
			HCRmainVB.setAlignment(Pos.TOP_CENTER);
		VBox.setVgrow(HCRsp, Priority.ALWAYS);
			HCRsp.setContent(HCRmainVB);
		VBox HCRvb1 = new VBox();
			HCRvb1.setAlignment(Pos.TOP_LEFT);
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

		/* Items that go in HCRhb1 go here
		 * Imageview of logo
		 * Business Info
		 * Invoice box
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

		//create report form Title labels
		Label HCRtitle1 = new Label("Hood"); 
			HCRtitle1.setFont(new Font("Cambria", 20));
		Label HCRtitle2 = new Label("Cleaning");	
			HCRtitle2.setFont(new Font("Cambria", 20));
		Label HCRtitle3 = new Label("Report");
			HCRtitle3.setFont(new Font("Cambria", 20));
		Label HCRtitle4 = new Label("Form");	
			HCRtitle4.setFont(new Font("Cambria", 20));
		Label HCRtitlespare = new Label();	
			HCRtitlespare.setFont(new Font("Cambria", 20));
		
			//Create Address VBox for Business information
			HCRvb1.getChildren().addAll(HCRtitle1, HCRtitle2, HCRtitle3, HCRtitle4, HCRtitlespare);
		
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
		
		/* Items that go in HCRhb2 and go here
		 * Service Info Box
		 * Customer Info Box
		 */
		//Create Service Schedule Information box
		Label HCRservSchLabel = new Label(" Service Scheduled with: ");
		Label HCRstoreCMLabel = new Label(" Store Closing Manager: ");
		Label HCRdateOSLabel = new Label(" Date of Service: ");
		Label HCRserviceELabel = new Label(" Service Frequency ");
		Label HCRtimeOSLabel = new Label(" Time of Service: ");
	
		TextField HCRservSchTF = new TextField(((CusOb) clientmap.get(CUSTOBJFOCUS)).getSSw());
			HCRservSchTF.setMinWidth(205);
			HCRservSchTF.setFont(new Font("Cambria", 10));
		TextField HCRstoreCMTF = new TextField(((CusOb) clientmap.get(CUSTOBJFOCUS)).getSCM());
			HCRstoreCMTF.setFont(new Font("Cambria", 10));
			HCRstoreCMTF.setMaxWidth(275);
		TextField HCRtimeOSTF = new TextField("24:00");
			HCRtimeOSTF.setFont(new Font("Cambria", 10));
			HCRtimeOSTF.setMaxWidth(75);
		
		DatePicker HCRdateOSDP = new DatePicker(GENdateNow);
		
		ComboBox<String> HCRserviceECB = new ComboBox<String>();
			HCRserviceECB.setValue(((CusOb) clientmap.get(CUSTOBJFOCUS)).getSF());
			HCRserviceECB.getItems().addAll("Annually", "Bi-Annually", "Quarterly");
		
		GridPane HCRservGrid = new GridPane();
			HCRservGrid.setMinSize(400, 100);
			HCRservGrid.setAlignment(Pos.TOP_LEFT);
			
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
	
		//Create Second row of boxes for Customer information and place them on the grid
		Label HCRcustPhoneLabel = new Label(" Phone: ");
		Label HCRcustEmailLabel = new Label(" Email: ");
		Label HCRcustNameLabel = new Label(" Client: ");
		Label HCRcustAdrLabel = new Label(" Address: ");
		Label HCRcustAdrCityLabel = new Label(" City: ");
		Label HCRcustAdrStateLabel = new Label(" State: ");
		Label HCRcustAdrZipLabel = new Label(" Zip: ");
		
		TextField HCRtfcustPhone = new TextField(((CusOb) clientmap.get(CUSTOBJFOCUS)).getPhone());
			HCRtfcustPhone.setFont(new Font("Cambria", 10));
			HCRtfcustPhone.setMaxWidth(115);
		TextField HCRcustEmailTF = new TextField(((CusOb) clientmap.get(CUSTOBJFOCUS)).getEmail());
			HCRcustEmailTF.setFont(new Font("Cambria", 10));
			HCRcustEmailTF.setMaxWidth(115);
		TextField HCRtfcustName = new TextField(((CusOb) clientmap.get(CUSTOBJFOCUS)).getClient());
			HCRtfcustName.setFont(new Font("Cambria", 10));
			HCRtfcustName.setMinWidth(205);
		TextField HCRtfcustAdr = new TextField(((CusOb) clientmap.get(CUSTOBJFOCUS)).getAddress());
			HCRtfcustAdr.setFont(new Font("Cambria", 10));
			HCRtfcustAdr.setMaxWidth(275);
		TextField HCRtfcustAdrCity = new TextField(((CusOb) clientmap.get(CUSTOBJFOCUS)).getCity());
			HCRtfcustAdrCity.setFont(new Font("Cambria", 10));
			HCRtfcustAdrCity.setMaxWidth(115);
		TextField HCRtfcustAdrState = new TextField(((CusOb) clientmap.get(CUSTOBJFOCUS)).getState());
			HCRtfcustAdrState.setFont(new Font("Cambria", 10));
			HCRtfcustAdrState.setMaxWidth(115);
		TextField HCRtfcustAdrZip = new TextField(((CusOb) clientmap.get(CUSTOBJFOCUS)).getZip());
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
			
			HCRcustGrid.add(HCRcustEmailLabel,0,6);
			HCRcustGrid.add(HCRcustEmailTF,1,6);
			
			HCRhb2.setAlignment(Pos.TOP_LEFT);
			
			HCRhb2.getChildren().addAll(HCRservGrid, HCRcustGrid);
			
		/* Items that go in HCRvb2 go here
		 * Notes to technicians *servLabel7*
		 * TextArea *taServ1*
		 */
		//Create cleaning notes text area and label
		TextArea HCRtaServ1 = new TextArea();
			HCRtaServ1.setCache(false);
			HCRtaServ1.setWrapText(true);
			HCRtaServ1.setPrefHeight(50);
			HCRtaServ1.setMaxWidth(750);

		Label HCRservLabel7 = new Label(" Notes for cleaning technicians: ");
		
			HCRvb2.getChildren().addAll(HCRservLabel7, HCRtaServ1);
		
		/* Items that go in HCRhb3 go here
		 * cleaning notice label *cLNOLabel*
		 */
		//Create the cleaning notice and place it in the grid
		Label HCRclNoLabel = new Label("All cleaning is in accordance with the local fire codes and/or NFPA Standard Code #96. This courtesy follow-up report is provided as a free customer service only; it is not a paid consultation. The inspection of the exhaust system is limited to the possible need for improved access and cleaning only. Other deficiencies, whether reported or not, are beyond the scope of our cleaning crew's knowledge. It is the owner of the exhaust system's responsibility to take appropriate action to modify any deficiencies noted herein or elsewhere.");
			HCRclNoLabel.setFont(new Font("Cambria", 10));
			HCRclNoLabel.setMaxWidth(750);
			HCRclNoLabel.setWrapText(true);
			//HCRhb3.getChildren().add(HCRclNoLabel);
		

		/* Items that go in HCRvb3 go here
		 * Kitchen Exhaust Cleaning Service Report Title bar
		 * Initial service check boxes
		 */
		//Create the kitchen cleaning service report boxes and place them in the grid
		Label HCRkECSRLabel = new Label("KITCHEN EXHAUST CLEANING SERVICE REPORT");
		
		RadioButton HCRiScb = new RadioButton("INITIAL SERVICE ");
		RadioButton HCRrScb = new RadioButton("REGULAR SERVICE ");
		RadioButton HCRiNcb = new RadioButton("INSPECTION ");
		
			HCRhb4.getChildren().addAll(HCRiScb, HCRrScb, HCRiNcb);
			HCRvb3.getChildren().addAll(HCRkECSRLabel, HCRhb4);
			
		/* Items that go in HCRhb5 go here
		 * Check In Box
		 * Check Out Box
		 */
		//Check In Box
		Label HCRcheckInLabel = new Label("Check In: ");
		Label HCRcIYLabel = new Label("Yes ");
			HCRcIYLabel.setFont(new Font("Cambria", 10));
		Label HCRcINLabel = new Label("No");
			HCRcINLabel.setFont(new Font("Cambria", 10));
		Label HCRcINALabel = new Label("N/A");
			HCRcINALabel.setFont(new Font("Cambria", 10));
		Label HCRlightLabel = new Label("Light ");
			HCRlightLabel.setFont(new Font("Cambria", 8));
		Label HCRmediumLabel = new Label("Med ");
			HCRmediumLabel.setFont(new Font("Cambria", 8));
		Label HCRheavyLabel = new Label("Heavy");
			HCRheavyLabel.setFont(new Font("Cambria", 8));
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
		RadioButton HCRdKWrb3 = new RadioButton();
			HCRdKWrb3.setToggleGroup(HCRdkW);
		
		ToggleGroup HCRfWP = new ToggleGroup();
		RadioButton HCRfWPrb1 = new RadioButton();
			HCRfWPrb1.setToggleGroup(HCRfWP);
		RadioButton HCRfWPrb2 = new RadioButton();
			HCRfWPrb2.setToggleGroup(HCRfWP);
		RadioButton HCRfWPrb3 = new RadioButton();
			HCRfWPrb3.setToggleGroup(HCRfWP);
		
		ToggleGroup HCRdIF = new ToggleGroup();
		RadioButton HCRdIFrb1 = new RadioButton();
			HCRdIFrb1.setToggleGroup(HCRdIF);
		RadioButton HCRdIFrb2 = new RadioButton();
			HCRdIFrb2.setToggleGroup(HCRdIF);
		RadioButton HCRdIFrb3 = new RadioButton();
			HCRdIFrb3.setToggleGroup(HCRdIF);
		
		ToggleGroup HCRaFH = new ToggleGroup();
		RadioButton HCRaFHrb1 = new RadioButton();
			HCRaFHrb1.setToggleGroup(HCRaFH);
		RadioButton HCRaFHrb2 = new RadioButton();
			HCRaFHrb2.setToggleGroup(HCRaFH);
		RadioButton HCRaFHrb3 = new RadioButton();
			HCRaFHrb3.setToggleGroup(HCRaFH);
		
		ToggleGroup HCRfDW = new ToggleGroup();
		RadioButton HCRfDWrb1 = new RadioButton();
			HCRfDWrb1.setToggleGroup(HCRfDW);
		RadioButton HCRfDWrb2 = new RadioButton();
			HCRfDWrb2.setToggleGroup(HCRfDW);
		RadioButton HCRfDWrb3 = new RadioButton();
			HCRfDWrb3.setToggleGroup(HCRfDW);
		
		ToggleGroup HCRhLW = new ToggleGroup();
		RadioButton HCRhLWrb1 = new RadioButton();
			HCRhLWrb1.setToggleGroup(HCRhLW);
		RadioButton HCRhLWrb2 = new RadioButton();
			HCRhLWrb2.setToggleGroup(HCRhLW);
		RadioButton HCRhLWrb3 = new RadioButton();
			HCRhLWrb3.setToggleGroup(HCRhLW);
		
		ToggleGroup HCRhGP = new ToggleGroup();
		RadioButton HCRhGPrb1 = new RadioButton();
			HCRhGPrb1.setToggleGroup(HCRhGP);
		RadioButton HCRhGPrb2 = new RadioButton();
			HCRhGPrb2.setToggleGroup(HCRhGP);
		RadioButton HCRhGPrb3 = new RadioButton();
			HCRhGPrb3.setToggleGroup(HCRhGP);
		
		ToggleGroup HCRrTCS = new ToggleGroup();
		RadioButton HCRrTCSrb1 = new RadioButton();
			HCRrTCSrb1.setToggleGroup(HCRrTCS);
		RadioButton HCRrTCSrb2 = new RadioButton();
			HCRrTCSrb2.setToggleGroup(HCRrTCS);
		RadioButton HCRrTCSrb3 = new RadioButton();
			HCRrTCSrb3.setToggleGroup(HCRrTCS);
		
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
			HCRcIBGrid.add(HCRcINALabel,3,0);
			
			HCRcIBGrid.add(HCRdKWLabel,0,1);
			HCRcIBGrid.add(HCRdKWrb1,1,1);
			HCRcIBGrid.add(HCRdKWrb2,2,1);
			HCRcIBGrid.add(HCRdKWrb3,3,1);
			
			HCRcIBGrid.add(HCRfWPLabel,0,2);
			HCRcIBGrid.add(HCRfWPrb1,1,2);
			HCRcIBGrid.add(HCRfWPrb2,2,2);
			HCRcIBGrid.add(HCRfWPrb3,3,2);
			
			HCRcIBGrid.add(HCRdIFWLabel,0,3);
			HCRcIBGrid.add(HCRdIFrb1,1,3);
			HCRcIBGrid.add(HCRdIFrb2,2,3);
			HCRcIBGrid.add(HCRdIFrb3,3,3);
			
			HCRcIBGrid.add(HCRaFHLabel,0,4);
			HCRcIBGrid.add(HCRaFHrb1,1,4);
			HCRcIBGrid.add(HCRaFHrb2,2,4);
			HCRcIBGrid.add(HCRaFHrb3,3,4);
			
			HCRcIBGrid.add(HCRfDWLabel,0,5);
			HCRcIBGrid.add(HCRfDWrb1,1,5);
			HCRcIBGrid.add(HCRfDWrb2,2,5);
			HCRcIBGrid.add(HCRfDWrb3,3,5);
			
			HCRcIBGrid.add(HCRhLWLabel,0,6);
			HCRcIBGrid.add(HCRhLWrb1,1,6);
			HCRcIBGrid.add(HCRhLWrb2,2,6);
			HCRcIBGrid.add(HCRhLWrb3,3,6);
			
			HCRcIBGrid.add(HCRhGPLabel,0,7);
			HCRcIBGrid.add(HCRhGPrb1,1,7);
			HCRcIBGrid.add(HCRhGPrb2,2,7);
			HCRcIBGrid.add(HCRhGPrb3,3,7);
			
			HCRcIBGrid.add(HCRrTCSLabel,0,8);
			HCRcIBGrid.add(HCRrTCSrb1,1,8);
			HCRcIBGrid.add(HCRrTCSrb2,2,8);
			HCRcIBGrid.add(HCRrTCSrb3,3,8);
			
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
		Label HCRcNALabel = new Label("N/A");
			HCRcNALabel.setFont(new Font("Cambria", 10));
		Label HCRcONewLabel = new Label("New");
			HCRcONewLabel.setFont(new Font("Cambria", 8));
		Label HCRcOULabel = new Label("Updated");
			HCRcOULabel.setFont(new Font("Cambria", 8));	
		Label HCRmoreHoods = new Label("Hood Description");
			HCRmoreHoods.setFont(new Font("Cambria", 10));
			HCRmoreHoods.setMaxWidth(115);
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

		TextField HCRmoreHoods2 = new TextField();
			HCRmoreHoods2.setFont(new Font("Cambria", 10));
			HCRmoreHoods2.setMaxWidth(200);
		
		ToggleGroup HCRfWLR = new ToggleGroup();
		RadioButton HCRfWLRrb1 = new RadioButton();
			HCRfWLRrb1.setToggleGroup(HCRfWLR);
		RadioButton HCRfWLRrb2 = new RadioButton();
			HCRfWLRrb2.setToggleGroup(HCRfWLR);
		RadioButton HCRfWLRrb3 = new RadioButton();
			HCRfWLRrb3.setToggleGroup(HCRfWLR);
		
		ToggleGroup HCRrANFRO = new ToggleGroup();
		RadioButton HCRrANFROrb1 = new RadioButton();
			HCRrANFROrb1.setToggleGroup(HCRrANFRO);
		RadioButton HCRrANFROrb2 = new RadioButton();
			HCRrANFROrb2.setToggleGroup(HCRrANFRO);
		RadioButton HCRrANFROrb3 = new RadioButton();
			HCRrANFROrb3.setToggleGroup(HCRrANFRO);
	
		ToggleGroup HCRhIWD = new ToggleGroup();
		RadioButton HCRhIWDrb1 = new RadioButton();
			HCRhIWDrb1.setToggleGroup(HCRhIWD);
		RadioButton HCRhIWDrb2 = new RadioButton();
			HCRhIWDrb2.setToggleGroup(HCRhIWD);
		RadioButton HCRhIWDrb3 = new RadioButton();
			HCRhIWDrb3.setToggleGroup(HCRhIWD);
			
		ToggleGroup HCRkFCEWD = new ToggleGroup();
		RadioButton HCRkFCEWDrb1 = new RadioButton();
			HCRkFCEWDrb1.setToggleGroup(HCRkFCEWD);
		RadioButton HCRkFCEWDrb2 = new RadioButton();
			HCRkFCEWDrb2.setToggleGroup(HCRkFCEWD);
		RadioButton HCRkFCEWDrb3 = new RadioButton();
			HCRkFCEWDrb3.setToggleGroup(HCRkFCEWD);
		
		ToggleGroup HCRoARC = new ToggleGroup();
		RadioButton HCRoARCrb1 = new RadioButton();
			HCRoARCrb1.setToggleGroup(HCRoARC);
		RadioButton HCRoARCrb2 = new RadioButton();
			HCRoARCrb2.setToggleGroup(HCRoARC);
		RadioButton HCRoARCrb3 = new RadioButton();
			HCRoARCrb3.setToggleGroup(HCRoARC);
	
		ToggleGroup HCRhSFPW = new ToggleGroup();
		RadioButton HCRhSFPWrb1 = new RadioButton();
			HCRhSFPWrb1.setToggleGroup(HCRhSFPW);
		RadioButton HCRhSFPWrb2 = new RadioButton();
			HCRhSFPWrb2.setToggleGroup(HCRhSFPW);
		RadioButton HCRhSFPWrb3 = new RadioButton();
			HCRhSFPWrb3.setToggleGroup(HCRhSFPW);
		
		ToggleGroup HCRhDGL = new ToggleGroup();
		RadioButton HCRhDGLrb1 = new RadioButton();
			HCRhDGLrb1.setToggleGroup(HCRhDGL);
		RadioButton HCRhDGLrb2 = new RadioButton();
			HCRhDGLrb2.setToggleGroup(HCRhDGL);
		RadioButton HCRhDGLrb3 = new RadioButton();
			HCRhDGLrb3.setToggleGroup(HCRhDGL);
		
		ToggleGroup HCRaPGQ = new ToggleGroup();
		RadioButton HCRaPGQrb1 = new RadioButton();
			HCRaPGQrb1.setToggleGroup(HCRaPGQ);
		RadioButton HCRaPGQrb2 = new RadioButton();
			HCRaPGQrb2.setToggleGroup(HCRaPGQ);
		RadioButton HCRaPGQrb3 = new RadioButton();
			HCRaPGQrb3.setToggleGroup(HCRaPGQ);
		
		ToggleGroup HCRsDWT = new ToggleGroup();
		RadioButton HCRsDWTrb1 = new RadioButton();
			HCRsDWTrb1.setToggleGroup(HCRsDWT);
		RadioButton HCRsDWTrb2 = new RadioButton();
			HCRsDWTrb2.setToggleGroup(HCRsDWT);
		RadioButton HCRsDWTrb3 = new RadioButton();
			HCRsDWTrb3.setToggleGroup(HCRsDWT);
		
		ToggleGroup HCRpLR = new ToggleGroup();
		RadioButton HCRpLRrb1 = new RadioButton();
			HCRpLRrb1.setToggleGroup(HCRpLR);
		RadioButton HCRpLRrb2 = new RadioButton();
			HCRpLRrb2.setToggleGroup(HCRpLR);
		RadioButton HCRpLRrb3 = new RadioButton();
			HCRpLRrb3.setToggleGroup(HCRpLR);
		
		ToggleGroup HCRhSR = new ToggleGroup();
		RadioButton HCRhSRrb1 = new RadioButton();
			HCRhSRrb1.setToggleGroup(HCRhSR);
		RadioButton HCRhSRrb2 = new RadioButton();
			HCRhSRrb2.setToggleGroup(HCRhSR);
		RadioButton HCRhSRrb3 = new RadioButton();
			HCRhSRrb3.setToggleGroup(HCRhSR);
		
		ToggleGroup HCRphotoT = new ToggleGroup();
		RadioButton HCRphotoTrb1 = new RadioButton();
			HCRphotoTrb1.setToggleGroup(HCRphotoT);
		RadioButton HCRphotoTrb2 = new RadioButton();
			HCRphotoTrb2.setToggleGroup(HCRphotoT);
		RadioButton HCRphotoTrb3 = new RadioButton();
			HCRphotoTrb3.setToggleGroup(HCRphotoT);
		
		GridPane HCRcOBGrid = new GridPane();
			HCRcOBGrid.add(HCRcheckOutLabel,0,0);
			HCRcOBGrid.add(HCRcOYLabel,1,0);
			HCRcOBGrid.add(HCRcONLabel,2,0);
			HCRcOBGrid.add(HCRcNALabel,3,0);
			
			HCRcOBGrid.add(HCRfWLRLabel,0,1);
			HCRcOBGrid.add(HCRfWLRrb1,1,1);
			HCRcOBGrid.add(HCRfWLRrb2,2,1);
			HCRcOBGrid.add(HCRfWLRrb3,3,1);
					
			HCRcOBGrid.add(HCRrANFROLabel,0,2);
			HCRcOBGrid.add(HCRrANFROrb1,1,2);
			HCRcOBGrid.add(HCRrANFROrb2,2,2);
			HCRcOBGrid.add(HCRrANFROrb3,3,2);
					
			HCRcOBGrid.add(HCRhIWDLabel,0,3);
			HCRcOBGrid.add(HCRhIWDrb1,1,3);
			HCRcOBGrid.add(HCRhIWDrb2,2,3);
			HCRcOBGrid.add(HCRhIWDrb3,3,3);
					
			HCRcOBGrid.add(HCRkFCEWDLabel,0,4);
			HCRcOBGrid.add(HCRkFCEWDrb1,1,4);
			HCRcOBGrid.add(HCRkFCEWDrb2,2,4);
			HCRcOBGrid.add(HCRkFCEWDrb3,3,4);
					
			HCRcOBGrid.add(HCRoARCLabel,0,5);
			HCRcOBGrid.add(HCRoARCrb1,1,5);
			HCRcOBGrid.add(HCRoARCrb2,2,5);
			HCRcOBGrid.add(HCRoARCrb3,3,5);
					
			HCRcOBGrid.add(HCRhSFPWLabel,0,6);
			HCRcOBGrid.add(HCRhSFPWrb1,1,6);
			HCRcOBGrid.add(HCRhSFPWrb2,2,6);
			HCRcOBGrid.add(HCRhSFPWrb3,3,6);
					
			HCRcOBGrid.add(HCRhDGLLabel,0,7);
			HCRcOBGrid.add(HCRhDGLrb1,1,7);
			HCRcOBGrid.add(HCRhDGLrb2,2,7);
			HCRcOBGrid.add(HCRhDGLrb3,3,7);
					
			HCRcOBGrid.add(HCRaPGQLabel,0,8);
			HCRcOBGrid.add(HCRaPGQrb1,1,8);
			HCRcOBGrid.add(HCRaPGQrb2,2,8);
			HCRcOBGrid.add(HCRaPGQrb3,3,8);
					
			HCRcOBGrid.add(HCRsDWTLabel,0,9);
			HCRcOBGrid.add(HCRsDWTrb1,1,9);
			HCRcOBGrid.add(HCRsDWTrb2,2,9);
			HCRcOBGrid.add(HCRsDWTrb3,3,9);
					
			HCRcOBGrid.add(HCRpLRLabel,0,10);
			HCRcOBGrid.add(HCRpLRrb1,1,10);
			HCRcOBGrid.add(HCRpLRrb2,2,10);
			HCRcOBGrid.add(HCRpLRrb3,3,10);
					
			HCRcOBGrid.add(HCRphotoTLabel,0,11);
			HCRcOBGrid.add(HCRphotoTrb1,1,11);
			HCRcOBGrid.add(HCRphotoTrb2,2,11);
			HCRcOBGrid.add(HCRphotoTrb3,3,11);
					
			HCRcOBGrid.add(HCRcONewLabel,1,12);
			HCRcOBGrid.add(HCRcOULabel,3,12);
			
			HCRcOBGrid.add(HCRhSRLabel,0,13);
			HCRcOBGrid.add(HCRhSRrb1,1,13);
			HCRcOBGrid.add(HCRhSRrb2,3,13);
			
			HCRcOBGrid.add(HCRinAccCB,0,14);
			
			HCRcOBGrid.add(HCRmoreHoods,0,15);
			HCRcOBGrid.add(HCRmoreHoods2,0,16);
			
			HCRhb5.getChildren().addAll(HCRcIBGrid, HCRcOBGrid);
		
		/* Items that go in HCRhb6 go here
		 * Time in Time out boxes 
		 */
		Label HCRtILabel = new Label("TIME IN: ");
		Label HCRtOLabel = new Label("TIME OUT: ");
		
		TextField HCRtfTI = new TextField("24:00");
			HCRtfTI.setFont(new Font("Cambria", 10));
			HCRtfTI.setMaxWidth(80);
		TextField HCRtfTO = new TextField("24:00");
			HCRtfTO.setFont(new Font("Cambria", 10));
			HCRtfTO.setMaxWidth(80);
			
			HCRhb6.getChildren().addAll(HCRtILabel, HCRtfTI, HCRtOLabel, HCRtfTO);
		
		/* Items that go in HCRhb7 go here
		 * Miscellaneous notes text field
		 * Acknowledgement box
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
		
		TextArea HCRmiscNotTa = new TextArea();
			HCRmiscNotTa.setCache(false);
			HCRmiscNotTa.setWrapText(true);
			HCRmiscNotTa.setFont(new Font("Cambria", 10));
			HCRmiscNotTa.setWrapText(true);
			HCRmiscNotTa.setMaxWidth(375);
			HCRmiscNotTa.setMaxHeight(100);

		ComboBox<String> HCRtechtf = new ComboBox<String>();
			HCRtechtf.getItems().addAll(techlist);
			
		TextField HCRcustSigntf = new TextField("____________________________________________________________                    Date:_________________________\n");
			HCRcustSigntf.setFont(new Font("Cambria", 10));
		Button HCRbtPreView = new Button("Preview");
		Button HCRBackBT = new Button("Return to Main Menu");
			HCRBackBT.setOnAction(e ->{
				try {start(primaryStage);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			});
		Button HCRbtPrint = new Button("Print");
		CheckBox HCRkeyCB = new CheckBox("Key ");
		CheckBox HCRnoAvailCB = new CheckBox("No one available to sign ");

		
			HCRhb7.getChildren().addAll(HCRvb4, HCRvb5);
			HCRhb8.getChildren().addAll(HCRkeyCB, HCRnoAvailCB);
			HCRhb9.getChildren().addAll(HCRtechSigLabel,HCRtechtf);
			HCRhb10.getChildren().addAll(HCRbtPreView, HCRBackBT);
			
			HCRvb4.getChildren().addAll(HCRmiscNotLabel, HCRmiscNotTa);
			HCRvb5.getChildren().addAll(HCRhb9, HCRhb11, HCRhb8);
			
			//OnAction events for radio buttons and check boxes
			HCRdKWrb1.setOnAction(e -> {setYes(GENdkWSt, "HCRdKWrb1"); });
			HCRdKWrb2.setOnAction(e -> {setNo(GENdkWSt, "HCRdKWrb2"); });
			HCRdKWrb3.setOnAction(e -> {setNo(GENdkWSt, "HCRdKWrb3"); });
					
			HCRfWPrb1.setOnAction(e -> {setYes(GENdkWSt, "HCRfWPrb1"); });
			HCRfWPrb2.setOnAction(e -> {setNo(GENdkWSt, "HCRfWPrb2"); });
			HCRfWPrb3.setOnAction(e -> {setNo(GENdkWSt, "HCRfWPrb3"); });
			
			HCRdIFrb1.setOnAction(e -> {setYes(GENdIFSt, "HCRdIFrb1"); });
			HCRdIFrb2.setOnAction(e -> {setNo(GENdIFSt, "HCRdIFrb2"); });
			HCRdIFrb3.setOnAction(e -> {setNo(GENdIFSt, "HCRdIFrb3"); });
			
			HCRaFHrb1.setOnAction(e -> {setYes(GENaFHSt, "HCRaFHrb1"); });
			HCRaFHrb2.setOnAction(e -> {setNo(GENaFHSt, "HCRaFHrb2"); });
			HCRaFHrb3.setOnAction(e -> {setNo(GENaFHSt, "HCRaFHrb3"); });
			
			HCRfDWrb1.setOnAction(e -> {setYes(GENfDWSt, "HCRfDWrb1"); });
			HCRfDWrb2.setOnAction(e -> {setNo(GENfDWSt, "HCRfDWrb2"); });
			HCRfDWrb3.setOnAction(e -> {setNo(GENfDWSt, "HCRfDWrb3"); });
			
			HCRhLWrb1.setOnAction(e -> {setYes(GENhLWSt, "HCRhLWrb1"); });
			HCRhLWrb2.setOnAction(e -> {setNo(GENhLWSt, "HCRhLWrb2"); });
			HCRhLWrb3.setOnAction(e -> {setNo(GENhLWSt, "HCRhLWrb3"); });
			
			HCRhGPrb1.setOnAction(e -> {setYes(GENhGPSt, "HCRhGPrb1"); });
			HCRhGPrb2.setOnAction(e -> {setNo(GENhGPSt, "HCRhGPrb2"); });
			HCRhGPrb3.setOnAction(e -> {setNo(GENhGPSt, "HCRhGPrb3"); });
			
			HCRrTCSrb1.setOnAction(e -> {setYes(GENrTCSSt, "HCRrTCSrb1"); });
			HCRrTCSrb2.setOnAction(e -> {setNo(GENrTCSSt, "HCRrTCSrb2"); });
			HCRrTCSrb3.setOnAction(e -> {setNo(GENrTCSSt, "HCRrTCSrb3"); });
			
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
			HCRfWLRrb3.setOnAction(e -> {setNo(GENfWLRSt, "HCRfWLRrb3"); });
			
			HCRrANFROrb1.setOnAction(e -> {setYes(GENrANFROSt, "HCRrANFROrb1"); });
			HCRrANFROrb2.setOnAction(e -> {setNo(GENrANFROSt, "HCRrANFROrb2"); });
			HCRrANFROrb3.setOnAction(e -> {setNo(GENrANFROSt, "HCRrANFROrb3"); });
			
			HCRhIWDrb1.setOnAction(e -> {setYes(GENhIWDSt, "HCRhIWDrb1"); });
			HCRhIWDrb2.setOnAction(e -> {setNo(GENhIWDSt, "HCRhIWDrb2"); });
			HCRhIWDrb3.setOnAction(e -> {setNo(GENhIWDSt, "HCRhIWDrb3"); });
			
			HCRkFCEWDrb1.setOnAction(e -> {setYes(GENkFCEWDSt, "HCRHCRkFCEWDrb1"); });
			HCRkFCEWDrb2.setOnAction(e -> {setNo(GENkFCEWDSt, "HCRkFCEWDrb2"); });
			HCRkFCEWDrb3.setOnAction(e -> {setNo(GENkFCEWDSt, "HCRkFCEWDrb3"); });
			
			HCRoARCrb1.setOnAction(e -> {setYes(GENoARCSt, "HCRoARCrb1"); });
			HCRoARCrb2.setOnAction(e -> {setNo(GENoARCSt, "HCRoARCrb2"); });
			HCRoARCrb3.setOnAction(e -> {setNo(GENoARCSt, "HCRoARCrb3"); });
			
			HCRhSFPWrb1.setOnAction(e -> {setYes(GENhSFPWSt, "HCRhSFPWrb1"); });
			HCRhSFPWrb2.setOnAction(e -> {setNo(GENhSFPWSt, "HCRhSFPWrb2"); });
			HCRhSFPWrb3.setOnAction(e -> {setNo(GENhSFPWSt, "HCRhSFPWrb3"); });
			
			HCRhDGLrb1.setOnAction(e -> {setYes(GENhDGLSt, "HCRhDGLrb1"); });
			HCRhDGLrb2.setOnAction(e -> {setNo(GENhDGLSt, "HCRhDGLrb2"); });
			HCRhDGLrb3.setOnAction(e -> {setNo(GENhDGLSt, "HCRhDGLrb3"); });
			
			HCRaPGQrb1.setOnAction(e -> {setYes(GENaPGQSt, "HCRaPGQrb1"); });
			HCRaPGQrb2.setOnAction(e -> {setNo(GENaPGQSt, "HCRaPGQrb2"); });
			HCRaPGQrb3.setOnAction(e -> {setNo(GENaPGQSt, "HCRaPGQrb3"); });
			
			HCRsDWTrb1.setOnAction(e -> {setYes(GENsDWTSt, "HCRsDWTrb1"); });
			HCRsDWTrb2.setOnAction(e -> {setNo(GENsDWTSt, "HCRsDWTrb2"); });
			HCRsDWTrb3.setOnAction(e -> {setNo(GENsDWTSt, "HCRsDWTrb3"); });
			
			HCRpLRrb1.setOnAction(e -> {setYes(GENpLRSt, "HCRpLRrb1"); });
			HCRpLRrb2.setOnAction(e -> {setNo(GENpLRSt, "HCRpLRrb2"); });
			HCRpLRrb3.setOnAction(e -> {setNo(GENpLRSt, "HCRpLRrb3"); });
			
			HCRhSRrb1.setOnAction(e -> {setNew(GENhSRSt, "HCRhSRrb1"); });
			HCRhSRrb2.setOnAction(e -> {setUp(GENhSRSt, "HCRhSRrb2"); });
			HCRhSRrb3.setOnAction(e -> {setUp(GENhSRSt, "HCRhSRrb3"); });
			
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
	        	GENTechName = ((TechOb) techmap.get(HCRtechtf.getValue())).getTechName();
	        	GENTechAdd = ((TechOb) techmap.get(HCRtechtf.getValue())).getTechAdd();
	        	GENTechZip = ((TechOb) techmap.get(HCRtechtf.getValue())).getTechZip();
	        	GENTechCity = ((TechOb) techmap.get(HCRtechtf.getValue())).getTechCity();
	        	GENTechState = ((TechOb) techmap.get(HCRtechtf.getValue())).getTechState();
	        	GENTechPhone = ((TechOb) techmap.get(HCRtechtf.getValue())).getTechPhone();
	        	GENTechLic = ((TechOb) techmap.get(HCRtechtf.getValue())).getTechLic();
	        	
	        	GENendTech1 = GENTechName + "\n" 
	        			+ GENTechAdd + "\n" 
	        			+ GENTechCity + ", " + GENTechState + " " + GENTechZip + "\n" 
	        			+ GENTechPhone + "\n" 
	        			+ "License #" + GENTechLic;
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
					HCRcustSigntf.setText("____________________________________________________________                    Date:_________________________\n");
			}});
			
			//send image of GUI to file.
	        HCRbtPreView.setOnAction(e -> {
				String HCRcustadd1na = HCRtfcustName.getText().trim();
				String HCRcustadd1po = HCRtfcustAdr.getText().trim();
				String HCRcustadd1csz = HCRtfcustAdrCity.getText().trim() + ", " + HCRtfcustAdrState.getText().trim() + ", " +HCRtfcustAdrZip.getText().trim();
				String HCRcustadd1ph = HCRtfcustPhone.getText().trim();
				String HCRcustadd1email = HCRcustEmailTF.getText().trim();
				String HCRcustSignSt = HCRcustSigntf.getText();
				
				if (GENrepDate != 0000) {
					System.out.println(GENrepDate);
					GENrepDate = HCRdateOSDP.getValue().getYear();
				}
					
				StackPane HCRprintBtStage = new StackPane();
					
				Button HCRcancel = new Button("Close Preview");
	
				TextArea HCRprintTa = new TextArea();
					HCRprintTa.setCache(false);
					HCRprintTa.setMinHeight(height);
					HCRprintTa.setMinWidth(775);
					HCRprintTa.setMaxWidth(775);
					HCRprintTa.setEditable(false);
				TextArea HCRprintTitleTa = new TextArea("KITCHEN EXHAUST HOOD CLEANING REPORT");
					HCRprintTitleTa.setFont(font2);
					HCRprintTitleTa.setCache(false);
					HCRprintTitleTa.setMinHeight(30);
					HCRprintTitleTa.setMaxHeight(30);
					HCRprintTitleTa.setMinWidth(410);
					HCRprintTitleTa.setMaxWidth(410);
					HCRprintTitleTa.setEditable(false);
					HCRprintTitleTa.setStyle("-fx-highlight-fill: #7ecfff;"
							+"-fx-focus-color: transparent;"
							+"-fx-text-box-border: transparent;"
						    +"-fx-background-insets: 0;"
						    +"-fx-background-color: transparent;"
							);
				TextArea HCRtechAddta = new TextArea();
					HCRtechAddta.setCache(false);
					HCRtechAddta.setMaxHeight(125);
					HCRtechAddta.setMaxWidth(300);
					HCRtechAddta.setEditable(false);
					HCRtechAddta.setStyle("-fx-focus-color: transparent; -fx-text-box-border: transparent;");
				TextArea HCRcustAddta = new TextArea();
					HCRcustAddta.setCache(false);
					HCRcustAddta.setMaxHeight(125);
					HCRcustAddta.setMaxWidth(300);
					HCRcustAddta.setEditable(false);
					HCRcustAddta.setStyle("-fx-focus-color: transparent; -fx-text-box-border: transparent;");
				TextArea HCRcleanNotice = new TextArea();
					HCRcleanNotice.setCache(false);
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
					
				AnchorPane HCRprintAP = new AnchorPane(HCRprintTa,HCRreportLogo,HCRcleanNotice,HCRtechAddta,HCRcustAddta,HCRprintTitleTa);
				AnchorPane.setTopAnchor(HCRreportLogo,10.0);
				AnchorPane.setLeftAnchor(HCRreportLogo,0.0);
				AnchorPane.setTopAnchor(HCRprintTa,0.0);
				AnchorPane.setLeftAnchor(HCRprintTa,0.0);
				AnchorPane.setTopAnchor(HCRtechAddta,10.0);
				AnchorPane.setLeftAnchor(HCRtechAddta,225.0);
				AnchorPane.setTopAnchor(HCRcustAddta,10.0);
				AnchorPane.setRightAnchor(HCRcustAddta,0.0);
				AnchorPane.setTopAnchor(HCRcleanNotice,110.0);
				AnchorPane.setRightAnchor(HCRcleanNotice,5.0);
				AnchorPane.setRightAnchor(HCRprintTitleTa,175.0);
				AnchorPane.setTopAnchor(HCRprintTitleTa,257.0);
				
				Stage HCRprintWindow = new Stage();
				Stage HCRprintBtWindow = new Stage();
				Scene HCRprintScene = new Scene(HCRprintAP, 775, 1000);
				Scene HCRprintBtScene = new Scene(HCRprintBtStage , 200, 50);
				
					HCRtechAddta.appendText(GENendTech1);
					HCRcustAddta.appendText("Invoice Number: " + HCRtfInvoice.getText() + "\n" + HCRcustadd1na + "\n" + HCRcustadd1po + "\n" + HCRcustadd1csz + "\n" + HCRcustadd1ph + "\n" + HCRcustadd1email);
					HCRcleanNotice.appendText("\nAll cleaning is in accordance with the local fire codes and/or NFPA Standard Code #96. This\n"
						+ "courtesy follow-up report is provided as a free customer service only; it is not a paid consul-\n"
						+ "tation. The inspection of the exhaust system is limited to the possible need for improved \n"
						+ "access and cleaning only. Other deficiencies, whether reported or not, are beyond the scope\nof"
						+ " our cleaning crew's knowledge. It is the owner of the exhaust system's responsibility to \ntake"
						+ " appropriate action to modify any deficiencies noted herein or elsewhere.\n");
					
					HCRprintTa.appendText("\n" + "\n" + "\n" + "\n" + "\n"+"\n" + "\n" + "\n"
						+ "    Service Scheduled with:\t" + HCRservSchTF.getText() + "\n"
						+ "    Store Closing Manager:\t" + HCRstoreCMTF.getText()+ "\n"
						+ "    Date of Service:\t\t\t" + HCRdateOSDP.getValue()+ "\n"
						+ "    Service Frequency:\t\t" + HCRserviceECB.getValue()+ "\n"
						+ "    Time of Service:\t\t\t" + HCRtimeOSTF.getText()+ "\n"
						+ "    Next Service Due:\t\t" + GENexecDate + "\n"
						+ "\t__________________________________________________________________________________________________________________________________________\n"
						+ "\n"	+ "\t\t\t\t\t\t\t\t\t\n" 
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
						+ "\t\t13. Grease build up on filter: \t\t\t\t" + GENgBUFiSt + "\t\t\t" + "Inaccessible areas?:  " + GENinAccCBSt + "               Key available?:\t" + GENkeyCBSt +"\n" + "\n"
						+ "\tNotes to Cleaning Technicians: "
						+ "\t" + HCRtaServ1.getText() + "\n"
						+ "\tMiscellaneous Notes: "
						+ HCRmiscNotTa.getText() + "\n\n"
						+ "\tService performed by:      " + HCRtechtf.getValue() + "\t\tDate Completed: " + HCRdateOSDP.getValue()	+ "                  Time In: " + HCRtfTI.getText()+ "                  Time Out: " + HCRtfTO.getText()+ "\n"
						+ "\n\tTechnician Signature:____________________________________________________________\t\t\tDate:_________________________\n"
						+ "\n\t__________________________________________________________________________________________________________________________________________\n"
						+ "\tIN THE EVENT OF DEFAULT, TONG'S FIRE EXTINGUISHER SHALL BE ENTITLED TO RECOVER COST OF COLLECTION, INCLUDING\n\tREASONABLE ATTORNEY FEES. ACKNOWLEDGMENT OF KITCHEN CONDITION & KEC SERVICE COMPLETED. BY SIGNING BELOW \n\tTHE CUSTOMER ACKNOWLEDGES ALL SERVICE WAS COMPLETED AND THE KITCHEN WAS LEFT CLEAN AND IN SATISFACTORY \n\tCONDITION."
						+ "\n\tClaims of unsatisfactory workmanship must be made within 48 hours. Invoices are subject to an interest charge of the lesser of \n\t1.5% per month(18% per year) or the maximum rate allowed by law on any unpaid invoices outstanding after 30 days from date \n\tof service. The Customer herby waives thier rights of subrogation by thier insurance carrier against Tong's Fire Extinguisher \n\tunder any fire or liability insurance policy.\n"
						+ "\n\n\tCustomer Signature: " + HCRcustSignSt  
						
					);
					HCRbtPrint.setOnAction(e1 -> {
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
						//print(primaryStage);
						//defaultPrinter(primaryStage);
						//startPrint(primaryStage);
						//startSetupStage(primaryStage);
						//printSetup(HCRprintAP, HCRprintWindow);
						
						printNode(HCRprintAP);
					
					});
					HBox HCRprintHBox = new HBox();
						HCRprintHBox.getChildren().addAll(HCRbtPrint,HCRcancel);
					
						HCRprintBtStage.getChildren().addAll(HCRprintHBox);
					
						HCRprintWindow.setTitle("HCRGen Report");
						HCRprintWindow.setScene(HCRprintScene);
						
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
			
	        
	        
	        HCRmainVB.getChildren().addAll(HCRhb1, HCRhb2, HCRvb2, HCRvb3, HCRhb5, HCRhb6, HCRhb7,HCRhb10);
			
		Scene HCRscene = new Scene(HCRsp , 775, height);
			
			primaryStage.setTitle("HCRGen/Hood Cleaning Report Form");
			primaryStage.setX(0);
			primaryStage.setY(0);
			primaryStage.setScene(HCRscene);
			primaryStage.setMinWidth(775);
			primaryStage.setMaxWidth(775);
			primaryStage.setMinHeight(height);
			primaryStage.setMaxHeight(height);
			primaryStage.show();
	}
	
	/** Restaurant Fire Suppression Systems Report Window RFSSR 
	 */
	public void startRFSSR(Stage primaryStage) throws FileNotFoundException{			
		//Create a main page VBox and set its attributes
		ScrollPane RFSSRsp = new ScrollPane();
			RFSSRsp.setCache(false);
		VBox RFSSRmainVB = new VBox();
			RFSSRmainVB.setMinSize(400, 450);
			RFSSRmainVB.setPadding(new Insets(10,10,10,10));
			RFSSRmainVB.setAlignment(Pos.TOP_CENTER);
		VBox.setVgrow(RFSSRsp, Priority.ALWAYS);
			RFSSRsp.setContent(RFSSRmainVB);
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
			
		/* Items that go in RFSSRhb1 go here
		 * ImageView of logo
		 * Business Info
		 * Invoice box
		 */
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
			
		Label RFSSRlogo = new Label();
		Label RFSSRreportLogo = new Label();
			
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
	
			//create report form Title labels
			Label RFSSRtitle1 = new Label("Resturant"); 
				RFSSRtitle1.setFont(new Font("Cambria", 20));
			Label RFSSRtitle2 = new Label("Fire");	
				RFSSRtitle2.setFont(new Font("Cambria", 20));
			Label RFSSRtitle3 = new Label("Suppression");
				RFSSRtitle3.setFont(new Font("Cambria", 20));
			Label RFSSRtitle4 = new Label("Systems");	
				RFSSRtitle4.setFont(new Font("Cambria", 20));
			Label RFSSRtitle5 = new Label("Report");	
				RFSSRtitle5.setFont(new Font("Cambria", 20));
			Label RFSSRtitle6 = new Label("Form");	
				RFSSRtitle6.setFont(new Font("Cambria", 20));
			
			RFSSRvb1.getChildren().addAll(RFSSRtitle1, RFSSRtitle2, RFSSRtitle3, RFSSRtitle4, RFSSRtitle5,RFSSRtitle6);
			
		VBox RFSSRinvVBox = new VBox();
			RFSSRinvVBox.setAlignment(Pos.TOP_LEFT);
		
		Label RFSSRinvRefNum = new Label(" Invoice Reference #");
			
		TextField RFSSRtfInvoice = new TextField("####");
			RFSSRtfInvoice.setFont(new Font("Cambria", 10));
				
			RFSSRinvVBox.getChildren().addAll(RFSSRinvRefNum, RFSSRtfInvoice);
			RFSSRheadPane.add(RFSSRlogo, 0,0);		
			RFSSRheadPane.add(RFSSRvb1, 1,0);
			RFSSRheadPane.add(RFSSRinvVBox, 2,0);
	
			RFSSRhb1.getChildren().addAll(RFSSRheadPane);
			
		/* Items that go in RFSSRhb2 and go here
		 * Service Info Box
		 * Customer Info Box
		 */
		Label RFSSRservSchLabel = new Label(" Service Scheduled with: ");
		Label RFSSRstoreCMLabel = new Label(" Store Closing Manager: ");
		Label RFSSRdateOSLabel = new Label(" Date of Service: ");
		Label RFSSRtimeOSLabel = new Label(" Time of Service: ");
		Label RFSSRserviceELabel = new Label(" Service Frequency ");
			
		ComboBox<String> RFSSRserviceECB = new ComboBox<String>();
			RFSSRserviceECB.setValue(((CusOb) clientmap.get(CUSTOBJFOCUS)).getSF());
			RFSSRserviceECB.getItems().addAll("Annually", "Bi-Annually", "Quarterly");
				
		TextField RFSSRservSchTF = new TextField(((CusOb) clientmap.get(CUSTOBJFOCUS)).getSSw());
			RFSSRservSchTF.setMinWidth(205);
			RFSSRservSchTF.setFont(new Font("Cambria", 10));
		TextField RFSSRstoreCMTF = new TextField(((CusOb) clientmap.get(CUSTOBJFOCUS)).getSCM());
			RFSSRstoreCMTF.setFont(new Font("Cambria", 10));
			RFSSRstoreCMTF.setMaxWidth(275);
		TextField RFSSRtimeOSTF = new TextField("24:00");
			RFSSRtimeOSTF.setFont(new Font("Cambria", 10));
			RFSSRtimeOSTF.setMaxWidth(75);
				
		DatePicker RFSSRdateOSDP = new DatePicker(GENdateNow);
			
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
			RFSSRservGrid.add(RFSSRserviceELabel,0,4);  
			RFSSRservGrid.add(RFSSRserviceECB,1,4); 
			
		//Create Second row of boxes for Customer information and place them on the grid
		Label RFSSRcustPhoneLabel = new Label(" Phone: ");
		Label RFSSRcustEmailLabel = new Label(" Email: ");
		Label RFSSRcustNameLabel = new Label(" Client: ");
		Label RFSSRcustAdrLabel = new Label(" Address: ");
		Label RFSSRcustAdrCityLabel = new Label(" City: ");
		Label RFSSRcustAdrStateLabel = new Label(" State: ");
		Label RFSSRcustAdrZipLabel = new Label(" Zip: ");
			
		TextField RFSSRtfcustPhone = new TextField(((CusOb) clientmap.get(CUSTOBJFOCUS)).getPhone());
			RFSSRtfcustPhone.setFont(new Font("Cambria", 10));
			RFSSRtfcustPhone.setMaxWidth(115);
		TextField RFSSRcustEmailTF = new TextField(((CusOb) clientmap.get(CUSTOBJFOCUS)).getEmail());
			RFSSRcustEmailTF.setFont(new Font("Cambria", 10));
			RFSSRcustEmailTF.setMaxWidth(115);
		TextField RFSSRtfcustName = new TextField(((CusOb) clientmap.get(CUSTOBJFOCUS)).getClient());
			RFSSRtfcustName.setFont(new Font("Cambria", 10));
			RFSSRtfcustName.setMinWidth(205);
		TextField RFSSRtfcustAdr = new TextField(((CusOb) clientmap.get(CUSTOBJFOCUS)).getAddress());
			RFSSRtfcustAdr.setFont(new Font("Cambria", 10));
			RFSSRtfcustAdr.setMaxWidth(275);
		TextField RFSSRtfcustAdrCity = new TextField(((CusOb) clientmap.get(CUSTOBJFOCUS)).getCity());
			RFSSRtfcustAdrCity.setFont(new Font("Cambria", 10));
			RFSSRtfcustAdrCity.setMaxWidth(115);
		TextField RFSSRtfcustAdrState = new TextField(((CusOb) clientmap.get(CUSTOBJFOCUS)).getState());
			RFSSRtfcustAdrState.setFont(new Font("Cambria", 10));
			RFSSRtfcustAdrState.setMaxWidth(115);
		TextField RFSSRtfcustAdrZip = new TextField(((CusOb) clientmap.get(CUSTOBJFOCUS)).getZip());
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
			
			RFSSRcustGrid.add(RFSSRcustEmailLabel,0,6);
			RFSSRcustGrid.add(RFSSRcustEmailTF,1,6);
			
			RFSSRhb2.getChildren().addAll(RFSSRservGrid, RFSSRcustGrid);
			
		/* RFSSRhb3 Items go here
		 * Service Type and Basic Service information
		 */
		GridPane RFSSRSiGrid = new GridPane();
			RFSSRSiGrid.setAlignment(Pos.TOP_LEFT);
			
		VBox RFSSRvb6 = new VBox();
			
		Label RFSSRsysInfoL = new Label(" System Information");
			RFSSRsysInfoL.setFont(new Font("Cambria", 10));
		Label RFSSRselOneL = new Label("Service Type: ");
		Label RFSSREoGLabel = new Label("Shut off");
		Label RFSSRmanLabel = new Label("Manufacturer: ");
		Label RFSSRmodLabel = new Label("Model: ");
		Label RFSSRWoDLabel= new Label("Agent ");
		Label RFSSRCSLabel = new Label("Cylinder size: ");
		Label RFSSRCSSLabelM = new Label("Master");
			RFSSRCSSLabelM.setFont(new Font("Cambria", 10));
		Label RFSSRCSSLabelS = new Label("Slave");
			RFSSRCSSLabelS.setFont(new Font("Cambria", 10));
		Label RFSSRCSSLabelS2 = new Label("Slave #2");
			RFSSRCSSLabelS2.setFont(new Font("Cambria", 10));
		Label RFSSRflLabel = new Label("Fuse  Links: ");
		Label RFSSRfl360Label = new Label("360");
			RFSSRfl360Label.setFont(new Font("Cambria", 10));
		Label RFSSRfl450Label = new Label("450");
			RFSSRfl450Label.setFont(new Font("Cambria", 10));
		Label RFSSRfl500Label = new Label("500");
			RFSSRfl500Label.setFont(new Font("Cambria", 10));
		Label RFSSRLHTDLabel = new Label("Last hydro test: ");
		Label RFSSRNHTDLabel = new Label("Next hydro test: ");
		Label RFSSRCALLabel = new Label("System location");
			
		ComboBox<String> RFSSRselOneCB = new ComboBox<String>();
			RFSSRselOneCB.getItems().addAll("Semi-Annual", "Recharge", "Installation", "Renovation");
		TextField RFSSRmanTF = new TextField();
		TextField RFSSRmodTF = new TextField();
		ComboBox<String> RFSSRCSMCB = new ComboBox<String>();
			RFSSRCSMCB.setValue(" ");
			RFSSRCSMCB.getItems().addAll("1.5","1.6","2.5","2.75","3","3.75","4","4.6","4.75","6");
		ComboBox<String> RFSSRCSSMCB = new ComboBox<String>();
			RFSSRCSSMCB.setValue(" ");
			RFSSRCSSMCB.getItems().addAll("1.5","1.6","2.5","2.75","3","3.75","4","4.6","4.75","6");
		ComboBox<String> RFSSRCSSMCB2 = new ComboBox<String>();
			RFSSRCSSMCB2.setValue(" ");
			RFSSRCSSMCB2.getItems().addAll("1.5","1.6","2.5","2.75","3","3.75","4","4.6","4.75","6");
		ComboBox<String> RFSSRfl360CB = new ComboBox<String>();
			RFSSRfl360CB.setValue(" ");
			RFSSRfl360CB.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12");
		ComboBox<String> RFSSRfl450CB = new ComboBox<String>();
			RFSSRfl450CB.setValue(" ");
			RFSSRfl450CB.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12");
		ComboBox<String> RFSSRfl500CB = new ComboBox<String>();
			RFSSRfl500CB.setValue(" ");
			RFSSRfl500CB.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12");
			
		DatePicker RFSSRLHTDDP = new DatePicker();
			RFSSRLHTDDP.setValue(((CusOb) clientmap.get(CUSTOBJFOCUS)).getLastHydro());

		TextField RFSSRNHTDDP = new TextField(((CusOb) clientmap.get(CUSTOBJFOCUS)).getLastHydro().plusYears(12).toString());
			RFSSRNHTDDP.setEditable(false);
		TextField RFSSRCALTF = new TextField();
			
		ToggleGroup RFSSRWDTG = new ToggleGroup();
		RadioButton RFSSRWDrb1 = new RadioButton("Wet");
			RFSSRWDrb1.setFont(new Font("Cambria", 10));
			RFSSRWDrb1.setToggleGroup(RFSSRWDTG);
		RadioButton RFSSRWDrb2 = new RadioButton("Dry");
			RFSSRWDrb2.setFont(new Font("Cambria", 10));
			RFSSRWDrb2.setToggleGroup(RFSSRWDTG);
				
		ToggleGroup RFSSREoGTG = new ToggleGroup();
		RadioButton RFSSREoGrb1 = new RadioButton("Gas");
			RFSSREoGrb1.setFont(new Font("Cambria", 10));
			RFSSREoGrb1.setToggleGroup(RFSSREoGTG);
		RadioButton RFSSREoGrb2 = new RadioButton("Elect");
			RFSSREoGrb2.setFont(new Font("Cambria", 10));
			RFSSREoGrb2.setToggleGroup(RFSSREoGTG);
				
			RFSSRSiGrid.add(RFSSRsysInfoL,		1,0);
			
			RFSSRSiGrid.add(RFSSRselOneL,		0,1);
			RFSSRSiGrid.add(RFSSRmanLabel,		0,2);
			RFSSRSiGrid.add(RFSSRmodLabel,		0,3);
			RFSSRSiGrid.add(RFSSRCALLabel,		0,4);
			RFSSRSiGrid.add(RFSSRLHTDLabel,		0,5);
			RFSSRSiGrid.add(RFSSRNHTDLabel,		0,6);	

			RFSSRSiGrid.add(RFSSRselOneCB,		1,1);
			RFSSRSiGrid.add(RFSSRmanTF,			1,2);
			RFSSRSiGrid.add(RFSSRmodTF,			1,3);
			RFSSRSiGrid.add(RFSSRCALTF,			1,4);	
			RFSSRSiGrid.add(RFSSRLHTDDP,		1,5);
			RFSSRSiGrid.add(RFSSRNHTDDP,		1,6);
			
		GridPane RFSSRservInfoGrid = new GridPane();
			
			RFSSRservInfoGrid.add(RFSSRWoDLabel,		0,0);	
			RFSSRservInfoGrid.add(RFSSRWDrb1,			1,0);
			RFSSRservInfoGrid.add(RFSSRWDrb2,			2,0);
			
			RFSSRservInfoGrid.add(RFSSREoGLabel,		0,1);
			RFSSRservInfoGrid.add(RFSSREoGrb1,			1,1);
			RFSSRservInfoGrid.add(RFSSREoGrb2,			2,1);
			
			RFSSRservInfoGrid.add(RFSSRCSLabel,			0,3);
			RFSSRservInfoGrid.add(RFSSRCSSLabelM,		1,2);
			RFSSRservInfoGrid.add(RFSSRCSSLabelS,		2,2);
			RFSSRservInfoGrid.add(RFSSRCSSLabelS2,		3,2);
			RFSSRservInfoGrid.add(RFSSRCSMCB,			1,3);
			RFSSRservInfoGrid.add(RFSSRCSSMCB,			2,3);
			RFSSRservInfoGrid.add(RFSSRCSSMCB2,			3,3);
			
			RFSSRservInfoGrid.add(RFSSRflLabel,			0,5);
			RFSSRservInfoGrid.add(RFSSRfl360Label,		1,4);
			RFSSRservInfoGrid.add(RFSSRfl450Label,		2,4);
			RFSSRservInfoGrid.add(RFSSRfl500Label,		3,4);			
			RFSSRservInfoGrid.add(RFSSRfl360CB,			1,5);
			RFSSRservInfoGrid.add(RFSSRfl450CB,			2,5);
			RFSSRservInfoGrid.add(RFSSRfl500CB,			3,5);
			
		Label RFSSRtILabel = new Label("TIME IN: ");
		Label RFSSRtOLabel = new Label("TIME OUT: ");
			
		TextField RFSSRtfTI = new TextField("24:00");
			RFSSRtfTI.setFont(new Font("Cambria", 10));
			RFSSRtfTI.setMaxWidth(80);
		TextField RFSSRtfTO = new TextField("24:00");
			RFSSRtfTO.setFont(new Font("Cambria", 10));
			RFSSRtfTO.setMaxWidth(80);
			
		Label RFSSRmiscNotLabel = new Label("Comments and Deficiencies: ");
			
		TextArea RFSSRmiscNotTa = new TextArea("None");
			RFSSRmiscNotTa.setCache(false);
			RFSSRmiscNotTa.setWrapText(true);
			RFSSRmiscNotTa.setFont(new Font("Cambria", 10));
			RFSSRmiscNotTa.setWrapText(true);
			RFSSRmiscNotTa.setMaxWidth(315);
		
			RFSSRhb6.getChildren().addAll(RFSSRtILabel, RFSSRtfTI, RFSSRtOLabel, RFSSRtfTO);
			
		VBox RFFSRvb7 = new VBox();
			
		GridPane RFSSRrbGrid = new GridPane();
			RFSSRrbGrid.setAlignment(Pos.TOP_LEFT);
			
		Label RFSSRlabelYes = new Label("Yes");
			RFSSRlabelYes.setFont(new Font("Cambria", 9));
		Label RFSSRlabelNo = new Label("No");
			RFSSRlabelNo.setFont(new Font("Cambria", 9));
		Label RFSSRlabelNA = new Label("N/A");
			RFSSRlabelNA.setFont(new Font("Cambria", 9));
		Label RFSSRservInfoL = new Label(" \t\tService Information");
			RFSSRservInfoL.setFont(new Font("Cambria", 10));
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
		Label RFSSRlabel32 = new Label("32. Multiple tank system ");
	
			//add labels to RFSSRrbGrid
			RFSSRrbGrid.add(RFSSRservInfoL,		0,0);
			RFSSRrbGrid.add(RFSSRlabelYes,      1,0);
			RFSSRrbGrid.add(RFSSRlabelNo,  	    2,0);
			RFSSRrbGrid.add(RFSSRlabelNA,  	    3,0);

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
			RFSSRrbGrid.add(RFSSRlabel32,		0,32);
			
		ToggleGroup RFSSRlabel1TG = new ToggleGroup();
		RadioButton RFSSRrb1 = new RadioButton( );
			RFSSRrb1.setToggleGroup(RFSSRlabel1TG);
		RadioButton RFSSRrb1N = new RadioButton( );
			RFSSRrb1N.setToggleGroup(RFSSRlabel1TG);
		RadioButton RFSSRrb1Na = new RadioButton( );
			RFSSRrb1Na.setToggleGroup(RFSSRlabel1TG);	
			
		ToggleGroup RFSSRlabel2TG = new ToggleGroup();
		RadioButton RFSSRrb2 = new RadioButton( );
			RFSSRrb2.setToggleGroup(RFSSRlabel2TG);
		RadioButton RFSSRrb2N = new RadioButton( );
			RFSSRrb2N.setToggleGroup(RFSSRlabel2TG);
		RadioButton RFSSRrb2Na = new RadioButton( );
			RFSSRrb2Na.setToggleGroup(RFSSRlabel2TG);
			
		ToggleGroup RFSSRlabel3TG = new ToggleGroup();
		RadioButton RFSSRrb3 = new RadioButton( );
			RFSSRrb3.setToggleGroup(RFSSRlabel3TG);
		RadioButton RFSSRrb3N = new RadioButton( );
			RFSSRrb3N.setToggleGroup(RFSSRlabel3TG);
		RadioButton RFSSRrb3Na = new RadioButton( );
			RFSSRrb3Na.setToggleGroup(RFSSRlabel3TG);
			
		ToggleGroup RFSSRlabel4TG = new ToggleGroup();
		RadioButton RFSSRrb4 = new RadioButton( );
			RFSSRrb4.setToggleGroup(RFSSRlabel4TG);
		RadioButton RFSSRrb4N = new RadioButton( );
			RFSSRrb4N.setToggleGroup(RFSSRlabel4TG);
		RadioButton RFSSRrb4Na = new RadioButton( );
			RFSSRrb4Na.setToggleGroup(RFSSRlabel4TG);
			
		ToggleGroup RFSSRlabel5TG = new ToggleGroup();
		RadioButton RFSSRrb5 = new RadioButton( );
			RFSSRrb5.setToggleGroup(RFSSRlabel5TG);
		RadioButton RFSSRrb5N = new RadioButton( );
			RFSSRrb5N.setToggleGroup(RFSSRlabel5TG);
		RadioButton RFSSRrb5Na = new RadioButton( );
			RFSSRrb5Na.setToggleGroup(RFSSRlabel5TG);
		
		ToggleGroup RFSSRlabel6TG = new ToggleGroup();
		RadioButton RFSSRrb6 = new RadioButton( );
			RFSSRrb6.setToggleGroup(RFSSRlabel6TG);
		RadioButton RFSSRrb6N = new RadioButton( );
			RFSSRrb6N.setToggleGroup(RFSSRlabel6TG);
		RadioButton RFSSRrb6Na = new RadioButton( );
			RFSSRrb6Na.setToggleGroup(RFSSRlabel6TG);
		
		ToggleGroup RFSSRlabel7TG = new ToggleGroup();
		RadioButton RFSSRrb7 = new RadioButton( );
			RFSSRrb7.setToggleGroup(RFSSRlabel7TG);
		RadioButton RFSSRrb7N = new RadioButton( );
			RFSSRrb7N.setToggleGroup(RFSSRlabel7TG);
		RadioButton RFSSRrb7Na = new RadioButton( );
			RFSSRrb7Na.setToggleGroup(RFSSRlabel7TG);
		
		ToggleGroup RFSSRlabel8TG = new ToggleGroup();
		RadioButton RFSSRrb8 = new RadioButton( );
			RFSSRrb8.setToggleGroup(RFSSRlabel8TG);
		RadioButton RFSSRrb8N = new RadioButton( );
			RFSSRrb8N.setToggleGroup(RFSSRlabel8TG);
		RadioButton RFSSRrb8Na = new RadioButton( );
			RFSSRrb8Na.setToggleGroup(RFSSRlabel8TG);
		
		ToggleGroup RFSSRlabel9TG = new ToggleGroup();
		RadioButton RFSSRrb9 = new RadioButton( );
			RFSSRrb9 .setToggleGroup(RFSSRlabel9TG);
		RadioButton RFSSRrb9N = new RadioButton( );
			RFSSRrb9N .setToggleGroup(RFSSRlabel9TG);
		RadioButton RFSSRrb9Na = new RadioButton( );
			RFSSRrb9N .setToggleGroup(RFSSRlabel9TG);
		
		ToggleGroup RFSSRlabel10TG = new ToggleGroup();
		RadioButton RFSSRrb10 = new RadioButton( );
			RFSSRrb10.setToggleGroup(RFSSRlabel10TG);
		RadioButton RFSSRrb10N = new RadioButton( );
			RFSSRrb10N.setToggleGroup(RFSSRlabel10TG);
		RadioButton RFSSRrb10Na = new RadioButton( );
			RFSSRrb10Na.setToggleGroup(RFSSRlabel10TG);
		
		ToggleGroup RFSSRlabel11TG = new ToggleGroup();
		RadioButton RFSSRrb11 = new RadioButton( );
			RFSSRrb11.setToggleGroup(RFSSRlabel11TG);
		RadioButton RFSSRrb11N = new RadioButton( );
			RFSSRrb11N.setToggleGroup(RFSSRlabel11TG);
		RadioButton RFSSRrb11Na = new RadioButton( );
			RFSSRrb11Na.setToggleGroup(RFSSRlabel11TG);
		
		ToggleGroup RFSSRlabel12TG = new ToggleGroup();
		RadioButton RFSSRrb12 = new RadioButton( );
			RFSSRrb12.setToggleGroup(RFSSRlabel12TG);
		RadioButton RFSSRrb12N = new RadioButton( );
			RFSSRrb12N.setToggleGroup(RFSSRlabel12TG);
		RadioButton RFSSRrb12Na = new RadioButton( );
			RFSSRrb12Na.setToggleGroup(RFSSRlabel12TG);
		
		ToggleGroup RFSSRlabel13TG = new ToggleGroup();
		RadioButton RFSSRrb13 = new RadioButton( );
			RFSSRrb13.setToggleGroup(RFSSRlabel13TG);
		RadioButton RFSSRrb13N = new RadioButton( );
			RFSSRrb13N.setToggleGroup(RFSSRlabel13TG);
		RadioButton RFSSRrb13Na = new RadioButton( );
			RFSSRrb13Na.setToggleGroup(RFSSRlabel13TG);
		
		ToggleGroup RFSSRlabel14TG = new ToggleGroup();
		RadioButton RFSSRrb14 = new RadioButton( );
			RFSSRrb14.setToggleGroup(RFSSRlabel14TG);
		RadioButton RFSSRrb14N = new RadioButton( );
			RFSSRrb14N.setToggleGroup(RFSSRlabel14TG);
		RadioButton RFSSRrb14Na = new RadioButton( );
			RFSSRrb14Na.setToggleGroup(RFSSRlabel14TG);
		
		ToggleGroup RFSSRlabel15TG = new ToggleGroup();
		RadioButton RFSSRrb15 = new RadioButton( );
			RFSSRrb15.setToggleGroup(RFSSRlabel15TG);
		RadioButton RFSSRrb15N = new RadioButton( );
			RFSSRrb15N.setToggleGroup(RFSSRlabel15TG);
		RadioButton RFSSRrb15Na = new RadioButton( );
			RFSSRrb15Na.setToggleGroup(RFSSRlabel15TG);
		
		ToggleGroup RFSSRlabel16TG = new ToggleGroup();
		RadioButton RFSSRrb16 = new RadioButton( );
			RFSSRrb16.setToggleGroup(RFSSRlabel16TG);
		RadioButton RFSSRrb16N = new RadioButton( );
			RFSSRrb16N.setToggleGroup(RFSSRlabel16TG);
		RadioButton RFSSRrb16Na = new RadioButton( );
			RFSSRrb16Na.setToggleGroup(RFSSRlabel16TG);
		
		ToggleGroup RFSSRlabel17TG = new ToggleGroup();
		RadioButton RFSSRrb17 = new RadioButton( );
			RFSSRrb17.setToggleGroup(RFSSRlabel17TG);
		RadioButton RFSSRrb17N = new RadioButton( );
			RFSSRrb17N.setToggleGroup(RFSSRlabel17TG);
		RadioButton RFSSRrb17Na = new RadioButton( );
			RFSSRrb17Na.setToggleGroup(RFSSRlabel17TG);
		
		ToggleGroup RFSSRlabel18TG = new ToggleGroup();
		RadioButton RFSSRrb18 = new RadioButton( );
			RFSSRrb18.setToggleGroup(RFSSRlabel18TG);
		RadioButton RFSSRrb18N = new RadioButton( );
			RFSSRrb18N.setToggleGroup(RFSSRlabel18TG);
		RadioButton RFSSRrb18Na = new RadioButton( );
			RFSSRrb18Na.setToggleGroup(RFSSRlabel18TG);
		
		ToggleGroup RFSSRlabel19TG = new ToggleGroup();
		RadioButton RFSSRrb19 = new RadioButton( );
			RFSSRrb19.setToggleGroup(RFSSRlabel19TG);
		RadioButton RFSSRrb19N = new RadioButton( );
			RFSSRrb19N.setToggleGroup(RFSSRlabel19TG);
		RadioButton RFSSRrb19Na = new RadioButton( );
			RFSSRrb19Na.setToggleGroup(RFSSRlabel19TG);
		
		ToggleGroup RFSSRlabel20TG = new ToggleGroup();
		RadioButton RFSSRrb20 = new RadioButton( );
			RFSSRrb20.setToggleGroup(RFSSRlabel20TG);
		RadioButton RFSSRrb20N = new RadioButton( );
			RFSSRrb20N.setToggleGroup(RFSSRlabel20TG);
		RadioButton RFSSRrb20Na = new RadioButton( );
			RFSSRrb20Na.setToggleGroup(RFSSRlabel20TG);
		
		ToggleGroup RFSSRlabel21TG = new ToggleGroup();
		RadioButton RFSSRrb21 = new RadioButton( );
			RFSSRrb21.setToggleGroup(RFSSRlabel21TG);
		RadioButton RFSSRrb21N = new RadioButton( );
			RFSSRrb21N.setToggleGroup(RFSSRlabel21TG);
		RadioButton RFSSRrb21Na = new RadioButton( );
			RFSSRrb21Na.setToggleGroup(RFSSRlabel21TG);
		
		ToggleGroup RFSSRlabel22TG = new ToggleGroup();
		RadioButton RFSSRrb22 = new RadioButton( );
			RFSSRrb22.setToggleGroup(RFSSRlabel22TG);
		RadioButton RFSSRrb22N = new RadioButton( );
			RFSSRrb22N.setToggleGroup(RFSSRlabel22TG);
		RadioButton RFSSRrb22Na = new RadioButton( );
			RFSSRrb22Na.setToggleGroup(RFSSRlabel22TG);
		
		ToggleGroup RFSSRlabel23TG = new ToggleGroup();
		RadioButton RFSSRrb23 = new RadioButton( );
			RFSSRrb23.setToggleGroup(RFSSRlabel23TG);
		RadioButton RFSSRrb23N = new RadioButton( );
			RFSSRrb23N.setToggleGroup(RFSSRlabel23TG);
		RadioButton RFSSRrb23Na = new RadioButton( );
			RFSSRrb23Na.setToggleGroup(RFSSRlabel23TG);
		
		ToggleGroup RFSSRlabel24TG = new ToggleGroup();
		RadioButton RFSSRrb24 = new RadioButton( );
			RFSSRrb24.setToggleGroup(RFSSRlabel24TG);
		RadioButton RFSSRrb24N = new RadioButton( );
			RFSSRrb24N.setToggleGroup(RFSSRlabel24TG);
		RadioButton RFSSRrb24Na = new RadioButton( );
			RFSSRrb24Na.setToggleGroup(RFSSRlabel24TG);
		
		ToggleGroup RFSSRlabel25TG = new ToggleGroup();
		RadioButton RFSSRrb25 = new RadioButton( );
			RFSSRrb25.setToggleGroup(RFSSRlabel25TG);
		RadioButton RFSSRrb25N = new RadioButton( );
			RFSSRrb25N.setToggleGroup(RFSSRlabel25TG);
		RadioButton RFSSRrb25Na = new RadioButton( );
			RFSSRrb25Na.setToggleGroup(RFSSRlabel25TG);
		
		ToggleGroup RFSSRlabel26TG = new ToggleGroup();
		RadioButton RFSSRrb26 = new RadioButton( );
			RFSSRrb26.setToggleGroup(RFSSRlabel26TG);
		RadioButton RFSSRrb26N = new RadioButton( );
			RFSSRrb26N.setToggleGroup(RFSSRlabel26TG);
		RadioButton RFSSRrb26Na = new RadioButton( );
			RFSSRrb26Na.setToggleGroup(RFSSRlabel26TG);
		
		ToggleGroup RFSSRlabel27TG = new ToggleGroup();
		RadioButton RFSSRrb27 = new RadioButton( );
			RFSSRrb27.setToggleGroup(RFSSRlabel27TG);
		RadioButton RFSSRrb27N = new RadioButton( );
			RFSSRrb27N.setToggleGroup(RFSSRlabel27TG);
		RadioButton RFSSRrb27Na = new RadioButton( );
			RFSSRrb27Na.setToggleGroup(RFSSRlabel27TG);
		
		ToggleGroup RFSSRlabel28TG = new ToggleGroup();
		RadioButton RFSSRrb28 = new RadioButton( );
			RFSSRrb28.setToggleGroup(RFSSRlabel28TG);
		RadioButton RFSSRrb28N = new RadioButton( );
			RFSSRrb28N.setToggleGroup(RFSSRlabel28TG);
		RadioButton RFSSRrb28Na = new RadioButton( );
			RFSSRrb28Na.setToggleGroup(RFSSRlabel28TG);
		
		ToggleGroup RFSSRlabel29TG = new ToggleGroup();
		RadioButton RFSSRrb29 = new RadioButton( );
			RFSSRrb29.setToggleGroup(RFSSRlabel29TG);
		RadioButton RFSSRrb29N = new RadioButton();
			RFSSRrb29N.setToggleGroup(RFSSRlabel29TG);
		RadioButton RFSSRrb29Na = new RadioButton();
			RFSSRrb29Na.setToggleGroup(RFSSRlabel29TG);
		
		ToggleGroup RFSSRlabel30TG = new ToggleGroup();
		RadioButton RFSSRrb30 = new RadioButton();
			RFSSRrb30.setToggleGroup(RFSSRlabel30TG);
		RadioButton RFSSRrb30N = new RadioButton();
			RFSSRrb30N.setToggleGroup(RFSSRlabel30TG);
		RadioButton RFSSRrb30Na = new RadioButton();
			RFSSRrb30Na.setToggleGroup(RFSSRlabel30TG);
		
		ToggleGroup RFSSRlabel31TG = new ToggleGroup();
		RadioButton RFSSRrb31 = new RadioButton();
			RFSSRrb31.setToggleGroup(RFSSRlabel31TG);
		RadioButton RFSSRrb31N = new RadioButton();
			RFSSRrb31N.setToggleGroup(RFSSRlabel31TG);
		RadioButton RFSSRrb31Na = new RadioButton();
			RFSSRrb31Na.setToggleGroup(RFSSRlabel31TG);
		
		ToggleGroup RFSSRlabel32TG = new ToggleGroup();
		RadioButton RFSSRrb32 = new RadioButton();
			RFSSRrb31.setToggleGroup(RFSSRlabel32TG);
		RadioButton RFSSRrb32N = new RadioButton();
			RFSSRrb31N.setToggleGroup(RFSSRlabel32TG);
		RadioButton RFSSRrb32Na = new RadioButton();
			RFSSRrb32Na.setToggleGroup(RFSSRlabel32TG);
			
			//Add radio buttons to RFSSRrbGrid
			RFSSRrbGrid.add(RFSSRrb1,		1,1);
			RFSSRrbGrid.add(RFSSRrb1N,		2,1);
			RFSSRrbGrid.add(RFSSRrb1Na,     3,1);
			RFSSRrbGrid.add(RFSSRrb2,	 	1,2);	
			RFSSRrbGrid.add(RFSSRrb2N,		2,2);
			RFSSRrbGrid.add(RFSSRrb2Na,		3,2);
			RFSSRrbGrid.add(RFSSRrb3,		1,3);
			RFSSRrbGrid.add(RFSSRrb3N,		2,3);
			RFSSRrbGrid.add(RFSSRrb3Na,		3,3);
			RFSSRrbGrid.add(RFSSRrb4,	 	1,4);
			RFSSRrbGrid.add(RFSSRrb4N,		2,4);
			RFSSRrbGrid.add(RFSSRrb4Na,		3,4);
			RFSSRrbGrid.add(RFSSRrb5,		1,5);
			RFSSRrbGrid.add(RFSSRrb5N,		2,5);
			RFSSRrbGrid.add(RFSSRrb5Na,		3,5);
			RFSSRrbGrid.add(RFSSRrb6,	 	1,6);
			RFSSRrbGrid.add(RFSSRrb6N,		2,6);
			RFSSRrbGrid.add(RFSSRrb6Na,		3,6);
			RFSSRrbGrid.add(RFSSRrb7,		1,7);
			RFSSRrbGrid.add(RFSSRrb7N,		2,7);
			RFSSRrbGrid.add(RFSSRrb7Na,		3,7);
			RFSSRrbGrid.add(RFSSRrb8,	 	1,8);
			RFSSRrbGrid.add(RFSSRrb8N,		2,8);
			RFSSRrbGrid.add(RFSSRrb8Na,		3,8);
			RFSSRrbGrid.add(RFSSRrb9,		1,9);
			RFSSRrbGrid.add(RFSSRrb9N,		2,9);
			RFSSRrbGrid.add(RFSSRrb9Na,		3,9);
			RFSSRrbGrid.add(RFSSRrb10,	 	1,10);
			RFSSRrbGrid.add(RFSSRrb10N,		2,10);
			RFSSRrbGrid.add(RFSSRrb10Na,	3,10);
			RFSSRrbGrid.add(RFSSRrb11,		1,11);
			RFSSRrbGrid.add(RFSSRrb11N,		2,11);
			RFSSRrbGrid.add(RFSSRrb11Na,	3,11);
			RFSSRrbGrid.add(RFSSRrb12,	 	1,12);	
			RFSSRrbGrid.add(RFSSRrb12N,		2,12);
			RFSSRrbGrid.add(RFSSRrb12Na,	3,12);
			RFSSRrbGrid.add(RFSSRrb13,		1,13);
			RFSSRrbGrid.add(RFSSRrb13N,		2,13);
			RFSSRrbGrid.add(RFSSRrb13Na,	3,13);
			RFSSRrbGrid.add(RFSSRrb14,	 	1,14);
			RFSSRrbGrid.add(RFSSRrb14N,		2,14);
			RFSSRrbGrid.add(RFSSRrb14Na,	3,14);
			RFSSRrbGrid.add(RFSSRrb15,		1,15);
			RFSSRrbGrid.add(RFSSRrb15N,		2,15);
			RFSSRrbGrid.add(RFSSRrb15Na,	3,15);
			RFSSRrbGrid.add(RFSSRrb16,	 	1,16);
			RFSSRrbGrid.add(RFSSRrb16N,		2,16);
			RFSSRrbGrid.add(RFSSRrb16Na,	3,16);
			RFSSRrbGrid.add(RFSSRrb17,		1,17);
			RFSSRrbGrid.add(RFSSRrb17N,		2,17);
			RFSSRrbGrid.add(RFSSRrb17Na,	3,17);
			RFSSRrbGrid.add(RFSSRrb18,	 	1,18);
			RFSSRrbGrid.add(RFSSRrb18N,		2,18);
			RFSSRrbGrid.add(RFSSRrb18Na,	3,18);
			RFSSRrbGrid.add(RFSSRrb19,		1,19);
			RFSSRrbGrid.add(RFSSRrb19N,		2,19);
			RFSSRrbGrid.add(RFSSRrb19Na,	3,19);
			RFSSRrbGrid.add(RFSSRrb20,	 	1,20);
			RFSSRrbGrid.add(RFSSRrb20N,		2,20);
			RFSSRrbGrid.add(RFSSRrb20Na,	3,20);
			RFSSRrbGrid.add(RFSSRrb21,		1,21);
			RFSSRrbGrid.add(RFSSRrb21N,		2,21);
			RFSSRrbGrid.add(RFSSRrb21Na,	3,21);
			RFSSRrbGrid.add(RFSSRrb22,	 	1,22);	
			RFSSRrbGrid.add(RFSSRrb22N,		2,22);
			RFSSRrbGrid.add(RFSSRrb22Na,	3,22);
			RFSSRrbGrid.add(RFSSRrb23,		1,23);
			RFSSRrbGrid.add(RFSSRrb23N,		2,23);
			RFSSRrbGrid.add(RFSSRrb23Na,	3,23);
			RFSSRrbGrid.add(RFSSRrb24,	 	1,24);
			RFSSRrbGrid.add(RFSSRrb24N,		2,24);
			RFSSRrbGrid.add(RFSSRrb24Na,	3,24);
			RFSSRrbGrid.add(RFSSRrb25,		1,25);
			RFSSRrbGrid.add(RFSSRrb25N,		2,25);
			RFSSRrbGrid.add(RFSSRrb25Na,	3,25);
			RFSSRrbGrid.add(RFSSRrb26,	 	1,26);
			RFSSRrbGrid.add(RFSSRrb26N,		2,26);
			RFSSRrbGrid.add(RFSSRrb26Na,	3,26);
			RFSSRrbGrid.add(RFSSRrb27,		1,27);
			RFSSRrbGrid.add(RFSSRrb27N,		2,27);
			RFSSRrbGrid.add(RFSSRrb27Na,	3,27);
			RFSSRrbGrid.add(RFSSRrb28,	 	1,28);
			RFSSRrbGrid.add(RFSSRrb28N,		2,28);
			RFSSRrbGrid.add(RFSSRrb28Na,	3,28);
			RFSSRrbGrid.add(RFSSRrb29,		1,29);
			RFSSRrbGrid.add(RFSSRrb29N,		2,29);
			RFSSRrbGrid.add(RFSSRrb29Na,	3,29);
			RFSSRrbGrid.add(RFSSRrb30,	 	1,30);
			RFSSRrbGrid.add(RFSSRrb30N,		2,30);
			RFSSRrbGrid.add(RFSSRrb30Na,	3,30);
			RFSSRrbGrid.add(RFSSRrb31,		1,31);
			RFSSRrbGrid.add(RFSSRrb31N,		2,31);
			RFSSRrbGrid.add(RFSSRrb31Na,	3,31);
			RFSSRrbGrid.add(RFSSRrb32,		1,32);
			RFSSRrbGrid.add(RFSSRrb32N,		2,32);
			RFSSRrbGrid.add(RFSSRrb32Na,    3,32);
			
		//Create the miscellaneous Notes and Acknowledgment Boxes and place them in the grid
		Label RFSSRtechSigLabel = new Label("Technician Name:");	
		
		ComboBox<String> RFSSRtechTF = new ComboBox<String>();
			RFSSRtechTF.setValue("No Tech Selected!");
			RFSSRtechTF.getItems().addAll(techlist);
	        RFSSRtechTF.setOnAction(e -> {
	        	GENTechName = ((TechOb) techmap.get(RFSSRtechTF.getValue())).getTechName();
	        	GENTechAdd = ((TechOb) techmap.get(RFSSRtechTF.getValue())).getTechAdd();
	        	GENTechZip = ((TechOb) techmap.get(RFSSRtechTF.getValue())).getTechZip();
	        	GENTechCity = ((TechOb) techmap.get(RFSSRtechTF.getValue())).getTechCity();
	        	GENTechState = ((TechOb) techmap.get(RFSSRtechTF.getValue())).getTechState();
	        	GENTechPhone = ((TechOb) techmap.get(RFSSRtechTF.getValue())).getTechPhone();
	        	GENTechLic = ((TechOb) techmap.get(RFSSRtechTF.getValue())).getTechLic();
	        	
	        	GENendTech1 = GENTechName + "\n" 
	        			+ GENTechAdd + "\n" 
	        			+ GENTechCity + ", " + GENTechState + " " + GENTechZip + "\n" 
	        			+ GENTechPhone + "\n" 
	        			+ "License #" + GENTechLic;
			});
		
		TextField RFSSRcustSigntf = new TextField("____________________________________________________________                    Date:_________________________\n");
			RFSSRcustSigntf.setFont(new Font("Cambria", 10));
		
		Button RFSSRbtPreView = new Button("Preview");
		Button RFSSRBackBT = new Button("Return to Main Menu");
			RFSSRBackBT.setOnAction(e ->{
				try {start(primaryStage);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			});
		Button RFSSRbtPrint = new Button("Print");

			RFSSRhb7.getChildren().addAll(RFSSRtechSigLabel,RFSSRtechTF);
			RFSSRhb8.getChildren().addAll(RFSSRbtPreView,RFSSRBackBT);
			RFSSRvb6.getChildren().addAll(RFSSRSiGrid,RFSSRservInfoGrid,RFSSRhb6,RFSSRmiscNotLabel,RFSSRmiscNotTa, RFSSRhb7);	
			RFFSRvb7.getChildren().addAll(RFSSRrbGrid);
			RFSSRhb3.getChildren().addAll(RFFSRvb7,RFSSRvb6);	
			
			//button OnAction assignments
			RFSSRWDrb1.setOnAction(e -> {setWorD(GENWoDST, "RFSSRWDrb1"); });
			RFSSRWDrb2.setOnAction(e -> {setWorD(GENWoDST, "RFSSRWDrb2"); });
			
			RFSSREoGrb1.setOnAction(e -> {setGorE(GENEoGST, "RFSSREoGrb1"); });
			RFSSREoGrb2.setOnAction(e -> {setGorE(GENEoGST, "RFSSREoGrb2"); });
			
			RFSSRrb1.setOnAction(e -> {setYes(GENlabel1TG, "RFSSRrb1"); });
			RFSSRrb1N.setOnAction(e -> {setNo(GENlabel1TG, "RFSSRrb1N"); });
			RFSSRrb1Na.setOnAction(e -> {setNo(GENlabel1TG, "RFSSRrb1Na"); });
			
			RFSSRrb2.setOnAction(e -> {setYes(GENlabel2TG, "RFSSRrb2"); });
			RFSSRrb2N.setOnAction(e -> {setNo(GENlabel2TG, "RFSSRrb2N"); });
			RFSSRrb2Na.setOnAction(e -> {setNo(GENlabel2TG, "RFSSRrb2Na"); });
			
			RFSSRrb3.setOnAction(e -> {setYes(GENlabel3TG, "RFSSRrb3"); });
			RFSSRrb3N.setOnAction(e -> {setNo(GENlabel3TG, "RFSSRrb3N"); });
			RFSSRrb3Na.setOnAction(e -> {setNo(GENlabel3TG, "RFSSRrb3Na"); });
			
			RFSSRrb4.setOnAction(e -> {setYes(GENlabel4TG, "RFSSRrb4"); });
			RFSSRrb4N.setOnAction(e -> {setNo(GENlabel4TG, "RFSSRrb4N"); });
			RFSSRrb4Na.setOnAction(e -> {setNo(GENlabel4TG, "RFSSRrb4Na"); });
			
			RFSSRrb5.setOnAction(e -> {setYes(GENlabel5TG, "RFSSRrb5"); });
			RFSSRrb5N.setOnAction(e -> {setNo(GENlabel5TG, "RFSSRrb5N"); });
			RFSSRrb5Na.setOnAction(e -> {setNo(GENlabel5TG, "RFSSRrb5Na"); });
						
			RFSSRrb6.setOnAction(e -> {setYes(GENlabel6TG, "RFSSRrb6"); });
			RFSSRrb6N.setOnAction(e -> {setNo(GENlabel6TG, "RFSSRrb6N"); });
			RFSSRrb6Na.setOnAction(e -> {setNo(GENlabel6TG, "RFSSRrb6Na"); });
			
			RFSSRrb7.setOnAction(e -> {setYes(GENlabel7TG, "RFSSRrb7"); });
			RFSSRrb7N.setOnAction(e -> {setNo(GENlabel7TG, "RFSSRrb7N"); });
			RFSSRrb7Na.setOnAction(e -> {setNo(GENlabel7TG, "RFSSRrb7Na"); });
			
			RFSSRrb8.setOnAction(e -> {setYes(GENlabel8TG, "RFSSRrb8"); });
			RFSSRrb8N.setOnAction(e -> {setNo(GENlabel8TG, "RFSSRrb8N"); });
			RFSSRrb8Na.setOnAction(e -> {setNo(GENlabel8TG, "RFSSRrb8Na"); });
			
			RFSSRrb9.setOnAction(e -> {setYes(GENlabel9TG, "RFSSRrb9"); });
			RFSSRrb9N.setOnAction(e -> {setNo(GENlabel9TG, "RFSSRrb9N"); });
			RFSSRrb9Na.setOnAction(e -> {setNo(GENlabel9TG, "RFSSRrb9Na"); });
			
			RFSSRrb10.setOnAction(e -> {setYes(GENlabel10TG, "RFSSRrb10"); });
			RFSSRrb10N.setOnAction(e -> {setNo(GENlabel10TG, "RFSSRrb10N"); });
			RFSSRrb10Na.setOnAction(e -> {setNo(GENlabel10TG, "RFSSRrb10Na"); });
			
			RFSSRrb11.setOnAction(e -> {setYes(GENlabel11TG, "RFSSRrb11"); });
			RFSSRrb11N.setOnAction(e -> {setNo(GENlabel11TG, "RFSSRrb11N"); });
			RFSSRrb11Na.setOnAction(e -> {setNo(GENlabel11TG, "RFSSRrb11Na"); });
			
			RFSSRrb12.setOnAction(e -> {setYes(GENlabel12TG, "RFSSRrb12"); });
			RFSSRrb12N.setOnAction(e -> {setNo(GENlabel12TG, "RFSSRrb12N"); });
			RFSSRrb12Na.setOnAction(e -> {setNo(GENlabel12TG, "RFSSRrb12Na"); });
			
			RFSSRrb13.setOnAction(e -> {setYes(GENlabel13TG, "RFSSRrb13"); });
			RFSSRrb13N.setOnAction(e -> {setNo(GENlabel13TG, "RFSSRrb13N"); });
			RFSSRrb13Na.setOnAction(e -> {setNo(GENlabel13TG, "RFSSRrb13Na"); });
			
			RFSSRrb14.setOnAction(e -> {setYes(GENlabel14TG, "RFSSRrb14"); });
			RFSSRrb14N.setOnAction(e -> {setNo(GENlabel14TG, "RFSSRrb14N"); });
			RFSSRrb14Na.setOnAction(e -> {setNo(GENlabel14TG, "RFSSRrb14Na"); });
			
			RFSSRrb15.setOnAction(e -> {setYes(GENlabel15TG, "RFSSRrb15"); });
			RFSSRrb15N.setOnAction(e -> {setNo(GENlabel15TG, "RFSSRrb15N"); });
			RFSSRrb15Na.setOnAction(e -> {setNo(GENlabel15TG, "RFSSRrb15Na"); });
			
			RFSSRrb16.setOnAction(e -> {setYes(GENlabel16TG, "RFSSRrb16"); });
			RFSSRrb16N.setOnAction(e -> {setNo(GENlabel16TG, "RFSSRrb16N"); });
			RFSSRrb16Na.setOnAction(e -> {setNo(GENlabel16TG, "RFSSRrb16Na"); });
			
			RFSSRrb17.setOnAction(e -> {setYes(GENlabel17TG, "RFSSRrb17"); });
			RFSSRrb17N.setOnAction(e -> {setNo(GENlabel17TG, "RFSSRrb17N"); });
			RFSSRrb17Na.setOnAction(e -> {setNo(GENlabel17TG, "RFSSRrb17Na"); });
			
			RFSSRrb18.setOnAction(e -> {setYes(GENlabel18TG, "RFSSRrb18"); });
			RFSSRrb18N.setOnAction(e -> {setNo(GENlabel18TG, "RFSSRrb18N"); });
			RFSSRrb18Na.setOnAction(e -> {setNo(GENlabel18TG, "RFSSRrb18Na"); });
			
			RFSSRrb19.setOnAction(e -> {setYes(GENlabel19TG, "RFSSRrb19"); });
			RFSSRrb19N.setOnAction(e -> {setNo(GENlabel19TG, "RFSSRrb19N"); });
			RFSSRrb19Na.setOnAction(e -> {setNo(GENlabel19TG, "RFSSRrb19Na"); });
			
			RFSSRrb20.setOnAction(e -> {setYes(GENlabel20TG, "RFSSRrb20"); });
			RFSSRrb20N.setOnAction(e -> {setNo(GENlabel20TG, "RFSSRrb20N"); });
			RFSSRrb20Na.setOnAction(e -> {setNo(GENlabel20TG, "RFSSRrb20Na"); });
			
			RFSSRrb21.setOnAction(e -> {setYes(GENlabel21TG, "RFSSRrb21"); });
			RFSSRrb21N.setOnAction(e -> {setNo(GENlabel21TG, "RFSSRrb21N"); });
			RFSSRrb21Na.setOnAction(e -> {setNo(GENlabel21TG, "RFSSRrb21Na"); });
			
			RFSSRrb22.setOnAction(e -> {setYes(GENlabel22TG, "RFSSRrb22"); });
			RFSSRrb22N.setOnAction(e -> {setNo(GENlabel22TG, "RFSSRrb22N"); });
			RFSSRrb22Na.setOnAction(e -> {setNo(GENlabel22TG, "RFSSRrb22Na"); });
			
			RFSSRrb23.setOnAction(e -> {setYes(GENlabel23TG, "RFSSRrb23"); });
			RFSSRrb23N.setOnAction(e -> {setNo(GENlabel23TG, "RFSSRrb23N"); });
			RFSSRrb23Na.setOnAction(e -> {setNo(GENlabel23TG, "RFSSRrb23Na"); });
			
			RFSSRrb24.setOnAction(e -> {setYes(GENlabel24TG, "RFSSRrb24"); });
			RFSSRrb24N.setOnAction(e -> {setNo(GENlabel24TG, "RFSSRrb24N"); });
			RFSSRrb24Na.setOnAction(e -> {setNo(GENlabel24TG, "RFSSRrb24Na"); });
			
			RFSSRrb25.setOnAction(e -> {setYes(GENlabel25TG, "RFSSRrb25"); });
			RFSSRrb25N.setOnAction(e -> {setNo(GENlabel25TG, "RFSSRrb25N"); });
			RFSSRrb25Na.setOnAction(e -> {setNo(GENlabel25TG, "RFSSRrb25Na"); });
			
			RFSSRrb26.setOnAction(e -> {setYes(GENlabel26TG, "RFSSRrb26"); });
			RFSSRrb26N.setOnAction(e -> {setNo(GENlabel26TG, "RFSSRrb26N"); });
			RFSSRrb26Na.setOnAction(e -> {setNo(GENlabel26TG, "RFSSRrb26Na"); });
			
			RFSSRrb27.setOnAction(e -> {setYes(GENlabel27TG, "RFSSRrb27"); });
			RFSSRrb27N.setOnAction(e -> {setNo(GENlabel27TG, "RFSSRrb27N"); });
			RFSSRrb27Na.setOnAction(e -> {setNo(GENlabel27TG, "RFSSRrb27Na"); });
			
			RFSSRrb28.setOnAction(e -> {setYes(GENlabel28TG, "RFSSRrb28"); });
			RFSSRrb28N.setOnAction(e -> {setNo(GENlabel28TG, "RFSSRrb28N"); });
			RFSSRrb28Na.setOnAction(e -> {setNo(GENlabel28TG, "RFSSRrb28Na"); });
			
			RFSSRrb29.setOnAction(e -> {setYes(GENlabel29TG, "RFSSRrb29"); });
			RFSSRrb29N.setOnAction(e -> {setNo(GENlabel29TG, "RFSSRrb29N"); });
			RFSSRrb29Na.setOnAction(e -> {setNo(GENlabel29TG, "RFSSRrb29Na"); });
			
			RFSSRrb30.setOnAction(e -> {setYes(GENlabel30TG, "RFSSRrb30"); });
			RFSSRrb30N.setOnAction(e -> {setNo(GENlabel30TG, "RFSSRrb30N"); });
			RFSSRrb30Na.setOnAction(e -> {setNo(GENlabel30TG, "RFSSRrb30Na"); });
			
			RFSSRrb31.setOnAction(e -> {setYes(GENlabel31TG, "RFSSRrb31"); });
			RFSSRrb31N.setOnAction(e -> {setNo(GENlabel31TG, "RFSSRrb31N"); });
			RFSSRrb31Na.setOnAction(e -> {setNo(GENlabel31TG, "RFSSRrb31Na"); });
			
			RFSSRrb32.setOnAction(e -> {setYes(GENlabel32TG, "RFSSRrb32"); });
			RFSSRrb32N.setOnAction(e -> {setNo(GENlabel32TG, "RFSSRrb32N"); });
			RFSSRrb32Na.setOnAction(e -> {setNo(GENlabel32TG, "RFSSRrb32Na"); });
			
			RFSSRbtPreView.setOnAction(e -> {
				String RFSSRcustadd1na = RFSSRtfcustName.getText().trim();
				String RFSSRcustadd1po = RFSSRtfcustAdr.getText().trim();
				String RFSSRcustadd1csz = RFSSRtfcustAdrCity.getText().trim() + ", " + RFSSRtfcustAdrState.getText().trim() + ", " +RFSSRtfcustAdrZip.getText().trim();
				String RFSSRcustadd1ph = RFSSRtfcustPhone.getText().trim();
				String RFSSRcustadd1email = RFSSRcustEmailTF.getText().trim();
				String RFSSRcustSignSt = RFSSRcustSigntf.getText();
					
				if (GENrepDate != 0000) {
					System.out.println(GENrepDate);
					GENrepDate = RFSSRdateOSDP.getValue().getYear();
				}
						
				StackPane RFSSRprintBtStage = new StackPane();
						
				Button RFSSRcancel = new Button("Close Preview");

				TextArea RFSSRprintTa = new TextArea();
					RFSSRprintTa.setCache(false);
					RFSSRprintTa.setMinHeight(height);
					RFSSRprintTa.setMinWidth(775);
					RFSSRprintTa.setEditable(false);
						
				TextArea RFSSRtechAddta = new TextArea();
					RFSSRtechAddta.setCache(false);
					RFSSRtechAddta.setMaxHeight(125);
					RFSSRtechAddta.setMaxWidth(300);
					RFSSRtechAddta.setEditable(false);
					RFSSRtechAddta.setStyle("-fx-focus-color: transparent; -fx-text-box-border: transparent;");
						
				TextArea RFSSRcustAddta = new TextArea();
					RFSSRcustAddta.setCache(false);
					RFSSRcustAddta.setMaxHeight(125);
					RFSSRcustAddta.setMaxWidth(300);
					RFSSRcustAddta.setEditable(false);
					RFSSRcustAddta.setStyle("-fx-focus-color: transparent; -fx-text-box-border: transparent;");
						
				TextArea RFSSRcleanNotice = new TextArea();
					RFSSRcleanNotice.setCache(false);
					RFSSRcleanNotice.setMinHeight(125);
					RFSSRcleanNotice.setMinWidth(290);
					RFSSRcleanNotice.setEditable(false);
					RFSSRcleanNotice.setStyle("-fx-highlight-fill: #7ecfff;"
										+"-fx-focus-color: transparent;"
										+"-fx-text-box-border: transparent;"
										+"-fx-font-size:10;"
									    +"-fx-background-insets: 0;"
									    +"-fx-background-color: transparent;"
									    +"-fx-padding: 10px;");
				TextArea RFSSRmanTA = new TextArea();
					RFSSRmanTA.setCache(false);
					RFSSRmanTA.setMaxHeight(100);
					RFSSRmanTA.setMaxWidth(290);
					RFSSRmanTA.setEditable(false);
					RFSSRmanTA.setStyle("-fx-focus-color: transparent; -fx-text-box-border: transparent;");
						
				TextArea RFSSRcylTA = new TextArea();
					RFSSRcylTA.setCache(false);
					RFSSRcylTA.setMaxHeight(100);
					RFSSRcylTA.setMaxWidth(200);
					RFSSRcylTA.setEditable(false);
					RFSSRcylTA.setStyle("-fx-focus-color: transparent; -fx-text-box-border: transparent;");
						
				TextArea RFSSRfusTA = new TextArea();
					RFSSRfusTA.setCache(false);
					RFSSRfusTA.setMaxHeight(100);
					RFSSRfusTA.setMaxWidth(250);
					RFSSRfusTA.setEditable(false);
					RFSSRfusTA.setStyle("-fx-focus-color: transparent; -fx-text-box-border: transparent;");
				TextArea RFSSRprintTitleTa = new TextArea("RESTAURANT FIRE SUPPRESSION SYSTEMS REPORT");
					RFSSRprintTitleTa.setFont(font2);
					RFSSRprintTitleTa.setCache(false);
					RFSSRprintTitleTa.setMinHeight(30);
					RFSSRprintTitleTa.setMaxHeight(30);
					RFSSRprintTitleTa.setMinWidth(465);
					RFSSRprintTitleTa.setMaxWidth(465);
					RFSSRprintTitleTa.setEditable(false);
					RFSSRprintTitleTa.setStyle("-fx-highlight-fill: #7ecfff;"
							+"-fx-focus-color: transparent;"
							+"-fx-text-box-border: transparent;"
						    +"-fx-background-insets: 0;"
						    +"-fx-background-color: transparent;"
							);
					
				AnchorPane RFSSRprintStage = new AnchorPane(RFSSRprintTa,RFSSRreportLogo,RFSSRcleanNotice,RFSSRtechAddta,RFSSRcustAddta,RFSSRmanTA,RFSSRcylTA,RFSSRfusTA,RFSSRprintTitleTa);

				AnchorPane.setTopAnchor(RFSSRreportLogo,10.0);
				AnchorPane.setLeftAnchor(RFSSRreportLogo,0.0);
				AnchorPane.setTopAnchor(RFSSRprintTa,0.0);
				AnchorPane.setLeftAnchor(RFSSRprintTa,0.0);
				AnchorPane.setTopAnchor(RFSSRtechAddta,10.0);
				AnchorPane.setLeftAnchor(RFSSRtechAddta,225.0);
				AnchorPane.setTopAnchor(RFSSRcustAddta,10.0);
				AnchorPane.setRightAnchor(RFSSRcustAddta,0.0);
				AnchorPane.setTopAnchor(RFSSRcleanNotice,110.0);
				AnchorPane.setRightAnchor(RFSSRcleanNotice,5.0);
				AnchorPane.setTopAnchor(RFSSRmanTA,300.0);
				AnchorPane.setTopAnchor(RFSSRcylTA,300.0);
				AnchorPane.setTopAnchor(RFSSRfusTA,300.0);
				AnchorPane.setLeftAnchor(RFSSRmanTA,10.0);
				AnchorPane.setLeftAnchor(RFSSRcylTA,300.0);
				AnchorPane.setRightAnchor(RFSSRfusTA,10.0);
				AnchorPane.setRightAnchor(RFSSRprintTitleTa,175.0);
				AnchorPane.setTopAnchor(RFSSRprintTitleTa,275.0);

				RFSSRtechAddta.appendText(GENendTech1);
				RFSSRcustAddta.appendText("Invoice Number: " + RFSSRtfInvoice.getText() + "\n" + RFSSRcustadd1na + "\n" + RFSSRcustadd1po + "\n" + RFSSRcustadd1csz + "\n" + RFSSRcustadd1ph + "\n" + RFSSRcustadd1email);
				RFSSRcleanNotice.appendText("\nOn this date, the below was tested and inspected in accordance with procedures \nof the"
						+ " presently adopted editions of NFPA 17, 17A, refrences to Fire Suppression \nSystems contained in NFPA 96,"
						+ "and the manufacturer's manual, and was operated\naccording to these procedures with results indicated herein."
						+ "\n\nThe service technician certifies that the system was personally inspected, and the\nconditions were found to be as indicated on this report. "
				);
						
				RFSSRmanTA.appendText(
					RFSSRmanLabel.getText() +"\t\t" +  RFSSRmanTF.getText().trim() 
						+ "\n" + RFSSRmodLabel.getText() +"\t\t\t" +  RFSSRmodTF.getText().trim() 
						+ "\nSystem Location:  " + "\n\t" + RFSSRCALTF.getText()
					);
						
				RFSSRcylTA.appendText(
					RFSSRWoDLabel.getText() + ": \t\t" + GENWoDST 
						+ "\n" + RFSSRCSLabel.getText()
						+"\n\tMaster:\t"+  RFSSRCSMCB.getValue()
						+"\n\t" + RFSSRCSSLabelS.getText() +":\t" +RFSSRCSSMCB.getValue()
						+"\n\t" + RFSSRCSSLabelS2.getText() +":\t" +  RFSSRCSSMCB2.getValue()  
					);
						
				RFSSRfusTA.appendText(
					RFSSREoGLabel.getText() +": \t\t" + GENEoGST 
						+ "\n" + RFSSRflLabel.getText() 
						+ "\n\t" + RFSSRfl360Label.getText() + ": \t\t" + RFSSRfl360CB.getValue()
						+ "\n\t" + RFSSRfl450Label.getText() + ": \t\t" + RFSSRfl450CB.getValue()
						+ "\n\t" + RFSSRfl500Label.getText() + ": \t\t" + RFSSRfl500CB.getValue() 
					);
						
				RFSSRprintTa.appendText("\n" + "\n" + "\n" + "\n" + "\n"+"\n" + "\n" + "\n"
						+ "    Service Scheduled with:\t" + RFSSRservSchTF.getText() + "\n"
						+ "    Store Closing Manager:\t" + RFSSRstoreCMTF.getText()+ "\n"
						+ "    Date of Service:\t\t\t" + RFSSRdateOSDP.getValue()+ "\n"
						+ "    Service Frequency:\t\t" + RFSSRselOneCB.getValue()+ "\n"
						+ "    Time of Service:\t\t\t" + RFSSRtimeOSTF.getText()+ "\n"
						+ "    Completed Service:\t\t"+RFSSRselOneCB.getValue() +"\n"
						+ "    Next Service Due:\t\t" + GENexecDate + "\n"
						+ "\t__________________________________________________________________________________________________________________________________________\n"
						+ "\n"				+ "\t\t\t\t\t\t\t\t\t\n" 
						+ "\n\n\n\n"				
						+ "\n\tItem: \t\t\t\t\t\t\t\t\t\t" +"\t\t\t\tItem:\n"
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
						+ " "+ RFSSRlabel16.getText() + "\t\t\t\t\t\t\t\t" + GENlabel16TG +"\t\t\t" + RFSSRlabel32.getText() + "\t\t\t\t\t\t\t" +  GENlabel32TG + "\n\n"
						+ " "+ RFSSRmiscNotLabel.getText() + " "+RFSSRmiscNotTa.getText() + "\n\n"
						+ "\tService performed by:      " + RFSSRtechTF.getValue() + "\t\tDate Completed: " + RFSSRdateOSDP.getValue()	+ "                  Time In: " + RFSSRtfTI.getText()+ "                  Time Out: " + RFSSRtfTO.getText()+ "\n"
						+ "\n\tTechnician Signature:____________________________________________________________\t\t\tDate:_________________________\n"
						+ "\n\t__________________________________________________________________________________________________________________________________________\n"
						+ "\tIN THE EVENT OF DEFAULT, TONG'S FIRE EXTINGUISHER SHALL BE ENTITLED TO RECOVER COST OF COLLECTION, INCLUDING\n\tREASONABLE ATTORNEY FEES. ACKNOWLEDGMENT OF KITCHEN CONDITION & KEC SERVICE COMPLETED. BY SIGNING BELOW \n\tTHE CUSTOMER ACKNOWLEDGES ALL SERVICE WAS COMPLETED AND THE KITCHEN WAS LEFT CLEAN AND IN SATISFACTORY \n\tCONDITION."
						+ "\n\tClaims of unsatisfactory workmanship must be made within 48 hours. Invoices are subject to an interest charge of the lesser of \n\t1.5% per month (18% per year) or the maximum rate allowed by law on any unpaid invoices outstanding after 30 days from date \n\tof service. The Customer herby waives thier rights of subrogation by thier insurance carrier against Tong's Fire Extinguisher \n\tunder any fire or liability insurance policy.\n"
						+ "\n\tCustomer Signature: " + RFSSRcustSignSt + "\n"  
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
				RFSSRbtPrint.setOnAction(e1 -> {
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
					printNode(RFSSRprintStage);
				});
			});
				

	        
			RFSSRmainVB.getChildren().addAll(RFSSRhb1, RFSSRhb2, RFSSRhb3, RFSSRhb4, RFSSRhb5, RFSSRhb8);
		Scene RFSSRscene = new Scene(RFSSRsp , width, height);
		
			primaryStage.setTitle("HCRGen/Restaurant Fire Suppression Systems Report Form");
			primaryStage.setX(0);
			primaryStage.setY(0);
			primaryStage.setScene(RFSSRscene);
			primaryStage.setMinWidth(775);
			primaryStage.setMaxWidth(775);
			primaryStage.setMinHeight(height);
			primaryStage.setMaxHeight(height);
			primaryStage.show();
	}	
	
	/** Add Client window "CA" makes creating a customer possible
	 */
	public void CAstart(Stage primaryStage) throws FileNotFoundException{
		ScrollPane CAsp = new ScrollPane();	
			CAsp.setCache(false);
		VBox CAmainVB = new VBox();
			CAmainVB.setMinSize(400, 250);
			CAmainVB.setPadding(new Insets(10,10,10,10));
			CAmainVB.setAlignment(Pos.TOP_CENTER);
		VBox.setVgrow(CAsp, Priority.ALWAYS);
			CAsp.setContent(CAmainVB);
	
		HBox CAhb1 = new HBox();
			CAhb1.setAlignment(Pos.TOP_CENTER);
			CAhb1.setPadding(new Insets(10,10,10,10));
			CAhb1.setSpacing(10);
		
		//create GridPane for the logo, business information and invoice Box
		GridPane CAheadPane = new GridPane();
			CAheadPane.setMinSize(200, 100);
			CAheadPane.setPadding(new Insets(10,10,10,10));
			CAheadPane.setVgap(5);
			CAheadPane.setHgap(0);
			CAheadPane.setAlignment(Pos.TOP_LEFT);
			CAheadPane.setGridLinesVisible(false);
		
		//create ImageView for logo and place in the grid
		File CAf = new File("TONGS-FIRE-EXTINGUISHER-SALES-AND-SERVICE.jpg");
		String CAfilLoc = CAf.getAbsolutePath();
		Label CAlogo = new Label();

		Image CAimg = new Image(new FileInputStream(CAfilLoc));
		ImageView CAview = new ImageView(CAimg);
			CAview.setFitHeight(125);
			CAview.setFitWidth(225);
			CAview.setPreserveRatio(false);
		
		CAlogo.setGraphic(CAview);
		CAheadPane.add(CAlogo, 0,0);		
		
		//Create Service Schedule Information box
		Label CATLabel1 = new Label("Add Ne");
			CATLabel1.setFont(new Font("Cambria", 45));
		Label CATLabel2 = new Label("w Client");
			CATLabel2.setFont(new Font("Cambria", 45));
		Label CAcustNameLabel = new Label(" Client: ");
		Label CAcustAdrLabel = new Label(" Address: ");
		Label CAcustAdrCityLabel = new Label(" City: ");
		Label CAcustAdrStateLabel = new Label(" State: ");
		Label CAcustAdrZipLabel = new Label(" Zip: ");
		Label CAcustPhoneLabel = new Label(" Phone: ");
		Label CAcustEmailLabel = new Label(" Email: ");
		Label CAservSchLabel = new Label(" Service Scheduled with: ");
		Label CAstoreCMLabel = new Label(" Store Closing Manager: ");
		Label CAserviceELabel = new Label(" Service Frequency ");
		Label CALastHydroLabel = new Label(" Last Hydro Test: ");
		
		TextField CAtfcustPhone = new TextField();
			CAtfcustPhone.setFont(new Font("Cambria", 10));
			CAtfcustPhone.setMaxWidth(200);
		TextField CAtfcustName = new TextField();
			CAtfcustName.setFont(new Font("Cambria", 10));
			CAtfcustName.setMaxWidth(200);
		TextField CAtfcustAdr = new TextField();
			CAtfcustAdr.setFont(new Font("Cambria", 10));
			CAtfcustAdr.setMaxWidth(200);
		TextField CAtfcustAdrCity = new TextField();
			CAtfcustAdrCity.setFont(new Font("Cambria", 10));
			CAtfcustAdrCity.setMaxWidth(200);
		TextField CAtfcustAdrState = new TextField();
			CAtfcustAdrState.setFont(new Font("Cambria", 10));
			CAtfcustAdrState.setMaxWidth(200);
		TextField CAtfcustAdrZip = new TextField();
			CAtfcustAdrZip.setFont(new Font("Cambria", 10));
			CAtfcustAdrZip.setMaxWidth(200);
		TextField CAservSchTF = new TextField();
			CAservSchTF.setMaxWidth(200);
			CAservSchTF.setFont(new Font("Cambria", 10));
		TextField CAstoreCMTF = new TextField();
			CAstoreCMTF.setFont(new Font("Cambria", 10));
			CAstoreCMTF.setMaxWidth(200);
		TextField CAEmailTF = new TextField();
			CAEmailTF.setFont(new Font("Cambria", 10));
			CAEmailTF.setMaxWidth(200);
		
		ComboBox<String> CAserviceECB = new ComboBox<String>();
			CAserviceECB.getItems().addAll("Annually", "Bi-Annually", "Quarterly");
			CAserviceECB.setValue("Annually");
		
		DatePicker CALastHydroDP = new DatePicker(GENdateNow);
		
		Button CAbtFin = new Button("Finish");
			CAbtFin.setOnAction(e -> {
				String client = CAtfcustName.getText().trim();
				String address = CAtfcustAdr.getText().trim();
				String city = CAtfcustAdrCity.getText().trim();
				String state = CAtfcustAdrState.getText().trim();
				String zip= CAtfcustAdrZip.getText().trim();
				String phone= CAtfcustPhone.getText().trim();
				String SSw = CAservSchTF.getText().trim();
				String SCM = CAstoreCMTF.getText().trim();
				String SF = CAserviceECB.getValue().trim();
				String email = CAEmailTF.getText().trim();
				LocalDate LastHydro = CALastHydroDP.getValue();
				
				CusOb obj = new CusOb(client,address,city,state,zip,phone,SSw,SCM,SF,email,LastHydro);
				
				System.out.println("Saving Customer List via saveCust()");
				try {
					saveCust(obj);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
			
		Button CABackBT = new Button("Return to Main Menu");
			CABackBT.setOnAction(e ->{
				try {start(primaryStage);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			});
			
		Button CAbtCreate = new Button("Create");
			CAbtCreate.setOnAction(e -> {
				String client = "Customer Name";
						CAtfcustName.setText(client);
				String address = "The Black Pearl";
						CAtfcustAdr.setText(address);
				String city = "Davey jones' Locker";
						CAtfcustAdrCity.setText(city);
				String state = "The Indian Ocean";
						CAtfcustAdrState.setText(state);
				String zip = "84701";
						CAtfcustAdrZip.setText(zip);
				String phone = "ButWhyIsTheRumGone@pirates.com";
						CAtfcustPhone.setText(phone);
				String email = "(435)-896-5555";
						CAtfcustPhone.setText(email);
				String SSw = "Captain";
						CAservSchTF.setText(SSw);
				String SCM = "Jack Sparrow";
						CAstoreCMTF.setText(SCM);
				String SF = "Annually";
						CAserviceECB.setValue(SF);
				LocalDate LastHydro = LocalDate.now();
						CALastHydroDP.setValue(LastHydro);
			});
							
		GridPane CAservGrid = new GridPane();
			CAservGrid.setMinSize(400, 100);
			CAservGrid.setAlignment(Pos.TOP_LEFT);
			
			CAservGrid.add(CATLabel1,0,0);
			CAservGrid.add(CATLabel2,1,0);
			
			CAservGrid.add(CAcustNameLabel,0,1);
			CAservGrid.add(CAtfcustName,1,1);
			
			CAservGrid.add(CAcustAdrLabel,0,2);
			CAservGrid.add(CAtfcustAdr,1,2);
			
			CAservGrid.add(CAcustAdrCityLabel,0,3);
			CAservGrid.add(CAtfcustAdrCity,1,3);
			
			CAservGrid.add(CAcustAdrStateLabel,0,4);
			CAservGrid.add(CAtfcustAdrState,1,4);
			
			CAservGrid.add(CAcustAdrZipLabel,0,5);
			CAservGrid.add(CAtfcustAdrZip,1,5);
			
			CAservGrid.add(CAcustPhoneLabel,0,6);
			CAservGrid.add(CAtfcustPhone,1,6);
			
			CAservGrid.add(CAcustEmailLabel,0,7);
			CAservGrid.add(CAEmailTF,1,7);
			
			CAservGrid.add(CAservSchLabel,0,8);
			CAservGrid.add(CAservSchTF,1,8);
			
			CAservGrid.add(CAstoreCMLabel,0,9);
			CAservGrid.add(CAstoreCMTF,1,9);
			
			CAservGrid.add(CAserviceELabel,0,10);
			CAservGrid.add(CAserviceECB,1,10);
			
			CAservGrid.add(CALastHydroLabel, 0, 11);
			CAservGrid.add(CALastHydroDP, 1, 11);
			
			CAservGrid.add(CAbtFin, 1, 12);
			CAservGrid.add(CABackBT, 0, 12);
			//CAservGrid.add(CAbtCreate, 2, 10); //this is for debugging
		
		CAhb1.getChildren().addAll(CAheadPane, CAservGrid);
		CAmainVB.getChildren().addAll(CAhb1);
		Scene CAscene = new Scene(CAsp , 700, 400);
		
		primaryStage.setTitle("HCRGen/ADMIN/Add new Client");
		primaryStage.setX(0);
		primaryStage.setY(0);
		primaryStage.setMinWidth(725);
		primaryStage.setMaxWidth(725);
		primaryStage.setMinHeight(450);
		primaryStage.setMaxHeight(450);
		primaryStage.setScene(CAscene);
		primaryStage.show();
	}
	
	/** Edit Client information window "CE" makes editing customer object values possible
	 */
	public void CEstart(Stage primaryStage) throws FileNotFoundException{
		ScrollPane CEsp = new ScrollPane();	
			CEsp.setCache(false);
		VBox.setVgrow(CEsp, Priority.ALWAYS);

		VBox CEmainVB = new VBox();
			CEmainVB.setMinSize(400, 250);
			CEmainVB.setPadding(new Insets(10,10,10,10));
			CEmainVB.setAlignment(Pos.TOP_CENTER);
		
			CEsp.setContent(CEmainVB);
		
		HBox CEhb1 = new HBox();
			CEhb1.setAlignment(Pos.TOP_CENTER);
			CEhb1.setPadding(new Insets(10,10,10,10));
			CEhb1.setSpacing(10);
		
		//create GridPane for the logo, business information and invoice Box
		GridPane CEheadPane = new GridPane();
			CEheadPane.setMinSize(200, 100);
			CEheadPane.setPadding(new Insets(10,10,10,10));
			CEheadPane.setVgap(50);
			CEheadPane.setHgap(60);
			CEheadPane.setAlignment(Pos.TOP_LEFT);
			CEheadPane.setGridLinesVisible(false);
		
		//create ImageView for logo and place in the grid
		File CEf = new File("TONGS-FIRE-EXTINGUISHER-SALES-AND-SERVICE.jpg");
		String CEfilLoc = CEf.getAbsolutePath();
		
		//Creating a Label
		Label CElogo = new Label();
				
		//Creating a graphic
		Image CEimg = new Image(new FileInputStream(CEfilLoc));
		ImageView CEview = new ImageView(CEimg);
			CEview.setFitHeight(125);
			CEview.setFitWidth(225);
			CEview.setPreserveRatio(false);
		
			CElogo.setGraphic(CEview);
			CEheadPane.add(CElogo, 0,0);		
		
		//Create Service Schedule Information box
		Label CETLabel1 = new Label("Edit Ex");
			CETLabel1.setFont(new Font("Cambria", 45));
		Label CETLabel2 = new Label("isting Client");
			CETLabel2.setFont(new Font("Cambria", 45));
		Label CEcustNameLabel = new Label(" Client: ");
		Label CEcustAdrLabel = new Label(" Address: ");
		Label CEcustAdrCityLabel = new Label(" City: ");
		Label CEcustAdrStateLabel = new Label(" State: ");
		Label CEcustAdrZipLabel = new Label(" Zip: ");
		Label CEcustPhoneLabel = new Label(" Phone: ");
		Label CEcustEmailLabel = new Label(" Email: ");
		Label CEservSchLabel = new Label(" Service Scheduled with: ");
		Label CEstoreCMLabel = new Label(" Store Closing Manager: ");
		Label CEserviceELabel = new Label(" Service Frequency ");
		Label CELastHydroLabel = new Label(" Last Hydro Test ");

		TextField CEtfcustName = new TextField();
			CEtfcustName.setFont(new Font("Cambria", 10));
			CEtfcustName.setMaxWidth(200);
		TextField CEtfcustAdr = new TextField();
			CEtfcustAdr.setFont(new Font("Cambria", 10));
			CEtfcustAdr.setMaxWidth(200);
		TextField CEtfcustAdrCity = new TextField();
			CEtfcustAdrCity.setFont(new Font("Cambria", 10));
			CEtfcustAdrCity.setMaxWidth(200);
		TextField CEtfcustAdrState = new TextField();
			CEtfcustAdrState.setFont(new Font("Cambria", 10));
			CEtfcustAdrState.setMaxWidth(200);
		TextField CEtfcustAdrZip = new TextField();
			CEtfcustAdrZip.setFont(new Font("Cambria", 10));
			CEtfcustAdrZip.setMaxWidth(200);
		TextField CEtfcustPhone = new TextField();
			CEtfcustPhone.setFont(new Font("Cambria", 10));
			CEtfcustPhone.setMaxWidth(200);
		TextField CEservSchTF = new TextField();
			CEservSchTF.setMaxWidth(200);
			CEservSchTF.setFont(new Font("Cambria", 10));
		TextField CEstoreCMTF = new TextField();
			CEstoreCMTF.setFont(new Font("Cambria", 10));
			CEstoreCMTF.setMaxWidth(200);
		TextField CEcustEmailTF = new TextField();
			CEcustEmailTF.setFont(new Font("Cambria", 10));
			CEcustEmailTF.setMaxWidth(200);
		
		DatePicker CELastHydroDP = new DatePicker();
			
		
		ComboBox<String> CEserviceECB = new ComboBox<String>();
			CEserviceECB.getItems().addAll("Annually", "Bi-Annually", "Quarterly");
						
		Button CEbtFin = new Button("Save Changes");
			CEbtFin.setOnAction(e ->{ 
				String client1 = CEtfcustName.getText().trim();
				String address1 = CEtfcustAdr.getText().trim();
				String city1 = CEtfcustAdrCity.getText().trim();
				String state1 = CEtfcustAdrState.getText().trim();
				String zip1 = CEtfcustAdrZip.getText().trim();
				String phone1= CEtfcustPhone.getText().trim();
				String SSw1 = CEservSchTF.getText().trim();
				String SCM1 = CEstoreCMTF.getText().trim();
				String SF1 = CEserviceECB.getValue().trim();
				String email1 = CEcustEmailTF.getText().trim();
				LocalDate LastHydro1 = CELastHydroDP.getValue();
				
				CusOb obj = new CusOb(client1,address1,city1,state1,zip1,phone1,SSw1,SCM1,SF1,email1,LastHydro1);
				
				System.out.println("Saving Customer List! saveCust()");
				try {
					saveCust(obj);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
		
		Button CEFillBT = new Button("Get Info");
			CEFillBT.setFont(new Font("Cambria", 9));
			CEFillBT.setOnAction(e ->{		
				if (CEtfcustName.getText().equals("")) {
					CEtfcustName.setText("Name Required!");
				}
				else if(CEtfcustName.getText().equals("Name Required!")) {
					CEtfcustName.setText("Name Required!");
				}
				else {
    			CEtfcustName.setText( ((CusOb) clientmap.get(CEtfcustName.getText())).getClient().toString());
    			CEtfcustAdr.setText( ((CusOb) clientmap.get(CEtfcustName.getText())).getAddress().toString());
    		 	CEtfcustAdrCity.setText( ((CusOb) clientmap.get(CEtfcustName.getText())).getCity().toString());
    		 	CEtfcustAdrState.setText( ((CusOb) clientmap.get(CEtfcustName.getText())).getState().toString());
    		 	CEtfcustAdrZip.setText( ((CusOb) clientmap.get(CEtfcustName.getText())).getZip().toString());
    		 	CEtfcustPhone.setText( ((CusOb) clientmap.get(CEtfcustName.getText())).getPhone().toString());
    			CEservSchTF.setText( ((CusOb) clientmap.get(CEtfcustName.getText())).getSSw().toString());
    		 	CEstoreCMTF.setText( ((CusOb) clientmap.get(CEtfcustName.getText())).getSCM().toString());
    			CEserviceECB.setValue( ((CusOb) clientmap.get(CEtfcustName.getText())).getSF().toString());
    			CEcustEmailTF.setText( ((CusOb) clientmap.get(CEtfcustName.getText())).getEmail().toString());
    		 	CELastHydroDP.setId( ((CusOb) clientmap.get(CEtfcustName.getText())).getLastHydro().toString());
				}
			});
		Button CEBackBT = new Button("Return to Main Menu");
			CEBackBT.setOnAction(e ->{
				try {start(primaryStage);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			});
		Button CERemBT = new Button("Remove");
			CERemBT.setFont(new Font("Cambria", 9));
			CERemBT.setOnAction(e ->{
				clientmap.remove(CEtfcustName.getText().trim());
				ObjectOutputStream oos;
				try {
					oos = new ObjectOutputStream(new FileOutputStream(mapFile + "/" + "ClientList.bin"));
					oos.writeObject(clientmap);
					System.out.println("Client Removed!");
					oos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
		Button CEListBT = new Button("List All");	
			CEListBT.setFont(new Font("Cambria", 9));
			CEListBT.setOnAction(e ->{
				custList();
			});
			
		GridPane CEservGrid = new GridPane();
			CEservGrid.setMinSize(400, 100);
			CEservGrid.setAlignment(Pos.TOP_LEFT);
			
			CEservGrid.add(CETLabel1,0,0);
			CEservGrid.add(CETLabel2,1,0);
			
			CEservGrid.add(CEcustNameLabel,0,1);
			CEservGrid.add(CEtfcustName,1,1);
			CEservGrid.add(CEFillBT,2,1);
			
			CEservGrid.add(CEcustAdrLabel,0,2);
			CEservGrid.add(CEtfcustAdr,1,2);
			CEservGrid.add(CEListBT,2,2);
			
			CEservGrid.add(CEcustAdrCityLabel,0,3);
			CEservGrid.add(CEtfcustAdrCity,1,3);
			
			CEservGrid.add(CEcustAdrStateLabel,0,4);
			CEservGrid.add(CEtfcustAdrState,1,4);
			
			CEservGrid.add(CEcustAdrZipLabel,0,5);
			CEservGrid.add(CEtfcustAdrZip,1,5);
			
			CEservGrid.add(CEcustPhoneLabel,0,6);
			CEservGrid.add(CEtfcustPhone,1,6);
			CEservGrid.add(CERemBT, 2,6);
			
			CEservGrid.add(CEcustEmailLabel,0,7);
			CEservGrid.add(CEcustEmailTF,1,7);
			
			CEservGrid.add(CEservSchLabel,0,8);
			CEservGrid.add(CEservSchTF,1,8);
			
			CEservGrid.add(CEstoreCMLabel,0,9);
			CEservGrid.add(CEstoreCMTF,1,9);
			
			CEservGrid.add(CEserviceELabel,0,10);
			CEservGrid.add(CEserviceECB,1,10);
		
			CEservGrid.add(CELastHydroLabel,0,11);
			CEservGrid.add(CELastHydroDP,1,11);
			
			CEservGrid.add(CEbtFin, 1, 12);
			CEservGrid.add(CEBackBT, 0, 12);
			
			CEhb1.getChildren().addAll(CEheadPane, CEservGrid);
			CEmainVB.getChildren().addAll(CEhb1);
		Scene CEscene = new Scene(CEsp , 700, 400);
		
			primaryStage.setTitle("HCRGen/ADMIN/Edit Existing Client");
			primaryStage.setX(0);
			primaryStage.setY(0);
			primaryStage.setMinWidth(725);
			primaryStage.setMaxWidth(725);
			primaryStage.setMinHeight(450);
			primaryStage.setMaxHeight(450);
			primaryStage.setScene(CEscene);
			primaryStage.show();
	}
	
	/** Technician add window method
	 * @throws FileNotFoundException 
	 * 
	 */
	public void TAstart(Stage primaryStage) throws FileNotFoundException {
		
		ScrollPane TAsp = new ScrollPane();	
			TAsp.setCache(false);
		VBox.setVgrow(TAsp, Priority.ALWAYS);
		HBox TAHB1 = new HBox();
		VBox TAmainVB = new VBox();
			TAmainVB.setMinSize(400, 250);
			TAmainVB.setPadding(new Insets(10,10,10,10));
			TAmainVB.setAlignment(Pos.TOP_CENTER);
		
			TAsp.setContent(TAmainVB);
		
		//create GridPane for the logo, business information and invoice Box
		GridPane TAheadPane = new GridPane();
			TAheadPane.setMinSize(200, 100);
			TAheadPane.setPadding(new Insets(10,10,10,10));
			TAheadPane.setVgap(5);
			TAheadPane.setHgap(0);
			TAheadPane.setAlignment(Pos.TOP_LEFT);
			TAheadPane.setGridLinesVisible(false);
		
		//create ImageView for logo and place in the grid
		File TAf = new File("TONGS-FIRE-EXTINGUISHER-SALES-AND-SERVICE.jpg");
		String TAfilLoc = TAf.getAbsolutePath();
		Label TAlogo = new Label();

		Image TAimg = new Image(new FileInputStream(TAfilLoc));
		ImageView TAview = new ImageView(TAimg);
			TAview.setFitHeight(125);
			TAview.setFitWidth(225);
			TAview.setPreserveRatio(false);
		
			TAlogo.setGraphic(TAview);
		
		Label TATLabel1 = new Label("New Te");
			TATLabel1.setFont(new Font("Cambria", 45));
		Label TATLabel2 = new Label("chnician");
			TATLabel2.setFont(new Font("Cambria", 45));
		Label TANameLabel = new Label(" Name: ");
		Label TAAdrLabel = new Label(" Address: ");
		Label TACityLabel = new Label(" City: ");
		Label TAStateLabel = new Label(" State: ");
		Label TAZipLabel = new Label(" Zip Code: ");
		Label TAPhoneLabel = new Label(" Phone Number: ");
		Label TAEmailLabel = new Label(" Email: ");
		Label TALicLabel = new Label(" License Number: ");
		Label TADateLabel = new Label(" Hire Date: ");
		
		TextField TANameTF = new TextField();
			TANameTF.setFont(new Font("Cambria", 10));
			TANameTF.setMaxWidth(200);
		TextField TAAdrTF = new TextField();
			TAAdrTF.setFont(new Font("Cambria", 10));
			TAAdrTF.setMaxWidth(200);
		TextField TACityTF = new TextField();
			TACityTF.setFont(new Font("Cambria", 10));
			TACityTF.setMaxWidth(200);
		TextField TAStateTF = new TextField();
			TAStateTF.setFont(new Font("Cambria", 10));
			TAStateTF.setMaxWidth(200);
		TextField TAZipTF = new TextField();
			TAZipTF.setFont(new Font("Cambria", 10));
			TAZipTF.setMaxWidth(200);
		TextField TAPhoneTF = new TextField();
			TAPhoneTF.setFont(new Font("Cambria", 10));
			TAPhoneTF.setMaxWidth(200);
		TextField TAEmailTF = new TextField();
			TAEmailTF.setFont(new Font("Cambria", 10));
			TAEmailTF.setMaxWidth(200);
		TextField TALicTF = new TextField();
			TALicTF.setFont(new Font("Cambria", 10));
			TALicTF.setMaxWidth(200);
		
		TextField TADateTF = new TextField();
		
		Button TABackBT = new Button("Return to Main Menu");
			TABackBT.setOnAction(e ->{
				try {start(primaryStage);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			});
		Button TASubBT = new Button("Save Changes");
			TASubBT.setOnAction(e ->{
				String TAName = TANameTF.getText().trim();
				String TAAdr = TAAdrTF.getText().trim();
				String TACity = TACityTF.getText().trim();
				String TAState = TAStateTF.getText().trim();
				String TAZip = TAZipTF.getText().trim();
				String TAPhone= TAPhoneTF.getText().trim();
				String TALic = TALicTF.getText().trim();
				String TAEmail = TAEmailTF.getText().trim();
				String TADate = TADateTF.getText().trim();
				
				TechOb obj = new TechOb(TAName,TAAdr,TACity,TAState,TAZip,TAPhone,TALic,TAEmail,TADate);
				
				try {
					System.out.println("Saving technician List! saveTech()");
					saveTech(obj);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
		
			TAheadPane.add(TATLabel1, 1,0);
			TAheadPane.add(TANameLabel, 1,1);
			TAheadPane.add(TAAdrLabel, 1,2);
			TAheadPane.add(TACityLabel, 1,3);
			TAheadPane.add(TAStateLabel, 1,4);
			TAheadPane.add(TAZipLabel, 1,5);
			TAheadPane.add(TAPhoneLabel, 1,6);
			TAheadPane.add(TAEmailLabel, 1,7);
			TAheadPane.add(TALicLabel, 1,8);
			TAheadPane.add(TADateLabel, 1,9);
			
			TAheadPane.add(TATLabel2, 2,0);
			TAheadPane.add(TANameTF, 2,1);
			TAheadPane.add(TAAdrTF, 2,2);
			TAheadPane.add(TACityTF, 2,3);
			TAheadPane.add(TAStateTF, 2,4);
			TAheadPane.add(TAZipTF, 2,5);
			TAheadPane.add(TAPhoneTF, 2,6);
			TAheadPane.add(TAEmailTF, 2,7);
			TAheadPane.add(TALicTF, 2,8);
			TAheadPane.add(TADateTF, 2,9);
			
			TAheadPane.add(TABackBT, 1,10);
			TAheadPane.add(TASubBT, 2,10);
			
			TAHB1.getChildren().addAll(TAlogo, TAheadPane);
			
			TAmainVB.getChildren().addAll(TAHB1);
		Scene TAscene = new Scene(TAsp , 700, 400);
		
			primaryStage.setTitle("HCRGen/ADMIN/Add new Technician");
			primaryStage.setX(0);
			primaryStage.setY(0);
			primaryStage.setMinWidth(725);
			primaryStage.setMaxWidth(725);
			primaryStage.setMinHeight(450);
			primaryStage.setMaxHeight(450);
			primaryStage.setScene(TAscene);
			primaryStage.show();
	}
	
	/** Technician edit window method
	 * @throws FileNotFoundException 
	 * 
	 */
	public void TEstart(Stage primaryStage) throws FileNotFoundException {
		
		ScrollPane TEsp = new ScrollPane();	
			TEsp.setCache(false);
		VBox.setVgrow(TEsp, Priority.ALWAYS);

		HBox TEHB1 = new HBox();
		
		VBox TEmainVB = new VBox();
			TEmainVB.setMinSize(400, 250);
			TEmainVB.setPadding(new Insets(10,10,10,10));
			TEmainVB.setAlignment(Pos.TOP_CENTER);
		
		TEsp.setContent(TEmainVB);
		
		//create GridPane for the logo, business information and invoice Box
		GridPane TEheadPane = new GridPane();
			TEheadPane.setMinSize(200, 100);
			TEheadPane.setPadding(new Insets(10,10,10,10));
			TEheadPane.setVgap(5);
			TEheadPane.setHgap(0);
			TEheadPane.setAlignment(Pos.TOP_LEFT);
			TEheadPane.setGridLinesVisible(false);
		
		//create ImageView for logo and place in the grid
		File TEf = new File("TONGS-FIRE-EXTINGUISHER-SALES-AND-SERVICE.jpg");
		String TEfilLoc = TEf.getAbsolutePath();
		Label TElogo = new Label();

		Image TEimg = new Image(new FileInputStream(TEfilLoc));
		ImageView TEview = new ImageView(TEimg);
			TEview.setFitHeight(125);
			TEview.setFitWidth(225);
			TEview.setPreserveRatio(false);
		
		TElogo.setGraphic(TEview);
		
		Label TETLabel1 = new Label("Existing");
			TETLabel1.setFont(new Font("Cambria", 45));
		Label TETLabel2 = new Label(" Technician");
			TETLabel2.setFont(new Font("Cambria", 45));
		Label TENameLabel = new Label(" Name: ");
		Label TEAdrLabel = new Label(" Address: ");
		Label TECityLabel = new Label(" City: ");
		Label TEStateLabel = new Label(" State: ");
		Label TEZipLabel = new Label(" Zip Code: ");
		Label TEPhoneLabel = new Label(" Phone Number: ");
		Label TEEmailLabel = new Label(" Email: ");
		Label TELicLabel = new Label(" License Number: ");
		Label TEDateLabel = new Label(" Hire Date: ");
		
		TextField TENameTF = new TextField();
			TENameTF.setFont(new Font("Cambria", 10));
			TENameTF.setMaxWidth(200);
		TextField TEAdrTF = new TextField();
			TEAdrTF.setFont(new Font("Cambria", 10));
			TEAdrTF.setMaxWidth(200);
		TextField TECityTF = new TextField();
			TECityTF.setFont(new Font("Cambria", 10));
			TECityTF.setMaxWidth(200);
		TextField TEStateTF = new TextField();
			TEStateTF.setFont(new Font("Cambria", 10));
			TEStateTF.setMaxWidth(200);
		TextField TEZipTF = new TextField();
			TEZipTF.setFont(new Font("Cambria", 10));
			TEZipTF.setMaxWidth(200);
		TextField TEPhoneTF = new TextField();
			TEPhoneTF.setFont(new Font("Cambria", 10));
			TEPhoneTF.setMaxWidth(200);
		TextField TEEmailTF = new TextField();
			TEEmailTF.setFont(new Font("Cambria", 10));
			TEEmailTF.setMaxWidth(200);
		TextField TELicTF = new TextField();
			TELicTF.setFont(new Font("Cambria", 10));
			TELicTF.setMaxWidth(200);
		TextField TEDateTF = new TextField();
			TEDateTF.setFont(new Font("Cambria", 10));
			TEDateTF.setMaxWidth(200);
		
		Button TEFillBT = new Button("Get Info");
			TEFillBT.setFont(new Font("Cambria", 9));
			TEFillBT.setOnAction(e ->{
				if (TENameTF.getText().equals("")) {
					TENameTF.setText("Name Required!");
				}
				else if(TENameTF.getText().equals("Name Required!")) {
					TENameTF.setText("Name Required!");
				}
				else {
    			TENameTF.setText( ((TechOb) techmap.get(TENameTF.getText())).getTechName().toString());
    			TEAdrTF.setText( ((TechOb) techmap.get(TENameTF.getText())).getTechAdd().toString());
    		 	TECityTF.setText( ((TechOb) techmap.get(TENameTF.getText())).getTechCity().toString());
    		 	TEStateTF.setText( ((TechOb) techmap.get(TENameTF.getText())).getTechState().toString());
    		 	TEZipTF.setText( ((TechOb) techmap.get(TENameTF.getText())).getTechZip().toString());
    		 	TEPhoneTF.setText( ((TechOb) techmap.get(TENameTF.getText())).getTechPhone().toString());
    			TEEmailTF.setText( ((TechOb) techmap.get(TENameTF.getText())).getTechEmail().toString());
    		 	TELicTF.setText( ((TechOb) techmap.get(TENameTF.getText())).getTechLic().toString());
    		 	TEDateTF.setText( ((TechOb) techmap.get(TENameTF.getText())).getTechDate().toString());
				}
			});
		Button TESrchBT = new Button("List All");
			TESrchBT.setFont(new Font("Cambria", 9));
			TESrchBT.setOnAction(e ->{
				techList();
			});
		Button TEBackBT = new Button("Return to Main Menu");
			TEBackBT.setOnAction(e ->{
				try {start(primaryStage);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			});
		Button TESubBT = new Button("Save Changes");
			TESubBT.setOnAction(e->{
				String TEName = TENameTF.getText().trim();
				String TEAdr = TEAdrTF.getText().trim();
				String TECity = TECityTF.getText().trim();
				String TEState = TEStateTF.getText().trim();
				String TEZip = TEZipTF.getText().trim();
				String TEPhone= TEPhoneTF.getText().trim();
				String TELic = TELicTF.getText().trim();
				String TEEmail = TEEmailTF.getText().trim();
				String TEDate = TEDateTF.getText().trim();
				
				TechOb obj = new TechOb(TEName,TEAdr,TECity,TEState,TEZip,TEPhone,TELic,TEEmail,TEDate);
				
				System.out.println("Saving technician List! saveTech()");
				try {
					saveTech(obj);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
		Button TERemBT = new Button("Remove");
			TERemBT.setFont(new Font("Cambria", 9));
			TERemBT.setOnAction(e ->{
				techmap.remove(TENameTF.getText().trim());
				ObjectOutputStream oos;
				try {
					oos = new ObjectOutputStream(new FileOutputStream(mapFile + "/" + "TechList.bin"));
					oos.writeObject(techmap);
					System.out.println("Technician Removed!");
					oos.close();
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				techlist.clear();
				try {
					getTech();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
			
			TEheadPane.add(TETLabel1, 1,0);
			TEheadPane.add(TETLabel2, 2,0);
			
			TEheadPane.add(TENameLabel, 1,1);
			TEheadPane.add(TEAdrLabel, 1,2);
			TEheadPane.add(TECityLabel, 1,3);
			TEheadPane.add(TEStateLabel, 1,4);
			TEheadPane.add(TEZipLabel, 1,5);
			TEheadPane.add(TEPhoneLabel, 1,6);
			TEheadPane.add(TEEmailLabel, 1,7);
			TEheadPane.add(TELicLabel, 1,8);
			TEheadPane.add(TEDateLabel, 1,9);
			
			TEheadPane.add(TENameTF, 2,1);
			TEheadPane.add(TEAdrTF, 2,2);
			TEheadPane.add(TECityTF, 2,3);
			TEheadPane.add(TEStateTF, 2,4);
			TEheadPane.add(TEZipTF, 2,5);
			TEheadPane.add(TEPhoneTF, 2,6);
			TEheadPane.add(TEEmailTF, 2,7);
			TEheadPane.add(TELicTF, 2,8);
			TEheadPane.add(TEDateTF, 2,9);
			
			TEheadPane.add(TEFillBT,3,1);
			TEheadPane.add(TESrchBT,3,2);
			TEheadPane.add(TERemBT, 3,6);
			TEheadPane.add(TEBackBT, 1,10);
			TEheadPane.add(TESubBT, 2,10);
			
			TEHB1.getChildren().addAll(TElogo, TEheadPane);
			
			TEmainVB.getChildren().addAll(TEHB1);
		Scene TEscene = new Scene(TEsp , 700, 400);
		
			primaryStage.setTitle("HCRGen/ADMIN/Edit Technician");
			primaryStage.setX(0);
			primaryStage.setY(0);
			primaryStage.setMinWidth(725);
			primaryStage.setMaxWidth(725);
			primaryStage.setMinHeight(450);
			primaryStage.setMaxHeight(450);
			primaryStage.setScene(TEscene);
			primaryStage.show();
	}
	
	/** Business edit window method
	 * @throws FileNotFoundException 
	 * 
	 */
	public void BEstart(Stage primaryStage) throws FileNotFoundException {
		
		ScrollPane BEsp = new ScrollPane();	
			BEsp.setCache(false);
		VBox.setVgrow(BEsp, Priority.ALWAYS);

		HBox BEHB1 = new HBox();
		HBox BEHB2 = new HBox();
		
		VBox BEmainVB = new VBox();
			BEmainVB.setMinSize(400, 250);
			BEmainVB.setPadding(new Insets(10,10,10,10));
			BEmainVB.setAlignment(Pos.TOP_CENTER);
		
		BEsp.setContent(BEmainVB);
		
		//create GridPane for the logo, business information and invoice Box
		GridPane BEheadPane = new GridPane();
			BEheadPane.setMinSize(200, 100);
			BEheadPane.setPadding(new Insets(10,10,10,10));
			BEheadPane.setVgap(5);
			BEheadPane.setHgap(0);
			BEheadPane.setAlignment(Pos.TOP_LEFT);
			BEheadPane.setGridLinesVisible(false);
		
		//create ImageView for logo and place in the grid
		File BEf = new File("TONGS-FIRE-EXTINGUISHER-SALES-AND-SERVICE.jpg");
		String BEfilLoc = BEf.getAbsolutePath();
		Label BElogo = new Label();

		Image BEimg = new Image(new FileInputStream(BEfilLoc));
		ImageView BEview = new ImageView(BEimg);
			BEview.setFitHeight(125);
			BEview.setFitWidth(225);
			BEview.setPreserveRatio(false);
		
		BElogo.setGraphic(BEview);
		
		Label BETLabel1 = new Label("Edit Buis");
			BETLabel1.setFont(new Font("Cambria", 45));
		Label BETLabel2 = new Label("ness Info");
			BETLabel2.setFont(new Font("Cambria", 45));
		Label BENameLabel = new Label(" Business Name: ");
		Label BEAdrLabel = new Label(" Address: ");
		Label BECityLabel = new Label(" City: ");
		Label BEStateLabel = new Label(" State: ");
		Label BEZipLabel = new Label(" Zip Code: ");
		Label BEPhoneLabel = new Label(" Phone Number: ");
		Label BEEmailLabel = new Label(" Email: ");
		Label BELicLabel = new Label(" License Number: ");
		Label BEPWLabel = new Label("Password: ");
		Label BEPWQ1Label = new Label("Enable Password Protection?");
				
		TextField BENameTF = new TextField(busmap.get(1));
			BENameTF.setFont(new Font("Cambria", 10));
			BENameTF.setMaxWidth(250);
			BENameTF.setMinWidth(250);
		TextField BEAdrTF = new TextField(busmap.get(2));
			BEAdrTF.setFont(new Font("Cambria", 10));
			BEAdrTF.setMaxWidth(250);
			BEAdrTF.setMinWidth(250);
		TextField BECityTF = new TextField(busmap.get(3));
			BECityTF.setFont(new Font("Cambria", 10));
			BECityTF.setMaxWidth(250);
			BECityTF.setMinWidth(250);
		TextField BEStateTF = new TextField(busmap.get(4));
			BEStateTF.setFont(new Font("Cambria", 10));
			BEStateTF.setMaxWidth(250);
			BEStateTF.setMinWidth(250);
		TextField BEZipTF = new TextField(busmap.get(5));
			BEZipTF.setFont(new Font("Cambria", 10));
			BEZipTF.setMaxWidth(250);
			BEZipTF.setMinWidth(250);
		TextField BEPhoneTF = new TextField(busmap.get(6));
			BEPhoneTF.setFont(new Font("Cambria", 10));
			BEPhoneTF.setMaxWidth(250);
			BEPhoneTF.setMinWidth(250);
		TextField BEEmailTF = new TextField(busmap.get(7));
			BEEmailTF.setFont(new Font("Cambria", 10));
			BEEmailTF.setMaxWidth(250);
			BEEmailTF.setMinWidth(250);
		TextField BELicTF = new TextField(busmap.get(8));
			BELicTF.setFont(new Font("Cambria", 10));
			BELicTF.setMaxWidth(250);
			BELicTF.setMinWidth(250);
		TextField BEPWTF = new TextField(busmap.get(9));
			BEPWTF.setFont(new Font("Cambria", 10));
			BEPWTF.setMaxWidth(250);
			BEPWTF.setMinWidth(250);
			
		ToggleGroup BEPWRBTG = new ToggleGroup();
		RadioButton BEPW1RB = new RadioButton("Yes "); 	
			BEPW1RB.setToggleGroup(BEPWRBTG);
			BEPW1RB.setOnAction(e ->{
				setPWProT(passProtection, "BEPW1RB");
			});
		RadioButton BEPW2RB = new RadioButton("No"); 
			BEPW2RB.setToggleGroup(BEPWRBTG);
			BEPW2RB.setOnAction(e -> {
				setPWProF(passProtection, "BEPW1RB");
			});
			
			BEHB2.getChildren().addAll(BEPW1RB,BEPW2RB);
		
		Button BEBackBT = new Button("Return to Main Menu");
			BEBackBT.setOnAction(e ->{
				try {start(primaryStage);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			});
			
		Button BESubBT = new Button("Save Changes");
			BESubBT.setOnAction(e ->{	
				busmap.put(1, BENameTF.getText().trim());
				busmap.put(2, BEAdrTF.getText().trim());
				busmap.put(3, BECityTF.getText().trim());
				busmap.put(4, BEStateTF.getText().trim());
				busmap.put(5, BEZipTF.getText().trim());
				busmap.put(6, BEPhoneTF.getText().trim());
				busmap.put(7, BEEmailTF.getText().trim());
				busmap.put(8, BELicTF.getText().trim());
				busmap.put(9, BEPWTF.getText().trim());
				
					if (passProtection == true)
						busmap.put(10, "True");
					else if (passProtection != false)
						busmap.put(10, "False");
					
				try {
					saveBus();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
			
			if (passProtection == true) {
				BEPW1RB.setSelected(true);
			}
			else if (passProtection != true) {
				BEPW2RB.setSelected(true);
			}
			
			BEheadPane.add(BETLabel1, 1,0);
			BEheadPane.add(BENameLabel, 1,1);
			BEheadPane.add(BEAdrLabel, 1,2);
			BEheadPane.add(BECityLabel, 1,3);
			BEheadPane.add(BEStateLabel, 1,4);
			BEheadPane.add(BEZipLabel, 1,5);
			BEheadPane.add(BEPhoneLabel, 1,6);
			BEheadPane.add(BEEmailLabel, 1,7);
			BEheadPane.add(BELicLabel, 1,8);
			BEheadPane.add(BEPWLabel, 1,10);
			BEheadPane.add(BEPWQ1Label, 1,9);
			BEheadPane.add(BEHB2, 2,9);
						
			BEheadPane.add(BETLabel2, 2,0);
			BEheadPane.add(BENameTF, 2,1);
			BEheadPane.add(BEAdrTF, 2,2);
			BEheadPane.add(BECityTF, 2,3);
			BEheadPane.add(BEStateTF, 2,4);
			BEheadPane.add(BEZipTF, 2,5);
			BEheadPane.add(BEPhoneTF, 2,6);
			BEheadPane.add(BEEmailTF, 2,7);
			BEheadPane.add(BELicTF, 2,8);
			BEheadPane.add(BEPWTF, 2,10);
			
			
			BEheadPane.add(BEBackBT, 1,11);
			BEheadPane.add(BESubBT, 2,11);
			
			BEHB1.getChildren().addAll(BElogo, BEheadPane);
			
			BEmainVB.getChildren().addAll(BEHB1);
		Scene BEscene = new Scene(BEsp , 700, 400);
		
			primaryStage.setTitle("HCRGen/ADMIN/Edit Business Information");
			primaryStage.setX(0);
			primaryStage.setY(0);
			primaryStage.setMinWidth(725);
			primaryStage.setMaxWidth(725);
			primaryStage.setMinHeight(450);
			primaryStage.setMaxHeight(450);
			primaryStage.setScene(BEscene);
			primaryStage.show();
	}
	/** Password check window
	 * 
	 */
	public void passwordCheckWin(Stage primaryStage) {
		HBox PWWHBox = new HBox();
			PWWHBox.setAlignment(Pos.TOP_CENTER);
		Scene PWWScene = new Scene(PWWHBox , 270, 30);
		Stage PWWindow = new Stage();		
		
		TextField PWWTF = new TextField();
			PWWTF.setOnKeyPressed(ex -> {
				if (ex.getCode().equals(KeyCode.ENTER)) {
					if (PWWTF.getText().equals("MASTERKEY")) {
						try {
							startAdminWin(primaryStage);
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
						System.out.println("Master Key used!");
						PWWindow.close();
					}
					else if (PWWTF.getText().equals(GENBusinessPassword)) {
						try {
							startAdminWin(primaryStage);
							System.out.println("Password Confirmed!");
							PWWindow.close();
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
					}
					else if(!PWWTF.getText().equals(GENBusinessPassword)) {
						System.out.println("Password Did Not Match!");
						PWWindow.close();
					}
				}
				else if (ex.getCode().equals(KeyCode.ESCAPE)) {
					PWWindow.close();
				}	
			});
		Button PWWCancel = new Button("Cancel");
		
			PWWHBox.getChildren().addAll(PWWTF, PWWCancel);
			
			PWWindow.setTitle("Enter Password");
			PWWindow.setScene(PWWScene);
			PWWindow.setX(100);
			PWWindow.setY(350);
			PWWindow.setMinWidth(270);
			PWWindow.setMaxWidth(270);
			PWWindow.setMinHeight(90);
			PWWindow.setMaxHeight(90);	
			PWWindow.show();
	}
	
	/** Administration Pane:
	 * * Business Information window.
	 * * Technician add/edit window.
	 * * Customer add/edit window.
	 * @throws FileNotFoundException 
	 */
	public void startAdminWin(Stage primaryStage) throws FileNotFoundException {

		//create ImageView for the Company logo and place in the grid
		File ADMINf = new File("TONGS-FIRE-EXTINGUISHER-SALES-AND-SERVICE.jpg");
		String ADMINfilLoc = ADMINf.getAbsolutePath();
		
		//Creating a Graphical Label
		Label ADMINlogo = new Label();
			version.setFont(new Font("Kalam", 9));
		
		//Creating a graphic for the HCR window
		Image ADMINimg = new Image(new FileInputStream(ADMINfilLoc));
		ImageView ADMINview = new ImageView(ADMINimg);
			ADMINview.setFitHeight(200);
			ADMINview.setFitWidth(300);
			ADMINview.setPreserveRatio(false);
			
			ADMINlogo.setGraphic(ADMINview);
		
		//Create Start Window and add its components
		ScrollPane ADMINstartWindow = new ScrollPane();
			ADMINstartWindow.setCache(false);
		GridPane ADMINGrid = new GridPane();
			ADMINGrid.setMinSize(200, 100);
			ADMINGrid.setPadding(new Insets(10,10,10,10));
			ADMINGrid.setVgap(5);
			ADMINGrid.setHgap(5);
			ADMINGrid.setAlignment(Pos.TOP_LEFT);
			ADMINGrid.setGridLinesVisible(false);
		
		VBox ADMINmainVB = new VBox();
			ADMINmainVB.setMinSize(325, 300);
			ADMINmainVB.setPadding(new Insets(10,10,10,10));
			ADMINmainVB.setAlignment(Pos.TOP_LEFT);
			
		HBox ADMINCurVerHB = new HBox();
			ADMINCurVerHB.setAlignment(Pos.BOTTOM_RIGHT);
			ADMINCurVerHB.setPadding(new Insets(10,10,10,10));
			
		Label ADMINBusInL = new Label("Business Information: ");
			ADMINBusInL.setFont(new Font("Arial", 20));
		Label ADMINTechCL = new Label("Technician Controls: ");
			ADMINTechCL.setFont(new Font("Arial", 20));
		Label ADMINCustCL = new Label("Customer Controls:  ");
			ADMINCustCL.setFont(new Font("Arial", 20));
		
		VBox.setVgrow(ADMINstartWindow, Priority.ALWAYS);	
		
		Button ADMINBusBT = new Button("Edit");
			ADMINBusBT.setFont(new Font("Cambria", 9));
			ADMINBusBT.setOnAction(e ->{
				try {BEstart(primaryStage);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}); 
		Button ADMINTechABT = new Button("New");
			ADMINTechABT.setFont(new Font("Cambria", 9));
			ADMINTechABT.setOnAction(e ->{
				try {TAstart(primaryStage);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			});
		Button ADMINTechEBT = new Button("Edit");
			ADMINTechEBT.setFont(new Font("Cambria", 9));
			ADMINTechEBT.setOnAction(e ->{
				try {TEstart(primaryStage);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			});
		Button ADMINCustABT = new Button("New");
			ADMINCustABT.setFont(new Font("Cambria", 9));
			ADMINCustABT.setOnAction(e ->{
				try {CAstart(primaryStage);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			});
		Button ADMINCustEBT = new Button("Edit");
			ADMINCustEBT.setFont(new Font("Cambria", 9));
			ADMINCustEBT.setOnAction(e ->{
				try {CEstart(primaryStage);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			});
		Button ADMINBackBT = new Button("Return to Main Menu");
			ADMINBackBT.setOnAction(e ->{
				try {start(primaryStage);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			});

			//Combine all components and add components to the Start Window
			ADMINGrid.add(ADMINBusInL, 0,0);
			ADMINGrid.add(ADMINBusBT, 1,0);
			
			ADMINGrid.add(ADMINTechCL, 0,1);
			ADMINGrid.add(ADMINTechABT, 2,1);
			ADMINGrid.add(ADMINTechEBT, 1,1);
			
			ADMINGrid.add(ADMINCustCL, 0,2);
			ADMINGrid.add(ADMINCustABT, 2,2);
			ADMINGrid.add(ADMINCustEBT, 1,2);
			
			ADMINGrid.add(ADMINBackBT, 0,3);
			
			ADMINCurVerHB.getChildren().addAll(version,curVer);
			
			ADMINmainVB.getChildren().addAll(ADMINview,ADMINGrid, ADMINCurVerHB);
			ADMINstartWindow.setContent(ADMINmainVB);
		
		Scene ADMINscene = new Scene(ADMINstartWindow , 400, 450);
		
			primaryStage.setTitle("HCRGen/ADMIN");
			primaryStage.setX(0);
			primaryStage.setY(0);
			primaryStage.setMinWidth(400);
			primaryStage.setMaxWidth(400);
			primaryStage.setMinHeight(450);
			primaryStage.setMaxHeight(450);
			primaryStage.setScene(ADMINscene);
			primaryStage.show();
	}
	
	/** Method for setting the radio group to yes
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
			case "RFSSRrb32": GENlabel32TG = "Yes"; break;
		}
	}
	
	/** Method for setting the radio group to no
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
			case "RFSSRrb32N": GENlabel32TG = "No"; break;
		}
	}
	
	/** Method for setting the radio group to N/A
	 * @param input name for radio group
	 * @param btName name of button 
	 */
	public void setNA(String input, String btName){
		switch (btName){
			//HCR
			case "HCRdKWrb3": GENdkWSt = "N/A"; break;
			case "HCRfWPrb3": GENdkWSt = "N/A"; break;
			case "HCRdIFrb3": GENdIFSt = "N/A"; break;
			case "HCRaFHrb3": GENaFHSt = "N/A"; break;
			case "HCRfDWrb3": GENfDWSt = "N/A"; break;
			case "HCRhLWrb3": GENhLWSt = "N/A"; break;
			case "HCRhGPrb3": GENhGPSt = "N/A"; break;
			case "HCRrTCSrb3": GENrTCSSt = "N/A"; break;
			case "HCRfWLRrb3": GENfWLRSt = "N/A"; break;
			case "HCRrANFROrb3": GENrANFROSt = "N/A"; break;
			case "HCRhIWDrb3": GENhIWDSt = "N/A"; break;
			case "HCRkFCEWDrb3": GENkFCEWDSt = "N/A"; break;
			case "HCRoARCrb3": GENoARCSt = "N/A"; break;
			case "HCRhSFPWrb3": GENhSFPWSt = "N/A"; break;
			case "HCRhDGLrb3": GENhDGLSt = "N/A"; break;
			case "HCRaPGQrb3": GENaPGQSt = "N/A"; break;
			case "HCRsDWTrb3": GENsDWTSt = "N/A"; break;
			case "HCRpLRrb3": GENpLRSt = "N/A"; break;
			case "HCRhSRrb3": GENhSRSt = "N/A"; break;
			case "HCRphotoTrb3": GENphotoTSt = "N/A"; break;
			//RFSSR
			case "RFSSRrb1Na": GENlabel1TG = "N/A"; break;
			case "RFSSRrb2Na": GENlabel2TG = "N/A"; break;
			case "RFSSRrb3Na": GENlabel3TG = "N/A"; break;
			case "RFSSRrb4Na": GENlabel4TG = "N/A"; break;
			case "RFSSRrb5Na": GENlabel5TG = "N/A"; break;
			case "RFSSRrb6Na": GENlabel6TG = "N/A"; break;
			case "RFSSRrb7Na": GENlabel7TG = "N/A"; break;
			case "RFSSRrb8Na": GENlabel8TG = "N/A"; break;
			case "RFSSRrb9Na": GENlabel9TG = "N/A"; break;
			case "RFSSRrb10Na": GENlabel10TG = "N/A"; break;
			case "RFSSRrb11Na": GENlabel11TG = "N/A"; break;
			case "RFSSRrb12Na": GENlabel12TG = "N/A"; break;
			case "RFSSRrb13Na": GENlabel13TG = "N/A"; break;
			case "RFSSRrb14Na": GENlabel14TG = "N/A"; break;
			case "RFSSRrb15Na": GENlabel15TG = "N/A"; break;
			case "RFSSRrb16Na": GENlabel16TG = "N/A"; break;
			case "RFSSRrb17Na": GENlabel17TG = "N/A"; break;
			case "RFSSRrb18Na": GENlabel18TG = "N/A"; break;
			case "RFSSRrb19Na": GENlabel19TG = "N/A"; break;
			case "RFSSRrb20Na": GENlabel20TG = "N/A"; break;
			case "RFSSRrb21Na": GENlabel21TG = "N/A"; break;
			case "RFSSRrb22Na": GENlabel22TG = "N/A"; break;
			case "RFSSRrb23Na": GENlabel23TG = "N/A"; break;
			case "RFSSRrb24Na": GENlabel24TG = "N/A"; break;
			case "RFSSRrb25Na": GENlabel25TG = "N/A"; break;
			case "RFSSRrb26Na": GENlabel26TG = "N/A"; break;
			case "RFSSRrb27Na": GENlabel27TG = "N/A"; break;
			case "RFSSRrb28Na": GENlabel28TG = "N/A"; break;
			case "RFSSRrb29Na": GENlabel29TG = "N/A"; break;
			case "RFSSRrb30Na": GENlabel30TG = "N/A"; break;
			case "RFSSRrb31Na": GENlabel31TG = "N/A"; break;
			case "RFSSRrb32Na": GENlabel32TG = "N/A"; break;
		}
	}
	
	/** Method for setting the radio group to Light
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
	
	/** Method for setting the radio group to Medium
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
	
	/** Method for setting the radio group to Heavy
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
	
	/** Method for setting the radio group to Gas or Electric
	 * @param input name for radio group
	 * @param btName name of button 
	 */
	public void setGorE(String input, String btName){
		switch (btName) {
			case "RFSSREoGrb1": GENEoGST = "Gas"; break;
			case "RFSSREoGrb2": GENEoGST = "Elect"; break;
		}
	}

	/** Method for setting the radio group to Wet or Dry
	 * @param input name for radio group
	 * @param btName name of button 
	 */
	public void setWorD(String input, String btName){
		switch (btName) {
			case "RFSSRWDrb1": GENWoDST = "Wet"; break;
			case "RFSSRWDrb2": GENWoDST = "Dry"; break;
		}
	}
	
	/** Method for setting the radio group to New when changing the label
	 * @param input name for radio group
	 * @param btName name of button 
	 */
	public void setNew(String input, String btName){
		switch (btName){		
			case "HCRhSRrb1": GENhSRSt = "New"; break;
		}
	}
	
	public void setPWProT(boolean input, String btName){
		switch (btName){		
			case "BEPW1RB": passProtection = true; break;
		}
		busmap.put(10, "True");
		System.out.println("Password Protection ON!");
		try {
			saveBus();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setPWProF(boolean input, String btName){
		switch (btName){		
			case "BEPW2RB": passProtection = false; break;
		}
		busmap.put(10, "False");
		System.out.println("Password Protection OFF!");
		try {
			saveBus();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** Method for setting the radio group to Update when changing the label
	 * @param input name for radio group
	 * @param btName name of button 
	 */
	public void setUp(String input, String btName){
		switch (btName){		
			case "HCRhSRrb2": GENhSRSt = "Update"; break;
		}
	}
	
	/** Method for getting the client list from the saved file
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static void getCust() throws ClassNotFoundException, IOException{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(mapFile + "/" + "ClientList.bin"));
			clientmap = (HashMap<String, Object>)ois.readObject();
			ois.close();
			for (String s : clientmap.keySet()) {
				System.out.println("\t" + s);
			}
			
			System.out.println("Done getting Client List!");
	}
	
	/** Method for saving the Client info in file format
	 * @param al ArrayList<Object> for customer objects
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@SuppressWarnings("resource")
	public static void saveCust(Object obj) throws FileNotFoundException, IOException {
		clientmap.put(((CusOb) obj).getClient(), obj);
		System.out.println("Object written to clientmap!");
			
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(mapFile + "/" + "ClientList.bin"));
			
		oos.writeObject(clientmap);
		System.out.println("Client List Updated");
	}
	
	/** Method for creating a default customer Object and placing it in the map
	 */
	public static void makeCust() {
		String client = "Customer Name";
		String address = "Enter client Address";
		String city = "Enter client City";
		String state = "Ut";
		String zip= "Enter ZipCode";
		String phone= "Enter Phone Number";
		String SSw = "Service contact";
		String SCM = "Managers name";
		String SF = "Annually";
		String email = "Enter Email";
		LocalDate LastHydro = LocalDate.now();
		
		CusOb obj = new CusOb(client,address,city,state,zip,phone,SSw,SCM,SF,email, LastHydro);
		
		clientmap.put(obj.getClient(), obj);
		System.out.println("Default Client added to clientmap!");
	}
	
	/** Method for getting the technician list from the saved file
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static void getTech() throws ClassNotFoundException, IOException{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(mapFile + "/" + "TechList.bin"));
			techmap = (HashMap<String, Object>)ois.readObject();
			ois.close();
			for (String s : techmap.keySet()) {
				techlist.add(((TechOb) techmap.get(s)).getTechName().toString());
			}
			System.out.println("\t" + techlist);
			System.out.println("Done getting Technician List!");
			
	}
	
	/** Method for saving the Technician info in file format
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void saveTech(Object obj) throws FileNotFoundException, IOException {
		techmap.put(((TechOb) obj).getTechName(), obj);
		System.out.println("Object written to techmap!");
			
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(mapFile + "/" + "TechList.bin"));
			
		oos.writeObject(techmap);
		System.out.println("Technician List Updated");
		oos.close();
	}
	
	/** Method for creating a default technician Object and placing it in the map
	 */
	public static void makeTech() {
		String techName = "";
		String address = "Enter Address";
		String city = "Enter City";
		String state = "Ut";
		String zip= "Enter ZipCode";
		String phone= "Enter Phone Number";
		String license = "Enter License Number";
		String email = "Enter Email";
		String enterDate = LocalDate.now().toString();
		
		TechOb obj = new TechOb(techName,address,city,state,zip,phone,license,email,enterDate);
		
		techmap.put(obj.getTechName(), obj);
		System.out.println("Default Technician added to map!");
	}
	
	/** Method for creating a default technician Object and placing it in the map
	 */
	public static void makeBus() {
		busmap.put(1, "Enter Business Name");
		busmap.put(2, "Enter Address");
		busmap.put(3, "Enter City");
		busmap.put(4, "Enter State");
		busmap.put(5, "Enter Zipcode");
		busmap.put(6, "Enter Phone");
		busmap.put(7, "Enter Email");
		busmap.put(8, "Enter License");
		busmap.put(9, "Enter Password");
		busmap.put(10, "False");
		
		System.out.println("Default Business info created!");
	}
	
	/** Method for getting the technician list from the saved file
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static void getBus() throws ClassNotFoundException, IOException{
		
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(mapFile + "/" + "BusIn.bin"));
			busmap = (HashMap<Integer, String>)ois.readObject();
			ois.close();
						
			GENBusinessName = busmap.get(1);
			GENBusinessAdd = busmap.get(2);
			GENBusinessCity = busmap.get(3);
			GENBusinessState = busmap.get(4);
			GENBusinessZipcode = busmap.get(5);
			GENBusinessPhone = busmap.get(6);
			GENBusinessEmail = busmap.get(7);
			GENBusinessLicense = busmap.get(8);
			GENBusinessPassword = busmap.get(9);			
			
			GENendTech1 = GENBusinessName + "\n" 
			+ GENBusinessAdd + "\n" 
			+ GENBusinessCity + GENBusinessState + GENBusinessZipcode + "\n" 	
			+ GENBusinessPhone + "\nWARNING!\nTechnician not selected!" ;
			
			System.out.println("\t" + busmap.get(1));
						
			if(busmap.get(10).equals("True")) {
				passProtection = true;
				System.out.println("\tPassword Protection is On!");
			}	
			else if (!busmap.get(10).equals("True")) {
				passProtection = false;
				System.out.println("\tPassword Protection is Off!");
			}
			System.out.println("finished getting business information!");
	}
	
	/** Method for saving the Technician info in file format
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void saveBus() throws FileNotFoundException, IOException {
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(mapFile + "/" + "BusIn.bin"));
			
		oos.writeObject(busmap);
		System.out.println("Business Information Updated");
		oos.close();
	}
	
	/** Customer search function
	 * @param client, customer name for search function
	 */
	public static void custSrch(String client) {
		
		StackPane CSWindow = new StackPane();
		Stage CSStage = new Stage();
		Scene CSscene = new Scene(CSWindow , 400, 450);
		
		TextArea CSTA = new TextArea();
			CSTA.setCache(false);
			CSTA.appendText(
            			"Client Name: \t\t\t" + ((CusOb) clientmap.get(client)).getClient().toString()
            		+	"\nAddress: \t\t\t\t" + ((CusOb) clientmap.get(client)).getAddress().toString()
            		+ 	"\nCity: \t\t\t\t\t" + ((CusOb) clientmap.get(client)).getCity().toString()
            		+ 	"\nState: \t\t\t\t" + ((CusOb) clientmap.get(client)).getState().toString()
            		+ 	"\nZipcode: \t\t\t\t" + ((CusOb) clientmap.get(client)).getZip().toString()
            		+ 	"\nPhonenumber: \t\t" + ((CusOb) clientmap.get(client)).getPhone().toString()
            		+	"\nService Scheduled with: \t" + ((CusOb) clientmap.get(client)).getSSw().toString()
            		+ 	"\nStore Closing Manager: \t" + ((CusOb) clientmap.get(client)).getSCM().toString()
            		+	"\nService Frequency: \t\t" + ((CusOb) clientmap.get(client)).getSF().toString()
            		+	"\nEmail: \t\t\t\t" + ((CusOb) clientmap.get(client)).getEmail().toString()
            		+ 	"\nLast Hydro Test: \t\t" + ((CusOb) clientmap.get(client)).getLastHydro().toString()
            );
			
			CSWindow.getChildren().addAll(CSTA);
			CSStage.setTitle("Customer Search");
			CSStage.setX(0);
			CSStage.setY(450);
			CSStage.setMinWidth(400);
			CSStage.setMaxWidth(400);
			CSStage.setMinHeight(450);
			CSStage.setMaxHeight(450);
			CSStage.setScene(CSscene);
			CSStage.show();	
	}
	
	/** Customer search function
	 * @param client, customer name for search function
	 */
	public static void techSrch(String TSname) {
		
		StackPane TSWindow = new StackPane();
		Stage TSStage = new Stage();
		Scene TSscene = new Scene(TSWindow , 400, 450);
		
		TextArea TSTA = new TextArea();
			TSTA.setCache(false);
			TSTA.appendText(
            			"technician Name: \n\t" + ((TechOb) techmap.get(TSname)).getTechName().toString()
            		+	"\nAddress: \n\t" + ((TechOb) techmap.get(TSname)).getTechAdd().toString()
            		+ 	"\nCity: \n\t" + ((TechOb) techmap.get(TSname)).getTechCity().toString()
            		+ 	"\nState: \n\t" + ((TechOb) techmap.get(TSname)).getTechState().toString()
            		+ 	"\nZipcode: \n\t" + ((TechOb) techmap.get(TSname)).getTechZip().toString()
            		+ 	"\nPhone number: \n\t" + ((TechOb) techmap.get(TSname)).getTechPhone().toString()
            		+	"\nTech License: \n\t" + ((TechOb) techmap.get(TSname)).getTechLic().toString()
            		+	"\nTech Email: \n\t" + ((TechOb) techmap.get(TSname)).getTechEmail().toString()
            		+ 	"\nHire Date: \n\t" + ((TechOb) techmap.get(TSname)).getTechDate().toString()
            );
			
			TSWindow.getChildren().addAll(TSTA);
			TSStage.setTitle("Customer Search");
			TSStage.setX(0);
			TSStage.setY(450);
			TSStage.setMinWidth(400);
			TSStage.setMaxWidth(400);
			TSStage.setMinHeight(450);
			TSStage.setMaxHeight(450);
			TSStage.setScene(TSscene);
			TSStage.show();	
	}
	
	/** List Customer function
	 */
	public static void techList() {
		
		StackPane TLWindow = new StackPane();
		Stage TLStage = new Stage();
		Scene TLscene = new Scene(TLWindow , 1000, 450);
		
		TextArea TLTA = new TextArea();
			TLTA.setCache(false);
			TLTA.appendText(GENBusinessName + "\nTechnician List: " + "\n\n");
			
		for (String s : techmap.keySet()) {
			TLTA.appendText(
        			"Technician Name: \t" + ((TechOb) techmap.get(s)).getTechName().toString()
        		+	"\nAddress: \t\t\t" + ((TechOb) techmap.get(s)).getTechAdd().toString()
        		+ 	"\nCity: \t\t\t\t" + ((TechOb) techmap.get(s)).getTechCity().toString()
        		+ 	"\nState: \t\t\t" + ((TechOb) techmap.get(s)).getTechState().toString()
        		+ 	"\nZipcode: \t\t\t" + ((TechOb) techmap.get(s)).getTechZip().toString()
        		+ 	"\nPhone number: \t" + ((TechOb) techmap.get(s)).getTechPhone().toString()
        		+	"\nTech License: \t\t" + ((TechOb) techmap.get(s)).getTechLic().toString()
        		+	"\nTech Email: \t\t" + ((TechOb) techmap.get(s)).getTechEmail().toString()
        		+ 	"\nHire Date: \t\t" + ((TechOb) techmap.get(s)).getTechDate().toString()
            	+	"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
		}
			
			TLWindow.getChildren().addAll(TLTA);
			TLStage.setTitle("Technician List");
			TLStage.setX(725);
			TLStage.setY(0);
			TLStage.setMinWidth(450);
			TLStage.setMaxWidth(450);
			TLStage.setMinHeight(1000);
			TLStage.setMaxHeight(1000);
			TLStage.setScene(TLscene);
			TLStage.show();
	}
	
	/** List Customer function
	 */
	public static void custList() {
		
		StackPane CLWindow = new StackPane();
		Stage CLStage = new Stage();
		Scene CLscene = new Scene(CLWindow , 1000, 450);
		
		TextArea CLTA = new TextArea();
			CLTA.setCache(false);
			CLTA.appendText(GENBusinessName + "\nClient List: " + "\n\n");
		
		for (String s : clientmap.keySet()) {
			CLTA.appendText(
        			"Client Name: \t\t\t\t" + ((CusOb) clientmap.get(s)).getClient().toString()
        		+	"\nAddress: \t\t\t\t\t" + ((CusOb) clientmap.get(s)).getAddress().toString()
        		+ 	"\nCity: \t\t\t\t\t\t" + ((CusOb) clientmap.get(s)).getCity().toString()
        		+ 	"\nState: \t\t\t\t\t" + ((CusOb) clientmap.get(s)).getState().toString()
        		+ 	"\nZipcode: \t\t\t\t\t" + ((CusOb) clientmap.get(s)).getZip().toString()
        		+ 	"\nPhonenumber: \t\t\t" + ((CusOb) clientmap.get(s)).getPhone().toString()
        		+	"\nService Scheduled with: \t\t" + ((CusOb) clientmap.get(s)).getSSw().toString()
        		+ 	"\nStore Closing Manager: \t\t" + ((CusOb) clientmap.get(s)).getSCM().toString()
        		+	"\nService Frequency: \t\t\t" + ((CusOb) clientmap.get(s)).getSF().toString()
        		+	"\nEmail: \t\t\t\t\t" + ((CusOb) clientmap.get(s)).getEmail().toString()
        		+ 	"\nLast Hydro Test: \t\t\t" + ((CusOb) clientmap.get(s)).getLastHydro().toString()
            	+	"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
		}
			
			CLWindow.getChildren().addAll(CLTA);
			CLStage.setTitle("Customer List");
			CLStage.setX(725);
			CLStage.setY(0);
			CLStage.setMinWidth(450);
			CLStage.setMaxWidth(450);
			CLStage.setMinHeight(1000);
			CLStage.setMaxHeight(1000);
			CLStage.setScene(CLscene);
			CLStage.show();
	}
	
    public void showPrinters(Stage stage)
    {
        // Create the TextArea
        final TextArea textArea = new TextArea();
        // Create the Button
        Button button = new Button("Get all Printers");
 
        // Create the Event-Handlers for the Buttons
        button.setOnAction(new EventHandler <ActionEvent>() 
        {
            public void handle(ActionEvent event) 
            {
                //Get all Printers
                ObservableSet<Printer> printers = Printer.getAllPrinters();
                 
                for(Printer printer : printers) 
                {
                    textArea.appendText(printer.getName()+"\n");
                }       
            }
        });
         
        // Create the VBox with a 10px spacing
        VBox root = new VBox(10);   
        // Add the Children to the VBox
        root.getChildren().addAll(button,textArea); 
        // Set the Size of the VBox
        root.setPrefSize(400, 250);     
        // Set the Style-properties of the VBox
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
         
        // Create the Scene
        Scene scene = new Scene(root);
        // Add the scene to the Stage
        stage.setScene(scene);
        // Set the title of the Stage
        stage.setTitle("Showing all Printers");
        // Display the Stage
        stage.show();       
    }

    public void defaultPrinter(Stage stage)
    {
        // Create the TextArea
        final TextArea textArea = new TextArea();
        // Create the Button
        Button button = new Button("Get the Default Printer");
 
        // Create the Event-Handlers for the Buttons
        button.setOnAction(new EventHandler <ActionEvent>() 
        {
            public void handle(ActionEvent event) 
            {
                //Get the Default Printer
                Printer defaultprinter = Printer.getDefaultPrinter();
 
                if (defaultprinter != null) 
                {
                    String name = defaultprinter.getName();
                    textArea.appendText("Default printer name: " + name);
                } 
                else
                {
                    textArea.appendText("No printers installed.");
                }       
            }
        });
         
        // Create the VBox with a 10px spacing
        VBox root = new VBox(10);   
        // Add the Children to the VBox
        root.getChildren().addAll(button,textArea); 
        // Set the Size of the VBox
        root.setPrefSize(400, 250);     
        // Set the Style-properties of the VBox
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
         
        // Create the Scene
        Scene scene = new Scene(root);
        // Add the scene to the Stage
        stage.setScene(scene);
        // Set the title of the Stage
        stage.setTitle("Show the default Printer");
        // Display the Stage
        stage.show();       
    }
    
    public void startPrint(Stage stage){
    
        final VBox root = new VBox(5);
 
        Label textLabel = new Label("Please insert your Text:");
         
        final TextArea textArea = new TextArea();
         
        Button printTextButton = new Button("Print Text");
        Button printSceneButton = new Button("Print Scene");
        
        	printTextButton.setOnAction(new EventHandler <ActionEvent>() 
        	{
	            public void handle(ActionEvent event) 
	            {
	                print(textArea);
	            }
        	});
 
	        printSceneButton.setOnAction(new EventHandler <ActionEvent>() 
	        {
	            public void handle(ActionEvent event) 
	            {
	                print(root);
	            }
	        });
         
        HBox jobStatusBox = new HBox(5, new Label("Job Status: "), jobStatus);
        
        HBox buttonBox = new HBox(5, printTextButton, printSceneButton);
 	            
	        root.getChildren().addAll(textLabel, textArea, buttonBox, jobStatusBox);
	        root.setPrefSize(400, 300);
	        root.setStyle("-fx-padding: 10;" +
	                "-fx-border-style: solid inside;" +
	                "-fx-border-width: 2;" +
	                "-fx-border-insets: 5;" +
	                "-fx-border-radius: 5;" +
	                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.setTitle("A Printing Nodes Example");
	        stage.show();       
    }
     
    private void print(Node node){
        // Define the Job Status Message
        jobStatus.textProperty().unbind();
        jobStatus.setText("Creating a printer job...");
         
        // Create a printer job for the default printer
        PrinterJob job = PrinterJob.createPrinterJob();
         
        if (job != null) 
        {
            // Show the printer job status
            jobStatus.textProperty().bind(job.jobStatusProperty().asString());
             
            // Print the node
            boolean printed = job.printPage(node);
 
            if (printed) 
            {
                // End the printer job
                job.endJob();
            } 
            else
            {
                // Write Error Message
                jobStatus.textProperty().unbind();
                jobStatus.setText("Printing failed.");
            }
        } 
        else
        {
            // Write Error Message
            jobStatus.setText("Could not create a printer job.");
        }
    }   
    
    public void startSetupStage(final Stage stage){

        Label textLabel = new Label("Please insert your Text:");
        
        final TextArea textArea = new TextArea();
      
        Button printSetupButton = new Button("Print Setup and Print");
         	printSetupButton.setOnAction(e ->{
                printSetup(textArea, stage);
        });
         
        HBox jobStatusBox = new HBox(5, new Label("Job Status: "), jobStatus);
 
        HBox buttonBox = new HBox(printSetupButton);
         
        VBox root = new VBox(5);    
	        root.getChildren().addAll(textLabel, textArea, buttonBox, jobStatusBox);
	        root.setPrefSize(400, 300);
	        root.setStyle("-fx-padding: 10;" +
	                "-fx-border-style: solid inside;" +
	                "-fx-border-width: 2;" +
	                "-fx-border-insets: 5;" +
	                "-fx-border-radius: 5;" +
	                "-fx-border-color: blue;");
	         
        Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.setTitle("A Printing Dialog Example");
	        stage.show();       
    }
     
    @SuppressWarnings("unused")
	public void printSetup(Node node, Stage owner) 
    {
        // Create the PrinterJob        
        PrinterJob job = PrinterJob.createPrinterJob();
     
        // Get The Printer Job Settings
        JobSettings jobSettings = job.getJobSettings();
         
        // Get the Page Layout
        PageLayout pageLayout = jobSettings.getPageLayout();
        
        // Get the Page Attributes
        double pgW = pageLayout.getPrintableWidth();
        double pgH = pageLayout.getPrintableHeight();

         
        // Get The Printer
        Printer printer = job.getPrinter();
        
        // Create the Page Layout of the Printer
        pageLayout = printer.createPageLayout(Paper.NA_LETTER,
                PageOrientation.PORTRAIT,Printer.MarginType.DEFAULT);
        
        jobSettings.setPageLayout(pageLayout);
        
        if (job == null) 
        {
            return;
        }
 
        // Show the print setup dialog
        boolean proceed = job.showPrintDialog(owner);
         
        if (proceed) 
        {
            print(job, node);
        }
    }
     
    public static void printNode(final Node node){
        Printer printer = Printer.getDefaultPrinter();
        PageLayout pageLayout = printer.createPageLayout(Paper.NA_LETTER, PageOrientation.PORTRAIT, Printer.MarginType.DEFAULT);
        double scaleX = pageLayout.getPrintableWidth() / node.getBoundsInParent().getWidth();
        double scaleY = pageLayout.getPrintableHeight() / node.getBoundsInParent().getHeight();
        node.getTransforms().add(new Scale(scaleX, scaleY));
 
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null) {
            boolean success = job.printPage(node);
            if (success) {
                job.endJob();
            }
        }
    }
    private void print(PrinterJob job, Node node){
        jobStatus.textProperty().bind(job.jobStatusProperty().asString());
         
        boolean printed = job.printPage(node);
     
        if (printed){
            job.endJob();
        }
    } 
    
	/** Method for Capturing the screen as a file to save the report
	 * @param fileName name for the file to be generated
	 * @throws Exception listed for IO file not found exception
	 */
	public void captureScreen(String fileName) throws Exception {
		Rectangle screenRectangle = new Rectangle(7, 45, 761, 1005);
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screenRectangle);
		ImageIO.write(image, "png", new File(fileName));
	}
    
	/**main method
	 * @param args launch method
	 */
	public static void main(String[] args){
		Application.launch(args);
		}
}