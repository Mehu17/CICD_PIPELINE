package employee.service;

import employee.entity.Employee;
import employee.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTests {

    @Mock
    private EmployeeRepository repo;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1L, "Sachin Tendulkar", "CRICKET",3L));
        employees.add(new Employee(2L, "Christiano Ronaldo", "FOOTBALL",4L));

        when(repo.findAll()).thenReturn(employees);

        List<Employee> result = employeeService.getAllEmployees();

        assertEquals(2, result.size());
        assertEquals("Sachin Tendulkar", result.get(0).getName());
        assertEquals("Christiano Ronaldo", result.get(1).getName());

        verify(repo, times(1)).findAll();
    }
}
