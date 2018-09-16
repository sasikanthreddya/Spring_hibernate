package com.bmo.alerts.bs.dao;

import java.util.List;

import com.bmo.alerts.bs.model.Employee;

public interface EmployeeDao {
	public void addEmployee(Employee e);
	public void updateEmployee(Employee e);
	public List<Employee> listEmployees();
	public Employee getEMployeeById(int id);
	public void removeEmployee(int id);
	public List<Employee> listEmployes(int firstResult, int maxResults);
	public void addAllEmployees();
}
