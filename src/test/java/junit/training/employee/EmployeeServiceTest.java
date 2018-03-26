package junit.training.employee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class EmployeeServiceTest {

	EmployeeService employeeService = new EmployeeService();

	@Test
	public void testNameFound() {
		String name = employeeService.findNameById(1);

		assertNotNull(name);
		assertEquals(name, "Amol");
	}

	@Test
	public void testNameNotFoundException() {
		String name = employeeService.findNameById(3);

		assertNull(name);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgumentException() {
		employeeService.findNameById(null);
	}

	@Test
	public void testIllegalArgumentException_old() {
		try {
			employeeService.findNameById(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Employee Id is required");
		}
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testIllegalArgumentException_new() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Employee Id is required");

		employeeService.findNameById(null);
	}

	@Ignore
	@Test
	public void testFloatingPointAssertions() {
		double expectedTaxAmout = 10.005;
		double actualTaxAmout = 10.004;
		// assertEquals(10.004, 10.005);
		assertEquals(expectedTaxAmout, actualTaxAmout, 0.002);
	}
}
