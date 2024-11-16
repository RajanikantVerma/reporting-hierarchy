package org.reporting.hierarchy;

import java.io.IOException;

import org.junit.Test;

public class ReportingHierarchyTest {

	@Test(expected = NullPointerException.class)
	public void parseTest() throws IOException {
		ReportingHierarchy reportingHierarchy = new ReportingHierarchy();
		reportingHierarchy.parse("test.csv");
	}

}
