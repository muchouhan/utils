package com.muchouhan.emailutil.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.muchouhan.emailutil.FileManager;

/**
 * Unit test for simple App.
 */
public class EmailUtilityTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public EmailUtilityTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(EmailUtilityTest.class);
	}

	public void testActiveRecipient() {

		String recipients = FileManager.getInstance().getActiveRecipient();
		assertEquals("mukundchouhan220@gmail.com;", recipients);
	}

}
