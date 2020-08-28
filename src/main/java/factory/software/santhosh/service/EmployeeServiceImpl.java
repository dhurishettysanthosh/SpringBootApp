package factory.software.santhosh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import factory.software.santhosh.Exception.EmployeeNotFoundException;
import factory.software.santhosh.dao.EmployeeRepository;
import factory.software.santhosh.model.Employee;

@Service

public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Integer id, Employee employee) {
		
		Employee employee1= employeeRepository.findById(id)
				.orElseThrow(()-> new EmployeeNotFoundException("Employee not found with this"+id));
		employee1.setAge(employee.getAge());
		employee1.setDesignation(employee.getDesignation());
		employee1.setName(employee.getName());
		employee1.setQualification(employee.getQualification());
		return  employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeRepository.findAll();
	}

	@Override
	public void deleteEmployee(Integer id) {
		Employee emp= employeeRepository.findById(id)
				.orElseThrow(()-> new EmployeeNotFoundException("Employee not found with this"+id));
		employeeRepository.delete(emp);
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		Employee emp= employeeRepository.findById(id)
				.orElseThrow(()-> new EmployeeNotFoundException("Employee not found with this"+id));
	return emp;
	}

}
