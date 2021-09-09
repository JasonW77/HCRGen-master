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
public class TechOb  extends HCRGen implements Serializable{
	private String techName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String license;
	private String email;
	private String enterDate;
	
	/** default object creation settings
	 */
	public TechOb() {
		this.techName = "";
		this.address = "";
		this.city = "";
		this.state = "Ut";
		this.zip = "";
		this.phone = "";
		this.license = "";
		this.email = "";
		this.enterDate = LocalDate.now().toString();
	}
	
	/** object creation with specified parameters
	 */
	public TechOb(String techName,String address, String city, String state, String zip, String phone,String license, String email, String enterDate) {
		this.techName = techName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.license = license;
		this.email = email;
		this.enterDate = enterDate;
	}
	
	/** TechOb getters
	 */
	public String getTechName() {
		return this.techName;
	}
	public String getTechAdd() {
		return this.address;
	}
	public String getTechCity() {
		return this.city;
	}
	public String getTechState() {
		return this.state;
	}
	public String getTechZip() {
		return this.zip;
	}
	public String getTechPhone() {
		return this.phone;
	}
	public String getTechLic() {
		return this.license;
	}
	public String getTechEmail() {
		return this.email;
	}
	public String getTechDate() {
		return this.enterDate;
	}
	
	/** TechOb setters
	 */
	public String setTechName(String techName) {
		return this.techName = techName;
	}
	public String setTechAdd(String address) {
		return this.address = address;
	}
	public String setTechCity(String city) {
		return this.city = city;
	}
	public String setTechState(String state) {
		return this.state = state;
	}
	public String setTechZip(String zip) {
		return this.zip= zip;
	}
	public String setTechPhone(String phone) {
		return this.phone = phone;
	}
	public String setTechLic(String license) {
		return this.license = license;
	}
	public String setTechEmail(String email) {
		return this.email = email;
	}
	public String setTechDate(String enterDate) {
		return this.enterDate = enterDate;
	}
}
