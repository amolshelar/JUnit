package training;

import org.junit.Test;
import static org.junit.Assert.*;

public class MyTestCase {

	public boolean isEventNumber(int num) {
		if (num % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Test
	public void testCase1() {
		assertTrue(isEventNumber(10));
	}

	@Test
	public void testCase2() {
		assertFalse(isEventNumber(11));
	}

	@Test
	public void testCase3() {
		assertFalse(isEventNumber(12));
	}

}
