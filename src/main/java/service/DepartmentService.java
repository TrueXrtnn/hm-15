package service;

import com.example.hm15.Employee;
import exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee maxSalary(int departmentId) {

        return employeeService.getEmployees()
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .max(Comparator.comparingInt(e -> e.getSalary()))
                .orElse(null);
    }

    public Employee minSalary(int departmentId) {

        return employeeService.getEmployees()
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .orElse(null);
    }

    public int sumSalary(int departmentId) {

        return employeeService
                .getEmployees()
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public Collection<Employee> allDepartment(int departmentId) {
        return employeeService.getEmployees()
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> allDepartment() {
        return employeeService.getEmployees()
                .stream()
                .collect(groupingBy(Employee::getDepartment));
    }
}
