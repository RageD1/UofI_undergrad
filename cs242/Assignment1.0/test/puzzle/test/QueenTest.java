/**
 * @author Dennis J. McWherter, Jr.
 * @version 1.0
 */
package puzzle.test;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzle.Board;
import puzzle.Queen;

/**
 * Tests the Queen class
 * @author Dennis J. McWherter, Jr.
 * 
 */
public class QueenTest {
	
	/**
	 * Test valid constructor 1
	 */
	@Test
	public void testValidConstructor1() {
		Board b = new Board(10);
		Queen q = new Queen();
		
		b.placePiece(1, 5, q);
		
		assertEquals(1, q.getX());
		assertEquals(5, q.getY());
	}

	/**
	 * Test method for {@link puzzle.Queen#canAttack(int, int)}.
	 */
	@Test
	public void testCanAttack() {
		Board b = new Board(5);
		Queen q = new Queen();
		
		b.placePiece(2, 2, q);
		
		assertFalse(q.canAttack(1, 0));
		assertTrue(q.canAttack(3, 1));
		assertTrue(q.canAttack(1, 1));
		assertTrue(q.canAttack(2, 0));
		assertTrue(q.canAttack(0, 2));
	}
	
	/**
	 * Test bad things for can attack
	 */
	@Test
	public void testCanAttackBad() {
		Board b = new Board(5);
		Queen q = new Queen();
		
		assertFalse(q.canAttack(0, 1));
		
		b.placePiece(0, 0, q);
		
		assertFalse(q.canAttack(-1, 0));
		assertFalse(q.canAttack(10, 0));
		assertFalse(q.canAttack(0, 10));
		assertFalse(q.canAttack(0, 0));
	}

}