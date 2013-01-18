package com.blackrock.app;

/**
 * 
 * @author kiran
 *
 */
public class Coordinates {
	
	public Coordinates(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
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

	public Coordinates(int x, int y, String direction, String turn) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.turn = turn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + ((turn == null) ? 0 : turn.hashCode());
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinates other = (Coordinates) obj;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		if (turn == null) {
			if (other.turn != null)
				return false;
		} else if (!turn.equals(other.turn))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coordinates [x=" + x + ", y=" + y + ", direction=" + direction
				+ ", turn=" + turn + "]";
	}

	private int x;
	private int y;
	private String direction; 
	private String turn;
	
	
	

}
