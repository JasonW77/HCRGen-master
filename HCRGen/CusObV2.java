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

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class CusObV2  extends HCRGen implements Serializable{
	
	private String client;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String SSw;
	private String SCM;
	private String SF;
	private String email;
	private LocalDate LastHydro;
	
	/** default object creation settings
	 */
	public CusObV2() {
		this.client = "";
		this.address = "";
		this.city = "";
		this.state = "Ut";
		this.zip = "";
		this.phone = "";
		this.SSw = "";
		this.SCM = "";
		this.SF = "";
		this.email = "";
		this.LastHydro = LocalDate.now();
	}
	
	/** object creation with specified parameters
	 */
	public CusObV2(String client,String address, String city, String state, String zip, String phone, String SSw, String SCM, String SF, String email, LocalDate LastHydro) {
		this.client = client;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.SSw = SSw;
		this.SCM = SCM;
		this.SF = SF;
		this.email = email;
		this.LastHydro = LastHydro;
	}
	
	/** CusOb getters
	 */
	public String getClient() {
		return this.client;
	}
	public String getAddress() {
		return this.address;
	}
	public String getCity() {
		return this.city;
	}
	public String getState() {
		return this.state;
	}
	public String getZip() {
		return this.zip;
	}
	public String getPhone() {
		return this.phone;
	}
	public String getSSw() {
		return this.SSw;
	}
	public String getSCM() {
		return this.SCM;
	}
	public String getSF() {
		return this.SF;
	}
	public String getEmail() {
		return this.email;
	}
	public LocalDate getLastHydro() {
		return this.LastHydro;
	}
	
	/** CusOb setters
	 */
	public String setClient(String client) {
		return this.client = client;
	}
	public String setAddress(String address) {
		return this.address = address;
	}
	public String setCity(String city) {
		return this.city = city;
	}
	public String setState(String state) {
		return this.state = state;
	}
	public String setZip(String zip) {
		return this.zip= zip;
	}
	public String setPhone(String phone) {
		return this.phone = phone;
	}
	public String setSSw(String SSw) {
		return this.SSw = SSw;
	}
	public String setSCM(String SCM) {
		return this.SCM = SCM;
	}
	public String setSF(String SF) {
		return this.SF = SF;
	}
	public String setEmail(String email) {
		return this.email = email;
	}
	public LocalDate setLastHydro(LocalDate LastHydro) {
		return this.LastHydro = LastHydro;
	}
}