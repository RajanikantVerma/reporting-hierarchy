package org.reporting.hierarchy;

import java.io.IOException;
import java.util.Scanner;

import org.reporting.hierarchy.management.ReportingHierarchyManagement;
import org.reporting.hierarchy.parser.DataParser;

public class ReportingHierarchyMain {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello and welcome!");
		try (Scanner sc = new Scanner(System.in)) {
			ReportingHierarchyMain main = new ReportingHierarchyMain();
			main.parse(sc.next());
		}

	}

	public void parse(String fileName) throws IOException {
		DataParser parser = new DataParser();
		parser.parser(fileName);
		ReportingHierarchyManagement rhm = new ReportingHierarchyManagement();
		rhm.reportingLine(parser.getEmployeeManagerMap(), parser.getEmployeeMap());
		rhm.earningOfDirectSubordinates(parser.getManagerEmployeeMap(), parser.getEmployeeMap());
	}
}