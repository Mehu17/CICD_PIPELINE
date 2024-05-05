package employee.service;

import employee.entity.Employee;
import employee.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	public List<Employee> getAllEmployeesByDepartmentId(Long id) {
		return repo.findByDepartmentId(id);
	}

	public Employee getEmployeeById(Long id) {
		return repo.findById(id).orElse(null);
	}

	public Employee addEmployee(Employee employee) {
		return repo.save(employee);
	}

	public Employee updateEmployee(Long id, Employee employee) {
		if (repo.findById(id).isPresent()) {
			employee.setId(id);
			return repo.save(employee);
		}
		return repo.save(employee);
	}

	public boolean deleteEmployee(Long id) {
		if (repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}
}
