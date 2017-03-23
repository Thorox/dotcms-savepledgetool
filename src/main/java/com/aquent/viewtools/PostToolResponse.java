package edu.pittstate.viewtools;

/**
 * A Response from the PostTool viewtool
 * Contains the response code and response string
 * 
 * @author Jay Hodges
 *
 */
public class PostToolResponse {

	/**
	 * The Response
	 */
	public String response;
	
	/**
	 * The Response Code
	 */
	public int responseCode;
	
	public PostToolResponse() { }
	public PostToolResponse(int rc, String r) { 
		this.response = r;
		this.responseCode = rc;
	}
	
	public String getResponse() { return this.response; }
	public int getResponseCode() { return this.responseCode; }
	
	public void setResponse(String r) { this.response = r; }
	public void setResponseCode(int rc) { this.responseCode = rc; }
	
}
