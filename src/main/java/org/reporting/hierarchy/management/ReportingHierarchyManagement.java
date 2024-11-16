package org.reporting.hierarchy.management;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.reporting.hierarchy.employee.Employee;

public class ReportingHierarchyManagement {

	public Map<Integer, Integer> reportingLine(final Map<Integer, Integer> employeeManagerMap,
			final Map<Integer, Employee> employeeMap) {
		Map<Integer, Integer> reportingLineMap = new HashMap<>();

		for (Map.Entry<Integer, Integer> m : employeeManagerMap.entrySet()) {
			Employee emp = employeeMap.get(m.getKey());
			int managerId = m.getValue();
			int reporlineLine = 0;
			while (managerId != 0) {
				managerId = employeeManagerMap.get(managerId);
				reporlineLine++;
			}
			reportingLineMap.put(m.getKey(), reporlineLine == 0 ? 0 : reporlineLine - 1);
			String tooLongReportingLine = reporlineLine - 4 - 1 > 0 ? " which is too long by " + (reporlineLine - 4 - 1)
					: reporlineLine == 0 ? " is CEO" : " have reporting Line : " + (reporlineLine - 1);
			System.out.println(emp.getFirstName() + " " + emp.getLastName() + tooLongReportingLine);
		}
		return reportingLineMap;
	}

	public Map<Integer, Integer> earningOfDirectSubordinates(final Map<Integer, List<Integer>> managerEmployeeMap,
			final Map<Integer, Employee> employeeMap) {
		Map<Integer, Integer> differnceEarningOfDirectSubordinatesMap = new HashMap<>();

		for (Map.Entry<Integer, List<Integer>> m : managerEmployeeMap.entrySet()) {
			if (m.getKey() != 0) {
				List<Integer> directSuborinates = m.getValue();
				double salDirectSuborinates = directSuborinates.stream().map(id -> employeeMap.get(id).getSalary())
						.collect(Collectors.averagingInt(Integer::intValue));

				int maxManagerSalaryRange = (int) (salDirectSuborinates * 1.5);
				int minManagerSalaryRange = (int) (salDirectSuborinates * 1.2);

				String salaryRange = "";
				Employee manager = employeeMap.get(m.getKey());
				int salM = manager.getSalary();
				int salaryDiff = Integer.MIN_VALUE;
				if (salM > maxManagerSalaryRange) {
					salaryDiff = salM - maxManagerSalaryRange;
					salaryRange = ", earning more than he/she should by " + salaryDiff;
					differnceEarningOfDirectSubordinatesMap.put(m.getKey(), salaryDiff);
				} else if (salM < minManagerSalaryRange) {
					salaryDiff = minManagerSalaryRange - salM;
					salaryRange = ", earning less than he/she should by " + salaryDiff;
					differnceEarningOfDirectSubordinatesMap.put(m.getKey(), salaryDiff * -1);
				} else {
					salaryRange = ", earning at least 20% more than the average salary of its direct subordinates, but no more than 50% more than that average.";
					differnceEarningOfDirectSubordinatesMap.put(m.getKey(), 0);
				}
				System.out.println(
						manager.getFirstName() + " " + manager.getLastName() + " have salary " + salM + salaryRange);
			}
		}
		return differnceEarningOfDirectSubordinatesMap;
	}

}
