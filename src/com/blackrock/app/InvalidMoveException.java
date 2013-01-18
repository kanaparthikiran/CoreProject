/**
 * 
 */
package com.blackrock.app;

/**
 * @author kiran
 *
 */
public class InvalidMoveException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidMoveException() {
			super();
	 }
	 
	public InvalidMoveException(String message) {
	    	super(message);
	}
	
	public InvalidMoveException(String message, Throwable cause) {
		super(message, cause);
	 }
}
