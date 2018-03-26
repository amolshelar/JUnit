package training;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class ExecutionProcedureJunit4x {

	// execute only once, in the starting e.g. Database connection, connection pool
	@BeforeClass
	public static void beforeClass() {
		System.out.println("@BeforeClass - in before class");
	}

	// execute only once, in the end e.g close connection, cleanup
	@AfterClass
	public static void afterClass() {
		System.out.println("\n@AfterClass - in after class");
	}

	// execute for each test, before executing test e.g. Creating an similar object and share for all @Test
	@Before
	public void before() {
		System.out.println("\n@Before - in before");
	}

	// execute for each test, after executing test
	@After
	public void after() {
		System.out.println("@After - in after");
	}

	// test case 1
	@Test
	public void testCase1() {
		System.out.println("@Test - in test case 1");
	}

	// test case 2
	@Test
	public void myTestCase2() {
		System.out.println("@Test - in test case 2");
	}

	// test case 3 (Ignored)
	@Ignore
	@Test
	public void myTestCase3() {
		System.out.println("@Test - in test case 3");
	}
}