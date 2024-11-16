package org.reporting.hierarchy.management;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;
import org.reporting.hierarchy.parser.DataParser;

public class ReportingHierarchyManagementTest {

	ReportingHierarchyManagement underTest = new ReportingHierarchyManagement();

	@Test
	public void reportingLineTest() throws NullPointerException, IOException {
		DataParser parser = new DataParser();
		parser.parser("reporting.csv");
		Map<Integer, Integer> map = underTest.reportingLine(parser.getEmployeeManagerMap(), parser.getEmployeeMap());
		assertTrue(map.getOrDefault(305, 0) == 2);
		assertTrue(map.getOrDefault(505, 0) == 0);
	}

	@Test
	public void earningOfDirectSubordinatesTest() throws NullPointerException, IOException {
		DataParser parser = new DataParser();
		parser.parser("reporting.csv");
		Map<Integer, Integer> map = underTest.earningOfDirectSubordinates(parser.getManagerEmployeeMap(),
				parser.getEmployeeMap());
		assertTrue(map.getOrDefault(124, 0) == -15000);
		assertTrue(map.getOrDefault(505, 0) == 0);
	}

}
