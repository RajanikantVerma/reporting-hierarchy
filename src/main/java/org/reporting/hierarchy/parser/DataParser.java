package org.reporting.hierarchy.parser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.reporting.hierarchy.employee.Employee;

import com.opencsv.CSVReader;

public class DataParser {

	private Map<Integer, Employee> employeeMap = new HashMap<>();
	private Map<Integer, List<Integer>> managerEmployeeMap = new HashMap<>();
	private Map<Integer, Integer> employeeManagerMap = new HashMap<>();

	public Map<Integer, Employee> getEmployeeMap() {
		return employeeMap;
	}

	public Map<Integer, List<Integer>> getManagerEmployeeMap() {
		return managerEmployeeMap;
	}

	public Map<Integer, Integer> getEmployeeManagerMap() {
		return employeeManagerMap;
	}

	public void parser(String fileName) throws IOException {

		String filePath = Objects.requireNonNull(getClass().getClassLoader().getResource(fileName)).getPath();
		FileReader filereader = new FileReader(filePath);
		try (CSVReader csvReader = new CSVReader(filereader)) {
			String[] nextRecord = csvReader.readNext();
			while ((nextRecord = csvReader.readNext()) != null) {
				Employee emp = new Employee();
				emp.setId(Integer.valueOf(nextRecord[0]));
				emp.setFirstName(nextRecord[1]);
				emp.setLastName(nextRecord[2]);
				emp.setSalary(Integer.valueOf(nextRecord[3]));
				emp.setManagerId(nextRecord[4].equalsIgnoreCase("") ? 0 : Integer.valueOf(nextRecord[4]));
				employeeMap.put(emp.getId(), emp);
				List<Integer> list = managerEmployeeMap.getOrDefault(emp.getManagerId(), new ArrayList<>());
				list.add(emp.getId());
				managerEmployeeMap.put(emp.getManagerId(), list);
				employeeManagerMap.put(emp.getId(), emp.getManagerId());
			}
		}
	}
}
