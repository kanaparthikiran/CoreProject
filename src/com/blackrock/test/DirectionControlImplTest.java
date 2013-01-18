/**
 * 
 */
package com.blackrock.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.blackrock.app.Coordinates;
import com.blackrock.app.DirectionControlImpl;
import com.blackrock.app.InvalidMoveException;
import com.blackrock.app.RoverConstants;

/**
 * @author kiran
 *
 */
public class DirectionControlImplTest {
	
	Coordinates current = null;
	Coordinates max = null;
	DirectionControlImpl ctrlImpl = null;
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
			current = new Coordinates(1,4,"N","L");
			max = new Coordinates(5,5,"","");
			ctrlImpl = new DirectionControlImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
			 current = null;
			 max = null;
			 ctrlImpl = null;
	}

	/**
	 * Test method for {@link com.blackrock.app.DirectionControlImpl#turnLeft(com.blackrock.app.Coordinates)}.
	 */
	@Test
	public final void testTurnLeft() {
		assertEquals(RoverConstants.WEST,ctrlImpl.turnLeft(current));
		assertNotSame(RoverConstants.EAST,ctrlImpl.turnRight(current));
		assertNotSame(null,ctrlImpl.turnRight(current));
	
	}

	/**
	 * Test method for {@link com.blackrock.app.DirectionControlImpl#changeDirection(com.blackrock.app.Coordinates)}.
	 */
	@Test
	public final void testChangeDirection() {
		assertEquals(RoverConstants.WEST,ctrlImpl.changeDirection(current));
		assertNotSame(null,ctrlImpl.changeDirection(current));
	}

	/**
	 * Test method for {@link com.blackrock.app.DirectionControlImpl#turnRight(com.blackrock.app.Coordinates)}.
	 */
	@Test
	public final void testTurnRight() {
		assertEquals(RoverConstants.EAST,ctrlImpl.turnRight(current));
		assertNotSame(RoverConstants.WEST,ctrlImpl.turnRight(current));
		assertNotSame(null,ctrlImpl.turnRight(current));
	}

	/**
	 * Test method for {@link com.blackrock.app.DirectionControlImpl#move(com.blackrock.app.Coordinates, com.blackrock.app.Coordinates)}.
	 */
	@Test
	public final void testMove() {
		int beforeY = current.getY();
		ctrlImpl.move(current, max);
		assertEquals((beforeY+1),current.getY());
		
	}


	/**
	 * Test method for {@link com.blackrock.app.DirectionControlImpl#canMove(com.blackrock.app.Coordinates, com.blackrock.app.Coordinates)}.
	 */
	@Test
	public final void testCanMove() {
		assertEquals(false,(current.getDirection().equals(RoverConstants.NORTH) && current.getY() == max.getY())) ;
		assertNotSame(true,(current.getDirection().equals(RoverConstants.EAST) && current.getX() == max.getX()));
		assertNotSame(null,(current.getDirection().equals(RoverConstants.NORTH) && current.getY() == max.getY())) ;
	}

}
