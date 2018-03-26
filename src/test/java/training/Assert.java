package training;

import org.junit.Test;
import static org.junit.Assert.*;

public class Assert {

	public boolean userExists(int id) {
		if (id == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Test
	public void testAssertBoolean() {
		assertTrue(userExists(1));
		assertFalse(userExists(0));
		// assertTrue("User doesn't exists", userExists(0));
	}

	public String getName(int id) {
		if (id == 1) {
			return "Amol";
		} else {
			return null;
		}
	}

	@Test
	public void testAsserts() {
		assertEquals((2 + 3), 5);

		assertNull(getName(0));
		assertNotNull(getName(1));

		assertEquals(getName(1), "Amol");
		// assertEquals(getName(1), "amol");
		// assertEquals("failuer – string not equal", getName(1), "amol");
	}
}
