/**
 * 
 */
package com.blackrock.app;

/**
 * @author kiran
 *
 */
public class DirectionControlImpl implements DirectionControl {

	/**
	 * 
	 */
	public  String turnLeft(Coordinates curr) {
		System.out.println("Got Direction as :"+ curr.getDirection());
		if(curr.getDirection().equalsIgnoreCase(RoverConstants.NORTH)) {
			curr.setDirection(RoverConstants.WEST);
		} else if(curr.getDirection().equalsIgnoreCase(RoverConstants.EAST)) {
			curr.setDirection(RoverConstants.NORTH);
		} else if(curr.getDirection().equalsIgnoreCase(RoverConstants.SOUTH)) {
			curr.setDirection(RoverConstants.EAST);
		} else if(curr.getDirection().equalsIgnoreCase(RoverConstants.WEST)) {
			curr.setDirection(RoverConstants.SOUTH);
		}
			return curr.getDirection();
	}
	
	/**
	 * 
	 * @param direction
	 */
	public  String changeDirection(Coordinates curr) {
		if(curr.getTurn().equalsIgnoreCase(RoverConstants.LEFT)) {
			curr.setDirection(turnLeft(curr));
		} else if(curr.getTurn().equalsIgnoreCase(RoverConstants.RIGHT)){
			curr.setDirection(turnRight(curr));
		} else {
			throw new InvalidDataException("InvalidDataException");
		}
		return curr.getDirection();
	}
	
	/**
	 * 
	 */
	public  String turnRight(Coordinates curr) {
		System.out.println("Got Direction as :"+ curr.getDirection());
		if(curr.getDirection().equalsIgnoreCase(RoverConstants.NORTH)) {
			curr.setDirection(RoverConstants.EAST);
		} else if(curr.getDirection().equalsIgnoreCase(RoverConstants.EAST)) {
			curr.setDirection(RoverConstants.SOUTH);
		} else if(curr.getDirection().equalsIgnoreCase(RoverConstants.SOUTH)) {
			curr.setDirection(RoverConstants.WEST);
		} else if(curr.getDirection().equalsIgnoreCase(RoverConstants.WEST)) {
			curr.setDirection(RoverConstants.NORTH);
		}
		return curr.getDirection();
	}
	
	
	/**
	 * 
	 */
	public  Coordinates move(Coordinates curr,Coordinates max) {
		if(canMove(curr,max)) {
		if(curr.getDirection().equalsIgnoreCase(RoverConstants.NORTH)) {
			System.out.println("Moved Y from "+ curr.getY()+"to "+curr.getY()+1);
			curr.setY(curr.getY()+1);
		} else if(curr.getDirection().equalsIgnoreCase(RoverConstants.EAST)) {
			curr.setX(curr.getX()+1);
			System.out.println("Moved Y from "+ curr.getX()+"to "+curr.getX()+1);
		} else if(curr.getDirection().equalsIgnoreCase(RoverConstants.SOUTH)) {
			curr.setY(curr.getY()-1);
			System.out.println("Moved Y from "+ curr.getY()+"to "+ (curr.getY()- 1));
		} else if(curr.getDirection().equalsIgnoreCase(RoverConstants.WEST)) {
			System.out.println("Moved Y from "+ curr.getX()+"to "+ (curr.getX()- 1));
			curr.setX(curr.getX()-1);
		} 
		}  else {
			throw new InvalidMoveException("Invalid Move Exception");
		}
		return curr;
	}
	

	/**
	 * 
	 * @return
	 */
	public  boolean canMove(Coordinates curr,Coordinates max) {
		boolean movable;
		if(curr.getDirection().equalsIgnoreCase(RoverConstants.NORTH) && curr.getY() == max.getY()) {
			throw new InvalidMoveException("Invalid Move Exception curr.getY() "+ curr.getY());
		} else if(curr.getDirection().equalsIgnoreCase(RoverConstants.EAST) && (curr.getX() == max.getX())) {
			throw new InvalidMoveException("Invalid Move Exception x "+ curr.getX());
		} else if(curr.getDirection().equalsIgnoreCase(RoverConstants.SOUTH) && (curr.getY() == RoverConstants.minY)) {
			throw new InvalidMoveException("Invalid Move Exception y "+ curr.getY());
		} else if(curr.getDirection().equalsIgnoreCase(RoverConstants.WEST) && (curr.getX() == RoverConstants.minX)) {
			throw new InvalidMoveException("Invalid Move Exception x "+ curr.getX());
		} else {
			movable = true;
		}
		return movable;
	}
}
