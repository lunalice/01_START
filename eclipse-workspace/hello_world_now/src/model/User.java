/**
 * 
 */
package model;

import java.io.Serializable;

/**
 * @author tealice
 *
 */
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String pass;

	public User() {};

	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}

	public String getName() {return this.name;}
	public String getPass() {return this.pass;}
}
