package employee.controller;

import employee.entity.Employee;
import employee.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private Controller controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1L, "Jhony Dip", "CSE",1L));
        employees.add(new Employee(2L, "Mark Willam", "ECE",1L));

        when(employeeService.getAllEmployees()).thenReturn(employees);

        List<Employee> result = controller.getAllEmployees();

        assertEquals(2, result.size());
        assertEquals("Jhony Dip", result.get(0).getName());
        assertEquals("Mark Willam", result.get(1).getName());

        verify(employeeService, times(1)).getAllEmployees();
    }
}
