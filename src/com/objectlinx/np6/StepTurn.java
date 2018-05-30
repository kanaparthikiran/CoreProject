/**
 * 
 */
package com.objectlinx.np6;

/**
 * @author kikanapa
 *
 */
public class StepTurn {

	public StepTurn(String direction, String turn) {
		super();
		this.direction = direction;
		this.turn = turn;
	}
	private String direction;
	private String turn;
	
	
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getTurn() {
		return turn;
	}
	public void setTurn(String turn) {
		this.turn = turn;
	}
}
