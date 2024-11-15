package org.reporting.hierarchy.management;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.reporting.hierarchy.employee.Employee;

public class ReportingHierarchyManagement {
	
	public void reportingLine(final Map<Integer,Integer> employeeManagerMap, final Map<Integer,Employee> employeeMap) {
		
		for(Map.Entry<Integer, Integer> m : employeeManagerMap.entrySet()) {
			Employee emp = employeeMap.get(m.getKey());
			int managerId = m.getValue();
			int reporlineLine = 0;
			while(managerId!=0) {
				managerId = employeeManagerMap.get(managerId);
				reporlineLine++;
			}
			String tooLongReportingLine = reporlineLine - 4 > 0 ? " which is too long by " + (reporlineLine - 4): reporlineLine==0 ? " is CEO" : " have reporting Line : " + (reporlineLine-1);
			System.out.println(emp.getFirstName()+" "+ emp.getLastName() + tooLongReportingLine);
		}	
	}
	
	public void earningOfDirectSubordinates(final Map<Integer,List<Integer>> managerEmployeeMap, Map<Integer,Employee> employeeMap) {
		for(Map.Entry<Integer, List<Integer>> m : managerEmployeeMap.entrySet()) {
			if(m.getKey()!=0) {
			Employee manager = employeeMap.get(m.getKey());
			List<Integer> directSuborinates = m.getValue();
			int salM = manager.getSalary();
			double salDirectSuborinates = directSuborinates.stream().map(id -> employeeMap.get(id).getSalary()).collect(Collectors.averagingInt(Integer::intValue));
			int maxManagerSalaryRange = (int) (salDirectSuborinates*1.5);
			int minManagerSalaryRange = (int) (salDirectSuborinates*1.2);
			String salaryRange = "";
			if(salM > maxManagerSalaryRange) {
				salaryRange = ", earning more than he/she should by " + (salM - maxManagerSalaryRange);
			}else if (salM < minManagerSalaryRange) {
				salaryRange = ", earning less than he/she should by " + (minManagerSalaryRange -salM);
			}else {
				salaryRange = ", earning at least 20% more than the average salary of its direct subordinates, but no more than 50% more than that average.";
			}
			System.out.println(manager.getFirstName()+" "+ manager.getLastName() + "have salary " + salM + salaryRange);

		}
		}
	}

}
