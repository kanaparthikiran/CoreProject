/**
 * 
 */
package com.blackrock.app;

/**
 * @author kiran
 *
 */
public interface DirectionControl {

	public  String turnLeft(Coordinates curr);
	public  String changeDirection(Coordinates curr);
	public  String turnRight(Coordinates curr);
	public  Coordinates move(Coordinates curr,Coordinates max);
	public  boolean canMove(Coordinates curr,Coordinates max);
	
}
