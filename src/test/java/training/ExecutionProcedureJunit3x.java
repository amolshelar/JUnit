package training;

import junit.framework.TestCase;

public class ExecutionProcedureJunit3x extends TestCase {

	public void setUp() {
		System.out.println("SetUp - in before");
	}

	public void tearDown() {
		System.out.println("TearDown - in after");
	}

	public void testCase() {
		System.out.println("TestCase - in test case 1");
	}

	public void anotherTestCase() {
		System.out.println("TestCse - in test case 2");
	}
}