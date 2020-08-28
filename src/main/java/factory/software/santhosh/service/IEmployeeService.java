package factory.software.santhosh.service;

import java.util.List;

import factory.software.santhosh.model.Employee;

public interface IEmployeeService {

	public Employee saveEmployee(Employee employee);
	public Employee updateEmployee(Integer id,Employee employee);
	public List<Employee> getAllEmployee();
	public void deleteEmployee(Integer id);
	public Employee getEmployeeById(Integer id);

}
