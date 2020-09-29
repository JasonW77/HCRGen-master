/**
 *  * <h1>JavaDoc</h1>
 * 
 *  HCRGen application for generating Hood Cleaning Reports (or HCRGen.java).
 * 	I created this program for Tong's Fire Extinguisher Sales and Service to help them move from paper reports to an all digital report system.
 * 
 * Version 2.0 adds the RFSSR class and the CustCrea class, this allows for a second report to be generated and the customer information to be saved.
 * 	 
 * 
	<p>Date created 8/17/2020 <p/>
	<p>Version 2.0 <p/>
	
	@author Jason Waters
 */
package HCRGen;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CusOb  extends HCRGen implements Serializable{
	
	private String client;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String SSw;
	private String SCM;
	private String SF;
	
	/**
	 * default object creation settings
	 */
	public CusOb() {
		this.client = "";
		this.address = "";
		this.city = "";
		this.state = "Ut";
		this.zip = "";
		this.phone = "";
		this.SSw = "";
		this.SCM = "";
		this.SF = "";
	}
	
	/**
	 * object creation with specified parameters
	 */
	
	public CusOb(String client,String address, String city, String state, String zip, String phone, String SSw, String SCM, String SF) {
		this.client = client;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.SSw = SSw;
		this.SCM = SCM;
		this.SF = SF;
	}
	/**
	 * CusOb getters
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
	
	/**
	 * CusOb setters
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

}
