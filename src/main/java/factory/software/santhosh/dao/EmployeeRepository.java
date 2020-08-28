package factory.software.santhosh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import factory.software.santhosh.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
