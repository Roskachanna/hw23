package service;

import com.roskachanna.web.exception.EmployeeAlreadyAddedException;
import com.roskachanna.web.model.Employee;
import com.roskachanna.web.service.EmployeeService;
import com.roskachanna.web.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Map;

public class EmployeeServiceImplTest {
    private final EmployeeService employeeService = new EmployeeServiceImpl();
    @Test
    private void shouldThrowExceptionWhenEmployeeIsAlreadyPresentedInRepository(){
        // given
        Employee employee = new Employee("Ivan","Petrov", 100_000, 1);
        employeeService.addEmployee (employee.getFirstName(), employee.getLastName(), employee.getDepartment());
        // when
        //then
        Assertions.assertThrows(
                EmployeeAlreadyAddedException.class,
                ()-> employeeService.addEmployee (employee.getFirstName(), employee.getLastName(), employee.getDepartment())
        );
    }
    @Test
    public void shouldReturnCorrectEmployee(){
        // given
        Employee employee = new Employee("Ivan","Petrov", 100_000, 1);
        //when
        Employee addedEmployee = employeeService.addEmployee (employee.getFirstName(), employee.getLastName(), employee.getDepartment());
        //then
        Assertions.assertEquals(employee, addedEmployee);
    }
    @Test
    public void shouldReturnCorrectEmployees() {
        //given
        Employee employee1 = new Employee("Ivan","Petrov", 100_000, 1);
        Employee employee2 = new Employee("Stepan","Sidorov", 120_000, 3);
        Employee employee3 = new Employee("Ivan","Ivanov", 150_000, 2 );
        employeeService.addEmployee(employee1.getFirstName(), employee1.getLastName(), employee1.getDepartment());
        employeeService.addEmployee(employee2.getFirstName(), employee2.getLastName(), employee2.getDepartment());
        employeeService.addEmployee(employee3.getFirstName(), employee3.getLastName(), employee3.getDepartment());
        //when
        Collection<Employee> allEmployees = employeeService.getAllEmployees();
        //then
        Assertions.assertTrue(allEmployees.contains(employee1.getFirstName() + employee1.getLastName()));
        Assertions.assertTrue(allEmployees.contains(employee2.getFirstName() + employee2.getLastName()));
        Assertions.assertTrue(allEmployees.contains(employee3.getFirstName() + employee3.getLastName()));
    }

}
