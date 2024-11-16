package org.reporting.hierarchy.parser;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.reporting.hierarchy.employee.Employee;

public class DataParserTest {

	@Test
	public void testDataParser() throws IOException {
		DataParser parser = new DataParser();
		parser.parser("reporting.csv");
		assertEquals(parser.getEmployeeMap().size(), 5);
		Employee emp = new Employee(124, "Martin", "Chekov", 45000, 123);
		assertEquals(parser.getEmployeeMap().get(124), emp);
	}

	@Test(expected = NullPointerException.class)
	public void testDataParserNullPointerException() throws IOException {
		DataParser parser = new DataParser();
		parser.parser("io.csv");
	}
}
