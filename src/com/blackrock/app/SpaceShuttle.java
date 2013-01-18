/**
 * 
 */
package com.blackrock.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author kiran
 * 
 */
public class SpaceShuttle {

	int x;
	int y;
	private String direction = null;
	int maxX, maxY;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new SpaceShuttle().readInput("");
	}

	/**
	 * 
	 * @param input
	 */
	public void readInput(String input)  {

		Coordinates corr = null;
		Coordinates max = null;
		DirectionControlImpl control = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			String lineRead = br.readLine();
			String[] inArray = lineRead.split("\\s");
			maxX = Integer.parseInt(inArray[0]);
			maxY = Integer.parseInt(inArray[1]);
			System.out.println("maxX and maxY are " + maxX + " and maxY "
					+ maxY);
			max = new Coordinates(maxX, maxY);
			while (true) {
				
				control = new DirectionControlImpl();
				lineRead = br.readLine();
				
		
				if (lineRead != null && !lineRead.isEmpty()) {

					if(lineRead.equalsIgnoreCase(RoverConstants.STOP)) {
						throw new InvalidDataException("Abnormal Status Code, Exiting the Program");
					}
				
					inArray = lineRead.split("\\s");
					x = Integer.parseInt(inArray[0]);
					y = Integer.parseInt(inArray[1]);
					direction = inArray[2];
					corr = new Coordinates(x, y, direction, "");
					System.out.println("Setting all the values : x " + x
							+ " y: " + y + " direction: " + direction
							+ " direction: ");

					lineRead = br.readLine();
					int index = 0;

					while (lineRead != null && !lineRead.isEmpty()
							&& (index < lineRead.length())) {
						System.out.println("Got input as :" + lineRead);
						System.out.println("index is :" + index);
						char c = lineRead.charAt(index);
						index++;
						String step = String.valueOf(c);
						if (step.equalsIgnoreCase(RoverConstants.MOVE)) {
							corr.setDirection(direction);
							System.out.println("input string  for move is "
									+ step);
							corr = control.move(corr, max);
							System.out.println("Coordinate Values after "
									+ index + " move " + corr.toString());
						} else if (step.equalsIgnoreCase(RoverConstants.LEFT)
								|| step.equalsIgnoreCase(RoverConstants.RIGHT)) {
							System.out
									.println("input string  for direction is "
											+ step);
							corr.setTurn(step);
							direction = control.changeDirection(corr);
							System.out.println("Coordinate Values after "
									+ index + " move" + corr.toString());
						} else {
							throw new InvalidDataException(
									"InvalidDataException");
						}
					}
					System.out
							.println("The final Coordinates and Direction are x: "
									+ corr.getX()
									+ " y: "
									+ corr.getY()
									+ " direction : " + direction);
				
				
				} else {
					throw new InvalidDataException("InvalidDataException");
				}
			
				
			}
		} catch (IOException ioe) {
			System.err.println("The Exception is " + ioe.getMessage());
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				System.err.println("The Exception is " + e.getMessage());
			}
		}
	}
}
